package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class StatusPingResponder {
   private static final int c = 3851;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -2031329496 ^ -2031333341) + 124;
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
      return var1 != null ? var3 != 0 : var3 != (-1590579597 ^ -1590582920);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (StringDecoder.d(new byte[]{106, 89}, 63)
               + TokenExtractor.w(new byte[]{27, 65}, 109)
               + TokenExtractor.w(new byte[]{-73, -12, -122, -90, -85, -95, -39, -72, -19, -67, -71, -84, -85, -27, -90}, 198)
               + StringDecoder.d(new byte[]{124, 121, 37, 46, 53}, 16))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 73;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 73;
            var8 = var2;
         } else {
            var3 = 73;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 73;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 79;
               case 1 -> 90;
               case 2 -> 88;
               case 3 -> 22;
               case 4 -> 65;
               case 5 -> 5;
               default -> 87;
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
