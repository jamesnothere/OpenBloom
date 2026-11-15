package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class InputEventProcessor {
   private static final int c = 286;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 100361071 ^ 100360817) + 9;
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
      return var1 != null ? var3 != 0 : var3 != (-380104118 ^ -380103852);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (NotifyResolver.q(new byte[]{6}, 100)
               + JoinerWriter.p(new byte[]{-55, -14, -48, -89}, 95)
               + JoinerWriter.p(new byte[]{-15, -22, 23, -16, 29, -38, -44, -48, -8, 16, -10, 17, -22, -51, 0, -36, -43, 34, -53}, 53))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 67;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 67;
            var8 = var2;
         } else {
            var3 = 67;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 67;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 104;
               case 1 -> 5;
               case 2 -> 97;
               case 3 -> 7;
               case 4 -> 62;
               case 5 -> 32;
               default -> 21;
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
