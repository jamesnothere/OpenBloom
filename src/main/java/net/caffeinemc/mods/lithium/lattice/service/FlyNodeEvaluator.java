package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;

public class FlyNodeEvaluator {
   private static final int c = 2642;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -2119248183 ^ -2119246693) + 85;
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
      return var1 != null ? var3 != 0 : var3 != (-423862873 ^ -423864331);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (JoinerWriter.p(new byte[]{-44, -72, -105, -84, -24, 126, -116, -52, -57, -88, -121, -57, 122, -106}, 142)
               + YieldKeeper.v(new byte[]{-41, 97, -86}, 156)
               + NotifyResolver.q(new byte[]{24}, 29)
               + YieldKeeper.v(new byte[]{-30, -41, 39}, 198))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 84;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 84;
            var8 = var2;
         } else {
            var3 = 84;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 84;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 112;
               case 1 -> 127;
               case 2 -> 10;
               case 3 -> 39;
               case 4 -> 65;
               case 5 -> 33;
               default -> 17;
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
