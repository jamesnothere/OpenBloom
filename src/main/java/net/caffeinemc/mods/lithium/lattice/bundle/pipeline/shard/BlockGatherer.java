package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public final class BlockGatherer {
   private static final String[] c;
   private static final String[] d;
   private static int e = 0;

   public static boolean c() {
      return false;
   }

   static {
      lbl917d54_15: {
      String[] var0 = new String[2];
      int var1 = 0;
      String var2 = NotifyResolver.q(new byte[]{-44, 110, 47, 103, 62, 119, 61, 94, 119}, 172)
         + TokenExtractor.w(new byte[]{-105, 121, 30, 122, 47, -99, -33, 103, 44, -84, -14, -83, 99, 6, 109, 34}, 183)
         + JoinerWriter.p(new byte[]{-106, -125, -108, -123, -110, 108}, 44)
         + JoinerWriter.p(new byte[]{-29, 67, -103, 104, 75, -106, -111, -108, -120, -40}, 40);
      int var3 = YieldKeeper.v(
            new byte[]{
               75,
               -91,
               30,
               14,
               125,
               -16,
               -48,
               91,
               80,
               -43,
               -13,
               -64,
               84,
               93,
               -57,
               73,
               -95,
               30,
               -58,
               -84,
               35,
               -95,
               60,
               11,
               116,
               -20,
               -47,
               86,
               115,
               56,
               -80,
               107,
               -1,
               5,
               106,
               91,
               -100,
               45,
               6,
               64,
               34
            },
            51
         )
         .length();
      char var4 = '\r';
      int var5 = -1;

      while (true) {
         char[] var6;
         label38: {
            char[] var7 = var2.substring(++var5, var5 + var4).toCharArray();
            int var8 = var7.length;
            int var9 = 0;
            byte var10 = 9;
            var6 = var7;
            int var11 = var8;
            byte var12;
            char[] var13;
            int var14;
            if (var8 <= 1) {
               var13 = var7;
               var12 = 9;
               var14 = var9;
            } else {
               var10 = 9;
               var11 = var8;
               if (var8 <= var9) {
                  break label38;
               }

               var13 = var7;
               var12 = 9;
               var14 = var9;
            }

            while (true) {
               var13[var14] = (char)(var13[var14] ^ var12 ^ switch (var9 % 7) {
                  case 0 -> 47;
                  case 1 -> 79;
                  case 2 -> 71;
                  case 3 -> 88;
                  case 4 -> 111;
                  case 5 -> 59;
                  default -> 124;
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
            break lbl917d54_15;
         }

         var4 = var2.charAt(var5);
      }
      }
   }
}
