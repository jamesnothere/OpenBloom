package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RawProjectionMatrix;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.DiffuseLighting.Type;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.command.RenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public final class BevelPassCache {
   public static volatile boolean ON;
   public static int SKIN = 1;
   public static int APPLY;
   public static int FINISH;
   public static boolean DRAW_ANIM = true;
   public static boolean GLOW = true;
   public static int GLOW_RGB = 16777215;
   public static int ARM;
   public static int ARM_RGB = 3046399;
   public static int ARM_RIM = 8845055;
   public static int THEME_RGB = 10255359;
   public static float GLOW_STR = 1.0F;
   public static float SPEED = 1.0F;
   public static boolean SWAY = true;
   public static boolean SOUNDS = true;
   public static boolean FIDGETS = true;
   public static float SWAY_AMT = 1.0F;
   public static float ARM_SIZE = 0.6F;
   public static float SND_VOL = 0.6F;
   public static int HOLD_STYLE;
   public static boolean INS_RANDOM;
   public static int KEY = -1;
   private static boolean ao;
   private static int ap = -2;
   private static long aq;
   private static final long ar = 1000000000L;
   public static boolean LIVE;
   public static boolean VAN_LIVE;
   public static boolean ARM_ALT;
   static final Identifier ATLAS = Identifier.of(
      NotifyResolver.q(new byte[]{-19, -23, -15, -32, -8, -19, -56}, 129),
      QueryZone.r(new byte[]{125, 115, 117, 127, 109, 82, 78, 124, 77, 33, 50}, 23) + JoinerWriter.p(new byte[]{0, 17}, 97)
   );
   private static final String as = StringDecoder.d(new byte[]{-47, -24, -10, -18, -25, -15, -83, -51, -25}, 134)
      + QueryZone.r(new byte[]{104, 125, 103, 114, 109, 20, 123}, 31)
      + StringDecoder.d(new byte[]{113, 109, 109, 121, 120, 110}, 31);
   private static volatile boolean at;
   private static volatile boolean au;
   private static volatile NativeImage[] av;
   private static RenderLayer aw;
   private static RenderLayer ax;
   private static RenderLayer ay;
   private static RenderLayer az;
   private static RenderLayer ba;
   private static final int bb = 1;
   private static final int bc = 2;
   private static final int bd = 3;
   private static int be;
   private static final float[] bf = new float[21];
   private static int bg = -1;
   private static int bh = -1;
   private static long bi;
   private static float bj;
   private static float bk;
   private static float bl;
   private static boolean bm;
   private static final float bn = 0.35F;
   private static SoundEvent[] bo;
   private static boolean bp;
   private static Item bq;
   private static int br = -1;
   private static boolean bs;
   private static boolean bt;
   private static Item bu;
   private static int bv = -1;
   private static boolean bw;
   private static boolean bx;
   private static final Quaternionf by = new Quaternionf();
   private static final Matrix3f bz = new Matrix3f();
   private static final float[] ca = new float[12];
   private static final float[] cb = new float[9];
   private static int cc;
   private static int cd;
   private static final float[] ce = new float[]{0.0706F, 0.2F, 0.0706F};
   private static final float[] cf = new float[]{0.0706F, 0.2F, 0.0706F};
   private static Item cg;
   private static ItemStack ch;
   private static ItemRenderState ci;
   static final float ROLL_CAP = 65.0F;
   private static final float[] cj = new float[]{
      0.0706F, 0.2F, 0.0706F, 0.0F, 0.1875F, 0.05F, 0.3125F, 0.398F, -0.18F, 0.196F, 0.125F, 0.008F, 0.0F, 0.0F, 0.0F
   };
   private static final float[] ck = new float[]{0.0F, 0.94F, 0.342F, 0.0F, 0.94F, 0.342F, 0.0F, 0.906F, -0.423F, 0.0F, 0.985F, -0.173F, 0.0F, 1.0F, 0.0F};
   private static final long cl = 700000000L;
   private static final float[] cm = new float[]{
      0.12F, -0.26F, 0.68F, -0.03F, -0.22F, 0.8F, 0.28F, -0.22F, 0.76F, 0.21F, -0.35F, 0.8F, 0.02F, -0.22F, 0.78F, 0.2F, -0.22F, 0.86F, -0.03F, -0.26F, 0.78F
   };
   private static final float cn = 0.88F;
   private static final float co = -0.34F;
   private static final float cp = 0.8F;
   private static final float cq = 14.0F;
   private static final float cr = 7.3F;
   private static final float cs = 4.0F;
   private static final float ct = 5.1F;
   private static final float cu = 0.006F;
   private static final float cv = 2.9F;
   private static final String[] cw = new String[]{
      TokenExtractor.w(new byte[]{63, 57, 37}, 86)
         + QueryZone.r(new byte[]{-21, -29, -28, -11, -65, -49, -61, -57, -53, -89, -86, -92, -9, -82}, 128)
         + QueryZone.r(new byte[]{-35, -61}, 172)
         + YieldKeeper.v(new byte[]{-62, 1, 121, -89}, 180)
   };
   private static final float[] cx = new float[21];
   private static int cy = -1;
   private static long cz;
   private static boolean da;
   private static boolean db;
   private static boolean dc;
   private static int dd = -2;
   private static float de = 1.0F;
   private static float df;
   private static float dg;
   private static float dh;
   private static float di;
   private static final float dj = 9.0F;
   private static double dk;
   private static int dl;
   private static RenderLayer dm;
   private static boolean dn;
   private static RawProjectionMatrix do99;
   private static GpuBufferSlice dp;
   private static final Matrix4f dq = new Matrix4f();
   private static float dr = -1.0F;
   private static int ds = -1;
   private static ItemRenderState dt;
   private static ItemStack du;
   private static int dv;
   private static final int dw = 15728880;
   private static int dy = 0;

   private BevelPassCache() {
   }

   public static void a() {
      if (dy != 0) {
         new Object().hashCode();
      }

      if (!at) {
         at = true;

         try {
            Thread var0 = new Thread(
               BevelPassCache::b,
               YieldKeeper.v(new byte[]{69, 75, 68, 35, 63, 30}, 18)
                  + StringDecoder.d(new byte[]{-92, -60, -30, -2}, 31613445 ^ 31613580)
                  + YieldKeeper.v(new byte[]{61, -61, -118, 57, -124, -73, 61, -37}, 85)
                  + YieldKeeper.v(new byte[]{92, 61, -25, -60}, 44)
            );
            var0.setDaemon(true);
            var0.setPriority(1);
            var0.start();
         } catch (Throwable var1) {
            au = true;
         }
      }
   }

   private static void b() {
      if (dy != 0) {
         new Object().hashCode();
      }

      try {
         BevelArrayCache.bu();
         av = MipmapTextureCache.toImages(BevelTextureCache.s(BevelTextureCache.r()), 175868713 ^ 175869737, 699335064 ^ 699336088);
      } catch (Throwable var1) {
         au = true;
      }
   }

   private static boolean c() {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (ay != null) {
         return true;
      }

      if (!au && av != null && BevelArrayCache.READY) {
         NativeImage[] var0 = av;
         av = null;
         AbstractTexture var1 = null;

         try {
            var1 = new MipmapTextureCache(
               TokenExtractor.w(new byte[]{-80, -74, -86, -87, -87, -74, -81, -24, -83, -87}, 112405001 ^ 112405208)
                  + TokenExtractor.w(new byte[]{62, 60, 42, 45, 53}, 73),
               var0,
               false
            );
            MinecraftClient.getInstance().getTextureManager().registerTexture(ATLAS, var1);
            d();
         } catch (Throwable var3) {
            au = true;
            ay = null;
            return false;
         }

         return ay != null;
      } else {
         return false;
      }
   }

   private static void d() {
      if (dy != 0) {
         new Object().hashCode();
      }

      RenderPipeline var0 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_SNIPPET})
         .withLocation(
            Identifier.of(
               NotifyResolver.q(new byte[]{33, 37, 61, 44, 52, 33, 4}, 77),
               JoinerWriter.p(new byte[]{-89}, 1891696967 ^ 1891697038)
                  + YieldKeeper.v(
                     new byte[]{-54, 54, -116, -32, 70, -68, 16, 55, -46, 48, 114, -44, 34, -119, -7, 111, -72, 24, 112, -38, 58}, 824336111 ^ 824335948
                  )
            )
         )
         .withShaderDefine(
            NotifyResolver.q(new byte[]{-59, -55, -48, -59, -43, -62, -29}, 1327814699 ^ 1327814831)
               + QueryZone.r(new byte[]{37}, 115)
               + NotifyResolver.q(new byte[]{79, 85}, 27)
               + JoinerWriter.p(new byte[]{1, -1}, 84),
            0.1F
         )
         .withShaderDefine(TokenExtractor.w(new byte[]{67, 67, 80, 65, 95, 77}, 13) + YieldKeeper.v(new byte[]{44, -80, 59, -95}, 126))
         .withShaderDefine(
            JoinerWriter.p(new byte[]{-4, -4, 11, -18, -21, -5, -20}, 82)
               + StringDecoder.d(new byte[]{-27, -29, -17, -29, -9}, -2013928844 ^ -2013928744)
               + JoinerWriter.p(new byte[]{-5, -9, -12}, 81)
               + StringDecoder.d(new byte[]{-27, -8, -26, -32, -18}, -1586515631 ^ -1586515460)
         )
         .withCull(false)
         .build();
      RenderPipeline var1 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_SNIPPET})
         .withLocation(
            Identifier.of(
               StringDecoder.d(new byte[]{14, 10, 20, 9, 15, 18, 9}, 98),
               NotifyResolver.q(new byte[]{16, 8, 20, 12, 28, 16, 42, 52, 15, 88, 106, 106, -128, -84}, 96)
                  + QueryZone.r(new byte[]{-58, -40, -24}, -1517260962 ^ -1517260808)
                  + JoinerWriter.p(new byte[]{67, 63, 51, 48}, 48)
            )
         )
         .withShaderDefine(StringDecoder.d(new byte[]{113, 113, 98, 115, 109, 127, 107, 116, 118, 111}, 63))
         .withShaderDefine(
            YieldKeeper.v(new byte[]{120, 35, -3, -101, 79, 22, 62, -7, -88, 93, 30, -41, -14, -67, 109, 40, -62, -123}, 54)
               + StringDecoder.d(new byte[]{33, 41}, 111)
         )
         .withBlend(new BlendFunction(SourceFactor.ONE_MINUS_DST_COLOR, DestFactor.ONE, SourceFactor.ZERO, DestFactor.ONE))
         .withDepthTestFunction(DepthTestFunction.EQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var2 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_EMISSIVE_SNIPPET})
         .withLocation(
            Identifier.of(
               JoinerWriter.p(new byte[]{-91, -95, -85, -98, -98, -87, -96}, 1886210871 ^ 1886211056),
               TokenExtractor.w(new byte[]{-13, -21, -15, -27, -21, -17, -21, -31, -76, -13, -9, -21, -17, -5, -2, -24, -52, -6, -2}, 1010637446 ^ 1010637325)
                  + StringDecoder.d(new byte[]{29, 21}, 113)
            )
         )
         .withShaderDefine(NotifyResolver.q(new byte[]{18, 18, 7}, 92) + TokenExtractor.w(new byte[]{10, 18, 2, 20, 5, 9, 18}, 65))
         .withShaderDefine(
            StringDecoder.d(new byte[]{-47, -47, -62}, 1780461642 ^ 1780461781)
               + QueryZone.r(new byte[]{37, 46, 38, 57, 51, 13, 9, 29, 1, 107, 101, 114, 122, 111, 73, 71, 81}, 101)
         )
         .withColorWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var3 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_EMISSIVE_SNIPPET})
         .withLocation(
            Identifier.of(
               NotifyResolver.q(new byte[]{42, 46, 54, 39, 63, 42, 15}, 70),
               StringDecoder.d(new byte[]{-1, -25, -3, -23, -25, -29, -25, -19}, 533160671 ^ 533160528)
                  + StringDecoder.d(new byte[]{123, 60, 56, 36, 32, 52, 49, 39}, 84)
                  + StringDecoder.d(new byte[]{-10}, -390608514 ^ -390608425)
                  + StringDecoder.d(new byte[]{-38, -56, -44}, -1483373376 ^ -1483373445)
            )
         )
         .withShaderDefine(
            JoinerWriter.p(new byte[]{40, 40, 55, 38, 44}, 38)
               + YieldKeeper.v(new byte[]{-34}, 305399905 ^ 305400058)
               + JoinerWriter.p(new byte[]{-9}, 91)
               + TokenExtractor.w(new byte[]{-7, -13, -22}, 1744218118 ^ 1744218296)
         )
         .withShaderDefine(
            YieldKeeper.v(new byte[]{-48, 115, -123, 59, 87, -26, 22, -71, -64, 109, -122, 55, 74, -19, 5, -88}, 1893994246 ^ 1893994392)
               + StringDecoder.d(new byte[]{74, 86, 82, 90}, 30)
         )
         .withCull(false)
         .build();
      RenderPipeline var4 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_EMISSIVE_SNIPPET})
         .withLocation(
            Identifier.of(
               QueryZone.r(new byte[]{-25, -21, -19, -8, -2, -37, -56}, 1225057369 ^ 1225057489),
               TokenExtractor.w(new byte[]{-32, -6, -30, -16}, -1500199240 ^ -1500199391)
                  + YieldKeeper.v(new byte[]{102, 125, 112, 77, 29}, 10)
                  + TokenExtractor.w(new byte[]{-47, -47, -51, -51, -39, -64}, -1902152433 ^ -1902152260)
                  + QueryZone.r(new byte[]{56, 26, 57, 59, 63, 30}, 79)
            )
         )
         .withShaderDefine(YieldKeeper.v(new byte[]{93, 105, 102, 3, 9, 55}, 19) + NotifyResolver.q(new byte[]{-50, -47, -39, -52}, -1591764041 ^ -1591764181))
         .withShaderDefine(
            YieldKeeper.v(new byte[]{-51, 73, -42, 79, -50, 64, -47, 81, -43, 95, -19, 123, -21, 99, -22, 120, -25, 127, -9, 123}, 233300595 ^ 233300720)
         )
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      aw = RenderLayer.of(
         NotifyResolver.q(new byte[]{114, 118, 110, 127, 103, 114, 87, 112, 55}, 30)
            + QueryZone.r(new byte[]{-21}, -1592925303 ^ -1592925425)
            + QueryZone.r(new byte[]{90, 80, 94, 81}, 42)
            + QueryZone.r(new byte[]{101, 71, 104, 100, 100, 82, 90}, 18),
         RenderSetup.builder(var0).texture(StringDecoder.d(new byte[]{-100, -81, -96, -68, -89, -81, -69, -8}, 703782880 ^ 703782703), ATLAS, () -> {
            if (dy != 0) {
               Math.abs(Integer.MIN_VALUE);
            }

            return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
         }).useLightmap().expectedBufferSize(799106731 ^ 799237803).build()
      );
      az = RenderLayer.of(
         YieldKeeper.v(new byte[]{-3, 75, -57, 44, -68, 19, -102, -41, 112, -60, 72}, 142100024 ^ 142100137)
            + NotifyResolver.q(new byte[]{17, 5, 6, 28, 46, 11, 53, 53, 66}, 97),
         RenderSetup.builder(var1).texture(QueryZone.r(new byte[]{-98, -91, -78, -90, -67, -115, -111, -54}, 1559390152 ^ 1559389958), ATLAS, () -> {
            if (dy != 0) {
               new Object().hashCode();
            }

            return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
         }).useLightmap().expectedBufferSize(1252696215 ^ 1252761751).build()
      );
      ax = RenderLayer.of(
         NotifyResolver.q(new byte[]{84, 80, 72, 89, 65, 84, 113, 86, 17, 7, 47, 49}, 56)
            + NotifyResolver.q(new byte[]{2, 5, 23}, 103)
            + NotifyResolver.q(new byte[]{78, 113, 103, 117}, 17),
         RenderSetup.builder(var3).texture(StringDecoder.d(new byte[]{112, 67, 76, 80, 75, 67, 87, 20}, 35), ATLAS, () -> {
            if (dy != 0) {
               System.nanoTime();
            }

            return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
         }).expectedBufferSize(-1035889440 ^ -1035893536).build()
      );
      ba = RenderLayer.of(
         NotifyResolver.q(new byte[]{45, 41, 49, 32, 56, 45, 8, 47, 104, 126, 86, 72, -76, -117, -15, -1, 41, 15, 105, 77}, 65),
         RenderSetup.builder(var2).texture(QueryZone.r(new byte[]{66, 121, 110, 122, 97, 81, 77, 22}, 18), ATLAS, () -> {
            if (dy != 0) {
               System.nanoTime();
            }

            return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
         }).expectedBufferSize(-1808409910 ^ -1808426294).build()
      );
      ay = RenderLayer.of(
         JoinerWriter.p(
            new byte[]{-95, -99, -89, -102, -102, -91, -100, -115, -106, -102, -98, -102, -114, -117, -101, -123, -116, -112, -110, -103},
            1506764464 ^ 1506764411
         ),
         RenderSetup.builder(var4).texture(JoinerWriter.p(new byte[]{-30, -17, -6, -4, -9, -17, -5, -72}, 113), ATLAS, () -> {
            if (dy != 0) {
               Math.abs(Integer.MIN_VALUE);
            }

            return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
         }).expectedBufferSize(1926438856 ^ 1926701000).build()
      );
   }

   public static void off() {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      LIVE = false;
      VAN_LIVE = false;
      ARM_ALT = false;
      BevelArrayCache.s(0);
      ap = -2;
      bi = 0L;
      bh = -1;
   }

   public static boolean e(ItemStack var0) {
      if (dy != 0) {
         new Object().hashCode();
      }

      ch = var0;
      if (SKIN != 0 && var0 != null && !var0.isEmpty()) {
         Item var1 = var0.getItem();
         int var2 = APPLY;
         if (var1 == bu && var2 == bv) {
            return bw;
         }

         boolean var3;
         if (var2 == 3) {
            var3 = var1 != Items.FILLED_MAP;
         } else {
            boolean var4 = var0.isIn(ItemTags.SWORDS);
            if (var2 == 0) {
               var3 = var4;
            } else if (var2 == 1) {
               var3 = var4 || var0.isIn(ItemTags.AXES);
            } else {
               var3 = var4 || var0.isIn(ItemTags.AXES) || var0.isIn(ItemTags.SPEARS) || var1 == Items.MACE || var1 == Items.TRIDENT;
            }
         }

         bu = var1;
         bv = var2;
         bw = var3;
         return var3;
      } else {
         return false;
      }
   }

   private static int f(ItemStack var0) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var0.isIn(ItemTags.SWORDS)) {
         return 7;
      } else if (var0.isIn(ItemTags.AXES)) {
         return 8;
      } else {
         Item var1 = var0.getItem();
         if (var1 == Items.MACE) {
            return 9;
         } else if (var1 != Items.SHIELD && !var0.isIn(ItemTags.BANNERS)) {
            return var1 != Items.TRIDENT && !var0.isIn(ItemTags.SPEARS) ? 0 : 10;
         } else {
            return 11;
         }
      }
   }

   private static int g() {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      ClientPlayerEntity var0 = MinecraftClient.getInstance().player;
      cd = 0;
      cf[0] = cj[0];
      cf[1] = cj[1];
      cf[2] = cj[2];
      if (var0 == null) {
         return 7;
      }

      ItemStack var1 = var0.getMainHandStack();
      if (var1.isEmpty()) {
         return 7;
      }

      cd = h(var1, cf);
      return f(var1);
   }

   private static int h(ItemStack var0, float[] var1) {
      if (dy != 0) {
         System.nanoTime();
      }

      MinecraftClient var2 = MinecraftClient.getInstance();
      ItemRenderState var3 = null;
      Box var4 = null;
      Item var5 = var0.getItem();
      int var6 = var5 == Items.MACE ? 1 : (var5 == Items.TRIDENT ? 2 : (var0.isIn(ItemTags.SPEARS) ? 3 : 0));
      var1[0] = cj[var6 * 3];
      var1[1] = cj[var6 * 3 + 1];
      var1[2] = cj[var6 * 3 + 2];
      if (var6 == 0 && var2.world != null && var2.player != null) {
         var3 = ci;
         if (var3 == null) {
            var3 = new ItemRenderState();
            ci = var3;
         }

         try {
            var2.getItemModelManager().clearAndUpdate(var3, var0, ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, var2.world, var2.player, 0);
            if (var5 instanceof BlockItem && var3.isSideLit()) {
               var6 = 4;
            }

            var4 = var3.getModelBoundingBox();
         } catch (Throwable var13) {
            var4 = null;
         }

         if (var6 == 4) {
            var1[0] = cj[12];
            var1[1] = cj[13];
            var1[2] = cj[14];
         }

         if (var4 != null) {
            double var7 = (var4.minX + var4.maxX) * 0.5;
            double var9 = (var4.minY + var4.maxY) * 0.5;
            double var11 = (var4.minZ + var4.maxZ) * 0.5;
            if (var7 * var7 + var9 * var9 + var11 * var11 < 4.0) {
               var1[0] = (float)var7;
               var1[1] = (float)var9;
               var1[2] = (float)var11;
            }
         }

         return var6;
      } else {
         return var6;
      }
   }

   public static void i(ClientPlayerEntity var0) {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      MinecraftClient var1 = MinecraftClient.getInstance();
      if (!at) {
         a();
      }

      LIVE = true;
      ARM_ALT = ARM != 0;
      bx = false;
      float var2 = ARM_SIZE < 0.3F ? 0.3F : ARM_SIZE;
      BevelArrayCache.ARM_WS = var2;
      BevelArrayCache.ARM_LS = var2 > 1.0F ? 0.5F + 0.5F * var2 : 1.0F;
      BevelArrayCache.FIDGETS = FIDGETS;
      long var3 = System.nanoTime();
      int var5 = var0.getInventory().getSelectedSlot();
      boolean var6 = var1.currentScreen != null
         || var0.handSwinging
         || var0.isUsingItem()
         || var1.interactionManager != null && var1.interactionManager.isBreakingBlock();
      bt = var6;
      ItemStack var7 = var0.getMainHandStack();
      boolean var8 = e(var7) && be <= 20 && (ay != null || c());
      Item var9 = var7.getItem();
      boolean var10 = var9 != bq || var5 != br;
      if (var10) {
         bq = var9;
         br = var5;
         bs = true;
      }

      int var11 = KEY;
      boolean var12 = var11 != -1 && SlotInspector.a(var11);
      boolean var13 = var3 - aq < 1000000000L;
      boolean var14 = var12 && !ao && var11 == ap && var13 && var1.currentScreen == null;
      ao = var12;
      ap = var11;
      aq = var3;
      byte var15 = 0;
      int var16 = var8 ? SKIN : 0;
      int var17 = bh >= 0 && var13 ? bh : var16;
      bh = -1;
      if (var14 && !var6 && var17 == var16 && BevelArrayCache.p(var15) != 0 && !var7.isEmpty()) {
         int var18 = var17;
         if (var17 == 0) {
            var18 = f(var7);
            cc = h(var7, ce);
            cg = var9;
         }

         BevelArrayCache.ab(var15, BevelArrayCache.u(var18, INS_RANDOM, var3), var17, HOLD_STYLE, var3, SPEED, true);
         bg = var5;
      }

      if (BevelArrayCache.p(var15) >= 0 && (var6 || var5 != bg)) {
         BevelArrayCache.ae(var15, var3, SPEED);
      }

      if (var6 || var10) {
         BevelArrayCache.ag(var15, var3, SPEED);
      }

      int var19 = BevelArrayCache.ah(var15, var3, var17, HOLD_STYLE, SPEED, bf);
      if (var19 > 0) {
         l(var19, false);
      }

      VAN_LIVE = var17 == 0 && (BevelArrayCache.p(var15) == 0 || BevelArrayCache.q(var15));
      k(var1, var0, var3);
   }

   private static void j() {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      float var0 = ARM_SIZE < 0.3F ? 0.3F : ARM_SIZE;
      BevelArrayCache.ARM_WS = var0;
      BevelArrayCache.ARM_LS = var0 > 1.0F ? 0.5F + 0.5F * var0 : 1.0F;
   }

   private static void k(MinecraftClient var0, ClientPlayerEntity var1, long var2) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      Camera var4 = var0.gameRenderer.getCamera();
      Vec3d var5 = var1.getVelocity();
      float var6 = var4.getYaw();
      float var7 = var4.getPitch();
      long var8 = bi;
      bi = var2;
      float var10 = var8 == 0L ? -1.0F : (float)(var2 - var8) * 1.0E-9F;
      float var11 = MathHelper.wrapDegrees(var6 - bj);
      float var12 = var7 - bk;
      bj = var6;
      bk = var7;
      float var13 = var0.getRenderTickCounter().getTickProgress(true);
      float var14 = var1.getState().getReverseLerpedDistanceMoved(var13) * (float) Math.PI;
      float var15 = var0.options.getBobView().getValue() ? var1.getState().lerpMovement(var13) * 10.0F : 0.0F;
      double var16 = Math.toRadians(var6);
      float var18 = (float)((-var5.x * Math.cos(var16) - var5.z * Math.sin(var16)) * 20.0);
      boolean var19 = var1.isOnGround();
      float var20 = 0.0F;
      if (var19 && bm) {
         float var21 = -bl - 0.1F;
         var20 = var21 > 0.0F ? -Math.min(1.1F, var21 * 1.4F) : 0.0F;
      } else if (!var19 && !bm && var5.y > 0.2) {
         var20 = -0.3F;
      }

      bm = !var19;
      if (!var19) {
         bl = (float)var5.y;
      }

      BevelArrayCache.ai(var10, var11, var12, var14, var15, var18, var20, SWAY ? SWAY_AMT : 0.0F);
   }

   private static void l(int var0, boolean var1) {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      if (SOUNDS && !(SND_VOL <= 0.001F) && !bp) {
         MinecraftClient var2 = MinecraftClient.getInstance();
         SoundEvent var3 = null;
         float[] var4 = BevelArrayCache.CUE_TAB;

         try {
            if (bo == null) {
               bo = new SoundEvent[]{
                  SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE,
                  SoundEvents.BLOCK_CHAIN_PLACE,
                  SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,
                  SoundEvents.ENTITY_PLAYER_ATTACK_WEAK,
                  SoundEvents.ITEM_SPYGLASS_USE,
                  SoundEvents.ITEM_SHEARS_SNIP,
                  (SoundEvent)SoundEvents.ITEM_ARMOR_EQUIP_CHAIN.value()
               };
            }

            for (int var5 = 0; var5 < var0; var5++) {
               int var6 = BevelArrayCache.CUE_HIT[var5];
               var3 = bo[(int)var4[var6 + 1]];
               float var7 = var4[var6 + 2] * (0.96F + 0.08F * (float)Math.random());
               float var8 = var4[var6 + 3] * SND_VOL;
               if (var1) {
                  var2.getSoundManager().play(PositionedSoundInstance.ui(var3, var7, var8 * 0.5F));
               } else if (var2.world != null) {
                  var2.world.playSoundClient(var3, SoundCategory.PLAYERS, var8, var7);
               }
            }
         } catch (Throwable var9) {
            bp = true;
         }
      }
   }

   private static void m(AbstractClientPlayerEntity var0, ItemStack var1, float var2) {
      if (dy != 0) {
         System.nanoTime();
      }

      if (bs && var1 == var0.getMainHandStack()) {
         bs = false;
         byte var3 = 0;
         if (DRAW_ANIM && (BevelArrayCache.p(var3) != 0 || BevelArrayCache.ac(var3)) && var2 >= 0.5F && !bt) {
            long var4 = System.nanoTime();
            BevelArrayCache.ab(var3, SKIN * 2 + 1, SKIN, HOLD_STYLE, var4, SPEED, false);
            bg = br;
            int var6 = BevelArrayCache.ah(var3, var4, SKIN, HOLD_STYLE, SPEED, bf);
            if (var6 > 0) {
               l(var6, false);
            }
         }
      }
   }

   public static void n(MatrixStack var0, boolean var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (dy != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var2 = 1;
                  break;
               }
            case 1:
               if (!var1) {
                  var0.scale(-1.0F, 1.0F, 1.0F);
                  var2 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public static boolean o(AbstractClientPlayerEntity var0, ItemStack var1, MatrixStack var2, OrderedRenderCommandQueue var3, int var4, float var5, float var6) {
      if (dy != 0) {
         new Object().hashCode();
      }

      if ((ay != null || c()) && be <= 20) {
         try {
            m(var0, var1, var6);
            int var7 = SKIN;
            if (BevelArrayCache.r(0) != var7) {
               BevelArrayCache.ah(0, System.nanoTime(), var7, HOLD_STYLE, SPEED, bf);
            }

            bh = var7;
            if (SWAY) {
               float var8 = var0.getMainArm() != Arm.LEFT ? 1.0F : -1.0F;
               var2.translate(var8 * BevelArrayCache.SW_X, BevelArrayCache.SW_Y, BevelArrayCache.SW_Z + 0.35F);
               var2.multiply(
                  by.rotationYXZ(
                     (float)Math.toRadians(var8 * BevelArrayCache.SW_YAW),
                     (float)Math.toRadians(BevelArrayCache.SW_PIT),
                     (float)Math.toRadians(var8 * BevelArrayCache.SW_ROLL)
                  )
               );
               var2.translate(0.0F, 0.0F, -0.35F);
            }

            BevelArrayCache.aj(var5);
            float var11 = BevelArrayCache.SL_V;
            if (var11 != 0.0F) {
               var2.translate(-0.25F, 0.27F, 0.72F + var11 * -0.03F);
               var2.multiply(by.rotationYXZ((float)Math.toRadians(var11 * 24.0F), (float)Math.toRadians(var11 * 0.0F), (float)Math.toRadians(var11 * 10.0F)));
               var2.translate(0.25F, -0.27F, -0.72F);
            }

            BevelArrayCache.c(var7, bf);
            p(var2);
            if (!var0.isInvisible()) {
               if (ARM == 0) {
                  s(var0, var2, var3, var4);
               } else if (ARM == 1 && !bx) {
                  bx = true;
                  BevelArrayCache.mul(BevelArrayCache.E, 0, BevelArrayCache.HM, 0, ca, 0);
                  BevelArrayCache.tr(ca, 0.0625F, -0.6125F, -0.0F);
                  r(ca);
                  BevelArrayCache.ap(ca, cb, ARM_RGB, ARM_RIM);
                  var3.submitCustom(var2, ax, BevelPassCache::af);
                  var3.getBatchingQueue(3).submitCustom(var2, ay, BevelPassCache::ag);
               }
            }

            BevelArrayCache.am(var7, FINISH, FINISH == 6 ? THEME_RGB : 464030949 ^ 458715930);
            int var9 = var4 >> 4 & 15;
            dv = GLOW && var9 < 11 ? var4 & (-1980136620 ^ 1980136539) | -511583300 ^ -511583476 : var4;
            var3.submitCustom(var2, aw, BevelPassCache::ab);
            BevelArrayCache.an();
            if (BevelArrayCache.SV > 0) {
               var3.getBatchingQueue(1).submitCustom(var2, az, BevelPassCache::ac);
            }

            if (BevelArrayCache.WN > 0 && (GLOW || ARM == 1)) {
               var3.getBatchingQueue(2).submitCustom(var2, ba, BevelPassCache::ad);
            }

            if (GLOW) {
               BevelArrayCache.ao(var7, GLOW_RGB, GLOW_STR);
               var3.getBatchingQueue(3).submitCustom(var2, ay, BevelPassCache::ae);
            }

            return true;
         } catch (Throwable var10) {
            be++;
            return false;
         }
      } else {
         return false;
      }
   }

   private static void p(MatrixStack var0) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      q(var0);
      Camera var1 = MinecraftClient.getInstance().gameRenderer.getCamera();
      bz.set(var1.getRotation());
      float[] var2 = BevelArrayCache.CAM;
      var2[0] = bz.m00();
      var2[1] = bz.m10();
      var2[2] = bz.m20();
      var2[3] = bz.m01();
      var2[4] = bz.m11();
      var2[5] = bz.m21();
      var2[6] = bz.m02();
      var2[7] = bz.m12();
      var2[8] = bz.m22();
      BevelArrayCache.al();
   }

   private static void q(MatrixStack var0) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      Matrix4f var1 = var0.peek().getPositionMatrix();
      float[] var2 = BevelArrayCache.E;
      var2[0] = var1.m00();
      var2[1] = var1.m10();
      var2[2] = var1.m20();
      var2[3] = var1.m30();
      var2[4] = var1.m01();
      var2[5] = var1.m11();
      var2[6] = var1.m21();
      var2[7] = var1.m31();
      var2[8] = var1.m02();
      var2[9] = var1.m12();
      var2[10] = var1.m22();
      var2[11] = var1.m32();
      Matrix3f var3 = var0.peek().getNormalMatrix();
      float[] var4 = BevelArrayCache.EN;
      var4[0] = var3.m00();
      var4[1] = var3.m10();
      var4[2] = var3.m20();
      var4[3] = var3.m01();
      var4[4] = var3.m11();
      var4[5] = var3.m21();
      var4[6] = var3.m02();
      var4[7] = var3.m12();
      var4[8] = var3.m22();
   }

   private static void r(float[] var0) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      for (int var1 = 0; var1 < 3; var1++) {
         float var2 = var0[var1];
         float var3 = var0[4 + var1];
         float var4 = var0[8 + var1];
         float var5 = (float)Math.sqrt(var2 * var2 + var3 * var3 + var4 * var4);
         if (var5 > 1.0E-6F) {
            var5 = 1.0F / var5;
         }

         cb[var1] = var2 * var5;
         cb[3 + var1] = var3 * var5;
         cb[6 + var1] = var4 * var5;
      }
   }

   private static void s(AbstractClientPlayerEntity var0, MatrixStack var1, OrderedRenderCommandQueue var2, int var3) {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      PlayerEntityRenderer var4 = null;
      Identifier var5 = null;
      var4 = MinecraftClient.getInstance().getEntityRenderDispatcher().getPlayerRenderer(var0);
      var5 = var0.getSkin().body().texturePath();
      boolean var6 = var0.getMainArm() == Arm.LEFT;
      boolean var7 = var0.isModelPartVisible(var6 ? PlayerModelPart.LEFT_SLEEVE : PlayerModelPart.RIGHT_SLEEVE);
      float[] var8 = BevelArrayCache.HM;
      float[] var9 = BevelArrayCache.HQ;
      var1.push();

      try {
         var1.translate(var8[3], var8[7], var8[11]);
         var1.multiply(by.set(var9[0], var9[1], var9[2], var9[3]));
         var1.scale(BevelArrayCache.ARM_WS, BevelArrayCache.ARM_LS, BevelArrayCache.ARM_WS);
         var1.translate(0.0625F, -0.6125F, -0.0F);

         for (int var10 = 0; var10 < 2; var10++) {
            if (var10 == 1) {
               if (var6) {
                  var1.scale(-1.0F, 1.0F, 1.0F);
               }

               var1.translate(-0.3125F, 0.125F, 0.0F);
               var1.multiply(by.rotationZ(0.1F));
               var1.translate(0.0F, -0.125F, 0.0F);
               var1.multiply(by.set(1.0F, 0.0F, 0.0F, 0.0F));
               var1.translate(0.0F, 0.125F, 0.0F);
            }

            var1.multiply(by.rotationZ(-0.1F));
            var1.translate(0.3125F, -0.125F, 0.0F);
            if (var6) {
               var1.scale(-1.0F, 1.0F, 1.0F);
               var4.renderLeftArm(var1, var2, var3, var5, var7);
            } else {
               var4.renderRightArm(var1, var2, var3, var5, var7);
            }
         }
      } finally {
         var1.pop();
      }
   }

   public static boolean t(MatrixStack var0, OrderedRenderCommandQueue var1, float var2, float var3, boolean var4) {
      if (dy != 0) {
         System.nanoTime();
      }

      if (ARM == 2) {
         return true;
      }

      if ((ay != null || c()) && be <= 20 && !bx) {
         try {
            var0.push();

            try {
               if (!var4) {
                  var0.scale(-1.0F, 1.0F, 1.0F);
               }

               bx = true;
               float var5 = (float)Math.sqrt(var3);
               float var6 = -0.3F * (float)Math.sin(var5 * Math.PI);
               float var7 = 0.4F * (float)Math.sin(var5 * Math.PI * 2.0);
               float var8 = -0.4F * (float)Math.sin(var3 * Math.PI);
               var0.translate(var6 + 0.64000005F, var7 - 0.6F + var2 * -0.6F, var8 - 0.71999997F);
               var0.multiply(by.rotationY((float)Math.toRadians(45.0)));
               float var9 = (float)Math.sin(var3 * var3 * Math.PI);
               float var10 = (float)Math.sin(var5 * Math.PI);
               var0.multiply(by.rotationY((float)Math.toRadians(var10 * 70.0F)));
               var0.multiply(by.rotationZ((float)Math.toRadians(var9 * -20.0F)));
               var0.translate(-1.0F, 3.6F, 3.5F);
               var0.multiply(by.rotationZ((float)Math.toRadians(120.0)));
               var0.multiply(by.rotationX((float)Math.toRadians(200.0)));
               var0.multiply(by.rotationY((float)Math.toRadians(-135.0)));
               var0.translate(5.6F, 0.0F, 0.0F);
               var0.translate(-0.3125F, 0.125F, 0.0F);
               var0.multiply(by.rotationZ(0.1F));
               p(var0);
               System.arraycopy(BevelArrayCache.E, 0, ca, 0, 12);
               r(ca);
               BevelArrayCache.ap(ca, cb, ARM_RGB, ARM_RIM);
               var1.submitCustom(var0, ax, BevelPassCache::af);
               var1.getBatchingQueue(3).submitCustom(var0, ay, BevelPassCache::ag);
            } finally {
               var0.pop();
            }

            return true;
         } catch (Throwable var15) {
            be++;
            return false;
         }
      } else {
         return false;
      }
   }

   public static void u(MatrixStack var0, boolean var1) {
      if (dy != 0) {
         new Object().hashCode();
      }

      bh = 0;
      ItemStack var2 = ch;
      if (var2 != null && !var2.isEmpty() && var2.getItem() != cg) {
         cg = var2.getItem();
         cc = h(var2, ce);
      }

      v(var0, var1 ? 1.0F : -1.0F, bf, cc, ce);
   }

   private static void v(MatrixStack var0, float var1, float[] var2, int var3, float[] var4) {
      if (dy != 0) {
         new Object().hashCode();
      }

      var0.translate(var1 * var2[0], var2[1], var2[2]);
      var0.translate(0.0F, 0.2F, 0.0F);
      var0.multiply(by.rotationYXZ((float)Math.toRadians(var1 * var2[4]), (float)Math.toRadians(var2[3]), (float)Math.toRadians(var1 * var2[5])));
      var0.multiply(by.rotationZYX((float)Math.toRadians(var1 * var2[6]), (float)Math.toRadians(var1 * var2[7]), (float)Math.toRadians(var2[8])));
      var0.translate(0.0F, -0.2F, 0.0F);
      float var5 = var2[10];
      float var6 = var2[9];
      if (var3 == 1 || var3 == 3) {
         var6 = 65.0F * (float)Math.sin(Math.toRadians(var6));
      }

      if (var5 != 0.0F || var6 != 0.0F) {
         int var7 = (var3 >= 0 && var3 < 5 ? var3 : 0) * 3;
         float var8 = var1 * var4[0];
         float var9 = var4[1];
         float var10 = var4[2];
         var0.translate(var8, var9, var10);
         var0.multiply(by.rotationX((float)Math.toRadians(var5)));
         var0.multiply(by.rotationAxis((float)Math.toRadians(var1 * var6), 0.0F, ck[var7 + 1], ck[var7 + 2]));
         var0.translate(-var8, -var9, -var10);
      }
   }

   public static void w(boolean var0) {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      long var1 = System.nanoTime();
      a();
      j();
      BevelArrayCache.FIDGETS = FIDGETS;
      int var3 = SKIN;
      byte var4 = 1;
      if (var1 - cz > 700000000L) {
         BevelArrayCache.s(var4);
         dd = -2;
         if (cy < 0) {
            cy = var3;
         }

         da = false;
         db = false;
         de = 1.0F;
         df = 0.0F;
         cz = var1;
      }

      float var5 = (float)(var1 - cz) * 1.0E-9F;
      var5 = var5 > 0.1F ? 0.1F : var5;
      cz = var1;
      int var6 = KEY;
      boolean var7 = var6 > 1 && SlotInspector.a(var6);
      if (var7 && !dc && var6 == dd && var0) {
         da = true;
      }

      dc = var7;
      dd = var6;
      if (var3 != cy) {
         cy = var3;
         db = false;
         if (DRAW_ANIM && BevelArrayCache.DUR[var3 * 2 + 1] > 0.0F) {
            BevelArrayCache.ab(var4, var3 * 2 + 1, var3, HOLD_STYLE, var1, SPEED, false);
         }
      }

      if (da) {
         int var8 = BevelArrayCache.p(var4);
         if (var8 < 0) {
            da = false;
            db = true;
            int var9 = var3 != 0 ? var3 : g();
            BevelArrayCache.ab(var4, BevelArrayCache.u(var9, INS_RANDOM, var1), var3, HOLD_STYLE, var1, SPEED, true);
         } else if (var8 == 0) {
            da = false;
         }
      }

      int var17 = BevelArrayCache.ah(var4, var1, var3, HOLD_STYLE, SPEED, cx);
      if (var17 > 0 && db) {
         l(var17, true);
      }

      float var18 = BevelArrayCache.p(var4) < 0 ? 1.0F : 0.0F;
      float var10 = de - var18;
      float var11 = df + 9.0F * var10;
      float var12 = (float)Math.exp(-9.0F * var5);
      de = var18 + (var10 + var11 * var5) * var12;
      df = (df - 9.0F * var11 * var5) * var12;
      float var13 = de;
      double var14 = dk + var5;
      dk = var14 > 100000.0 ? 0.0 : var14;
      dg = var13 * 14.0F * (float)Math.sin(var14 * (Math.PI * 2) / 7.3F);
      dh = var13 * 4.0F * (float)Math.sin(var14 * (Math.PI * 2) / 5.1F + 0.7);
      di = var13 * 0.006F * (float)Math.sin(var14 * (Math.PI * 2) / 2.9F + 1.9);
   }

   public static void x() {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      da = true;
   }

   public static void y(Immediate var0, MatrixStack var1, int var2, int var3) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      MinecraftClient var4 = MinecraftClient.getInstance();
      ClientPlayerEntity var5 = var4.player;
      GpuBufferSlice var6 = null;
      ProjectionType var7 = null;
      RenderDispatcher var8 = null;
      ItemRenderState var9 = null;
      ItemStack var10 = null;
      ItemDisplayContext var11 = null;
      RenderLayer var12 = null;
      VertexConsumer var13 = null;
      if (var5 != null && var4.world != null && var0 != null && var1 != null && var2 > 0 && var3 > 0 && dl <= 20 && c()) {
         var6 = RenderSystem.getProjectionMatrixBuffer();
         var7 = RenderSystem.getProjectionType();
         var1.push();

         try {
            int var14 = SKIN;
            int var15 = ARM;
            boolean var16 = var14 == 0;
            boolean var17 = var5.getMainArm() != Arm.LEFT;
            float var18 = var17 ? 1.0F : -1.0F;
            z((float)var2 / var3, var16, var17, var14);
            var4.gameRenderer.getDiffuseLighting().setShaderLights(Type.LEVEL);
            var1.loadIdentity();
            var1.translate(var18 * 0.56F, -0.52F, -0.72F);
            float var19 = var18 * -0.176F;
            var1.translate(var19, 0.147F + di, -0.08F);
            var1.multiply(by.rotationYXZ((float)Math.toRadians(var18 * dg), (float)Math.toRadians(dh), 0.0F));
            var1.translate(-var19, -0.147F, 0.08F);
            var8 = var4.gameRenderer.getEntityRenderDispatcher();
            if (!var16) {
               n(var1, var17);
               BevelArrayCache.c(var14, cx);
               q(var1);
               float[] var20 = BevelArrayCache.CAM;
               var20[0] = 1.0F;
               var20[1] = 0.0F;
               var20[2] = 0.0F;
               var20[3] = 0.0F;
               var20[4] = 1.0F;
               var20[5] = 0.0F;
               var20[6] = 0.0F;
               var20[7] = 0.0F;
               var20[8] = 1.0F;
               BevelArrayCache.al();
               if (var15 == 0) {
                  try {
                     s(var5, var1, var8.getQueue(), -1639762768 ^ -1632422848);
                  } finally {
                     var8.render();
                  }

                  var0.draw();
               }

               BevelArrayCache.am(var14, FINISH, FINISH == 6 ? THEME_RGB : -1770592806 ^ -1769399771);
               dv = -1269987776 ^ -1262647632;
               var13 = var0.getBuffer(aw);
               ab(null, var13);
               BevelArrayCache.an();
               if (BevelArrayCache.SV > 0) {
                  var13 = var0.getBuffer(az);
                  ac(null, var13);
               }

               if (var15 == 1) {
                  BevelArrayCache.mul(BevelArrayCache.E, 0, BevelArrayCache.HM, 0, ca, 0);
                  BevelArrayCache.tr(ca, 0.0625F, -0.6125F, -0.0F);
                  r(ca);
                  BevelArrayCache.ap(ca, cb, ARM_RGB, ARM_RIM);
                  var13 = var0.getBuffer(ax);
                  af(null, var13);
               }

               if (BevelArrayCache.WN > 0 && (GLOW || var15 == 1)) {
                  var13 = var0.getBuffer(ba);
                  ad(null, var13);
               }

               if (GLOW || var15 == 1) {
                  var12 = aa();
                  var13 = var0.getBuffer(var12);
                  if (GLOW) {
                     BevelArrayCache.ao(var14, GLOW_RGB, GLOW_STR);
                     ah(var13, BevelArrayCache.GP, BevelArrayCache.GT, BevelArrayCache.GC, BevelArrayCache.GV);
                  }

                  if (var15 == 1) {
                     ah(var13, BevelArrayCache.AGP, BevelArrayCache.AGT, BevelArrayCache.AGC, BevelArrayCache.AGV);
                  }
               }

               var0.draw();
               return;
            }

            v(var1, var18, cx, cd, cf);
            var10 = var5.getMainHandStack();
            if (var10.isEmpty()) {
               var10 = du;
               if (var10 == null) {
                  var10 = new ItemStack(Items.DIAMOND_SWORD);
                  du = var10;
               }
            }

            var9 = dt;
            if (var9 == null) {
               var9 = new ItemRenderState();
               dt = var9;
            }

            var11 = var17 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND;
            var4.getItemModelManager().clearAndUpdate(var9, var10, var11, var4.world, var5, var5.getId() + var11.ordinal());

            try {
               var9.render(var1, var8.getQueue(), -1696098498 ^ -1709729842, OverlayTexture.DEFAULT_UV, 0);
            } finally {
               var8.render();
            }

            var0.draw();
         } catch (Throwable var37) {
            dl++;
            return;
         } finally {
            var1.pop();
            if (var6 != null && var7 != null) {
               RenderSystem.setProjectionMatrix(var6, var7);
            }
         }
      }
   }

   private static void z(float var0, boolean var1, boolean var2, int var3) {
      if (dy != 0) {
         new Object().hashCode();
      }

      int var4 = var3 > 0 && var3 * 3 + 2 < cm.length ? var3 * 3 : 0;
      int var5 = (var1 ? 2 : 0) | (var2 ? 0 : 1) | var4 << 2;
      if (do99 == null) {
         do99 = new RawProjectionMatrix(cw[0]);
         dp = null;
      }

      if (dp == null || var0 != dr || var5 != ds) {
         float var6 = var1 ? 0.88F : cm[var4];
         float var7 = var1 ? -0.34F : cm[var4 + 1];
         float var8 = var1 ? 0.8F : cm[var4 + 2];
         float var9 = var8 * var0;
         if (var9 < var8) {
            var9 = var8;
            var8 = var9 / var0;
         }

         float var10 = 0.05F;
         if (!var2) {
            var6 = -var6;
         }

         dq.setFrustum((var6 - var9) * var10, (var6 + var9) * var10, (var7 - var8) * var10, (var7 + var8) * var10, var10, 40.0F);
         dp = do99.set(dq);
         dr = var0;
         ds = var5;
      }

      RenderSystem.setProjectionMatrix(dp, ProjectionType.PERSPECTIVE);
   }

   private static RenderLayer aa() {
      if (dy != 0) {
         System.nanoTime();
      }

      RenderPipeline var0 = null;
      if (dm == null && !dn) {
         try {
            var0 = RenderPipeline.builder(new Snippet[]{RenderPipelines.ENTITY_EMISSIVE_SNIPPET})
               .withLocation(
                  Identifier.of(
                     JoinerWriter.p(new byte[]{38, 34, 44, 31, 31, 42, 33}, 70),
                     YieldKeeper.v(new byte[]{52, -31, -68, 117, 56, -15, -78, 69, 75, -63, -126, 67, 4, -35, -97, 52, -37, -81, 96, 63}, 68)
                        + JoinerWriter.p(new byte[]{65}, 54)
                        + YieldKeeper.v(new byte[]{117, 33, 23}, 42)
                  )
               )
               .withShaderDefine(QueryZone.r(new byte[]{16, 24, 19, 10, 20, 62, 34, 37, 39, 70}, 93))
               .withShaderDefine(
                  JoinerWriter.p(new byte[]{-22, -22, -7, -36, -39, -23, -38, -34, -30, -44, -34, -16}, 100)
                     + JoinerWriter.p(new byte[]{-104, -108, -111, -111}, 1596165796 ^ 1596165648)
                     + StringDecoder.d(new byte[]{72, 84, 80, 88}, 28)
               )
               .withBlend(new BlendFunction(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ZERO, DestFactor.ONE))
               .withDepthWrite(false)
               .withCull(false)
               .build();
            dm = RenderLayer.of(
               JoinerWriter.p(
                  new byte[]{-19, -23, -13, -26, -26, -15, -24, -39, -30, -26, -22, -26, -38, -41, -25, -47, -40, -36, -34, -27, -52, -31, -44}, 127
               ),
               RenderSetup.builder(var0).texture(StringDecoder.d(new byte[]{78, 125, 114, 110, 117, 125, 105, 42}, 29), ATLAS, () -> {
                  if (dy != 0) {
                     System.nanoTime();
                  }

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
               }).expectedBufferSize(490899751 ^ 491161895).build()
            );
         } catch (Throwable var2) {
            dn = true;
         }
      }

      return dm != null ? dm : ay;
   }

   private static void ab(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         System.nanoTime();
      }

      assert var1 != null
         && BevelArrayCache.OP != null
         && BevelArrayCache.OT != null
         && BevelArrayCache.OC != null
         && BevelArrayCache.OV >= 0
         && BevelArrayCache.OV * 3L <= BevelArrayCache.OP.length
         && BevelArrayCache.OV * 2L <= BevelArrayCache.OT.length
         && BevelArrayCache.OV <= BevelArrayCache.OC.length
         && BevelArrayCache.WN >= 0
         && BevelArrayCache.WN <= BevelArrayCache.WQ.length
         && BevelArrayCache.AP.length == 72
         && BevelArrayCache.AT.length == 48
         && BevelArrayCache.AC.length == 24
         && BevelArrayCache.AGP.length == (-2022863373 ^ -2022856589)
         && BevelArrayCache.AGT.length == (-951955665 ^ -951953873)
         && BevelArrayCache.AGC.length == (2078603569 ^ 2078602673) : TokenExtractor.w(new byte[]{49, 58, 63}, 81)
         + JoinerWriter.p(new byte[]{79, 37}, 37)
         + NotifyResolver.q(new byte[]{66}, 44)
         + JoinerWriter.p(new byte[]{78, 74, 72}, 27);
      float[] var2 = BevelArrayCache.OP;
      float[] var3 = BevelArrayCache.OT;
      int[] var4 = BevelArrayCache.OC;
      int var5 = BevelArrayCache.OV;
      int var6 = dv;
      int var7 = OverlayTexture.DEFAULT_UV;

      try {
         for (int var8 = 0; var8 < var5; var8++) {
            var1.vertex(var2[var8 * 3], var2[var8 * 3 + 1], var2[var8 * 3 + 2], var4[var8], var3[var8 * 2], var3[var8 * 2 + 1], var7, var6, 0.0F, 1.0F, 0.0F);
         }
      } catch (RuntimeException var9) {
         throw var9;
      }
   }

   private static void ac(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      assert var1 != null
         && BevelArrayCache.SP != null
         && BevelArrayCache.ST != null
         && BevelArrayCache.SC != null
         && BevelArrayCache.SV >= 0
         && BevelArrayCache.SV * 3L <= BevelArrayCache.SP.length
         && BevelArrayCache.SV * 2L <= BevelArrayCache.ST.length
         && BevelArrayCache.SV <= BevelArrayCache.SC.length
         && BevelArrayCache.OP != null
         && BevelArrayCache.OT != null
         && BevelArrayCache.OC != null
         && BevelArrayCache.OV >= 0
         && BevelArrayCache.WN >= 0
         && BevelArrayCache.WN <= BevelArrayCache.WQ.length
         && BevelArrayCache.AP.length == 72
         && BevelArrayCache.AT.length == 48
         && BevelArrayCache.AC.length == 24 : YieldKeeper.v(new byte[]{95, 25, -57, -100, 113, 44, -13, -77}, 58);
      float[] var2 = BevelArrayCache.SP;
      float[] var3 = BevelArrayCache.ST;
      int[] var4 = BevelArrayCache.SC;
      int var5 = BevelArrayCache.SV;
      int var6 = dv;
      int var7 = OverlayTexture.DEFAULT_UV;

      try {
         for (int var8 = 0; var8 < var5; var8++) {
            var1.vertex(var2[var8 * 3], var2[var8 * 3 + 1], var2[var8 * 3 + 2], var4[var8], var3[var8 * 2], var3[var8 * 2 + 1], var7, var6, 0.0F, 1.0F, 0.0F);
         }
      } catch (RuntimeException var9) {
         throw var9;
      }
   }

   private static void ad(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         Thread.currentThread().getName().length();
      }

      assert var1 != null
         && BevelArrayCache.OP != null
         && BevelArrayCache.WQ != null
         && BevelArrayCache.WN >= 0
         && BevelArrayCache.WN <= BevelArrayCache.WQ.length
         && BevelArrayCache.OV >= 0
         && BevelArrayCache.OV * 3L <= BevelArrayCache.OP.length
         && BevelArrayCache.OT != null
         && BevelArrayCache.OC != null
         && BevelArrayCache.SV >= 0
         && BevelArrayCache.AP.length == 72
         && BevelArrayCache.AT.length == 48
         && BevelArrayCache.AC.length == 24
         && BevelArrayCache.AGP.length == (-1738211417 ^ -1738221017)
         && BevelArrayCache.AGT.length == (-249703396 ^ -249705188)
         && BevelArrayCache.AGC.length == (1726020181 ^ 1726019285) : YieldKeeper.v(new byte[]{-87, -11, 13, 68, -76, -89}, -1696815627 ^ -1696815815)
         + JoinerWriter.p(new byte[]{-82, -90, -77}, 603825490 ^ 603825644);
      float[] var2 = BevelArrayCache.OP;
      int[] var3 = BevelArrayCache.WQ;
      int var4 = BevelArrayCache.WN;
      int var5 = OverlayTexture.DEFAULT_UV;

      try {
         for (int var6 = 0; var6 < var4; var6++) {
            int var7 = var3[var6];

            for (int var8 = var7; var8 < var7 + 4; var8++) {
               var1.vertex(var2[var8 * 3], var2[var8 * 3 + 1], var2[var8 * 3 + 2], -1, 0.0F, 0.0F, var5, 1750091599 ^ 1755334591, 0.0F, 1.0F, 0.0F);
            }
         }
      } catch (RuntimeException var9) {
         throw var9;
      }
   }

   private static void ae(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         new Object().hashCode();
      }

      ah(var1, BevelArrayCache.GP, BevelArrayCache.GT, BevelArrayCache.GC, BevelArrayCache.GV);
   }

   private static void af(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         System.nanoTime();
      }

      assert var1 != null
         && BevelArrayCache.AP.length == 72
         && BevelArrayCache.AT.length == 48
         && BevelArrayCache.AC.length == 24
         && BevelArrayCache.AGP.length == (-314132766 ^ -314141854)
         && BevelArrayCache.AGT.length == (-543876236 ^ -543882636)
         && BevelArrayCache.AGC.length == (873366793 ^ 873367945)
         && BevelArrayCache.AGV >= 0
         && BevelArrayCache.AGV <= (-1495771440 ^ -1495770544)
         && BevelArrayCache.OV >= 0
         && BevelArrayCache.SV >= 0
         && BevelArrayCache.WN >= 0
         && BevelArrayCache.GV >= 0 : StringDecoder.d(new byte[]{7, 14, 9, 21, 39, 21, 9}, 98);
      float[] var2 = BevelArrayCache.AP;
      float[] var3 = BevelArrayCache.AT;
      int[] var4 = BevelArrayCache.AC;
      int var5 = OverlayTexture.DEFAULT_UV;

      try {
         for (int var6 = 0; var6 < 24; var6++) {
            var1.vertex(
               var2[var6 * 3],
               var2[var6 * 3 + 1],
               var2[var6 * 3 + 2],
               var4[var6],
               var3[var6 * 2],
               var3[var6 * 2 + 1],
               var5,
               258141364 ^ 261286980,
               0.0F,
               1.0F,
               0.0F
            );
         }
      } catch (RuntimeException var7) {
         throw var7;
      }
   }

   private static void ag(Entry var0, VertexConsumer var1) {
      if (dy != 0) {
         System.nanoTime();
      }

      ah(var1, BevelArrayCache.AGP, BevelArrayCache.AGT, BevelArrayCache.AGC, BevelArrayCache.AGV);
   }

   private static void ah(VertexConsumer var0, float[] var1, float[] var2, int[] var3, int var4) {
      if (dy != 0) {
         System.nanoTime();
      }

      assert var0 != null
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 >= 0
         && var4 * 3L <= var1.length
         && var4 * 2L <= var2.length
         && var4 <= var3.length
         && BevelArrayCache.AP.length == 72
         && BevelArrayCache.AT.length == 48
         && BevelArrayCache.AC.length == 24
         && BevelArrayCache.AGP.length == (188296474 ^ 188287130)
         && BevelArrayCache.AGT.length == (-1046139694 ^ -1046137390)
         && BevelArrayCache.AGC.length == (238336340 ^ 238335444) : QueryZone.r(new byte[]{14, 4, 3, 7, 21, 43}, 126);
      int var5 = OverlayTexture.DEFAULT_UV;

      try {
         for (int var6 = 0; var6 < var4; var6++) {
            var0.vertex(
               var1[var6 * 3],
               var1[var6 * 3 + 1],
               var1[var6 * 3 + 2],
               var3[var6],
               var2[var6 * 2],
               var2[var6 * 2 + 1],
               var5,
               801849335 ^ 792411911,
               0.0F,
               1.0F,
               0.0F
            );
         }
      } catch (RuntimeException var7) {
         throw var7;
      }
   }
}
