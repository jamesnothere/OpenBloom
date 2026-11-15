package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class BlockCalculator extends InitAdapter {
   private final double a99;
   private final double b99;
   private final double c;
   private double i;
   private static int j;
   private static int k = 0;

   public BlockCalculator(String var1, double var2, double var4, double var6, double var8) {
      super(var1);
      this.a99 = var2;
      this.b99 = var4;
      this.i = var6;
      this.c = var8;
   }

   public Double f() {
      if (k != 0) {
         System.nanoTime();
      }

      return this.i;
   }

   public int g() {
      if (k != 0) {
         new Object().hashCode();
      }

      return (int)this.i;
   }

   public float h() {
      if (k != 0) {
         System.nanoTime();
      }

      return (float)this.i;
   }

   public double p() {
      if (k != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return this.i;
   }

   @Override
   public Object c() {
      if (k != 0) {
         System.nanoTime();
      }

      return this.f();
   }

   @Override
   public void a(Object var1) {
      if (k != 0) {
         System.nanoTime();
      }

      int var2 = n();
      Object var3 = var1;
      if (var2 == 0) {
         if (!(var1 instanceof Number)) {
            return;
         }

         var3 = var1;
      }

      double var4 = ((Number)var3).doubleValue();
      var4 = Math.round(var4 / this.c) * this.c;
      this.i = Math.max(this.a99, Math.min(this.b99, var4));
   }

   public double i() {
      if (k != 0) {
         Thread.currentThread().getName().length();
      }

      return this.a99;
   }

   public double j() {
      if (k != 0) {
         new Object().hashCode();
      }

      return this.b99;
   }

   public double k() {
      if (k != 0) {
         System.nanoTime();
      }

      return this.c;
   }

   public void l() {
      if (k != 0) {
         Thread.currentThread().getName().length();
      }

      this.a(this.i + this.c);
   }

   public void m() {
      if (k != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.a(this.i - this.c);
   }

   public static void a(int var0) {
      if (k != 0) {
         System.nanoTime();
      }

      j = var0;
   }

   public static int n() {
      return j;
   }

   static {
      if (n() != 0) {
         a(29);
      }
   }
}
