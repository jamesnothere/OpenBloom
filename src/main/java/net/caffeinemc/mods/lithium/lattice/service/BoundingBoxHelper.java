package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class BoundingBoxHelper {
   private static final int c = 5246;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1054620863 ^ 1054615745) + (1900063967 ^ 1900063862);
   }

   public static boolean a(Object var0) {
      InitAdapter[] var1 = WrittenBookHelper.b();
      Object var2 = var0;
      if (var1 == null) {
         if (var0 == null) {
            return false;
         }

         var2 = var0;
      }

      int var3 = var2.hashCode();
      return var1 != null ? var3 != 0 : var3 != (-148680912 ^ -148677810);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (JoinerWriter.p(new byte[]{-50, -56, -117, 124}, 167)
               + YieldKeeper.v(new byte[]{94, 32, 31, -16}, 40)
               + StringDecoder.d(new byte[]{-8, -118, -105, -4, -35, -59, -28}, 165)
               + TokenExtractor.w(new byte[]{-71, -15, -87, -92, -9, -7, -38}, 207))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 37;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 37;
            var8 = var2;
         } else {
            var3 = 37;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 37;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 18;
               case 1 -> 58;
               case 2 -> 100;
               case 3 -> 109;
               case 4 -> 55;
               case 5 -> 60;
               default -> 44;
            });
            var2++;
            if (var3 == 0) {
               var8 = var3;
               var7 = var4;
               var6 = var3;
            } else {
               if (var5 <= var2) {
                  String var9 = new String(var4).intern();
                  byte var10 = -1;
                  d = var9;
                  break;
               }

               var7 = var4;
               var6 = var3;
               var8 = var2;
            }
         }
      }
   }
}
