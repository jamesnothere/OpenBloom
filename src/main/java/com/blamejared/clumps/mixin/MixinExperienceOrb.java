package com.blamejared.clumps.mixin;

import com.blamejared.clumps.ClumpsCommon;
import com.blamejared.clumps.api.events.IRepairEvent;
import com.blamejared.clumps.api.events.IValueEvent;
import com.blamejared.clumps.helper.IClumpedOrb;
import com.blamejared.clumps.platform.Services;
import com.mojang.datafixers.util.Either;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ExperienceOrbEntity.class, priority = 1001)
public abstract class MixinExperienceOrb extends Entity implements IClumpedOrb {
   @Shadow
   private int pickingCount;
   @Shadow
   private int orbAge;
   @Unique
   public Map<Integer, Integer> clumps$clumpedMap;
   @Unique
   public Optional<EnchantmentEffectContext> clumps$currentEntry;

   @Shadow
   protected abstract int repairPlayerGears(ServerPlayerEntity var1, int var2);

   @Shadow
   private static boolean isMergeable(ExperienceOrbEntity experienceOrb, int id, int value) {
      return false;
   }

   @Shadow
   public abstract int getValue();

   @Shadow
   protected abstract void setValue(int var1);

   public MixinExperienceOrb(EntityType<?> entityType, World level) {
      super(entityType, level);
   }

   @Inject(method = "method_31494(Lnet/minecraft/class_1303;)Z", at = @At("HEAD"), cancellable = true)
   private void canMerge(ExperienceOrbEntity experienceOrb, CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(experienceOrb.isAlive() && !this.isPartOf(experienceOrb));
   }

   @Inject(method = "method_31495(Lnet/minecraft/class_1303;II)Z", at = @At("HEAD"), cancellable = true)
   private static void canMerge(ExperienceOrbEntity experienceOrb, int i, int j, CallbackInfoReturnable<Boolean> cir) {
      cir.setReturnValue(experienceOrb.isAlive());
   }

   @Inject(method = "method_5694(Lnet/minecraft/class_1657;)V", at = @At("HEAD"), cancellable = true)
   public void playerTouch(PlayerEntity rawPlayer, CallbackInfo ci) {
      if (rawPlayer instanceof ServerPlayerEntity player) {
         if (ClumpsCommon.pickupXPEvent.test(player, (ExperienceOrbEntity)(Object)this)) {
            return;
         }

         player.experiencePickUpDelay = 0;
         player.sendPickup(this, 1);
         if (this.getValue() != 0 || this.clumps$resolve()) {
            AtomicInteger toGive = new AtomicInteger();
            this.clumps$getClumpedMap().forEach((value, amount) -> {
               Either<IValueEvent, Integer> result = Services.EVENT.fireValueEvent(player, value);
               int actualValue = (Integer)result.map(IValueEvent::getValue, UnaryOperator.identity());

               for (int i = 0; i < amount; i++) {
                  int leftOver = (Integer)Services.EVENT.fireRepairEvent(player, actualValue).map(IRepairEvent::getValue, UnaryOperator.identity());
                  if (leftOver == actualValue) {
                     leftOver = this.repairPlayerGears(player, actualValue);
                  }

                  if (leftOver > 0) {
                     toGive.addAndGet(leftOver);
                  }
               }
            });
            if (toGive.get() > 0) {
               player.addExperience(toGive.get());
            }
         }

         this.discard();
         ci.cancel();
      }
   }

   @ModifyVariable(
      index = 3,
      method = "method_35051(Lnet/minecraft/class_3222;I)I",
      at = @At(
         value = "INVOKE_ASSIGN",
         target = "Lnet/minecraft/class_1890;method_8204(Lnet/minecraft/class_9331;Lnet/minecraft/class_1309;Ljava/util/function/Predicate;)Ljava/util/Optional;"
      )
   )
   public Optional<EnchantmentEffectContext> clumps$captureCurrentEntry(Optional<EnchantmentEffectContext> entry) {
      this.clumps$currentEntry = entry;
      return entry;
   }

   @Inject(
      method = "method_35051(Lnet/minecraft/class_3222;I)I",
      cancellable = true,
      at = @At(
         value = "INVOKE_ASSIGN",
         target = "Lnet/minecraft/class_1890;method_8204(Lnet/minecraft/class_9331;Lnet/minecraft/class_1309;Ljava/util/function/Predicate;)Ljava/util/Optional;"
      )
   )
   public void clumps$repairPlayerItems(ServerPlayerEntity player, int actualValue, CallbackInfoReturnable<Integer> cir) {
      cir.setReturnValue(
         this.clumps$currentEntry
            .<Integer>map(
               foundItem -> {
                  ItemStack itemstack = foundItem.stack();
                  int xpToRepair = EnchantmentHelper.getRepairWithExperience(
                     player.getEntityWorld(), itemstack, (int)(actualValue * Services.PLATFORM.getRepairRatio(itemstack))
                  );
                  int toRepair = Math.min(xpToRepair, itemstack.getDamage());
                  itemstack.setDamage(itemstack.getDamage() - toRepair);
                  if (toRepair > 0) {
                     int used = actualValue - toRepair * actualValue / xpToRepair;
                     if (used > 0) {
                        return this.repairPlayerGears(player, used);
                     }
                  }

                  return 0;
               }
            )
            .orElse(actualValue)
      );
   }

   @Inject(
      method = "method_31497(Lnet/minecraft/class_1303;)V",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/class_1303;method_31472()V", shift = Shift.BEFORE),
      cancellable = true
   )
   public void merge(ExperienceOrbEntity secondaryOrb, CallbackInfo ci) {
      Map<Integer, Integer> otherMap = ((IClumpedOrb)secondaryOrb).clumps$getClumpedMap();
      this.pickingCount = this.clumps$getClumpedMap().values().stream().reduce(Integer::sum).orElse(1);
      this.orbAge = Math.min(this.orbAge, ((ExperienceOrbAccess)secondaryOrb).clumps$getAge());
      this.clumps$setClumpedMap(
         Stream.of(this.clumps$getClumpedMap(), otherMap)
            .flatMap(map -> map.entrySet().stream())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum))
      );
      secondaryOrb.discard();
      ci.cancel();
   }

   @Inject(method = "method_31496(Lnet/minecraft/class_3218;Lnet/minecraft/class_243;I)Z", at = @At("HEAD"), cancellable = true)
   private static void tryMergeToExisting(ServerWorld serverLevel, Vec3d vec3, int value, CallbackInfoReturnable<Boolean> cir) {
      Box aABB = Box.of(vec3, 1.0, 1.0, 1.0);
      int id = serverLevel.getRandom().nextInt(40);
      List<ExperienceOrbEntity> list = serverLevel.getEntitiesByType(
         TypeFilter.instanceOf(ExperienceOrbEntity.class), aABB, experienceOrbx -> isMergeable(experienceOrbx, id, value)
      );
      if (!list.isEmpty()) {
         ExperienceOrbEntity experienceOrb = list.getFirst();
         Map<Integer, Integer> clumpedMap = ((IClumpedOrb)experienceOrb).clumps$getClumpedMap();
         ((IClumpedOrb)experienceOrb)
            .clumps$setClumpedMap(
               Stream.of(clumpedMap, Collections.singletonMap(value, 1))
                  .flatMap(map -> map.entrySet().stream())
                  .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum))
            );
         ((ExperienceOrbAccess)experienceOrb).clumps$setCount(clumpedMap.values().stream().reduce(Integer::sum).orElse(1));
         ((ExperienceOrbAccess)experienceOrb).clumps$setAge(0);
         cir.setReturnValue(true);
      } else {
         cir.setReturnValue(false);
      }
   }

   @Inject(method = "method_5652(Lnet/minecraft/class_11372;)V", at = @At("TAIL"))
   public void addAdditionalSaveData(WriteView valueOutput, CallbackInfo ci) {
      if (this.clumps$clumpedMap != null) {
         NbtCompound map = new NbtCompound();
         this.clumps$getClumpedMap().forEach((value, count) -> map.putInt(String.valueOf(value), count));
         valueOutput.put("clumpedMap", NbtCompound.CODEC, map);
      }
   }

   @Inject(method = "method_5749(Lnet/minecraft/class_11368;)V", at = @At("TAIL"))
   public void readAdditionalSaveData(ReadView valueInput, CallbackInfo ci) {
      Map<Integer, Integer> map = new HashMap<>();
      valueInput.read("clumpedMap", NbtCompound.CODEC).ifPresentOrElse(clumpedMap -> {
         for (String s : clumpedMap.getKeys()) {
            clumpedMap.getInt(s).ifPresent(value -> map.put(Integer.parseInt(s), value));
         }
      }, () -> map.put(this.getValue(), this.pickingCount));
      this.clumps$setClumpedMap(map);
   }

   @Override
   public Map<Integer, Integer> clumps$getClumpedMap() {
      if (this.clumps$clumpedMap == null) {
         this.clumps$clumpedMap = new HashMap<>();
         this.clumps$clumpedMap.put(this.getValue(), 1);
      }

      return this.clumps$clumpedMap;
   }

   @Override
   public void clumps$setClumpedMap(Map<Integer, Integer> map) {
      this.clumps$clumpedMap = map;
      this.clumps$resolve();
   }

   @Override
   public boolean clumps$resolve() {
      this.setValue(this.clumps$getClumpedMap().entrySet().stream().map(entry -> entry.getKey() * entry.getValue()).reduce(Integer::sum).orElse(1));
      return this.getValue() > 0;
   }
}
