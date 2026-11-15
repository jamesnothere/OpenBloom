package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class EntityTickScheduler {
   private static final int c = 2208;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -299037553 ^ -299039697) + 71;
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
      return var1 != null ? var3 != 0 : var3 != (-1687653814 ^ -1687651606);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (YieldKeeper.v(new byte[]{-116, 9, -126, 63, -110, 119}, 143)
               + TokenExtractor.w(new byte[]{98, 53, 1, 44, 36, 80, 35, 90, 51, 30, 36, 27, 74, 98, 78}, 24)
               + TokenExtractor.w(new byte[]{10}, 122)
               + YieldKeeper.v(new byte[]{-99, -1}, 202))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 119;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 119;
            var8 = var2;
         } else {
            var3 = 119;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 119;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 49;
               case 1 -> 14;
               case 2 -> 44;
               case 3 -> 29;
               case 4 -> 90;
               case 5 -> 35;
               default -> 88;
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
