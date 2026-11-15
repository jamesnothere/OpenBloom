package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class TextEntry extends InitAdapter {
   private String a99;
   private final int b;
   private static int c = 0;

   public TextEntry(String var1, String var2, int var3) {
      super(var1);
      this.b = var3;
      this.a99 = var2 == null ? "" : var2;
   }

   public String f() {
      if (c != 0) {
         new Object().hashCode();
      }

      return this.a99;
   }

   public int g() {
      if (c != 0) {
         System.nanoTime();
      }

      return this.b;
   }

   public void b(String var1) {
      if (c != 0) {
         new Object().hashCode();
      }

      if (var1 == null) {
         var1 = "";
      }

      if (var1.length() > this.b) {
         var1 = var1.substring(0, this.b);
      }

      this.a99 = var1;
   }

   @Override
   public Object c() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.a99;
   }

   @Override
   public void a(Object var1) {
      if (c != 0) {
         new Object().hashCode();
      }

      if (var1 instanceof String) {
         this.b((String)var1);
      }
   }
}
