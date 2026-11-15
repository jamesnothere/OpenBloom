package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.Random;

public abstract class InitAdapter {
   public char[] a;
   public int aK;
   private static int b;
   private static final Random d = new Random();
   private static int e = 0;

   public InitAdapter(String var1) {
      this.aK = d.nextInt();
      this.a = a(var1, this.aK);
   }

   public String a() {
      if (e != 0) {
         System.nanoTime();
      }

      char[] var1 = new char[this.a.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (char)(this.a[var2] ^ this.aK + var2 * 31);
      }

      return new String(var1);
   }

   public int labelLen() {
      if (e != 0) {
         Thread.currentThread().getName().length();
      }

      return this.a.length;
   }

   public void n(char[] var1, int var2) {
      if (e != 0) {
         System.nanoTime();
      }

      this.a = var1;
      this.aK = var2;
   }

   public abstract Object c();

   public abstract void a(Object var1);

   public static void b(int var0) {
      if (e != 0) {
         System.nanoTime();
      }

      b = var0;
   }

   public static int d() {
      return b;
   }

   public static int e() {
      if (e != 0) {
         System.nanoTime();
      }

      int var0 = d();
      return var0 == 0 ? 47 : 0;
   }

   private static char[] a(String var0, int var1) {
      if (e != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var0 == null) {
         var0 = "";
      }

      char[] var2 = var0.toCharArray();
      char[] var3 = new char[var2.length];

      for (int var4 = 0; var4 < var2.length; var4++) {
         var3[var4] = (char)(var2[var4] ^ var1 + var4 * 31);
      }

      return var3;
   }

   static {
      if (d() != 0) {
         b(29);
      }
   }
}
