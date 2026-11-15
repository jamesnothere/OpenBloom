package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class InventorySlotMapper {
   private static final int c = 658;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 2037047220 ^ 2037046566) + 21;
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
      return var1 != null ? var3 != 0 : var3 != (-504068403 ^ -504069025);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (NotifyResolver.q(new byte[]{51, 55, 91, 49, 85, 36, 118, 57, 97, 43, 85, 61, -83, -39, -33, -55, 89, 25}, 71)
               + TokenExtractor.w(new byte[]{60, 13}, 32)
               + NotifyResolver.q(new byte[]{-97, -98, -90, -60}, 147))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 83;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 83;
            var8 = var2;
         } else {
            var3 = 83;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 83;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 110;
               case 1 -> 76;
               case 2 -> 61;
               case 3 -> 73;
               case 4 -> 63;
               case 5 -> 93;
               default -> 41;
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
