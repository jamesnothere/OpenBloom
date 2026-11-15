package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class RecipeSerializer {
   private static final int c = 3386;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1002725702 ^ 1002728572) + 109;
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
      return var1 != null ? var3 != 0 : var3 != (-834405031 ^ -834408349);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (YieldKeeper.v(new byte[]{-9, -93, 97, 41, 119, -83, -61, 101, 27, 14, -38, -10, 6, 71, 14, -2}, 205)
               + QueryZone.r(new byte[]{62}, 120)
               + TokenExtractor.w(new byte[]{68, 112}, 66)
               + StringDecoder.d(new byte[]{-107, -121}, 189))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 113;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 113;
            var8 = var2;
         } else {
            var3 = 113;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 113;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 25;
               case 1 -> 45;
               case 2 -> 20;
               case 3 -> 5;
               case 4 -> 119;
               case 5 -> 119;
               default -> 122;
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
