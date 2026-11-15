package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public final class LoaderBridge {
   private double e;
   private final double f;
   private static final String[] g;
   private static final String[] h;
   private static int i = 0;

   public LoaderBridge(double var1) {
      this.e = var1;
      this.f = var1;
   }

   public static void b() {
   }

   static {
      lbla17573_22: {
      char[] var0 = null;
      String[] var1 = new String[10];
      int var2 = 0;
      String var3 = StringDecoder.d(
         new byte[]{
            65,
            56,
            -36,
            -65,
            115,
            -38,
            -94,
            35,
            53,
            74,
            34,
            67,
            1,
            -45,
            -127,
            26,
            40,
            -50,
            -81,
            -51,
            -66,
            29,
            -55,
            -69,
            -58,
            -69,
            -59,
            -68,
            -61,
            -110,
            -64,
            -122,
            57,
            -2,
            -122,
            18,
            -6,
            -104,
            -7,
            -81,
            11,
            48,
            -12,
            -78,
            -14,
            -125,
            -16,
            -83,
            -17,
            -112,
            48,
            45,
            5,
            44,
            62,
            -24,
            -128,
            22,
            -28,
            -92,
            83,
            -30,
            -82,
            -31,
            -41,
            -97,
            -64,
            -100,
            -43,
            -101,
            -6,
            50,
            -105,
            -22,
            -108,
            -5,
            -110,
            -32,
            78,
            59,
            -114,
            -2,
            70,
            -116,
            -40,
            63,
            53,
            79,
            -122,
            -52,
            -123,
            -5,
            54,
            21,
            82,
            -127,
            -51,
            22,
            59,
            57,
            -70,
            -20,
            -72,
            -16,
            96,
            -74,
            -22,
            111,
            48,
            97,
            -80,
            -4,
            102,
            -82,
            -27,
            -84,
            -9,
            -85,
            -34
         },
         28
      );
      int var4 = (YieldKeeper.v(
               new byte[]{-20, 71, -47, 100, 30, -27, 111, -80, 24, -75, -81, 24, -20, 108, -52, 25, -27, -79, -126, 22, 51, 34, 36, 40, -117, 68}, 177
            )
            + QueryZone.r(
               new byte[]{
                  -120,
                  -7,
                  -102,
                  -61,
                  -107,
                  -21,
                  96,
                  -65,
                  -53,
                  39,
                  -61,
                  -71,
                  -36,
                  -126,
                  18,
                  33,
                  -7,
                  -73,
                  11,
                  114,
                  5,
                  64,
                  22,
                  81,
                  -3,
                  -8,
                  -36,
                  -115,
                  -101,
                  69,
                  57,
                  -89,
                  105,
                  33,
                  -54,
                  115,
                  59,
                  -116,
                  -50,
                  -98,
                  -51,
                  -87,
                  -20,
                  -70,
                  -33,
                  31,
                  -50,
                  -69,
                  -39,
                  -66,
                  -21,
                  -111,
                  59,
                  86,
                  -9,
                  127,
                  -53,
                  25,
                  65,
                  -98,
                  -112,
                  -30,
                  63,
                  125,
                  72,
                  62,
                  -17,
                  -60,
                  -121,
                  108,
                  20,
                  -41,
                  -10,
                  12,
                  -125,
                  -51,
                  -99,
                  -35,
                  121,
                  -89,
                  -25,
                  106,
                  73,
                  16,
                  -59,
                  -111,
                  31,
                  -17,
                  -88,
                  -7,
                  -82,
                  10,
                  123
               },
               72
            ))
         .length();
      char var5 = '\f';
      int var20 = -1;

      label54:
      while (true) {
         byte var7 = 122;
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
                     case 0 -> 73;
                     case 1 -> 8;
                     case 2 -> 82;
                     case 3 -> 13;
                     case 4 -> 85;
                     case 5 -> 85;
                     default -> 28;
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
                     g = var1;
                     h = new String[10];
                     break lbla17573_22;
                  }

                  var5 = var3.charAt(var20);
                  break;
               default:
                  var1[var2++] = var21;
                  if ((var20 += var5) < var4) {
                     var5 = var3.charAt(var20);
                     continue label54;
                  }

                  var3 = JoinerWriter.p(
                        new byte[]{
                           -120,
                           80,
                           49,
                           -34,
                           3,
                           -126,
                           100,
                           -18,
                           -32,
                           126,
                           88,
                           124,
                           96,
                           123,
                           63,
                           121,
                           99,
                           -50,
                           -57,
                           117,
                           94,
                           -8,
                           -25,
                           112,
                           51,
                           -51,
                           109,
                           89,
                           107,
                           97,
                           106,
                           57
                        },
                        59
                     )
                     + StringDecoder.d(new byte[]{-67, -31, 76, -65, -48, 102, -70, -8, -76, -57, -73, -63, -80, -49, 113, -77, -59, -84, -31, -81, -32}, 126);
                  var4 = TokenExtractor.w(
                        new byte[]{
                           73,
                           7,
                           -26,
                           -107,
                           -52,
                           77,
                           41,
                           -67,
                           -79,
                           81,
                           13,
                           83,
                           49,
                           84,
                           28,
                           86,
                           52,
                           -127,
                           -116,
                           90,
                           51,
                           -41,
                           -92,
                           95,
                           36,
                           -126,
                           98,
                           14,
                           100,
                           30,
                           103,
                           54,
                           105,
                           53,
                           -104,
                           107,
                           4,
                           -78,
                           110,
                           44,
                           112,
                           3,
                           115,
                           5,
                           116,
                           11,
                           -75,
                           119,
                           17,
                           120,
                           53,
                           123,
                           52
                        },
                        130
                     )
                     .length();
                  var5 = '\f';
                  var20 = -1;
            }

            var7 = 71;
            var8 = var3.substring(++var20, var20 + var5);
            var9 = 0;
         }
      }
      }
   }
}
