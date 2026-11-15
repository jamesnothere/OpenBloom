package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class LinkerProvider {
   private static int a = 0;

   public static Vec3d a(Entity var0) {
      if (a != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return var0.getEntityPos().add(0.0, var0.getStandingEyeHeight(), 0.0);
   }

   public static Vec3d b(Entity var0) {
      if (a != 0) {
         Thread.currentThread().getName().length();
      }

      float var1 = var0.getYaw();
      float var2 = var0.getPitch();
      float var3 = (float)Math.toRadians(-var1 - 180.0F);
      float var4 = (float)Math.toRadians(-var2);
      float var5 = MathHelper.cos(var3);
      float var6 = MathHelper.sin(var3);
      float var7 = MathHelper.cos(var4);
      float var8 = MathHelper.sin(var4);
      return new Vec3d(var6 * var7, var8, var5 * var7);
   }
}
