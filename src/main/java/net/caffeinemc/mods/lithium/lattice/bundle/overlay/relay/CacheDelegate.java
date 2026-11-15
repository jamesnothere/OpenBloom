package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.RenderKernel;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class CacheDelegate {
   @Unique
   private static long g;
   @Unique
   private static boolean h;

   @Unique
   private static boolean a() {
      long var0 = System.nanoTime();
      if (!h || var0 - g > 2000000L || var0 - g < 0L) {
         h = ConfigBridge.c != null && ConfigBridge.c.a();
         g = var0;
      }

      return h;
   }

   @Inject(method = "method_1753(Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V", at = @At("TAIL"))
   private void b(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (ConfigBridge.c != null && a()) {
         try {
            EventAdapter.a(new RenderKernel(var1));
         } catch (Throwable var8) {
         }

         try {
            CoreZoneProcessor.l(var1);
         } catch (Throwable var7) {
         }

         if (NodeZoneRenderer.ON || NodeZoneRenderer.LINGER) {
            try {
               NodeZoneRenderer.ck(var1);
            } catch (Throwable var6) {
            }
         }

         try {
            NoticeQueue.e(var1, MinecraftClient.getInstance().getWindow().getScaledWidth());
         } catch (Throwable var5) {
         }
      }
   }

   @Inject(method = "method_55805(Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V", at = @At("HEAD"), cancellable = true, require = 0)
   private void c(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (ConfigBridge.c != null && CoreZoneProcessor.HOTBAR_ON) {
         try {
            if (a() && CoreZoneProcessor.m(var1, var2)) {
               var3.cancel();
            }
         } catch (Throwable var5) {
         }
      }
   }

   @Inject(method = "method_1765(Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V", at = @At("HEAD"), cancellable = true, require = 0)
   private void d(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (ConfigBridge.c != null && CoreZoneProcessor.POTIONS_ON) {
         try {
            if (a()) {
               var3.cancel();
            }
         } catch (Throwable var5) {
         }
      }
   }

   @Inject(method = "method_55800(Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V", at = @At("HEAD"), require = 0)
   private void e(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      CoreZoneProcessor.LIFT_PUSHED = false;
      if (ConfigBridge.c != null && CoreZoneProcessor.HOTBAR_ON) {
         float var4 = CoreZoneProcessor.ACTION_LIFT;
         if (!(var4 <= 0.0F)) {
            try {
               if (a()) {
                  var1.getMatrices().pushMatrix();
                  CoreZoneProcessor.LIFT_PUSHED = true;
                  var1.getMatrices().translate(0.0F, -var4);
               }
            } catch (Throwable var6) {
            }
         }
      }
   }

   @Inject(method = "method_55800(Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V", at = @At("RETURN"), require = 0)
   private void f(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (CoreZoneProcessor.LIFT_PUSHED) {
         CoreZoneProcessor.LIFT_PUSHED = false;

         try {
            var1.getMatrices().popMatrix();
         } catch (Throwable var5) {
         }
      }
   }
}
