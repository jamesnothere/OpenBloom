package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import java.io.InputStream;
import java.util.HashMap;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextHandler;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImage.Format;
import net.minecraft.resource.Resource;
import net.minecraft.text.CharacterVisitor;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.StyleSpriteSource.Font;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2fStack;

public final class StyleKeyCache {
   public static final int GUI = 0;
   public static final int WHITE = 1;
   public static final int GOLD = 2;
   public static final int RED = 3;
   public static final int PINK = 4;
   public static final int ORANGE = 5;
   public static final int PRESETS = 6;
   private static final int[] al = new int[]{
      8218825,
      11905504,
      526349,
      16777215,
      16777215,
      1512987,
      15122522,
      15763548,
      592139,
      15745871,
      15745871,
      723210,
      16415930,
      13163242,
      526347,
      16742943,
      16751196,
      592138
   };
   public static int A;
   public static int A2;
   public static int P;
   public static int PA;
   public static int PANEL;
   public static int TILE;
   public static int ACC_TXT;
   public static int KEY_FILL;
   public static int KEY_TXT;
   public static int TRACK_A;
   public static int SEL_FILL;
   public static int GRAPH;
   public static int PETAL;
   public static int SHADOW;
   public static int gen = 0;
   public static final int TXT = -657929;
   public static final int TXT2 = -2631716;
   public static final int DIS = -4342334;
   public static final int GREY = -7434605;
   public static final int DIM = -9803152;
   public static final int DIVIDER = 520093695;
   public static final int BAR_TRACK = -536147185;
   public static final int HOVER = 452984831;
   public static final int DISC = 352321535;
   public static final int POLLEN = -10612;
   public static final int ARMOR = -11108136;
   public static final int ARMOR_LOW = -42406;
   public static final int HP = -2737088;
   public static final int HP_POISON = -7490758;
   public static final int HP_WITHER = -11908534;
   public static final int HP_FROZEN = -6630913;
   public static final int ABSORB = -1525446;
   public static final int GHOST = 1509949439;
   public static final int FOOD = -2256856;
   public static final int FOOD_HUNGER = -7693510;
   public static final int AIR = -10827526;
   public static final int MOUNT = -1944214;
   public static final int XP = -11875502;
   public static final int XP_TXT = -8462246;
   public static final int T_HP = -12599439;
   public static final int T_TRACK = 268435455;
   public static final int SLOTNUM = -8618878;
   public static final int HURT = -53200;
   public static final int D_ARMOR = -11559937;
   public static final int D_HP = -1031846;
   public static final int D_ABSORB = -670440;
   public static final int D_FOOD = -681426;
   public static final int D_EMPTY = 452984831;
   public static final int D_SEL = -986894;
   public static final int D_SLOTNUM = -3618612;
   public static final int PIP_ARMOR = d(-11559937);
   public static final int PIP_HP = d(-1031846);
   public static final int PIP_ABSORB = d(-670440);
   public static final int PIP_FOOD = d(-681426);
   public static final int PIP_EMPTY = d(452984831);
   private static int am = -1;
   private static int an = -1;
   private static int ao = -1;
   private static int ap = -1;
   private static int aq;
   private static int ar;
   private static int as;
   private static long at = 0L;
   private static boolean au = false;
   public static final int XS = 0;
   public static final int S = 1;
   public static final int BS = 2;
   public static final int B = 3;
   public static final int BR = 4;
   public static final int T = 5;
   public static final int L = 6;
   public static final int LR = 7;
   public static final int LB = 8;
   public static final int XLB = 9;
   public static final int XL = 10;
   public static final int XLH = 11;
   public static final int ROLES = 12;
   public static final int LEFT = 0;
   public static final int CENTER = 1;
   public static final int RIGHT = 2;
   private static final String[] av = new String[]{
      JoinerWriter.p(new byte[]{-28, -34}, 148),
      NotifyResolver.q(new byte[]{97}, 18),
      NotifyResolver.q(new byte[]{39, 55}, 69),
      YieldKeeper.v(new byte[]{58}, 88),
      QueryZone.r(new byte[]{46, 55}, 79),
      StringDecoder.d(new byte[]{34}, 86),
      NotifyResolver.q(new byte[]{0}, 108),
      TokenExtractor.w(new byte[]{-10, -21}, 147),
      NotifyResolver.q(new byte[]{-52, -61}, 160),
      StringDecoder.d(new byte[]{65, 84, 89}, 57),
      YieldKeeper.v(new byte[]{74, 8}, 50),
      TokenExtractor.w(new byte[]{77, 94, 91}, 54)
   };
   private static final String[] aw = new String[]{
      StringDecoder.d(new byte[]{18, 19, 16}, 60),
      NotifyResolver.q(new byte[]{104, 81, 73, 93}, 63)
         + JoinerWriter.p(new byte[]{58, 70, 0, 30, 58, 68, 55, 55, 66, 57}, 43)
         + NotifyResolver.q(new byte[]{6, 99, 76, 77, 85, 65}, 43),
      StringDecoder.d(new byte[]{87, 83, 77, 80, 86, 75, 80, 17, 91, 71, 85, 2, 26, 95, 86, 91, 69, 89}, 59)
   };
   private static final int ax = 0;
   private static final int ay = 1;
   private static final int az = 2;
   public static final Style[][] STYLES = new Style[12][3];
   public static final Style[] ST = new Style[12];
   public static int MAG = 2;
   public static float PX = 0.5F;
   public static int ba = 0;
   public static int bb = 0;
   private static long bc = 0L;
   private static final HashMap<String, Text>[] bd = new HashMap[12];
   private static final Object2FloatOpenHashMap<String>[] be = new Object2FloatOpenHashMap[12];
   private static final int bf = 512;
   private static final int bg = 128;
   private static final int bh = 4;
   private static final String[] bi;
   private static final String[] bj;
   private static final float[] bk;
   private static final int[] bl;
   private static final int[] bm;
   private static final OrderedText[] bn;
   private static final OrderedText[] bo;
   private static final float[] bp;
   private static final int[] bq;
   private static final int[] br;
   private static int bs;
   private static TextHandler bt;
   private static float bu;
   private static float bv;
   private static int bw;
   private static int bx;
   private static final CharacterVisitor by;
   private static int[] bz;
   private static Style[] ca;
   private static int cb;
   private static int cc;
   private static final CharacterVisitor cd;
   private static final Identifier ce;
   private static final int cf = 2368;
   private static final int cg = 128;
   private static final int ch = 5;
   private static volatile NativeImage[] ci;
   private static volatile int[] cj;
   private static volatile boolean ck;
   private static boolean cl;
   private static boolean cm;
   private static boolean cn;
   private static final Identifier co;
   private static final Identifier cp;
   private static final int cq = 256;
   private static boolean cr;
   private static boolean cs;
   private static int cu = 0;

   private StyleKeyCache() {
   }

   public static void a(int var0, int var1) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var0 < 0 || var0 >= 6) {
         var0 = 0;
      }

      int var2 = var1 < 0 ? 0 : (var1 > 100 ? 100 : var1);
      int var3;
      int var6;
      if (var0 == 0) {
         int[] var7 = ThemeCache.e();
         int[] var8 = ThemeCache.f();
         var3 = (var7[0] & (-569202773 ^ -569202860)) << 16 | (var7[1] & (1117108252 ^ 1117108451)) << 8 | var7[2] & (1519814143 ^ 1519813888);
         var6 = (var8[0] & (1657062579 ^ 1657062476)) << 16 | (var8[1] & (-1688783528 ^ -1688783449)) << 8 | var8[2] & (1106268320 ^ 1106268255);
      } else {
         var3 = al[var0 * 3];
         var6 = -2 - var0;
      }

      if (var0 != am || au || var3 != an || var6 != ao || var2 != ap) {
         int var4;
         int var5;
         if (var0 == 0) {
            var4 = c(var3, 906321376 ^ 922395167, 0.45F);
            var5 = c(var6, 0, 0.25F);
         } else {
            var4 = al[var0 * 3 + 1];
            var5 = al[var0 * 3 + 2];
         }

         if (var0 != am) {
            if (am >= 0) {
               aq = A & (1494883217 ^ 1508238446);
               ar = A2 & (-1165263556 ^ -1166769469);
               as = P & (1695063584 ^ 1710711263);
               at = System.nanoTime();
               au = true;
            }

            am = var0;
         }

         an = var3;
         ao = var6;
         ap = var2;
         if (au) {
            float var9 = (float)(System.nanoTime() - at) / 2.8E8F;
            if (!(var9 >= 1.0F) && !(var9 < 0.0F)) {
               float var10 = 1.0F - (1.0F - var9) * (1.0F - var9);
               var3 = c(aq, var3, var10);
               var4 = c(ar, var4, var10);
               var5 = c(as, var5, var10);
            } else {
               au = false;
            }
         }

         if ((A & (80776072 ^ 70218871)) != var3
            || (A2 & (40375393 ^ 43510686)) != var4
            || (P & (1194023278 ^ 1205118609)) != var5
            || PA != Math.round(2.55F * var2)) {
            b(var3, var4, var5, var2);
         }
      }
   }

   private static void b(int var0, int var1, int var2, int var3) {
      if (cu != 0) {
         System.nanoTime();
      }

      int var4 = Math.round(2.55F * var3);
      var4 = var4 < 0 ? 0 : (var4 > (-1699922373 ^ -1699922236) ? -1736877400 ^ -1736877481 : var4);
      PA = var4;
      A = 120556536 ^ -131101704 | var0;
      A2 = -400621325 ^ 387907827 | var1;
      P = -186417065 ^ 199458903 | var2;
      PANEL = var4 << 24 | var2;
      TILE = var4 << 24 | 1119158564 ^ 1118245640;
      ACC_TXT = 1435303406 ^ -1433600530 | c(var0, 1428269743 ^ 1440634192, 0.12F);
      KEY_FILL = -245541123 ^ -1470277891 | var0;
      KEY_TXT = 1908813805 ^ -1899614227 | c(var0, -1053197476 ^ -1043954525, 0.35F);
      TRACK_A = 997104208 ^ 57580112 | var0;
      SEL_FILL = -1536485207 ^ 1533745321 | c(var2, var0, 0.08F);
      GRAPH = -1706363931 ^ 2051732453 | c(-827140157 ^ -838442119, var0, 0.25F);
      PETAL = 110199268 ^ -107904540 | c(var0, 49577031 ^ 34325137, 0.55F);
      SHADOW = c(var2, 0, 0.55F);
      gen++;
   }

   private static int c(int var0, int var1, float var2) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      int var3 = (int)(
         (var0 >> 16 & (-1748220917 ^ -1748220684)) + ((var1 >> 16 & (1423579159 ^ 1423579368)) - (var0 >> 16 & (-646644361 ^ -646644344))) * var2 + 0.5F
      );
      int var4 = (int)(
         (var0 >> 8 & (406348507 ^ 406348324)) + ((var1 >> 8 & (-245721890 ^ -245722079)) - (var0 >> 8 & (-1028001170 ^ -1028001135))) * var2 + 0.5F
      );
      int var5 = (int)((var0 & (-1947778509 ^ -1947778356)) + ((var1 & (-1396139579 ^ -1396139718)) - (var0 & (662888286 ^ 662888353))) * var2 + 0.5F);
      return var3 << 16 | var4 << 8 | var5;
   }

   public static int d(int var0) {
      if (cu != 0) {
         System.nanoTime();
      }

      int var1 = Math.min(-2073211283 ^ -2073211246, Math.round((var0 >> 16 & (891819247 ^ 891819024)) * 255.0F / 214.0F));
      int var2 = Math.min(1168028018 ^ 1168028045, Math.round((var0 >> 8 & (-1199754293 ^ -1199754444)) * 255.0F / 214.0F));
      int var3 = Math.min(828448484 ^ 828448283, Math.round((var0 & (-1384165007 ^ -1384164978)) * 255.0F / 214.0F));
      return var0 & (1522332519 ^ -1514343577) | var1 << 16 | var2 << 8 | var3;
   }

   public static void e(int var0) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      var0 = var0 < 1 ? 1 : (var0 > 3 ? 3 : var0);
      long var1 = System.nanoTime();
      if (var0 != MAG) {
         MAG = var0;
         PX = 1.0F / var0;

         for (int var3 = 0; var3 < 12; var3++) {
            ST[var3] = STYLES[var3][var0 - 1];
            bd[var3].clear();
            be[var3].clear();
         }

         bc = var1;
         ba++;
         bb++;
      } else if (var1 - bc > 5000000000L) {
         bc = var1;

         for (int var5 = 0; var5 < 12; var5++) {
            be[var5].clear();
         }

         ba++;
      }
   }

   public static Text txt(int var0, String var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      HashMap var2 = bd[var0];
      Text var3 = (Text)var2.get(var1);
      if (var3 != null) {
         return var3;
      }

      if (var2.size() > (-1994897202 ^ -1994896690)) {
         var2.clear();
      }

      MutableText var4 = Text.literal(var1 == null ? "" : var1).setStyle(ST[var0]);
      var2.put(var1, var4);
      return var4;
   }

   public static MutableText lit(int var0, String var1) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return Text.literal(var1 == null ? "" : var1).setStyle(ST[var0]);
   }

   public static float f(int var0, String var1) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (var1 == null) {
         return 0.0F;
      }

      Object2FloatOpenHashMap var2 = be[var0];
      float var3 = var2.getFloat(var1);
      if (var3 >= 0.0F) {
         return var3;
      }

      var3 = MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(txt(var0, var1));
      if (var2.size() > (-1286897855 ^ -1286898367)) {
         var2.clear();
      }

      var2.put(var1, var3);
      return var3;
   }

   public static float g(Text var0) {
      if (cu != 0) {
         new Object().hashCode();
      }

      return var0 == null ? 0.0F : MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(var0);
   }

   public static float h(OrderedText var0) {
      if (cu != 0) {
         System.nanoTime();
      }

      return var0 == null ? 0.0F : MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(var0);
   }

   public static void i(DrawContext var0, Text var1, float var2, float var3, int var4, boolean var5) {
      if (cu != 0) {
         System.nanoTime();
      }

      int var6 = var4 >>> 24 & (733812323 ^ 733812380);
      if (var6 >= 5 && var1 != null) {
         TextRenderer var7 = MinecraftClient.getInstance().textRenderer;
         int var8 = MAG;
         float var9 = PX;
         Matrix3x2fStack var10 = var0.getMatrices();
         var10.pushMatrix();

         try {
            var10.translate((float)Math.round(var2 * var8) / var8, (float)Math.round((var3 - 7.0F) * var8) / var8);
            int var11 = (int)(var6 * 0.78F);
            if (var5 && var11 >= 5) {
               var10.translate(var9, var9);
               var0.drawText(var7, var1, 0, 0, var11 << 24 | SHADOW, false);
               var10.translate(-var9, -var9);
            }

            var0.drawText(var7, var1, 0, 0, var4, false);
         } finally {
            var10.popMatrix();
         }
      }
   }

   public static void j(DrawContext var0, OrderedText var1, float var2, float var3, int var4, boolean var5) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var6 = var4 >>> 24 & (1926050659 ^ 1926050716);
      if (var6 >= 5 && var1 != null) {
         TextRenderer var7 = MinecraftClient.getInstance().textRenderer;
         int var8 = MAG;
         float var9 = PX;
         Matrix3x2fStack var10 = var0.getMatrices();
         var10.pushMatrix();

         try {
            var10.translate((float)Math.round(var2 * var8) / var8, (float)Math.round((var3 - 7.0F) * var8) / var8);
            int var11 = (int)(var6 * 0.78F);
            if (var5 && var11 >= 5) {
               var10.translate(var9, var9);
               var0.drawText(var7, var1, 0, 0, var11 << 24 | SHADOW, false);
               var10.translate(-var9, -var9);
            }

            var0.drawText(var7, var1, 0, 0, var4, false);
         } finally {
            var10.popMatrix();
         }
      }
   }

   public static void k(DrawContext var0, Text var1, Text var2, float var3, float var4, int var5) {
      if (cu != 0) {
         new Object().hashCode();
      }

      int var6 = var5 >>> 24 & (-1645593723 ^ -1645593734);
      if (var6 >= 5 && var1 != null) {
         TextRenderer var7 = MinecraftClient.getInstance().textRenderer;
         int var8 = MAG;
         float var9 = PX;
         Matrix3x2fStack var10 = var0.getMatrices();
         var10.pushMatrix();

         try {
            var10.translate((float)Math.round(var3 * var8) / var8, (float)Math.round((var4 - 7.0F) * var8) / var8);
            int var11 = (int)(var6 * 0.78F);
            if (var2 != null && var11 >= 5) {
               var10.translate(var9, var9);
               var0.drawText(var7, var2, 0, 0, var11 << 24 | SHADOW, false);
               var10.translate(-var9, -var9);
            }

            var0.drawText(var7, var1, 0, 0, var5, false);
         } finally {
            var10.popMatrix();
         }
      }
   }

   public static void l(DrawContext var0, int var1, String var2, float var3, float var4, int var5, boolean var6) {
      if (cu != 0) {
         System.nanoTime();
      }

      int var7 = var5 >>> 24 & (1104180461 ^ 1104180242);
      if (var7 >= 5 && var2 != null) {
         Text var8 = bd[var1].get(var2);
         if (var8 == null) {
            var8 = txt(var1, var2);
         }

         TextRenderer var9 = MinecraftClient.getInstance().textRenderer;
         int var10 = MAG;
         float var11 = PX;
         Matrix3x2fStack var12 = var0.getMatrices();
         var12.pushMatrix();

         try {
            var12.translate((float)Math.round(var3 * var10) / var10, (float)Math.round((var4 - 7.0F) * var10) / var10);
            int var13 = (int)(var7 * 0.78F);
            if (var6 && var13 >= 5) {
               var12.translate(var11, var11);
               var0.drawText(var9, var8, 0, 0, var13 << 24 | SHADOW, false);
               var12.translate(-var11, -var11);
            }

            var0.drawText(var9, var8, 0, 0, var5, false);
         } finally {
            var12.popMatrix();
         }
      }
   }

   public static void m(DrawContext var0, int var1, String var2, float var3, float var4, int var5, int var6, boolean var7) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var8 = var6 >>> 24 & (-968366131 ^ -968366286);
      if (var8 >= 5 && var2 != null) {
         if (var5 != 0) {
            float var9 = be[var1].getFloat(var2);
            if (var9 < 0.0F) {
               var9 = f(var1, var2);
            }

            var3 -= var5 == 1 ? var9 * 0.5F : var9;
         }

         Text var18 = bd[var1].get(var2);
         if (var18 == null) {
            var18 = txt(var1, var2);
         }

         TextRenderer var10 = MinecraftClient.getInstance().textRenderer;
         int var11 = MAG;
         float var12 = PX;
         Matrix3x2fStack var13 = var0.getMatrices();
         var13.pushMatrix();

         try {
            var13.translate((float)Math.round(var3 * var11) / var11, (float)Math.round((var4 - 7.0F) * var11) / var11);
            int var14 = (int)(var8 * 0.78F);
            if (var7 && var14 >= 5) {
               var13.translate(var12, var12);
               var0.drawText(var10, var18, 0, 0, var14 << 24 | SHADOW, false);
               var13.translate(-var12, -var12);
            }

            var0.drawText(var10, var18, 0, 0, var6, false);
         } finally {
            var13.popMatrix();
         }
      }
   }

   private static int n(Object var0, int var1, float var2) {
      if (cu != 0) {
         new Object().hashCode();
      }

      int var3 = System.identityHashCode(var0) * 31 + var1 * (-863390462 ^ 1388235963) + Float.floatToIntBits(var2) * 17;
      var3 ^= var3 >>> 16;
      return var3 & 124;
   }

   public static String o(String var0, int var1, float var2) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (var0 == null) {
         return "";
      }

      int var3 = n(var0, var1, var2);
      int var4 = ba;

      for (int var5 = 0; var5 < 4; var5++) {
         int var6 = var3 + var5;
         if (bi[var6] == var0 && bk[var6] == var2 && bl[var6] == var1 && bm[var6] == var4) {
            return bj[var6];
         }
      }

      String var13 = var0;
      if (!var0.isEmpty() && f(var1, var0) > var2) {
         TextHandler var14 = MinecraftClient.getInstance().textRenderer.getTextHandler();
         Style var7 = ST[var1];
         String var8 = aw[0];
         float var9 = var2 - f(var1, var8);
         int var10 = 0;
         int var11 = var0.length() - 1;

         while (var10 < var11) {
            int var12 = var10 + var11 + 1 >>> 1;
            if (var14.getWidth(Text.literal(var0.substring(0, var12)).setStyle(var7)) <= var9) {
               var10 = var12;
            } else {
               var11 = var12 - 1;
            }
         }

         if (var10 > 0 && Character.isHighSurrogate(var0.charAt(var10 - 1))) {
            var10--;
         }

         while (var10 > 0 && var0.charAt(var10 - 1) == ' ') {
            var10--;
         }

         var13 = var0.substring(0, var10) + var8;
      }

      int var15 = var3 + (bs++ & 3);

      for (int var16 = 0; var16 < 4; var16++) {
         if (bm[var3 + var16] != var4 || bi[var3 + var16] == null) {
            var15 = var3 + var16;
            break;
         }
      }

      bi[var15] = var0;
      bj[var15] = var13;
      bk[var15] = var2;
      bl[var15] = var1;
      bm[var15] = var4;
      return var13;
   }

   public static OrderedText p(OrderedText var0, int var1, float var2) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (var0 == null) {
         return OrderedText.EMPTY;
      }

      int var3 = n(var0, var1, var2);
      int var4 = ba;

      for (int var5 = 0; var5 < 4; var5++) {
         int var6 = var3 + var5;
         if (bn[var6] == var0 && bp[var6] == var2 && bq[var6] == var1 && br[var6] == var4) {
            return bo[var6];
         }
      }

      TextHandler var9 = MinecraftClient.getInstance().textRenderer.getTextHandler();
      OrderedText var10 = var0;
      if (var9.getWidth(var0) > var2) {
         String var7 = aw[0];
         bt = var9;
         bu = 0.0F;
         bv = var2 - f(var1, var7);
         bw = 0;
         bx = 0;
         var0.accept(by);
         bt = null;
         var10 = q(var0, bx, var7, ST[var1]);
      }

      int var11 = var3 + (bs++ & 3);

      for (int var8 = 0; var8 < 4; var8++) {
         if (br[var3 + var8] != var4 || bn[var3 + var8] == null) {
            var11 = var3 + var8;
            break;
         }
      }

      bn[var11] = var0;
      bo[var11] = var10;
      bp[var11] = var2;
      bq[var11] = var1;
      br[var11] = var4;
      return var10;
   }

   private static OrderedText q(OrderedText var0, int var1, String var2, Style var3) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      int[] var4 = new int[var1];
      Style[] var5 = new Style[var1];
      bz = var4;
      ca = var5;
      cb = 0;
      cc = var1;

      try {
         var0.accept(cd);
      } finally {
         bz = null;
         ca = null;
      }

      int var6 = cb;
      Style var7 = var3;
      if (var6 > 0) {
         var7 = var5[var6 - 1];
      }

      Style var8 = var7;
      return var5x -> {
         int var6x = 0;
         byte var7x = 0;

         while (true) {
            switch (var7x) {
               case 0:
               default:
                  if (cu != 0) {
                     Thread.currentThread().getName().length();
                     var7x = 4;
                     continue;
                  }
               case 4:
                  var6x = 0;
                  var7x = 1;
                  continue;
               case 1:
                  if (var6x < var6) {
                     if (!var5x.accept(var6x, var5[var6x], var4[var6x])) {
                        return false;
                     }
                     break;
                  }
               case 3:
                  var6x = 0;
                  var7x = 6;
                  continue;
               case 2:
                  break;
               case 5:
                  return true;
               case 6:
                  if (var6x >= var2.length()) {
                     return true;
                  }

                  if (!var5x.accept(var6 + var6x, var8, var2.charAt(var6x))) {
                     return false;
                  }
               case 7:
                  var6x++;
                  var7x = 6;
                  continue;
            }

            var6x++;
            var7x = 1;
         }
      };
   }

   public static void r(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (!(var3 <= 0.0F) && !(var4 <= 0.0F) && var6 >>> 24 != 0) {
         int var7 = MAG;
         int var8 = Math.round(var1 * var7);
         int var9 = Math.round(var2 * var7);
         int var10 = Math.round((var1 + var3) * var7) - var8;
         int var11 = Math.round((var2 + var4) * var7) - var9;
         int var12 = Math.round(var5 * var7);
         Matrix3x2fStack var13 = var0.getMatrices();
         var13.pushMatrix();

         try {
            var13.scale(1.0F / var7, 1.0F / var7);
            RasterCache.l(var0, var8, var9, var10, var11, var12, var6, 1, true, true, true, true);
         } finally {
            var13.popMatrix();
         }
      }
   }

   public static void s(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {
      if (cu != 0) {
         System.nanoTime();
      }

      if (!(var3 <= 0.0F) && !(var4 <= 0.0F) && var5 >>> 24 != 0) {
         int var6 = MAG;
         int var7 = Math.round(var1 * var6);
         int var8 = Math.round(var2 * var6);
         int var9 = Math.round((var1 + var3) * var6) - var7;
         int var10 = Math.round((var2 + var4) * var6) - var8;
         Matrix3x2fStack var11 = var0.getMatrices();
         var11.pushMatrix();

         try {
            var11.scale(1.0F / var6, 1.0F / var6);
            RasterCache.l(var0, var7, var8, var9, var10, Math.min(var9, var10) >> 1, var5, 1, true, true, true, true);
         } finally {
            var11.popMatrix();
         }
      }
   }

   public static void t(DrawContext var0, float var1, float var2, float var3, int var4) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (!(var3 <= 0.0F) && var4 >>> 24 != 0) {
         int var5 = MAG;
         Matrix3x2fStack var6 = var0.getMatrices();
         if (!cn && !aa()) {
            int var19 = Math.max(1, Math.round(var3 * var5));
            int var20 = Math.round(var1 * var5 - var19 * 0.5F);
            int var21 = Math.round(var2 * var5 - var19 * 0.5F);
            var6.pushMatrix();

            try {
               var6.scale(1.0F / var5, 1.0F / var5);
               RasterCache.l(var0, var20, var21, var19, var19, var19 >> 1, var4, 1, true, true, true, true);
            } finally {
               var6.popMatrix();
            }
         } else {
            float var7 = var3 / 0.92F;
            int var8 = Math.max(1, Math.round(var7 * var5));
            int var9 = Math.round(var1 * var5 - var8 * 0.5F);
            int var10 = Math.round(var2 * var5 - var8 * 0.5F);
            var6.pushMatrix();

            try {
               var6.scale(1.0F / var5, 1.0F / var5);
               var0.drawTexture(
                  RenderPipelines.GUI_TEXTURED, ce, var9, var10, 1024.0F, 0.0F, var8, var8, 64, 64, 2036879163 ^ 2036876923, -1215744919 ^ -1215744791, var4
               );
            } finally {
               var6.popMatrix();
            }
         }
      }
   }

   public static void u(DrawContext var0, Identifier var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var1 != null && !(var4 <= 0.0F) && !(var5 <= 0.0F) && var8 >>> 24 != 0) {
         int var9 = MAG;
         int var10 = Math.round(var2 * var9);
         int var11 = Math.round(var3 * var9);
         int var12 = Math.round((var2 + var4) * var9) - var10;
         int var13 = Math.round((var3 + var5) * var9) - var11;
         if (var12 > 0 && var13 > 0) {
            Matrix3x2fStack var14 = var0.getMatrices();
            var14.pushMatrix();

            try {
               var14.scale(1.0F / var9, 1.0F / var9);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, var1, var10, var11, 0.0F, 0.0F, var12, var13, var6, var7, var6, var7, var8);
            } finally {
               var14.popMatrix();
            }
         }
      }
   }

   public static boolean v() {
      return cn;
   }

   private static void w() {
      if (cu != 0) {
         System.nanoTime();
      }

      Object var0 = null;
      Object var1 = null;
      Object var2 = null;

      try {
         int[] var3 = GlyphArrayCache.a();
         x(var3);
         int[][] var4 = new int[5][];
         var4[0] = var3;

         for (int var5 = 1; var5 < 5; var5++) {
            var4[var5] = y(var4[var5 - 1], (1990310122 ^ 1990308266) >> var5 - 1, (-2085718272 ^ -2085718144) >> var5 - 1);
         }

         var2 = var3;
         var0 = new NativeImage[5];

         for (int var10 = 0; var10 < 5; var10++) {
            var1 = z(var4[var10], (956707828 ^ 956709556) >> var10, (-1441764222 ^ -1441764350) >> var10);
            ((Object[])var0)[var10] = var1;
         }
      } catch (Throwable var6) {
         ck = true;
         return;
      }

      cj = (int[])var2;
      ci = (NativeImage[])var0;
   }

   private static void x(int[] var0) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      byte var1 = 64;
      int var2 = 445948295 ^ 445950151;

      for (int var3 = 0; var3 < var1; var3++) {
         int var4 = var3 * var2;

         for (int var5 = 0; var5 < var2; var5++) {
            int var6 = var5 / var1;
            int var7 = var0[var4 + var5];
            if (var6 != 0) {
               if (var6 == 36) {
                  if (var7 >>> 24 == 0) {
                     var0[var4 + var5] = 14173562;
                  }
               } else if (var6 == 20) {
                  if (var7 >>> 24 == 0) {
                     var0[var4 + var5] = 14079702;
                  }
               } else {
                  var0[var4 + var5] = var7 & (-460409204 ^ 462337676) | 1650456502 ^ 1654655049;
               }
            }
         }
      }
   }

   private static int[] y(int[] var0, int var1, int var2) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var3 = var1 >> 1;
      int var4 = var2 >> 1;
      int[] var5 = new int[var3 * var4];

      for (int var6 = 0; var6 < var4; var6++) {
         for (int var7 = 0; var7 < var3; var7++) {
            int var8 = var6 * 2 * var1 + var7 * 2;
            int var9 = var0[var8];
            int var10 = var0[var8 + 1];
            int var11 = var0[var8 + var1];
            int var12 = var0[var8 + var1 + 1];
            int var13 = var9 >>> 24;
            int var14 = var10 >>> 24;
            int var15 = var11 >>> 24;
            int var16 = var12 >>> 24;
            int var17 = var13 + var14 + var15 + var16;
            int var18;
            int var19;
            int var20;
            if (var17 > 0) {
               var18 = (
                     (var9 >> 16 & (231437487 ^ 231437392)) * var13
                        + (var10 >> 16 & (-2117781242 ^ -2117780999)) * var14
                        + (var11 >> 16 & (-247543384 ^ -247543465)) * var15
                        + (var12 >> 16 & (1383492218 ^ 1383492229)) * var16
                        + var17 / 2
                  )
                  / var17;
               var19 = (
                     (var9 >> 8 & (1632732530 ^ 1632732557)) * var13
                        + (var10 >> 8 & (1853268770 ^ 1853268957)) * var14
                        + (var11 >> 8 & (-920036710 ^ -920036763)) * var15
                        + (var12 >> 8 & (2066860802 ^ 2066861053)) * var16
                        + var17 / 2
                  )
                  / var17;
               var20 = (
                     (var9 & (282013548 ^ 282013587)) * var13
                        + (var10 & (-786173451 ^ -786173686)) * var14
                        + (var11 & (1264802888 ^ 1264802999)) * var15
                        + (var12 & (-1427322871 ^ -1427322634)) * var16
                        + var17 / 2
                  )
                  / var17;
            } else {
               var18 = (var9 >> 16 & (953529877 ^ 953530090))
                     + (var10 >> 16 & (-1201185803 ^ -1201186038))
                     + (var11 >> 16 & (-875115397 ^ -875115388))
                     + (var12 >> 16 & (1819931900 ^ 1819931651))
                     + 2
                  >> 2;
               var19 = (var9 >> 8 & (1055598174 ^ 1055598241))
                     + (var10 >> 8 & (-37332647 ^ -37332570))
                     + (var11 >> 8 & (1032603607 ^ 1032603432))
                     + (var12 >> 8 & (1764671501 ^ 1764671730))
                     + 2
                  >> 2;
               var20 = (var9 & (103361438 ^ 103361377))
                     + (var10 & (-1265048935 ^ -1265048986))
                     + (var11 & (870428323 ^ 870428252))
                     + (var12 & (-1883784937 ^ -1883784728))
                     + 2
                  >> 2;
            }

            var5[var6 * var3 + var7] = var17 + 2 >> 2 << 24 | var18 << 16 | var19 << 8 | var20;
         }
      }

      return var5;
   }

   private static NativeImage z(int[] var0, int var1, int var2) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      NativeImage var3 = new NativeImage(Format.RGBA, var1, var2, false);

      for (int var4 = 0; var4 < var2; var4++) {
         int var5 = var4 * var1;

         for (int var6 = 0; var6 < var1; var6++) {
            var3.setColorArgb(var6, var4, var0[var5 + var6]);
         }
      }

      return var3;
   }

   private static boolean aa() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (cn) {
         return true;
      }

      if (cm || ck) {
         return false;
      }

      if (!cl) {
         cl = true;

         try {
            Thread var7 = new Thread(StyleKeyCache::w, aw[1]);
            var7.setDaemon(true);
            var7.start();
         } catch (Throwable var5) {
            ck = true;
         }

         return false;
      } else {
         NativeImage[] var0 = ci;
         if (var0 == null) {
            return false;
         }

         ci = null;
         cm = true;
         int[] var1 = cj;
         cj = null;

         try {
            MinecraftClient.getInstance().getTextureManager().registerTexture(ce, new MipmapTextureCache(aw[2], var0, false));
            cn = true;
            return true;
         } catch (Throwable var6) {
            cn = false;
            if (var1 == null) {
               return false;
            }

            NativeImage var2 = null;

            try {
               var2 = z(var1, 1418068734 ^ 1418070974, -1633248041 ^ -1633248169);
               MinecraftClient.getInstance().getTextureManager().registerTexture(ce, new LayerTextureCache(aw[2], var2));
               cn = true;
            } catch (Throwable var4) {
               cn = false;
            }

            return cn;
         }
      }
   }

   public static void ab(DrawContext var0, int var1, float var2, float var3, float var4, int var5) {
      if (cu != 0) {
         System.nanoTime();
      }

      if (!(var4 <= 0.0F) && var5 >>> 24 != 0 && var1 >= 0 && var1 < 37) {
         if (cn || aa()) {
            int var6 = var1 != 0 && var1 != 36 ? var5 : var5 | 1985262935 ^ 1990937256;
            int var7 = MAG;
            int var8 = Math.round(var2 * var7);
            int var9 = Math.round(var3 * var7);
            int var10 = Math.max(1, Math.round(var4 * var7));
            Matrix3x2fStack var11 = var0.getMatrices();
            var11.pushMatrix();

            try {
               var11.scale(1.0F / var7, 1.0F / var7);
               var0.drawTexture(
                  RenderPipelines.GUI_TEXTURED, ce, var8, var9, var1 * 64, 0.0F, var10, var10, 64, 64, 1176005515 ^ 1176003275, 1531203920 ^ 1531204048, var6
               );
            } finally {
               var11.popMatrix();
            }
         }
      }
   }

   public static void ac(DrawContext var0, int var1, float var2, float var3, float var4, int var5) {
      if (cu != 0) {
         System.nanoTime();
      }

      if (!(var4 <= 0.0F) && var1 >= 0 && var1 < 37) {
         int var6 = (int)((var5 >>> 24 & (1115491569 ^ 1115491342)) * 0.45F);
         if (var6 != 0) {
            if (cn || aa()) {
               int var7 = MAG;
               float var8 = var4 * 1.3F;
               float var9 = var2 + (var4 - var8) * 0.5F;
               float var10 = var3 + (var4 - var8) * 0.5F;
               int var11 = Math.round(var9 * var7);
               int var12 = Math.round(var10 * var7);
               int var13 = Math.max(1, Math.round(var8 * var7));
               Matrix3x2fStack var14 = var0.getMatrices();
               var14.pushMatrix();

               try {
                  var14.scale(1.0F / var7, 1.0F / var7);
                  var0.drawTexture(
                     RenderPipelines.GUI_TEXTURED,
                     ce,
                     var11,
                     var12,
                     var1 * 64,
                     64.0F,
                     var13,
                     var13,
                     64,
                     64,
                     -65001387 ^ -65003243,
                     1111191135 ^ 1111191263,
                     var6 << 24 | var5 & (658834941 ^ 666565122)
                  );
               } finally {
                  var14.popMatrix();
               }
            }
         }
      }
   }

   public static void ad(DrawContext var0, int var1, float var2, float var3, float var4, float var5, int var6) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && var1 >= 0 && var1 < 37) {
         int var7 = (int)((var6 >>> 24 & (-835847406 ^ -835847187)) * 0.45F);
         if (var7 != 0) {
            if (cn || aa()) {
               int var8 = MAG;
               int var9 = Math.round(var2 * var8);
               int var10 = Math.round(var3 * var8);
               int var11 = Math.max(1, Math.round(var4 * var8));
               int var12 = Math.max(1, Math.round(var5 * var8));
               Matrix3x2fStack var13 = var0.getMatrices();
               var13.pushMatrix();

               try {
                  var13.scale(1.0F / var8, 1.0F / var8);
                  var0.drawTexture(
                     RenderPipelines.GUI_TEXTURED,
                     ce,
                     var9,
                     var10,
                     var1 * 64,
                     64.0F,
                     var11,
                     var12,
                     64,
                     64,
                     -1672906395 ^ -1672908763,
                     -476173261 ^ -476173133,
                     var7 << 24 | var6 & (42910934 ^ 40975145)
                  );
               } finally {
                  var13.popMatrix();
               }
            }
         }
      }
   }

   public static void ae(DrawContext var0, int var1, float var2, float var3, float var4, int var5) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (!(var4 <= 0.0F) && var5 >>> 24 != 0 && var1 >= 0 && var1 < 37) {
         if (cn || aa()) {
            int var6 = MAG;
            int var7 = (int)((var5 >>> 24 & (1448453211 ^ 1448453284)) * 0.45F);
            int var8 = var1 * 64;
            Matrix3x2fStack var9 = var0.getMatrices();
            var9.pushMatrix();

            try {
               var9.scale(1.0F / var6, 1.0F / var6);
               if (var7 > 0) {
                  float var10 = var4 * 1.3F;
                  float var11 = var2 + (var4 - var10) * 0.5F;
                  float var12 = var3 + (var4 - var10) * 0.5F;
                  int var13 = Math.round(var11 * var6);
                  int var14 = Math.round(var12 * var6);
                  int var15 = Math.max(1, Math.round(var10 * var6));
                  var0.drawTexture(
                     RenderPipelines.GUI_TEXTURED,
                     ce,
                     var13,
                     var14,
                     var8,
                     64.0F,
                     var15,
                     var15,
                     64,
                     64,
                     1085833543 ^ 1085835271,
                     1273777342 ^ 1273777214,
                     var7 << 24 | var5 & (-1101413337 ^ -1096401960)
                  );
               }

               int var19 = var1 != 0 && var1 != 36 ? var5 : var5 | -1581013499 ^ -1589880326;
               int var20 = Math.round(var2 * var6);
               int var21 = Math.round(var3 * var6);
               int var22 = Math.max(1, Math.round(var4 * var6));
               var0.drawTexture(
                  RenderPipelines.GUI_TEXTURED, ce, var20, var21, var8, 0.0F, var22, var22, 64, 64, -540705978 ^ -540708346, -1710267452 ^ -1710267580, var19
               );
            } finally {
               var9.popMatrix();
            }
         }
      }
   }

   private static boolean af() {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (cr) {
         return true;
      }

      if (cs) {
         return false;
      }

      cs = true;
      NativeImage var0 = null;
      NativeImage var1 = null;
      NativeImage var2 = null;
      NativeImage[] var3 = null;
      InputStream var4 = null;
      assert co != null && cp != null;

      try {
         var4 = ((Resource)MinecraftClient.getInstance().getResourceManager().getResource(co).orElseThrow()).getInputStream();
         var0 = NativeImage.read(var4);
         if (var0.getWidth() != (-1794225678 ^ -1794225934) || var0.getHeight() != (-253772083 ^ -253771827)) {
            return false;
         }

         int var5 = 1;

         for (int var6 = 533469763 ^ 533470019; var6 > 1; var5++) {
            var6 >>= 1;
         }

         var3 = new NativeImage[var5];
         var3[0] = var0;
         var0 = null;

         for (int var7 = 1; var7 < var5; var7++) {
            int var8 = (-712518914 ^ -712518658) >> var7;
            var1 = var3[var7 - 1];
            var2 = new NativeImage(var8, var8, false);

            for (int var9 = 0; var9 < var8; var9++) {
               for (int var10 = 0; var10 < var8; var10++) {
                  int var11 = 0;
                  int var12 = 0;
                  int var13 = 0;
                  int var14 = 0;

                  for (int var15 = 0; var15 < 4; var15++) {
                     int var16 = var1.getColorArgb(var10 * 2 + (var15 & 1), var9 * 2 + (var15 >> 1));
                     int var17 = var16 >>> 24;
                     var11 += var17;
                     var12 += (var16 >> 16 & (252993920 ^ 252993919)) * var17;
                     var13 += (var16 >> 8 & (-789853272 ^ -789853353)) * var17;
                     var14 += (var16 & (-469436836 ^ -469436765)) * var17;
                  }

                  int var30 = var11 + 2 >> 2;
                  int var31 = var11 > 0 ? var30 << 24 | var12 / var11 << 16 | var13 / var11 << 8 | var14 / var11 : 0;
                  var2.setColorArgb(var10, var9, var31);
               }
            }

            var3[var7] = var2;
            var2 = null;
         }

         MinecraftClient.getInstance()
            .getTextureManager()
            .registerTexture(
               cp,
               new MipmapTextureCache(
                  JoinerWriter.p(new byte[]{22, 31}, 76)
                     + QueryZone.r(new byte[]{82, 91, 66}, 62)
                     + QueryZone.r(new byte[]{5, 64}, 38)
                     + TokenExtractor.w(new byte[]{71, 78, 65}, 42),
                  var3,
                  false
               )
            );
         var3 = null;
         cr = true;
      } catch (Throwable var27) {
         cr = false;
      } finally {
         if (var0 != null) {
            var0.close();
         }

         if (var2 != null) {
            var2.close();
         }

         if (var3 != null) {
            for (int var19 = 0; var19 < var3.length; var19++) {
               if (var3[var19] != null) {
                  var3[var19].close();
               }
            }
         }

         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var26) {
            }
         }
      }

      return cr;
   }

   public static boolean ag() {
      if (cu != 0) {
         new Object().hashCode();
      }

      return cr || af();
   }

   public static void ah(DrawContext var0, float var1, float var2, float var3, int var4) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (!(var3 <= 0.0F) && var4 >>> 24 != 0 && ag()) {
         Matrix3x2fStack var5 = var0.getMatrices();
         var5.pushMatrix();

         try {
            var5.translate(var1 - var3 * 0.5F, var2 - var3 * 0.5F);
            var5.scale(var3 / 256.0F, var3 / 256.0F);
            var0.drawTexture(
               RenderPipelines.GUI_TEXTURED,
               cp,
               0,
               0,
               0.0F,
               0.0F,
               1830484217 ^ 1830484473,
               -1920455997 ^ -1920455741,
               -9693774 ^ -9694030,
               1290881802 ^ 1290881546,
               -163790787 ^ -163790531,
               864921228 ^ 864921484,
               var4
            );
         } finally {
            var5.popMatrix();
         }
      }
   }

   static {
      b(al[0], al[1], al[2], 95);
      String var0 = StringDecoder.d(new byte[]{-4, -32, -14, -91, -49}, 148);

      for (int var1 = 0; var1 < 12; var1++) {
         for (int var2 = 0; var2 < 3; var2++) {
            STYLES[var1][var2] = Style.EMPTY
               .withFont(
                  new Font(
                     Identifier.of(
                        NotifyResolver.q(new byte[]{19, 23, 15, 30, 6, 19, 54}, 127), var0 + av[var1] + YieldKeeper.v(new byte[]{-105}, 200) + (var2 + 1)
                     )
                  )
               );
         }

         ST[var1] = STYLES[var1][1];
         bd[var1] = new HashMap<>();
         Object2FloatOpenHashMap var3 = new Object2FloatOpenHashMap();
         var3.defaultReturnValue(-1.0F);
         be[var1] = var3;
      }

      bi = new String[128];
      bj = new String[128];
      bk = new float[128];
      bl = new int[128];
      bm = new int[128];
      bn = new OrderedText[128];
      bo = new OrderedText[128];
      bp = new float[128];
      bq = new int[128];
      br = new int[128];
      bs = 0;
      by = (var0x, var1x, var2x) -> {
         if (cu != 0) {
            System.nanoTime();
         }

         bu = bu + bt.getWidth(OrderedText.styled(var2x, var1x));
         if (bu > bv) {
            return false;
         }

         bw++;
         if (var2x != 32) {
            bx = bw;
         }

         return true;
      };
      cd = (var0x, var1x, var2x) -> {
         if (cu != 0) {
            new Object().hashCode();
         }

         if (cb >= cc) {
            return false;
         }

         bz[cb] = var2x;
         ca[cb] = var1x;
         cb++;
         return true;
      };
      ce = Identifier.of(
         TokenExtractor.w(new byte[]{-37, -39, -59, -38, -38, -39, -64}, 188),
         NotifyResolver.q(new byte[]{-53, -41, -61}, 163) + YieldKeeper.v(new byte[]{101, -15, 108, 63, -36, 100, 18}, 87)
      );
      ck = false;
      cl = false;
      cm = false;
      cn = false;
      co = Identifier.of(
         JoinerWriter.p(new byte[]{27, 23, 33, 20, 20, 31, 22}, 81),
         TokenExtractor.w(
            new byte[]{-40, -56, -46, -33, -35, -37, -45, -60, -101, -46, -57, -38, -97, -45, -46, -48, -45, -48, -27, -41, -41, -34, -23, -87, -12, -21, -27},
            166
         )
      );
      cp = Identifier.of(
         StringDecoder.d(new byte[]{-21, -17, -15, -20, -22, -9, -20}, 135),
         NotifyResolver.q(new byte[]{-89, -88, -82, -93, -72, -125, -115, -101, -30}, 197)
            + QueryZone.r(new byte[]{20, 45, 4}, 120)
            + TokenExtractor.w(new byte[]{-3, -25}, 157)
      );
   }
}
