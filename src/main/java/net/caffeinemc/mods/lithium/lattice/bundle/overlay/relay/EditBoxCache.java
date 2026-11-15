package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.EditBoxWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EditBoxWidget.class)
public abstract class EditBoxCache {
   @Inject(method = "method_44389(Lnet/minecraft/class_332;IIF)V", at = @At("HEAD"))
   private void a(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      ProfileTextCache.EDIT = true;
   }

   @Inject(method = "method_44389(Lnet/minecraft/class_332;IIF)V", at = @At("RETURN"))
   private void b(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      ProfileTextCache.EDIT = false;
   }
}
