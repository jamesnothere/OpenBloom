package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class DispenserBehaviorMap {
   private static final int c = 6889;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 293082694 ^ 293080239) + (1085556661 ^ 1085556587);
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
      return var1 != null ? var3 != 0 : var3 != (-2107726652 ^ -2107720147);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = TokenExtractor.w(
               new byte[]{-79, -1, -11, -40, -24, -105, -65, -113, -3, -33, -44, -30, -111, -79, -118, -17, -26, -9, -30, -121, -34, -82, -120, -123, -77}, 205
            )
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 109;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 109;
            var8 = var2;
         } else {
            var3 = 109;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 109;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 89;
               case 1 -> 59;
               case 2 -> 40;
               case 3 -> 7;
               case 4 -> 61;
               case 5 -> 72;
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
