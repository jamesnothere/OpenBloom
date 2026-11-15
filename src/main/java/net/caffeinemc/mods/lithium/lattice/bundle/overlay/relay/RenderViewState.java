package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.FrameKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.render.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class RenderViewState {
   @ModifyArg(
      method = "method_3188(Lnet/minecraft/class_9779;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_761;method_22710(Lnet/minecraft/class_9922;Lnet/minecraft/class_9779;ZLnet/minecraft/class_4184;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"
      ),
      index = 4,
      require = 0
   )
   private Matrix4f a(Matrix4f var1) {
      if (FrameKeeper.ag) {
         try {
            var1.get(FrameKeeper.VIEW);
         } catch (Throwable var3) {
         }
      }

      return var1;
   }

   @ModifyArg(
      method = "method_3188(Lnet/minecraft/class_9779;)V",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_761;method_22710(Lnet/minecraft/class_9922;Lnet/minecraft/class_9779;ZLnet/minecraft/class_4184;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"
      ),
      index = 5,
      require = 0
   )
   private Matrix4f b(Matrix4f var1) {
      if (FrameKeeper.ag) {
         try {
            var1.get(FrameKeeper.PROJ);
            FrameKeeper.ai = true;
         } catch (Throwable var3) {
         }
      }

      return var1;
   }

   @Inject(method = "method_3172(FZLorg/joml/Matrix4f;)V", at = @At("HEAD"), cancellable = true, require = 0)
   private void c(float var1, boolean var2, Matrix4f var3, CallbackInfo var4) {
      if (ConfigBridge.c != null && LockD.g) {
         try {
            SyncDispatcher var5;
            if (ConfigBridge.c.a() && (var5 = ConfigBridge.c.c99()) != null) {
               NodeFilterCache var6 = var5.a(NodeFilterCache.class);
               if (var6 != null && var6.f() && var6.d99()) {
                  var4.cancel();
               }
            }
         } catch (Throwable var7) {
         }
      }
   }
}
