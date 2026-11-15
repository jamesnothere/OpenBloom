package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class OreVeinGenerator {
   private static final int c = 2053;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1867265434 ^ 1867267487) + 66;
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
      return var1 != null ? var3 != 0 : var3 != (-621992056 ^ -621990003);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (QueryZone.r(new byte[]{57, 67, 67, 2, 12, 71, 5, 6, 101, 27, 96, 84, 62, 108, 127, 37}, 76)
               + StringDecoder.d(new byte[]{117}, 46)
               + JoinerWriter.p(new byte[]{-52}, 170)
               + JoinerWriter.p(new byte[]{-49, 45, -4}, 60))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 114;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 114;
            var8 = var2;
         } else {
            var3 = 114;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 114;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 75;
               case 1 -> 5;
               case 2 -> 9;
               case 3 -> 114;
               case 4 -> 72;
               case 5 -> 54;
               default -> 120;
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
