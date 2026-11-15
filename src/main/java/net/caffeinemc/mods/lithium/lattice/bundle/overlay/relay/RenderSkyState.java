package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FieldVolumeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ShellArrayCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.minecraft.client.render.SkyRendering;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SkyRendering.class)
public class RenderSkyState {
   @ModifyVariable(method = "method_62303(FLnet/minecraft/class_4587;)V", at = @At("HEAD"), argsOnly = true, ordinal = 0, require = 0)
   private float a(float var1) {
      try {
         FieldVolumeCache.dy = true;
         FieldVolumeCache.dz = true;
         FieldVolumeCache.ea = var1;
         return LerpZoneBuffer.IDLE ? var1 : var1 * FieldVolumeCache.c();
      } catch (Throwable var3) {
         return var1;
      }
   }

   @ModifyVariable(
      method = "method_62304(Lnet/minecraft/class_12131;FLnet/minecraft/class_4587;)V",
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 0,
      require = 0
   )
   private float b(float var1) {
      try {
         if (LerpZoneBuffer.IDLE) {
            return var1;
         }

         float var2 = ShellArrayCache.ao;
         return var2 > 0.0F ? var1 * (1.0F - (var2 > 1.0F ? 1.0F : var2)) : var1;
      } catch (Throwable var3) {
         return var1;
      }
   }
}
