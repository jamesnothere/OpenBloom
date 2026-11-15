package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class SilkTouchHelper {
   private static final int c = 7726;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1116393503 ^ -1116393009) + (-1927205839 ^ -1927205688);
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
      return var1 != null ? var3 != 0 : var3 != (2110699452 ^ 2110695826);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (JoinerWriter.p(new byte[]{126, -92, -68, -76, -70, -72, -37, -89, -100, -39, -85, -21, -110, -28, -111}, 130)
               + TokenExtractor.w(new byte[]{98, 87, 109, 53, 104}, 12))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 18;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 18;
            var8 = var2;
         } else {
            var3 = 18;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 18;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 65;
               case 1 -> 92;
               case 2 -> 62;
               case 3 -> 64;
               case 4 -> 6;
               case 5 -> 66;
               default -> 4;
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
