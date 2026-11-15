package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public final class ItemHandler {
   private static final String[] c;
   private static final String[] d;
   private static int e = 0;

   public static void c() {
   }

   static {
      lbl69191f_13: {
      char[] var0 = null;
      String[] var1 = new String[11];
      int var2 = 0;
      String var3 = StringDecoder.d(
         new byte[]{
            111,
            40,
            108,
            15,
            -31,
            -86,
            -79,
            -90,
            102,
            8,
            100,
            35,
            98,
            4,
            96,
            0,
            -123,
            -45,
            -74,
            -2,
            122,
            0,
            121,
            53,
            118,
            36,
            -57,
            -76,
            115,
            2,
            -31,
            -90,
            79,
            23,
            -14,
            -124,
            74,
            61,
            72,
            47,
            71,
            14,
            69,
            62,
            -64,
            67,
            39,
            64,
            3,
            -92,
            -43,
            92,
            1,
            91,
            24,
            89,
            52,
            87,
            31,
            -55,
            82,
            32,
            81,
            22,
            47,
            70,
            -22,
            44,
            64,
            43,
            122,
            -105,
            38,
            122,
            -99,
            -14,
            35,
            86,
            33,
            64,
            63,
            83,
            -15,
            -81,
            58,
            77,
            -43,
            56,
            91,
            -62,
            -108,
            -108,
            50,
            69,
            48,
            97,
            -7,
            14,
            71,
            -8,
            -69,
            -25,
            -22,
            -101,
            -43,
            -89,
            -5,
            -65,
            2,
            99,
            -55,
            1,
            115,
            31,
            123,
            29,
            69,
            26,
            93,
            -4,
            23,
            88,
            -116,
            -98,
            -125,
            -21,
            -44,
            -42,
            40,
            53,
            -19,
            -81,
            -21,
            -113,
            34,
            -24,
            -106,
            -25,
            -116,
            4,
            59,
            90,
            -31,
            -116,
            -1,
            -107,
            66,
            113
         },
         173
      );
      int var4 = YieldKeeper.v(
            new byte[]{
               -22,
               -44,
               -69,
               1,
               -128,
               -14,
               2,
               76,
               -85,
               60,
               123,
               101,
               -53,
               -108,
               -101,
               34,
               -112,
               -65,
               -15,
               96,
               -117,
               -56,
               90,
               79,
               43,
               -128,
               72,
               98,
               74,
               2,
               -118,
               20,
               -22,
               -53,
               5,
               -86,
               11,
               69,
               -37,
               -27,
               -86,
               26,
               122,
               88,
               73,
               -13,
               -4,
               66,
               54,
               -24,
               -78,
               -30,
               -48,
               -77,
               27,
               3,
               73,
               -45,
               -80,
               63,
               75,
               0,
               26,
               -124,
               -22,
               -6,
               125,
               98,
               97,
               51,
               -119,
               61,
               -85,
               14,
               -62,
               -12,
               -54,
               -122,
               -102,
               34,
               106,
               127,
               -10,
               113,
               -117,
               -59,
               -74,
               2,
               70,
               38,
               91,
               2,
               75,
               5,
               27,
               -109,
               28,
               -110,
               -16,
               -106,
               -70,
               -33,
               57,
               17,
               120,
               -13,
               -124,
               -103,
               -53,
               -109,
               82,
               67,
               6,
               19,
               92,
               -29,
               -44,
               -78,
               30,
               -26,
               42,
               -100,
               99,
               40,
               -38,
               -117,
               -33,
               4,
               45,
               73,
               -70,
               33,
               10,
               87,
               17,
               -126,
               -37,
               83,
               19,
               -62,
               18,
               74,
               -102,
               46,
               106,
               121,
               -123,
               111
            },
            40
         )
         .length();
      char var5 = 5;
      int var20 = -1;

      label54:
      while (true) {
         byte var7 = 26;
         String var8 = var3.substring(++var20, var20 + var5);
         byte var9 = -1;

         while (true) {
            label49: {
               char[] var10 = var8.toCharArray();
               int var11 = var10.length;
               int var12 = 0;
               byte var13 = var7;
               var0 = var10;
               int var14 = var11;
               byte var15;
               char[] var16;
               int var17;
               if (var11 <= 1) {
                  var16 = var10;
                  var15 = var7;
                  var17 = var12;
               } else {
                  var13 = var7;
                  var14 = var11;
                  if (var11 <= var12) {
                     break label49;
                  }

                  var16 = var10;
                  var15 = var7;
                  var17 = var12;
               }

               while (true) {
                  var16[var17] = (char)(var16[var17] ^ var15 ^ switch (var12 % 7) {
                     case 0 -> 2;
                     case 1 -> 105;
                     case 2 -> 49;
                     case 3 -> 2;
                     case 4 -> 77;
                     case 5 -> 9;
                     default -> 112;
                  });
                  var12++;
                  if (var13 == 0) {
                     var17 = var13;
                     var16 = var0;
                     var15 = var13;
                  } else {
                     if (var14 <= var12) {
                        break;
                     }

                     var16 = var0;
                     var15 = var13;
                     var17 = var12;
                  }
               }
            }

            String var21 = new String(var0).intern();
            switch (var9) {
               case 0:
                  var1[var2++] = var21;
                  if ((var20 += var5) >= var4) {
                     c = var1;
                     d = new String[11];
                     break lbl69191f_13;
                  }

                  var5 = var3.charAt(var20);
                  break;
               default:
                  var1[var2++] = var21;
                  if ((var20 += var5) < var4) {
                     var5 = var3.charAt(var20);
                     continue label54;
                  }

                  var3 = StringDecoder.d(new byte[]{100, 9}, 167)
                     + StringDecoder.d(
                        new byte[]{
                           -125, -11, -128, -3, 116, 72, -124, -21, -118, -5, 5, -120, -28, 83, -115, -28, -109, -3, 81, -112, -12, -105, -35, -108, -7
                        },
                        64
                     );
                  var4 = QueryZone.r(
                        new byte[]{
                           102, 3, 116, 10, 123, 62, -69, -97, 95, 72, 45, 68, -66, 59, 107, -44, 22, 119, -28, -126, 42, -13, -101, -64, -122, -41, -66
                        },
                        166
                     )
                     .length();
                  var5 = '\f';
                  var20 = -1;
            }

            var7 = 120;
            var8 = var3.substring(++var20, var20 + var5);
            var9 = 0;
         }
      }
      }
   }
}
