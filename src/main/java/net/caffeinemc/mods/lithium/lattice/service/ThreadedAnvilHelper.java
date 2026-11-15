package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class ThreadedAnvilHelper {
   private static final int c = 6455;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -772539274 ^ -772545215) + (-1426171318 ^ -1426171238);
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
      return var1 != null ? var3 != 0 : var3 != (839937812 ^ 839939619);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (StringDecoder.d(new byte[]{-34, -47, -46, -48, -86, -26, -105, -23, -15, -59, -54, -83, -25, -79, -31, -37, -62}, 150)
               + StringDecoder.d(new byte[]{85, 58, 35}, 16)
               + TokenExtractor.w(new byte[]{100}, 119)
               + JoinerWriter.p(new byte[]{124, 78, 81}, 177))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 18;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 18;
            var8 = var2;
         } else {
            var3 = 18;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 18;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 14;
               case 1 -> 60;
               case 2 -> 38;
               case 3 -> 50;
               case 4 -> 75;
               case 5 -> 3;
               default -> 112;
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
