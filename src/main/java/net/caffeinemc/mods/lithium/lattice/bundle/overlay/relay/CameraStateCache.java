package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraStateCache {
   @Shadow
   private boolean thirdPerson;

   @Shadow
   protected abstract void setPos(double var1, double var3, double var5);

   @Shadow
   protected abstract void setRotation(float var1, float var2);

   @Inject(method = "method_19321(Lnet/minecraft/class_1937;Lnet/minecraft/class_1297;ZZF)V", at = @At("RETURN"), require = 0)
   private void a(World var1, Entity var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      if (ConfigBridge.c != null && LockD.g) {
         try {
            SyncDispatcher var7;
            if (!ConfigBridge.c.a() || (var7 = ConfigBridge.c.c99()) == null) {
               return;
            }

            NodeFilterCache var8 = var7.a(NodeFilterCache.class);
            if (var8 == null || !var8.f() || !var8.d99()) {
               return;
            }

            this.setRotation(var8.f99(), var8.g99());
            this.setPos(var8.h(var5), var8.i(var5), var8.j(var5));
            this.thirdPerson = true;
         } catch (Throwable var9) {
         }
      }
   }
}
