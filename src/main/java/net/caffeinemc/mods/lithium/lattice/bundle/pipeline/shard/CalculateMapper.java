package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;

public class CalculateMapper {
   private static final Random b = new Random();
   private static int c = 0;

   public static int a(int var0, int var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      byte var5 = 0;

      while (true) {
         switch (var5) {
            case 0:
            default:
               if (c != 0) {
                  Thread.currentThread().getName().length();
                  var5 = 2;
                  break;
               }
            case 2:
               var2 = InitExecutor.b();
               var3 = var0;
               var4 = var1;
               if (var2 == 0) {
                  return var3 + var4;
               }

               if (var0 >= var1) {
                  return var0;
               }
            case 3:
               var3 = var0;
               var4 = b.nextInt(var1 - var0 + 1);
               var5 = 1;
               break;
            case 1:
               return var3 + var4;
         }
      }
   }
}
