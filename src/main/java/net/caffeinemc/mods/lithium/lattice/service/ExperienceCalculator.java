package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;

public class ExperienceCalculator {
   private static final int c = 3076;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -612855699 ^ -612852631) + 99;
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
      return var1 != null ? var3 != 0 : var3 != (195514833 ^ 195517909);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = StringDecoder.d(new byte[]{89, 41, 54, 113, 32, 4, 86, 117, 59, 40, 94, 60, 8, 91, 103, 51, 53, 114, 43, 9, 1, 127, 119, 125, 63}, 96)
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 100;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 100;
            var8 = var2;
         } else {
            var3 = 100;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 100;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 24;
               case 1 -> 84;
               case 2 -> 64;
               case 3 -> 19;
               case 4 -> 82;
               case 5 -> 108;
               default -> 49;
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
