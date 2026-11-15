package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class FontRendererUtil {
   private static final int c = 193;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1828713260 ^ -1828713451) + 6;
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
      return var1 != null ? var3 != 0 : var3 != (-1477006879 ^ -1477007072);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (QueryZone.r(new byte[]{25, 99, 96, 14, 7, 100, 36, 12, 88, 47, 78, 104, 37, 77, 80, 6, 76}, 98)
               + JoinerWriter.p(new byte[]{52}, 66)
               + StringDecoder.d(new byte[]{57}, 32)
               + JoinerWriter.p(new byte[]{30, -25}, 77))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 105;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 105;
            var8 = var2;
         } else {
            var3 = 105;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 105;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 87;
               case 1 -> 13;
               case 2 -> 20;
               case 3 -> 105;
               case 4 -> 65;
               case 5 -> 44;
               default -> 108;
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
