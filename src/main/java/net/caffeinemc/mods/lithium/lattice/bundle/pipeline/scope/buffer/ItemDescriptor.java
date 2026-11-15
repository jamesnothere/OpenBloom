package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class ItemDescriptor extends InitAdapter {
   public int d99;
   private final boolean a99;
   private boolean b99 = false;
   private static int c = 0;

   public ItemDescriptor(String var1, int var2, boolean var3) {
      super(var1);
      this.d99 = var2;
      this.a99 = var3;
   }

   public Integer f() {
      if (c != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return this.d99;
   }

   @Override
   public Object c() {
      if (c != 0) {
         System.nanoTime();
      }

      return this.f();
   }

   @Override
   public void a(Object var1) {
      if (c != 0) {
         System.nanoTime();
      }

      if (var1 instanceof Number) {
         this.d99 = ((Number)var1).intValue();
      }
   }

   public int g() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.d99;
   }

   public void a(int var1) {
      if (c != 0) {
         System.nanoTime();
      }

      this.d99 = var1;
   }

   public boolean i() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.a99;
   }

   public void a(boolean var1) {
      if (c != 0) {
         System.nanoTime();
      }

      this.b99 = var1;
   }
}
