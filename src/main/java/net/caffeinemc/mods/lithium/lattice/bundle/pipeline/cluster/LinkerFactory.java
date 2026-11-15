package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class LinkerFactory extends PacketContainer<CoreSerializer> {
   private static int a = 0;

   @Override
   public Class<CoreSerializer> a() {
      if (a != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return CoreSerializer.class;
   }

   public void a(CoreSerializer var1) {
      if (a != 0) {
         Thread.currentThread().getName().length();
      }

      var1.a(this);
   }
}
