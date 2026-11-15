package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

public class NodeKeeper {
   private static final MinecraftClient b = MinecraftClient.getInstance();
   private static int c = 0;

   public static boolean a(BlockPos var0) {
      if (c != 0) {
         System.nanoTime();
      }

      int var1 = InitExecutor.c();
      if (b.world == null) {
         return false;
      }

      BlockPos var2 = var0.up();
      BlockPos var3 = var0.up(2);
      boolean var4 = b.world.getBlockState(var2).isAir();
      if (var1 == 0) {
         if (!var4) {
            return false;
         }

         var4 = b.world.getBlockState(var3).isAir();
      }

      if (var1 == 0) {
         if (var4) {
            Box var5 = new Box(var2.getX(), var2.getY(), var2.getZ(), var2.getX() + 1, var2.getY() + 2, var2.getZ() + 1);
            Iterator var6 = b.world.getOtherEntities(null, var5).iterator();

            while (true) {
               if (var6.hasNext()) {
                  Entity var7 = (Entity)var6.next();
                  var4 = var7.isAlive();
                  if (var1 != 0) {
                     break;
                  }

                  if (var1 != 0) {
                     return var4;
                  }

                  if (var4) {
                     return false;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               }

               var4 = true;
               break;
            }

            return var4;
         }

         var4 = false;
      }

      return var4;
   }

   public static boolean b(BlockPos var0) {
      if (c != 0) {
         new Object().hashCode();
      }

      if (b.world == null) {
         return false;
      }

      BlockState var1 = b.world.getBlockState(var0);
      return (var1.isOf(Blocks.OBSIDIAN) || var1.isOf(Blocks.BEDROCK)) && a(var0);
   }
}
