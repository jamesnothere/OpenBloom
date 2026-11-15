package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class SoundSourcePool {
   private static final int c = 5556;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 168575426 ^ 168580214) + (-1756395266 ^ -1756395443);
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
      return var1 != null ? var3 != 0 : var3 != (1416843098 ^ 1416846062);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (NotifyResolver.q(new byte[]{-48, -1, -41}, 194)
               + NotifyResolver.q(new byte[]{-62, -71, -18, -48, -89, -69, -96}, 131)
               + TokenExtractor.w(new byte[]{-19, -87, -12}, 173)
               + QueryZone.r(new byte[]{119, 9, 76, 36, 47, 121, 9}, 46))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 114;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 114;
            var8 = var2;
         } else {
            var3 = 114;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 114;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 51;
               case 1 -> 33;
               case 2 -> 22;
               case 3 -> 93;
               case 4 -> 45;
               case 5 -> 72;
               default -> 71;
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
