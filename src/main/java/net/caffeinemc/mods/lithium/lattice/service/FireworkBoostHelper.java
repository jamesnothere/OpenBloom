package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class FireworkBoostHelper {
   private static final int c = 7323;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -62981715 ^ -62986954) + (2121296864 ^ 2121296652);
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
      return var1 != null ? var3 != 0 : var3 != (861788022 ^ 861785069);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (JoinerWriter.p(new byte[]{6, -13, -89, -37, -31, -61, -91, -36, 19, -85, -34, -42, -61, -56}, 98)
               + StringDecoder.d(new byte[]{-11, -20, -75, -3, -8, -34, -79}, 190)
               + QueryZone.r(new byte[]{64, 71, 4}, 92))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 70;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 70;
            var8 = var2;
         } else {
            var3 = 70;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 70;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 104;
               case 1 -> 121;
               case 2 -> 63;
               case 3 -> 99;
               case 4 -> 118;
               case 5 -> 3;
               default -> 57;
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
