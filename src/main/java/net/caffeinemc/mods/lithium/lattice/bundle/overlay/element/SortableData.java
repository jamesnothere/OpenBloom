package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.ClickZoneResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class SortableData {
   @Inject(method = "method_1600(JDD)V", at = @At("HEAD"), cancellable = true, require = 0)
   private void a(long var1, double var3, double var5, CallbackInfo var7) {
      if (LockD.a) {
         MinecraftClient var8 = MinecraftClient.getInstance();
         if (var8 != null && var8.currentScreen instanceof InventoryScreen) {
            if (ConfigBridge.c != null && ConfigBridge.c.a()) {
               var7.cancel();
            }
         }
      }
   }

   @Redirect(method = "method_1606(D)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_746;method_5872(DD)V"), require = 0)
   private void b(ClientPlayerEntity var1, double var2, double var4) {
      if (System.nanoTime() >= LockD.b) {
         if (ConfigBridge.c != null && LockD.g) {
            try {
               SyncDispatcher var6;
               if (ConfigBridge.c.a() && (var6 = ConfigBridge.c.c99()) != null) {
                  NodeFilterCache var7 = var6.a(NodeFilterCache.class);
                  if (var7 != null && var7.f() && var7.d99()) {
                     var7.c(var2, var4);
                     return;
                  }
               }
            } catch (Throwable var8) {
            }
         }

         var1.changeLookDirection(var2, var4);
      }
   }

   @Inject(method = "method_1606(D)V", at = @At("HEAD"), require = 0)
   private void c(double var1, CallbackInfo var3) {
      Runnable var4 = LockD.c;
      if (var4 != null) {
         try {
            var4.run();
         } catch (Throwable var10) {
         }
      }

      if (ConfigBridge.c != null) {
         Runnable var5 = LockD.e;
         if (var5 != null) {
            try {
               if (ConfigBridge.c.a()) {
                  var5.run();
               }
            } catch (Throwable var9) {
            }
         }
      }

      Runnable var11 = LockD.d;
      if (var11 != null) {
         try {
            if (ConfigBridge.c != null && ConfigBridge.c.a()) {
               var11.run();
            }
         } catch (Throwable var8) {
         }
      }

      if (LockD.h) {
         try {
            ClickZoneResolver.b();
         } catch (Throwable var7) {
         }
      }
   }

   @Inject(method = "method_55793()V", at = @At("HEAD"), require = 0)
   private void d(CallbackInfo var1) {
      if (FrameClockCache.any) {
         try {
            FrameClockCache.e();
         } catch (Throwable var3) {
         }
      }
   }
}
