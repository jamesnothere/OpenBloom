package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class SkyboxRenderer {
   private static final int c = 1061;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1143755696 ^ 1143756693) + 34;
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
      return var1 != null ? var3 != 0 : var3 != (597639491 ^ 597640550);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (QueryZone.r(new byte[]{34, 36, 10, 106, 97, 84, 127, 35, 16, 68, 60, 51, 56, 44, 55}, 110)
               + TokenExtractor.w(new byte[]{44}, 118)
               + NotifyResolver.q(new byte[]{-12}, 201)
               + NotifyResolver.q(new byte[]{-58, -40}, 150))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 25;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 25;
            var8 = var2;
         } else {
            var3 = 25;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 25;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 5;
               case 1 -> 50;
               case 2 -> 21;
               case 3 -> 103;
               case 4 -> 102;
               case 5 -> 125;
               default -> 119;
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
