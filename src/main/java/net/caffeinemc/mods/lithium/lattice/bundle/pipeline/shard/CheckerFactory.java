package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public final class CheckerFactory {
   private static final String[] c;
   private static final String[] d;
   private static int e = 0;

   public static double b(double var0, double var2) {
      if (e != 0) {
         Thread.currentThread().getName().length();
      }

      return 0.0;
   }

   static {
      lbl1f7ec5_19: {
      String[] var0 = new String[2];
      int var1 = 0;
      String var2 = JoinerWriter.p(new byte[]{-125, 9, -10, 8, -53, -77, 118}, 184)
         + QueryZone.r(new byte[]{-115, -57, -98, -42, -112, -14, -94, -55, 16, -52, -87, 56, 106, 122, 24, 57}, 76)
         + NotifyResolver.q(new byte[]{96, 49, -96, -43, 20, 39, 46, 110, 6}, 103);
      int var3 = (QueryZone.r(new byte[]{120, -120, -31, -101, -40}, 64)
            + YieldKeeper.v(
               new byte[]{39, -102, -57, -35, 112, -120, -94, 32, -52, -41, -38, -42, -57, -26, 104, 24, -10, 7, 114, -101, -32, -63, -78, 113}, 87
            )
            + NotifyResolver.q(new byte[]{-92, -16, -20}, 201))
         .length();
      char var4 = 16;
      int var5 = -1;

      while (true) {
         char[] var6;
         label38: {
            char[] var7 = var2.substring(++var5, var5 + var4).toCharArray();
            int var8 = var7.length;
            int var9 = 0;
            byte var10 = 12;
            var6 = var7;
            int var11 = var8;
            byte var12;
            char[] var13;
            int var14;
            if (var8 <= 1) {
               var13 = var7;
               var12 = 12;
               var14 = var9;
            } else {
               var10 = 12;
               var11 = var8;
               if (var8 <= var9) {
                  break label38;
               }

               var13 = var7;
               var12 = 12;
               var14 = var9;
            }

            while (true) {
               var13[var14] = (char)(var13[var14] ^ var12 ^ switch (var9 % 7) {
                  case 0 -> 2;
                  case 1 -> 39;
                  case 2 -> 60;
                  case 3 -> 35;
                  case 4 -> 80;
                  case 5 -> 71;
                  default -> 73;
               });
               var9++;
               if (var10 == 0) {
                  var14 = var10;
                  var13 = var6;
                  var12 = var10;
               } else {
                  if (var11 <= var9) {
                     break;
                  }

                  var13 = var6;
                  var12 = var10;
                  var14 = var9;
               }
            }
         }

         String var16 = new String(var6).intern();
         byte var17 = -1;
         var0[var1++] = var16;
         if ((var5 += var4) >= var3) {
            c = var0;
            d = new String[2];
            break lbl1f7ec5_19;
         }

         var4 = var2.charAt(var5);
      }
      }
   }
}
