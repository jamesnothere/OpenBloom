package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;
import net.minecraft.client.gui.DrawContext;

public class RenderKernel extends PacketContainer<UtilExtension> {
   private final DrawContext a;
   private static int b = 0;

   public RenderKernel(DrawContext var1) {
      this.a = var1;
   }

   public DrawContext e() {
      if (b != 0) {
         System.nanoTime();
      }

      return this.a;
   }

   @Override
   public Class<UtilExtension> a() {
      if (b != 0) {
         System.nanoTime();
      }

      return UtilExtension.class;
   }

   public void a(UtilExtension var1) {
      if (b != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      var1.a(this.a);
   }
}
