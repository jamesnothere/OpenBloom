package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class RaycastHelper {
   private static final int c = 5277;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1016878012 ^ -1016874791) + (-1045509824 ^ -1045509654);
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
      return var1 != null ? var3 != 0 : var3 != (-87767289 ^ -87764070);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{54, 57, 40, 79, 47, 120, 26, 39, 52, 58, 69, 48, 96}, 100)
               + QueryZone.r(new byte[]{18}, 55)
               + YieldKeeper.v(new byte[]{3, -20}, 115)
               + TokenExtractor.w(new byte[]{24, 123}, 11))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 24;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 24;
            var8 = var2;
         } else {
            var3 = 24;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 24;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 30;
               case 1 -> 35;
               case 2 -> 37;
               case 3 -> 89;
               case 4 -> 56;
               case 5 -> 124;
               default -> 30;
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
