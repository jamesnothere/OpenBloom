package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class BufferEncoder extends PacketContainer<CalculateRange> {
   private static int[] a;
   private static int b = 0;

   @Override
   public Class<CalculateRange> a() {
      if (b != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return CalculateRange.class;
   }

   public void a(CalculateRange var1) {
      if (b != 0) {
         System.nanoTime();
      }

      var1.a(this);
   }

   public static void b(int[] var0) {
      if (b != 0) {
         new Object().hashCode();
      }

      a = var0;
   }

   public static int[] e() {
      return a;
   }

   static {
      if (e() != null) {
         b(new int[5]);
      }
   }
}
