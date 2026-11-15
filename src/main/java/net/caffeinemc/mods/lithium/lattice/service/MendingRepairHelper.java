package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;

public class MendingRepairHelper {
   private static final int c = 7757;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 2008601035 ^ 2008600454) + (-724557333 ^ -724557551);
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
      return var1 != null ? var3 != 0 : var3 != (1462448737 ^ 1462447148);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (NotifyResolver.q(new byte[]{-29, -86, -34}, 175)
               + JoinerWriter.p(new byte[]{-88, -68, -45, 121, -64, 112, -42, -100, -75, -32, -117, -54, 114, -49}, 143)
               + NotifyResolver.q(new byte[]{120}, 78)
               + StringDecoder.d(new byte[]{64, 60, 15, 36, 92, 57}, 23))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 51;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 51;
            var8 = var2;
         } else {
            var3 = 51;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 51;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 50;
               case 1 -> 82;
               case 2 -> 40;
               case 3 -> 96;
               case 4 -> 22;
               case 5 -> 57;
               default -> 95;
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
