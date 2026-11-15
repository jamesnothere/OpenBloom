package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RasterCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.JumpingMount;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Arm;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2fStack;

public final class BarZoneCache {
   private static final String[] q = new String[]{
      TokenExtractor.w(new byte[]{111}, 78),
      TokenExtractor.w(new byte[]{-22}, 200),
      YieldKeeper.v(new byte[]{85, 27, -33, -116, 116, 35, -30}, 57),
      NotifyResolver.q(new byte[]{-10, -22, -2, -91, -47, -18, -39, -64, -80, -68}, 158)
   };
   private static final int r = 0;
   private static final int s = 1;
   private static final Identifier t = Identifier.of(q[2], q[3]);
   private static final int u = 2368;
   private static final int v = 128;
   private static final float w = 1024.0F;
   private static final float x = 1280.0F;
   private static final EquipmentSlot[] y = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final ItemStack[] z = new ItemStack[4];
   private static final int aa = StyleKeyCache.d(-7490758);
   private static final int ab = StyleKeyCache.d(-11908534);
   private static final int ac = StyleKeyCache.d(-6630913);
   private static final int ad = StyleKeyCache.d(-7693510);
   private static final int ae = StyleKeyCache.d(-10827526);
   private static final int af = StyleKeyCache.d(-1944214);
   private static final int ag = -14013904;
   private static final int ah = -869651920;
   private static final int ai = 0;
   private static final int aj = 1;
   private static final int ak = 2;
   private static final int al = 3;
   private static final int am = 4;
   private static final int an = 5;
   private static final int ao = 6;
   private static final int ap = 10;
   private static final int aq = 11;
   private static final int ar = 12;
   private static final int[] as = new int[12];
   private static final int[] at = new int[12];
   private static final Text[] au = new Text[12];
   private static final float[] av = new float[12];
   private static final Text[] aw = new Text[9];
   private static final Text[] ax = new Text[9];
   private static final float[] ay = new float[9];
   private static int az = Integer.MIN_VALUE;
   private static final String[] ba = new String[1024];
   private static final String[] bb = new String[101];
   private static final int bc = 40;
   private static final Text[] bd;
   private static final float[] be;
   private static final float[] bf;
   private static final int[] bg;
   private static final boolean[] bh;
   private static int bi;
   private static final float[] bj;
   private static final float[] bk;
   private static final float[] bl;
   private static final float[] bm;
   private static final float[] bn;
   private static final int[] bo;
   private static final int[] bp;
   private static final int[] bq;
   private static final boolean[] br;
   private static boolean bs;
   private static float bt;
   private static float bu;
   private static final float[] bv;
   private static final boolean[] bw;
   private static boolean bx;
   private static float by;
   private static float bz;
   private static long ca;
   private static int cb;
   private static int cc;
   private static boolean cd;
   private static float ce;
   private static int cf;
   private static float cg;
   private static float ch;
   private static int ci;
   private static ItemStack cj;
   private static Text ck;
   private static float cl;
   private static long cm;
   private static long cn;
   private static int co;
   private static int cq = 0;

   private BarZoneCache() {
   }

   static boolean a(DrawContext var0, RenderTickCounter var1, CoreZoneProcessor var2, int var3, int var4) {
      if (cq != 0) {
         new Object().hashCode();
      }

      MinecraftClient var5 = MinecraftClient.getInstance();
      ClientPlayerEntity var6 = var5.player;
      ClientPlayerInteractionManager var7 = var5.interactionManager;
      if (var6 != null && var7 != null) {
         var0.createNewRootLayer();
         float var8 = var2.dq;
         boolean var9 = var2.dm == 1;
         boolean var10 = var2.cz.f();
         boolean var11 = var2.da.f();
         boolean var12 = StyleKeyCache.v();
         if (!var12) {
            StyleKeyCache.ab(var0, 16, -64.0F, -64.0F, 1.0F, 1146230562 ^ 1169025245);
         }

         if (az != StyleKeyCache.ba) {
            k();
         }

         bi = 0;
         float var13 = var3 * 0.5F;
         float var14 = var4 - 5.0F - 22.0F;
         int var15 = var6.getInventory().getSelectedSlot();
         if (var15 < 0 || var15 > 8) {
            var15 = 0;
         }

         float var16 = 20.0F * var15;
         boolean var17 = var6.getMainArm().getOpposite() == Arm.LEFT;
         boolean var18 = var9 || !var6.getOffHandStack().isEmpty();
         float var19 = !var17 && var18 ? (var9 ? 31.0F : 25.0F) : 0.0F;
         if (!bs) {
            bs = true;
            bt = var16;
            bu = var19;
         } else {
            bt = bt + (var16 - bt) * (1.0F - (float)Math.exp(-24.0 * var8));
            if (Math.abs(var16 - bt) < 0.05F) {
               bt = var16;
            }

            bu = bu + (var19 - bu) * (1.0F - (float)Math.exp(-13.0 * var8));
            if (Math.abs(var19 - bu) < 0.05F) {
               bu = var19;
            }
         }

         if (var9) {
            c(var0, var1, var6, var5, var13, var14, var15, var17, var10);
         } else {
            b(var0, var1, var6, var5, var13, var14, var17, var18, var10);
         }

         float var20 = var9 ? var14 - 1.0F : var14;
         if (var11) {
            float var21 = var9
               ? e(var0, var6, var12, var13 + 100.0F + bu, var14 + 2.5F, 76.0F, 19.0F, 9.5F, var14 + 4.5F, 15.0F, 18.0F, 12.0F, 1.8F)
               : e(var0, var6, var12, var13 + 97.0F + bu, var14 - 1.0F, 84.0F, 24.0F, 8.0F, var14 + 2.5F, 17.0F, 20.0F, 14.0F, 1.85F);
            if (var21 > ch) {
               ch = var21;
            }

            if (var21 == var21 && !var9) {
               var20 = var14 - 1.0F;
            }
         }

         boolean var44 = var7.hasStatusBars();
         cd = false;
         if (var44) {
            int var22 = var6.getMaxAir();
            if (var22 > 0) {
               int var23 = Math.max(0, Math.min(var22, var6.getAir()));
               boolean var24 = var6.isSubmergedIn(FluidTags.WATER);
               if (var24 || var23 < var22) {
                  int var25 = (int)Math.ceil((var23 - 2) * 10.0F / var22);
                  int var26 = (int)Math.ceil(var23 * 10.0F / var22);
                  if (!var24) {
                     cc = 0;
                  }

                  if (var24 && var26 != var25 && var26 >= 1 && cc != var26) {
                     int var27 = 10 - (int)Math.ceil((var23 + (var23 != 0 ? 1 : 0)) * 10.0F / var22);
                     var6.playSound(SoundEvents.UI_HUD_BUBBLE_POP, 0.5F + 0.1F * Math.max(0, var27 - 2), 1.0F + 0.1F * Math.max(0, var27 - 4));
                     cc = var26;
                  }

                  cd = true;
                  ce = (float)var23 / var22;
                  cf = Math.max(0, var26);
               }
            }
         }

         LivingEntity var45 = null;
         if (var6.getVehicle() instanceof LivingEntity var47 && var47.isLiving() && (int)(var47.getMaxHealth() + 0.5F) / 2 > 0) {
            var45 = var47;
         }

         if (!var44 && var45 == null) {
            bw[0] = false;
            bw[1] = false;
            bw[2] = false;
            bw[3] = false;
         } else {
            float var48 = var9 ? g(var0, var6, var45, var44, var12, var13, var14) : f(var0, var6, var45, var44, var13, var14, var8);
            if (var48 < var20) {
               var20 = var48;
            }
         }

         float var49 = h(var0, var6, var7, var9, var13, var14, var8);
         if (var49 < var20) {
            var20 = var49;
         }

         ItemStack var50 = var6.getInventory().getSelectedStack();
         if (var50 != cj) {
            o(var50, var5);
         }

         if (cm != 0L) {
            long var51 = cm + cn - System.nanoTime();
            if (var51 > 0L && cj != null && !cj.isEmpty()) {
               if (co != StyleKeyCache.bb) {
                  p(cj);
               }

               if (ck != null) {
                  float var28 = Math.min(1.0F, (float)var51 / 5.0E8F);
                  float var29 = cl + 12.0F;
                  float var30 = var20 - 15.0F;
                  float var31 = var13 - var29 * 0.5F;
                  float var32 = var30;
                  float var33 = var29;
                  float var34 = 12.0F;
                  int var35 = (int)(StyleKeyCache.PA * var28 * 0.9F) << 24 | StyleKeyCache.PANEL & (1364627125 ^ 1370059082);
                  if (var33 > 0.0F && var34 > 0.0F && var35 >>> 24 != 0) {
                     int var36 = StyleKeyCache.MAG;
                     int var37 = Math.round(var31 * var36);
                     int var38 = Math.round(var32 * var36);
                     int var39 = Math.round((var31 + var33) * var36) - var37;
                     int var40 = Math.round((var32 + var34) * var36) - var38;
                     var0.getMatrices().pushMatrix();

                     try {
                        var0.getMatrices().scale(1.0F / var36, 1.0F / var36);
                        RasterCache.l(var0, var37, var38, var39, var40, Math.min(var39, var40) >> 1, var35, 1, true, true, true, true);
                     } finally {
                        var0.getMatrices().popMatrix();
                     }
                  }

                  int var55 = bi++;
                  bd[var55] = ck;
                  be[var55] = var13 - cl * 0.5F;
                  bf[var55] = var30 + 8.5F;
                  bg[var55] = (int)(255.0F * var28) << 24 | -784746200 ^ -775534889;
                  bh[var55] = false;
               }
            } else {
               cm = 0L;
            }
         }

         i(var0);
         var2.dv = var20 - 15.0F;
         int[] var52 = var2.ew[9];
         int var53 = (int)Math.floor(cg);
         int var54 = (int)Math.floor(var20);
         var52[0] = var53;
         var52[1] = var54;
         var52[2] = (int)Math.ceil(ch) - var53;
         var52[3] = (int)Math.ceil(var14 + 23.0F) - var54;
         return true;
      } else {
         return false;
      }
   }

   private static void b(
      DrawContext var0, RenderTickCounter var1, ClientPlayerEntity var2, MinecraftClient var3, float var4, float var5, boolean var6, boolean var7, boolean var8
   ) {
      if (cq != 0) {
         System.nanoTime();
      }

      float var9 = var4 - 91.0F;
      float var10 = var9;
      float var11 = var5;
      float var12 = 182.0F;
      float var13 = 22.0F;
      int var14 = StyleKeyCache.PANEL;
      if (var12 > 0.0F && var13 > 0.0F && var14 >>> 24 != 0) {
         int var15 = StyleKeyCache.MAG;
         int var16 = Math.round(var10 * var15);
         int var17 = Math.round(var11 * var15);
         int var18 = Math.round((var10 + var12) * var15) - var16;
         int var19 = Math.round((var11 + var13) * var15) - var17;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var15, 1.0F / var15);
            RasterCache.l(var0, var16, var17, var18, var19, Math.round(5.0F * var15), var14, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      var10 = var9 + 1.0F + bt;
      var11 = var10;
      var12 = var5 + 1.0F;
      var13 = 20.0F;
      float var69 = 20.0F;
      int var74 = StyleKeyCache.A;
      if (var13 > 0.0F && var69 > 0.0F && var74 >>> 24 != 0) {
         int var78 = StyleKeyCache.MAG;
         int var82 = Math.round(var11 * var78);
         int var86 = Math.round(var12 * var78);
         int var90 = Math.round((var11 + var13) * var78) - var82;
         int var20 = Math.round((var12 + var69) * var78) - var86;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var78, 1.0F / var78);
            RasterCache.l(var0, var82, var86, var90, var20, Math.round(4.0F * var78), var74, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      var11 = var10 + 1.0F;
      var12 = var5 + 2.0F;
      var13 = 18.0F;
      float var70 = 18.0F;
      var74 = StyleKeyCache.SEL_FILL;
      if (var13 > 0.0F && var70 > 0.0F && var74 >>> 24 != 0) {
         int var79 = StyleKeyCache.MAG;
         int var83 = Math.round(var11 * var79);
         int var87 = Math.round(var12 * var79);
         int var91 = Math.round((var11 + var13) * var79) - var83;
         int var94 = Math.round((var12 + var70) * var79) - var87;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var79, 1.0F / var79);
            RasterCache.l(var0, var83, var87, var91, var94, Math.round(3.0F * var79), var74, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      var11 = var6 ? var4 - 116.0F : var4 + 95.0F;
      if (var7) {
         var12 = var11;
         var13 = var5;
         float var71 = 21.0F;
         float var76 = 22.0F;
         int var80 = StyleKeyCache.PANEL;
         if (var71 > 0.0F && var76 > 0.0F && var80 >>> 24 != 0) {
            int var84 = StyleKeyCache.MAG;
            int var88 = Math.round(var12 * var84);
            int var92 = Math.round(var13 * var84);
            int var95 = Math.round((var12 + var71) * var84) - var88;
            int var21 = Math.round((var13 + var76) * var84) - var92;
            var0.getMatrices().pushMatrix();

            try {
               var0.getMatrices().scale(1.0F / var84, 1.0F / var84);
               RasterCache.l(var0, var88, var92, var95, var21, Math.round(5.0F * var84), var80, 1, true, true, true, true);
            } finally {
               var0.getMatrices().popMatrix();
            }
         }
      }

      cg = var7 && var6 ? var4 - 116.0F : var9;
      ch = var7 && !var6 ? var4 + 116.0F : var4 + 91.0F;
      d(var0, var1, var2, var3, var9 + 3.0F, var5 + 3.0F, var7 ? var11 + 2.5F : Float.NaN);
      if (var8) {
         Text[] var62 = aw;

         for (int var67 = 0; var67 < 9; var67++) {
            var14 = bi++;
            bd[var14] = var62[var67];
            be[var14] = var9 + 1.0F + 20.0F * var67 + 2.5F;
            bf[var14] = var5 + 6.5F;
            bg[var14] = -8618878;
            bh[var14] = false;
         }
      }

      if (var3.options.getAttackIndicator().getValue() == AttackIndicator.HOTBAR) {
         var12 = var2.getAttackCooldownProgress(0.0F);
         if (var12 < 1.0F) {
            var13 = var10 + 3.0F;
            float var73 = var5 + 19.5F;
            float var77 = Math.max(1.0F, 14.0F * var12);
            float var81 = 1.0F;
            int var85 = -1820108772 ^ 1602443292 | StyleKeyCache.A & (-139060072 ^ -146152601);
            if (var77 > 0.0F && var81 > 0.0F && var85 >>> 24 != 0) {
               int var89 = StyleKeyCache.MAG;
               int var93 = Math.round(var13 * var89);
               int var96 = Math.round(var73 * var89);
               int var97 = Math.round((var13 + var77) * var89) - var93;
               int var22 = Math.round((var73 + var81) * var89) - var96;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var89, 1.0F / var89);
                  RasterCache.l(var0, var93, var96, var97, var22, Math.min(var97, var22) >> 1, var85, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }
      }
   }

   private static void c(
      DrawContext var0, RenderTickCounter var1, ClientPlayerEntity var2, MinecraftClient var3, float var4, float var5, int var6, boolean var7, boolean var8
   ) {
      if (cq != 0) {
         new Object().hashCode();
      }

      float var9 = var4 - 96.0F;
      float var10 = var5 - 1.0F;
      float var11 = 192.0F;
      float var12 = 24.0F;
      int var13 = StyleKeyCache.PANEL;
      if (var11 > 0.0F && var12 > 0.0F && var13 >>> 24 != 0) {
         int var14 = StyleKeyCache.MAG;
         int var15 = Math.round(var9 * var14);
         int var16 = Math.round(var10 * var14);
         int var17 = Math.round((var9 + var11) * var14) - var15;
         int var18 = Math.round((var10 + var12) * var14) - var16;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var14, 1.0F / var14);
            RasterCache.l(var0, var15, var16, var17, var18, Math.round(7.0F * var14), var13, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      var9 = var4 - 91.0F;
      var10 = var9 + bt;
      var11 = var10;
      var12 = var5 + 1.0F;
      float var52 = 20.0F;
      float var56 = 20.0F;
      int var60 = -1551119042 ^ 1551580620;
      if (var52 > 0.0F && var56 > 0.0F && var60 >>> 24 != 0) {
         int var63 = StyleKeyCache.MAG;
         int var66 = Math.round(var11 * var63);
         int var69 = Math.round(var12 * var63);
         int var19 = Math.round((var11 + var52) * var63) - var66;
         int var20 = Math.round((var12 + var56) * var63) - var69;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var63, 1.0F / var63);
            RasterCache.l(var0, var66, var69, var19, var20, Math.round(5.0F * var63), var60, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      var11 = var7 ? var4 - 127.0F : var4 + 104.0F;
      var12 = var11;
      float var53 = var5;
      var56 = 23.0F;
      float var61 = 22.0F;
      int var64 = StyleKeyCache.PANEL;
      if (var56 > 0.0F && var61 > 0.0F && var64 >>> 24 != 0) {
         int var67 = StyleKeyCache.MAG;
         int var70 = Math.round(var12 * var67);
         int var72 = Math.round(var53 * var67);
         int var74 = Math.round((var12 + var56) * var67) - var70;
         int var21 = Math.round((var53 + var61) * var67) - var72;
         var0.getMatrices().pushMatrix();

         try {
            var0.getMatrices().scale(1.0F / var67, 1.0F / var67);
            RasterCache.l(var0, var70, var72, var74, var21, Math.round(6.0F * var67), var64, 1, true, true, true, true);
         } finally {
            var0.getMatrices().popMatrix();
         }
      }

      cg = var7 ? var11 : var4 - 96.0F;
      ch = var7 ? var4 + 96.0F : var11 + 23.0F;
      d(var0, var1, var2, var3, var9 + 2.0F, var5 + 3.0F, var11 + 3.5F);
      if (var8) {
         int var50 = ci;

         for (int var54 = 0; var54 < 9; var54++) {
            if ((var50 & 1 << var54) == 0) {
               int var58 = bi++;
               bd[var58] = ax[var54];
               be[var58] = var9 + 20.0F * var54 + 10.0F - ay[var54] * 0.5F;
               bf[var58] = var5 + 13.4F;
               bg[var58] = var54 == var6 ? -792050561 ^ 803237455 : -3618612;
               bh[var58] = false;
            }
         }
      }

      if (var3.options.getAttackIndicator().getValue() == AttackIndicator.HOTBAR) {
         var12 = var2.getAttackCooldownProgress(0.0F);
         if (var12 < 1.0F) {
            float var55 = var10 + 3.0F;
            var56 = var5 + 19.5F;
            float var62 = Math.max(1.0F, 14.0F * var12);
            float var65 = 1.0F;
            int var68 = -790897983 ^ 485617905;
            if (var62 > 0.0F && var65 > 0.0F && var68 >>> 24 != 0) {
               int var71 = StyleKeyCache.MAG;
               int var73 = Math.round(var55 * var71);
               int var75 = Math.round(var56 * var71);
               int var76 = Math.round((var55 + var62) * var71) - var73;
               int var22 = Math.round((var56 + var65) * var71) - var75;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var71, 1.0F / var71);
                  RasterCache.l(var0, var73, var75, var76, var22, Math.min(var76, var22) >> 1, var68, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }
      }
   }

   private static void d(DrawContext var0, RenderTickCounter var1, ClientPlayerEntity var2, MinecraftClient var3, float var4, float var5, float var6) {
      if (cq != 0) {
         System.nanoTime();
      }

      assert var0 != null
         && var1 != null
         && var2 != null
         && var3 != null
         && !Float.isNaN(var4)
         && !Float.isNaN(var5)
         && bd.length == 40
         && be.length == 40
         && bf.length == 40
         && bg.length == 40
         && bh.length == 40
         && StyleKeyCache.MAG >= 1
         && StyleKeyCache.MAG <= 3
         && ci >= 0 : NotifyResolver.q(new byte[]{-53, -41, -61, -58, -63}, 1682794787 ^ 1682794881);
      PlayerInventory var7 = var2.getInventory();
      TextRenderer var8 = var3.textRenderer;
      Matrix3x2fStack var9 = var0.getMatrices();
      float var10 = var1.getTickProgress(false);
      int var11 = StyleKeyCache.MAG;
      float var12 = (float)Math.round(var5 * var11) / var11;
      int var13 = 0;

      try {
         for (int var15 = 0; var15 < 10; var15++) {
            ItemStack var14;
            float var16;
            if (var15 < 9) {
               var14 = var7.getStack(var15);
               var16 = var4 + 20.0F * var15;
            } else {
               if (var6 != var6) {
                  break;
               }

               var14 = var2.getOffHandStack();
               var16 = var6;
            }

            if (!var14.isEmpty()) {
               var13 |= 1 << var15;
               var16 = (float)Math.round(var16 * var11) / var11;
               float var17 = var14.getBobbingAnimationTime() - var10;
               var9.pushMatrix();

               try {
                  var9.translate(var16, var12);
                  if (var17 > 0.0F) {
                     float var18 = 1.0F + var17 / 5.0F;
                     var9.translate(8.0F, 12.0F);
                     var9.scale(1.0F / var18, (var18 + 1.0F) / 2.0F);
                     var9.translate(-8.0F, -12.0F);
                  }

                  var0.drawItem(var2, var14, 0, 0, var15 + 1);
               } finally {
                  var9.popMatrix();
               }

               var9.pushMatrix();

               try {
                  var9.translate(var16, var12);
                  var0.drawStackOverlay(var8, var14, 0, 0);
               } finally {
                  var9.popMatrix();
               }
            }
         }
      } catch (RuntimeException var29) {
         throw var29;
      }

      ci = var13 & (-612744051 ^ -612743822);
   }

   private static float e(
      DrawContext var0,
      ClientPlayerEntity var1,
      boolean var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      if (cq != 0) {
         Thread.currentThread().getName().length();
      }

      ItemStack[] var13 = z;
      int var14 = 0;

      for (int var15 = 0; var15 < 4; var15++) {
         ItemStack var16 = var1.getEquippedStack(y[var15]);
         var13[var15] = var16;
         if (!var16.isEmpty()) {
            var14++;
         }
      }

      if (var14 == 0) {
         for (int var45 = 0; var45 < 4; var45++) {
            var13[var45] = null;
         }

         return Float.NaN;
      } else {
         float var43 = var3;
         float var46 = var4;
         float var17 = var5;
         float var18 = var6;
         int var19 = StyleKeyCache.PANEL;
         if (var17 > 0.0F && var18 > 0.0F && var19 >>> 24 != 0) {
            int var20 = StyleKeyCache.MAG;
            int var21 = Math.round(var43 * var20);
            int var22 = Math.round(var46 * var20);
            int var23 = Math.round((var43 + var17) * var20) - var21;
            int var24 = Math.round((var46 + var18) * var20) - var22;
            var0.getMatrices().pushMatrix();

            try {
               var0.getMatrices().scale(1.0F / var20, 1.0F / var20);
               RasterCache.l(var0, var21, var22, var23, var24, Math.round(var7 * var20), var19, 1, true, true, true, true);
            } finally {
               var0.getMatrices().popMatrix();
            }
         }

         Matrix3x2fStack var44 = var0.getMatrices();
         int var47 = StyleKeyCache.MAG;
         var17 = var3 + 3.5F;
         var18 = var9 * 0.5F;
         if (var2) {
            var19 = Math.max(1, Math.round(var9 / 0.92F * var47));
            var44.pushMatrix();

            try {
               var44.scale(1.0F / var47, 1.0F / var47);

               for (int var53 = 0; var53 < 4; var53++) {
                  int var55 = Math.round((var17 + var10 * var53 + var18) * var47 - var19 * 0.5F);
                  int var57 = Math.round((var8 + var18) * var47 - var19 * 0.5F);
                  var0.drawTexture(
                     RenderPipelines.GUI_TEXTURED,
                     t,
                     var55,
                     var57,
                     1024.0F,
                     0.0F,
                     var19,
                     var19,
                     64,
                     64,
                     1474626884 ^ 1474628612,
                     -298588967 ^ -298589095,
                     294248256 ^ 91627711
                  );
               }
            } finally {
               var44.popMatrix();
            }
         } else {
            for (int var51 = 0; var51 < 4; var51++) {
               StyleKeyCache.t(var0, var17 + var10 * var51 + var18, var8 + var18, var9, -1158984665 ^ -1374374952);
            }
         }

         float var52 = var11 / 16.0F;
         int var54 = StyleKeyCache.ba;

         for (int var58 = 0; var58 < 4; var58++) {
            ItemStack var56 = var13[var58];
            var13[var58] = null;
            if (!var56.isEmpty()) {
               float var59 = var17 + var10 * var58 + var18;
               float var60 = var8 + var18;
               float var25 = (float)Math.round((var59 - var11 * 0.5F) * var47) / var47;
               float var26 = (float)Math.round((var60 - var11 * 0.5F) * var47) / var47;
               var44.pushMatrix();

               try {
                  var44.translate(var25, var26);
                  var44.scale(var52, var52);
                  var0.drawItem(var1, var56, 0, 0, 11 + var58);
               } finally {
                  var44.popMatrix();
               }

               if (var56.isDamageable()) {
                  int var27 = var56.getMaxDamage();
                  int var28 = var27 > 0 ? (var27 - var56.getDamage()) * 100 / var27 : 100;
                  var28 = var28 < 0 ? 0 : (var28 > 100 ? 100 : var28);
                  int var29 = 6 + var58;
                  if (as[var29] != var28 || at[var29] != var54) {
                     j(var29, 0, var28, m(var28));
                  }

                  int var30 = bi++;
                  bd[var30] = au[var29];
                  be[var30] = var59 - av[var29] * 0.5F;
                  bf[var30] = var60 + var12;
                  bg[var30] = var28 < 25 ? 496569225 ^ -496610861 : -657929;
                  bh[var30] = true;
               }
            }
         }

         return var3 + var5;
      }
   }

   private static float f(DrawContext var0, ClientPlayerEntity var1, LivingEntity var2, boolean var3, float var4, float var5, float var6) {
      if (cq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      float var7 = 1.0F - (float)Math.exp(-12.0 * var6);
      int var8 = StyleKeyCache.ba;
      int var9 = 0;
      float var10 = Float.MAX_VALUE;
      if (var3) {
         int var11 = var1.getArmor();
         if (var11 > 0) {
            float var12 = Math.min(1.0F, var11 / 20.0F);
            float var13 = bw[0] ? bv[0] + (var12 - bv[0]) * var7 : var12;
            bv[0] = var13;
            bw[0] = true;
            if (as[0] != var11 || at[0] != var8) {
               j(0, 0, var11, l(var11));
            }

            bj[var9] = var4 - 91.0F;
            bk[var9] = var5 - 30.0F;
            bl[var9] = var13;
            bo[var9] = -11108136;
            br[var9] = false;
            bp[var9] = 0;
            bq[var9] = -657929;
            bm[var9] = -1.0F;
            bn[var9] = 0.0F;
            var9++;
            var10 = var5 - 30.0F;
         } else {
            bw[0] = false;
         }

         float var54 = var1.getHealth();
         float var57 = var1.getAbsorptionAmount();
         float var14 = Math.max(var1.getMaxHealth(), var54);
         if (var14 <= 0.0F) {
            var14 = 1.0F;
         }

         float var15 = var54 / var14;
         var15 = var15 > 0.0F ? (var15 < 1.0F ? var15 : 1.0F) : 0.0F;
         long var17 = System.nanoTime();
         float var16;
         if (!bw[1]) {
            var16 = var15;
            by = var15;
            ca = 0L;
         } else {
            var16 = bv[1] + (var15 - bv[1]) * var7;
            if (var15 < bz - 0.001F) {
               ca = var17 + 380000000L;
            }

            if (var15 >= by) {
               by = var16;
            } else if (var17 >= ca) {
               by = by + (var16 - by) * (1.0F - (float)Math.exp(-5.5 * var6));
            }
         }

         bz = var15;
         bv[1] = var16;
         bw[1] = true;
         int var19 = Math.round((var54 + var57) * 10.0F);
         if (as[1] != var19 || at[1] != var8) {
            j(1, 0, var19, n(var19));
         }

         bj[var9] = var4 - 91.0F;
         bk[var9] = var5 - 16.0F;
         bl[var9] = var16;
         bo[var9] = var1.hasStatusEffect(StatusEffects.POISON)
            ? 2104298550 ^ -2099200244
            : (var1.hasStatusEffect(StatusEffects.WITHER) ? -800002248 ^ 790275442 : (var1.isFrozen() ? 1762342331 ^ -1768823740 : -2737088));
         br[var9] = false;
         bp[var9] = 1;
         bq[var9] = var57 > 0.0F ? -1459206550 ^ 1458503504 : -657929;
         bm[var9] = by;
         bn[var9] = Math.max(0.0F, Math.min(1.0F, Math.min(var57, var14) / var14));
         var9++;
         if (var10 > var5 - 16.0F) {
            var10 = var5 - 16.0F;
         }

         if (var2 == null) {
            int var20 = var1.getHungerManager().getFoodLevel();
            float var21 = Math.max(0.0F, Math.min(1.0F, var20 / 20.0F));
            float var22 = bw[2] && !bx ? bv[2] + (var21 - bv[2]) * var7 : var21;
            bv[2] = var22;
            bw[2] = true;
            bx = false;
            if (as[2] != var20 || at[2] != var8) {
               j(2, 0, var20, l(var20));
            }

            bj[var9] = var4 + 11.0F;
            bk[var9] = var5 - 16.0F;
            bl[var9] = var22;
            bo[var9] = var1.hasStatusEffect(StatusEffects.HUNGER) ? 1991490272 ^ -1992744486 : -2256856;
            br[var9] = true;
            bp[var9] = 2;
            bq[var9] = -657929;
            bm[var9] = -1.0F;
            bn[var9] = 0.0F;
            var9++;
         }

         if (cd) {
            float var76 = bw[3] ? bv[3] + (ce - bv[3]) * var7 : ce;
            bv[3] = var76;
            bw[3] = true;
            int var82 = cf;
            if (as[4] != var82 || at[4] != var8) {
               j(4, 0, var82, l(var82));
            }

            bj[var9] = var4 + 11.0F;
            bk[var9] = var5 - 30.0F;
            bl[var9] = var76;
            bo[var9] = -10827526;
            br[var9] = true;
            bp[var9] = 4;
            bq[var9] = -657929;
            bm[var9] = -1.0F;
            bn[var9] = 0.0F;
            var9++;
            var10 = var5 - 30.0F;
         } else {
            bw[3] = false;
         }
      } else {
         bw[0] = false;
         bw[1] = false;
         bw[3] = false;
      }

      if (var2 != null) {
         float var52 = var2.getHealth();
         float var55 = Math.max(1.0F, var2.getMaxHealth());
         float var58 = var52 / var55;
         var58 = var58 > 0.0F ? (var58 < 1.0F ? var58 : 1.0F) : 0.0F;
         float var61 = bw[2] && bx ? bv[2] + (var58 - bv[2]) * var7 : var58;
         bv[2] = var61;
         bw[2] = true;
         bx = true;
         int var64 = Math.round(var52 * 10.0F);
         if (as[3] != var64 || at[3] != var8) {
            j(3, 0, var64, n(var64));
         }

         bj[var9] = var4 + 11.0F;
         bk[var9] = var5 - 16.0F;
         bl[var9] = var61;
         bo[var9] = -1944214;
         br[var9] = true;
         bp[var9] = 3;
         bq[var9] = -657929;
         bm[var9] = -1.0F;
         bn[var9] = 0.0F;
         var9++;
         if (var10 > var5 - 16.0F) {
            var10 = var5 - 16.0F;
         }
      } else if (!var3) {
         bw[2] = false;
      }

      for (int var53 = 0; var53 < var9; var53++) {
         float var56 = bj[var53];
         float var60 = bk[var53];
         float var62 = bl[var53];
         float var65 = bm[var53];
         boolean var66 = br[var53];
         float var67 = 80.0F * var62;
         if (var62 < 0.999F || var65 > var62 + 0.004F) {
            float var18 = var56;
            float var71 = var60;
            float var77 = 80.0F;
            float var83 = 8.0F;
            int var88 = -663758554 ^ 946131497;
            if (var77 > 0.0F && var83 > 0.0F && var88 >>> 24 != 0) {
               int var23 = StyleKeyCache.MAG;
               int var24 = Math.round(var18 * var23);
               int var25 = Math.round(var71 * var23);
               int var26 = Math.round((var18 + var77) * var23) - var24;
               int var27 = Math.round((var71 + var83) * var23) - var25;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var23, 1.0F / var23);
                  RasterCache.l(var0, var24, var25, var26, var27, Math.round(2.5F * var23), var88, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         if (var65 > var62 + 0.004F) {
            float var68 = Math.max(5.0F, 80.0F * var65);
            float var72 = var66 ? var56 + 80.0F - var68 : var56;
            float var78 = var60;
            float var84 = var68;
            float var89 = 8.0F;
            int var94 = -164850904 ^ -1345098537;
            if (var84 > 0.0F && var89 > 0.0F && var94 >>> 24 != 0) {
               int var97 = StyleKeyCache.MAG;
               int var100 = Math.round(var72 * var97);
               int var103 = Math.round(var78 * var97);
               int var106 = Math.round((var72 + var84) * var97) - var100;
               int var28 = Math.round((var78 + var89) * var97) - var103;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var97, 1.0F / var97);
                  RasterCache.l(var0, var100, var103, var106, var28, Math.round(2.5F * var97), var94, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         if (var67 > 0.5F) {
            float var69 = Math.max(5.0F, var67);
            float var73 = var66 ? var56 + 80.0F - var69 : var56;
            float var79 = var60;
            float var85 = var69;
            float var90 = 8.0F;
            int var95 = bo[var53];
            if (var85 > 0.0F && var90 > 0.0F && var95 >>> 24 != 0) {
               int var98 = StyleKeyCache.MAG;
               int var101 = Math.round(var73 * var98);
               int var104 = Math.round(var79 * var98);
               int var107 = Math.round((var73 + var85) * var98) - var101;
               int var109 = Math.round((var79 + var90) * var98) - var104;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var98, 1.0F / var98);
                  RasterCache.l(var0, var101, var104, var107, var109, Math.round(2.5F * var98), var95, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         float var70 = bn[var53];
         if (var70 > 0.001F) {
            float var74 = var56 + 1.5F;
            float var80 = var60 + 0.5F;
            float var86 = Math.max(1.5F, 80.0F * var70 - 3.0F);
            float var91 = 1.5F;
            int var96 = -723753005 ^ 724885225;
            if (var86 > 0.0F && var91 > 0.0F && var96 >>> 24 != 0) {
               int var99 = StyleKeyCache.MAG;
               int var102 = Math.round(var74 * var99);
               int var105 = Math.round(var80 * var99);
               int var108 = Math.round((var74 + var86) * var99) - var102;
               int var110 = Math.round((var80 + var91) * var99) - var105;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var99, 1.0F / var99);
                  RasterCache.l(var0, var102, var105, var108, var110, Math.min(var108, var110) >> 1, var96, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         int var75 = bp[var53];
         float var81 = av[var75];
         float var87;
         if (var66) {
            float var92 = var56 + 80.0F - var67;
            var87 = var67 >= var81 + 6.0F ? var92 + 3.0F : var92 - 3.0F - var81;
         } else {
            var87 = var56 + (80.0F - var81) * 0.5F;
         }

         int var93 = bi++;
         bd[var93] = au[var75];
         be[var93] = var87;
         bf[var93] = var60 + 5.8F;
         bg[var93] = bq[var53];
         bh[var93] = false;
      }

      return var10;
   }

   private static float g(DrawContext var0, ClientPlayerEntity var1, LivingEntity var2, boolean var3, boolean var4, float var5, float var6) {
      if (cq != 0) {
         System.nanoTime();
      }

      bw[0] = false;
      bw[1] = false;
      bw[2] = false;
      bw[3] = false;
      byte var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = StyleKeyCache.PIP_HP;
      int var11 = 0;
      int var12 = StyleKeyCache.PIP_FOOD;
      int var13 = -1;
      boolean var14 = false;
      boolean var15 = false;
      int var16 = StyleKeyCache.ba;
      float var17 = Float.MAX_VALUE;
      if (var3) {
         int var18 = var1.getArmor();
         var7 = (byte)(var18 > 0 ? Math.min(10, (var18 + 1) / 2) : 0);
         float var19 = var1.getHealth();
         float var20 = var1.getAbsorptionAmount();
         var8 = Math.max(0, Math.min(10, (int)Math.ceil(var20 / 2.0F)));
         var9 = Math.max(0, Math.min(10 - var8, (int)Math.ceil(var19 / 2.0F)));
         var10 = var1.hasStatusEffect(StatusEffects.POISON)
            ? aa
            : (var1.hasStatusEffect(StatusEffects.WITHER) ? ab : (var1.isFrozen() ? ac : StyleKeyCache.PIP_HP));
         var14 = true;
         int var21 = Math.round(var19 + var20);
         if (as[10] != var21 || at[10] != var16) {
            j(10, 0, var21, l(var21));
         }

         int var22 = bi++;
         bd[var22] = au[10];
         be[var22] = var5 - 89.5F - av[10] * 0.5F;
         bf[var22] = var6 - 13.5F;
         bg[var22] = var20 > 0.0F ? -1213094120 ^ 1212441088 : -1031846;
         bh[var22] = true;
         if (cd) {
            var13 = Math.min(10, cf);
         }

         var17 = var7 <= 0 && !cd ? var6 - 17.5F : var6 - 22.5F;
      }

      int var34 = -580224135 ^ 1567259513;
      int var35 = 80392913 ^ -79746817;
      if (var2 != null) {
         float var36 = var2.getHealth();
         float var40 = Math.max(1.0F, var2.getMaxHealth());
         var11 = Math.max(0, Math.min(10, (int)Math.ceil(10.0F * var36 / var40)));
         var12 = af;
         var34 = Math.round(var36);
         var35 = 1341203488 ^ -1340903094;
         var15 = true;
      } else if (var3) {
         int var37 = var1.getHungerManager().getFoodLevel();
         var11 = Math.max(0, Math.min(10, (var37 + 1) / 2));
         var12 = var1.hasStatusEffect(StatusEffects.HUNGER) ? ad : StyleKeyCache.PIP_FOOD;
         var34 = var37;
         var15 = true;
      }

      if (var15) {
         if (as[11] != var34 || at[11] != var16) {
            j(11, 0, var34, l(var34));
         }

         int var38 = bi++;
         bd[var38] = au[11];
         be[var38] = var5 + 89.0F - av[11] * 0.5F;
         bf[var38] = var6 - 13.5F;
         bg[var38] = var35;
         bh[var38] = true;
         if (var17 > var6 - 17.5F) {
            var17 = var6 - 17.5F;
         }
      }

      Matrix3x2fStack var39 = var0.getMatrices();
      int var41 = StyleKeyCache.MAG;
      int var42 = Math.max(1, Math.round(7.6086955F * var41));
      int var23 = Math.max(1, Math.round(7.0F * var41));
      int var24 = Math.round(2.4F * var41);
      var39.pushMatrix();

      try {
         var39.scale(1.0F / var41, 1.0F / var41);

         for (int var25 = 0; var25 < 40; var25++) {
            int var26 = var25 / 10;
            int var27 = var25 - var26 * 10;
            int var28;
            float var29;
            float var30;
            if (var26 == 0) {
               if (var7 <= 0) {
                  var25 += 9;
                  continue;
               }

               var28 = var27 < var7 ? StyleKeyCache.PIP_ARMOR : StyleKeyCache.PIP_EMPTY;
               var29 = var5 - 89.5F + 9.0F * var27;
               var30 = var6 - 19.0F;
            } else if (var26 == 1) {
               if (!var14) {
                  var25 += 9;
                  continue;
               }

               var28 = var27 < var8 ? StyleKeyCache.PIP_ABSORB : (var27 < var8 + var9 ? var10 : StyleKeyCache.PIP_EMPTY);
               var29 = var5 - 89.5F + 9.0F * var27;
               var30 = var6 - 9.0F;
            } else if (var26 == 2) {
               if (!var15) {
                  var25 += 9;
                  continue;
               }

               var28 = 9 - var27 < var11 ? var12 : StyleKeyCache.PIP_EMPTY;
               var29 = var5 + 8.0F + 9.0F * var27;
               var30 = var6 - 9.0F;
            } else {
               if (var13 < 0) {
                  break;
               }

               var28 = 9 - var27 < var13 ? ae : StyleKeyCache.PIP_EMPTY;
               var29 = var5 + 8.0F + 9.0F * var27;
               var30 = var6 - 19.0F;
            }

            if (var4) {
               var0.drawTexture(
                  RenderPipelines.GUI_TEXTURED,
                  t,
                  Math.round(var29 * var41 - var42 * 0.5F),
                  Math.round(var30 * var41 - var42 * 0.5F),
                  1280.0F,
                  0.0F,
                  var42,
                  var42,
                  64,
                  64,
                  1958171645 ^ 1958173373,
                  1378854017 ^ 1378853889,
                  var28
               );
            } else {
               RasterCache.l(
                  var0,
                  Math.round(var29 * var41 - var23 * 0.5F),
                  Math.round(var30 * var41 - var23 * 0.5F),
                  var23,
                  var23,
                  var24,
                  var28,
                  1,
                  true,
                  true,
                  true,
                  true
               );
            }
         }
      } finally {
         var39.popMatrix();
      }

      return var17;
   }

   private static float h(DrawContext var0, ClientPlayerEntity var1, ClientPlayerInteractionManager var2, boolean var3, float var4, float var5, float var6) {
      if (cq != 0) {
         Thread.currentThread().getName().length();
      }

      boolean var7 = var2.hasExperienceBar();
      JumpingMount var8 = var1.getJumpingMount();
      float var9 = var3 ? var5 - 5.0F : var5 - 6.0F;
      float var10 = Float.MAX_VALUE;
      if (var8 != null) {
         float var11;
         int var12;
         if (var8.getJumpCooldown() > 0) {
            var11 = 1.0F;
            var12 = 102430511 ^ 1595602735 | StyleKeyCache.A & (-1006332674 ^ -990156031);
         } else {
            var11 = Math.max(0.0F, Math.min(1.0F, var1.getMountJumpStrength()));
            var12 = StyleKeyCache.A;
         }

         float var13 = var4 - 91.0F;
         float var14 = var9;
         float var15 = 182.0F;
         float var16 = 3.0F;
         int var17 = 762662699 ^ -847363036;
         if (var15 > 0.0F && var16 > 0.0F && var17 >>> 24 != 0) {
            int var18 = StyleKeyCache.MAG;
            int var19 = Math.round(var13 * var18);
            int var20 = Math.round(var14 * var18);
            int var21 = Math.round((var13 + var15) * var18) - var19;
            int var22 = Math.round((var14 + var16) * var18) - var20;
            var0.getMatrices().pushMatrix();

            try {
               var0.getMatrices().scale(1.0F / var18, 1.0F / var18);
               RasterCache.l(var0, var19, var20, var21, var22, Math.min(var21, var22) >> 1, var17, 1, true, true, true, true);
            } finally {
               var0.getMatrices().popMatrix();
            }
         }

         if (var11 > 0.001F) {
            var13 = var4 - 91.0F;
            var14 = var9;
            var15 = Math.max(3.0F, 182.0F * var11);
            var16 = 3.0F;
            var17 = var12;
            if (var15 > 0.0F && var16 > 0.0F && var17 >>> 24 != 0) {
               int var66 = StyleKeyCache.MAG;
               int var69 = Math.round(var13 * var66);
               int var72 = Math.round(var14 * var66);
               int var75 = Math.round((var13 + var15) * var66) - var69;
               int var78 = Math.round((var14 + var16) * var66) - var72;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var66, 1.0F / var66);
                  RasterCache.l(var0, var69, var72, var75, var78, Math.min(var75, var78) >> 1, var17, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         bw[4] = false;
         var10 = var9;
      } else if (var7) {
         float var47 = var1.experienceProgress;
         var47 = var47 > 0.0F ? (var47 < 1.0F ? var47 : 1.0F) : 0.0F;
         int var50 = var1.experienceLevel;
         float var53 = bw[4] && var50 == cb ? bv[4] + (var47 - bv[4]) * (1.0F - (float)Math.exp(-12.0 * var6)) : var47;
         bv[4] = var53;
         bw[4] = true;
         cb = var50;
         float var55 = var4 - 91.0F;
         float var58 = var9;
         float var61 = 182.0F;
         float var64 = 3.0F;
         int var67 = 1136813991 ^ -1547080536;
         if (var61 > 0.0F && var64 > 0.0F && var67 >>> 24 != 0) {
            int var70 = StyleKeyCache.MAG;
            int var73 = Math.round(var55 * var70);
            int var76 = Math.round(var58 * var70);
            int var79 = Math.round((var55 + var61) * var70) - var73;
            int var23 = Math.round((var58 + var64) * var70) - var76;
            var0.getMatrices().pushMatrix();

            try {
               var0.getMatrices().scale(1.0F / var70, 1.0F / var70);
               RasterCache.l(var0, var73, var76, var79, var23, Math.min(var79, var23) >> 1, var67, 1, true, true, true, true);
            } finally {
               var0.getMatrices().popMatrix();
            }
         }

         if (var53 > 0.001F) {
            var55 = var4 - 91.0F;
            var58 = var9;
            var61 = Math.max(3.0F, 182.0F * var53);
            var64 = 3.0F;
            var67 = 598791808 ^ -587588142;
            if (var61 > 0.0F && var64 > 0.0F && var67 >>> 24 != 0) {
               int var71 = StyleKeyCache.MAG;
               int var74 = Math.round(var55 * var71);
               int var77 = Math.round(var58 * var71);
               int var80 = Math.round((var55 + var61) * var71) - var74;
               int var81 = Math.round((var58 + var64) * var71) - var77;
               var0.getMatrices().pushMatrix();

               try {
                  var0.getMatrices().scale(1.0F / var71, 1.0F / var71);
                  RasterCache.l(var0, var74, var77, var80, var81, Math.min(var80, var81) >> 1, var67, 1, true, true, true, true);
               } finally {
                  var0.getMatrices().popMatrix();
               }
            }
         }

         var10 = var9;
      } else {
         bw[4] = false;
      }

      if (var7) {
         int var49 = var1.experienceLevel;
         if (as[5] != var49 || at[5] != StyleKeyCache.ba) {
            j(5, 5, var49, l(var49));
         }

         int var51 = bi++;
         bd[var51] = au[5];
         be[var51] = var4 - av[5] * 0.5F;
         bf[var51] = var5 - 9.3F;
         bg[var51] = -8462246;
         bh[var51] = true;
         if (var10 > var5 - 14.8F) {
            var10 = var5 - 14.8F;
         }
      }

      return var10;
   }

   private static void i(DrawContext var0) {
      if (cq != 0) {
         System.nanoTime();
      }

      assert var0 != null
         && bd.length == 40
         && be.length == 40
         && bf.length == 40
         && bg.length == 40
         && bh.length == 40
         && bi >= 0
         && bi <= 40
         && StyleKeyCache.MAG >= 1
         && StyleKeyCache.MAG <= 3
         && StyleKeyCache.PX > 0.0F
         && StyleKeyCache.ST.length == 12
         && ci >= 0 : TokenExtractor.w(new byte[]{107, 96, 122, 125, 97}, 13);
      int var1 = bi;
      bi = 0;
      if (var1 > 0) {
         TextRenderer var2 = MinecraftClient.getInstance().textRenderer;
         Matrix3x2fStack var3 = var0.getMatrices();
         int var4 = StyleKeyCache.MAG;
         float var5 = StyleKeyCache.PX;
         int var6 = StyleKeyCache.SHADOW & (-153741414 ^ -165025691);

         try {
            for (int var8 = 0; var8 < var1; var8++) {
               Text var7 = bd[var8];
               bd[var8] = null;
               int var9 = bg[var8];
               int var10 = var9 >>> 24 & (537699276 ^ 537699123);
               if (var7 != null && var10 >= 5) {
                  var3.pushMatrix();

                  try {
                     var3.translate((float)Math.round(be[var8] * var4) / var4, (float)Math.round((bf[var8] - 7.0F) * var4) / var4);
                     int var11 = (int)(var10 * 0.78F);
                     if (bh[var8] && var11 >= 5) {
                        var3.translate(var5, var5);
                        var0.drawText(var2, var7, 0, 0, var11 << 24 | var6, false);
                        var3.translate(-var5, -var5);
                     }

                     var0.drawText(var2, var7, 0, 0, var9, false);
                  } finally {
                     var3.popMatrix();
                  }
               }
            }
         } catch (RuntimeException var16) {
            throw var16;
         }
      }
   }

   private static void j(int var0, int var1, int var2, String var3) {
      if (cq != 0) {
         new Object().hashCode();
      }

      as[var0] = var2;
      at[var0] = StyleKeyCache.ba;
      au[var0] = StyleKeyCache.txt(var1, var3);
      av[var0] = StyleKeyCache.f(var1, var3);
   }

   private static void k() {
      if (cq != 0) {
         new Object().hashCode();
      }

      for (int var0 = 0; var0 < 9; var0++) {
         String var1 = l(var0 + 1);
         aw[var0] = StyleKeyCache.txt(0, var1);
         ax[var0] = StyleKeyCache.txt(1, var1);
         ay[var0] = StyleKeyCache.f(1, var1);
      }

      az = StyleKeyCache.ba;
   }

   private static String l(int var0) {
      if (cq != 0) {
         Thread.currentThread().getName().length();
      }

      if (var0 >= 0 && var0 < ba.length) {
         String var1 = ba[var0];
         if (var1 == null) {
            var1 = Integer.toString(var0);
            ba[var0] = var1;
         }

         return var1;
      } else {
         return Integer.toString(var0);
      }
   }

   private static String m(int var0) {
      if (cq != 0) {
         System.nanoTime();
      }

      String var1 = bb[var0];
      if (var1 == null) {
         var1 = l(var0) + q[0];
         bb[var0] = var1;
      }

      return var1;
   }

   private static String n(int var0) {
      if (cq != 0) {
         new Object().hashCode();
      }

      if (var0 < 0) {
         var0 = 0;
      }

      return l(var0 / 10) + q[1] + l(var0 % 10);
   }

   private static void o(ItemStack var0, MinecraftClient var1) {
      if (cq != 0) {
         Thread.currentThread().getName().length();
      }

      ItemStack var2 = cj;
      cj = var0;
      if (var0.isEmpty()) {
         cm = 0L;
      } else if (var2 == null || var2.isEmpty() || !var0.isOf(var2.getItem()) || !var0.getName().equals(var2.getName())) {
         double var3 = (Double)var1.options.getNotificationDisplayTime().getValue();
         cn = (long)(2.0E9 * var3);
         cm = System.nanoTime();
         p(var0);
      }
   }

   private static void p(ItemStack var0) {
      if (cq != 0) {
         new Object().hashCode();
      }

      MutableText var1 = Text.empty().setStyle(StyleKeyCache.ST[6]);
      var1.append(var0.getName());
      Formatting var2 = var0.getRarity().getFormatting();
      if (var2 != null) {
         var1.formatted(var2);
      }

      if (var0.contains(DataComponentTypes.CUSTOM_NAME)) {
         var1.formatted(Formatting.ITALIC);
      }

      ck = var1;
      cl = StyleKeyCache.g(var1);
      co = StyleKeyCache.bb;
   }

   static {
      for (int var0 = 0; var0 < 12; var0++) {
         as[var0] = Integer.MIN_VALUE;
         at[var0] = Integer.MIN_VALUE;
      }

      bd = new Text[40];
      be = new float[40];
      bf = new float[40];
      bg = new int[40];
      bh = new boolean[40];
      bi = 0;
      bj = new float[5];
      bk = new float[5];
      bl = new float[5];
      bm = new float[5];
      bn = new float[5];
      bo = new int[5];
      bp = new int[5];
      bq = new int[5];
      br = new boolean[5];
      bs = false;
      bt = 0.0F;
      bu = 0.0F;
      bv = new float[5];
      bw = new boolean[5];
      bx = false;
      by = 0.0F;
      bz = 0.0F;
      ca = 0L;
      cb = Integer.MIN_VALUE;
      cc = 0;
      cd = false;
      ce = 1.0F;
      cf = 10;
      ci = 0;
      cj = null;
      ck = null;
      cl = 0.0F;
      cm = 0L;
      cn = 0L;
      co = Integer.MIN_VALUE;
   }
}
