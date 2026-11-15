package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity.LineSplitter;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity.TextLines;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextDisplayEntity.class)
public abstract class TextDisplayCache {
   @Shadow
   private TextLines textLines;
   @Unique
   private int b;

   @Inject(method = "method_48905(Lnet/minecraft/class_8113$class_8123$class_8127;)Lnet/minecraft/class_8113$class_8123$class_8125;", at = @At("HEAD"))
   private void a(LineSplitter var1, CallbackInfoReturnable<TextLines> var2) {
      int var3 = ProfileTextCache.GEN;
      if (this.b != var3) {
         this.b = var3;
         this.textLines = null;
      }
   }
}
