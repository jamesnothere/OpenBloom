package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class ProgressCalculator {
   private static final int c = 3572;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 465171145 ^ 465174333) + 115;
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
      return var1 != null ? var3 != 0 : var3 != (-1208219591 ^ -1208220211);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = TokenExtractor.w(
               new byte[]{-119, -113, -9, -81, -106, -55, -52, -75, -89, -30, -67, -128, -48, -40, -82, -97, -27, -88, -54, -44, -68, -38, -30}, 202
            )
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 71;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 71;
            var8 = var2;
         } else {
            var3 = 71;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 71;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 88;
               case 1 -> 125;
               case 2 -> 27;
               case 3 -> 74;
               case 4 -> 121;
               case 5 -> 48;
               default -> 32;
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
