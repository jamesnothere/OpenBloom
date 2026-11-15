package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class TimingEntry extends BlockCalculator {
   private final double a99;
   private final double b99;
   private final boolean c99;
   private static int d99 = 0;

   public TimingEntry(String var1, double var2, double var4, double var6, double var8) {
      this(var1, var2, var4, var6, var8, 50.0, 0.0);
   }

   public TimingEntry(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6, var8, var10, var12, false);
   }

   public TimingEntry(String var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean var14) {
      super(var1, var2, var4, var6, var8);
      this.a99 = var10;
      this.b99 = var12;
      this.c99 = var14;
   }

   public long ns() {
      if (d99 != 0) {
         Thread.currentThread().getName().length();
      }

      return (long)(this.p() * 1000000.0);
   }

   public void fromOld(double var1) {
      if (d99 != 0) {
         new Object().hashCode();
      }

      double var3 = this.c99 ? Math.floor(var1) : var1;
      this.a(var3 * this.a99 + this.b99);
   }

   public String save() {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return num(this.p()) + QueryZone.r(new byte[]{6, 17}, 104);
   }

   public void load(boolean var1, String var2) {
      if (d99 != 0) {
         new Object().hashCode();
      }

      if (var1) {
         this.fromOld(Double.parseDouble(var2));
      } else {
         String var3 = strip(var2);
         int var4 = var3.indexOf(45, 1);
         if (var4 > 0) {
            var3 = var3.substring(0, var4);
         }

         this.a(Double.parseDouble(var3.trim()));
      }
   }

   static String num(double var0) {
      if (d99 != 0) {
         System.nanoTime();
      }

      return var0 == Math.rint(var0) && Math.abs(var0) < 1.0E15 ? Long.toString((long)var0) : Double.toString(var0);
   }

   static String strip(String var0) {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      String var1 = var0.trim();
      int var2 = var1.length();
      if (var2 >= 2 && (var1.charAt(var2 - 1) == 's' || var1.charAt(var2 - 1) == 'S') && (var1.charAt(var2 - 2) == 'm' || var1.charAt(var2 - 2) == 'M')) {
         var1 = var1.substring(0, var2 - 2);
      }

      return var1.trim();
   }

   @Override
   public String a() {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.a();
   }

   @Override
   public Double f() {
      if (d99 != 0) {
         new Object().hashCode();
      }

      return super.f();
   }

   @Override
   public int g() {
      if (d99 != 0) {
         System.nanoTime();
      }

      return super.g();
   }

   @Override
   public float h() {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.h();
   }

   @Override
   public double p() {
      if (d99 != 0) {
         new Object().hashCode();
      }

      return super.p();
   }

   @Override
   public double i() {
      if (d99 != 0) {
         new Object().hashCode();
      }

      return super.i();
   }

   @Override
   public double j() {
      if (d99 != 0) {
         System.nanoTime();
      }

      return super.j();
   }

   @Override
   public double k() {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.k();
   }

   @Override
   public void l() {
      if (d99 != 0) {
         Thread.currentThread().getName().length();
      }

      super.l();
   }

   @Override
   public void m() {
      if (d99 != 0) {
         new Object().hashCode();
      }

      super.m();
   }

   @Override
   public Object c() {
      if (d99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.c();
   }

   @Override
   public int labelLen() {
      if (d99 != 0) {
         Thread.currentThread().getName().length();
      }

      return super.labelLen();
   }
}
