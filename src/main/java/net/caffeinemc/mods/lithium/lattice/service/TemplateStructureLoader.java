package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;

public class TemplateStructureLoader {
   private static final int c = 1929;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1750769857 ^ 1750771528) + 62;
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
      return var1 != null ? var3 != 0 : var3 != (-181875800 ^ -181875679);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = StringDecoder.d(
               new byte[]{
                  -10, -55, -2, -93, -32, -82, -57, -64, -10, -20, -88, -10, -91, -52, -39, -48, -28, -115, -11, -72, -59, -46, -55, -90, -66, -96, -2, -98
               },
               163
            )
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 73;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 73;
            var8 = var2;
         } else {
            var3 = 73;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 73;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 72;
               case 1 -> 71;
               case 2 -> 123;
               case 3 -> 58;
               case 4 -> 98;
               case 5 -> 32;
               default -> 95;
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
