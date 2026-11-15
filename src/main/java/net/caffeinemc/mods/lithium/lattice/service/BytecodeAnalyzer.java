package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public class BytecodeAnalyzer {
   private static final int c = 4564;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1924857650 ^ -1924853478) + (430303390 ^ 430303245);
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
      return var1 != null ? var3 != 0 : var3 != (-1550046613 ^ -1550042177);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = (TokenExtractor.w(new byte[]{-80, -11, -85, -87, -108, -71, -43, -112, -44, -86, -76, -124, -74}, 135)
               + QueryZone.r(new byte[]{109, 62}, 44)
               + NotifyResolver.q(new byte[]{83, 80, 17, 103}, 35)
               + NotifyResolver.q(new byte[]{-79, -54}, 195))
            .toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 22;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 22;
            var8 = var2;
         } else {
            var3 = 22;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 22;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 107;
               case 1 -> 20;
               case 2 -> 68;
               case 3 -> 86;
               case 4 -> 106;
               case 5 -> 74;
               default -> 46;
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
