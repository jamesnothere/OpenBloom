package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class LightmapStateCache {
   @Shadow
   private boolean dirty;
   @Unique
   private static float c;
   @Unique
   private static float d;
   @Unique
   private static float e;
   @Unique
   private static float f;
   @Unique
   private static boolean g;
   @Unique
   private static long h;

   @Inject(method = "method_3313(F)V", at = @At("HEAD"), require = 0)
   private void a(float var1, CallbackInfo var2) {
      if (NodeZoneRenderer.FB_HOT) {
         try {
            boolean var3 = ConfigBridge.c != null && ConfigBridge.c.a();
            float var4 = var3 ? NodeZoneRenderer.FB_TA : 0.0F;
            float var5 = var3 ? NodeZoneRenderer.FB_TN : 0.0F;
            long var6 = System.nanoTime();
            float var8 = h == 0L ? 0.0F : (float)(var6 - h) / 1.0E9F;
            h = var6;
            if (var8 < 0.0F) {
               var8 = 0.0F;
            }

            if (var8 > 0.1F) {
               var8 = 0.1F;
            }

            if (!var3) {
               c = 0.0F;
               d = 0.0F;
            } else {
               float var9 = 1.0F - (float)Math.exp(-9.0 * var8);
               c = c + (var4 - c) * var9;
               if (Math.abs(var4 - c) < 0.004F) {
                  c = var4;
               }

               d = d + (var5 - d) * var9;
               if (Math.abs(var5 - d) < 0.004F) {
                  d = var5;
               }
            }

            NodeZoneRenderer.FB_AMB = c;
            NodeZoneRenderer.FB_NV = d;
            NodeZoneRenderer.FB_LIVE = var6 == 0L ? 1L : var6;
            if (!g || c != e || d != f) {
               this.dirty = true;
               e = c;
               f = d;
               g = true;
            }

            if (var4 == 0.0F && var5 == 0.0F && c == 0.0F && d == 0.0F) {
               NodeZoneRenderer.FB_HOT = false;
               h = 0L;
            }
         } catch (Throwable var10) {
         }
      }
   }

   @ModifyArg(
      method = "method_3313(F)V",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/buffers/Std140Builder;putFloat(F)Lcom/mojang/blaze3d/buffers/Std140Builder;", ordinal = 3),
      index = 0,
      require = 0
   )
   private float b(float var1) {
      float var2 = NodeZoneRenderer.FB_NV;
      return var2 > var1 ? var2 : var1;
   }
}
