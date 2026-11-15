package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class AccessWidenerHelper {
   private static final int c = 4471;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1795822418 ^ -1795818023) + (-1169282485 ^ -1169282341);
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
      return var1 != null ? var3 != 0 : var3 != (1886446864 ^ 1886450791);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{30}, 98)
               + TokenExtractor.w(new byte[]{-13, -7, -22, -7, -75, -114}, 150)
               + TokenExtractor.w(new byte[]{35, 21, 28, 0, 8, 85, 114, 38, 26, 16, 16, 6, 24, 85, 105, 65, 87}, 118))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 21;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 21;
            var8 = var2;
         } else {
            var3 = 21;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 21;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 46;
               case 1 -> 26;
               case 2 -> 19;
               case 3 -> 7;
               case 4 -> 5;
               case 5 -> 72;
               default -> 84;
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
