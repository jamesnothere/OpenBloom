package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.OptionalInt;
import java.util.function.Supplier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.gl.UniformType;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.util.Identifier;

public final class BlurPaneCache {
   private static final String[] n = new String[]{
      TokenExtractor.w(new byte[]{57, 63, 35, 48, 48, 47, 54}, 80),
      TokenExtractor.w(new byte[]{-48, -56, -42, -62, -56, -52}, 170)
         + NotifyResolver.q(new byte[]{-10, -4, -77, -9, -6}, 152)
         + NotifyResolver.q(new byte[]{77, 80, 82, 116, 81, 84, 118, 106}, 34),
      TokenExtractor.w(new byte[]{66}, 49)
         + YieldKeeper.v(new byte[]{-90, -18, 8, 80, 98, -76, -52, 87, 33, 100, -118, -57}, 207)
         + JoinerWriter.p(new byte[]{28, 6, 8, 17, 25, 21}, 88),
      YieldKeeper.v(new byte[]{34, -19, -79, 97, 106, -11, -92, 122, 44, -17, -91, 125}, 65)
         + TokenExtractor.w(new byte[]{122}, 15)
         + JoinerWriter.p(new byte[]{-3, -1}, 100),
      TokenExtractor.w(new byte[]{-61, -50}, 170) + StringDecoder.d(new byte[]{78, 88, 17, 93, 84, 80, 78, 100, 71, 86, 68, 82, 85, 95}, 60),
      TokenExtractor.w(new byte[]{-67, -93, -68, -70, -2, -78, -68, -86, -118, -74, -69, -93, -85}, 193),
      QueryZone.r(new byte[]{-43, -5, -35, -26}, 159) + NotifyResolver.q(new byte[]{48}, 93) + YieldKeeper.v(new byte[]{110, 80, 63, 10}, 30),
      StringDecoder.d(new byte[]{-18, -35, -46, -50, -43, -35, -55, -13, -37, -46, -40}, 189),
      TokenExtractor.w(new byte[]{-26, -55, -41, -47, -29, -50}, 174)
         + StringDecoder.d(new byte[]{-28}, 138)
         + YieldKeeper.v(new byte[]{6}, 96)
         + StringDecoder.d(new byte[]{85, 90}, 60),
      StringDecoder.d(new byte[]{118, 114}, 26)
         + NotifyResolver.q(new byte[]{-53, -42}, 191)
         + NotifyResolver.q(new byte[]{-93, -66, -93, -29, -68, -95, -127, -120}, 202)
         + QueryZone.r(new byte[]{84, 9, 90, 90, 80, 99}, 35),
      QueryZone.r(new byte[]{62, 50, 52, 33, 39, 2, 17, 69, 12, 97}, 81) + YieldKeeper.v(new byte[]{-57, 35, -116, -128, 41}, 168),
      TokenExtractor.w(new byte[]{-38, -40}, 189)
         + NotifyResolver.q(new byte[]{26, 7, 3, 18, 19, 87, 44, 45, 65}, 110)
         + StringDecoder.d(new byte[]{102, 96}, 21)
         + YieldKeeper.v(new byte[]{-112, 2}, 176),
      YieldKeeper.v(new byte[]{90, 5, -42, -80, 103, 49, 23, -112, -128, 110, 61, -5, -54, -44, 67, 14}, 54) + QueryZone.r(new byte[]{93, 93}, 56),
      StringDecoder.d(new byte[]{60, 56, 38, 59, 61, 32, 59, 119}, 80)
         + TokenExtractor.w(new byte[]{52, 35, 63}, 87)
         + TokenExtractor.w(new byte[]{20}, 97)
         + StringDecoder.d(new byte[]{99, 54, 125}, 23),
      TokenExtractor.w(new byte[]{-44, -42, -54, -43, -43, -42, -49, -127, -58}, 179)
         + StringDecoder.d(new byte[]{9, 21}, 123)
         + StringDecoder.d(new byte[]{-8, -2}, 139)
         + TokenExtractor.w(new byte[]{-84, -5}, 132),
      JoinerWriter.p(new byte[]{-57}, 165)
         + QueryZone.r(new byte[]{-31, -11, -14, -6, -31, -64, -122, -39, -62, -90, -79, -81, -4, -74, -127, -105, -127}, 139),
      YieldKeeper.v(new byte[]{-88, -31, 56, 120, -67, -19, 49, 0, -126, -38, 3, 67}, 196)
         + NotifyResolver.q(new byte[]{42, 127, 56}, 94)
         + YieldKeeper.v(new byte[]{113}, 29)
         + TokenExtractor.w(new byte[]{72, 72}, 62),
      TokenExtractor.w(new byte[]{2, 20, 12, 26, 18, 16, 22, 30, 85, 3, 22, 8, 21, 21, 63, 11, 3, 1, 10}, 117),
      TokenExtractor.w(new byte[]{-12, -20, -10, -30, -20, -24, -20, -26, -77, -5, -20, -16, -21, -19}, 140)
         + QueryZone.r(new byte[]{-39, -20}, 133)
         + NotifyResolver.q(new byte[]{-34}, 177)
         + JoinerWriter.p(new byte[]{91, 93}, 18)
   };
   private static final Supplier<String> o = () -> {
      if (BlurPaneCache.an != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return n[12];
   };
   private static final Supplier<String> p = () -> {
      if (BlurPaneCache.an != 0) {
         Thread.currentThread().getName().length();
      }

      return n[13];
   };
   private static final Supplier<String> q = () -> {
      if (BlurPaneCache.an != 0) {
         System.nanoTime();
      }

      return n[14];
   };
   private static final Supplier<String> r = () -> {
      if (BlurPaneCache.an != 0) {
         System.nanoTime();
      }

      return n[15];
   };
   private static final Supplier<String> s = () -> {
      if (BlurPaneCache.an != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return n[16];
   };
   public static volatile boolean t = false;
   private static int u = 0;
   private static boolean v = false;
   private static final float[] w = new float[]{5.0F, 8.0F, 12.0F};
   private static RenderPipeline x;
   private static RenderPipeline y;
   private static RenderPipeline z;
   private static RenderPipeline aa;
   private static Framebuffer ab;
   private static Framebuffer ac;
   private static Framebuffer ad;
   private static GpuBuffer ae;
   private static GpuBuffer af;
   private static GpuBuffer ag;
   private static int ah = -1;
   private static int ai = -1;
   private static int aj = -1;
   private static final ByteBuffer ak = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
   private static TextureSetup al;
   private static GpuTextureView am;
   public static float us;
   public static float vs;
   private static int an = 0;

   private BlurPaneCache() {
   }

   public static boolean ok() {
      return v;
   }

   public static TextureSetup a() {
      return al;
   }

   public static void b(float var0) {
      if (an != 0) {
         System.nanoTime();
      }

      v = false;
      if (!t) {
         MinecraftClient var1 = MinecraftClient.getInstance();
         Framebuffer var2 = var1.getFramebuffer();

         try {
            v = d(var1, var2, var0);
         } catch (Throwable var4) {
            v = false;
            if (++u >= 3) {
               t = true;
            }
         }
      }
   }

   public static void c() {
      if (an != 0) {
         new Object().hashCode();
      }

      v = false;
   }

   private static boolean d(MinecraftClient var0, Framebuffer var1, float var2) {
      if (an != 0) {
         System.nanoTime();
      }

      if (var1 != null && var1.getColorAttachmentView() != null) {
         int var3 = var1.textureWidth;
         int var4 = var1.textureHeight;
         if (var3 >= 16 && var4 >= 16) {
            int var5 = var3 + 1 >> 1;
            int var6 = var4 + 1 >> 1;
            int var7 = var5 + 1 >> 1;
            int var8 = var6 + 1 >> 1;
            if (x == null) {
               e();
            }

            if (ab == null) {
               ab = new SimpleFramebuffer(n[9], var5, var6, false);
            } else if (ab.textureWidth != var5 || ab.textureHeight != var6) {
               ab.resize(var5, var6);
            }

            if (ac == null) {
               ac = new SimpleFramebuffer(n[10], var7, var8, false);
            } else if (ac.textureWidth != var7 || ac.textureHeight != var8) {
               ac.resize(var7, var8);
            }

            if (ad == null) {
               ad = new SimpleFramebuffer(n[11], var7, var8, false);
            } else if (ad.textureWidth != var7 || ad.textureHeight != var8) {
               ad.resize(var7, var8);
            }

            CommandEncoder var9 = RenderSystem.getDevice().createCommandEncoder();
            if (ae == null) {
               ae = RenderSystem.getDevice().createBuffer(o, -776856738 ^ -776856618, 16L);
               af = RenderSystem.getDevice().createBuffer(p, -1920492193 ^ -1920492073, 16L);
               ag = RenderSystem.getDevice().createBuffer(q, -864832153 ^ -864832017, 16L);
               ah = -1;
               aj = -1;
            }

            if (var7 != ah || var8 != ai) {
               f(var9, ae, var7, var8, var7, var8);
               ah = var7;
               ai = var8;
            }

            int var10 = SyncController.h;
            float var11 = w[var10 <= 0 ? 0 : (var10 >= 2 ? 2 : 1)];
            int var12 = Math.round(var11 * (var2 > 0.25F ? var2 : 2.0F) / 4.0F - 0.5F);
            var12 = var12 < 2 ? 2 : (var12 > 14 ? 14 : var12);
            if (var12 != aj) {
               f(var9, af, 1.0F, 0.0F, var12, 0.0F);
               f(var9, ag, 0.0F, 1.0F, var12, 0.0F);
               aj = var12;
            }

            GpuSampler var13 = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            g(var9, x, var1.getColorAttachmentView(), ab, var13, true);
            g(var9, x, ab.getColorAttachmentView(), ac, var13, true);

            for (int var14 = 0; var14 < 3; var14++) {
               h(var9, ac, ad, af, var13);
               h(var9, ad, ac, ag, var13);
            }

            var9.clearColorTexture(ad.getColorAttachment(), -1923811643 ^ 1926526533);
            g(var9, z, ac.getColorAttachmentView(), ad, var13, false);
            g(var9, aa, ad.getColorAttachmentView(), ac, var13, false);
            GpuTextureView var17 = ac.getColorAttachmentView();
            if (var17 != am || al == null) {
               am = var17;
               al = TextureSetup.of(var17, var13);
            }

            float var15 = var0.getWindow().getScaleFactor();
            us = var15 / var3;
            vs = var15 / var4;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void e() {
      if (an != 0) {
         Thread.currentThread().getName().length();
      }

      x = RenderPipeline.builder(new Snippet[]{RenderPipelines.POST_EFFECT_PROCESSOR_SNIPPET})
         .withLocation(Identifier.of(n[0], n[1]))
         .withVertexShader(n[3])
         .withFragmentShader(n[4])
         .withSampler(n[6])
         .withoutBlend()
         .withColorWrite(true, false)
         .build();
      z = RenderPipeline.builder(new Snippet[]{RenderPipelines.POST_EFFECT_PROCESSOR_SNIPPET})
         .withLocation(Identifier.of(n[0], n[17]))
         .withVertexShader(n[3])
         .withFragmentShader(n[4])
         .withSampler(n[6])
         .withBlend(new BlendFunction(SourceFactor.DST_COLOR, DestFactor.ZERO))
         .withColorWrite(true, false)
         .build();
      aa = RenderPipeline.builder(new Snippet[]{RenderPipelines.POST_EFFECT_PROCESSOR_SNIPPET})
         .withLocation(Identifier.of(n[0], n[18]))
         .withVertexShader(n[3])
         .withFragmentShader(n[4])
         .withSampler(n[6])
         .withBlend(new BlendFunction(SourceFactor.ZERO, DestFactor.ONE_MINUS_SRC_COLOR))
         .withColorWrite(true, false)
         .build();
      y = RenderPipeline.builder(new Snippet[]{RenderPipelines.POST_EFFECT_PROCESSOR_SNIPPET})
         .withLocation(Identifier.of(n[0], n[2]))
         .withVertexShader(n[3])
         .withFragmentShader(n[5])
         .withSampler(n[6])
         .withUniform(n[7], UniformType.UNIFORM_BUFFER)
         .withUniform(n[8], UniformType.UNIFORM_BUFFER)
         .build();
   }

   private static void f(CommandEncoder var0, GpuBuffer var1, float var2, float var3, float var4, float var5) {
      if (an != 0) {
         new Object().hashCode();
      }

      ByteBuffer var6 = ak;
      var6.clear();
      var6.putFloat(0, var2).putFloat(4, var3).putFloat(8, var4).putFloat(12, var5);
      var6.position(0).limit(16);
      var0.writeToBuffer(var1.slice(), var6);
   }

   private static void g(CommandEncoder var0, RenderPipeline var1, GpuTextureView var2, Framebuffer var3, GpuSampler var4, boolean var5) {
      if (an != 0) {
         Thread.currentThread().getName().length();
      }

      if (var5) {
         var0.clearColorTexture(var3.getColorAttachment(), 554895235 ^ -569178237);
      }

      RenderPass var6 = var0.createRenderPass(r, var3.getColorAttachmentView(), OptionalInt.empty());

      try {
         var6.setPipeline(var1);
         var6.bindTexture(n[6], var2, var4);
         var6.draw(0, 3);
      } finally {
         var6.close();
      }
   }

   private static void h(CommandEncoder var0, Framebuffer var1, Framebuffer var2, GpuBuffer var3, GpuSampler var4) {
      if (an != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      RenderPass var5 = var0.createRenderPass(s, var2.getColorAttachmentView(), OptionalInt.empty());

      try {
         var5.setPipeline(y);
         RenderSystem.bindDefaultUniforms(var5);
         var5.setUniform(n[7], ae);
         var5.setUniform(n[8], var3);
         var5.bindTexture(n[6], var1.getColorAttachmentView(), var4);
         var5.draw(0, 3);
      } finally {
         var5.close();
      }
   }
}
