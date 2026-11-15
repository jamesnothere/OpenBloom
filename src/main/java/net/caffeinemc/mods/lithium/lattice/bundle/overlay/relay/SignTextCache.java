package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import java.util.function.Function;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.block.entity.SignText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignText.class)
public abstract class SignTextCache {
   @Shadow
   private OrderedText[] orderedMessages;
   @Unique
   private int b;

   @Inject(method = "method_49868(ZLjava/util/function/Function;)[Lnet/minecraft/class_5481;", at = @At("HEAD"))
   private void a(boolean var1, Function<Text, OrderedText> var2, CallbackInfoReturnable<OrderedText[]> var3) {
      int var4 = ProfileTextCache.GEN;
      if (this.b != var4) {
         this.b = var4;
         this.orderedMessages = null;
      }
   }
}
