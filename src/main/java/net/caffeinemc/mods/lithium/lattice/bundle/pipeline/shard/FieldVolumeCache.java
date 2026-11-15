package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OutputTarget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.texture.NativeImage.Format;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.chunk.WorldChunk;
import org.joml.Vector3fc;

public final class FieldVolumeCache {
   private static boolean bi = false;
   private static boolean bj = false;
   private static boolean bk = false;
   private static boolean bl = false;
   private static int bm = 0;
   private static RenderLayer bn;
   private static RenderLayer bo;
   private static RenderLayer bp;
   private static RenderLayer bq;
   private static RenderLayer br;
   private static RenderLayer bs;
   private static RenderLayer bt;
   private static RenderLayer bu;
   private static float bv = 0.0F;
   private static int bw = 0;
   private static float bx = 0.0F;
   private static float by = 150.0F;
   private static final Identifier bz = Identifier.of(
      NotifyResolver.q(new byte[]{124, 120, 96, 113, 105, 124, 89}, 16),
      YieldKeeper.v(new byte[]{48, -55}, 92) + QueryZone.r(new byte[]{116, 69, 75, 81, 83, 107, 90, 108, 123, 11, 18, 29}, 40)
   );
   private static final float[] ca = new float[9];
   private static final float[] cb = new float[]{0.74F, 0.78F, 0.84F};
   private static final float[] cc = new float[]{0.16470589F, 0.18039216F, 0.22745098F};
   private static RenderPipeline cd;
   private static RenderPipeline ce;
   private static OutputTarget cf;
   private static final Identifier cg = Identifier.of(
      JoinerWriter.p(new byte[]{-18, -22, -12, -25, -25, -14, -23}, 126),
      QueryZone.r(new byte[]{121, 109}, 22) + StringDecoder.d(new byte[]{-6, -41}, 165) + YieldKeeper.v(new byte[]{-5, 78, -56, 15, -128, 23, 120}, 148)
   );
   public static final Identifier PETAL_TEX = Identifier.of(
      JoinerWriter.p(new byte[]{95, 91, 101, 88, 88, 99, 90}, 13), TokenExtractor.w(new byte[]{-31, -3, -48, -2, -20, -4, -22, -26}, 133)
   );
   private static final int ch = 1024;
   public static final Identifier BRANCH_TEX = Identifier.of(
      YieldKeeper.v(new byte[]{-82, -19, 50, 96, -93, -7, 35}, 194),
      TokenExtractor.w(new byte[]{50, 44, 3, 49}, 91) + TokenExtractor.w(new byte[]{-31, -15, -1}, 154) + NotifyResolver.q(new byte[]{-96, -86}, 195)
   );
   public static final Identifier AURA_TEX = Identifier.of(
      TokenExtractor.w(new byte[]{51, 53, 41, 58, 58, 37, 60}, 90), QueryZone.r(new byte[]{-89, -77, -122, -79, -94, -100, -124}, 200)
   );
   private static final Identifier ci = Identifier.of(
      YieldKeeper.v(new byte[]{-96, -15, 16, 88, -107, -67, -7}, 204), JoinerWriter.p(new byte[]{33, 37, 18, 37, 31, 31, 38}, 75)
   );
   private static final Identifier cj = Identifier.of(
      YieldKeeper.v(new byte[]{115, 87, 41, 20, -14, -49, -76}, 31), StringDecoder.d(new byte[]{66, 94, 115, 94, 95, 69}, 46)
   );
   private static volatile NativeImage ck;
   private static volatile NativeImage cl;
   private static volatile NativeImage cm;
   private static volatile NativeImage cn;
   private static volatile NativeImage co;
   private static volatile boolean cp = false;
   private static volatile boolean cq = false;
   private static volatile boolean cr = false;
   private static volatile boolean cs = false;
   private static volatile boolean ct = false;
   private static volatile boolean cu = false;
   private static volatile boolean cv = false;
   private static boolean cw = false;
   private static boolean cx = false;
   private static boolean cy = false;
   private static boolean cz = false;
   private static boolean da = false;
   private static boolean db = false;
   private static boolean dc = true;
   private static final float[] dd = new float[32];
   private static final float[] de = new float[32];
   private static final float[] df = new float[32];
   private static final float[] dg = new float[32];
   private static final float[] dh = new float[]{0.0F, 0.25F, 0.375F, 0.4375F};
   private static final float[] di = new float[]{0.25F, 0.375F, 0.4375F, 0.46875F};
   private static final float[] dj = new float[]{0.75F, 0.75F, 0.75F, 0.75F};
   private static final float[] dk = new float[]{1.0F, 0.875F, 0.8125F, 0.78125F};
   private static volatile boolean dl = false;
   private static final float[] dm = new float[]{0.5F, 0.75F, 0.875F, 0.9375F};
   private static final float[] dn = new float[]{0.75F, 0.875F, 0.9375F, 0.96875F};
   private static final float[] do99 = new float[]{0.75F, 0.75F, 0.75F, 0.75F};
   private static final float[] dp = new float[]{1.0F, 0.875F, 0.8125F, 0.78125F};
   private static final float[] dq = new float[]{0.875F, 0.875F, 0.9375F};
   private static final float[] dr = new float[]{1.0F, 0.9375F, 0.96875F};
   private static final float[] ds = new float[]{0.5F, 0.625F, 0.625F};
   private static final float[] dt = new float[]{0.625F, 0.6875F, 0.65625F};
   private static final float[] du = new float[64];
   private static final float[] dv = new float[64];
   private static final float[] dw = new float[64];
   private static final float[] dx = new float[64];
   public static boolean dy = false;
   public static boolean dz = false;
   public static float ea = 1.0F;
   private static boolean eb = false;
   private static float ec = 1.0F;
   private static final Random ed = new Random();
   private static final float[] ee = new float[9];
   private static final float ef = (float) (Math.PI * 2);
   private static int eg = 0;
   private static final int eh = 4200;
   private static final double ei = 22.0;
   private static final double ej = 14.0;
   private static final double ek = 22.0;
   private static final double el = 4.5;
   private static final double em = 3.5;
   private static final double en = 11.0;
   private static final double eo = 7.0;
   private static final double[] ep = new double[4200];
   private static final double[] eq = new double[4200];
   private static final double[] er = new double[4200];
   private static final float[] es = new float[4200];
   private static final float[] et = new float[4200];
   private static final float[] eu = new float[4200];
   private static final float[] ev = new float[4200];
   private static final float[] ew = new float[4200];
   private static final float[] fa = new float[4200];
   private static final float[] fb = new float[4200];
   private static final float[] fc = new float[4200];
   private static final float[] fd = new float[4200];
   private static final float[] fe = new float[4200];
   private static final int[] ff = new int[4200];
   private static boolean fg = false;
   private static float fh = 0.0F;
   private static int fi = 0;
   private static int fj = 0;
   private static float fk = 1.0F;
   private static float fl = 0.0F;
   private static float fm = 0.0F;
   private static final int fn = 5000;
   private static final int fo = 10000;
   private static final double fp = 44.0;
   private static final double fq = 22.0;
   private static final double fr = 44.0;
   private static final double[] fs = new double[10000];
   private static final double[] ft = new double[10000];
   private static final double[] fu = new double[10000];
   private static final float[] fv = new float[10000];
   private static final float[] fw = new float[10000];
   private static final float[] fx = new float[10000];
   private static boolean fy = false;
   private static float fz = 0.0F;
   private static final int ga = 520;
   private static final double[] gb = new double[520];
   private static final double[] gc = new double[520];
   private static final double[] gd = new double[520];
   private static final float[] ge = new float[520];
   private static final float[] gf = new float[520];
   private static final float[] gg = new float[520];
   private static final float[] gh = new float[520];
   private static final float[] gi = new float[520];
   private static final float[] gj = new float[520];
   private static final float[] gk = new float[520];
   private static final float[] gl = new float[520];
   private static final float[] gm = new float[520];
   private static boolean gn = false;
   private static float go = 0.0F;
   private static int gp = 0;
   private static int gq = 0;
   private static final int gr = 380;
   private static final int gs = 475;
   private static final double gt = 14.0;
   private static final double gu = 8.0;
   private static final double gv = 14.0;
   private static final double[] gw = new double[475];
   private static final double[] ha = new double[475];
   private static final double[] hb = new double[475];
   private static final float[] hc = new float[475];
   private static final float[] hd = new float[475];
   private static final float[] he = new float[475];
   private static final float[] hf = new float[475];
   private static final float[] hg = new float[475];
   private static final float[] hh = new float[475];
   private static final float[] hi = new float[475];
   private static boolean hj = false;
   private static float hk = 0.0F;
   private static final int hl = 320;
   private static final double[] hm = new double[320];
   private static final double[] hn = new double[320];
   private static final double[] ho = new double[320];
   private static final float[] hp = new float[320];
   private static final float[] hq = new float[320];
   private static final float[] hr = new float[320];
   private static final float[] hs = new float[320];
   private static final float[] ht = new float[320];
   private static final float[] hu = new float[320];
   private static final float[] hv = new float[320];
   private static final float[] hw = new float[320];
   private static final float[] hx = new float[320];
   private static final float[] hy = new float[320];
   private static final float[] hz = new float[320];
   private static boolean ia = false;
   private static float ib = 0.0F;
   private static final int ic = 2800;
   private static final double id = 20.0;
   private static final double ie = 11.0;
   private static final double if99 = 20.0;
   private static final double[] ig = new double[2800];
   private static final double[] ih = new double[2800];
   private static final double[] ii = new double[2800];
   private static final float[] ij = new float[2800];
   private static final float[] ik = new float[2800];
   private static final float[] il = new float[2800];
   private static final float[] im = new float[2800];
   private static final float[] in = new float[2800];
   private static final float[] io = new float[2800];
   private static final float[] ip = new float[2800];
   private static final float[] iq = new float[2800];
   private static final float[] ir = new float[2800];
   private static final float[] is = new float[2800];
   private static boolean it = false;
   private static float iu = 0.0F;
   private static int iv = 0;
   private static int iw = 0;
   private static final int ix = 40;
   private static final double iy = 26.0;
   private static final double iz = 9.0;
   private static final double ja = 26.0;
   private static final double[] jb = new double[40];
   private static final double[] jc = new double[40];
   private static final double[] jd = new double[40];
   private static final float[] je = new float[40];
   private static final float[] jf = new float[40];
   private static final float[] jg = new float[40];
   private static final float[] jh = new float[40];
   private static boolean ji = false;
   private static final int jj = 1100;
   private static final double jk = 18.0;
   private static final double jl = 12.0;
   private static final double jm = 18.0;
   private static final double[] jn = new double[1100];
   private static final double[] jo = new double[1100];
   private static final double[] jp = new double[1100];
   private static final float[] jq = new float[1100];
   private static final float[] jr = new float[1100];
   private static final float[] js = new float[1100];
   private static final float[] jt = new float[1100];
   private static final float[] ju = new float[1100];
   private static boolean jv = false;
   private static float jw = 0.0F;
   private static float jx = 0.0F;
   private static final float jy = 0.8F;
   private static final float jz = 0.6F;
   private static final float ka = 0.3F;
   private static float kb = 1.0F;
   private static final int kc = 4600;
   private static final float kd = 0.1F;
   private static final float ke = 0.45F;
   private static final float kf = 0.06F;
   private static final float kg = 0.038F;
   private static final float kh = 0.125F;
   private static final float ki = 0.06F;
   private static final float kj = 0.09F;
   private static final float kk = 0.078F;
   private static final float kl = 0.3F;
   private static float km = 0.0F;
   private static final float kn = (float) Math.PI;
   private static final double ko = 20.0;
   private static final double kp = 14.0;
   private static final double kq = 20.0;
   private static final double[] kr = new double[4600];
   private static final double[] ks = new double[4600];
   private static final double[] kt = new double[4600];
   private static final float[] ku = new float[4600];
   private static final float[] kv = new float[4600];
   private static final float[] kw = new float[4600];
   private static final float[] kx = new float[4600];
   private static final float[] ky = new float[4600];
   private static final float[] kz = new float[4600];
   private static final float[] la = new float[4600];
   private static final float[] lb = new float[4600];
   private static final float[] lc = new float[4600];
   private static final float[] ld = new float[4600];
   private static final float[] le = new float[4600];
   private static final float[] lf = new float[4600];
   private static final float[] lg = new float[4600];
   private static final float[] lh = new float[4600];
   private static final float[] li = new float[4600];
   private static final float[] lj = new float[4600];
   private static final float[] lk = new float[4600];
   private static final float[] ll = new float[4600];
   private static final float[] lm = new float[4600];
   private static final int[] ln = new int[4600];
   private static boolean lo = false;
   private static float lp = 0.0F;
   private static final int lq = 6000;
   private static final int lr = 450;
   private static final byte ls = 0;
   private static final byte lt = 1;
   private static final byte lu = 2;
   private static final byte lv = 3;
   private static final double[] lw = new double[6000];
   private static final double[] lx = new double[6000];
   private static final double[] ly = new double[6000];
   private static final float[] lz = new float[6000];
   private static final float[] ma = new float[6000];
   private static final float[] mb = new float[6000];
   private static final float[] mc = new float[6000];
   private static final float[] md = new float[6000];
   private static final float[] me = new float[6000];
   private static final float[] mf = new float[6000];
   private static final float[] mg = new float[6000];
   private static final float[] mh = new float[6000];
   private static final float[] mi = new float[6000];
   private static final float[] mj = new float[6000];
   private static final float[] mk = new float[6000];
   private static final float[] ml = new float[6000];
   private static final float[] mm = new float[6000];
   private static final float[] mn = new float[6000];
   private static final float[] mo = new float[6000];
   private static final float[] mp = new float[6000];
   private static final int[] mq = new int[6000];
   private static final int[] mr = new int[6000];
   private static final int[] ms = new int[6000];
   private static final byte[] mt = new byte[6000];
   private static int mu = 0;
   private static int mv = 0;
   private static int mw = 0;
   private static boolean na = false;
   private static float nb = 0.0F;
   private static float nc = 0.0F;
   private static float nd = 0.0F;
   private static float ne = 0.0F;
   private static float nf = 0.0F;
   private static float ng = 0.0F;
   private static final int[] nh = new int[16384];
   private static final float ni = 0.014F;
   private static final float nj = 0.0042F;
   private static final float nk = 0.02F;
   private static final int nl = 36;
   private static final int nm = 384;
   private static final float[] nn = new float[4992];
   private static final float[] no = new float[384];
   private static final int[] np = new int[384];
   private static final int[] nq = new int[384];
   private static int nr = 0;
   private static final int ns = 12;
   private static final double[] nt = new double[12];
   private static final double[] nu = new double[12];
   private static final double[] nv = new double[12];
   private static final float[] nw = new float[12];
   private static final float[] nx = new float[12];
   private static final float[] ny = new float[12];
   private static final float[] nz = new float[12];
   private static final float[] oa = new float[12];
   private static int ob = 0;
   private static boolean oc = false;
   private static double od;
   private static double oe;
   private static double of;
   private static double og;
   private static boolean oh = true;
   private static float oi = 0.0F;
   private static float oj = 0.0F;
   private static float ok = 0.0F;
   private static float ol = 800.0F;
   private static float om = -1.0F;
   private static float on = 0.0F;
   private static float oo = 0.0F;
   private static float op = 0.0F;
   private static long oq = 0L;
   private static boolean or = false;
   private static float os = 0.0F;
   private static float ot = 1.0F;
   private static boolean ou = false;
   private static float ov = 0.0F;
   private static float ow = 0.0F;
   private static float ox = 0.0F;
   private static float oy = 0.0F;
   private static float oz = 1.0F;
   private static float pa = 1.0F;
   private static float pb = 0.0F;
   private static float pc = 0.0F;
   private static float pd = 0.0F;
   private static float pe = 0.0F;
   private static float pf = 0.0F;
   private static float pg = 0.0F;
   private static boolean ph = false;
   private static double pi;
   private static double pj;
   private static double pk;
   private static float pl;
   private static float pm;
   private static float pn;
   private static long po = 0L;
   private static final int pp = 24;
   private static final int pq = 49;
   private static final float pr = -1.0E9F;
   private static final int[] ps = new int[2401];
   private static final float[] pt = new float[2401];
   private static final byte[] pu = new byte[2401];
   private static final float[] pv = new float[2401];
   private static final float[] pw = new float[2401];
   private static final float[] qa = new float[153664];
   private static final byte[] qb = new byte[153664];
   private static final IdentityHashMap<BlockState, Float> qc = new IdentityHashMap<>();
   private static final Mutable qd = new Mutable();
   private static final int[] qe = new int[2401];
   private static final int[] qf = new int[2401];
   private static final float[] qg = new float[2401];
   private static final float[] qh = new float[2401];
   private static int qi = 0;
   private static int qj;
   private static int qk;
   private static long ql = 0L;
   private static boolean qm = false;
   private static boolean qn = false;
   private static int qo = 3;
   private static int qq = 0;

   private FieldVolumeCache() {
   }

   public static void a() {
      if (qq != 0) {
         new Object().hashCode();
      }

      if (!bi) {
         bi = true;

         try {
            ShellArrayCache.a();
         } catch (Throwable var4) {
         }

         try {
            WorldRenderEvents.END_MAIN.register(FieldVolumeCache::d);
         } catch (Throwable var3) {
         }

         try {
            WorldRenderEvents.END_MAIN.addPhaseOrdering(bz, Event.DEFAULT_PHASE);
            WorldRenderEvents.END_MAIN.register(bz, FieldVolumeCache::e);
         } catch (Throwable var2) {
         }

         try {
            Thread var0 = new Thread(
               () -> {
                  if (qq != 0) {
                     new Object().hashCode();
                  }

                  int[] var0x = null;

                  try {
                     var0x = PaletteArrayCache.a();
                  } catch (Throwable var11) {
                     cu = true;
                  }

                  int[] var1x = null;

                  try {
                     var1x = LevelArrayCache.a();
                  } catch (Throwable var10) {
                     cv = true;
                  }

                  if (var0x == null && var1x == null) {
                     cp = true;
                  } else {
                     int[] var2x = new int[524288];
                     if (var0x != null) {
                        System.arraycopy(var0x, 0, var2x, 0, 1814764014 ^ 1815026158);
                     }

                     if (var1x != null) {
                        System.arraycopy(var1x, 0, var2x, -1795104007 ^ -1794841863, 468470323 ^ 468208179);
                     }

                     try {
                        ck = i(var2x, -330733895 ^ -330734407, 883328430 ^ 883327406);
                     } catch (Throwable var9) {
                        cp = true;
                     }
                  }

                  try {
                     cn = i(BatchArrayCache.a(var0x), -1983458773 ^ -1983457749, -2086344822 ^ -2086342774);
                  } catch (Throwable var8) {
                     cs = true;
                  }

                  try {
                     cl = i(SurfaceArrayCache.a(), 1526185694 ^ 1526185182, -1244853964 ^ -1244853836);
                  } catch (Throwable var7) {
                     cq = true;
                  }

                  try {
                     int[] var12 = SampleArrayCache.a();

                     try {
                        StrataArrayCache.l(var12);
                        dl = true;
                     } catch (Throwable var5) {
                        dl = false;
                     }

                     cm = i(var12, -258792506 ^ -258793018, 1649171590 ^ 1649172102);
                  } catch (Throwable var6) {
                     cr = true;
                  }

                  try {
                     co = i(AreaArrayCache.a(), -1197773441 ^ -1197772929, 1031033817 ^ 1031033561);
                  } catch (Throwable var4x) {
                     ct = true;
                  }
               },
               JoinerWriter.p(new byte[]{-100, -77}, -1977118268 ^ -1977118337)
                  + YieldKeeper.v(new byte[]{24, -65, 91, -38, 63, 48, -113, 36, -46, 77, -5, -107, 79, -114}, 106)
                  + JoinerWriter.p(new byte[]{16}, 81)
                  + NotifyResolver.q(new byte[]{-47, -34}, -1837535315 ^ -1837535465)
            );
            var0.setDaemon(true);
            var0.setPriority(1);
            var0.start();
         } catch (Throwable var1) {
            cp = true;
            cq = true;
            cr = true;
            cs = true;
            ct = true;
         }
      }
   }

   public static boolean b() {
      if (qq != 0) {
         System.nanoTime();
      }

      if (db) {
         return true;
      }

      if (ct) {
         return false;
      }

      NativeImage var0 = co;
      if (var0 == null) {
         return false;
      }

      co = null;

      try {
         if (j(
            MinecraftClient.getInstance(),
            AURA_TEX,
            JoinerWriter.p(new byte[]{-101, -105}, 503677611 ^ 503677562)
               + QueryZone.r(new byte[]{-90}, 504275697 ^ 504275488)
               + JoinerWriter.p(new byte[]{12, 12, 23, 14}, 92)
               + TokenExtractor.w(new byte[]{-99, -42, -61, -57, -43}, -34021319 ^ -34021246),
            var0
         )) {
            db = true;
         } else {
            ct = true;
         }
      } catch (Throwable var2) {
         ct = true;
      }

      return db;
   }

   public static float c() {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      LerpZoneBuffer var0 = LerpZoneBuffer.I;
      if (!bl && var0 != null && LerpZoneBuffer.LIC) {
         float var1 = var0.cv * var0.da;
         float[] var2 = var0.pw;
         float var3 = var1 * var2[7] * 0.85F;
         if (eb) {
            var3 += var1 * (var2[2] + var2[5]) * 2.0F;
         }

         if (ShellArrayCache.am) {
            var3 += var1 * var2[9] * 2.0F;
         }

         if (ShellArrayCache.ay) {
            var3 += var1 * var2[11] * 2.0F;
         }

         if (ShellArrayCache.an) {
            var3 += var1 * (var2[1] + var2[7]) * 2.0F;
         }

         return var3 >= 1.0F ? 0.0F : 1.0F - var3;
      } else {
         return 1.0F;
      }
   }

   private static void d(WorldRenderContext var0) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      boolean var1 = !dz || dy;
      dy = false;
      bx = 0.0F;
      if (bl) {
         eb = false;
      } else {
         boolean var2 = false;

         try {
            LerpZoneBuffer var3 = LerpZoneBuffer.I;
            if (var3 == null || ConfigBridge.c == null) {
               return;
            }

            MinecraftClient var4 = MinecraftClient.getInstance();
            if (var4.world == null || var4.player == null) {
               return;
            }

            int var5 = System.identityHashCode(var4.world);
            if (var5 != eg) {
               eg = var5;
               n();
            }

            if (!LerpZoneBuffer.ae) {
               ph = false;
               po = System.nanoTime();
               if (na) {
                  o();
               }

               nb = 0.0F;
               nc = 0.0F;
               nd = 0.0F;
               return;
            }

            var3.a();
            if (!LerpZoneBuffer.LIC) {
               return;
            }

            long var6 = System.nanoTime();
            float[] var8 = var3.pw;
            float var9 = var8[0];
            float var10 = var8[1];
            float var11 = var8[7];
            float var12 = var8[8];
            float var13 = var3.cw;
            boolean var14 = var1 && var6 - var3.et < 250000000L;
            float var15 = var14 ? var3.cv * var3.da : 0.0F;
            float var16 = var14 ? var15 * var10 * ea : 0.0F;
            float var17 = var8[5];
            float var18 = var8[2] + var17;
            float var19 = var18 > 1.0E-4F ? var17 / var18 : 0.0F;
            float var20 = var14 ? var15 * var18 * ea : 0.0F;
            float var21 = var14 ? var15 * var11 * ea : 0.0F;
            float var22 = Math.min(1.0F, 1.45F * (var3.cv * var3.da)) * var8[11];
            if (!(var13 <= 0.002F) || !(var16 <= 0.002F) || !(var20 <= 0.002F) || !(var21 <= 0.002F) || !(var22 <= 0.002F)) {
               float var23 = po == 0L ? 0.0F : (float)(var6 - po) / 1.0E9F;
               po = var6;
               if (var23 < 0.0F) {
                  var23 = 0.0F;
               }

               if (var23 > 0.1F) {
                  var23 = 0.1F;
               }

               if (!bj) {
                  h(var4);
               }

               if (!bk) {
                  return;
               }

               if (dc) {
                  l(var4);
               }

               try {
                  float var24 = var4.getWindow().getFramebufferHeight();
                  int var25 = (Integer)var4.options.getFov().getValue();
                  ol = var24 / (2.0F * (float)Math.tan(Math.toRadians(var25) * 0.5));
                  float var26 = var4.getWindow().getFramebufferWidth();
                  double var27 = Math.tan(Math.toRadians(Math.min(170.0, var25 * 1.5)) * 0.5);
                  double var29 = var27 * var26 / var24;
                  float var31 = (float)(1.0 / Math.sqrt(1.0 + var27 * var27 + var29 * var29)) - 0.05F;
                  or = var31 > 0.02F && var26 >= 1.0F && var24 >= 1.0F;
                  os = var31 * var31;
                  ot = (float)Math.sqrt(1.0 - var31 * var31);
                  if (var4.player.hurtTime > 0
                     || var4.player.nauseaIntensity > 0.0F
                     || var4.player.lastNauseaIntensity > 0.0F
                     || var4.player.hasStatusEffect(StatusEffects.NAUSEA)) {
                     or = false;
                  }
               } catch (Throwable var93) {
                  ol = 800.0F;
                  or = false;
               }

               Camera var99 = var4.gameRenderer.getCamera();
               Vec3d var100 = var99.getCameraPos();
               Vector3fc var101 = var99.getHorizontalPlane();
               Vector3fc var102 = var99.getVerticalPlane();
               Vector3fc var28 = var99.getDiagonalPlane();
               float[] var103 = ee;
               var103[0] = -var28.x();
               var103[1] = -var28.y();
               var103[2] = -var28.z();
               var103[3] = var102.x();
               var103[4] = var102.y();
               var103[5] = var102.z();
               var103[6] = var101.x();
               var103[7] = var101.y();
               var103[8] = var101.z();
               float var30 = 1.0F;
               boolean var104 = false;

               try {
                  CameraSubmersionType var32 = var99.getSubmersionType();
                  var104 = var32 == CameraSubmersionType.WATER;
                  if (var32 != CameraSubmersionType.LAVA && var32 != CameraSubmersionType.POWDER_SNOW) {
                     if (var99.getFocusedEntity() instanceof LivingEntity var33
                        && (var33.hasStatusEffect(StatusEffects.BLINDNESS) || var33.hasStatusEffect(StatusEffects.DARKNESS))) {
                        var30 = 0.0F;
                     }
                  } else {
                     var30 = 0.0F;
                  }
               } catch (Throwable var92) {
               }

               ec = ec + (var30 - ec) * (1.0F - (float)Math.exp(-var23 * 6.0F));
               float var105 = ec;
               bv = bv + ((var104 ? 0.0F : 1.0F) - bv) * (1.0F - (float)Math.exp(-var23 * 5.0F));
               q(var100, var23);
               float var106 = cu ? 0.0F : var8[2];
               float var107 = cv ? 0.0F : var8[5];
               float var35 = var106 + var107;
               float var36 = var35 > 1.0E-4F ? var107 / var35 : 0.0F;
               boolean var37 = cw && (var13 > 0.002F && var35 > 0.001F || na);
               float var38 = var8[10];
               float var39 = var8[11];
               boolean var40 = var13 > 0.002F
                  && (
                     var9 > 0.001F
                        || var10 > 0.001F
                        || var11 > 0.001F
                        || var12 > 0.001F
                        || var38 > 0.001F
                        || var39 > 0.001F
                        || var8[3] + var8[4] + var8[9] + var8[12] > 0.001F
                  );
               r(var4, var100, var6, var40, var37);
               p(var99, var104);
               VertexConsumerProvider var41 = var0.consumers();
               Entry var42 = var0.matrices().peek();
               ou = (var42.getPositionMatrix().properties() & 4) != 0;
               double var43 = var3.dd;
               float var45 = 0.35F + 0.65F * var3.da;
               ov = var3.di;
               ow = var3.db;
               ox = var3.dh;
               oy = var3.dc;
               oz = var3.ev;
               pa = var3.ew;
               float var46 = var9 + var38 + var39;
               float var47 = var13 * (var9 + 0.8F * var38 + var39) * var45 * var105;
               if (var46 > 1.0E-4F) {
                  fk = var9 / var46;
                  fl = var38 / var46;
                  fm = var39 / var46;
               }

               float var48 = var10 + 0.6F * var12;
               float var49 = var13 * var48 * var45 * var105;
               float var50 = var48 > 1.0E-4F ? 0.6F * var12 / var48 : 0.0F;
               kb = var10 + var12 > 1.0E-4F ? (var10 + 0.3F * var12) / (var10 + var12) : 1.0F;
               float var51 = var13 * var35 * var45 * var105;
               float var52 = var13 * var8[6] * var45 * var105;
               float var53 = var13 * var11 * var45 * var105;
               float var54 = var12 + 0.8F * var10;
               float var55 = var13 * var54 * var45 * var105;
               jx = var54 > 1.0E-4F ? 0.8F * var10 / var54 : 0.0F;
               km = var51 < 0.05F ? var36 : km + (var36 - km) * (1.0F - (float)Math.exp(-var23 * 0.8F));
               boolean var56 = var13 > 0.002F && var3.v();
               var16 *= var105;
               var20 *= var105;
               var21 *= var105;
               float var57 = Math.max(150.0F, var4.options.getClampedViewDistance() * 16.0F * 1.5F);
               float var58 = var4.gameRenderer.getFarPlaneDistance();
               if (var58 > 10.0F && var57 > var58 / 2.4F) {
                  var57 = var58 / 2.4F;
               }

               float var59 = var3.er * (float) (Math.PI / 180.0);
               om = -MathHelper.sin(var59);
               on = MathHelper.cos(var59);
               float var60 = om * var57;
               float var61 = on * var57;
               float var62 = !(var16 > 0.002F) && !(var20 > 0.002F) && !(var21 > 0.002F) ? 0.0F : var3.eu;
               boolean var63 = cw && qn && var56 && var35 > 0.01F;
               nb = nb + ((var63 ? 1.0F : 0.0F) - nb) * (1.0F - (float)Math.exp(-var23 * 2.5F));
               float var64 = 1.0F - (float)Math.exp(-var23 * 3.0F);
               float var65 = 1.0F - (float)Math.exp(-var23 * 0.6F);
               nc = nc + ((var106 > 0.02F ? 1.0F : 0.0F) - nc) * (var106 > 0.02F ? var64 : var65);
               nd = nd + ((var107 > 0.02F ? 1.0F : 0.0F) - nd) * (var107 > 0.02F ? var64 : var65);
               boolean var66 = cw && qn && (var63 || na && nb > 0.01F);
               if (!var66 && na) {
                  o();
               }

               boolean var67 = cw && var51 > 0.002F;
               if (var67 || var66) {
                  w(var4, var100, var23);
               }

               float var68 = var22 * bv * var105;
               bx = var68 > 1.0F ? 1.0F : var68;
               by = var57;
               boolean var69 = false;
               if (var20 > 0.002F && cx) {
                  y(var4, var100, var60, var61, var6, var23);
                  VertexConsumer var70 = var41.getBuffer(bs);
                  SurfaceArrayCache.j(var70, var42, var60, var61, 0.0F, var57, var20 * Math.max(var62, 0.35F), oy, var43, var103, oo, var19);
                  var69 = true;
                  var2 = true;
               }

               boolean var108 = false;
               boolean var71 = var20 > 0.002F && !cx;
               boolean var72 = var16 > 0.002F || var71 || var21 > 0.002F;
               if (var72) {
                  VertexConsumer var73 = var41.getBuffer(bp);
                  if (var16 > 0.002F) {
                     av(var73, var42, var60, var61, var16 * Math.max(var62, 0.35F), var43, var57, var103);
                  }

                  if (var21 > 0.002F) {
                     ay(var73, var42, var60, var61, var21 * var62, var43, var57, var103);
                  }

                  if (var71) {
                     aw(var73, var42, var60, var61, var20 * Math.max(var62, 0.35F), var43, var57, var103, var19);
                  }

                  var108 = true;
               }

               boolean var109 = false;
               boolean var74 = false;
               if (var53 > 0.002F && cy) {
                  VertexConsumer var75 = var41.getBuffer(br);
                  am(var75, var42, var100, var23, var43, var53, var103, true);
                  var74 = true;
               }

               if (var53 > 0.002F) {
                  VertexConsumer var110 = var41.getBuffer(bn);
                  if (!cy) {
                     am(var110, var42, var100, var23, var43, var53, var103, false);
                  }

                  ak(var110, var42, var100, var23, var43, var53, var103);
                  var109 = true;
               }

               if (var55 > 0.002F) {
                  VertexConsumer var111 = var41.getBuffer(cy ? br : bn);
                  ao(var111, var42, var100, var23, var43, var55, var103, cy);
                  if (cy) {
                     var74 = true;
                  } else {
                     var109 = true;
                  }
               }

               if (var47 > 0.002F) {
                  VertexConsumer var112 = var41.getBuffer(cy ? br : bn);
                  ab(var112, var42, var100, var23, var43, var47, var103, cy);
                  if (cy && dl && fl + fm > 0.01F) {
                     ac(var112, var42, var100, var23, var43, var47, var103);
                  } else {
                     fz = 0.0F;
                  }

                  if (cy) {
                     var74 = true;
                  } else {
                     var109 = true;
                  }
               }

               boolean var113 = false;
               if (var67 || var66) {
                  VertexConsumer var76 = var41.getBuffer(bq);
                  nr = 0;
                  if (var66) {
                     nf = var106 > 0.02F ? nf + var23 : 0.0F;
                     ng = var107 > 0.02F ? ng + var23 : 0.0F;
                     if (var63) {
                        at(var100, var23, var106, var107);
                     }

                     float var77 = var13 * var45 * var35 * nb * var105;
                     au(var76, var42, var100, var23, var43, var8, var77 * nc, var77 * nd, var103);
                  }

                  if (var67) {
                     aq(var76, var42, var100, var23, var43, var51, var103, var63, km, var14 ? oy : 0.0F);
                  }

                  z(var76, var42);
                  var113 = true;
               }

               boolean var114 = false;
               float var115 = var8[3];
               float var78 = var8[4];
               float var79 = var8[9];
               float var80 = var8[12];
               float var81 = var13 * (var115 + 0.8F * var78 + 0.7F * var79 + 0.3F * var80) * var45 * var105;
               if (var49 > 0.002F || var81 > 0.002F || var52 > 0.002F) {
                  VertexConsumer var82 = var41.getBuffer(bo);
                  if (var49 > 0.002F) {
                     ae(var82, var42, var100, var23, var43, var49, var103, var50);
                  }

                  if (var81 > 0.002F) {
                     float var83 = var115 + var78 + var79 + var80;
                     float var84 = var83 > 1.0E-4F ? var78 / var83 : 0.0F;
                     float var85 = var83 > 1.0E-4F ? var79 / var83 : 0.0F;
                     float var86 = var83 > 1.0E-4F ? var80 / var83 : 0.0F;
                     ag(var82, var42, var100, var23, var43, var81, var84, var85, var86, var103);
                  }

                  if (var52 > 0.002F) {
                     ai(var82, var42, var4.world, var100, var23, var43, var52, var103);
                  }

                  var114 = true;
               }

               if (var81 <= 0.002F) {
                  hj = false;
               }

               if (var41 instanceof Immediate var116) {
                  if (var69) {
                     var116.draw(bs);
                  }

                  if (var108) {
                     var116.draw(bp);
                  }

                  if (var109) {
                     var116.draw(bn);
                  }

                  if (var74) {
                     var116.draw(br);
                  }

                  if (var113) {
                     var116.draw(bq);
                  }

                  if (var114) {
                     var116.draw(bo);
                     return;
                  }
               }

               return;
            }

            ph = false;
            po = var6;
            if (na) {
               o();
            }

            nb = 0.0F;
            nc = 0.0F;
            nd = 0.0F;
         } catch (Throwable var94) {
            nr = 0;
            if (++bm > 30) {
               bl = true;
            }

            return;
         } finally {
            eb = var2;
         }
      }
   }

   private static void e(WorldRenderContext var0) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      float var1 = bx;
      if (!(var1 <= 0.003F) && !bl && bt != null && bu != null) {
         try {
            f(var0, var1);
         } catch (Throwable var3) {
            if (++bw > 5) {
               bt = null;
               bu = null;
            }
         }
      }
   }

   private static void f(WorldRenderContext var0, float var1) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      Camera var2 = MinecraftClient.getInstance().gameRenderer.getCamera();
      Vector3fc var3 = var2.getHorizontalPlane();
      Vector3fc var4 = var2.getVerticalPlane();
      Vector3fc var5 = var2.getDiagonalPlane();
      float[] var6 = ca;
      var6[0] = -var5.x();
      var6[1] = -var5.y();
      var6[2] = -var5.z();
      var6[3] = var4.x();
      var6[4] = var4.y();
      var6[5] = var4.z();
      var6[6] = var3.x();
      var6[7] = var3.y();
      var6[8] = var3.z();
      Entry var7 = var0.matrices().peek();
      boolean var8 = (var7.getPositionMatrix().properties() & 4) != 0;
      g(var0.consumers(), var7, var6, by, var1, var8);
   }

   private static void g(VertexConsumerProvider var0, Entry var1, float[] var2, float var3, float var4, boolean var5) {
      if (qq != 0) {
         System.nanoTime();
      }

      float[] var6 = cb;
      float[] var7 = cc;
      int var8 = (int)((1.0F - var4 * (1.0F - var6[0])) * 255.0F + 0.5F);
      int var9 = (int)((1.0F - var4 * (1.0F - var6[1])) * 255.0F + 0.5F);
      int var10 = (int)((1.0F - var4 * (1.0F - var6[2])) * 255.0F + 0.5F);
      int var11 = (int)(var4 * var7[0] * 255.0F + 0.5F);
      int var12 = (int)(var4 * var7[1] * 255.0F + 0.5F);
      int var13 = (int)(var4 * var7[2] * 255.0F + 0.5F);
      float var14 = var2[6] * var3;
      float var15 = var2[7] * var3;
      float var16 = var2[8] * var3;
      float var17 = 32.0F * var3;
      float var18 = var2[0] * var17;
      float var19 = var2[1] * var17;
      float var20 = var2[2] * var17;
      float var21 = var2[3] * var17;
      float var22 = var2[4] * var17;
      float var23 = var2[5] * var17;

      for (int var24 = 0; var24 < 2; var24++) {
         VertexConsumer var25 = var0.getBuffer(var24 == 0 ? bt : bu);
         int var26 = var24 == 0 ? 603401642 ^ -587780694 | var8 << 16 | var9 << 8 | var10 : -132704378 ^ 118953862 | var11 << 16 | var12 << 8 | var13;

         for (int var27 = 0; var27 < 4; var27++) {
            float var28 = var27 != 0 && var27 != 1 ? 1.0F : -1.0F;
            float var29 = var27 != 0 && var27 != 3 ? 1.0F : -1.0F;
            float var30 = var14 + var28 * var18 + var29 * var21;
            float var31 = var15 + var28 * var19 + var29 * var22;
            float var32 = var16 + var28 * var20 + var29 * var23;
            if (var5) {
               var25.vertex(var30, var31, var32).texture(0.5F, 0.5F).color(var26);
            } else {
               var25.vertex(var1, var30, var31, var32).texture(0.5F, 0.5F).color(var26);
            }
         }

         if (var0 instanceof Immediate var33) {
            var33.draw(var24 == 0 ? bt : bu);
         }
      }
   }

   private static void h(MinecraftClient var0) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (!bj) {
         bj = true;

         try {
            byte var1 = 64;
            NativeImage var2 = new NativeImage(Format.RGBA, var1, var1, false);

            for (int var3 = 0; var3 < var1; var3++) {
               for (int var4 = 0; var4 < var1; var4++) {
                  double var5 = (var4 + 0.5) / (var1 * 0.5) - 1.0;
                  double var7 = (var3 + 0.5) / (var1 * 0.5) - 1.0;
                  double var9 = Math.sqrt(var5 * var5 + var7 * var7);
                  double var11 = var9 >= 1.0 ? 0.0 : Math.pow(1.0 - var9, 1.6);
                  int var13 = (int)Math.round(Math.min(1.0, var11 * 1.2) * 255.0);
                  var2.setColorArgb(var4, var3, var13 << 24 | -2135816372 ^ -2142373709);
               }
            }

            var0.getTextureManager().registerTexture(cg, new NativeImageBackedTexture(() -> {
               if (qq != 0) {
                  Thread.currentThread().getName().length();
               }

               return YieldKeeper.v(new byte[]{4, -71, 76, -56, 97, 5, -75, 109, -37, 127, 30, -108, 101, -44, 119, -12}, 104);
            }, var2));

            for (int var16 = 0; var16 < 4; var16++) {
               int var18 = (1806280804 ^ 1806280932) >> var16;

               for (int var20 = 0; var20 < 8; var20++) {
                  int var6;
                  int var21;
                  if (var16 == 0) {
                     var6 = (var20 & 3) * (-1244671688 ^ -1244671560);
                     var21 = (var20 >> 2) * (3065545 ^ 3065417);
                  } else if (var16 == 1) {
                     var6 = (var20 & 3) * 64;
                     var21 = (-1857028652 ^ -1857028908) + (var20 >> 2) * 64;
                  } else if (var16 == 2) {
                     var6 = (-1103003689 ^ -1103003945) + (var20 & 3) * 32;
                     var21 = (545235439 ^ 545235183) + (var20 >> 2) * 32;
                  } else {
                     var6 = (-1634482245 ^ -1634482629) + (var20 & 3) * 16;
                     var21 = (55150484 ^ 55150228) + (var20 >> 2) * 16;
                  }

                  int var8 = var16 * 8 + var20;
                  dd[var8] = var6 / 512.0F;
                  df[var8] = (var6 + var18) / 512.0F;
                  de[var8] = var21 / 512.0F;
                  dg[var8] = (var21 + var18) / 512.0F;

                  for (int var22 = 0; var22 < 2; var22++) {
                     int var10 = var16 * 16 + var22 * 8 + var20;
                     du[var10] = dd[var8];
                     dw[var10] = df[var8];
                     dv[var10] = (var21 + var22 * (169757600 ^ 169757088)) / 1024.0F;
                     dx[var10] = (var21 + var18 + var22 * (-1357680612 ^ -1357680100)) / 1024.0F;
                  }
               }
            }

            cf = new OutputTarget(
               JoinerWriter.p(new byte[]{-101, -105, -95, -108, -108, -97, -106, -121}, 801909872 ^ 801909921)
                  + QueryZone.r(new byte[]{-36, -64, -62, -55, -46, -24, -5, -17, -9, -103}, 203304169 ^ 203304023),
               () -> {
                  if (qq != 0) {
                     new Object().hashCode();
                  }

                  MinecraftClient var0x = MinecraftClient.getInstance();
                  Framebuffer var1x = var0x.worldRenderer == null ? null : var0x.worldRenderer.getTranslucentFramebuffer();
                  return var1x != null ? var1x : var0x.getFramebuffer();
               }
            );
            RenderPipeline var17 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(
                  Identifier.of(
                     StringDecoder.d(new byte[]{-62, -58, -40, -59, -61, -34, -59}, -1670842319 ^ -1670842209),
                     JoinerWriter.p(new byte[]{70, 62, 68}, 42)
                        + QueryZone.r(new byte[]{51, 51, 45, 35, 47, 92, 20, 16}, 85)
                        + YieldKeeper.v(new byte[]{84, 101, 78, 74, 67}, 11)
                  )
               )
               .withBlend(BlendFunction.TRANSLUCENT)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            RenderPipeline var19 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(
                  Identifier.of(
                     QueryZone.r(new byte[]{-37, -41, -47, -60, -62, -25, -12}, 1227577194 ^ 1227577310),
                     QueryZone.r(new byte[]{32, 48, 50, 46, 32, 28, 16, 2, 71, 125, 107, 92, 101, 105, 82}, 83)
                  )
               )
               .withBlend(BlendFunction.LIGHTNING)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            bn = RenderLayer.of(
               QueryZone.r(new byte[]{77, 65}, 34)
                  + TokenExtractor.w(new byte[]{-42, -53, -51, -48, -53, -8, -44, -56, -27, -56, -45, -37, -54}, 1359827866 ^ 1359827762),
               RenderSetup.builder(var17).texture(JoinerWriter.p(new byte[]{-115, -102, -91, -89, -94, -102, -90, 99}, -1281143200 ^ -1281143130), cg, () -> {
                  if (qq != 0) {
                     new Object().hashCode();
                  }

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(cf).expectedBufferSize(1236272268 ^ 1236403340).build()
            );
            bo = RenderLayer.of(
               JoinerWriter.p(new byte[]{-58, -62, -52, -65, -65, -54, -63}, 1668334138 ^ 1668334236)
                  + JoinerWriter.p(new byte[]{-25}, 120)
                  + NotifyResolver.q(new byte[]{43}, 71)
                  + NotifyResolver.q(new byte[]{-79, -98, -91, -83, -76}, -1812364227 ^ -1812364035),
               RenderSetup.builder(var19).texture(QueryZone.r(new byte[]{-39, -30, -11, -31, -6, -54, -42, -115}, 2078772685 ^ 2078772548), cg, () -> {
                  if (qq != 0) {
                     Math.abs(Integer.MIN_VALUE);
                  }

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(cf).expectedBufferSize(-1912651517 ^ -1912717053).build()
            );
            bp = RenderLayer.of(
               QueryZone.r(new byte[]{-22, -26, -32, -11, -13, -42, -59, -18, -46}, -956805827 ^ -956805704)
                  + NotifyResolver.q(new byte[]{44, 3, 42, 63, 52, 37, 29, 8}, 93),
               RenderSetup.builder(var19).texture(NotifyResolver.q(new byte[]{45, 30, 23, 7, 2, 2, 40, 127}, 126), cg, () -> {
                  if (qq != 0) {
                     new Object().hashCode();
                  }

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(-2054093431 ^ -2054089335).build()
            );
            cd = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(
                  Identifier.of(
                     NotifyResolver.q(new byte[]{-22, -18, -10, -25, -1, -22, -49}, 2111044088 ^ 2111043966),
                     StringDecoder.d(new byte[]{-3, -27, -1, -21, -27, -31, -27, -17, -86, -24}, -837762356 ^ -837762495)
                        + NotifyResolver.q(new byte[]{-73}, -1965642558 ^ -1965642748)
                        + QueryZone.r(new byte[]{32, 6, 8, 16, 2, 54}, 124)
                  )
               )
               .withBlend(BlendFunction.TRANSLUCENT)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            ce = var19;

            try {
               bt = RenderLayer.of(
                  YieldKeeper.v(new byte[]{27, -121, 17, -76, 58, -65, 44, -25, 67, -41, 66, -13, 121, -29, -99, 21, -72, 51, -96, 32}, 119),
                  RenderSetup.builder(
                        RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
                           .withLocation(
                              Identifier.of(
                                 NotifyResolver.q(new byte[]{-61, -57, -33, -50, -42, -61, -26}, 1375422098 ^ 1375422013),
                                 JoinerWriter.p(
                                    new byte[]{-54, -62, -56, -68, -62, -66, -62, -72, -127, -67, -63, -82, -75, -65, -83, -81, -81, -88, -75, -68, -78},
                                    -738354847 ^ -738354745
                                 )
                              )
                           )
                           .withBlend(new BlendFunction(SourceFactor.DST_COLOR, DestFactor.ZERO))
                           .withDepthTestFunction(DepthTestFunction.GREATER_DEPTH_TEST)
                           .withDepthWrite(false)
                           .withCull(false)
                           .build()
                     )
                     .texture(NotifyResolver.q(new byte[]{-46, -31, -24, -8, -3, -3, -41, -128}, -1287201874 ^ -1287202001), cg)
                     .outputTarget(OutputTarget.MAIN_TARGET)
                     .expectedBufferSize(2058577524 ^ 2058577780)
                     .build()
               );
               bu = RenderLayer.of(
                  JoinerWriter.p(new byte[]{1, -3, 7, -6, -6, 5, -4, -19, -7, -3, -22, -15, -5, -23, -21, -21, -28}, 107)
                     + JoinerWriter.p(new byte[]{14, 16, 15}, 83),
                  RenderSetup.builder(
                        RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
                           .withLocation(
                              Identifier.of(
                                 JoinerWriter.p(new byte[]{84, 80, 90, 77, 77, 88, 79}, 24),
                                 NotifyResolver.q(new byte[]{46, 54, 42, 50, 34, 46, 20, 10, 49, 99, 75, 120, -87, -123, -5, -37, 59, 32, 123, 83, -86}, 94)
                              )
                           )
                           .withBlend(BlendFunction.LIGHTNING)
                           .withDepthTestFunction(DepthTestFunction.GREATER_DEPTH_TEST)
                           .withDepthWrite(false)
                           .withCull(false)
                           .build()
                     )
                     .texture(StringDecoder.d(new byte[]{5, 54, 57, 37, 62, 54, 34, 97}, 86), cg)
                     .outputTarget(OutputTarget.MAIN_TARGET)
                     .expectedBufferSize(455974658 ^ 455974402)
                     .build()
               );
            } catch (Throwable var14) {
               bt = null;
               bu = null;
            }

            bk = true;
         } catch (Throwable var15) {
            bk = false;
         }
      }
   }

   private static NativeImage i(int[] var0, int var1, int var2) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      NativeImage var3 = new NativeImage(Format.RGBA, var1, var2, false);

      try {
         for (int var4 = 0; var4 < var2; var4++) {
            int var5 = var4 * var1;

            for (int var6 = 0; var6 < var1; var6++) {
               var3.setColorArgb(var6, var4, var0[var5 + var6]);
            }
         }

         return var3;
      } catch (Throwable var7) {
         var3.close();
         throw var7;
      }
   }

   private static boolean j(MinecraftClient var0, Identifier var1, String var2, NativeImage var3) {
      if (qq != 0) {
         System.nanoTime();
      }

      try {
         var0.getTextureManager().registerTexture(var1, new LayerTextureCache(var2, var3));
         return true;
      } catch (Throwable var5) {
         var3.close();
         return false;
      }
   }

   private static void k(MinecraftClient var0) {
      if (qq != 0) {
         System.nanoTime();
      }

      if (!cz && !cp) {
         NativeImage var1 = ck;
         if (var1 != null) {
            ck = null;
            if (j(
               var0,
               PETAL_TEX,
               QueryZone.r(new byte[]{-59}, -606924247 ^ -606924157)
                  + TokenExtractor.w(new byte[]{-85, -73, -88, -88, -85, -78, -15, -83, -65}, 1831303022 ^ 1831303072)
                  + JoinerWriter.p(new byte[]{40}, 76)
                  + JoinerWriter.p(new byte[]{-109, -99}, -90478373 ^ -90478571),
               var1
            )) {
               cz = true;
            } else {
               cp = true;
            }
         }
      }
   }

   private static void l(MinecraftClient var0) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      k(var0);
      if (cz && !cw && !cp) {
         try {
            bq = RenderLayer.of(
               StringDecoder.d(new byte[]{-6, -2, -32}, 532584368 ^ 532584230)
                  + JoinerWriter.p(new byte[]{51, 51, 62, 53, 38, 50, 54, 35, 51, 39}, 53)
                  + JoinerWriter.p(new byte[]{52}, 64)
                  + StringDecoder.d(new byte[]{120, 116}, 25),
               RenderSetup.builder(cd).texture(YieldKeeper.v(new byte[]{16, -25, -92, 124, 35, -9, -89, 40}, 67), PETAL_TEX, () -> {
                  if (qq != 0) {
                     System.nanoTime();
                  }

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(cf).expectedBufferSize(195790883 ^ 196839459).build()
            );
            cw = true;
         } catch (Throwable var5) {
            cp = true;
         }
      }

      if (!cy && !cr) {
         NativeImage var1 = cm;
         if (var1 != null) {
            cm = null;

            try {
               if (!j(var0, ci, NotifyResolver.q(new byte[]{10, 14, 22, 7, 31, 10, 47, 122, 85, 89, 109, 104}, 102), var1)) {
                  throw new IllegalStateException();
               }

               br = RenderLayer.of(
                  QueryZone.r(new byte[]{127, 115, 117, 96, 102, 67, 80}, 16)
                     + TokenExtractor.w(new byte[]{-22, -34, -62, -17}, 1578587753 ^ 1578587863)
                     + QueryZone.r(new byte[]{-53}, -436177275 ^ -436177346)
                     + YieldKeeper.v(new byte[]{41, -31, -94}, 71),
                  RenderSetup.builder(cd).texture(YieldKeeper.v(new byte[]{-109, -31, 45, 112, -84, -27, 50, 48}, 1553647427 ^ 1553647491), ci, () -> {
                     if (qq != 0) {
                        System.nanoTime();
                     }

                     return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
                  }).outputTarget(cf).expectedBufferSize(-932114831 ^ -931590543).build()
               );
               cy = true;
            } catch (Throwable var4) {
               cr = true;
            }
         }
      }

      if (!cx && !cq) {
         NativeImage var6 = cl;
         if (var6 != null) {
            cl = null;

            try {
               if (!j(
                  var0,
                  cj,
                  JoinerWriter.p(new byte[]{-2, -6, 4, -9, -9}, 110)
                     + JoinerWriter.p(new byte[]{29, 20, -45}, 88)
                     + StringDecoder.d(new byte[]{-7, -2, -26}, -541594943 ^ -541595061),
                  var6
               )) {
                  throw new IllegalStateException();
               }

               bs = RenderLayer.of(
                  NotifyResolver.q(new byte[]{103, 99, 123}, 11) + YieldKeeper.v(new byte[]{88, 9, -27, -83, -81, 76, 33, -33, -61, -107, 126}, 48),
                  RenderSetup.builder(ce).texture(StringDecoder.d(new byte[]{53, 6, 9, 21, 14, 6, 18, 81}, 102), cj, () -> {
                     if (qq != 0) {
                        System.nanoTime();
                     }

                     return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
                  }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(-1124963324 ^ -1124979708).build()
               );
               cx = true;
            } catch (Throwable var3) {
               cq = true;
            }
         }
      }

      dc = !cw && !cp || !cy && !cr || !cx && !cq;
   }

   public static int m() {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         MinecraftClient var0 = MinecraftClient.getInstance();
         k(var0);
         if (!da && !cs && cn != null) {
            boolean var1 = j(
               var0,
               BRANCH_TEX,
               StringDecoder.d(new byte[]{42, 46, 48, 45, 43, 54, 45, 108, 44}, 70)
                  + TokenExtractor.w(new byte[]{-45, -63}, 639755851 ^ 639756000)
                  + NotifyResolver.q(new byte[]{-9}, 1181890997 ^ 1181890860)
                  + JoinerWriter.p(new byte[]{-91, -87}, -410067949 ^ -410067795),
               cn
            );
            cn = null;
            if (var1) {
               da = true;
               SceneLayerCache.b();
            } else {
               cs = true;
            }
         }
      } catch (Throwable var2) {
      }

      return (cz ? 1 : 0) | (da ? 2 : 0);
   }

   private static void n() {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      o();
      nb = 0.0F;
      nc = 0.0F;
      nd = 0.0F;
      qm = false;
      qn = false;
      qi = 0;
      ph = false;
      lo = false;
      fg = false;
      fy = false;
      gn = false;
      hj = false;
      ia = false;
      it = false;
      ji = false;
      jv = false;
      ob = 0;
      oc = false;
      oh = true;
      oi = 0.0F;
      oj = 0.0F;
      qc.clear();
   }

   private static void o() {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      Arrays.fill(mt, (byte)0);
      Arrays.fill(nh, 0);
      mu = 0;
      mv = 0;
      mw = 0;
      na = false;
      nf = 0.0F;
      ng = 0.0F;
      ne = 0.0F;
   }

   private static void p(Camera var0, boolean var1) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      pg = 0.0F;
      if (!var1) {
         try {
            float var2 = MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(false);
            int var3 = (Integer)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_COLOR_VISUAL, var2);
            float var4 = (Float)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_START_DISTANCE_VISUAL, var2);
            float var5 = (Float)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_END_DISTANCE_VISUAL, var2);
            if (var5 > var4 + 0.5F && var5 < 100000.0F) {
               pb = var3 >> 16 & (846203149 ^ 846203378);
               pc = var3 >> 8 & (-1381804183 ^ -1381804138);
               pd = var3 & (1907073320 ^ 1907073495);
               pe = var4;
               pf = 1.0F / (var5 - var4);
               pg = 1.0F;
            }
         } catch (Throwable var6) {
            pg = 0.0F;
         }
      }
   }

   private static void q(Vec3d var0, float var1) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (!ph) {
         pi = var0.x;
         pj = var0.y;
         pk = var0.z;
         pn = 0.0F;
         pm = 0.0F;
         pl = 0.0F;
         ph = true;
      } else {
         double var2 = var0.x - pi;
         double var4 = var0.y - pj;
         double var6 = var0.z - pk;
         pi = var0.x;
         pj = var0.y;
         pk = var0.z;
         if (!(var1 <= 0.0F) && !(var2 * var2 + var4 * var4 + var6 * var6 > 64.0)) {
            float var8 = 1.0F - (float)Math.exp(-var1 * 10.0F);
            pl = pl + ((float)(var2 / var1) - pl) * var8;
            pm = pm + ((float)(var4 / var1) - pm) * var8;
            pn = pn + ((float)(var6 / var1) - pn) * var8;
         }
      }
   }

   private static void r(MinecraftClient var0, Vec3d var1, long var2, boolean var4, boolean var5) {
      if (qq != 0) {
         new Object().hashCode();
      }

      if (var4 || var5) {
         ClientWorld var6 = var0.world;
         int var7 = MathHelper.floor(var1.x);
         int var8 = MathHelper.floor(var1.z);
         if (qm && (!var5 || qn)) {
            boolean var9 = var1.y - var6.getTopY(Type.MOTION_BLOCKING, var7, var8) > 45.0;
            long var10 = var9 ? 1500000000L : 400000000L;
            int var12 = var9 ? 8 : 2;
            if (var2 - ql < var10 && Math.abs(var7 - qj) <= var12 && Math.abs(var8 - qk) <= var12) {
               return;
            }
         }

         int var47 = var6.getBottomY();
         Mutable var48 = qd;
         IdentityHashMap var11 = qc;
         int var49 = -1309637335 ^ 837846313;
         int var13 = -797203719 ^ 1350279929;
         boolean var14 = false;
         WorldChunk var15 = null;

         for (int var16 = -24; var16 <= 24; var16++) {
            int var17 = (var16 + 24) * 49;

            for (int var18 = -24; var18 <= 24; var18++) {
               int var19 = var17 + var18 + 24;
               int var20 = var7 + var18;
               int var21 = var8 + var16;
               if (var20 >> 4 != var49 || var21 >> 4 != var13) {
                  var49 = var20 >> 4;
                  var13 = var21 >> 4;
                  var14 = var49 >= (845903550 ^ -846719626)
                     && var13 >= (-2054155003 ^ 2054387405)
                     && var49 < (-2011474220 ^ -2012755220)
                     && var13 < (-1785622627 ^ -1785916507)
                     && var6.isChunkLoaded(var49, var13);
                  var15 = null;
                  if (var14) {
                     var15 = var6.getChunk(var49, var13);
                  }
               }

               int var22 = var14 ? var15.sampleHeightmap(Type.MOTION_BLOCKING, var20 & 15, var21 & 15) + 1 : var6.getTopY(Type.MOTION_BLOCKING, var20, var21);
               ps[var19] = var22;
               if (var5) {
                  pv[var19] = 0.0F;
                  pw[var19] = 0.0F;

                  try {
                     int var23 = var14
                        ? var15.sampleHeightmap(Type.MOTION_BLOCKING_NO_LEAVES, var20 & 15, var21 & 15) + 1
                        : var6.getTopY(Type.MOTION_BLOCKING_NO_LEAVES, var20, var21);
                     if (var23 <= var47) {
                        pt[var19] = -1.0E9F;
                        pu[var19] = 3;
                     } else {
                        var48.set(var20, var23 - 1, var21);
                        BlockState var24 = var14 ? var15.getBlockState(var48) : var6.getBlockState(var48);
                        boolean var25 = !var24.hasModelOffset() && !var24.hasBlockEntity();
                        Float var26 = var25 ? (Float)var11.get(var24) : null;
                        VoxelShape var27 = null;
                        float var28;
                        if (var26 != null) {
                           var28 = var26;
                        } else {
                           var27 = var24.getOutlineShape(var6, var48);
                           if (!var27.isEmpty() && var27 != VoxelShapes.fullCube()) {
                              float var29 = (float)Math.min(1.0, var27.getMax(Axis.Y));
                              var28 = -var29 - 1.0F;
                              if (var27.getMin(Axis.X) <= 1.0E-4
                                 && var27.getMax(Axis.X) >= 0.9999
                                 && var27.getMin(Axis.Z) <= 1.0E-4
                                 && var27.getMax(Axis.Z) >= 0.9999) {
                                 if (var29 >= 0.999F && Block.isFaceFullSquare(var27, Direction.UP)) {
                                    var28 = 1.0F;
                                 } else {
                                    double var30 = 0.0;
                                    boolean var32 = true;

                                    for (Box var34 : var27.getBoundingBoxes()) {
                                       if (var34.maxY < var29 - 0.01) {
                                          var32 = false;
                                          break;
                                       }

                                       var30 += (var34.maxX - var34.minX) * (var34.maxZ - var34.minZ);
                                    }

                                    if (var32 && var30 >= 0.98) {
                                       var28 = var29;
                                    }
                                 }
                              }
                           } else {
                              var28 = 1.0F;
                           }

                           if (var25) {
                              var11.put(var24, var28);
                           }
                        }

                        float var50 = var28 >= 0.0F ? var28 : -var28 - 1.0F;
                        FluidState var51 = var24.getFluidState();
                        float var31 = -1.0F;
                        boolean var52 = false;
                        if (!var51.isEmpty()) {
                           var31 = var51.getHeight(var6, var48);
                           var52 = var51.isIn(FluidTags.LAVA);
                           if (var31 >= var50 || var24.getCollisionShape(var6, var48).isEmpty()) {
                              pt[var19] = var23 - 1 + var31;
                              if (var52) {
                                 pu[var19] = 2;
                              } else {
                                 pu[var19] = 1;
                                 if (!var51.isStill()) {
                                    Vec3d var54 = var51.getVelocity(var6, var48);
                                    pv[var19] = (float)var54.x;
                                    pw[var19] = (float)var54.z;
                                 }
                              }
                              continue;
                           }
                        }

                        if (var28 >= 0.0F) {
                           pt[var19] = var23 - 1 + var28;
                           pu[var19] = 0;
                        } else {
                           if (var27 == null) {
                              var27 = var24.getOutlineShape(var6, var48);
                           }

                           t(var6, var19, var20, var23 - 1, var21, var47, var24, var27, var50, var31, var52);
                        }

                        int var53 = var23;

                        for (int var55 = 0; var55 < 4; var55++) {
                           var48.set(var20, var53, var21);
                           BlockState var35 = var14 ? var15.getBlockState(var48) : var6.getBlockState(var48);
                           if (var35.isAir()
                              || var35.isOf(Blocks.COBWEB)
                              || var35.isIn(BlockTags.LEAVES)
                              || var35.isIn(BlockTags.RAILS)
                              || !var35.getFluidState().isEmpty()) {
                              break;
                           }

                           boolean var36 = !var35.hasModelOffset() && !var35.hasBlockEntity();
                           Float var37 = var36 ? (Float)var11.get(var35) : null;
                           float var38;
                           if (var37 != null) {
                              var38 = var37;
                           } else {
                              VoxelShape var39 = var35.getOutlineShape(var6, var48);
                              var38 = -2.0F;
                              if (!var39.isEmpty()
                                 && var39.getMin(Axis.X) <= 1.0E-4
                                 && var39.getMax(Axis.X) >= 0.9999
                                 && var39.getMin(Axis.Z) <= 1.0E-4
                                 && var39.getMax(Axis.Z) >= 0.9999) {
                                 float var40 = (float)Math.min(1.0, var39.getMax(Axis.Y));
                                 double var41 = 0.0;
                                 boolean var43 = true;

                                 for (Box var45 : var39.getBoundingBoxes()) {
                                    if (var45.maxY < var40 - 0.01) {
                                       var43 = false;
                                       break;
                                    }

                                    var41 += (var45.maxX - var45.minX) * (var45.maxZ - var45.minZ);
                                 }

                                 if (var43 && var41 >= 0.98) {
                                    var38 = var40;
                                 }
                              }

                              if (var36) {
                                 var11.put(var35, var38);
                              }
                           }

                           if (var38 < 0.0F) {
                              break;
                           }

                           pt[var19] = var53 + var38;
                           pu[var19] = 0;
                           if (var38 < 0.999F) {
                              break;
                           }

                           var53++;
                        }
                     }
                  } catch (Throwable var46) {
                     pt[var19] = var22;
                     pu[var19] = 0;
                  }
               }
            }
         }

         qj = var7;
         qk = var8;
         ql = var2;
         qm = true;
         qn = var5;
         if (var5) {
            s(var7, var8);
         } else {
            qi = 0;
         }
      }
   }

   private static void s(int var0, int var1) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      assert ps.length == (854730635 ^ 854732522)
         && pt.length == (-1169264904 ^ -1169266791)
         && pu.length == (-897960569 ^ -897958682)
         && qe.length == (-897895949 ^ -897894254)
         && qf.length == (-579328712 ^ -579326887)
         && qg.length == (2111212517 ^ 2111210116)
         && qh.length == (-1127257935 ^ -1127259696)
         && qa.length == (-1425145763 ^ -1425254371)
         && qb.length == (1730630032 ^ 1730480592)
         && qi >= 0
         && qi <= (36822543 ^ 36820846)
         && var0 > (-89226136 ^ 2058257520)
         && var1 > (494613317 ^ -1652870307) : NotifyResolver.q(new byte[]{-57, -60, -50, -62, -60, -60}, -297032070 ^ -297031970);

      try {
         int var2 = 0;
         int[] var3 = ps;
         float[] var4 = pt;
         byte[] var5 = pu;

         for (int var6 = -24; var6 <= 24; var6++) {
            for (int var7 = -24; var7 <= 24; var7++) {
               int var8 = (var6 + 24) * 49 + var7 + 24;
               float var9 = var3[var8];
               float var10 = var4[var8];
               if (var5[var8] == 0 && var9 - var10 > 2.0F) {
                  qe[var2] = var0 + var7;
                  qf[var2] = var1 + var6;
                  qg[var2] = var9;
                  qh[var2] = Math.max(var10 + 1.5F, var9 - 3.0F);
                  var2++;
               }
            }
         }

         qi = var2;
      } catch (RuntimeException var11) {
         throw var11;
      }
   }

   private static void t(
      ClientWorld var0, int var1, int var2, int var3, int var4, int var5, BlockState var6, VoxelShape var7, float var8, float var9, boolean var10
   ) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      assert var0 != null
         && var6 != null
         && var7 != null
         && var1 >= 0
         && var1 < (-657458560 ^ -657460255)
         && var5 <= var3
         && qa.length == (-411772837 ^ -411664357)
         && qb.length == (-1719277036 ^ -1719160236)
         && pt.length == (1246157279 ^ 1246154942)
         && pu.length == (2004518146 ^ 2004520035)
         && ps.length == (-286828518 ^ -286830213)
         && !Float.isNaN(var8)
         && !Float.isNaN(var9)
         && qd != null
         && qe.length == (1969853952 ^ 1969856353)
         && qf.length == (1244480474 ^ 1244482235) : QueryZone.r(new byte[]{75, 83, 91, 84, 78, 127, 121, 79, 108, 22, 4, 5, 1}, 56);
      List var11 = var7.getBoundingBoxes();
      Mutable var14 = qd;
      BlockState var15 = var6;

      try {
         int var19 = var1 << 6;
         int var20 = 0;
         int var21 = var11.size();

         for (int var22 = 0; var22 < 64; var22++) {
            double var23 = ((var22 >> 3) + 0.5) / 8.0;
            double var25 = ((var22 & 7) + 0.5) / 8.0;
            double var27 = -1.0;

            for (int var29 = 0; var29 < var21; var29++) {
               Box var13 = (Box)var11.get(var29);
               if (var23 >= var13.minX - 0.02 && var23 <= var13.maxX + 0.02 && var25 >= var13.minZ - 0.02 && var25 <= var13.maxZ + 0.02) {
                  double var30 = var13.maxY > 1.0 ? 1.0 : var13.maxY;
                  if (var30 > var27) {
                     var27 = var30;
                  }
               }
            }

            if (var27 >= 0.0 && var27 >= var9) {
               qa[var19 + var22] = (float)(var3 + var27);
               qb[var19 + var22] = 0;
            } else if (var9 >= 0.0F) {
               qa[var19 + var22] = var3 + var9;
               qb[var19 + var22] = (byte)(var10 ? 2 : 1);
            } else {
               qa[var19 + var22] = -1.0E9F;
               qb[var19 + var22] = 3;
               var20++;
            }
         }

         for (int var40 = 1; var40 <= 64 && var20 > 0 && var3 - var40 >= var5; var40++) {
            int var41 = var3 - var40;
            var14.set(var2, var41, var4);
            BlockState var16 = var0.getBlockState(var14);
            FluidState var17 = var16.getFluidState();
            if (var16 != var15 || !var17.isEmpty()) {
               var15 = var16;
               VoxelShape var18 = var16.getOutlineShape(var0, var14);
               if (!var18.isEmpty() || !var17.isEmpty()) {
                  float var24 = var17.isEmpty() ? -1.0F : var17.getHeight(var0, var14);
                  boolean var42 = !var17.isEmpty() && var17.isIn(FluidTags.LAVA);
                  boolean var26 = var18 == VoxelShapes.fullCube();
                  List var12;
                  if (!var18.isEmpty() && !var26) {
                     var12 = var18.getBoundingBoxes();
                  } else {
                     var12 = null;
                  }

                  int var43 = var12 == null ? 0 : var12.size();

                  for (int var28 = 0; var28 < 64; var28++) {
                     if (qb[var19 + var28] == 3) {
                        double var44 = var26 ? 1.0 : -1.0;
                        if (var43 > 0) {
                           double var31 = ((var28 >> 3) + 0.5) / 8.0;
                           double var33 = ((var28 & 7) + 0.5) / 8.0;

                           for (int var35 = 0; var35 < var43; var35++) {
                              Box var39 = (Box)var12.get(var35);
                              if (var31 >= var39.minX - 0.02 && var31 <= var39.maxX + 0.02 && var33 >= var39.minZ - 0.02 && var33 <= var39.maxZ + 0.02) {
                                 double var36 = var39.maxY > 1.0 ? 1.0 : var39.maxY;
                                 if (var36 > var44) {
                                    var44 = var36;
                                 }
                              }
                           }
                        }

                        if (var24 >= 0.0F && var24 > var44) {
                           qa[var19 + var28] = var41 + var24;
                           qb[var19 + var28] = (byte)(var42 ? 2 : 1);
                           var20--;
                        } else if (var44 >= 0.0) {
                           qa[var19 + var28] = (float)(var41 + var44);
                           qb[var19 + var28] = 0;
                           var20--;
                        }
                     }
                  }
               }
            }
         }

         pt[var1] = var3 + var8;
         pu[var1] = 4;
      } catch (RuntimeException var38) {
         throw var38;
      }
   }

   private static float u(double var0, double var2) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      qo = 3;
      if (qm && qn) {
         int var4 = MathHelper.floor(var0);
         int var5 = MathHelper.floor(var2);
         int var6 = var4 - qj + 24;
         int var7 = var5 - qk + 24;
         if (var6 >= 0 && var7 >= 0 && var6 < 49 && var7 < 49) {
            int var8 = var7 * 49 + var6;
            byte var9 = pu[var8];
            if (var9 == 4) {
               int var10 = var8 << 6 | ((int)((var0 - var4) * 8.0) & 7) << 3 | (int)((var2 - var5) * 8.0) & 7;
               qo = qb[var10];
               return qa[var10];
            } else {
               qo = var9;
               return pt[var8];
            }
         } else {
            return -1.0E9F;
         }
      } else {
         return -1.0E9F;
      }
   }

   private static int v(double var0, double var2) {
      if (qq != 0) {
         System.nanoTime();
      }

      if (!qm) {
         return -1632180469 ^ 515303179;
      }

      int var4 = MathHelper.floor(var0) - qj + 24;
      int var5 = MathHelper.floor(var2) - qk + 24;
      return var4 >= 0 && var5 >= 0 && var4 < 49 && var5 < 49 ? ps[var5 * 49 + var4] : 986541970 ^ -1160941678;
   }

   private static void w(MinecraftClient var0, Vec3d var1, float var2) {
      if (qq != 0) {
         new Object().hashCode();
      }

      int var3 = 0;

      try {
         float var4 = var0.getRenderTickCounter().getTickProgress(true);
         ClientPlayerEntity var5 = var0.player;
         if (!var5.isSpectator()) {
            float var6 = (float)((var5.getY() - var5.lastY) * 20.0);
            if (var6 < -60.0F || var6 > 60.0F) {
               var6 = 0.0F;
            }

            boolean var7 = var5.isOnGround();
            if (!var7) {
               if (var6 < oi) {
                  oi = var6;
               }
            } else if (!oh) {
               if (oi < -6.0F && !var5.isTouchingWater()) {
                  oj = 0.14F;
                  ok = Math.min(1.5F, -oi / 9.0F);
               }

               oi = 0.0F;
            }

            oh = var7;
            if (oj > 0.0F) {
               oj -= var2;
            }

            var3 = x(var5, var4, var3, oj > 0.0F ? ok : 0.0F);
         }

         List var23 = var0.world
            .getEntitiesByClass(
               LivingEntity.class, new Box(var1.x - 24.0, var1.y - 16.0, var1.z - 24.0, var1.x + 24.0, var1.y + 16.0, var1.z + 24.0), Entity::isAlive
            );

         for (int var24 = 0; var24 < var23.size() && var3 < 12; var24++) {
            LivingEntity var8 = (LivingEntity)var23.get(var24);
            if (var8 != var5 && !var8.isSpectator()) {
               double var9 = var8.getX() - var8.lastX;
               double var11 = var8.getZ() - var8.lastZ;
               double var13 = (var9 * var9 + var11 * var11) * 400.0;
               if (!(var13 <= 0.64) && !(var13 > 1600.0)) {
                  var3 = x(var8, var4, var3, 0.0F);
               }
            }
         }
      } catch (Throwable var20) {
      }

      ob = var3;
      boolean var21 = false;
      double var22 = 0.0;
      double var25 = 0.0;
      double var26 = 0.0;
      double var27 = 0.0;

      for (int var28 = 0; var28 < var3; var28++) {
         if (!(oa[var28] <= 0.0F)) {
            double var14 = ny[var28] + 0.91;
            double var16 = nt[var28];
            double var18 = nv[var28];
            if (!var21 || var16 - var14 < var22) {
               var22 = var16 - var14;
            }

            if (!var21 || var16 + var14 > var25) {
               var25 = var16 + var14;
            }

            if (!var21 || var18 - var14 < var26) {
               var26 = var18 - var14;
            }

            if (!var21 || var18 + var14 > var27) {
               var27 = var18 + var14;
            }

            var21 = true;
         }
      }

      oc = var21;
      od = var22;
      oe = var25;
      of = var26;
      og = var27;
   }

   private static int x(Entity var0, float var1, int var2, float var3) {
      if (qq != 0) {
         System.nanoTime();
      }

      Vec3d var4 = var0.getLerpedPos(var1);
      float var5 = (float)((var0.getX() - var0.lastX) * 20.0);
      float var6 = (float)((var0.getZ() - var0.lastZ) * 20.0);
      float var7 = MathHelper.sqrt(var5 * var5 + var6 * var6);
      if (var7 > 40.0F) {
         var5 = 0.0F;
         var6 = 0.0F;
         var7 = 0.0F;
      }

      float var8 = (var7 - 0.8F) / 4.8F;
      var8 = var8 < 0.0F ? 0.0F : (var8 > 1.4F ? 1.4F : var8);
      float var9 = var0.getWidth() * 0.5F + 0.45F + Math.min(var7, 8.0F) * 0.07F;
      if (var3 > var8) {
         var8 = var3;
      }

      if (var3 > 0.0F) {
         var9 += 0.9F * var3;
      }

      nt[var2] = var4.x;
      nu[var2] = var4.y;
      nv[var2] = var4.z;
      nw[var2] = var5;
      nx[var2] = var6;
      ny[var2] = var9;
      nz[var2] = var0.getHeight();
      oa[var2] = var8;
      return var2 + 1;
   }

   private static void y(MinecraftClient var0, Vec3d var1, float var2, float var3, long var4, float var6) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var4 - oq > 60000000L) {
         oq = var4;

         try {
            float var7 = MathHelper.sqrt(var2 * var2 + var3 * var3);
            Vec3d var8 = var1.add(var2 / var7 * 192.0, var3 / var7 * 192.0, 0.0);
            BlockHitResult var9 = var0.world.raycast(new RaycastContext(var1, var8, ShapeType.VISUAL, FluidHandling.NONE, var0.player));
            op = var9 != null && var9.getType() != net.minecraft.util.hit.HitResult.Type.MISS ? 0.0F : 1.0F;
         } catch (Throwable var10) {
            op = 0.0F;
         }
      }

      oo = oo + (op - oo) * (1.0F - (float)Math.exp(-var6 * 7.0F));
   }

   private static void z(VertexConsumer var0, Entry var1) {
      if (qq != 0) {
         System.nanoTime();
      }

      assert var0 != null
         && (ou || var1 != null)
         && nr >= 0
         && nr <= (963585145 ^ 963585529)
         && nq.length >= (-1693222576 ^ -1693222704)
         && no.length >= (1782242006 ^ 1782242134)
         && np.length >= (35336574 ^ 35336446)
         && nn.length >= (-243786986 ^ -243791722)
         && ps.length == (15374831 ^ 15372430)
         && pt.length == (-669945253 ^ -669942982)
         && pu.length == (-1176713185 ^ -1176714882)
         && qe.length == (18466959 ^ 18465262)
         && qf.length == (1403485475 ^ 1403483202) : NotifyResolver.q(new byte[]{55, 60, 32, 43}, 81)
         + JoinerWriter.p(new byte[]{-91, -118}, -1204241992 ^ -1204242053)
         + StringDecoder.d(new byte[]{43, 46, 62}, 78);
      int var2 = nr;
      nr = 0;
      if (var2 > 0) {
         try {
            int[] var3 = nq;
            float[] var4 = no;
            int var5 = 0;

            while (var5 < var2) {
               var3[var5] = var5++;
            }

            for (int var30 = 1; var30 < var2; var30++) {
               int var6 = var3[var30];
               float var7 = var4[var6];

               int var8;
               for (var8 = var30 - 1; var8 >= 0 && var4[var3[var8]] < var7; var8--) {
                  var3[var8 + 1] = var3[var8];
               }

               var3[var8 + 1] = var6;
            }

            float[] var31 = nn;
            int[] var32 = np;
            boolean var33 = ou;

            for (int var34 = 0; var34 < var2; var34++) {
               int var9 = var3[var34];
               int var10 = var9 * 13;
               float var11 = var31[var10];
               float var12 = var31[var10 + 1];
               float var13 = var31[var10 + 2];
               float var14 = var31[var10 + 3];
               float var15 = var31[var10 + 4];
               float var16 = var31[var10 + 5];
               float var17 = var31[var10 + 6];
               float var18 = var31[var10 + 7];
               float var19 = var31[var10 + 8];
               float var20 = var31[var10 + 9];
               float var21 = var31[var10 + 10];
               float var22 = var31[var10 + 11];
               float var23 = var31[var10 + 12];
               int var24 = var32[var9];
               int var25 = var24 >>> 24;
               int var26 = var24 >>> 16 & (-331912373 ^ -331912268);
               int var27 = var24 >>> 8 & (55051671 ^ 55051624);
               int var28 = var24 & (542743721 ^ 542743638);
               if (var33) {
                  var0.vertex(var11 - var14 - var17, var12 - var15 - var18, var13 - var16 - var19).texture(var20, var23).color(var25, var26, var27, var28);
                  var0.vertex(var11 - var14 + var17, var12 - var15 + var18, var13 - var16 + var19).texture(var20, var21).color(var25, var26, var27, var28);
                  var0.vertex(var11 + var14 + var17, var12 + var15 + var18, var13 + var16 + var19).texture(var22, var21).color(var25, var26, var27, var28);
                  var0.vertex(var11 + var14 - var17, var12 + var15 - var18, var13 + var16 - var19).texture(var22, var23).color(var25, var26, var27, var28);
               } else {
                  var0.vertex(var1, var11 - var14 - var17, var12 - var15 - var18, var13 - var16 - var19)
                     .texture(var20, var23)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 - var14 + var17, var12 - var15 + var18, var13 - var16 + var19)
                     .texture(var20, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 + var14 + var17, var12 + var15 + var18, var13 + var16 + var19)
                     .texture(var22, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 + var14 - var17, var12 + var15 - var18, var13 + var16 - var19)
                     .texture(var22, var23)
                     .color(var25, var26, var27, var28);
               }
            }
         } catch (RuntimeException var29) {
            throw var29;
         }
      }
   }

   private static void aa(int var0, double var1, double var3, double var5) {
      if (qq != 0) {
         System.nanoTime();
      }

      int var7 = var0 & 3;
      double var8 = var7 < 2 ? 4.5 : (var7 == 2 ? 11.0 : 22.0);
      double var10 = var7 < 2 ? 3.5 : (var7 == 2 ? 7.0 : 14.0);
      ep[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * var8;
      eq[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * var10;
      er[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * var8;
      boolean var12 = ed.nextFloat() < 0.4F;
      ff[var0] = var12 ? ed.nextInt(7) : 7;
      float var13 = ed.nextFloat();
      if (var12) {
         es[var0] = 0.5F + ed.nextFloat() * 0.5F;
         et[var0] = 0.022F + 0.018F * var13;
      } else {
         es[var0] = 0.8F + ed.nextFloat() * 0.7F;
         et[var0] = 0.014F + 0.02F * var13 * var13;
      }

      eu[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      ev[var0] = 0.7F + ed.nextFloat() * 1.4F;
      ew[var0] = ed.nextFloat();
      fa[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 1.2F;
   }

   private static void ab(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {
      if (qq != 0) {
         new Object().hashCode();
      }

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!fg) {
         for (int var15 = 0; var15 < (960672086 ^ 960667966); var15++) {
            aa(var15, var9, var11, var13);
         }

         fg = true;
         fj = 2;
      }

      float var189 = fk;
      float var16 = fl;
      float var17 = fm;
      float var18 = 4200.0F * Math.max(0.05F, ov) * (0.6F * var189 + 1.6F * var16 + 1.6F * var17);
      fh = fh + (var18 - fh) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var19 = Math.min(-2056443068 ^ -2056438996, (int)Math.ceil(fh));
      float var20 = fh;
      float var21 = var189 + 0.8F * var16 + 0.85F * var17;
      float var22 = var189 + 0.6F * var16 + 1.25F * var17;
      float var23 = (var189 + 0.25F * var17) * (float) (Math.PI * 2);
      float var24 = 0.009F * var189 + 0.085F * var16 + 0.012F * var17;
      float var25 = var189 + 1.45F * var16 + var17;
      float var26 = 0.52F * var189 + 0.88F * (var16 + var17);
      float var27 = 0.3F * var189 + 0.12F * (var16 + var17);
      boolean var28 = dl;
      float var29 = (var16 + var17) * (float) (Math.PI * 2);
      float var30 = 0.7F * var16 + 4.0F * var17;
      float var31 = 0.015F * (var16 + var17);
      float var32 = 228.0F * var189 + 250.0F * var16 + 236.0F * var17;
      float var33 = 234.0F * var189 + 238.0F * var16 + 244.0F * var17;
      float var34 = 244.0F * var189 + 222.0F * var16 + 255.0F * var17;
      float var35 = 0.9F * var16 + 0.8F * var17;
      float var36 = var17;
      float var37 = 0.2F * var29;
      float var38 = 0.45F * var189 + 0.4F * var16;
      boolean var39 = var17 < 0.5F;
      double var40 = 4.5 - 1.3 * var189;
      double var42 = 3.5 - 0.9 * var189;
      float var44 = ow;
      float var45 = ox;
      float var46 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var47 = MathHelper.cos(var46);
      float var48 = MathHelper.sin(var46);
      float var49 = var189 * (2.0F + 16.0F * var44) + (6.0F * var16 + 2.0F * var17) * var44;
      float var50 = 0.4F * var189 + 0.5F * (var16 + var17);
      float var51 = 0.33F * var49 + 0.4F;
      double var52 = var49 * 0.8 * var4;
      double var54 = var47 * var52;
      double var56 = var48 * var52;
      float var58 = (float)(var4 * 0.11 % 6283.185307179586);
      float var59 = (float)(var4 * 0.07 % 6283.185307179586 + 1.3);
      float var60 = (float)(var4 * 0.09 % 6283.185307179586 + 2.1);
      double var61 = 0.072 * var49 * var4;
      double var63 = 0.288 * var49 * var4;
      double var65 = 0.1 * var4;
      double var67 = 0.2 * var4;
      int var69 = fi & 7;
      byte var70 = 8;
      fi++;
      if (fj > 0) {
         fj--;
         var69 = 0;
         var70 = 1;
      }

      for (int var71 = var69; var71 < var19; var71 += var70) {
         double var72 = ep[var71];
         double var74 = eq[var71];
         double var76 = er[var71];
         float var78 = (float)(var72 * var47 + var76 * var48);
         float var79 = (float)(var76 * var47 - var72 * var48);
         float var80 = var45 + var50 * MathHelper.sin(0.09F * var78 - var61 + 1.4F * MathHelper.sin(0.05F * var79 + var65));
         var80 = var80 < 0.0F ? 0.0F : (var80 > 1.0F ? 1.0F : var80);
         float var81 = var49 * (0.55F + 0.45F * var80);
         float var82 = (float)(var72 - var54);
         float var83 = (float)var74;
         float var84 = (float)(var76 - var56);
         float var85 = MathHelper.sin(0.21F * var84 + var58)
            + MathHelper.cos(0.21F * var83 + var59)
            + 0.55F * (MathHelper.sin(0.8F * var84 + var60) + MathHelper.cos(0.8F * var83 + var58));
         float var86 = MathHelper.sin(0.21F * var82 + var60)
            + MathHelper.cos(0.21F * var84 + var58)
            + 0.55F * (MathHelper.sin(0.8F * var82 + var59) + MathHelper.cos(0.8F * var84 + var60));
         float var87 = MathHelper.sin(0.21F * var83 + var59)
            + MathHelper.cos(0.21F * var82 + var60)
            + 0.55F * (MathHelper.sin(0.8F * var83 + var58) + MathHelper.cos(0.8F * var82 + var59));
         fb[var71] = var47 * var81 + var51 * 0.5F * var85;
         fc[var71] = var51 * 0.3F * var86;
         fd[var71] = var48 * var81 + var51 * 0.5F * var87;
         float var88 = var38 > 0.0F ? 0.5F + 0.5F * MathHelper.sin(0.32F * var78 - var63 + 1.2F * MathHelper.sin(0.13F * var79 + var67)) : 1.0F;
         fe[var71] = 1.0F - var38 * (1.0F - var88);
      }

      boolean var190 = qm && var189 > 0.05F;
      float var191 = 1.0F - (float)Math.exp(-var3 * 6.0F);
      float var73 = var3 > 0.001F ? 1.0F / var3 : 1000.0F;
      float var192 = oz + (pa - oz) * (var16 + var17);
      float var75 = 0.25F + 0.75F * (var192 < 0.0F ? 0.0F : (var192 > 1.0F ? 1.0F : var192));
      float var193 = 0.6F + 0.4F * (var192 < 0.0F ? 0.0F : (var192 > 1.0F ? 1.0F : var192));
      float var77 = var7[0];
      float var194 = var7[1];
      float var195 = var7[2];
      float var197 = var7[3];
      float var198 = var7[4];
      float var199 = var7[5];
      float var200 = var7[6];
      float var201 = var7[7];
      float var202 = var7[8];
      float var203 = pl;
      float var204 = pm;
      float var205 = pn;
      float var89 = ol;
      float var90 = om;
      float var91 = on;
      float var92 = pg;
      float var93 = pe;
      float var94 = pf;
      float var95 = pb;
      float var96 = pc;
      float var97 = pd;
      boolean var98 = qm;
      int var99 = qj;
      int var100 = qk;
      int[] var101 = ps;
      boolean var102 = or;
      boolean var103 = ou;
      float var104 = ot;
      float var105 = os;
      float var106 = 22.0F * (0.55F + 0.15F * (var16 + var17));
      float var107 = 22.0F * (0.45F - 0.15F * (var16 + var17));
      float var108 = 8.400001F;
      float var109 = 5.6F;

      for (int var110 = 0; var110 < var19; var110++) {
         float var111 = eu[var110];
         float var112 = ev[var110];
         int var113 = var8 ? ff[var110] : 7;
         float var114 = 1.0F;
         float var115 = 1.0F;
         if (var113 != 7 && var111 >= var23) {
            float var116 = (var111 - var23) * 2.5F;
            if (var116 < 1.0F) {
               var115 = 1.0F - var116;
            } else {
               var113 = 7;
               var114 = 0.42F;
               var115 = var116 < 2.0F ? var116 - 1.0F : 1.0F;
            }
         }

         int var206 = var110 & 3;
         boolean var117 = var190 && var110 % 6 == 0;
         if (var117) {
            var113 = 7;
         }

         double var118 = ep[var110];
         double var120 = eq[var110];
         double var122 = er[var110];
         float var124 = fb[var110];
         float var125 = -es[var110] * var21 + fc[var110];
         float var126 = fd[var110];
         double var127 = var118 + var124 * var3;
         double var129 = var120 + var125 * var3;
         double var131 = var122 + var126 * var3;
         double var133 = var206 < 2 ? var40 : (var206 == 2 ? 11.0 : 22.0);
         double var135 = var206 < 2 ? var42 : (var206 == 2 ? 7.0 : 14.0);
         if (var117) {
            var117 = false;
            int var137 = MathHelper.floor(var127) - var99 + 24;
            int var138 = MathHelper.floor(var131) - var100 + 24;
            if (var137 >= 0 && var138 >= 0 && var137 < 49 && var138 < 49) {
               float var139 = var111 * 0.15915494F;
               double var140 = var101[var138 * 49 + var137]
                  + 0.03F
                  + 0.55F * var139 * var139
                  + 0.1F * (1.0F + MathHelper.sin(var4 * var112 * 3.0 + var111 * 3.0));
               if (var140 - var11 > -var135 * 0.8 && var140 - var11 < var135 * 0.8) {
                  var117 = true;
                  var129 = var120 + (var140 - var120) * var191;
                  var125 = (float)(var129 - var120) * var73;
                  var125 = var125 > 6.0F ? 6.0F : (var125 < -6.0F ? -6.0F : var125);
                  var124 *= 0.85F;
                  var126 *= 0.85F;
                  var127 = var118 + var124 * var3;
                  var131 = var122 + var126 * var3;
               }
            }
         }

         double var210 = var127 - var9;
         double var211 = var129 - var11;
         double var141 = var131 - var13;
         if (var210 < -var133 || var210 >= var133) {
            var210 -= Math.floor((var210 + var133) / (2.0 * var133)) * (2.0 * var133);
            var127 = var9 + var210;
         }

         if (var141 < -var133 || var141 >= var133) {
            var141 -= Math.floor((var141 + var133) / (2.0 * var133)) * (2.0 * var133);
            var131 = var13 + var141;
         }

         if (var211 < -var135 || var211 >= var135) {
            var211 -= Math.floor((var211 + var135) / (2.0 * var135)) * (2.0 * var135);
            var129 = var11 + var211;
         }

         ep[var110] = var127;
         eq[var110] = var129;
         er[var110] = var131;
         float var143 = (float)var210;
         float var144 = (float)var211;
         float var145 = (float)var141;
         float var146 = var143 * var143 + var144 * var144 + var145 * var145;
         if (!(var146 < 0.04F)) {
            float var147 = MathHelper.sqrt(var146);
            float var148 = var143 * var200 + var144 * var201 + var145 * var202;
            if (!(var148 < -0.3F * var147)) {
               if (var102) {
                  float var149 = 0.5F + var148 * var104;
                  if (var149 < 0.0F || (var146 - var148 * var148) * var105 > var149 * var149) {
                     continue;
                  }
               }

               float var212 = 1.0F;
               if (var98) {
                  int var150 = MathHelper.floor(var127) - var99 + 24;
                  int var151 = MathHelper.floor(var131) - var100 + 24;
                  if (var150 >= 0 && var151 >= 0 && var150 < 49 && var151 < 49) {
                     float var152 = var101[var151 * 49 + var150];
                     if (var129 < var152) {
                        continue;
                     }

                     if (!var117) {
                        float var153 = (float)(var129 - var152) * 8.333333F;
                        var212 = var153 > 1.0F ? 1.0F : var153;
                     }
                  }
               }

               float var213 = (var147 - 0.2F) * 2.0F;
               var213 = var213 < 0.0F ? 0.0F : (var213 > 1.0F ? 1.0F : var213);
               float var219 = var144 < 0.0F ? -var144 : var144;
               float var215;
               float var217;
               if (var206 == 3) {
                  var215 = (var147 - var106) / var107;
                  var217 = (var219 - var108) / var109;
               } else {
                  float var154 = var143 < 0.0F ? -var143 : var143;
                  float var155 = var145 < 0.0F ? -var145 : var145;
                  var154 = var154 > var155 ? var154 : var155;
                  var215 = (var154 - (float)var133 * 0.7F) / ((float)var133 * 0.3F);
                  var217 = var117 ? 0.0F : (var219 - (float)var135 * 0.6F) / ((float)var135 * 0.4F);
               }

               var215 = var215 < 0.0F ? 0.0F : (var215 > 1.0F ? 1.0F : var215);
               var217 = var217 < 0.0F ? 0.0F : (var217 > 1.0F ? 1.0F : var217);
               float var221 = (var20 - var110) / 64.0F;
               var221 = var221 < 0.0F ? 0.0F : (var221 > 1.0F ? 1.0F : var221);
               float var223 = (0.85F + 0.85F * var189)
                  * var6
                  * (var213 * var213 * (3.0F - 2.0F * var213))
                  * (1.0F - var215 * var215 * (3.0F - 2.0F * var215))
                  * (1.0F - var217 * var217 * (3.0F - 2.0F * var217))
                  * var221
                  * var115
                  * var212
                  * fe[var110];
               if (var117) {
                  var223 *= 0.6F;
               }

               if (!(var223 < 0.012F)) {
                  float var156 = var113 == 7 ? 0.25F : 0.45F;
                  float var157 = MathHelper.sin(var4 * var112 * 2.0 + var111) * var156;
                  float var158 = MathHelper.cos(var4 * var112 * 1.7 + var111 * 1.7) * var156;
                  var124 += var157;
                  var126 += var158;
                  ep[var110] = var127 + var157 * var3;
                  er[var110] = var131 + var158 * var3;
                  float var159 = et[var110] * (var22 * var114) * (1.0F + var147 * var31);
                  float var160 = 0.0F;
                  if (var39 && var113 == 7 && var147 < 1.4F) {
                     float var161 = var159 + 0.006F * (1.4F - var147) / var147;
                     float var162 = var159 / var161;
                     var223 *= var162 * var162 * 1.6F;
                     var160 = 1.0F - var162;
                     var159 = var161;
                  }

                  float var224 = var159 * 2.0F * var89 / var147;
                  if (var113 != 7 && var224 < 16.0F) {
                     var113 = 7;
                     var159 *= 0.9F;
                     var224 *= 0.9F;
                  }

                  float var163;
                  float var164;
                  float var165;
                  float var166;
                  float var167;
                  float var168;
                  float var169;
                  float var170;
                  float var171;
                  float var225;
                  if (var113 != 7) {
                     double var226 = var111 + var4 * fa[var110];
                     float var233 = MathHelper.cos(var226);
                     float var237 = MathHelper.sin(var226);
                     float var240 = 0.7F + 0.3F * Math.abs(MathHelper.cos(var4 * var112 * 0.7 + var111 * 1.3));
                     float var251 = var159 * var240;
                     var165 = (var77 * var233 + var197 * var237) * var251;
                     var166 = (var194 * var233 + var198 * var237) * var251;
                     var167 = (var195 * var233 + var199 * var237) * var251;
                     var225 = (-var77 * var237 + var197 * var233) * var159;
                     var163 = (-var194 * var237 + var198 * var233) * var159;
                     var164 = (-var195 * var237 + var199 * var233) * var159;
                     float var253 = var224 * MathHelper.sqrt(var240);
                     int var255 = (var253 >= 64.0F ? 0 : (var253 >= 32.0F ? 8 : (var253 >= 16.0F ? 16 : 24))) + var113;
                     var168 = dd[var255];
                     var169 = de[var255];
                     var170 = df[var255];
                     var171 = dg[var255];
                  } else {
                     boolean var172 = var28 && var111 < var29;
                     if (var172) {
                        float var173 = var30 * var147 / var89;
                        var159 = var159 < var173 ? var173 : var159;
                     } else {
                        float var229 = 0.75F * var147 / var89;
                        if (var159 < var229) {
                           var223 *= var159 / var229;
                           var159 = var229;
                        }
                     }

                     var225 = var197 * var159;
                     var163 = var198 * var159;
                     var164 = var199 * var159;
                     var165 = var77 * var159;
                     var166 = var194 * var159;
                     var167 = var195 * var159;
                     float var230 = var124 - var203;
                     float var174 = var125 - var204;
                     float var175 = var126 - var205;
                     float var176 = var230 * var230 + var174 * var174 + var175 * var175;
                     if (var24 > 0.0F && var176 > 1.0E-4F) {
                        float var177 = MathHelper.sqrt(var176);
                        float var178 = var230 / var177;
                        float var179 = var174 / var177;
                        float var180 = var175 / var177;
                        float var181 = var179 * var145 - var180 * var144;
                        float var182 = var180 * var143 - var178 * var145;
                        float var183 = var178 * var144 - var179 * var143;
                        float var184 = MathHelper.sqrt(var181 * var181 + var182 * var182 + var183 * var183);
                        if (var184 > 0.001F) {
                           float var185 = var159 / var184;
                           float var186 = var177 * (var117 ? 0.03F : var24) * 0.5F;
                           float var187 = 0.7F * var147 / var89;
                           var223 *= (float)Math.sqrt(Math.sqrt(var159 / (var159 + var186)));
                           float var188 = var159 + var186;
                           if (var159 < var187) {
                              var223 *= var159 / var187;
                              var185 = var187 / var184;
                           }

                           var225 = var178 * var188;
                           var163 = var179 * var188;
                           var164 = var180 * var188;
                           var165 = var181 * var185;
                           var166 = var182 * var185;
                           var167 = var183 * var185;
                        }
                     }

                     if (var8) {
                        int var249 = (var224 >= 64.0F ? 0 : (var224 >= 32.0F ? 8 : (var224 >= 16.0F ? 16 : 24))) + 7;
                        if (!var28 || !var172 && !var117 && !(var189 > 0.5F)) {
                           var168 = dd[var249];
                           var169 = de[var249];
                           var170 = df[var249];
                           var171 = dg[var249];
                        } else {
                           var249 >>= 3;
                           var168 = dh[var249];
                           var169 = dj[var249];
                           var170 = di[var249];
                           var171 = dk[var249];
                        }
                     } else {
                        var168 = 0.0F;
                        var169 = 0.0F;
                        var170 = 1.0F;
                        var171 = 1.0F;
                     }
                  }

                  float var227 = (var26 + var27 * ew[var110]) * (var8 ? var193 : var75) * var25;
                  var227 = var227 > 1.0F ? 1.0F : var227;
                  if (var35 > 0.0F) {
                     float var231 = (var143 * var90 + var144 * var91) / var147;
                     if (var231 > 0.0F) {
                        float var234 = var231 * var231;
                        var234 *= var234;
                        float var238 = var234 * var234;
                        var227 *= 1.0F + var35 * (0.35F * var234 + 0.9F * var238 * var238);
                        var223 *= 1.0F + var35 * 0.6F * var238;
                        if (var36 > 0.0F && var113 == 7 && var111 < var37) {
                           float var241 = MathHelper.sin(var4 * var112 * 5.0 + var111 * 7.0);
                           var241 *= var241;
                           var241 *= var241;
                           var241 *= var241;
                           var241 *= var241;
                           var227 *= 1.0F + 1.5F * var36 * var241 * var241;
                        }
                     }
                  }

                  if (var117) {
                     var227 *= 1.08F;
                  }

                  if (var160 > 0.0F) {
                     var227 += (1.05F - var227) * var160;
                  }

                  float var232 = var32 * var227;
                  float var236 = var33 * var227;
                  float var239 = var34 * var227;
                  if (var92 > 0.0F) {
                     float var246 = (var147 - var93) * var94;
                     var246 = var246 < 0.0F ? 0.0F : (var246 > 1.0F ? 1.0F : var246);
                     var232 += (var95 - var232) * var246;
                     var236 += (var96 - var236) * var246;
                     var239 += (var97 - var239) * var246;
                  }

                  int var248 = (int)(var232 > 255.0F ? 255.0F : var232);
                  int var252 = (int)(var236 > 255.0F ? 255.0F : var236);
                  int var254 = (int)(var239 > 255.0F ? 255.0F : var239);
                  int var256 = (int)((var223 > 1.0F ? 1.0F : var223) * 255.0F);
                  if (var103) {
                     var0.vertex(var143 - var165 - var225, var144 - var166 - var163, var145 - var167 - var164)
                        .texture(var168, var171)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 - var165 + var225, var144 - var166 + var163, var145 - var167 + var164)
                        .texture(var168, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 + var165 + var225, var144 + var166 + var163, var145 + var167 + var164)
                        .texture(var170, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 + var165 - var225, var144 + var166 - var163, var145 + var167 - var164)
                        .texture(var170, var171)
                        .color(var248, var252, var254, var256);
                  } else {
                     var0.vertex(var1, var143 - var165 - var225, var144 - var166 - var163, var145 - var167 - var164)
                        .texture(var168, var171)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 - var165 + var225, var144 - var166 + var163, var145 - var167 + var164)
                        .texture(var168, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 + var165 + var225, var144 + var166 + var163, var145 + var167 + var164)
                        .texture(var170, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 + var165 - var225, var144 + var166 - var163, var145 + var167 - var164)
                        .texture(var170, var171)
                        .color(var248, var252, var254, var256);
                  }
               }
            }
         }
      }
   }

   private static void ac(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7) {
      if (qq != 0) {
         new Object().hashCode();
      }

      assert var0 != null
         && var2 != null
         && var7 != null
         && var7.length == 9
         && var3 >= 0.0F
         && var3 <= 0.11F
         && !Double.isNaN(var4)
         && var6 >= 0.0F
         && var6 <= 2.0F
         && (740324827 ^ 740315851) == fs.length
         && (1971099111 ^ 1971106551) == ft.length
         && (1813632459 ^ 1813639899) == fu.length
         && (-18211443 ^ -18204003) == fv.length
         && (1647228456 ^ 1647219000) == fw.length
         && (-1185553688 ^ -1185561096) == fx.length
         && dh.length == 4
         && dj.length == 4
         && di.length == 4
         && dk.length == 4
         && ps.length == (-88919914 ^ -88917513) : TokenExtractor.w(
         new byte[]{-84, -86, -70, -102, -72, -72, -93, -17, -14, -79, -79, -75, -2, -71, -82, -68, -73, -66}, -185544021 ^ -185544083
      );

      try {
         double var8 = var2.x;
         double var10 = var2.y;
         double var12 = var2.z;
         if (!fy) {
            for (int var14 = 0; var14 < (1869333066 ^ 1869342042); var14++) {
               fs[var14] = var8 + (ed.nextDouble() * 2.0 - 1.0) * 44.0;
               ft[var14] = var10 + (ed.nextDouble() * 2.0 - 1.0) * 22.0;
               fu[var14] = var12 + (ed.nextDouble() * 2.0 - 1.0) * 44.0;
               fv[var14] = 0.8F + ed.nextFloat() * 0.7F;
               fw[var14] = 0.035F + ed.nextFloat() * 0.03F;
               fx[var14] = 0.86F + ed.nextFloat() * 0.14F;
            }

            fy = true;
         }

         float var121 = fl;
         float var15 = fm;
         float var16 = var121 + var15;
         float var17 = 5000.0F * Math.max(0.05F, ov) * (1.8F * var121 + 3.2F * var15) / var16;
         var17 = var17 > 10000.0F ? 10000.0F : var17;
         fz = fz + (var17 - fz) * (1.0F - (float)Math.exp(-var3 * 1.5F));
         int var18 = Math.min(181868005 ^ 181875445, (int)Math.ceil(fz));
         float var19 = fz;
         float var20 = (0.8F * var121 + 0.85F * var15) / var16;
         float var21 = ow * (0.55F + 0.45F * ox) * (6.0F * var121 + 2.0F * var15) / var16;
         float var22 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
         float var23 = MathHelper.cos(var22) * var21;
         float var24 = MathHelper.sin(var22) * var21;
         float var25 = 0.085F * var121 / var16;
         float var26 = (0.7F * var121 + 4.0F * var15) / var16;
         float var27 = pa < 0.0F ? 0.0F : (pa > 1.0F ? 1.0F : pa);
         float var28 = (0.6F + 0.4F * var27) * (1.45F * var121 + var15) / var16;
         float var29 = (250.0F * var121 + 236.0F * var15) / var16;
         float var30 = (238.0F * var121 + 244.0F * var15) / var16;
         float var31 = (222.0F * var121 + 255.0F * var15) / var16;
         float var32 = var7[0];
         float var33 = var7[1];
         float var34 = var7[2];
         float var35 = var7[3];
         float var36 = var7[4];
         float var37 = var7[5];
         float var38 = var7[6];
         float var39 = var7[7];
         float var40 = var7[8];
         float var41 = pl;
         float var42 = pm;
         float var43 = pn;
         float var44 = ol;
         boolean var45 = qm;
         boolean var46 = or;
         boolean var47 = ou;
         int var48 = qj;
         int var49 = qk;
         int[] var50 = ps;
         float var51 = ot;
         float var52 = os;
         double var53 = 88.0;
         double var55 = 44.0;
         double var57 = 88.0;
         float var59 = 12.1F;
         float var60 = 9.9F;
         float var61 = (0.85F * var121 + 1.1F * var15) * var6;
         float var62 = om;
         float var63 = on;
         float var64 = (0.9F * var121 + 0.8F * var15) / var16;
         float var65 = pg;
         float var66 = pe;
         float var67 = pf;
         float var68 = pb;
         float var69 = pc;
         float var70 = pd;

         for (int var71 = 0; var71 < var18; var71++) {
            float var72 = -fv[var71] * var20;
            double var73 = fs[var71] + var23 * var3;
            double var75 = ft[var71] + var72 * var3;
            double var77 = fu[var71] + var24 * var3;
            double var79 = var73 - var8;
            double var81 = var75 - var10;
            double var83 = var77 - var12;
            if (var79 < -44.0 || var79 >= 44.0) {
               var79 -= Math.floor((var79 + 44.0) / var53) * var53;
               var73 = var8 + var79;
            }

            if (var83 < -44.0 || var83 >= 44.0) {
               var83 -= Math.floor((var83 + 44.0) / var57) * var57;
               var77 = var12 + var83;
            }

            if (var81 < -22.0 || var81 >= 22.0) {
               var81 -= Math.floor((var81 + 22.0) / var55) * var55;
               var75 = var10 + var81;
            }

            fs[var71] = var73;
            ft[var71] = var75;
            fu[var71] = var77;
            float var85 = (float)var79;
            float var86 = (float)var81;
            float var87 = (float)var83;
            float var88 = var85 * var85 + var86 * var86 + var87 * var87;
            if (!(var88 < 256.0F)) {
               float var89 = MathHelper.sqrt(var88);
               float var90 = var85 * var38 + var86 * var39 + var87 * var40;
               if (!(var90 < 0.1F * var89)) {
                  if (var46) {
                     float var91 = 0.5F + var90 * var51;
                     if ((var88 - var90 * var90) * var52 > var91 * var91) {
                        continue;
                     }
                  }

                  if (var45) {
                     int var123 = MathHelper.floor(var73) - var48 + 24;
                     int var92 = MathHelper.floor(var77) - var49 + 24;
                     if (var123 >= 0 && var92 >= 0 && var123 < 49 && var92 < 49 && var75 < var50[var92 * 49 + var123]) {
                        continue;
                     }
                  }

                  float var124 = (var89 - 16.0F) / 6.0F;
                  var124 = var124 > 1.0F ? 1.0F : var124;
                  float var126 = (var89 - 34.0F) / 10.0F;
                  var126 = var126 < 0.0F ? 0.0F : (var126 > 1.0F ? 1.0F : var126);
                  float var93 = var86 < 0.0F ? -var86 : var86;
                  float var94 = (var93 - var59) / var60;
                  var94 = var94 < 0.0F ? 0.0F : (var94 > 1.0F ? 1.0F : var94);
                  float var95 = (var19 - var71) / 64.0F;
                  var95 = var95 < 0.0F ? 0.0F : (var95 > 1.0F ? 1.0F : var95);
                  float var96 = var61
                     * (var124 * var124 * (3.0F - 2.0F * var124))
                     * (1.0F - var126 * var126 * (3.0F - 2.0F * var126))
                     * (1.0F - var94 * var94 * (3.0F - 2.0F * var94))
                     * var95;
                  if (!(var96 < 0.012F)) {
                     float var97 = fw[var71];
                     float var98 = var26 * var89 / var44;
                     var97 = var97 < var98 ? var98 : var97;
                     float var99 = var35 * var97;
                     float var100 = var36 * var97;
                     float var101 = var37 * var97;
                     float var102 = var32 * var97;
                     float var103 = var33 * var97;
                     float var104 = var34 * var97;
                     if (var25 > 0.0F) {
                        float var105 = var23 - var41;
                        float var106 = var72 - var42;
                        float var107 = var24 - var43;
                        float var108 = var105 * var105 + var106 * var106 + var107 * var107;
                        if (var108 > 1.0E-4F) {
                           float var109 = MathHelper.sqrt(var108);
                           float var110 = var105 / var109;
                           float var111 = var106 / var109;
                           float var112 = var107 / var109;
                           float var113 = var111 * var87 - var112 * var86;
                           float var114 = var112 * var85 - var110 * var87;
                           float var115 = var110 * var86 - var111 * var85;
                           float var116 = MathHelper.sqrt(var113 * var113 + var114 * var114 + var115 * var115);
                           if (var116 > 0.001F) {
                              float var117 = var109 * var25 * 0.5F;
                              float var118 = var97 + var117;
                              float var119 = var97 / var116;
                              var96 *= (float)Math.sqrt(Math.sqrt(var97 / var118));
                              var99 = var110 * var118;
                              var100 = var111 * var118;
                              var101 = var112 * var118;
                              var102 = var113 * var119;
                              var103 = var114 * var119;
                              var104 = var115 * var119;
                           }
                        }
                     }

                     float var131 = var97 * 2.0F * var44 / var89;
                     int var132 = var131 >= 32.0F ? 1 : (var131 >= 16.0F ? 2 : 3);
                     float var133 = dh[var132];
                     float var134 = dj[var132];
                     float var135 = di[var132];
                     float var136 = dk[var132];
                     float var137 = fx[var71] * var28;
                     var137 = var137 > 1.0F ? 1.0F : var137;
                     float var139 = (var85 * var62 + var86 * var63) / var89;
                     if (var139 > 0.0F) {
                        float var140 = var139 * var139;
                        var140 *= var140;
                        float var143 = var140 * var140;
                        var137 *= 1.0F + var64 * (0.35F * var140 + 0.9F * var143 * var143);
                        var96 *= 1.0F + var64 * 0.6F * var143;
                     }

                     float var142 = var29 * var137;
                     float var144 = var30 * var137;
                     float var145 = var31 * var137;
                     if (var65 > 0.0F) {
                        float var146 = (var89 - var66) * var67;
                        var146 = var146 < 0.0F ? 0.0F : (var146 > 1.0F ? 1.0F : var146);
                        var142 += (var68 - var142) * var146;
                        var144 += (var69 - var144) * var146;
                        var145 += (var70 - var145) * var146;
                     }

                     int var148 = (int)(var142 > 255.0F ? 255.0F : var142);
                     int var149 = (int)(var144 > 255.0F ? 255.0F : var144);
                     int var150 = (int)(var145 > 255.0F ? 255.0F : var145);
                     int var151 = (int)((var96 > 1.0F ? 1.0F : var96) * 255.0F);
                     if (var47) {
                        var0.vertex(var85 - var102 - var99, var86 - var103 - var100, var87 - var104 - var101)
                           .texture(var133, var136)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 - var102 + var99, var86 - var103 + var100, var87 - var104 + var101)
                           .texture(var133, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 + var102 + var99, var86 + var103 + var100, var87 + var104 + var101)
                           .texture(var135, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 + var102 - var99, var86 + var103 - var100, var87 + var104 - var101)
                           .texture(var135, var136)
                           .color(var148, var149, var150, var151);
                     } else {
                        var0.vertex(var1, var85 - var102 - var99, var86 - var103 - var100, var87 - var104 - var101)
                           .texture(var133, var136)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 - var102 + var99, var86 - var103 + var100, var87 - var104 + var101)
                           .texture(var133, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 + var102 + var99, var86 + var103 + var100, var87 + var104 + var101)
                           .texture(var135, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 + var102 - var99, var86 + var103 - var100, var87 + var104 - var101)
                           .texture(var135, var136)
                           .color(var148, var149, var150, var151);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var120) {
         throw var120;
      }
   }

   private static void ad(int var0, double var1, double var3, double var5, boolean var7) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      double var8 = ed.nextDouble() * Math.PI * 2.0;
      double var10 = 3.0 + 22.0 * Math.sqrt(ed.nextDouble());
      gb[var0] = var1 + Math.cos(var8) * var10;
      gd[var0] = var5 + Math.sin(var8) * var10;
      double var12 = var3 - 8.0 + ed.nextDouble() * 16.0;
      int var14 = v(gb[var0], gd[var0]);
      if (var14 != (-1737445168 ^ 410038480) && var12 < var14 && var14 < var3 + 16.0) {
         var12 = var14 + ed.nextDouble() * 2.0;
      }

      gc[var0] = var12;
      gf[var0] = 3.5F + ed.nextFloat() * 4.0F;
      ge[var0] = var7 ? ed.nextFloat() * gf[var0] : 0.0F;
      gg[var0] = 0.008F + ed.nextFloat() * ed.nextFloat() * 0.016F;
      gh[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      gi[var0] = (1.2F + ed.nextFloat() * 1.8F) * (float)Math.exp(-ge[var0] / 1.6F);
      gj[var0] = 0.6F + ed.nextFloat() * 0.9F;
   }

   private static void ae(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, float var8) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!gn) {
         for (int var15 = 0; var15 < (-1462826638 ^ -1462826118); var15++) {
            ad(var15, var9, var11, var13, true);
         }

         gn = true;
         gq = 2;
      }

      float var129 = 520.0F * Math.max(0.05F, ov) * kb;
      go = go + (var129 - go) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var16 = Math.min(-795331373 ^ -795330853, (int)Math.ceil(go));
      float var17 = go;
      float var18 = ow * 4.0F;
      float var19 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var20 = MathHelper.cos(var19) * var18;
      float var21 = MathHelper.sin(var19) * var18;
      float var22 = oy;
      float var23 = 0.75F + 0.25F * var22;
      float var24 = 0.16F + 0.3F * var22;
      float var25 = (float)Math.exp(-var3 / 1.6F);
      float var26 = var7[0];
      float var27 = var7[1];
      float var28 = var7[2];
      float var29 = var7[3];
      float var30 = var7[4];
      float var31 = var7[5];
      float var32 = var7[6];
      float var33 = var7[7];
      float var34 = var7[8];
      float var35 = pl;
      float var36 = pm;
      float var37 = pn;
      float var38 = ol;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      boolean var42 = qm;
      int var43 = qj;
      int var44 = qk;
      int[] var45 = ps;
      boolean var46 = or;
      float var47 = ot;
      float var48 = os;
      float var49 = (float)(var4 * 0.7 % 6283.185307179586);
      float var50 = (float)(var4 * 0.53 % 6283.185307179586 + 1.3);
      float var51 = (float)(var4 * 0.61 % 6283.185307179586 + 2.1);
      double var52 = var20 * var4 * 0.6;
      double var54 = var21 * var4 * 0.6;
      int var56 = gp & 7;
      byte var57 = 8;
      gp++;
      if (gq > 0) {
         gq--;
         var56 = 0;
         var57 = 1;
      }

      for (int var58 = var56; var58 < var16; var58 += var57) {
         float var59 = (float)(gb[var58] - var52);
         float var60 = (float)gc[var58];
         float var61 = (float)(gd[var58] - var54);
         gk[var58] = 0.45F
            * (
               MathHelper.sin(1.3F * var61 + var49)
                  + MathHelper.cos(1.3F * var60 + var50)
                  + 0.5F * (MathHelper.sin(3.1F * var61 + var51) + MathHelper.cos(3.1F * var60 + var49))
            );
         gl[var58] = 0.35F
            * (
               MathHelper.sin(1.3F * var59 + var51)
                  + MathHelper.cos(1.3F * var61 + var49)
                  + 0.5F * (MathHelper.sin(3.1F * var59 + var50) + MathHelper.cos(3.1F * var61 + var51))
            );
         gm[var58] = 0.45F
            * (
               MathHelper.sin(1.3F * var60 + var50)
                  + MathHelper.cos(1.3F * var59 + var51)
                  + 0.5F * (MathHelper.sin(3.1F * var60 + var49) + MathHelper.cos(3.1F * var59 + var50))
            );
      }

      for (int var130 = 0; var130 < var16; var130++) {
         float var131 = ge[var130] + var3;
         double var132 = gb[var130];
         double var62 = gc[var130];
         double var64 = gd[var130];
         double var66 = (var132 - var9) * (var132 - var9) + (var64 - var13) * (var64 - var13);
         double var68 = var62 - var11;
         if (var131 >= gf[var130] || var66 > 784.0 || var68 > 18.0 || var68 < -18.0) {
            ad(var130, var9, var11, var13, false);
            var131 = 0.0F;
            var132 = gb[var130];
            var62 = gc[var130];
            var64 = gd[var130];
         }

         ge[var130] = var131;
         float var70 = gf[var130];
         float var71 = var131 / var70;
         float var72 = gh[var130];
         float var73 = gi[var130] * var25;
         gi[var130] = var73;
         float var74 = var20 * 0.8F + gk[var130];
         float var75 = var21 * 0.8F + gm[var130];
         float var76 = var73 - 0.25F + gl[var130];
         var132 += var74 * var3;
         var62 += var76 * var3;
         var64 += var75 * var3;
         gb[var130] = var132;
         gc[var130] = var62;
         gd[var130] = var64;
         float var77 = (float)(var132 - var9);
         float var78 = (float)(var62 - var11);
         float var79 = (float)(var64 - var13);
         float var80 = var77 * var77 + var78 * var78 + var79 * var79;
         float var81 = MathHelper.sqrt(var80);
         float var82 = var77 * var32 + var78 * var33 + var79 * var34;
         if (!(var81 < 0.3F) && !(var82 < -0.3F * var81)) {
            if (var46) {
               float var83 = 0.7F + var82 * var47;
               if (var83 < 0.0F || (var80 - var82 * var82) * var48 > var83 * var83) {
                  continue;
               }
            }

            float var136 = var71 / 0.06F;
            var136 = var136 > 1.0F ? 1.0F : var136;
            float var84 = var81 - 0.35F;
            var84 = var84 < 0.0F ? 0.0F : (var84 > 1.0F ? 1.0F : var84);
            float var85 = (var81 - 18.0F) / 8.0F;
            var85 = var85 < 0.0F ? 0.0F : (var85 > 1.0F ? 1.0F : var85);
            float var86 = var78 < 0.0F ? -var78 : var78;
            float var87 = (var86 - 12.0F) / 5.5F;
            var87 = var87 < 0.0F ? 0.0F : (var87 > 1.0F ? 1.0F : var87);
            float var88 = (var17 - var130) / 24.0F;
            var88 = var88 < 0.0F ? 0.0F : (var88 > 1.0F ? 1.0F : var88);
            float var89 = MathHelper.sin(var4 * 2.3 * gj[var130] + var72);
            var89 = var89 > 0.96F ? (var89 - 0.96F) * 25.0F : 0.0F;
            float var90 = 0.7F + 0.3F * MathHelper.sin(var4 * 23.0 + var72 * 3.0) * MathHelper.sin(var4 * 17.3 + var72 * 5.0) + 0.8F * var89;
            float var91 = 1.0F - var71;
            float var92 = var91 * var91 * (1.5F - 0.5F * var91);
            float var93 = var6
               * var136
               * var90
               * var88
               * var92
               * 2.0F
               * (var84 * var84 * (3.0F - 2.0F * var84))
               * (1.0F - var85 * var85 * (3.0F - 2.0F * var85))
               * (1.0F - var87 * var87 * (3.0F - 2.0F * var87));
            if (var42) {
               int var94 = MathHelper.floor(var132) - var43 + 24;
               int var95 = MathHelper.floor(var64) - var44 + 24;
               if (var94 >= 0 && var95 >= 0 && var94 < 49 && var95 < 49) {
                  float var96 = (float)(var62 - (var45[var95 * 49 + var94] - 0.1)) / 0.9F;
                  var96 = var96 < 0.0F ? 0.0F : (var96 > 1.0F ? 1.0F : var96);
                  var93 *= var96 * var96 * (3.0F - 2.0F * var96);
               }
            }

            if (var39 > 0.0F) {
               float var143 = (var81 - var40) * var41;
               var93 *= var143 < 0.0F ? 1.0F : (var143 > 1.0F ? 0.0F : 1.0F - var143);
            }

            if (!(var93 < 0.01F)) {
               int var144;
               int var145;
               int var147;
               if (var91 > 0.6F) {
                  float var97 = (var91 - 0.6F) / 0.4F;
                  var144 = -1751862972 ^ -1751862853;
                  var145 = (int)(120.0F + 70.0F * var97);
                  var147 = (int)(30.0F + 40.0F * var97);
               } else if (var91 > 0.25F) {
                  float var148 = (var91 - 0.25F) / 0.35F;
                  var144 = -1466923995 ^ -1466923814;
                  var145 = (int)(62.0F + 58.0F * var148);
                  var147 = (int)(12.0F + 18.0F * var148);
               } else {
                  float var149 = var91 / 0.25F;
                  var144 = (int)(170.0F + 85.0F * var149);
                  var145 = (int)(28.0F + 34.0F * var149);
                  var147 = (int)(8.0F + 4.0F * var149);
               }

               if (var8 > 0.0F) {
                  int var150 = var91 > 0.5F ? -2180376 ^ -2180585 : (int)(255.0F - 150.0F * (0.5F - var91));
                  int var98 = (int)(12.0F + 52.0F * var91);
                  int var99 = (int)(10.0F + 34.0F * var91);
                  var144 = (int)(var144 + (var150 - var144) * var8);
                  var145 = (int)(var145 + (var98 - var145) * var8);
                  var147 = (int)(var147 + (var99 - var147) * var8);
               }

               float var151 = gg[var130];
               float var152 = 0.1F + var151 * 6.0F;
               float var153 = var81 * 0.12F;
               if (var152 > var153) {
                  var152 = var153;
               }

               int var100 = (int)((var93 > 1.0F ? 1.0F : var93) * var24 * 255.0F);
               float var101 = var26 * var152;
               float var102 = var27 * var152;
               float var103 = var28 * var152;
               float var104 = var29 * var152;
               float var105 = var30 * var152;
               float var106 = var31 * var152;
               if (ou) {
                  var0.vertex(var77 - var101 - var104, var78 - var102 - var105, var79 - var103 - var106)
                     .texture(0.0F, 1.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 - var101 + var104, var78 - var102 + var105, var79 - var103 + var106)
                     .texture(0.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 + var101 + var104, var78 + var102 + var105, var79 + var103 + var106)
                     .texture(1.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 + var101 - var104, var78 + var102 - var105, var79 + var103 - var106)
                     .texture(1.0F, 1.0F)
                     .color(var144, var145, var147, var100);
               } else {
                  var0.vertex(var1, var77 - var101 - var104, var78 - var102 - var105, var79 - var103 - var106)
                     .texture(0.0F, 1.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 - var101 + var104, var78 - var102 + var105, var79 - var103 + var106)
                     .texture(0.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 + var101 + var104, var78 + var102 + var105, var79 + var103 + var106)
                     .texture(1.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 + var101 - var104, var78 + var102 - var105, var79 + var103 - var106)
                     .texture(1.0F, 1.0F)
                     .color(var144, var145, var147, var100);
               }

               float var107 = var151;
               float var108 = 0.95F * var81 / var38;
               float var109 = 1.0F;
               if (var107 < var108) {
                  var109 = var107 / var108;
                  var107 = var108;
               }

               float var110 = var29 * var107;
               float var111 = var30 * var107;
               float var112 = var31 * var107;
               float var113 = var26 * var107;
               float var114 = var27 * var107;
               float var115 = var28 * var107;
               float var116 = var74 - var35;
               float var117 = var76 - var36;
               float var118 = var75 - var37;
               float var119 = var116 * var116 + var117 * var117 + var118 * var118;
               if (var119 > 1.0E-4F) {
                  float var120 = MathHelper.sqrt(var119);
                  float var121 = var116 / var120;
                  float var122 = var117 / var120;
                  float var123 = var118 / var120;
                  float var124 = var122 * var79 - var123 * var78;
                  float var125 = var123 * var77 - var121 * var79;
                  float var126 = var121 * var78 - var122 * var77;
                  float var127 = MathHelper.sqrt(var124 * var124 + var125 * var125 + var126 * var126);
                  if (var127 > 0.001F) {
                     float var128 = var107 + var120 * 0.0165F;
                     var109 *= (float)Math.sqrt(var107 / var128);
                     var110 = var121 * var128;
                     var111 = var122 * var128;
                     var112 = var123 * var128;
                     var113 = var124 * var107 / var127;
                     var114 = var125 * var107 / var127;
                     var115 = var126 * var107 / var127;
                  }
               }

               float var154 = var93 * var23 * (var109 * 2.2F > 1.0F ? 1.0F : var109 * 2.2F) * 1.6F;
               int var155 = (int)((var154 > 1.0F ? 1.0F : var154) * 255.0F);
               int var156 = var145 + 70 > (-1901979162 ^ -1901979367) ? 637739032 ^ 637739239 : var145 + 70;
               int var157 = var147 + 40 > (1281511540 ^ 1281511563) ? -1020340821 ^ -1020340908 : var147 + 40;
               if (ou) {
                  var0.vertex(var77 - var113 - var110, var78 - var114 - var111, var79 - var115 - var112)
                     .texture(0.0F, 1.0F)
                     .color(-388494362 ^ -388494567, var156, var157, var155);
                  var0.vertex(var77 - var113 + var110, var78 - var114 + var111, var79 - var115 + var112)
                     .texture(0.0F, 0.0F)
                     .color(1490417715 ^ 1490417868, var156, var157, var155);
                  var0.vertex(var77 + var113 + var110, var78 + var114 + var111, var79 + var115 + var112)
                     .texture(1.0F, 0.0F)
                     .color(-1451630964 ^ -1451630989, var156, var157, var155);
                  var0.vertex(var77 + var113 - var110, var78 + var114 - var111, var79 + var115 - var112)
                     .texture(1.0F, 1.0F)
                     .color(1288994429 ^ 1288994434, var156, var157, var155);
               } else {
                  var0.vertex(var1, var77 - var113 - var110, var78 - var114 - var111, var79 - var115 - var112)
                     .texture(0.0F, 1.0F)
                     .color(1389969988 ^ 1389970107, var156, var157, var155);
                  var0.vertex(var1, var77 - var113 + var110, var78 - var114 + var111, var79 - var115 + var112)
                     .texture(0.0F, 0.0F)
                     .color(-1861842842 ^ -1861842791, var156, var157, var155);
                  var0.vertex(var1, var77 + var113 + var110, var78 + var114 + var111, var79 + var115 + var112)
                     .texture(1.0F, 0.0F)
                     .color(-1126004367 ^ -1126004338, var156, var157, var155);
                  var0.vertex(var1, var77 + var113 - var110, var78 + var114 - var111, var79 + var115 - var112)
                     .texture(1.0F, 1.0F)
                     .color(-1027179510 ^ -1027179275, var156, var157, var155);
               }
            }
         }
      }
   }

   private static void af(int var0, double var1, double var3, double var5) {
      if (qq != 0) {
         System.nanoTime();
      }

      gw[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 14.0;
      ha[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 8.0;
      hb[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 14.0;
      float var7 = ed.nextFloat() * (float) (Math.PI * 2);
      float var8 = 0.05F + ed.nextFloat() * 0.18F;
      hc[var0] = MathHelper.cos(var7) * var8;
      he[var0] = MathHelper.sin(var7) * var8;
      hd[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.06F;
      hf[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      hg[var0] = 0.6F + ed.nextFloat() * 2.4F;
      hh[var0] = 0.012F + ed.nextFloat() * ed.nextFloat() * 0.024F;
      hi[var0] = ed.nextFloat();
   }

   private static void ag(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float var7, float var8, float var9, float[] var10) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      double var11 = var2.x;
      double var13 = var2.y;
      double var15 = var2.z;
      if (!hj) {
         for (int var17 = 0; var17 < (-974424332 ^ -974424273); var17++) {
            af(var17, var11, var13, var15);
         }

         hj = true;
      }

      float var119 = 380.0F * (0.3F + 0.7F * ov) * (1.0F + 0.25F * var7);
      hk = hk + (var119 - hk) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var18 = Math.min(-567320480 ^ -567320133, (int)Math.ceil(hk));
      float var19 = hk;
      float var20 = ow * 0.6F;
      float var21 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var22 = MathHelper.cos(var21) * var20;
      float var23 = MathHelper.sin(var21) * var20;
      float var24 = var10[0];
      float var25 = var10[1];
      float var26 = var10[2];
      float var27 = var10[3];
      float var28 = var10[4];
      float var29 = var10[5];
      float var30 = var10[6];
      float var31 = var10[7];
      float var32 = var10[8];
      boolean var33 = or;
      float var34 = ot;
      float var35 = os;
      double var36 = 28.0;
      double var38 = 16.0;
      double var40 = 28.0;
      float var42 = 10.08F;
      float var43 = 3.92F;
      float var44 = 5.2F;
      float var45 = 2.8F;
      float var46 = (0.1F + 0.1F * oy) * (1.0F - 0.85F * var7);
      float var47 = 3.0F + 2.0F * oy;
      float var48 = 1.0F - var7 - var8 - var9;
      var48 = var48 < 0.0F ? 0.0F : var48;
      float var49 = var8 + var9;
      float var50 = ol;
      float var51 = pg;
      float var52 = pe;
      float var53 = pf;
      boolean var54 = qm;
      int var55 = qj;
      int var56 = qk;
      int[] var57 = ps;

      for (int var58 = 0; var58 < var18; var58++) {
         float var59 = hf[var58];
         float var60 = hc[var58] + var22 + 0.05F * MathHelper.sin(var4 * 0.7 + var59);
         float var61 = hd[var58] * (1.0F - var7)
            - var7 * (0.04F + 0.0254648F * var59)
            + var8 * (0.05F + 0.1F * hi[var58])
            + 0.04F * MathHelper.sin(var4 * 0.5 + var59 * 1.7);
         float var62 = he[var58] + var23 + 0.05F * MathHelper.cos(var4 * 0.6 + var59 * 1.3);
         double var63 = gw[var58] + var60 * var3;
         double var65 = ha[var58] + var61 * var3;
         double var67 = hb[var58] + var62 * var3;
         double var69 = var63 - var11;
         double var71 = var65 - var13;
         double var73 = var67 - var15;
         if (var69 < -14.0 || var69 >= 14.0) {
            var69 -= Math.floor((var69 + 14.0) / var36) * var36;
            var63 = var11 + var69;
         }

         if (var71 < -8.0 || var71 >= 8.0) {
            var71 -= Math.floor((var71 + 8.0) / var38) * var38;
            var65 = var13 + var71;
         }

         if (var73 < -14.0 || var73 >= 14.0) {
            var73 -= Math.floor((var73 + 14.0) / var40) * var40;
            var67 = var15 + var73;
         }

         gw[var58] = var63;
         ha[var58] = var65;
         hb[var58] = var67;
         float var75 = (float)var69;
         float var76 = (float)var71;
         float var77 = (float)var73;
         float var78 = var75 * var75 + var76 * var76 + var77 * var77;
         float var79 = MathHelper.sqrt(var78);
         float var80 = var75 * var30 + var76 * var31 + var77 * var32;
         if (!(var79 < 0.4F) && !(var80 < -0.2F * var79)) {
            if (var33) {
               float var81 = 0.45F + var80 * var34;
               if (var81 < 0.0F || (var78 - var80 * var80) * var35 > var81 * var81) {
                  continue;
               }
            }

            if (var54) {
               int var121 = MathHelper.floor(var63) - var55 + 24;
               int var82 = MathHelper.floor(var67) - var56 + 24;
               if (var121 >= 0 && var82 >= 0 && var121 < 49 && var82 < 49 && var65 < var57[var82 * 49 + var121]) {
                  continue;
               }
            }

            float var122 = (var79 - 0.6F) / 1.6F;
            var122 = var122 < 0.0F ? 0.0F : (var122 > 1.0F ? 1.0F : var122);
            float var124 = (MathHelper.sqrt(var75 * var75 + var77 * var77) - var42) / var43;
            var124 = var124 < 0.0F ? 0.0F : (var124 > 1.0F ? 1.0F : var124);
            float var83 = ((var76 < 0.0F ? -var76 : var76) - var44) / var45;
            var83 = var83 < 0.0F ? 0.0F : (var83 > 1.0F ? 1.0F : var83);
            float var84 = (var19 - var58) / 24.0F;
            var84 = var84 < 0.0F ? 0.0F : (var84 > 1.0F ? 1.0F : var84);
            float var85 = MathHelper.sin(var4 * hg[var58] + var59);
            float var86 = var85 * var85;
            var86 *= var86;
            float var87 = var86 * var86;
            float var88 = var87 * var87;
            var88 *= var88;
            float var89 = 0.5F + 0.5F * var85;
            float var90 = var48 * (0.12F + 0.12F * var89 + 0.9F * var87) + var7 * (0.04F + 2.2F * var88) + var49 * (0.3F + 0.3F * var89 + 0.9F * var87);
            float var91 = var6
               * var90
               * var84
               * (var122 * var122 * (3.0F - 2.0F * var122))
               * (1.0F - var124 * var124 * (3.0F - 2.0F * var124))
               * (1.0F - var83 * var83 * (3.0F - 2.0F * var83));
            if (var51 > 0.0F) {
               float var92 = (var79 - var52) * var53;
               var91 *= var92 < 0.0F ? 1.0F : (var92 > 1.0F ? 0.0F : 1.0F - var92);
            }

            if (!(var91 < 0.01F)) {
               if (var91 > 1.0F) {
                  var91 = 1.0F;
               }

               float var130 = hi[var58];
               int var93;
               int var94;
               int var95;
               if (var130 < 0.35F) {
                  var93 = 213372535 ^ 213372637;
                  var94 = -737267060 ^ -737267189;
                  var95 = -1245815208 ^ -1245815129;
               } else if (var130 < 0.65F) {
                  var93 = 125;
                  var94 = -760703707 ^ -760703616;
                  var95 = 1656546509 ^ 1656546354;
               } else if (var130 < 0.82F) {
                  var93 = 1078282642 ^ 1078282605;
                  var94 = 603771864 ^ 603771726;
                  var95 = -394811363 ^ -394811140;
               } else {
                  var93 = -371824473 ^ -371824564;
                  var94 = 1661446522 ^ 1661446548;
                  var95 = -1885940856 ^ -1885940873;
               }

               int var96;
               int var97;
               int var98;
               if (var130 < 0.45F) {
                  var96 = 670065596 ^ 670065456;
                  var97 = -622427940 ^ -622428125;
                  var98 = 1903519815 ^ 1903519887;
               } else if (var130 < 0.8F) {
                  var96 = -2085695089 ^ -2085695207;
                  var97 = 252828033 ^ 252828007;
                  var98 = -1128467076 ^ -1128467069;
               } else {
                  var96 = -145176087 ^ -145176318;
                  var97 = -1178073977 ^ -1178073989;
                  var98 = 326982940 ^ 326983139;
               }

               int var99;
               int var100;
               int var101;
               if (var130 < 0.38F) {
                  var99 = -875419104 ^ -875418913;
                  var100 = 72;
                  var101 = -1740602417 ^ -1740602511;
               } else if (var130 < 0.66F) {
                  var99 = 70;
                  var100 = 1920644815 ^ 1920644651;
                  var101 = 647705670 ^ 647705785;
               } else if (var130 < 0.86F) {
                  var99 = -1298335502 ^ -1298335650;
                  var100 = 96;
                  var101 = -685842623 ^ -685842498;
               } else {
                  var99 = 1657713867 ^ 1657713716;
                  var100 = 777728567 ^ 777728761;
                  var101 = -272578868 ^ -272579014;
               }

               int var102;
               int var103;
               int var104;
               if (var130 < 0.55F) {
                  var102 = 24;
                  var103 = 553804400 ^ 553804528;
                  var104 = 1504405104 ^ 1504405135;
               } else if (var130 < 0.85F) {
                  var102 = 64;
                  var103 = -1690456891 ^ -1690457071;
                  var104 = 1297250485 ^ 1297250378;
               } else {
                  var102 = 92607883 ^ 92607797;
                  var103 = 1137718833 ^ 1137719001;
                  var104 = -130854515 ^ -130854542;
               }

               int var105 = (int)(var93 * var48 + var96 * var7 + var99 * var8 + var102 * var9);
               int var106 = (int)(var94 * var48 + var97 * var7 + var100 * var8 + var103 * var9);
               int var107 = (int)(var95 * var48 + var98 * var7 + var101 * var8 + var104 * var9);
               float var108 = hh[var58] * (1.0F + 0.6F * var87);
               float var109 = var108 * var47;
               int var110 = (int)(var91 * var46 * 255.0F);
               if (var110 > 0) {
                  float var111 = var24 * var109;
                  float var112 = var25 * var109;
                  float var113 = var26 * var109;
                  float var114 = var27 * var109;
                  float var115 = var28 * var109;
                  float var116 = var29 * var109;
                  if (ou) {
                     var0.vertex(var75 - var111 - var114, var76 - var112 - var115, var77 - var113 - var116)
                        .texture(0.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 - var111 + var114, var76 - var112 + var115, var77 - var113 + var116)
                        .texture(0.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 + var111 + var114, var76 + var112 + var115, var77 + var113 + var116)
                        .texture(1.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 + var111 - var114, var76 + var112 - var115, var77 + var113 - var116)
                        .texture(1.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                  } else {
                     var0.vertex(var1, var75 - var111 - var114, var76 - var112 - var115, var77 - var113 - var116)
                        .texture(0.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 - var111 + var114, var76 - var112 + var115, var77 - var113 + var116)
                        .texture(0.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 + var111 + var114, var76 + var112 + var115, var77 + var113 + var116)
                        .texture(1.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 + var111 - var114, var76 + var112 - var115, var77 + var113 - var116)
                        .texture(1.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                  }
               }

               float var131 = 0.5F * var79 / var50;
               if (var108 < var131) {
                  var91 *= var108 / var131;
                  var108 = var131;
               }

               int var132 = (int)(var91 * 255.0F);
               float var133 = var24 * var108;
               float var134 = var25 * var108;
               float var135 = var26 * var108;
               float var136 = var27 * var108;
               float var117 = var28 * var108;
               float var118 = var29 * var108;
               if (ou) {
                  var0.vertex(var75 - var133 - var136, var76 - var134 - var117, var77 - var135 - var118)
                     .texture(0.0F, 1.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 - var133 + var136, var76 - var134 + var117, var77 - var135 + var118)
                     .texture(0.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 + var133 + var136, var76 + var134 + var117, var77 + var135 + var118)
                     .texture(1.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 + var133 - var136, var76 + var134 - var117, var77 + var135 - var118)
                     .texture(1.0F, 1.0F)
                     .color(var105, var106, var107, var132);
               } else {
                  var0.vertex(var1, var75 - var133 - var136, var76 - var134 - var117, var77 - var135 - var118)
                     .texture(0.0F, 1.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 - var133 + var136, var76 - var134 + var117, var77 - var135 + var118)
                     .texture(0.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 + var133 + var136, var76 + var134 + var117, var77 + var135 + var118)
                     .texture(1.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 + var133 - var136, var76 + var134 - var117, var77 + var135 - var118)
                     .texture(1.0F, 1.0F)
                     .color(var105, var106, var107, var132);
               }
            }
         }
      }
   }

   private static void ah(int var0, ClientWorld var1, double var2, double var4, double var6, boolean var8) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      double var9 = ed.nextDouble() * Math.PI * 2.0;
      double var11 = 2.5 + 17.5 * Math.sqrt(ed.nextDouble());
      double var13 = var2 + Math.cos(var9) * var11;
      double var15 = var6 + Math.sin(var9) * var11;
      double var17 = var4 - 1.6;
      if (var1 != null) {
         int var19 = var1.getTopY(Type.MOTION_BLOCKING_NO_LEAVES, MathHelper.floor(var13), MathHelper.floor(var15));
         if (var19 > var1.getBottomY() && var19 - var4 < 20.0 && var4 - var19 < 20.0) {
            var17 = var19;
         }
      }

      hm[var0] = var13;
      double var21 = ed.nextDouble();
      hn[var0] = var17 + 0.2 + 1.6 * var21 * var21;
      ho[var0] = var15;
      hp[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      hq[var0] = 0.22F + ed.nextFloat() * 0.3F;
      hr[var0] = 0.35F + ed.nextFloat() * 0.45F;
      hs[var0] = 0.25F + ed.nextFloat() * 0.35F;
      ht[var0] = 0.5F + ed.nextFloat() * 1.3F;
      hu[var0] = 4.0F + ed.nextFloat() * 3.5F;
      hv[var0] = ed.nextFloat() * hu[var0];
      hw[var0] = 14.0F + ed.nextFloat() * 18.0F;
      hx[var0] = var8 ? ed.nextFloat() * hw[var0] : 0.0F;
      hy[var0] = 0.009F + ed.nextFloat() * 0.006F;
      hz[var0] = ed.nextFloat();
   }

   private static void ai(VertexConsumer var0, Entry var1, ClientWorld var2, Vec3d var3, float var4, double var5, float var7, float[] var8) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      double var9 = var3.x;
      double var11 = var3.y;
      double var13 = var3.z;
      if (!ia) {
         for (int var15 = 0; var15 < (-1454899300 ^ -1454899492); var15++) {
            ah(var15, var2, var9, var11, var13, true);
         }

         ia = true;
      }

      float var104 = 320.0F * (0.25F + 0.75F * ov);
      ib = ib + (var104 - ib) * (1.0F - (float)Math.exp(-var4 * 1.5F));
      int var16 = Math.min(635151721 ^ 635151401, (int)Math.ceil(ib));
      float var17 = ib;
      float var18 = ow * 0.35F;
      float var19 = 0.6F + 0.35F * MathHelper.sin(var5 * 0.031);
      float var20 = MathHelper.cos(var19) * var18;
      float var21 = MathHelper.sin(var19) * var18;
      float var22 = pa;
      float var23 = 0.6F + 0.4F * (1.0F - (var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22)));
      float var24 = oy;
      float var25 = (0.16F + 0.3F * var24) * var23;
      float var26 = (0.75F + 0.25F * var24) * var23;
      float var27 = 5.0F + 3.0F * var24;
      float var28 = var8[0];
      float var29 = var8[1];
      float var30 = var8[2];
      float var31 = var8[3];
      float var32 = var8[4];
      float var33 = var8[5];
      float var34 = var8[6];
      float var35 = var8[7];
      float var36 = var8[8];
      boolean var37 = or;
      float var38 = ot;
      float var39 = os;
      float var40 = ol;
      float var41 = pg;
      float var42 = pe;
      float var43 = pf;

      for (int var44 = 0; var44 < var16; var44++) {
         float var45 = hx[var44] + var4;
         double var46 = hm[var44] + var20 * var4;
         double var48 = hn[var44];
         double var50 = ho[var44] + var21 * var4;
         double var52 = var46 - var9;
         double var54 = var50 - var13;
         if (var45 >= hw[var44] || var52 * var52 + var54 * var54 > 676.0 || var48 - var11 > 22.0 || var11 - var48 > 22.0) {
            ah(var44, var2, var9, var11, var13, false);
            var45 = 0.0F;
            var46 = hm[var44];
            var48 = hn[var44];
            var50 = ho[var44];
         }

         hx[var44] = var45;
         hm[var44] = var46;
         ho[var44] = var50;
         float var56 = hp[var44];
         float var57 = ht[var44];
         float var58 = hq[var44];
         float var59 = hr[var44];
         float var60 = hs[var44];
         double var61 = var46 + var57 * MathHelper.sin(var5 * var58 + var56) + 0.35F * var57 * MathHelper.sin(var5 * var59 * 2.3 + var56 * 1.7);
         double var63 = var50 + var57 * MathHelper.cos(var5 * var60 + var56 * 1.3) + 0.35F * var57 * MathHelper.cos(var5 * var59 * 1.9 + var56);
         double var65 = var48 + 0.45F * MathHelper.sin(var5 * var59 + var56 * 2.1) + 0.18F * MathHelper.sin(var5 * 1.7 + var56);
         float var67 = (float)(var61 - var9);
         float var68 = (float)(var65 - var11);
         float var69 = (float)(var63 - var13);
         float var70 = var67 * var67 + var68 * var68 + var69 * var69;
         float var71 = MathHelper.sqrt(var70);
         float var72 = var67 * var34 + var68 * var35 + var69 * var36;
         if (!(var71 < 0.35F) && !(var72 < -0.3F * var71)) {
            if (var37) {
               float var73 = 0.7F + var72 * var38;
               if (var73 < 0.0F || (var70 - var72 * var72) * var39 > var73 * var73) {
                  continue;
               }
            }

            float var106 = hu[var44];
            float var74 = (float)((var5 + hv[var44]) % var106);
            float var75 = var74 < 0.1F ? var74 * 10.0F : (var74 < 0.25F ? 1.0F : (var74 < 0.6F ? 1.0F - (var74 - 0.25F) / 0.35F : 0.0F));
            var75 = var75 * var75 * (3.0F - 2.0F * var75);
            float var76 = 0.015F + 0.985F * var75;
            float var77 = var45 / hw[var44];
            float var78 = var77 / 0.1F;
            var78 = var78 > 1.0F ? 1.0F : var78;
            float var79 = (1.0F - var77) / 0.1F;
            var79 = var79 < 0.0F ? 0.0F : (var79 > 1.0F ? 1.0F : var79);
            float var80 = (var71 - 0.4F) / 1.4F;
            var80 = var80 < 0.0F ? 0.0F : (var80 > 1.0F ? 1.0F : var80);
            float var81 = (var71 - 17.0F) / 6.0F;
            var81 = var81 < 0.0F ? 0.0F : (var81 > 1.0F ? 1.0F : var81);
            float var82 = (var17 - var44) / 16.0F;
            var82 = var82 < 0.0F ? 0.0F : (var82 > 1.0F ? 1.0F : var82);
            float var83 = var7
               * var76
               * var82
               * (var78 * var78 * (3.0F - 2.0F * var78))
               * (var79 * var79 * (3.0F - 2.0F * var79))
               * (var80 * var80 * (3.0F - 2.0F * var80))
               * (1.0F - var81 * var81 * (3.0F - 2.0F * var81));
            if (var41 > 0.0F) {
               float var84 = (var71 - var42) * var43;
               var83 *= var84 < 0.0F ? 1.0F : (var84 > 1.0F ? 0.0F : 1.0F - var84);
            }

            if (!(var83 < 0.01F)) {
               if (var83 > 1.0F) {
                  var83 = 1.0F;
               }

               boolean var113 = hz[var44] >= 0.95F;
               int var85 = var113 ? 482295737 ^ 482295622 : 950593719 ^ 950593651;
               int var86 = var113 ? 470786054 ^ 470786248 : 842917287 ^ 842917208;
               int var87 = var113 ? 90 : 96;
               float var88 = hy[var44] * (0.8F + 0.35F * var75);
               float var89 = 0.05F + hy[var44] * var27 * (0.8F + 0.35F * var75);
               float var90 = 0.8F * var71 / var40;
               float var91 = 1.0F;
               if (var88 < var90) {
                  var91 = var88 / var90;
                  var88 = var90;
               }

               var68 += 0.22F * var75;
               float var92 = var71 * 0.22F;
               if (var89 > var92) {
                  var89 = var92;
               }

               int var93 = (int)(var83 * var25 * 255.0F);
               if (var93 > 0) {
                  float var94 = var28 * var89;
                  float var95 = var29 * var89;
                  float var96 = var30 * var89;
                  float var97 = var31 * var89;
                  float var98 = var32 * var89;
                  float var99 = var33 * var89;
                  if (ou) {
                     var0.vertex(var67 - var94 - var97, var68 - var95 - var98, var69 - var96 - var99).texture(0.0F, 1.0F).color(var85, var86, var87, var93);
                     var0.vertex(var67 - var94 + var97, var68 - var95 + var98, var69 - var96 + var99).texture(0.0F, 0.0F).color(var85, var86, var87, var93);
                     var0.vertex(var67 + var94 + var97, var68 + var95 + var98, var69 + var96 + var99).texture(1.0F, 0.0F).color(var85, var86, var87, var93);
                     var0.vertex(var67 + var94 - var97, var68 + var95 - var98, var69 + var96 - var99).texture(1.0F, 1.0F).color(var85, var86, var87, var93);
                  } else {
                     var0.vertex(var1, var67 - var94 - var97, var68 - var95 - var98, var69 - var96 - var99)
                        .texture(0.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 - var94 + var97, var68 - var95 + var98, var69 - var96 + var99)
                        .texture(0.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 + var94 + var97, var68 + var95 + var98, var69 + var96 + var99)
                        .texture(1.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 + var94 - var97, var68 + var95 - var98, var69 + var96 - var99)
                        .texture(1.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                  }
               }

               float var114 = var83 * var26 * (var91 * 1.6F > 1.0F ? 1.0F : var91 * 1.6F);
               int var115 = (int)((var114 > 1.0F ? 1.0F : var114) * 255.0F);
               int var116 = Math.min(-2094042070 ^ -2094041899, var85 + 40);
               int var117 = Math.min(2130573961 ^ 2130573942, var87 + 90);
               float var118 = var28 * var88;
               float var119 = var29 * var88;
               float var100 = var30 * var88;
               float var101 = var31 * var88;
               float var102 = var32 * var88;
               float var103 = var33 * var88;
               if (ou) {
                  var0.vertex(var67 - var118 - var101, var68 - var119 - var102, var69 - var100 - var103)
                     .texture(0.0F, 1.0F)
                     .color(var116, -1266068930 ^ -1266068799, var117, var115);
                  var0.vertex(var67 - var118 + var101, var68 - var119 + var102, var69 - var100 + var103)
                     .texture(0.0F, 0.0F)
                     .color(var116, 1358331390 ^ 1358331137, var117, var115);
                  var0.vertex(var67 + var118 + var101, var68 + var119 + var102, var69 + var100 + var103)
                     .texture(1.0F, 0.0F)
                     .color(var116, 1597685818 ^ 1597685957, var117, var115);
                  var0.vertex(var67 + var118 - var101, var68 + var119 - var102, var69 + var100 - var103)
                     .texture(1.0F, 1.0F)
                     .color(var116, 1475601334 ^ 1475601225, var117, var115);
               } else {
                  var0.vertex(var1, var67 - var118 - var101, var68 - var119 - var102, var69 - var100 - var103)
                     .texture(0.0F, 1.0F)
                     .color(var116, -1989300463 ^ -1989300242, var117, var115);
                  var0.vertex(var1, var67 - var118 + var101, var68 - var119 + var102, var69 - var100 + var103)
                     .texture(0.0F, 0.0F)
                     .color(var116, -1962955294 ^ -1962955491, var117, var115);
                  var0.vertex(var1, var67 + var118 + var101, var68 + var119 + var102, var69 + var100 + var103)
                     .texture(1.0F, 0.0F)
                     .color(var116, 1389346233 ^ 1389346118, var117, var115);
                  var0.vertex(var1, var67 + var118 - var101, var68 + var119 - var102, var69 + var100 - var103)
                     .texture(1.0F, 1.0F)
                     .color(var116, -661331662 ^ -661331507, var117, var115);
               }
            }
         }
      }
   }

   private static void aj(int var0, double var1, double var3, double var5) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      ig[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ih[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 11.0;
      ii[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ij[var0] = 0.65F + ed.nextFloat() * 0.7F;
      ik[var0] = 0.012F + ed.nextFloat() * 0.022F;
      il[var0] = 0.78F + ed.nextFloat() * 0.22F;
      float var7 = ed.nextFloat() * (float) (Math.PI * 2);
      im[var0] = var7;
      float var8 = -0.32F * (float)Math.log(1.0F - 0.92F * var7 / (float) (Math.PI * 2)) + 0.04F;
      in[var0] = var8;
      io[var0] = (float) Math.PI / (0.35F + 0.9F * (float)Math.sqrt(var8));
      ip[var0] = 0.45F + 0.55F * var8 / (var8 + 0.6F);
   }

   private static void ak(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7) {
      if (qq != 0) {
         System.nanoTime();
      }

      double var8 = var2.x;
      double var10 = var2.y;
      double var12 = var2.z;
      if (!it) {
         for (int var14 = 0; var14 < (-1663865528 ^ -1663866952); var14++) {
            aj(var14, var8, var10, var12);
         }

         it = true;
         iw = 2;
      }

      float var138 = 2800.0F * Math.max(0.05F, ov) * 0.75F;
      iu = iu + (var138 - iu) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var15 = Math.min(-1544578449 ^ -1544580961, (int)Math.ceil(iu));
      float var16 = iu;
      float var17 = ox;
      float var18 = (0.3F + 0.7F * ow) * (6.0F + 10.0F * var17);
      float var19 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var20 = MathHelper.cos(var19);
      float var21 = MathHelper.sin(var19);
      float var22 = oz;
      float var23 = 0.28F + 0.72F * (var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22));
      float var24 = var7[0];
      float var25 = var7[1];
      float var26 = var7[2];
      float var27 = var7[3];
      float var28 = var7[4];
      float var29 = var7[5];
      float var30 = var7[6];
      float var31 = var7[7];
      float var32 = var7[8];
      float var33 = pl;
      float var34 = pm;
      float var35 = pn;
      float var36 = ol;
      float var37 = om;
      float var38 = on;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      float var42 = pb;
      float var43 = pc;
      float var44 = pd;
      boolean var45 = qm;
      int var46 = qj;
      int var47 = qk;
      int[] var48 = ps;
      boolean var49 = or;
      boolean var50 = ou;
      float var51 = ot;
      float var52 = os;
      double var53 = 40.0;
      double var55 = 22.0;
      double var57 = 40.0;
      float var59 = 11.0F;
      float var60 = 9.0F;
      float var61 = 6.6000004F;
      float var62 = 4.4F;
      float var63 = 0.22F * var18;
      double var64 = var20 * var18 * 0.8 * var4;
      double var66 = var21 * var18 * 0.8 * var4;
      double var68 = 0.064 * var18 * var4;
      double var70 = 0.1 * var4;
      float var72 = (float)(var4 * 0.13 % 6283.185307179586);
      float var73 = (float)(var4 * 0.09 % 6283.185307179586 + 1.3);
      float var74 = (float)(var4 * 0.11 % 6283.185307179586 + 2.1);
      int var75 = iv & 7;
      byte var76 = 8;
      iv++;
      if (iw > 0) {
         iw--;
         var75 = 0;
         var76 = 1;
      }

      for (int var77 = var75; var77 < var15; var77 += var76) {
         boolean var78 = var45 && var77 % 10 < 7;
         double var79 = ig[var77];
         double var81 = ih[var77];
         double var83 = ii[var77];
         float var85 = (float)(var79 * var20 + var83 * var21);
         float var86 = (float)(var83 * var20 - var79 * var21);
         float var87 = var17 + 0.4F * MathHelper.sin(0.08F * var85 - var68 + 1.4F * MathHelper.sin(0.05F * var86 + var70));
         var87 = var87 < 0.0F ? 0.0F : (var87 > 1.0F ? 1.0F : var87);
         float var88 = (float)(var79 - var64);
         float var89 = (float)var81;
         float var90 = (float)(var83 - var66);
         float var91 = MathHelper.sin(0.25F * var90 + var72)
            + MathHelper.cos(0.25F * var89 + var73)
            + 0.5F * (MathHelper.sin(0.8F * var90 + var74) + MathHelper.cos(0.8F * var89 + var72));
         float var92 = MathHelper.sin(0.25F * var88 + var74)
            + MathHelper.cos(0.25F * var90 + var72)
            + 0.5F * (MathHelper.sin(0.8F * var88 + var73) + MathHelper.cos(0.8F * var90 + var74));
         float var93 = MathHelper.sin(0.25F * var89 + var73)
            + MathHelper.cos(0.25F * var88 + var74)
            + 0.5F * (MathHelper.sin(0.8F * var89 + var72) + MathHelper.cos(0.8F * var88 + var73));
         float var94 = var18 * (0.55F + 0.45F * var87) * ij[var77] * (var78 ? ip[var77] : 1.0F);
         float var95 = var78 ? 0.35F * var63 : 0.5F * var63;
         iq[var77] = var20 * var94 + var95 * var91;
         ir[var77] = 0.3F * var63 * var92;
         is[var77] = var21 * var94 + var95 * var93;
      }

      double var139 = var10 - 1.62;

      for (int var140 = 0; var140 < var15; var140++) {
         float var80 = im[var140];
         boolean var141 = var45 && var140 % 10 < 7;
         double var82 = ig[var140];
         double var84 = ih[var140];
         double var142 = ii[var140];
         float var144 = iq[var140];
         float var145 = is[var140];
         double var147 = var82 + var144 * var3;
         double var148 = var142 + var145 * var3;
         float var146;
         double var149;
         if (var141) {
            float var97 = MathHelper.sin((var4 + var80 * 3.0) * io[var140]);
            var97 = var97 < 0.0F ? -var97 : var97;
            int var98 = MathHelper.floor(var147) - var46 + 24;
            int var99 = MathHelper.floor(var148) - var47 + 24;
            double var100 = var98 >= 0 && var99 >= 0 && var98 < 49 && var99 < 49 ? var48[var99 * 49 + var98] : var139;
            var149 = var100 + 0.02 + in[var140] * var97;
            var146 = (float)(var149 - var84) / (var3 > 0.001F ? var3 : 0.001F);
            if (var146 > 6.0F || var146 < -6.0F) {
               var146 = 0.0F;
            }
         } else {
            var146 = (MathHelper.sin(var4 * 1.3 + var80 * 2.0) * 0.5F - 0.15F) * (0.4F + var17) + ir[var140];
            var149 = var84 + var146 * var3;
         }

         double var151 = var147 - var8;
         double var152 = var149 - var10;
         double var101 = var148 - var12;
         if (var151 < -20.0 || var151 >= 20.0) {
            var151 -= Math.floor((var151 + 20.0) / var53) * var53;
            var147 = var8 + var151;
         }

         if (var101 < -20.0 || var101 >= 20.0) {
            var101 -= Math.floor((var101 + 20.0) / var57) * var57;
            var148 = var12 + var101;
         }

         boolean var103 = var152 < -11.0 || var152 >= 11.0;
         if (var103 && !var141) {
            var152 -= Math.floor((var152 + 11.0) / var55) * var55;
            var149 = var10 + var152;
         }

         ig[var140] = var147;
         ih[var140] = var149;
         ii[var140] = var148;
         if (!var103 || !var141) {
            float var104 = (float)var151;
            float var105 = (float)var152;
            float var106 = (float)var101;
            float var107 = var104 * var104 + var105 * var105 + var106 * var106;
            if (!(var107 < 0.09F)) {
               float var108 = MathHelper.sqrt(var107);
               float var109 = var104 * var30 + var105 * var31 + var106 * var32;
               if (!(var109 < -0.3F * var108)) {
                  if (var49) {
                     float var110 = 0.6F + var109 * var51;
                     if (var110 < 0.0F || (var107 - var109 * var109) * var52 > var110 * var110) {
                        continue;
                     }
                  }

                  if (var45 && !var141) {
                     int var153 = MathHelper.floor(var147) - var46 + 24;
                     int var111 = MathHelper.floor(var148) - var47 + 24;
                     if (var153 >= 0 && var111 >= 0 && var153 < 49 && var111 < 49 && var149 < var48[var111 * 49 + var153]) {
                        continue;
                     }
                  }

                  float var154 = (var108 - 0.4F) / 1.2F;
                  var154 = var154 < 0.0F ? 0.0F : (var154 > 1.0F ? 1.0F : var154);
                  float var156 = (var108 - var59) / var60;
                  var156 = var156 < 0.0F ? 0.0F : (var156 > 1.0F ? 1.0F : var156);
                  float var112 = var105 < 0.0F ? -var105 : var105;
                  float var113 = var141 ? 0.0F : (var112 - var61) / var62;
                  var113 = var113 < 0.0F ? 0.0F : (var113 > 1.0F ? 1.0F : var113);
                  float var114 = (var16 - var140) / 64.0F;
                  var114 = var114 < 0.0F ? 0.0F : (var114 > 1.0F ? 1.0F : var114);
                  float var115 = (var141 ? 0.85F : 0.3F)
                     * var6
                     * (var154 * var154 * (3.0F - 2.0F * var154))
                     * (1.0F - var156 * var156 * (3.0F - 2.0F * var156))
                     * (1.0F - var113 * var113 * (3.0F - 2.0F * var113))
                     * var114;
                  if (!(var115 < 0.012F)) {
                     float var116 = ik[var140] * (var141 ? 1.0F : 0.6F);
                     float var117 = 0.6F * var108 / var36;
                     if (var116 < var117) {
                        var115 *= var116 / var117;
                        var116 = var117;
                     }

                     float var118 = var27 * var116;
                     float var119 = var28 * var116;
                     float var120 = var29 * var116;
                     float var121 = var24 * var116;
                     float var122 = var25 * var116;
                     float var123 = var26 * var116;
                     float var124 = var144 - var33;
                     float var125 = var146 - var34;
                     float var126 = var145 - var35;
                     float var127 = var124 * var124 + var125 * var125 + var126 * var126;
                     if (var127 > 1.0F) {
                        float var128 = MathHelper.sqrt(var127);
                        float var129 = var124 / var128;
                        float var130 = var125 / var128;
                        float var131 = var126 / var128;
                        float var132 = var130 * var106 - var131 * var105;
                        float var133 = var131 * var104 - var129 * var106;
                        float var134 = var129 * var105 - var130 * var104;
                        float var135 = MathHelper.sqrt(var132 * var132 + var133 * var133 + var134 * var134);
                        if (var135 > 0.001F) {
                           float var136 = var116 + var128 * 0.01F;
                           float var137 = var116 * 0.75F / var135;
                           var115 *= (float)Math.sqrt(Math.sqrt(var116 / var136));
                           var118 = var129 * var136;
                           var119 = var130 * var136;
                           var120 = var131 * var136;
                           var121 = var132 * var137;
                           var122 = var133 * var137;
                           var123 = var134 * var137;
                        }
                     }

                     float var160 = il[var140] * var23;
                     float var161 = (var104 * var37 + var105 * var38) / var108;
                     if (var161 > 0.0F) {
                        float var162 = var161 * var161;
                        var162 *= var162;
                        var160 *= 1.0F + 0.5F * var162 * var162;
                     }

                     float var164 = 188.0F * var160;
                     float var165 = 142.0F * var160;
                     float var166 = 88.0F * var160;
                     if (var39 > 0.0F) {
                        float var167 = (var108 - var40) * var41;
                        var167 = var167 < 0.0F ? 0.0F : (var167 > 1.0F ? 1.0F : var167);
                        var164 += (var42 - var164) * var167;
                        var165 += (var43 - var165) * var167;
                        var166 += (var44 - var166) * var167;
                     }

                     int var169 = (int)(var164 > 255.0F ? 255.0F : var164);
                     int var170 = (int)(var165 > 255.0F ? 255.0F : var165);
                     int var171 = (int)(var166 > 255.0F ? 255.0F : var166);
                     int var172 = (int)((var115 > 1.0F ? 1.0F : var115) * 255.0F);
                     if (var50) {
                        var0.vertex(var104 - var121 - var118, var105 - var122 - var119, var106 - var123 - var120)
                           .texture(0.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 - var121 + var118, var105 - var122 + var119, var106 - var123 + var120)
                           .texture(0.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 + var121 + var118, var105 + var122 + var119, var106 + var123 + var120)
                           .texture(1.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 + var121 - var118, var105 + var122 - var119, var106 + var123 - var120)
                           .texture(1.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                     } else {
                        var0.vertex(var1, var104 - var121 - var118, var105 - var122 - var119, var106 - var123 - var120)
                           .texture(0.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 - var121 + var118, var105 - var122 + var119, var106 - var123 + var120)
                           .texture(0.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 + var121 + var118, var105 + var122 + var119, var106 + var123 + var120)
                           .texture(1.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 + var121 - var118, var105 + var122 - var119, var106 + var123 - var120)
                           .texture(1.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                     }
                  }
               }
            }
         }
      }
   }

   private static void al(int var0, double var1, double var3, double var5) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      jb[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 26.0;
      jc[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 9.0;
      jd[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 26.0;
      je[var0] = 2.5F + ed.nextFloat() * 4.5F;
      jf[var0] = 0.55F + ed.nextFloat() * 0.35F;
      jg[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      jh[var0] = 0.8F + ed.nextFloat() * 0.2F;
   }

   private static void am(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!ji) {
         for (int var15 = 0; var15 < 40; var15++) {
            al(var15, var9, var11, var13);
         }

         ji = true;
      }

      float var99 = ox;
      float var16 = (0.3F + 0.7F * ow) * (6.0F + 10.0F * var99);
      float var17 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var18 = MathHelper.cos(var17);
      float var19 = MathHelper.sin(var17);
      float var20 = oz;
      float var21 = 0.3F + 0.7F * (var20 < 0.0F ? 0.0F : (var20 > 1.0F ? 1.0F : var20));
      float var22 = var7[0];
      float var23 = var7[1];
      float var24 = var7[2];
      float var25 = var7[3];
      float var26 = var7[4];
      float var27 = var7[5];
      float var28 = var7[6];
      float var29 = var7[7];
      float var30 = var7[8];
      double var31 = 52.0;
      double var33 = 52.0;
      float var35 = 0.6F + 0.4F * var99;
      float var36 = ol;
      float var37 = om;
      float var38 = on;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      float var42 = pb;
      float var43 = pc;
      float var44 = pd;
      boolean var45 = qm;
      int var46 = qj;
      int var47 = qk;
      int[] var48 = ps;
      float var49 = 1.0F - (float)Math.exp(-var3 * 1.5F);

      for (int var50 = 0; var50 < 40; var50++) {
         float var51 = jg[var50];
         float var52 = var16 * jf[var50];
         double var53 = jb[var50] + var18 * var52 * var3;
         double var55 = jd[var50] + var19 * var52 * var3;
         double var57 = var53 - var9;
         double var59 = var55 - var13;
         if (var57 < -26.0 || var57 >= 26.0) {
            var57 -= Math.floor((var57 + 26.0) / var31) * var31;
            var53 = var9 + var57;
         }

         if (var59 < -26.0 || var59 >= 26.0) {
            var59 -= Math.floor((var59 + 26.0) / var33) * var33;
            var55 = var13 + var59;
         }

         jb[var50] = var53;
         jd[var50] = var55;
         double var61 = var11 - 1.62;
         if (var45) {
            int var63 = MathHelper.floor(var53) - var46 + 24;
            int var64 = MathHelper.floor(var55) - var47 + 24;
            if (var63 >= 0 && var64 >= 0 && var63 < 49 && var64 < 49) {
               var61 = var48[var64 * 49 + var63];
            }
         }

         float var100 = var51 * 0.15915494F;
         double var101 = var61 + 0.5 + 3.5 * var100 * var100 + 0.4 * MathHelper.sin(var4 * 0.3 + var51);
         double var66 = jc[var50] + (var101 - jc[var50]) * var49;
         jc[var50] = var66;
         float var68 = (float)var57;
         float var69 = (float)(var66 - var11);
         float var70 = (float)var59;
         float var71 = MathHelper.sqrt(var68 * var68 + var69 * var69 + var70 * var70);
         if (!(var71 < 0.5F) && !(var68 * var28 + var69 * var29 + var70 * var30 < -0.5F * var71)) {
            float var72 = je[var50] * (1.0F + 0.2F * MathHelper.sin(var4 * 0.25 + var51));
            float var73 = (var71 - 1.0F - 0.5F * var72) * 0.25F;
            var73 = var73 < 0.0F ? 0.0F : (var73 > 1.0F ? 1.0F : var73);
            float var74 = (MathHelper.sqrt(var68 * var68 + var70 * var70) - 15.6F) / 10.400001F;
            var74 = var74 < 0.0F ? 0.0F : (var74 > 1.0F ? 1.0F : var74);
            float var75 = 0.16F * var6 * var35 * (var73 * var73 * (3.0F - 2.0F * var73)) * (1.0F - var74 * var74 * (3.0F - 2.0F * var74));
            if (!(var75 < 0.006F)) {
               float var76 = jh[var50] * var21;
               float var77 = (var68 * var37 + var69 * var38) / var71;
               if (var77 > 0.0F) {
                  float var78 = var77 * var77;
                  var76 *= 1.0F + 0.35F * var78 * var78;
               }

               float var104 = 214.0F * var76;
               float var79 = 172.0F * var76;
               float var80 = 114.0F * var76;
               if (var39 > 0.0F) {
                  float var81 = (var71 - var40) * var41;
                  var81 = var81 < 0.0F ? 0.0F : (var81 > 1.0F ? 1.0F : var81);
                  var104 += (var42 - var104) * var81;
                  var79 += (var43 - var79) * var81;
                  var80 += (var44 - var80) * var81;
               }

               int var106 = (int)(var104 > 255.0F ? 255.0F : var104);
               int var82 = (int)(var79 > 255.0F ? 255.0F : var79);
               int var83 = (int)(var80 > 255.0F ? 255.0F : var80);
               int var84 = (int)((var75 > 1.0F ? 1.0F : var75) * 255.0F);
               float var85 = 0.0F;
               float var86 = 0.0F;
               float var87 = 1.0F;
               float var88 = 1.0F;
               if (var8) {
                  float var89 = var72 * 2.0F * var36 / var71;
                  int var90 = var89 >= 48.0F ? 0 : (var89 >= 24.0F ? 1 : 2);
                  var85 = dq[var90];
                  var86 = ds[var90];
                  var87 = dr[var90];
                  var88 = dt[var90];
               }

               double var107 = var51 + var4 * ((var50 & 1) == 0 ? 0.05 : -0.05);
               float var91 = MathHelper.cos(var107);
               float var92 = MathHelper.sin(var107);
               float var93 = (var22 * var91 + var25 * var92) * var72;
               float var94 = (var23 * var91 + var26 * var92) * var72;
               float var95 = (var24 * var91 + var27 * var92) * var72;
               float var96 = (-var22 * var92 + var25 * var91) * var72;
               float var97 = (-var23 * var92 + var26 * var91) * var72;
               float var98 = (-var24 * var92 + var27 * var91) * var72;
               if (ou) {
                  var0.vertex(var68 - var93 - var96, var69 - var94 - var97, var70 - var95 - var98).texture(var85, var88).color(var106, var82, var83, var84);
                  var0.vertex(var68 - var93 + var96, var69 - var94 + var97, var70 - var95 + var98).texture(var85, var86).color(var106, var82, var83, var84);
                  var0.vertex(var68 + var93 + var96, var69 + var94 + var97, var70 + var95 + var98).texture(var87, var86).color(var106, var82, var83, var84);
                  var0.vertex(var68 + var93 - var96, var69 + var94 - var97, var70 + var95 - var98).texture(var87, var88).color(var106, var82, var83, var84);
               } else {
                  var0.vertex(var1, var68 - var93 - var96, var69 - var94 - var97, var70 - var95 - var98)
                     .texture(var85, var88)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 - var93 + var96, var69 - var94 + var97, var70 - var95 + var98)
                     .texture(var85, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 + var93 + var96, var69 + var94 + var97, var70 + var95 + var98)
                     .texture(var87, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 + var93 - var96, var69 + var94 - var97, var70 + var95 - var98)
                     .texture(var87, var88)
                     .color(var106, var82, var83, var84);
               }
            }
         }
      }
   }

   private static void an(int var0, double var1, double var3, double var5) {
      if (qq != 0) {
         System.nanoTime();
      }

      jn[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 18.0;
      jo[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 12.0;
      jp[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 18.0;
      jq[var0] = 0.3F + ed.nextFloat() * 0.5F;
      jr[var0] = 0.01F + ed.nextFloat() * ed.nextFloat() * 0.03F;
      js[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      jt[var0] = 1.5F + ed.nextFloat() * 3.0F;
      ju[var0] = 0.7F + ed.nextFloat() * 0.3F;
   }

   private static void ao(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!jv) {
         for (int var15 = 0; var15 < (-2127164104 ^ -2127165068); var15++) {
            an(var15, var9, var11, var13);
         }

         jv = true;
      }

      float var122 = jx;
      float var16 = 1100.0F * Math.max(0.05F, ov) * (1.0F - 0.9F * var122);
      jw = jw + (var16 - jw) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var17 = Math.min(1911098000 ^ 1911099100, (int)Math.ceil(jw));
      float var18 = jw;
      float var19 = ow * 1.6F;
      float var20 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var21 = MathHelper.cos(var20) * var19;
      float var22 = MathHelper.sin(var20) * var19;
      float var23 = pa;
      float var24 = 0.45F + 0.55F * (var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23));
      float var25 = 158.0F + -66.0F * var122;
      float var26 = 132.0F + -46.0F * var122;
      float var27 = 128.0F + -48.0F * var122;
      float var28 = var7[0];
      float var29 = var7[1];
      float var30 = var7[2];
      float var31 = var7[3];
      float var32 = var7[4];
      float var33 = var7[5];
      float var34 = var7[6];
      float var35 = var7[7];
      float var36 = var7[8];
      float var37 = ol;
      float var38 = pg;
      float var39 = pe;
      float var40 = pf;
      float var41 = pb;
      float var42 = pc;
      float var43 = pd;
      boolean var44 = qm;
      int var45 = qj;
      int var46 = qk;
      int[] var47 = ps;
      boolean var48 = or;
      boolean var49 = ou;
      float var50 = ot;
      float var51 = os;
      double var52 = 36.0;
      double var54 = 24.0;
      double var56 = 36.0;
      float var58 = 9.900001F;
      float var59 = 8.099999F;
      float var60 = 7.2000003F;
      float var61 = 4.8F;

      for (int var62 = 0; var62 < var17; var62++) {
         float var63 = js[var62];
         float var64 = jt[var62];
         float var65 = var21 + MathHelper.sin(var4 * var64 * 0.5 + var63) * 0.35F;
         float var66 = MathHelper.sin(var4 * var64 + var63);
         float var67 = -jq[var62] * (0.75F + 0.5F * (var66 < 0.0F ? -var66 : var66));
         float var68 = var22 + MathHelper.cos(var4 * var64 * 0.41 + var63 * 1.7) * 0.35F;
         double var69 = jn[var62] + var65 * var3;
         double var71 = jo[var62] + var67 * var3;
         double var73 = jp[var62] + var68 * var3;
         double var75 = var69 - var9;
         double var77 = var71 - var11;
         double var79 = var73 - var13;
         if (var75 < -18.0 || var75 >= 18.0) {
            var75 -= Math.floor((var75 + 18.0) / var52) * var52;
            var69 = var9 + var75;
         }

         if (var79 < -18.0 || var79 >= 18.0) {
            var79 -= Math.floor((var79 + 18.0) / var56) * var56;
            var73 = var13 + var79;
         }

         if (var77 < -12.0 || var77 >= 12.0) {
            var77 -= Math.floor((var77 + 12.0) / var54) * var54;
            var71 = var11 + var77;
         }

         jn[var62] = var69;
         jo[var62] = var71;
         jp[var62] = var73;
         float var81 = (float)var75;
         float var82 = (float)var77;
         float var83 = (float)var79;
         float var84 = var81 * var81 + var82 * var82 + var83 * var83;
         if (!(var84 < 0.09F)) {
            float var85 = MathHelper.sqrt(var84);
            float var86 = var81 * var34 + var82 * var35 + var83 * var36;
            if (!(var86 < -0.3F * var85)) {
               if (var48) {
                  float var87 = 0.12F + var86 * var50;
                  if (var87 < 0.0F || (var84 - var86 * var86) * var51 > var87 * var87) {
                     continue;
                  }
               }

               float var123 = 1.0F;
               if (var44) {
                  int var88 = MathHelper.floor(var69) - var45 + 24;
                  int var89 = MathHelper.floor(var73) - var46 + 24;
                  if (var88 >= 0 && var89 >= 0 && var88 < 49 && var89 < 49) {
                     float var90 = var47[var89 * 49 + var88];
                     if (var71 < var90) {
                        continue;
                     }

                     float var91 = (float)(var71 - var90) * 10.0F;
                     var123 = var91 > 1.0F ? 1.0F : var91;
                  }
               }

               float var124 = var85 - 0.3F;
               var124 = var124 < 0.0F ? 0.0F : (var124 > 1.0F ? 1.0F : var124);
               float var126 = (var85 - var58) / var59;
               var126 = var126 < 0.0F ? 0.0F : (var126 > 1.0F ? 1.0F : var126);
               float var128 = var82 < 0.0F ? -var82 : var82;
               float var129 = (var128 - var60) / var61;
               var129 = var129 < 0.0F ? 0.0F : (var129 > 1.0F ? 1.0F : var129);
               float var92 = (var18 - var62) / 64.0F;
               var92 = var92 < 0.0F ? 0.0F : (var92 > 1.0F ? 1.0F : var92);
               float var93 = 0.9F
                  * var6
                  * (var124 * var124 * (3.0F - 2.0F * var124))
                  * (1.0F - var126 * var126 * (3.0F - 2.0F * var126))
                  * (1.0F - var129 * var129 * (3.0F - 2.0F * var129))
                  * var92
                  * var123;
               if (!(var93 < 0.012F)) {
                  float var94 = jr[var62];
                  float var95 = 0.6F * var85 / var37;
                  if (var94 < var95) {
                     var93 *= var94 / var95;
                     var94 = var95;
                  }

                  double var96 = var63 + var4 * var64 * 0.7;
                  float var98 = MathHelper.cos(var96);
                  float var99 = MathHelper.sin(var96);
                  float var100 = MathHelper.cos(var4 * var64 + var63 * 1.3);
                  float var101 = 0.25F + 0.75F * (var100 < 0.0F ? -var100 : var100);
                  float var102 = (var28 * var98 + var31 * var99) * var94 * var101;
                  float var103 = (var29 * var98 + var32 * var99) * var94 * var101;
                  float var104 = (var30 * var98 + var33 * var99) * var94 * var101;
                  float var105 = (-var28 * var99 + var31 * var98) * var94;
                  float var106 = (-var29 * var99 + var32 * var98) * var94;
                  float var107 = (-var30 * var99 + var33 * var98) * var94;
                  float var108 = ju[var62] * var24 * (0.82F + 0.18F * var100);
                  float var109 = var25 * var108;
                  float var110 = var26 * var108;
                  float var111 = var27 * var108;
                  if (var38 > 0.0F) {
                     float var112 = (var85 - var39) * var40;
                     var112 = var112 < 0.0F ? 0.0F : (var112 > 1.0F ? 1.0F : var112);
                     var109 += (var41 - var109) * var112;
                     var110 += (var42 - var110) * var112;
                     var111 += (var43 - var111) * var112;
                  }

                  int var133 = (int)(var109 > 255.0F ? 255.0F : var109);
                  int var113 = (int)(var110 > 255.0F ? 255.0F : var110);
                  int var114 = (int)(var111 > 255.0F ? 255.0F : var111);
                  int var115 = (int)((var93 > 1.0F ? 1.0F : var93) * 255.0F);
                  float var116 = 0.0F;
                  float var117 = 0.0F;
                  float var118 = 1.0F;
                  float var119 = 1.0F;
                  if (var8) {
                     float var120 = var94 * 2.0F * var37 / var85;
                     int var121 = var120 >= 64.0F ? 0 : (var120 >= 32.0F ? 1 : (var120 >= 16.0F ? 2 : 3));
                     var116 = dm[var121];
                     var117 = do99[var121];
                     var118 = dn[var121];
                     var119 = dp[var121];
                  }

                  if (var49) {
                     var0.vertex(var81 - var102 - var105, var82 - var103 - var106, var83 - var104 - var107)
                        .texture(var116, var119)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 - var102 + var105, var82 - var103 + var106, var83 - var104 + var107)
                        .texture(var116, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 + var102 + var105, var82 + var103 + var106, var83 + var104 + var107)
                        .texture(var118, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 + var102 - var105, var82 + var103 - var106, var83 + var104 - var107)
                        .texture(var118, var119)
                        .color(var133, var113, var114, var115);
                  } else {
                     var0.vertex(var1, var81 - var102 - var105, var82 - var103 - var106, var83 - var104 - var107)
                        .texture(var116, var119)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 - var102 + var105, var82 - var103 + var106, var83 - var104 + var107)
                        .texture(var116, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 + var102 + var105, var82 + var103 + var106, var83 + var104 + var107)
                        .texture(var118, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 + var102 - var105, var82 + var103 - var106, var83 + var104 - var107)
                        .texture(var118, var119)
                        .color(var133, var113, var114, var115);
                  }
               }
            }
         }
      }
   }

   private static void ap(int var0, double var1, double var3, double var5, boolean var7, boolean var8) {
      if (qq != 0) {
         new Object().hashCode();
      }

      kr[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      kt[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ks[var0] = var7 ? var3 + (ed.nextDouble() * 2.0 - 1.0) * 14.0 : var3 + 14.0 * (0.97 + 0.03 * ed.nextDouble());
      lf[var0] = 0.0F;
      lg[var0] = 0.0F;
      lh[var0] = 0.0F;
      li[var0] = 1.0F;
      lj[var0] = Float.NaN;
      lk[var0] = 0.0F;
      ll[var0] = 1.0F;
      lm[var0] = 0.0F;
      if (!var7 && qi > 0 && ed.nextFloat() < 0.45F) {
         int var9 = ed.nextInt(qi);
         double var10 = qe[var9] + ed.nextDouble();
         double var12 = qf[var9] + ed.nextDouble();
         double var14 = qh[var9] + (qg[var9] - qh[var9]) * ed.nextDouble();
         if (var10 - var1 > -20.0 && var10 - var1 < 20.0 && var12 - var5 > -20.0 && var12 - var5 < 20.0 && var14 - var3 < 12.6 && var14 - var3 > -12.6) {
            kr[var0] = var10;
            kt[var0] = var12;
            ks[var0] = var14;
            ll[var0] = 0.001F;
         }
      }

      if (var8) {
         float var17 = ed.nextFloat();
         int var18 = var17 < 0.34F ? 0 : (var17 < 0.56F ? 1 : (var17 < 0.82F ? 2 : 3));
         ln[var0] = 8 + var18 * 2;
         kv[var0] = (var18 == 2 ? 0.078F : 0.09F) * (0.8F + 0.45F * ed.nextFloat());
         ku[var0] = 1.25F + ed.nextFloat() * 1.0F;
         kw[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         kx[var0] = 2.5F + ed.nextFloat() * 2.5F;
         ky[var0] = 0.5F + ed.nextFloat() * 1.0F;
         kz[var0] = 0.45F + ed.nextFloat() * 0.65F;
         la[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         lb[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.9F;
         lc[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 2.2F;
         if (ed.nextFloat() < 0.55F) {
            ld[var0] = (4.0F + ed.nextFloat() * 6.0F) * (ed.nextBoolean() ? 1.0F : -1.0F);
         } else {
            ld[var0] = 0.0F;
            lk[var0] = ed.nextFloat() < 0.4F ? (float) Math.PI : 0.0F;
         }

         le[var0] = 0.86F + ed.nextFloat() * 0.14F;
         lm[var0] = ed.nextFloat();
      } else {
         boolean var16 = ed.nextFloat() < 0.1F;
         ln[var0] = var16 ? 4 + ed.nextInt(4) : ed.nextInt(4);
         kv[var0] = var16 ? 0.125F + ed.nextFloat() * 0.06F : 0.06F + ed.nextFloat() * 0.038F;
         ku[var0] = 0.8F + ed.nextFloat() * 0.9F;
         kw[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         kx[var0] = 5.0F + ed.nextFloat() * 5.0F;
         ky[var0] = 0.5F + ed.nextFloat() * 0.7F;
         kz[var0] = 0.3F + ed.nextFloat() * 0.6F;
         la[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         lb[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.6F;
         lc[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 1.1F;
         if (var16) {
            ld[var0] = 2.0F + ed.nextFloat() * 2.0F;
         } else if (ed.nextFloat() < 0.45F) {
            ld[var0] = (8.0F + ed.nextFloat() * 10.0F) * (ed.nextBoolean() ? 1.0F : -1.0F);
         } else {
            ld[var0] = 0.0F;
         }

         le[var0] = 0.92F + ed.nextFloat() * 0.08F;
      }
   }

   private static void aq(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8, float var9, float var10) {
      if (qq != 0) {
         System.nanoTime();
      }

      double var11 = var2.x;
      double var13 = var2.y;
      double var15 = var2.z;
      if (!lo) {
         for (int var17 = 0; var17 < (-398645987 ^ -398641947); var17++) {
            boolean var18 = (var17 * (2019639109 ^ -430553348) >>> 8) * 5.9604645E-8F < var9;
            ap(var17, var11, var13, var15, true, var18);
            if (var18 && (var17 * (1174708971 ^ -1007720320) + (-121587697 ^ -1832296856) >>> 8) * 5.9604645E-8F >= 0.3F) {
               ll[var17] = 0.0F;
            }
         }

         lo = true;
      }

      float var182 = 4600.0F * (0.12F + 0.88F * ov);
      lp = lp + (var182 - lp) * (1.0F - (float)Math.exp(-var3 * 1.5F));
      int var183 = Math.min(463970333 ^ 463974885, (int)Math.ceil(lp));
      float var19 = lp;
      float var20 = ow;
      float var21 = ox;
      float var22 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.027);
      float var23 = var20 * (0.9F + 2.8F * var21);
      float var24 = MathHelper.cos(var22) * var23;
      float var25 = MathHelper.sin(var22) * var23;
      float var26 = oz;
      float var27 = 0.35F + 0.65F * (var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26));
      float var28 = 0.62F + 0.38F * (var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26));
      float var29 = om;
      float var30 = on;
      float var31 = var10 > 0.0F ? 0.34F : 0.12F;
      int[] var32 = ps;
      float var33 = ol;
      float var34 = (float)Math.exp(-var3 * 2.2F);
      float var35 = var3 * 8.0F;
      float var36 = var7[0];
      float var37 = var7[1];
      float var38 = var7[2];
      float var39 = var7[3];
      float var40 = var7[4];
      float var41 = var7[5];
      float var42 = var7[6];
      float var43 = var7[7];
      float var44 = var7[8];
      boolean var45 = qm && qn;
      int var46 = qj;
      int var47 = qk;
      float[] var48 = pt;
      float[] var49 = qa;
      byte[] var50 = pu;
      byte[] var51 = qb;
      int[] var52 = nh;
      int var53 = ob;
      boolean var54 = oc;
      double var55 = od;
      double var57 = oe;
      double var59 = of;
      double var61 = og;
      boolean var63 = or;
      boolean var64 = ou;
      float var65 = ot;
      float var66 = os;
      float[] var67 = nn;
      float[] var68 = no;
      int[] var69 = np;
      double var70 = 40.0;
      double var72 = 28.0;
      double var74 = 40.0;
      float var76 = 8.400001F;
      float var77 = 5.6F;

      for (int var78 = 0; var78 < var183; var78++) {
         boolean var79 = (var78 * (-521950635 ^ 2127877100) >>> 8) * 5.9604645E-8F < var9;
         boolean var80 = var79 && (var78 * (-993727909 ^ 1093607472) + (-931731272 ^ -1568731425) >>> 8) * 5.9604645E-8F >= 0.3F;
         float var81 = ll[var78];
         if (var80) {
            if (var81 <= 0.0F) {
               continue;
            }

            var81 -= var3 * 4.0F;
            if (var81 < 0.0F) {
               var81 = 0.0F;
            }
         } else if (var79 != ln[var78] >= 8) {
            var81 -= var3 * 4.0F;
            if (var81 <= 0.0F) {
               ap(var78, var11, var13, var15, true, var79);
               var81 = 0.0F;
            }
         } else if (var81 < 1.0F) {
            if (var81 <= 0.0F) {
               ap(var78, var11, var13, var15, true, var79);
            }

            var81 += var3 * 2.0F;
            if (var81 > 1.0F) {
               var81 = 1.0F;
            }
         }

         ll[var78] = var81;
         int var82 = ln[var78];
         boolean var83 = var82 >= 8;
         float var84 = kw[var78];
         float var85 = kx[var78];
         double var86 = var4 * var85 + var84;
         float var88 = MathHelper.sin(var86);
         float var89 = MathHelper.cos(var86);
         double var90 = la[var78] + var4 * lb[var78];
         float var92 = MathHelper.sin(var90);
         float var93 = MathHelper.cos(var90);
         float var94 = ky[var78] * var89;
         double var95 = kr[var78];
         double var97 = ks[var78];
         double var99 = kt[var78];
         float var101 = lf[var78] * var34;
         float var102 = lg[var78] * var34;
         float var103 = lh[var78] * var34;
         int var104 = var54 && var95 >= var55 && var95 <= var57 && var99 >= var59 && var99 <= var61 ? var53 : 0;

         for (int var105 = 0; var105 < var104; var105++) {
            float var106 = oa[var105];
            if (!(var106 <= 0.0F)) {
               float var107 = ny[var105] + 0.9F;
               float var108 = (float)(var95 - nt[var105]);
               float var109 = (float)(var99 - nv[var105]);
               if (!(var108 > var107) && !(var108 < -var107) && !(var109 > var107) && !(var109 < -var107)) {
                  float var110 = (float)(var97 - nu[var105]);
                  if (!(var110 < -0.3F) && !(var110 > nz[var105] + 0.4F)) {
                     float var111 = var108 * var108 + var109 * var109;
                     if (!(var111 >= var107 * var107)) {
                        float var112 = MathHelper.sqrt(var111) + 0.001F;
                        float var113 = (1.0F - var112 / var107) * var106 * var3;
                        var101 += (nw[var105] * 1.4F + var108 / var112 * 3.5F) * var113;
                        var103 += (nx[var105] * 1.4F + var109 / var112 * 3.5F) * var113;
                        var102 += 1.8F * var113;
                     }
                  }
               }
            }
         }

         if (var101 * var101 + var102 * var102 + var103 * var103 < 1.0E-4F) {
            var101 = 0.0F;
            var102 = 0.0F;
            var103 = 0.0F;
         }

         lf[var78] = var101;
         lg[var78] = var102;
         lh[var78] = var103;
         float var184 = var94 * var93;
         float var185 = -var94 * var92;
         float var186 = 0.5F + var89 * var89;
         if (var83 && ld[var78] != 0.0F) {
            float var187 = ky[var78] * (0.5F + 0.2F * var89) * (ld[var78] > 0.0F ? 1.0F : -1.0F);
            var184 = var187 * var92;
            var185 = var187 * var93;
            var186 = 1.15F;
         }

         float var188 = var24 + var184 + var101;
         float var189 = var25 + var185 + var103;
         float var190 = -ku[var78] * var186 + var102;
         double var191 = var95 + var188 * var3;
         double var192 = var97 + var190 * var3;
         double var115 = var99 + var189 * var3;
         float var117 = -1.0E9F;
         byte var118 = 3;
         int var119 = -1;
         if (var45) {
            int var120 = MathHelper.floor(var191);
            int var121 = MathHelper.floor(var115);
            int var122 = var120 - var46 + 24;
            int var123 = var121 - var47 + 24;
            if (var122 >= 0 && var123 >= 0 && var122 < 49 && var123 < 49) {
               int var124 = var123 * 49 + var122;
               var119 = var124;
               var118 = var50[var124];
               if (var118 == 4) {
                  int var125 = var124 << 6 | ((int)((var191 - var120) * 8.0) & 7) << 3 | (int)((var115 - var121) * 8.0) & 7;
                  var117 = var49[var125];
                  var118 = var51[var125];
               } else {
                  var117 = var48[var124];
               }
            }

            if (var117 > var192 + 0.05F) {
               int var202 = MathHelper.floor(var95);
               int var204 = MathHelper.floor(var99);
               int var126 = var202 - var46 + 24;
               int var127 = var204 - var47 + 24;
               float var128 = -1.0E9F;
               byte var129 = 3;
               if (var126 >= 0 && var127 >= 0 && var126 < 49 && var127 < 49) {
                  int var130 = var127 * 49 + var126;
                  var129 = var50[var130];
                  if (var129 == 4) {
                     int var131 = var130 << 6 | ((int)((var95 - var202) * 8.0) & 7) << 3 | (int)((var99 - var204) * 8.0) & 7;
                     var128 = var49[var131];
                     var129 = var51[var131];
                  } else {
                     var128 = var48[var130];
                  }
               }

               if (var128 <= var97 + 0.02F) {
                  var191 = var95;
                  var115 = var99;
                  var117 = var128;
                  var118 = var129;
                  lf[var78] = 0.0F;
                  lh[var78] = 0.0F;
               }
            }
         }

         float var193 = var117;
         if (var118 == 0) {
            int var194 = (MathHelper.floor(var191 * 2.0) & 127) << 7 | MathHelper.floor(var115 * 2.0) & 127;
            int var196 = var52[var194];
            var193 = var117 + 0.014F + (var196 > 36 ? 36 : var196) * 0.0042F;
         } else if (var118 == 1) {
            var193 = var117 + 0.02F;
         }

         float var195 = 1.0F;
         if (var8 && var118 <= 1) {
            float var197 = (float)(var192 - var193);
            float var200 = var83 ? 0.45F : 0.35F;
            if (var197 < var200) {
               var195 = var197 <= 0.0F ? 0.0F : var197 / var200;
            }
         }

         float var198 = li[var78];
         var198 = var195 > var198 + var35 ? var198 + var35 : (var195 < var198 - var35 ? var198 - var35 : var195);
         li[var78] = var198;
         boolean var201 = var8 && var118 <= 2 && var192 <= var193 + 0.006F && var97 > var117 - 0.4F;
         if (var201 && var118 <= 1) {
            if (var198 > 0.02F) {
               var192 = var193 + 0.006F;
               var201 = false;
            } else {
               var192 = var193;
            }
         }

         int var203 = var82 == 7 && var198 < 1.0F ? 4 + var78 % 3 : var82;
         float var205 = 0.0F;
         float var206 = 0.0F;
         float var207 = 0.0F;
         if (var82 < 4 || var82 >= 8) {
            var206 = kz[var78] * var88 * var198;
            float var208 = ld[var78];
            if (var208 != 0.0F) {
               double var210 = var4 * var208 + var84 + lk[var78];
               float var215 = (float)(var210 - (float) (Math.PI * 2) * Math.floor(var210 / (float) (Math.PI * 2) + 0.5));
               float var132 = lj[var78];
               if (var198 < 1.0F) {
                  if (var132 != var132) {
                     var132 = var215;
                     lj[var78] = var132;
                  }

                  if (var83 && (var132 > (float) (Math.PI / 2) || var132 < (float) (-Math.PI / 2))) {
                     var205 = var132 > 0.0F ? (float) Math.PI : (float) -Math.PI;
                  }

                  var207 = var205 + (var132 - var205) * var198;
               } else {
                  if (var132 == var132) {
                     lk[var78] = lk[var78] + (var132 - var215);
                     lj[var78] = Float.NaN;
                     var215 = var132;
                  }

                  var207 = var215;
               }
            } else {
               var205 = lk[var78];
               var207 = var205 + 0.3F * MathHelper.sin(var4 * var85 * 1.7 + var84 * 2.0) * var198;
            }
         }

         boolean var209 = false;
         float var211 = 1.0F;
         if (var118 <= 2) {
            if (var8) {
               if (var118 == 2) {
                  float var212 = (float)(var192 - var117) / 0.4F;
                  if (var212 <= 0.0F) {
                     var209 = true;
                  } else if (var212 < 1.0F) {
                     var211 = var212 * var212 * (3.0F - 2.0F * var212);
                  }
               } else {
                  var209 = var192 < var117 - 0.4F;
               }
            } else {
               float var213 = (float)(var192 - var117) / 1.2F;
               if (var213 < 0.0F) {
                  var209 = true;
               } else if (var213 < 1.0F) {
                  var211 = var213 * var213 * (3.0F - 2.0F * var213);
               }
            }
         }

         double var214 = var191 - var11;
         double var216 = var192 - var13;
         double var134 = var115 - var15;
         if (!var201) {
            if (var214 < -20.0 || var214 >= 20.0) {
               var214 -= Math.floor((var214 + 20.0) / var70) * var70;
               var191 = var11 + var214;
            }

            if (var134 < -20.0 || var134 >= 20.0) {
               var134 -= Math.floor((var134 + 20.0) / var74) * var74;
               var115 = var15 + var134;
            }

            if (var216 < -14.0 || var216 >= 14.0) {
               var216 -= Math.floor((var216 + 14.0) / var72) * var72;
               var192 = var13 + var216;
               li[var78] = 1.0F;
               lj[var78] = Float.NaN;
            }
         }

         kr[var78] = var191;
         ks[var78] = var192;
         kt[var78] = var115;
         float var136 = (float)var214;
         float var137 = (float)var216;
         float var138 = (float)var134;
         float var139 = var136 * var136 + var138 * var138;
         float var140 = var139 + var137 * var137;
         float var141 = MathHelper.sqrt(var140);
         float var142 = (var141 - 0.25F) / 1.2F;
         var142 = var142 < 0.0F ? 0.0F : (var142 > 1.0F ? 1.0F : var142);
         float var143 = var137 < 0.0F ? -var137 : var137;
         float var144 = (var143 - var76) / var77;
         var144 = var144 < 0.0F ? 0.0F : (var144 > 1.0F ? 1.0F : var144);
         float var145 = (var19 - var78) / 64.0F;
         var145 = var145 < 0.0F ? 0.0F : (var145 > 1.0F ? 1.0F : var145);
         float var146 = var142 * var142 * (3.0F - 2.0F * var142) * (1.0F - var144 * var144 * (3.0F - 2.0F * var144)) * var145;
         float var147 = var136 * var42 + var137 * var43 + var138 * var44;
         boolean var148 = !var209 && !(var140 < 0.06F) && !(var139 >= 400.0F) && !(var147 < -0.3F * var141);
         if (var148 && var63) {
            float var149 = 0.55F + var147 * var65;
            var148 = !(var149 < 0.0F) && !((var140 - var147 * var147) * var66 > var149 * var149);
         }

         float var220 = 0.0F;
         if (var148) {
            float var150 = (MathHelper.sqrt(var139) - 13.0F) / 7.0F;
            var150 = var150 < 0.0F ? 0.0F : (var150 > 1.0F ? 1.0F : var150);
            var220 = var6 * var211 * var146 * var81 * (1.0F - var150 * var150 * (3.0F - 2.0F * var150));
            var148 = !(var220 < 0.012F);
         }

         float var222 = 0.0F;
         float var151 = 0.0F;
         float var152 = 0.0F;
         float var153 = 0.0F;
         float var154 = 0.0F;
         float var155 = 0.0F;
         float var156 = 0.0F;
         if (var148 || var201) {
            double var157 = var84 + var4 * lc[var78];
            float var159 = MathHelper.cos(var157);
            float var160 = MathHelper.sin(var157);
            if (var82 >= 4 && var82 < 8) {
               float var227 = 0.62F + 0.38F * Math.abs(MathHelper.cos(var4 * ld[var78] + var84));
               var227 = 1.0F + (var227 - 1.0F) * var198;
               float var230 = (var36 * var159 + var39 * var160) * var227;
               float var232 = (var37 * var159 + var40 * var160) * var227;
               float var234 = (var38 * var159 + var41 * var160) * var227;
               float var236 = -var36 * var160 + var39 * var159;
               float var238 = -var37 * var160 + var40 * var159;
               float var240 = -var38 * var160 + var41 * var159;
               if (var198 < 1.0F) {
                  float var243 = -var36 * var160 + var38 * var159;
                  float var247 = -var38 * var160 - var36 * var159;
                  float var250 = 1.0F - var198;
                  var222 = -var247 * var250 + var230 * var198;
                  var151 = var232 * var198;
                  var152 = var243 * var250 + var234 * var198;
                  var153 = var243 * var250 + var236 * var198;
                  var154 = var238 * var198;
                  var155 = var247 * var250 + var240 * var198;
               } else {
                  var222 = var230;
                  var151 = var232;
                  var152 = var234;
                  var153 = var236;
                  var154 = var238;
                  var155 = var240;
               }

               var156 = 1.0F;
            } else {
               float var161 = MathHelper.cos(var206);
               float var162 = MathHelper.sin(var206);
               float var163 = MathHelper.cos(var207);
               float var164 = MathHelper.sin(var207);
               float var165 = var161 * var93;
               float var166 = var162;
               float var167 = -var161 * var92;
               float var168 = var164 * var162 * var93 + var163 * var92;
               float var169 = -var164 * var161;
               float var170 = -var164 * var162 * var92 + var163 * var93;
               var153 = var165 * var159 + var168 * var160;
               var154 = var166 * var159 + var169 * var160;
               var155 = var167 * var159 + var170 * var160;
               var222 = -var165 * var160 + var168 * var159;
               var151 = -var166 * var160 + var169 * var159;
               var152 = -var167 * var160 + var170 * var159;
               var156 = var163 * var161;
               if (var156 < 0.0F) {
                  var156 = -var156;
               }
            }
         }

         if (var148) {
            if (var220 > 1.0F) {
               var220 = 1.0F;
            }

            float var223 = kv[var78] * (1.0F + var141 * 0.01F);
            float var158 = var222 * var223;
            float var225 = var151 * var223;
            float var226 = var152 * var223;
            float var229 = var153 * var223;
            float var231 = var154 * var223;
            float var233 = var155 * var223;
            float var235 = 1.0F - var198;
            float var237 = (var136 * var29 + var137 * var30) / (var141 + 1.0E-4F);
            float var239 = 1.0F;
            if (var119 >= 0) {
               float var241 = var32[var119];
               float var244 = var48[var119];
               if (var241 - var244 > 2.0F && var192 < var241 - 0.3) {
                  float var248 = (float)(var241 - 0.3 - var192) * 0.8333333F;
                  var239 = 1.0F - 0.3F * (var248 > 1.0F ? 1.0F : var248);
               }
            }

            float var242 = 1.0F;
            if (var82 < 4 || var83) {
               float var245 = (var151 * var155 - var152 * var154) * var29 + (var152 * var153 - var222 * var155) * var30;
               var242 = 0.84F + var31 * var245 * var245;
            }

            int var171 = var203;
            int var246;
            int var249;
            int var251;
            if (var83) {
               float var172 = lm[var78];
               float var173 = 1.0F - 0.26F * var172;
               float var174 = 1.0F - 0.36F * var172;
               float var175 = var28 * le[var78] * 0.8F;
               float var176 = var28 * le[var78] * (0.84F + 0.08F * var156);
               if (var237 > 0.55F) {
                  float var177 = (var237 - 0.55F) / 0.45F;
                  var177 = var177 * var177 * var10;
                  var176 += var177 * 0.3F;
                  var173 += var177 * 0.06F;
               }

               float var266 = (var176 * var242 * var198 + var175 * var235) * var239;
               float var178 = var173 * var198 + (1.0F - 0.26F * var172) * var235;
               var266 = var266 > 1.0F ? 1.0F : var266;
               var178 = var178 > 1.0F ? 1.0F : var178;
               var246 = (int)(255.0F * var266);
               var249 = (int)(255.0F * var266 * var178);
               var251 = (int)(255.0F * var266 * var174);
               float var179 = var151 * var155 - var152 * var154;
               float var180 = var152 * var153 - var222 * var155;
               float var181 = var222 * var154 - var151 * var153;
               var171 = var82 + (var179 * var136 + var180 * var137 + var181 * var138 > 0.0F ? 1 : 0);
            } else {
               float var252 = var27 * le[var78] * (0.92F + 0.08F * var156);
               float var255 = (float)((var13 - var192) / 12.0);
               var255 = var255 < 0.0F ? 0.0F : (var255 > 1.0F ? 1.0F : var255) * 0.5F;
               if (var237 > 0.6F) {
                  float var258 = (var237 - 0.6F) / 0.4F;
                  var258 = var258 * var258 * var10 * var198;
                  var252 += var258 * 0.3F;
                  var255 += var258 * 0.6F;
               }

               var252 *= var239 * (var242 * var198 + var235);
               if (var252 > 1.0F) {
                  var252 = 1.0F;
               }

               if (var255 > 1.0F) {
                  var255 = 1.0F;
               }

               var246 = (int)(255.0F * var252);
               var249 = (int)(((255.0F - 12.0F * var255) * var198 + 249.0F * var235) * var252);
               var251 = (int)(((255.0F - 22.0F * var255) * var198 + 245.0F * var235) * var252);
            }

            int var254 = (int)(var220 * 255.0F);
            float var257 = var223 * 2.0F * var33 / var141;
            if (var235 > 0.0F) {
               float var260 = (var137 < 0.0F ? -var137 : var137) / var141;
               var260 = var260 < 0.15F ? 0.3873F : MathHelper.sqrt(var260);
               var257 *= var198 + var235 * var260;
            }

            int var262 = (var257 >= 64.0F ? 0 : (var257 >= 32.0F ? 16 : (var257 >= 16.0F ? 32 : 48))) + var171;
            float var263 = du[var262];
            float var264 = dv[var262];
            float var268 = dw[var262];
            float var270 = dx[var262];
            if (var141 < 4.0F && nr < (-105930772 ^ -105931156)) {
               int var271 = nr * 13;
               var67[var271] = var136;
               var67[var271 + 1] = var137;
               var67[var271 + 2] = var138;
               var67[var271 + 3] = var158;
               var67[var271 + 4] = var225;
               var67[var271 + 5] = var226;
               var67[var271 + 6] = var229;
               var67[var271 + 7] = var231;
               var67[var271 + 8] = var233;
               var67[var271 + 9] = var263;
               var67[var271 + 10] = var264;
               var67[var271 + 11] = var268;
               var67[var271 + 12] = var270;
               var68[nr] = var141;
               var69[nr] = var246 << 24 | var249 << 16 | var251 << 8 | var254;
               nr++;
            } else if (var64) {
               var0.vertex(var136 - var158 - var229, var137 - var225 - var231, var138 - var226 - var233)
                  .texture(var263, var270)
                  .color(var246, var249, var251, var254);
               var0.vertex(var136 - var158 + var229, var137 - var225 + var231, var138 - var226 + var233)
                  .texture(var263, var264)
                  .color(var246, var249, var251, var254);
               var0.vertex(var136 + var158 + var229, var137 + var225 + var231, var138 + var226 + var233)
                  .texture(var268, var264)
                  .color(var246, var249, var251, var254);
               var0.vertex(var136 + var158 - var229, var137 + var225 - var231, var138 + var226 - var233)
                  .texture(var268, var270)
                  .color(var246, var249, var251, var254);
            } else {
               var0.vertex(var1, var136 - var158 - var229, var137 - var225 - var231, var138 - var226 - var233)
                  .texture(var263, var270)
                  .color(var246, var249, var251, var254);
               var0.vertex(var1, var136 - var158 + var229, var137 - var225 + var231, var138 - var226 + var233)
                  .texture(var263, var264)
                  .color(var246, var249, var251, var254);
               var0.vertex(var1, var136 + var158 + var229, var137 + var225 + var231, var138 + var226 + var233)
                  .texture(var268, var264)
                  .color(var246, var249, var251, var254);
               var0.vertex(var1, var136 + var158 - var229, var137 + var225 - var231, var138 + var226 - var233)
                  .texture(var268, var270)
                  .color(var246, var249, var251, var254);
            }
         }

         if (var201) {
            if (var118 <= 1 && var81 > 0.0F) {
               boolean var224 = var83 && (var205 > (float) (Math.PI / 2) || var205 < (float) (-Math.PI / 2));
               ar(var191, var117, var115, var203, kv[var78], le[var78], lm[var78], (float)Math.atan2(-var155, var153), var224, var118, var146 * var81);
            }

            ap(var78, var11, var13, var15, false, var79);
            if (var80) {
               ll[var78] = 0.0F;
            }
         }
      }
   }

   private static void ar(
      double var0, double var2, double var4, int var6, float var7, float var8, float var9, float var10, boolean var11, int var12, float var13
   ) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var14 = mu;
      mu = var14 + 1 >= (-1755602942 ^ -1755596942) ? 0 : var14 + 1;
      if (mt[var14] == 1) {
         int var15 = mr[var14];
         if (var15 >= 0 && nh[var15] > 0) {
            nh[var15]--;
         }
      }

      lw[var14] = var0;
      ly[var14] = var4;
      mq[var14] = var6 == 7 ? 4 : var6;
      mf[var14] = var7;
      mp[var14] = var8;
      mo[var14] = var9;
      mc[var14] = var10;
      mj[var14] = 0.0F;
      mk[var14] = 0.0F;
      ml[var14] = var6 >= 8 ? 0.22F + ed.nextFloat() * 0.85F : 0.3F + ed.nextFloat() * 0.95F;
      mm[var14] = ed.nextFloat();
      mn[var14] = var13 < 0.0F ? 0.0F : (var13 > 1.0F ? 1.0F : var13);
      mr[var14] = -1;
      na = true;
      as(var14, var2, var12);
      if (var11) {
         mi[var14] = (float) Math.PI;
      }
   }

   private static void as(int var0, double var1, int var3) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      lz[var0] = 0.0F;
      ma[var0] = 0.0F;
      mb[var0] = 0.0F;
      mh[var0] = 0.0F;
      mi[var0] = 0.0F;
      float var4 = 1.0F;
      if (qm && qn) {
         int var5 = MathHelper.floor(lw[var0]) - qj + 24;
         int var6 = MathHelper.floor(ly[var0]) - qk + 24;
         if (var5 >= 0 && var6 >= 0 && var5 < 49 && var6 < 49) {
            int var7 = var6 * 49 + var5;
            float var8 = ps[var7];
            if (var8 - pt[var7] > 2.0F && var1 < var8 - 0.3) {
               float var9 = (float)(var8 - 0.3 - var1) * 0.8333333F;
               var4 = 1.0F - 0.3F * (var9 > 1.0F ? 1.0F : var9);
            }
         }
      }

      mg[var0] = mp[var0] * var4;
      if (var3 == 1) {
         mt[var0] = 3;
         mr[var0] = -1;
         ms[var0] = 0;
         md[var0] = 0.0F;
         me[var0] = 0.0F;
         lx[var0] = var1 + 0.02F;
      } else {
         int var10 = (MathHelper.floor(lw[var0] * 2.0) & 127) << 7 | MathHelper.floor(ly[var0] * 2.0) & 127;
         int var11 = nh[var10]++;
         if (var11 > 36) {
            var11 = 36;
         }

         mr[var0] = var10;
         ms[var0] = var11;
         float var12 = mq[var0] >= 8 ? (var11 > 2 ? 0.16F : 0.05F) : (var11 > 2 ? 0.28F : 0.07F);
         md[var0] = (ed.nextFloat() * 2.0F - 1.0F) * var12;
         me[var0] = (ed.nextFloat() * 2.0F - 1.0F) * var12;
         lx[var0] = var1 + 0.014F + var11 * 0.0042F;
         mt[var0] = 1;
      }
   }

   private static void at(Vec3d var0, float var1, float var2, float var3) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      if (qm && qn) {
         float var4 = 0.3F + 0.7F * ov;
         float var5 = nf / 30.0F;
         float var6 = ng / 24.0F;
         var5 = var5 > 1.0F ? 1.0F : var5;
         var6 = var6 > 1.0F ? 1.0F : var6;
         float var7 = var2 + var3;
         float var8 = var7 > 1.0E-4F ? var3 / var7 : 0.0F;
         int var9 = (int)(3000.0F * var4 * var5 * (1.0F - var8)) - mv;
         int var10 = (int)(3720.0F * var4 * var6 * var8) - mw;
         if (var9 <= 0 && var10 <= 0) {
            ne = 0.0F;
         } else {
            ne += var1 * 800.0F;
            int var11 = (int)ne;
            if (var11 > 48) {
               var11 = 48;
            }

            ne -= var11;
            float var12 = MathHelper.sqrt(pl * pl + pn * pn);
            float var13 = (float)Math.atan2(pn, pl);
            int var14 = 0;

            while (var14 < var11) {
               float var15 = var12 > 2.0F && ed.nextFloat() < 0.7F ? var13 + (ed.nextFloat() * 2.0F - 1.0F) * 1.3F : ed.nextFloat() * (float) (Math.PI * 2);
               double var16 = 12.0 + 8.0 * Math.sqrt(ed.nextDouble());
               double var18 = var0.x + MathHelper.cos(var15) * var16;
               double var20 = var0.z + MathHelper.sin(var15) * var16;
               boolean var22 = var10 > 0 && (var9 <= 0 || ed.nextFloat() * (var9 + var10) < var10);
               if (var22) {
                  float var39 = u(var18, var20);
                  int var40 = v(var18, var20);
                  if ((var40 == (1573145225 ^ -574338423) || !(var40 > var39 + 1.5F)) && ed.nextFloat() > 0.45F) {
                     var14++;
                  } else {
                     int var41 = 1 + ed.nextInt(4);

                     for (int var42 = 0; var42 < var41 && var14 < var11; var14++) {
                        double var43 = var18 + (ed.nextDouble() * 2.0 - 1.0) * 0.8;
                        double var29 = var20 + (ed.nextDouble() * 2.0 - 1.0) * 0.8;
                        float var31 = u(var43, var29);
                        int var44 = qo;
                        if (var44 < 2 && !(var31 > var0.y + 12.0) && !(var31 < var0.y - 24.0)) {
                           float var45 = ed.nextFloat();
                           int var46 = var45 < 0.34F ? 0 : (var45 < 0.56F ? 1 : (var45 < 0.82F ? 2 : 3));
                           float var47 = (var46 == 2 ? 0.078F : 0.09F) * (0.8F + 0.45F * ed.nextFloat());
                           ar(
                              var43,
                              var31,
                              var29,
                              8 + var46 * 2,
                              var47,
                              0.78F + ed.nextFloat() * 0.18F,
                              ed.nextFloat(),
                              ed.nextFloat() * (float) (Math.PI * 2),
                              ed.nextFloat() < 0.42F,
                              var44,
                              0.0F
                           );
                           var10--;
                        }

                        var42++;
                     }
                  }
               } else {
                  float var23 = u(var18, var20);
                  int var24 = v(var18, var20);
                  boolean var25 = var24 != (-253744426 ^ 1893739222) && var24 > var23 + 2.0F;
                  if (!var25 && ed.nextFloat() > 0.55F) {
                     var14++;
                  } else {
                     int var26 = var25 ? 2 + ed.nextInt(5) : 1 + ed.nextInt(2);

                     for (int var27 = 0; var27 < var26 && var14 < var11; var14++) {
                        double var28 = var18 + (ed.nextDouble() * 2.0 - 1.0) * 0.7;
                        double var30 = var20 + (ed.nextDouble() * 2.0 - 1.0) * 0.7;
                        float var32 = u(var28, var30);
                        int var33 = qo;
                        if (var33 < 2 && !(var32 > var0.y + 12.0) && !(var32 < var0.y - 24.0)) {
                           boolean var34 = ed.nextFloat() < 0.1F;
                           int var35 = var34 ? 4 + ed.nextInt(3) : ed.nextInt(4);
                           float var36 = var34 ? 0.125F + ed.nextFloat() * 0.06F : 0.06F + ed.nextFloat() * 0.038F;
                           ar(
                              var28,
                              var32,
                              var30,
                              var35,
                              var36,
                              0.84F + ed.nextFloat() * 0.14F,
                              0.0F,
                              ed.nextFloat() * (float) (Math.PI * 2),
                              false,
                              var33,
                              0.0F
                           );
                           var9--;
                        }

                        var27++;
                     }
                  }
               }
            }
         }
      }
   }

   private static void au(VertexConsumer var0, Entry var1, Vec3d var2, float var3, double var4, float[] var6, float var7, float var8, float[] var9) {
      if (qq != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      double var10 = var2.x;
      double var12 = var2.y;
      double var14 = var2.z;
      float var16 = oz;
      float var17 = 0.35F + 0.65F * (var16 < 0.0F ? 0.0F : (var16 > 1.0F ? 1.0F : var16));
      float var18 = 0.62F + 0.38F * (var16 < 0.0F ? 0.0F : (var16 > 1.0F ? 1.0F : var16));
      float var19 = ow;
      float var20 = ox;
      float var21 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.027);
      float var22 = MathHelper.cos(var21);
      float var23 = MathHelper.sin(var21);
      float var24 = var19 * (0.9F + 2.8F * var20);
      float var25 = var22 * var24;
      float var26 = var23 * var24;
      float var27 = var19 * (0.35F + 0.65F * var20);
      float var28 = (float)Math.exp(-var3 * 2.4F);
      float var29 = (float)Math.exp(-var3 * 2.0F);
      float var30 = (float)Math.exp(-var3 * 3.0F);
      float var31 = 1.0F - (float)Math.exp(-var3 * 7.0F);
      boolean var32 = nc < 0.004F && var6[2] <= 0.02F;
      boolean var33 = nd < 0.004F && var6[5] <= 0.02F;
      int var34 = 0;
      float var35 = ol;
      float var36 = var9[6];
      float var37 = var9[7];
      float var38 = var9[8];
      boolean var39 = qm && qn;
      int var40 = qj;
      int var41 = qk;
      float[] var42 = pt;
      float[] var43 = qa;
      float[] var44 = pv;
      float[] var45 = pw;
      byte[] var46 = pu;
      byte[] var47 = qb;
      int[] var48 = nh;
      int var49 = ob;
      boolean var50 = oc;
      double var51 = od;
      double var53 = oe;
      double var55 = of;
      double var57 = og;
      boolean var59 = or;
      boolean var60 = ou;
      float var61 = ot;
      float var62 = os;
      int var63 = mu;
      float[] var64 = nn;
      float[] var65 = no;
      int[] var66 = np;
      double var67 = Math.floor(var10 / 512.0) * 512.0;
      double var69 = Math.floor(var14 / 512.0) * 512.0;
      int var71 = 0;

      for (int var72 = 0; var72 < (1801354544 ^ 1801349696); var72++) {
         byte var73 = mt[var72];
         if (var73 != 0) {
            double var74 = lw[var72];
            double var76 = lx[var72];
            double var78 = ly[var72];
            double var80 = var74 - var10;
            double var82 = var78 - var14;
            boolean var84 = mq[var72] >= 8;
            if (!(var80 * var80 + var82 * var82 > 676.0) && !(var76 < var12 - 40.0) && (var84 ? !var33 : !var32)) {
               int var126 = -1;
               float var86 = -1.0E9F;
               byte var87 = 3;
               if (var39) {
                  int var88 = MathHelper.floor(var74);
                  int var89 = MathHelper.floor(var78);
                  int var90 = var88 - var40 + 24;
                  int var91 = var89 - var41 + 24;
                  if (var90 >= 0 && var91 >= 0 && var90 < 49 && var91 < 49) {
                     var126 = var91 * 49 + var90;
                     var87 = var46[var126];
                     if (var87 == 4) {
                        int var92 = var126 << 6 | ((int)((var74 - var88) * 8.0) & 7) << 3 | (int)((var78 - var89) * 8.0) & 7;
                        var86 = var43[var92];
                        var87 = var47[var92];
                     } else {
                        var86 = var42[var126];
                     }
                  }
               }

               float var127 = mm[var72];
               float var128 = 1.0F;
               if (var73 == 2) {
                  float var129 = lz[var72];
                  float var137 = ma[var72];
                  float var143 = mb[var72];
                  float var93 = var84 ? var29 : var28;
                  float var94 = var84 ? 0.8F : 1.1F;
                  var137 = (var137 - (var84 ? 5.2F : 4.2F) * var3) * var30;
                  var129 = var25 + (var129 - var25) * var93 + MathHelper.sin(var4 * 5.3 + var127 * 31.0F) * var94 * var3;
                  var143 = var26 + (var143 - var26) * var93 + MathHelper.cos(var4 * 4.7 + var127 * 17.0F) * var94 * var3;
                  int var95 = var50 && var74 >= var51 && var74 <= var53 && var78 >= var55 && var78 <= var57 ? var49 : 0;

                  for (int var96 = 0; var96 < var95; var96++) {
                     float var97 = oa[var96];
                     if (!(var97 <= 0.0F)) {
                        float var98 = ny[var96] + 0.5F;
                        float var99 = (float)(var74 - nt[var96]);
                        float var100 = (float)(var78 - nv[var96]);
                        if (!(var99 > var98) && !(var99 < -var98) && !(var100 > var98) && !(var100 < -var98)) {
                           float var101 = (float)(var76 - nu[var96]);
                           if (!(var101 < -0.5F) && !(var101 > nz[var96])) {
                              float var102 = var99 * var99 + var100 * var100;
                              if (!(var102 >= var98 * var98)) {
                                 float var103 = MathHelper.sqrt(var102) + 0.001F;
                                 float var104 = (1.0F - var103 / var98) * var97 * var3;
                                 var129 += (nw[var96] * 1.6F + var99 / var103 * 4.5F) * var104;
                                 var143 += (nx[var96] * 1.6F + var100 / var103 * 4.5F) * var104;
                                 var137 += 2.0F * var104;
                              }
                           }
                        }
                     }
                  }

                  double var159 = var74 + var129 * var3;
                  double var168 = var76 + var137 * var3;
                  double var180 = var78 + var143 * var3;
                  float var190 = -1.0E9F;
                  byte var196 = 3;
                  if (var39) {
                     int var202 = MathHelper.floor(var159);
                     int var105 = MathHelper.floor(var180);
                     int var106 = var202 - var40 + 24;
                     int var107 = var105 - var41 + 24;
                     if (var106 >= 0 && var107 >= 0 && var106 < 49 && var107 < 49) {
                        int var108 = var107 * 49 + var106;
                        var196 = var46[var108];
                        if (var196 == 4) {
                           int var109 = var108 << 6 | ((int)((var159 - var202) * 8.0) & 7) << 3 | (int)((var180 - var105) * 8.0) & 7;
                           var190 = var43[var109];
                           var196 = var47[var109];
                        } else {
                           var190 = var42[var108];
                        }
                     }
                  }

                  if (var190 > var86 + 0.05F && var190 > var168 + 0.05F) {
                     var159 = var74;
                     var180 = var78;
                     var129 *= -0.3F;
                     var143 *= -0.3F;
                     var190 = var86;
                     var196 = var87;
                  }

                  float var203 = var190;
                  if (var196 == 0) {
                     int var207 = (MathHelper.floor(var159 * 2.0) & 127) << 7 | MathHelper.floor(var180 * 2.0) & 127;
                     int var212 = var48[var207];
                     var203 = var190 + 0.014F + (var212 > 36 ? 36 : var212) * 0.0042F;
                  } else if (var196 == 1) {
                     var203 = var190 + 0.02F;
                  }

                  float var217 = var84 ? 0.5F : 0.4F;
                  float var208;
                  float var213;
                  if (var168 - var203 < var217 && var137 < 0.0F) {
                     var208 = mh[var72];
                     var213 = mi[var72];
                     mj[var72] = 0.0F;
                     mk[var72] = 0.0F;
                     float var220;
                     float var224;
                     if (var84) {
                        var220 = Math.round(var208 * 0.31830987F) * (float) Math.PI;
                        var224 = Math.round(var213 * 0.31830987F) * (float) Math.PI;
                     } else {
                        var220 = Math.round(var208 * 0.15915494F) * (float) (Math.PI * 2);
                        var224 = Math.round(var213 * 0.15915494F) * (float) (Math.PI * 2);
                     }

                     float var110 = (float)((var168 - var203) / Math.max(var76 - var203, 0.001));
                     var110 = var110 < 0.0F ? 0.0F : (var110 > 1.0F ? 1.0F : var110);
                     var208 = var220 + (var208 - var220) * var110;
                     var213 = var224 + (var213 - var224) * var110;
                  } else {
                     var208 = mh[var72] + mj[var72] * var3;
                     var213 = mi[var72] + mk[var72] * var3;
                  }

                  mh[var72] = var208;
                  mi[var72] = var213;
                  if (var196 <= 2 && var168 <= var203 && var137 <= 0.0F) {
                     if (var196 == 2) {
                        mt[var72] = 0;
                        continue;
                     }

                     lw[var72] = var159;
                     ly[var72] = var180;
                     int var221 = Math.round(var208 * 0.31830987F);
                     int var225 = Math.round(var213 * 0.31830987F);
                     as(var72, var190, var196);
                     if (var84) {
                        if ((var221 & 1) != 0) {
                           mc[var72] = mc[var72] + (float) Math.PI;
                        }

                        mi[var72] = (var221 + var225 & 1) != 0 ? (float) Math.PI : 0.0F;
                     }

                     var74 = var159;
                     var76 = lx[var72];
                     var78 = var180;
                     var73 = mt[var72];
                     var128 = ((float)(var76 - var190) - 0.003F) / (mf[var72] * 1.42F);
                  } else {
                     lw[var72] = var159;
                     lx[var72] = var168;
                     ly[var72] = var180;
                     lz[var72] = var129;
                     ma[var72] = var137;
                     mb[var72] = var143;
                     var74 = var159;
                     var76 = var168;
                     var78 = var180;
                  }
               } else {
                  if (var126 >= 0) {
                     if (var86 > var76 + 0.06F) {
                        if (var73 == 1) {
                           int var136 = mr[var72];
                           if (var136 >= 0 && var48[var136] > 0) {
                              var48[var136]--;
                           }
                        }

                        mt[var72] = 0;
                        continue;
                     }

                     if (var86 < var76 - 0.45F) {
                        if (var73 == 1) {
                           int var131 = mr[var72];
                           if (var131 >= 0 && var48[var131] > 0) {
                              var48[var131]--;
                           }
                        }

                        mt[var72] = 2;
                        lz[var72] = 0.0F;
                        ma[var72] = 0.0F;
                        mb[var72] = 0.0F;
                        var73 = 2;
                     }
                  }

                  if (var73 == 1) {
                     int var133 = mr[var72];
                     int var140 = var133 >= 0 ? var48[var133] : 1;
                     int var146 = ms[var72];
                     if (var146 > var140 - 1) {
                        var146 = var140 - 1;
                     }

                     if (var146 < 0) {
                        var146 = 0;
                     }

                     if (var126 >= 0) {
                        var76 += (var86 + 0.014F + var146 * 0.0042F - var76) * var31;
                        var128 = ((float)(var76 - var86) - 0.003F) / (mf[var72] * 1.42F);
                     } else {
                        var128 = 0.03F;
                     }

                     float var149 = ml[var72];
                     if (var27 > 0.02F && var126 >= 0 && var149 < var27) {
                        float var153 = (float)(var74 - var67);
                        float var156 = (float)(var78 - var69);
                        float var161 = var27
                           * (0.55F + 0.45F * MathHelper.sin(var153 * 0.23F + var4 * 1.7 + 1.3F * MathHelper.sin(var156 * 0.19F - var4 * 0.8)));
                        float var165 = var161 - var149;
                        if (var165 > 0.0F) {
                           float var170 = var165 * (var84 ? 3.1F : 2.6F);
                           double var176 = var74 + var22 * var170 * var3;
                           double var186 = var78 + var23 * var170 * var3;
                           float var198 = -1.0E9F;
                           byte var204 = 3;
                           int var210 = MathHelper.floor(var176);
                           int var215 = MathHelper.floor(var186);
                           int var218 = var210 - var40 + 24;
                           int var222 = var215 - var41 + 24;
                           if (var218 >= 0 && var222 >= 0 && var218 < 49 && var222 < 49) {
                              int var226 = var222 * 49 + var218;
                              var204 = var46[var226];
                              if (var204 == 4) {
                                 int var230 = var226 << 6 | ((int)((var176 - var210) * 8.0) & 7) << 3 | (int)((var186 - var215) * 8.0) & 7;
                                 var198 = var43[var230];
                                 var204 = var47[var230];
                              } else {
                                 var198 = var42[var226];
                              }
                           }

                           if (var204 < 2 && !(var198 > var76 + 0.05F)) {
                              if (!(var198 < var86 - 0.3F) && var204 != 1) {
                                 int var227 = (MathHelper.floor(var176 * 2.0) & 127) << 7 | MathHelper.floor(var186 * 2.0) & 127;
                                 if (var227 != var133) {
                                    if (var133 >= 0 && var48[var133] > 0) {
                                       var48[var133]--;
                                    }

                                    int var231 = var48[var227]++;
                                    ms[var72] = (var231 > 36 ? 36 : var231);
                                    mr[var72] = var227;
                                 }

                                 var74 = var176;
                                 var78 = var186;
                                 mc[var72] = mc[var72] + (var127 - 0.5F) * var170 * var3 * (var84 ? 4.5F : 3.0F);
                                 if (var165 > (var84 ? 0.22F : 0.3F) && ed.nextFloat() < var165 * (var84 ? 1.3F : 0.8F) * var3) {
                                    if (var48[var227] > 0) {
                                       var48[var227]--;
                                    }

                                    mt[var72] = 2;
                                    var73 = 2;
                                    lz[var72] = var22 * var170 * 1.5F;
                                    mb[var72] = var23 * var170 * 1.5F;
                                    ma[var72] = var84 ? 0.6F + var165 * 1.2F : 0.8F + var165 * 1.5F;
                                    mj[var72] = (var127 - 0.5F) * (var84 ? 21.0F : 16.0F);
                                    mk[var72] = (0.5F - var127) * (var84 ? 16.0F : 10.0F);
                                 }
                              } else {
                                 if (var133 >= 0 && var48[var133] > 0) {
                                    var48[var133]--;
                                 }

                                 mt[var72] = 2;
                                 var73 = 2;
                                 lz[var72] = var22 * var170;
                                 mb[var72] = var23 * var170;
                                 ma[var72] = 0.2F;
                                 var74 = var176;
                                 var78 = var186;
                              }
                           }
                        }
                     }

                     lw[var72] = var74;
                     lx[var72] = var76;
                     ly[var72] = var78;
                  } else if (var73 == 3) {
                     if (var126 >= 0) {
                        var76 += (var86 + 0.02F - var76) * var31;
                        float var132 = var44[var126] * 0.7F + var25 * 0.12F;
                        float var139 = var45[var126] * 0.7F + var26 * 0.12F;
                        if (var132 * var132 + var139 * var139 > 1.0E-4F) {
                           double var145 = var74 + var132 * var3;
                           double var152 = var78 + var139 * var3;
                           float var160 = -1.0E9F;
                           byte var164 = 3;
                           int var169 = MathHelper.floor(var145);
                           int var175 = MathHelper.floor(var152);
                           int var181 = var169 - var40 + 24;
                           int var185 = var175 - var41 + 24;
                           if (var181 >= 0 && var185 >= 0 && var181 < 49 && var185 < 49) {
                              int var191 = var185 * 49 + var181;
                              var164 = var46[var191];
                              if (var164 == 4) {
                                 int var197 = var191 << 6 | ((int)((var145 - var169) * 8.0) & 7) << 3 | (int)((var152 - var175) * 8.0) & 7;
                                 var160 = var43[var197];
                                 var164 = var47[var197];
                              } else {
                                 var160 = var42[var191];
                              }
                           }

                           if (var164 == 1) {
                              if (var160 < var86 - 0.3F) {
                                 mt[var72] = 2;
                                 var73 = 2;
                                 lz[var72] = var132;
                                 ma[var72] = 0.0F;
                                 mb[var72] = var139;
                                 var74 = var145;
                                 var78 = var152;
                              } else if (var160 < var86 + 0.3F) {
                                 var74 = var145;
                                 var78 = var152;
                              }
                           }
                        }
                     }

                     mc[var72] = mc[var72] + (var127 - 0.5F) * 0.25F * var3;
                     lw[var72] = var74;
                     lx[var72] = var76;
                     ly[var72] = var78;
                  }

                  if (var73 != 2 && var50 && var74 >= var51 && var74 <= var53 && var78 >= var55 && var78 <= var57) {
                     for (int var134 = 0; var134 < var49; var134++) {
                        float var141 = oa[var134];
                        if (!(var141 <= 0.0F)) {
                           float var147 = ny[var134];
                           float var150 = (float)(var74 - nt[var134]);
                           float var154 = (float)(var78 - nv[var134]);
                           if (!(var150 > var147) && !(var150 < -var147) && !(var154 > var147) && !(var154 < -var147)) {
                              float var157 = (float)(var76 - nu[var134]);
                              if (!(var157 > (var73 == 3 ? 2.2F : 0.6F)) && !(var157 < -1.1F)) {
                                 float var162 = var150 * var150 + var154 * var154;
                                 if (!(var162 >= var147 * var147)) {
                                    float var166 = MathHelper.sqrt(var162) + 0.001F;
                                    float var171 = (1.0F - var166 / var147) * var141;
                                    if (var157 < -0.35F) {
                                       var171 *= 1.0F + (var157 + 0.35F) / 0.75F;
                                    }

                                    if (!(var171 <= 0.07F + var127 * 0.25F)) {
                                       if (var73 == 1) {
                                          int var177 = mr[var72];
                                          if (var177 >= 0 && var48[var177] > 0) {
                                             var48[var177]--;
                                          }

                                          if (var177 >= 0 && var126 >= 0) {
                                             int var182 = var48[var177];
                                             float var187 = var86 + 0.014F + (var182 > 36 ? 36 : var182) * 0.0042F;
                                             if (var76 < var187) {
                                                var76 = var187;
                                                lx[var72] = var187;
                                             }
                                          }
                                       }

                                       float var178 = var150 / var166;
                                       float var183 = var154 / var166;
                                       float var188 = (0.6F + 1.6F * var171) * (0.6F + 0.8F * var127) * (var84 ? 1.15F : 1.0F);
                                       float var192 = var84 ? 0.25F + 0.35F * var127 : 0.15F + 0.3F * var127;
                                       lz[var72] = nw[var134] * var192 + var178 * var188;
                                       mb[var72] = nx[var134] * var192 + var183 * var188;
                                       ma[var72] = var73 == 3
                                          ? 0.3F + 0.6F * var171
                                          : (var84 ? 0.7F + 1.8F * var171 * (0.5F + var127) : 0.9F + 2.3F * var171 * (0.5F + var127));
                                       float var199 = var127 * 7.31F;
                                       var199 -= (int)var199;
                                       float var205 = var84 ? 1.3F : 1.0F;
                                       mj[var72] = (var199 - 0.5F) * 2.0F * (6.0F + 8.0F * var171) * var205;
                                       mk[var72] = (var127 - 0.5F) * 2.0F * (4.0F + 6.0F * var171) * var205;
                                       mt[var72] = 2;
                                       var73 = 2;
                                       break;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               float var135 = mn[var72];
               if (var135 < 1.0F) {
                  var135 += var3 * 0.7F;
                  if (var135 > 1.0F) {
                     var135 = 1.0F;
                  }

                  mn[var72] = var135;
               }

               float var142 = (float)(var74 - var10);
               float var148 = (float)(var76 - var12);
               float var151 = (float)(var78 - var14);
               float var155 = var142 * var142 + var151 * var151;
               if (!(var155 >= 400.0F)) {
                  if (var84) {
                     var71++;
                  } else {
                     var34++;
                  }

                  float var158 = var155 + var148 * var148;
                  if (!(var158 < 0.02F)) {
                     float var163 = MathHelper.sqrt(var158);
                     float var167 = var142 * var36 + var148 * var37 + var151 * var38;
                     if (!(var167 < -0.3F * var163)) {
                        if (var59) {
                           float var172 = 0.6F + var167 * var61;
                           if (var172 < 0.0F || (var158 - var167 * var167) * var62 > var172 * var172) {
                              continue;
                           }
                        }

                        float var173 = (MathHelper.sqrt(var155) - 13.0F) / 7.0F;
                        var173 = var173 < 0.0F ? 0.0F : (var173 > 1.0F ? 1.0F : var173);
                        int var179 = var72 - var63;
                        if (var179 < 0) {
                           var179 += 6000;
                        }

                        float var184 = var179 >= (1567392728 ^ 1567392282) ? 1.0F : var179 / 450.0F;
                        float var189 = (var84 ? var8 : var7) * (1.0F - var173 * var173 * (3.0F - 2.0F * var173)) * var184 * var135;
                        if (var73 == 2) {
                           float var193 = (var163 - 0.25F) / 1.2F;
                           var193 = var193 < 0.0F ? 0.0F : (var193 > 1.0F ? 1.0F : var193);
                           var189 *= var193 * var193 * (3.0F - 2.0F * var193);
                        }

                        if (!(var189 < 0.012F)) {
                           if (var189 > 1.0F) {
                              var189 = 1.0F;
                           }

                           float var195 = mf[var72] * (1.0F + var163 * 0.01F);
                           float var201 = mc[var72];
                           float var206 = MathHelper.sin(var201);
                           float var211 = MathHelper.cos(var201);
                           float var113 = var17 * mg[var72];
                           float var111;
                           float var112;
                           float var216;
                           float var219;
                           float var223;
                           float var228;
                           float var232;
                           if (var73 == 2) {
                              float var114 = mh[var72];
                              float var115 = mi[var72];
                              float var116 = MathHelper.cos(var114);
                              float var117 = MathHelper.sin(var114);
                              float var118 = MathHelper.cos(var115);
                              float var119 = MathHelper.sin(var115);
                              var228 = var116 * var211 * var195;
                              var232 = var117 * var195;
                              var111 = -var116 * var206 * var195;
                              var216 = (var119 * var117 * var211 + var118 * var206) * var195;
                              var219 = -var119 * var116 * var195;
                              var223 = (-var119 * var117 * var206 + var118 * var211) * var195;
                              var112 = 1.0F;
                           } else {
                              float var234 = md[var72];
                              float var236 = me[var72];
                              if (var128 < 0.0F) {
                                 var128 = 0.0F;
                              }

                              if (var234 > var128) {
                                 var234 = var128;
                              } else if (var234 < -var128) {
                                 var234 = -var128;
                              }

                              if (var236 > var128) {
                                 var236 = var128;
                              } else if (var236 < -var128) {
                                 var236 = -var128;
                              }

                              var228 = var211 * var195;
                              var111 = -var206 * var195;
                              var232 = -(var234 * var228 + var236 * var111);
                              float var238 = !var84 || !(mi[var72] > (float) (Math.PI / 2)) && !(mi[var72] < (float) (-Math.PI / 2)) ? var195 : -var195;
                              var216 = var206 * var238;
                              var223 = var211 * var238;
                              var219 = -(var234 * var216 + var236 * var223);
                              if (var73 == 3) {
                                 var148 += MathHelper.sin(var4 * 1.3 + var127 * 20.0F) * 0.008F;
                              }

                              var112 = (var148 < 0.0F ? -var148 : var148) / var163;
                              var112 = var112 < 0.15F ? 0.3873F : MathHelper.sqrt(var112);
                           }

                           int var240 = mq[var72];
                           int var235;
                           int var237;
                           int var239;
                           if (var84) {
                              float var241 = var18 * mg[var72] * 0.8F;
                              float var244 = mo[var72];
                              var241 = var241 > 1.0F ? 1.0F : var241;
                              var235 = (int)(255.0F * var241);
                              var237 = (int)(255.0F * var241 * (1.0F - 0.26F * var244));
                              var239 = (int)(255.0F * var241 * (1.0F - 0.36F * var244));
                              float var120 = var219 * var111 - var223 * var232;
                              float var121 = var223 * var228 - var216 * var111;
                              float var122 = var216 * var232 - var219 * var228;
                              if (var120 * var142 + var121 * var148 + var122 * var151 > 0.0F) {
                                 var240++;
                              }
                           } else {
                              if (var113 > 1.0F) {
                                 var113 = 1.0F;
                              }

                              var235 = (int)(255.0F * var113);
                              var237 = (int)(249.0F * var113);
                              var239 = (int)(245.0F * var113);
                           }

                           int var243 = (int)(var189 * 255.0F);
                           float var245 = var195 * 2.0F * var35 / var163 * var112;
                           int var246 = (var245 >= 64.0F ? 0 : (var245 >= 32.0F ? 16 : (var245 >= 16.0F ? 32 : 48))) + var240;
                           float var247 = du[var246];
                           float var248 = dv[var246];
                           float var123 = dw[var246];
                           float var124 = dx[var246];
                           if (var73 == 2 && var163 < 4.0F && nr < (2028670793 ^ 2028670665)) {
                              int var125 = nr * 13;
                              var64[var125] = var142;
                              var64[var125 + 1] = var148;
                              var64[var125 + 2] = var151;
                              var64[var125 + 3] = var216;
                              var64[var125 + 4] = var219;
                              var64[var125 + 5] = var223;
                              var64[var125 + 6] = var228;
                              var64[var125 + 7] = var232;
                              var64[var125 + 8] = var111;
                              var64[var125 + 9] = var247;
                              var64[var125 + 10] = var248;
                              var64[var125 + 11] = var123;
                              var64[var125 + 12] = var124;
                              var65[nr] = var163;
                              var66[nr] = var235 << 24 | var237 << 16 | var239 << 8 | var243;
                              nr++;
                           } else if (var60) {
                              var0.vertex(var142 - var216 - var228, var148 - var219 - var232, var151 - var223 - var111)
                                 .texture(var247, var124)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var142 - var216 + var228, var148 - var219 + var232, var151 - var223 + var111)
                                 .texture(var247, var248)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var142 + var216 + var228, var148 + var219 + var232, var151 + var223 + var111)
                                 .texture(var123, var248)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var142 + var216 - var228, var148 + var219 - var232, var151 + var223 - var111)
                                 .texture(var123, var124)
                                 .color(var235, var237, var239, var243);
                           } else {
                              var0.vertex(var1, var142 - var216 - var228, var148 - var219 - var232, var151 - var223 - var111)
                                 .texture(var247, var124)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var1, var142 - var216 + var228, var148 - var219 + var232, var151 - var223 + var111)
                                 .texture(var247, var248)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var1, var142 + var216 + var228, var148 + var219 + var232, var151 + var223 + var111)
                                 .texture(var123, var248)
                                 .color(var235, var237, var239, var243);
                              var0.vertex(var1, var142 + var216 - var228, var148 + var219 - var232, var151 + var223 - var111)
                                 .texture(var123, var124)
                                 .color(var235, var237, var239, var243);
                           }
                        }
                     }
                  }
               }
            } else {
               if (var73 == 1) {
                  int var85 = mr[var72];
                  if (var85 >= 0 && var48[var85] > 0) {
                     var48[var85]--;
                  }
               }

               mt[var72] = 0;
            }
         }
      }

      mv = var34;
      mw = var71;
   }

   private static void av(VertexConsumer var0, Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8) {
      if (qq != 0) {
         System.nanoTime();
      }

      float var9 = (0.3F + 0.9F * oy) * var4;
      float var10 = 0.9F + 0.1F * MathHelper.sin(var5 * 0.8);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.55F, -1065353190 ^ -1065352987, 80, 30, var9 * 0.22F, var8);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.26F, 548673964 ^ 548673875, 110, 40, var9 * 0.42F * var10, var8);
      if (!ShellArrayCache.an) {
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.11F, -634787458 ^ -634787455, -1086065360 ^ -1086065254, 70, var9 * 0.7F * var10, var8);
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.045F, 127186224 ^ 127186383, -454896134 ^ -454896364, 632693214 ^ 632693018, var9 * var10, var8);
      }
   }

   private static void aw(VertexConsumer var0, Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8, float var9) {
      if (qq != 0) {
         new Object().hashCode();
      }

      float var10 = (0.3F + 0.9F * oy) * var4;
      float var11 = 0.92F + 0.08F * MathHelper.sin(var5 * 0.5);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.55F, -1703949190 ^ -1703949179, (int)(120.0F + 30.0F * var9), (int)(150.0F - 90.0F * var9), var10 * 0.2F, var8);
      ax(
         var0,
         var1,
         var2,
         var3,
         0.0F,
         var7 * 0.26F,
         1252086809 ^ 1252087014,
         (int)(150.0F + 25.0F * var9),
         (int)(165.0F - 85.0F * var9),
         var10 * 0.4F * var11,
         var8
      );
      ax(
         var0,
         var1,
         var2,
         var3,
         0.0F,
         var7 * 0.12F,
         1470218238 ^ 1470217985,
         (int)(195.0F + 10.0F * var9),
         (int)(190.0F - 70.0F * var9),
         var10 * 0.68F * var11,
         var8
      );
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.05F, 823622609 ^ 823622446, (int)(240.0F + 4.0F * var9), (int)(224.0F - 19.0F * var9), var10 * var11, var8);
   }

   private static void ax(
      VertexConsumer var0, Entry var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, float var9, float[] var10
   ) {
      if (qq != 0) {
         System.nanoTime();
      }

      int var11 = (int)((var9 > 1.0F ? 1.0F : (var9 < 0.0F ? 0.0F : var9)) * 255.0F);
      if (var11 > 0) {
         float var12 = var10[0] * var5;
         float var13 = var10[1] * var5;
         float var14 = var10[2] * var5;
         float var15 = var10[3] * var5;
         float var16 = var10[4] * var5;
         float var17 = var10[5] * var5;
         var0.vertex(var1, var2 - var12 - var15, var3 - var13 - var16, var4 - var14 - var17).texture(0.0F, 1.0F).color(var6, var7, var8, var11);
         var0.vertex(var1, var2 - var12 + var15, var3 - var13 + var16, var4 - var14 + var17).texture(0.0F, 0.0F).color(var6, var7, var8, var11);
         var0.vertex(var1, var2 + var12 + var15, var3 + var13 + var16, var4 + var14 + var17).texture(1.0F, 0.0F).color(var6, var7, var8, var11);
         var0.vertex(var1, var2 + var12 - var15, var3 + var13 - var16, var4 + var14 - var17).texture(1.0F, 1.0F).color(var6, var7, var8, var11);
      }
   }

   private static void ay(VertexConsumer var0, Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8) {
      if (qq != 0) {
         Thread.currentThread().getName().length();
      }

      if (!(on < -0.05F)) {
         float var9 = (0.45F + 0.55F * oy) * var4 * (0.85F + 0.15F * MathHelper.sin(var5 * 0.35));
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.6F, 2009189467 ^ 2009189540, 184943203 ^ 184943277, -180234228 ^ -180234112, var9 * 0.16F, var8);
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.22F, -1898473765 ^ -1898473948, 1767962747 ^ 1767962779, -1852951282 ^ -1852951106, var9 * 0.3F, var8);
         if (!ShellArrayCache.an) {
            ax(var0, var1, var2, var3, 0.0F, var7 * 0.075F, -964095216 ^ -964094993, 991009522 ^ 991009282, 1296885022 ^ 1296885192, var9 * 0.5F, var8);
         }
      }
   }
}
