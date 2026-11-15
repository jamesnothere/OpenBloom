package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MutableText.class)
public abstract class OverlayTitleCache {
   @Shadow
   private Language language;
   @Unique
   private int b;

   @Inject(method = "method_30937()Lnet/minecraft/class_5481;", at = @At("HEAD"))
   private void a(CallbackInfoReturnable<OrderedText> var1) {
      int var2 = ProfileTextCache.GEN;
      if (this.b != var2) {
         this.b = var2;
         this.language = null;
      }
   }
}
