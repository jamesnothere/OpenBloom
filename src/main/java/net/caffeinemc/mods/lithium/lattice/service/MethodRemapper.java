package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class MethodRemapper {
   private static final int c = 4595;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -791926446 ^ -791922527) + (-1628486869 ^ -1628486721);
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
      return var1 != null ? var3 != 0 : var3 != (454727884 ^ 454723903);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{-77, -29, -113, -13, -8, -58, -39, -128, -14, -123, -14, -4, -34, -2}, 164)
               + YieldKeeper.v(new byte[]{26, -117}, 106)
               + JoinerWriter.p(new byte[]{27}, 71)
               + YieldKeeper.v(new byte[]{80, -107}, 76))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 74;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 74;
            var8 = var2;
         } else {
            var3 = 74;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 74;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 26;
               case 1 -> 99;
               case 2 -> 25;
               case 3 -> 120;
               case 4 -> 119;
               case 5 -> 67;
               default -> 117;
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
