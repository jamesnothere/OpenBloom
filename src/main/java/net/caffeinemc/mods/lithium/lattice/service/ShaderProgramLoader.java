package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class ShaderProgramLoader {
   private static final int c = 1309;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1295877029 ^ 1295877816) + 42;
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
      return var1 != null ? var3 != 0 : var3 != (2124005763 ^ 2124006558);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (NotifyResolver.q(new byte[]{29, 22, 19, 89, 69, 82, 51, 13}, 90)
               + StringDecoder.d(new byte[]{-48, -48, -124, -110, -112}, 154)
               + QueryZone.r(new byte[]{94, 125}, 12)
               + NotifyResolver.q(new byte[]{106, 103, 33, 63, 125, 92, 47, 20, 114}, 46))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 64;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 64;
            var8 = var2;
         } else {
            var3 = 64;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 64;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 84;
               case 1 -> 101;
               case 2 -> 108;
               case 3 -> 46;
               case 4 -> 42;
               case 5 -> 35;
               default -> 93;
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
