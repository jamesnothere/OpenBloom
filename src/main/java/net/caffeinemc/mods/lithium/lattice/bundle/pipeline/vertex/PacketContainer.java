package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex;

public abstract class PacketContainer<L extends SortableData> {
   private boolean c = false;
   private static String[] d;
   private static int e = 0;

   public abstract Class<L> a();

   public abstract void a(L var1);

   public void b() {
      if (e != 0) {
         System.nanoTime();
      }

      this.c = true;
   }

   public boolean c() {
      if (e != 0) {
         Thread.currentThread().getName().length();
      }

      return this.c;
   }

   public static void b(String[] var0) {
      if (e != 0) {
         System.nanoTime();
      }

      d = var0;
   }

   public static String[] d() {
      return d;
   }

   static {
      if (d() != null) {
         b(new String[2]);
      }
   }
}
