package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class FishingHookHelper {
   private static final int c = 7168;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -440023736 ^ -440018616) + (827955900 ^ 827955803);
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
      return var1 != null ? var3 != 0 : var3 != (-613143006 ^ -613141982);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{-123}, 182)
               + JoinerWriter.p(new byte[]{-45, -14, -52, -39, 6, -34, -8, -50, -9}, 56)
               + NotifyResolver.q(new byte[]{89, 104, 17, 69, 66, 66, 82, 35, 23, 16}, 92)
               + TokenExtractor.w(new byte[]{117, 104}, 37))
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
               case 0 -> 108;
               case 1 -> 112;
               case 2 -> 74;
               case 3 -> 124;
               case 4 -> 111;
               case 5 -> 62;
               default -> 110;
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
