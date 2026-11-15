package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.CoreCacheKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.NodeCacheGroup;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.component.type.PiercingWeaponComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class InteractionProbe {
   @Inject(method = "method_2918(Lnet/minecraft/class_1657;Lnet/minecraft/class_1297;)V", at = @At("HEAD"), require = 0)
   private void a(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      NodeZoneRenderer var4 = null;

      try {
         FrameClockCache.l = var1.age;
         if (ConfigBridge.c == null || !ConfigBridge.c.a() || ConfigBridge.c.c99() == null) {
            return;
         }

         LockD.f = System.nanoTime();
         if (NodeCacheGroup.RUN && var2 instanceof LivingEntity) {
            NodeCacheGroup.HIT_ID = var2.getId();
            NodeCacheGroup.HIT_NS = System.nanoTime();
         }

         if (NodeZoneRenderer.ON) {
            var4 = ConfigBridge.c.c99().a(NodeZoneRenderer.class);
            if (var4 != null && var4.f()) {
               var4.bn(var2);
            }
         }
      } catch (Throwable var6) {
      }
   }

   @Inject(
      method = "method_2896(Lnet/minecraft/class_746;Lnet/minecraft/class_1268;Lnet/minecraft/class_3965;)Lnet/minecraft/class_1269;",
      at = @At("HEAD"),
      require = 0
   )
   private void b(ClientPlayerEntity var1, Hand var2, BlockHitResult var3, CallbackInfoReturnable<ActionResult> var4) {
      try {
         FrameClockCache.l = var1.age;
      } catch (Throwable var6) {
      }
   }

   @Inject(method = "method_2919(Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1269;", at = @At("HEAD"), require = 0)
   private void c(PlayerEntity var1, Hand var2, CallbackInfoReturnable<ActionResult> var3) {
      try {
         FrameClockCache.l = var1.age;
      } catch (Throwable var5) {
      }
   }

   @Inject(
      method = "method_2905(Lnet/minecraft/class_1657;Lnet/minecraft/class_1297;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1269;",
      at = @At("HEAD"),
      require = 0
   )
   private void d(PlayerEntity var1, Entity var2, Hand var3, CallbackInfoReturnable<ActionResult> var4) {
      try {
         FrameClockCache.l = var1.age;
      } catch (Throwable var6) {
      }
   }

   @Inject(
      method = "method_2917(Lnet/minecraft/class_1657;Lnet/minecraft/class_1297;Lnet/minecraft/class_3966;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1269;",
      at = @At("HEAD"),
      require = 0
   )
   private void e(PlayerEntity var1, Entity var2, EntityHitResult var3, Hand var4, CallbackInfoReturnable<ActionResult> var5) {
      try {
         FrameClockCache.l = var1.age;
      } catch (Throwable var7) {
      }
   }

   @Inject(method = "method_2910(Lnet/minecraft/class_2338;Lnet/minecraft/class_2350;)Z", at = @At("HEAD"), require = 0)
   private void f(BlockPos var1, Direction var2, CallbackInfoReturnable<Boolean> var3) {
      MinecraftClient var4 = MinecraftClient.getInstance();

      try {
         if (var4 != null && var4.player != null) {
            FrameClockCache.l = var4.player.age;
         }
      } catch (Throwable var6) {
      }
   }

   @Inject(method = "method_75407(Lnet/minecraft/class_12125;)V", at = @At("HEAD"), require = 0)
   private void g(PiercingWeaponComponent var1, CallbackInfo var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();

      try {
         if (var3 != null && var3.player != null) {
            FrameClockCache.l = var3.player.age;
         }
      } catch (Throwable var5) {
      }
   }

   @Inject(method = "method_2918(Lnet/minecraft/class_1657;Lnet/minecraft/class_1297;)V", at = @At("RETURN"), require = 0)
   private void h(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      CoreCacheKeeper var4 = null;

      try {
         if (ConfigBridge.c == null || !CoreCacheKeeper.ON || !ConfigBridge.c.a() || ConfigBridge.c.c99() == null) {
            return;
         }

         var4 = ConfigBridge.c.c99().a(CoreCacheKeeper.class);
         if (var4 != null && var4.f()) {
            CoreCacheKeeper.d(var2);
         }
      } catch (Throwable var6) {
      }
   }
}
