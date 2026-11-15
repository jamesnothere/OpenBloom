package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class DialEntry extends BlockCalculator {
   public static final int DAY = 24000;
   private static int d99 = 0;

   public DialEntry(String var1, double var2) {
      super(var1, 0.0, 23999.0, var2, 1.0);
   }

   public int a99() {
      if (d99 != 0) {
         new Object().hashCode();
      }

      int var1 = (int)Math.round(this.f());
      return (var1 % (-550497320 ^ -550482408) + (-1180856681 ^ -1180839081)) % (-840406800 ^ -840420048);
   }

   public void b(double var1) {
      if (d99 != 0) {
         System.nanoTime();
      }

      double var3 = (var1 % 24000.0 + 24000.0) % 24000.0;
      this.a(Math.floor(var3));
   }

   public static String c(int var0) {
      if (d99 != 0) {
         new Object().hashCode();
      }

      int var1 = (int)((var0 + 6000L) % 24000L * 1440L / 24000L);
      int var2 = var1 / 60;
      var1 %= 60;
      StringBuilder var3 = new StringBuilder(5);
      if (var2 < 10) {
         var3.append('0');
      }

      var3.append(var2).append(':');
      if (var1 < 10) {
         var3.append('0');
      }

      return var3.append(var1).toString();
   }
}
