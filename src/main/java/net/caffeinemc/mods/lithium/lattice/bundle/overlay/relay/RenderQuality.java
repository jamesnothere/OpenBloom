package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.attribute.EnvironmentAttributeInterpolator;
import net.minecraft.world.attribute.EnvironmentAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnvironmentAttributeInterpolator.class)
public class RenderQuality {
   @Inject(method = "method_75689(Lnet/minecraft/class_12197;F)Ljava/lang/Object;", at = @At("RETURN"), cancellable = true, require = 0)
   private void a(EnvironmentAttribute<?> var1, float var2, CallbackInfoReturnable<Object> var3) {
      boolean var4 = LerpZoneBuffer.ae;
      boolean var5 = NodeZoneRenderer.SKY_HOT;
      boolean var6 = NodeZoneRenderer.FOG_HOT;
      if (var4 || var5 || var6) {
         try {
            Object var7 = var3.getReturnValue();
            Object var8 = var4 ? LerpZoneBuffer.r(var1, var7) : null;
            Object var9 = (
                     !var5
                        || var1 != EnvironmentAttributes.SKY_COLOR_VISUAL
                           && var1 != EnvironmentAttributes.STAR_BRIGHTNESS_VISUAL
                           && var1 != EnvironmentAttributes.CLOUD_COLOR_VISUAL
                  )
                  && (!var6 || var1 != EnvironmentAttributes.FOG_START_DISTANCE_VISUAL && var1 != EnvironmentAttributes.FOG_END_DISTANCE_VISUAL)
               ? null
               : NodeZoneRenderer.dj(var1, var7, var8);
            Object var10 = var9 != null ? var9 : var8;
            if (var10 != null) {
               var3.setReturnValue(var10);
            }
         } catch (Throwable var11) {
         }
      }
   }
}
