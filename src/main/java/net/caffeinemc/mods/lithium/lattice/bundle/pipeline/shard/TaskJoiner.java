package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

public class TaskJoiner {
   private static final MinecraftClient b = MinecraftClient.getInstance();
   private static int c = 0;

   public static boolean a(BlockPos var0, Block var1) {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return b.world == null ? false : b.world.getBlockState(var0).getBlock() == var1;
   }

   public static boolean b(BlockPos var0) {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      if (b.world == null) {
         return false;
      }

      Block var1 = b.world.getBlockState(var0).getBlock();
      return var1 == Blocks.OBSIDIAN || var1 == Blocks.BEDROCK;
   }

   public static void a(BlockHitResult var0, boolean var1) {
      if (c != 0) {
         new Object().hashCode();
      }

      int var2 = InitExecutor.b();
      MinecraftClient var3 = b;
      if (var2 != 0) {
         if (b.player == null) {
            return;
         }

         var3 = b;
      }

      label37: {
         ClientPlayerInteractionManager var4 = var3.interactionManager;
         if (var2 != 0) {
            if (var3.interactionManager == null) {
               return;
            }

            var3 = b;
            if (var2 == 0) {
               break label37;
            }

            var4 = b.interactionManager;
         }

         var4.interactBlock(b.player, Hand.MAIN_HAND, var0);
         if (!var1) {
            return;
         }

         var3 = b;
      }

      var3.player.swingHand(Hand.MAIN_HAND);
   }
}
