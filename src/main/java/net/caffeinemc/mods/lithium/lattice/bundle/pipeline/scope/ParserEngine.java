package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public enum ParserEngine {
   CT(JoinerWriter.p(new byte[]{-118, -75, -78, -90, -92, -74}, 185)),
   Z3(TokenExtractor.w(new byte[]{-23, -39, -45, -38, -38, -46}, 176)),
   V2(
      TokenExtractor.w(new byte[]{-30, -56, -55, -63, -51, -63, -40, -40, -97, -13, -42, -36}, 173)
         + JoinerWriter.p(new byte[]{-38, -48}, 155)
         + TokenExtractor.w(new byte[]{-62, -43}, 173)
   ),
   Z4(TokenExtractor.w(new byte[]{-57, -30, -5, -22}, 130)),
   PC(YieldKeeper.v(new byte[]{121, 61, 15, -124, -114, -98, 122, 41, 5, -23}, 41));

   public final char[] a;
   public final int aK;
   private static int[] d;
   private static int f = 0;

   ParserEngine(String var3) {
      this.aK = var3.hashCode() * 31 + 17;
      this.a = a(var3, this.aK);
   }

   public String a() {
      if (f != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      char[] var1 = new char[this.a.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (char)(this.a[var2] ^ this.aK + var2 * 31);
      }

      return new String(var1);
   }

   @Override
   public String toString() {
      if (f != 0) {
         System.nanoTime();
      }

      return this.a();
   }

   private static char[] a(String var0, int var1) {
      if (f != 0) {
         Thread.currentThread().getName().length();
      }

      char[] var2 = var0.toCharArray();
      char[] var3 = new char[var2.length];

      for (int var4 = 0; var4 < var2.length; var4++) {
         var3[var4] = (char)(var2[var4] ^ var1 + var4 * 31);
      }

      return var3;
   }

   public static void b(int[] var0) {
      if (f != 0) {
         System.nanoTime();
      }

      d = var0;
   }

   static {
      b(new int[1]);
   }
}
