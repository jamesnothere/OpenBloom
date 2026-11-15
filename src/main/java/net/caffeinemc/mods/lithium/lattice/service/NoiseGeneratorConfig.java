package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class NoiseGeneratorConfig {
   private static final int c = 1805;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1846209968 ^ -1846209187) + 58;
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
      return var1 != null ? var3 != 0 : var3 != (1241731697 ^ 1241732476);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (StringDecoder.d(new byte[]{13}, 28)
               + StringDecoder.d(new byte[]{98, 89, 80, 41, 56}, 94)
               + QueryZone.r(new byte[]{107, 3, 31, 61, 57, 123, 95, 75, 31, 70, 112, 113, 23, 36, 72, 125, 41, 3, -10}, 56))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 75;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 75;
            var8 = var2;
         } else {
            var3 = 75;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 75;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 20;
               case 1 -> 24;
               case 2 -> 36;
               case 3 -> 52;
               case 4 -> 90;
               case 5 -> 110;
               default -> 126;
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
