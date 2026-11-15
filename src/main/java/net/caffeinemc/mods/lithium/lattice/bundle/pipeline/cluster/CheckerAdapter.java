package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class CheckerAdapter extends PacketContainer<InitNotifier> {
   private static int a = 0;

   @Override
   public Class<InitNotifier> a() {
      if (a != 0) {
         Thread.currentThread().getName().length();
      }

      return InitNotifier.class;
   }

   public void a(InitNotifier var1) {
      if (a != 0) {
         new Object().hashCode();
      }

      var1.a();
   }
}
