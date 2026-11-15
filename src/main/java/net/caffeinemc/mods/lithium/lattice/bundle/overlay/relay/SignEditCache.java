package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSignEditScreen.class)
public abstract class SignEditCache {
   @Inject(method = "method_45655(Lnet/minecraft/class_332;)V", at = @At("HEAD"))
   private void a(DrawContext var1, CallbackInfo var2) {
      ProfileTextCache.EDIT = true;
   }

   @Inject(method = "method_45655(Lnet/minecraft/class_332;)V", at = @At("RETURN"))
   private void b(DrawContext var1, CallbackInfo var2) {
      ProfileTextCache.EDIT = false;
   }
}
