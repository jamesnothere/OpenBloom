package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class CheckerBridge extends InitAdapter {
   private boolean a99;
   private static int b;
   private static int c = 0;

   public CheckerBridge(String var1, boolean var2) {
      super(var1);
      this.a99 = var2;
   }

   public Boolean f() {
      if (c != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return this.a99;
   }

   @Override
   public Object c() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.f();
   }

   @Override
   public void a(Object var1) {
      if (c != 0) {
         System.nanoTime();
      }

      if (var1 instanceof Boolean) {
         this.a99 = (Boolean)var1;
      }
   }

   public void g() {
      if (c != 0) {
         new Object().hashCode();
      }

      int var1 = BlockCalculator.n();
      boolean var2 = this.a99;
      if (var1 == 0) {
         var2 = !this.a99;
      }

      this.a99 = var2;
   }

   public static void a(int var0) {
      if (c != 0) {
         new Object().hashCode();
      }

      b = var0;
   }

   public static int h() {
      return b;
   }

   public static int i() {
      if (c != 0) {
         new Object().hashCode();
      }

      int var0 = h();
      return var0 == 0 ? 116 : 0;
   }

   static {
      if (i() == 0) {
         a(3);
      }
   }
}
