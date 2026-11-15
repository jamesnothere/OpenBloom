package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class BidiReorderHelper {
   private static final int c = 5897;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -308033472 ^ -308027575) + (698834477 ^ 698834579);
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
      return var1 != null ? var3 != 0 : var3 != (-949465370 ^ -949462545);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (YieldKeeper.v(new byte[]{-99, 34, -54}, 156)
               + TokenExtractor.w(new byte[]{-34, -87, -67, -21, -109, -76, -93}, 172)
               + QueryZone.r(new byte[]{-17, -111, -125, -34, -93, -65, -86, -118, -98, -124, -51, -84}, 143))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 1;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 1;
            var8 = var2;
         } else {
            var3 = 1;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 1;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 66;
               case 1 -> 114;
               case 2 -> 123;
               case 3 -> 16;
               case 4 -> 93;
               case 5 -> 121;
               default -> 36;
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
