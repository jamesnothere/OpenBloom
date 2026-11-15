package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;

public class ComposterFillHelper {
   private static final int c = 6951;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 127227517 ^ 127225178) + (1669586452 ^ 1669586676);
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
      return var1 != null ? var3 != 0 : var3 != (-718572043 ^ -718573870);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (StringDecoder.d(new byte[]{99, 127, 73, 38, 18, 79, 35, 66, 107, 105, 54}, 61)
               + YieldKeeper.v(new byte[]{12, 32, 72, -24}, 36)
               + YieldKeeper.v(new byte[]{110, 55, -121, -114, -62, 14, 110, 114, -75}, 46))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 85;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 85;
            var8 = var2;
         } else {
            var3 = 85;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 85;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 72;
               case 1 -> 121;
               case 2 -> 78;
               case 3 -> 61;
               case 4 -> 17;
               case 5 -> 81;
               default -> 57;
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
