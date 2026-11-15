package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class ParticleEffectPool {
   private static final int c = 968;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1044198958 ^ -1044198886) + 31;
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
      return var1 != null ? var3 != 0 : var3 != (-235794604 ^ -235795300);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = NotifyResolver.q(new byte[]{127, 26, 72, 66, 116, 4, 61, 123, 127, 9, 61, 17, -115, -88, -69, -12, 81, 114, 105, 97, -44, -72, -82}, 70)
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
               case 0 -> 61;
               case 1 -> 104;
               case 2 -> 44;
               case 3 -> 45;
               case 4 -> 31;
               case 5 -> 108;
               default -> 103;
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
