package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class RegistrySyncValidator {
   private static final int c = 3324;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1731005224 ^ -1731004380) + 107;
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
      return var1 != null ? var3 != 0 : var3 != (1204174387 ^ 1204171471);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{96, 121, 113, 34, 68, 41, 119, 66, 72, 118, 62, 77, 20, 125, 76, 107, 108}, 116)
               + YieldKeeper.v(new byte[]{123, 98, -57, -78, -118, 12}, 47)
               + YieldKeeper.v(new byte[]{96}, 58)
               + QueryZone.r(new byte[]{81, 59}, 73))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 45;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 45;
            var8 = var2;
         } else {
            var3 = 45;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 45;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 108;
               case 1 -> 77;
               case 2 -> 70;
               case 3 -> 24;
               case 4 -> 101;
               case 5 -> 8;
               default -> 81;
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
