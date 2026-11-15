package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;

public class ShapeVoxelHelper {
   private static final int c = 5339;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -2037349473 ^ -2037344444) + (-1758942347 ^ -1758942247);
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
      return var1 != null ? var3 != 0 : var3 != (974761040 ^ 974764171);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (JoinerWriter.p(new byte[]{123, -52, 121}, 136)
               + JoinerWriter.p(new byte[]{-56, -103}, 183)
               + StringDecoder.d(new byte[]{-79, -81, -6, -117, -38, -110, -121, -116, -71, -20, -107, -103, -91, -40, -57, -2}, 208))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 33;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 33;
            var8 = var2;
         } else {
            var3 = 33;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 33;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 113;
               case 1 -> 28;
               case 2 -> 67;
               case 3 -> 46;
               case 4 -> 21;
               case 5 -> 22;
               default -> 48;
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
