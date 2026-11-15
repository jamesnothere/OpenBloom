package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CurveJ;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RotG;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult.Success;
import net.minecraft.util.ActionResult.SwingSource;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class RenderCZ extends BuilderFactory implements InitNotifier {
   private final ItemDescriptor ax;
   private final BlockCalculator ay;
   private final BlockCalculator az;
   private final BlockCalculator ba;
   private final BlockCalculator bb;
   private final CheckerBridge bc;
   private final CheckerBridge bd;
   private final BlockCalculator be;
   private final CheckerBridge bf;
   private final BlockCalculator bg;
   private final SlotEntry bh;
   private final TimingEntry bi;
   private final TimingEntry bj;
   private static final String[] bk = new String[]{QueryZone.r(new byte[]{82, 111, 117, 103}, 16), TokenExtractor.w(new byte[]{125, 86, 88, 64, 85, 87}, 51)};
   public static volatile boolean MANUAL;
   private static RenderCZ bl;
   private static final long bm = 5000L;
   private static final int bn = 40;
   private boolean bo;
   private boolean bp;
   private int bq;
   private int br;
   private long bs;
   private long bt;
   private long bu;
   private long bv;
   private long bw;
   private BlockPos bx;
   private boolean by;
   private boolean bz;
   private boolean ca;
   private long cb;
   private long cc;
   private int cd;
   private volatile boolean ce;
   private volatile BlockPos cf;
   private volatile BlockPos cg;
   private volatile float ch;
   private volatile float ci;
   private volatile float cj;
   private volatile float ck;
   private volatile boolean cl;
   private volatile boolean cm;
   private volatile long cn;
   private float co;
   private float cp;
   private volatile float cq;
   private volatile float cr;
   private volatile Runnable cs;
   private int ct;
   private static int cu = 0;

   public RenderCZ() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'䂵', '䄫', '䅅', '䄥', '䄇', '䆡', '䇡', '䇑', '䆽', '䆕', '䉳', '䉉'},
         -460439322,
         new char[]{
            '痈',
            '痝',
            '疳',
            '疉',
            '癨',
            '癅',
            '瘷',
            '瘋',
            '盢',
            '盁',
            '盓',
            '皲',
            '的',
            '眼',
            '睋',
            '眶',
            '眘',
            '矻',
            '矒',
            '瞥',
            '矙',
            '破',
            '硐',
            '砺',
            '砐',
            '磢',
            '磈',
            '碫',
            '碞',
            '礬',
            '祊',
            '礤',
            '礍',
            '禨',
            '秂',
            '禾',
            '禕',
            '穨',
            '穌',
            '稦',
            '稄',
            '竳',
            '窿',
            '竌',
            '窸',
            '窏',
            '筫',
            '筛',
            '笮',
            '笖',
            '箷',
            '篗',
            '箻',
            '算',
            '类',
            '籝',
            '簣',
            '簃'
         },
         131298697
      );
      ItemDescriptor var10001 = new ItemDescriptor("", 71, false);
      var10001.n(new char[]{'ꊳ', 'ꍴ', 'ꍌ', 'ꌣ', 'ꌄ', 'ꏧ', 'ꏓ', 'ꏠ', 'ꎔ', 'ꎛ', 'ꑤ'}, 1508614887);
      this.ax = var10001;
      BlockCalculator var1 = new BlockCalculator("", 0.0, 500.0, 100.0, 1.0);
      var1.n(new char[]{'㿤', '㾧', '㾗', '䁫', '䁎', '䀮', '䁿', '䀺', '䃸', '䃐', '䂺', '䂃', '䄹', '䄐', '䄺', '䄅', '䆼'}, -1833353307);
      this.ay = var1;
      BlockCalculator var2 = new BlockCalculator("", 0.0, 500.0, 0.0, 1.0);
      var2.n(new char[]{'䡉', '䡎', '䠱', '䠃', '䣵', '䣝', '䣴', '䢤', '䥳', '䥘', '䤤', '䥏', '䦦', '䧀', '䦿', '䧂'}, 1342392346);
      this.az = var2;
      BlockCalculator var3 = new BlockCalculator("", 1.0, 9.0, 9.0, 1.0);
      var3.n(new char[]{'쇦', '솾', '솄', '쉪', '쉃', '쉭', '숿', '싧', '싅', '슽'}, 164348338);
      this.ba = var3;
      BlockCalculator var4 = new BlockCalculator("", 3.0, 6.0, 4.5, 0.1);
      var4.n(new char[]{'\ue588', '\ue598', '\ue676', '\ue650', '\ue633'}, -446896678);
      this.bb = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'懦', '憣', '憜', '扱', '扇', '扲', '戰', '拾', '拈', '抢', '抈', '捿'}, -299408969);
      this.bc = var5;
      CheckerBridge var6 = new CheckerBridge("", true);
      var6.n(new char[]{'枪', '桵', '桘', '根', '栁', '棼', '梓', '梀', '梞', '楤', '楎', '椺', '椄', '槣', '槅', '榹'}, -2115803143);
      this.bd = var6;
      BlockCalculator var7 = new BlockCalculator("", 30.0, 360.0, 180.0, 10.0);
      var7.n(new char[]{'李', '杔', '朮', '朘', '柬', '柞', '枹', '枛', '栴', '桠', '栢', '栔', '棵', '棋'}, -1916573924);
      this.be = var7;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'ᔼ', 'ᗻ', 'ᗂ', 'ᗦ', 'ᖠ', 'ᙥ', 'ᙐ', 'ᘫ', 'ᘏ', 'ᛧ'}, -661842583);
      this.bf = var8;
      BlockCalculator var9 = new BlockCalculator("", 1.0, 5.0, 3.0, 0.5);
      var9.n(
         new char[]{
            '\ue371',
            '\ue332',
            '\ue301',
            '\ue3f8',
            '\ue3de',
            '\ue3a8',
            '\ue3ce',
            '\ue45e',
            '\ue458',
            '\ue439',
            '\ue40f',
            '\ue4e7',
            '\ue4cf',
            '\ue4b3',
            '\ue48e'
         },
         128377652
      );
      this.bg = var9;
      this.bh = new SlotEntry(
         JoinerWriter.p(new byte[]{-39, -71, -7, -19, -19}, 116),
         QueryZone.r(new byte[]{49, 12, 22, 4}, 115),
         JoinerWriter.p(new byte[]{4, 55, 53, 47}, 61),
         NotifyResolver.q(new byte[]{-10, -37, -47, -57, -54, -50}, 187)
      );
      TimingEntry var10 = new TimingEntry("", 0.0, 500.0, 40.0, 1.0, 1.0, 0.0);
      var10.n(new char[]{'磚', '碆', '碰', '碏', '祱', '祇', '礫', '祂', '秅', '秅', '秓', '禿', '禄'}, 1696430217);
      this.bi = var10;
      TimingEntry var11 = new TimingEntry("", 0.0, 500.0, 40.0, 1.0, 1.0, 0.0);
      var11.n(new char[]{'垤', '堨', '塉', '堭', '堀', '壩', '墁', '墄', '墺', '墒', '奼', '奅'}, 1272797159);
      this.bj = var11;
      this.cb = 0L;
      this.cc = 0L;
      this.cd = 0;
      this.ce = false;
      this.cf = null;
      this.cg = null;
      this.ch = 0.0F;
      this.ci = 0.0F;
      this.cj = 0.0F;
      this.ck = 0.0F;
      this.cl = false;
      this.cm = false;
      this.cn = 0L;
      this.co = 0.0F;
      this.cp = 0.0F;
      this.cq = 0.0F;
      this.cr = 0.0F;
      this.cs = null;
      this.ct = 0;
      this.a(this.ax, this.ay, this.az, this.ba, this.bb, this.bc, this.bd, this.be, this.bf, this.bg, this.bh, this.bi, this.bj);
      bl = this;
   }

   @Override
   public void c() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.b.a(InitNotifier.class, this);
      LockD.c = this::b;
      this.cn = System.nanoTime();
      this.w();
      this.am();
      this.bo = this.bh.b(bk[1]);
      MANUAL = this.bo;
      super.c();
   }

   @Override
   public void d() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      MANUAL = false;
      this.b.b(InitNotifier.class, this);
      LockD.c = null;
      this.w();
      this.am();
      this.by = false;
      super.d();
   }

   private void b() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (MANUAL) {
         LockD.b = 0L;
      } else if (a.player != null && this.ce && this.bd.f()) {
         long var1 = System.nanoTime();
         float var3 = (float)(var1 - this.cn) / 1.0E9F;
         this.cn = var1;
         var3 = Math.max(0.0F, Math.min(var3, 0.05F));
         if (this.cl && !this.cm) {
            float var4 = this.be.g();
            float var5 = Math.max(0.045F, Math.min(0.3F, 12.0F / Math.max(var4, 1.0F)));
            if (this.bf.f()) {
               float var6 = Math.max(1.0F, Math.min(5.0F, this.bg.f().floatValue()));
               var5 *= 0.8F + var6 * 0.1F;
            }

            this.ch = CurveJ.b(a.player.getYaw(), this.cj, var5, var3);
            this.ci = Math.max(-90.0F, Math.min(90.0F, (float)CurveJ.a(a.player.getPitch(), this.ck, var5, var3)));
            if (!this.bc.f()) {
               LockD.b = var1 + 200000000L;
            }

            this.c(this.ch, this.ci);
            float var10 = Math.abs(this.d(this.cj - this.ch));
            float var7 = Math.abs(this.ck - this.ci);
            if (var10 < 0.5F && var7 < 0.5F) {
               this.cm = true;
               this.ch = this.cj;
               this.ci = this.ck;
               this.c(this.ch, this.ci);
               LockD.b = 0L;
               if (this.cs != null) {
                  Runnable var8 = this.cs;
                  this.cs = null;
                  a.execute(var8);
               }
            }
         } else {
            LockD.b = 0L;
         }
      } else {
         LockD.b = 0L;
      }
   }

   private void c(float var1, float var2) {
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (cu != 0) {
                  new Object().hashCode();
                  var3 = 1;
                  break;
               }
            case 1:
               if (!this.bc.f() && RotG.a(20, this)) {
                  a.player.setYaw(var1);
                  a.player.setPitch(var2);
                  a.player.lastYaw = var1;
                  a.player.lastPitch = var2;
                  var3 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   private float d(float var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (cu != 0) {
                  Thread.currentThread().getName().length();
                  var2 = 1;
                  break;
               }
            case 1:
               var1 %= 360.0F;
               if (var1 >= 180.0F) {
                  var1 -= 360.0F;
                  var2 = 3;
                  break;
               }
            case 2:
               if (var1 < -180.0F) {
                  var1 += 360.0F;
                  var2 = 3;
                  break;
               }

               return var1;
            case 3:
               return var1;
         }
      }
   }

   @Override
   public void a() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      boolean var1 = this.bh.b(bk[1]);
      if (var1 != this.bo) {
         this.y(var1);
      }

      if (var1) {
         this.z();
      } else {
         try {
            if (a.currentScreen != null || a.player == null || a.world == null || a.interactionManager == null) {
               return;
            }

            long var2 = System.nanoTime();
            if (this.ce && this.bd.f() && this.cl && !this.cm && var2 - this.cn > 100000000L) {
               this.b();
            }

            if (!this.s()) {
               if (this.ce) {
                  this.w();
               }

               if (this.t()) {
                  this.v(
                     JoinerWriter.p(
                        new byte[]{
                           6,
                           1,
                           10,
                           9,
                           -2,
                           2,
                           -6,
                           -78,
                           3,
                           -11,
                           2,
                           -2,
                           -18,
                           3,
                           -7,
                           -86,
                           -22,
                           -10,
                           -22,
                           -18,
                           -12,
                           -10,
                           -93,
                           -15,
                           -13,
                           -96,
                           -26,
                           -22,
                           -20,
                           -13,
                           -18,
                           -18,
                           -24,
                           -26,
                           -36
                        },
                        103
                     )
                  );
               }

               return;
            }

            if (!this.ce && !this.u()) {
               return;
            }

            long var4 = this.ay.g();
            if (this.cl && !this.cm && this.bd.f() && var4 > 50L) {
               return;
            }

            long var6 = System.currentTimeMillis();
            long var8 = Math.max(var4, 0L);
            if (var6 - this.cb < var8) {
               return;
            }

            if (var6 - this.cc < this.az.g()) {
               return;
            }

            this.cb = var6;
            switch (this.cd) {
               case 0:
                  String var10 = this.f99();
                  if (var10 != null) {
                     this.v(var10);
                     this.w();
                     return;
                  }

                  this.cd++;
                  break;
               case 1:
                  if (this.j(this.cf) && !this.m(this.cf, Items.RESPAWN_ANCHOR)) {
                     this.w();
                     return;
                  }

                  this.cd++;
                  break;
               case 2:
                  if (this.j(this.cf)) {
                     this.ct++;
                     if (this.ct > 40) {
                        this.w();
                     }
                  } else {
                     this.ct = 0;
                     if (!this.p(this.cf)) {
                        this.w();
                        return;
                     }

                     this.cd++;
                  }
                  break;
               case 3:
                  if (!this.j(this.cg)) {
                     this.cd++;
                  } else {
                     BlockPos var11 = this.cg.down();
                     if (this.j(var11)) {
                        this.cd++;
                     } else {
                        this.m(this.cg, Items.GLOWSTONE);
                        this.cd++;
                     }
                  }
                  break;
               case 4:
                  this.l(Math.round(this.ba.g()) - 1);
                  this.cd++;
                  break;
               case 5:
                  if (this.x(this.cf)) {
                     this.ct++;
                     if (this.ct > 40) {
                        this.w();
                     }
                  } else {
                     this.ct = 0;
                     if (!this.o(this.cf, null)) {
                        this.w();
                        return;
                     }

                     this.cd++;
                  }
                  break;
               case 6:
                  this.w();
            }
         } catch (Exception var12) {
            this.w();
         }
      }
   }

   private void e(Vec3d var1, Runnable var2) {
      if (cu != 0) {
         new Object().hashCode();
      }

      Vec3d var3 = a.player.getEyePos();
      Vec3d var4 = var1.subtract(var3);
      this.cj = (float)(Math.toDegrees(Math.atan2(var4.z, var4.x)) - 90.0);
      this.ck = (float)(-Math.toDegrees(Math.atan2(var4.y, Math.sqrt(var4.x * var4.x + var4.z * var4.z))));
      boolean var5 = this.bd.f();
      boolean var6 = this.ay.g() <= 50;
      if (var5) {
         if ((!this.cl || this.cm) && !this.bc.f()) {
            this.ch = a.player.getYaw();
            this.ci = a.player.getPitch();
         }

         this.co = this.ch;
         this.cp = this.ci;
         this.cq = 0.0F;
         float var7 = Math.abs(this.d(this.cj - this.co));
         float var8 = Math.abs(this.ck - this.cp);
         this.cr = (float)Math.sqrt(var7 * var7 + var8 * var8);
         if (this.cr < 0.1F) {
            this.cr = 0.1F;
         }

         this.cl = true;
         this.cm = false;
         if (var6) {
            this.cs = null;
            if (var2 != null) {
               a.execute(var2);
            }
         } else {
            this.cs = var2;
         }
      } else {
         this.ch = this.cj;
         this.ci = this.ck;
         this.c(this.cj, this.ck);
         this.cl = false;
         this.cm = true;
         this.cs = null;
         if (var2 != null) {
            a.execute(var2);
         }
      }
   }

   private String f99() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      BlockHitResult var1 = this.g99();
      if (var1 != null && var1.getType() == Type.BLOCK) {
         BlockPos var2 = var1.getBlockPos();
         if (a.world.getBlockState(var2).getBlock() == Blocks.RESPAWN_ANCHOR) {
            this.cf = var2;
         } else if (this.j(var2)) {
            this.cf = var2;
         } else {
            this.cf = var2.offset(var1.getSide());
         }

         double var3 = a.player.getEyePos().distanceTo(Vec3d.ofCenter(this.cf));
         if (var3 > this.bb.f() + 0.5) {
            return NotifyResolver.q(new byte[]{-27, -15, -25, -1, -28, -4, -107, -49, -92, -76, -43, -121, 103, 24, 39, 21}, -1069451625 ^ -1069451770)
               + StringDecoder.d(new byte[]{-26, -27, -19}, -398276367 ^ -398276490);
         }

         boolean var5 = a.world.getBlockState(this.cf).getBlock() == Blocks.RESPAWN_ANCHOR;
         if (!this.j(this.cf) && !var5) {
            return StringDecoder.d(new byte[]{-5, -17, -1, -21, -18, -2, -87, -5, -9, -25, -26}, 1758998071 ^ 1758998200)
               + YieldKeeper.v(new byte[]{85, 64, -7, -77, -48, 79, 50, -13, -60, -110, 101, 35, 4, -59, -76}, 48);
         }

         this.cg = this.h99();
         return null;
      } else {
         return NotifyResolver.q(new byte[]{31, 31, 85}, 113)
            + JoinerWriter.p(new byte[]{-61, -52, -50, -63, -56, 124, -60, -56, 121, -50}, 1665612357 ^ 1665612506)
            + YieldKeeper.v(new byte[]{-9, 89, -83, 88, 97, -35, 38, -104}, 1798384212 ^ 1798384330)
            + StringDecoder.d(new byte[]{28, 26, 87, 4, 20, 17, 16, 26}, 117);
      }
   }

   private BlockHitResult g99() {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (a.player != null && a.world != null) {
         Vec3d var1 = a.player.getEyePos();
         Vec3d var2 = a.player.getRotationVec(1.0F);
         Vec3d var3 = var1.add(var2.multiply(this.bb.f()));
         return a.world.raycast(new RaycastContext(var1, var3, ShapeType.OUTLINE, FluidHandling.NONE, a.player));
      } else {
         return null;
      }
   }

   private BlockPos h99() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      Vec3d var1 = new Vec3d(a.player.getX(), a.player.getY(), a.player.getZ());
      Vec3d var2 = Vec3d.ofCenter(this.cf);
      Vec3d var3 = var1.add(var2).multiply(0.5);
      BlockPos var4 = new BlockPos((int)Math.floor(var3.x), a.player.getBlockY(), (int)Math.floor(var3.z));
      if (var4.equals(this.cf) || var4.equals(a.player.getBlockPos())) {
         Direction var5 = this.i(a.player.getYaw());
         var4 = a.player.getBlockPos().offset(var5);
         if (var4.equals(this.cf)) {
            var4 = a.player.getBlockPos();
         }
      }

      return var4;
   }

   private Direction i(float var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (cu != 0) {
                  System.nanoTime();
                  var2 = 4;
                  break;
               }
            case 4:
               var1 %= 360.0F;
               if (var1 < 0.0F) {
                  var1 += 360.0F;
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 >= 315.0F) {
                  return Direction.SOUTH;
               }

               if (var1 < 45.0F) {
                  var2 = 2;
                  break;
               }
            case 5:
               if (var1 >= 45.0F && var1 < 135.0F) {
                  return Direction.WEST;
               }
            case 6:
               if (var1 >= 135.0F && var1 < 225.0F) {
                  return Direction.NORTH;
               }
            case 3:
               return Direction.EAST;
            case 2:
               return Direction.SOUTH;
         }
      }
   }

   private boolean j(BlockPos var1) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (a.world != null && var1 != null) {
         BlockState var2 = a.world.getBlockState(var1);
         Block var3 = var2.getBlock();
         return var2.isAir()
            ? true
            : var3 == Blocks.SHORT_GRASS
               || var3 == Blocks.TALL_GRASS
               || var3 == Blocks.FERN
               || var3 == Blocks.LARGE_FERN
               || var3 == Blocks.DEAD_BUSH
               || var3 == Blocks.VINE
               || var3 == Blocks.FIRE
               || var3 == Blocks.SOUL_FIRE
               || var3 == Blocks.WATER
               || var3 == Blocks.LAVA
               || var3 == Blocks.SNOW
               || var3 == Blocks.SEAGRASS
               || var3 == Blocks.TALL_SEAGRASS
               || var3 == Blocks.KELP
               || var3 == Blocks.KELP_PLANT
               || var2.isReplaceable();
      } else {
         return false;
      }
   }

   private boolean k(Item var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (a.player.getInventory().getStack(var2).getItem() == var1) {
            if (InitExecutor.a(a.player.getInventory()) != var2) {
               this.cc = System.currentTimeMillis();
            }

            InitExecutor.a(a.player.getInventory(), var2);
            return true;
         }
      }

      return false;
   }

   private void l(int var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (var1 >= 0 && var1 < 9) {
         if (InitExecutor.a(a.player.getInventory()) != var1) {
            this.cc = System.currentTimeMillis();
         }

         InitExecutor.a(a.player.getInventory(), var1);
      }
   }

   private boolean m(BlockPos var1, Item var2) {
      if (cu != 0) {
         System.nanoTime();
      }

      if (var1 == null || !this.j(var1) || a.interactionManager == null || a.player == null) {
         return false;
      }

      if (!this.k(var2)) {
         return false;
      }

      BlockHitResult var3 = this.n(var1);
      if (var3 == null) {
         return false;
      }

      this.e(var3.getPos(), () -> {
         if (cu != 0) {
            Thread.currentThread().getName().length();
         }

         a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var3);
         a.player.swingHand(Hand.MAIN_HAND);
      });
      return true;
   }

   private BlockHitResult n(BlockPos var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      Direction[] var2 = new Direction[]{Direction.DOWN, Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};

      for (Direction var6 : var2) {
         BlockPos var7 = var1.offset(var6);
         if (!this.j(var7)) {
            return new BlockHitResult(
               Vec3d.ofCenter(var7)
                  .add(var6.getOpposite().getVector().getX() * 0.5, var6.getOpposite().getVector().getY() * 0.5, var6.getOpposite().getVector().getZ() * 0.5),
               var6.getOpposite(),
               var7,
               false
            );
         }
      }

      return null;
   }

   private boolean o(BlockPos var1, Item var2) {
      if (cu != 0) {
         System.nanoTime();
      }

      if (var1 != null && a.player != null && a.interactionManager != null) {
         if (var2 != null) {
            this.k(var2);
         }

         Direction var3 = Direction.UP;
         Vec3d var4 = Vec3d.ofCenter(var1).add(var3.getOffsetX() * 0.5, var3.getOffsetY() * 0.5, var3.getOffsetZ() * 0.5);
         Vec3d var5 = a.player.getEyePos();
         if (var4.y > var5.y) {
            var4 = Vec3d.ofCenter(var1);
         }

         this.e(var4, () -> {
            if (cu != 0) {
               System.nanoTime();
            }

            BlockHitResult var1x = q(var1);
            a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var1x);
            a.player.swingHand(Hand.MAIN_HAND);
         });
         return true;
      } else {
         return false;
      }
   }

   private boolean p(BlockPos var1) {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (var1 == null || this.j(var1) || a.interactionManager == null || a.player == null) {
         return false;
      }

      if (!this.k(Items.GLOWSTONE)) {
         return false;
      }

      BlockHitResult var2 = q(var1);
      a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var2);
      a.player.swingHand(Hand.MAIN_HAND);
      return true;
   }

   private static BlockHitResult q(BlockPos var0) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (a.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == Type.BLOCK && var1.getBlockPos().equals(var0)) {
         return var1;
      } else {
         Vec3d var27 = a.player.getEyePos();
         double var28 = var0.getX();
         double var4 = var0.getY();
         double var6 = var0.getZ();
         double var8 = Math.max(var28, Math.min(var28 + 1.0, var27.x));
         double var10 = Math.max(var4, Math.min(var4 + 1.0, var27.y));
         double var12 = Math.max(var6, Math.min(var6 + 1.0, var27.z));
         double var14 = var27.x - var8;
         double var16 = var27.y - var10;
         double var18 = var27.z - var12;
         double var20 = Math.abs(var14);
         double var22 = Math.abs(var16);
         double var24 = Math.abs(var18);
         Direction var26;
         if (var22 >= var20 && var22 >= var24) {
            var26 = var16 > 0.0 ? Direction.UP : Direction.DOWN;
            var8 = Math.max(var28 + 0.05, Math.min(var28 + 0.95, var8));
            var12 = Math.max(var6 + 0.05, Math.min(var6 + 0.95, var12));
         } else if (var20 >= var24) {
            var26 = var14 > 0.0 ? Direction.EAST : Direction.WEST;
            var10 = Math.max(var4 + 0.05, Math.min(var4 + 0.95, var10));
            var12 = Math.max(var6 + 0.05, Math.min(var6 + 0.95, var12));
         } else {
            var26 = var18 > 0.0 ? Direction.SOUTH : Direction.NORTH;
            var8 = Math.max(var28 + 0.05, Math.min(var28 + 0.95, var8));
            var10 = Math.max(var4 + 0.05, Math.min(var4 + 0.95, var10));
         }

         return new BlockHitResult(new Vec3d(var8, var10, var12), var26, var0, false);
      }
   }

   private boolean r(Item var1) {
      int var2 = 0;
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (cu != 0) {
                  System.nanoTime();
                  var3 = 4;
                  break;
               }
            case 4:
               var2 = 0;
               var3 = 1;
               break;
            case 1:
               if (var2 >= 9) {
                  return false;
               }

               if (a.player.getInventory().getStack(var2).getItem() == var1) {
                  return true;
               }
            case 2:
               var2++;
               var3 = 1;
               break;
            case 3:
               return false;
         }
      }
   }

   private boolean s() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      return this.r(Items.RESPAWN_ANCHOR) && this.r(Items.GLOWSTONE);
   }

   private boolean t() {
      if (cu != 0) {
         System.nanoTime();
      }

      int var1 = this.ax.g();
      return var1 != -1 && SlotInspector.a(var1);
   }

   private boolean u() {
      byte var1 = 0;

      label16:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (cu != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (!this.t()) {
                  return false;
               }
            case 2:
               break label16;
         }
      }

      this.ce = true;
      return true;
   }

   private void v(String var1) {
   }

   private void w() {
      if (cu != 0) {
         new Object().hashCode();
      }

      this.ce = false;
      this.cd = 0;
      this.ct = 0;
      this.cb = 0L;
      this.cf = null;
      this.cg = null;
      this.cl = false;
      this.cm = false;
      this.cs = null;
      this.cq = 0.0F;
      LockD.b = 0L;
      RotG.b(this);
   }

   public boolean x(BlockPos var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      return a.world.getBlockState(var1).getBlock() == Blocks.RESPAWN_ANCHOR
         ? (Integer)a.world.getBlockState(var1).get(RespawnAnchorBlock.CHARGES) == 0
         : false;
   }

   private void y(boolean var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      this.bo = var1;
      MANUAL = var1;
      this.w();
      this.am();
   }

   private void z() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         this.aa();
      } catch (Exception var2) {
         this.am();
      }
   }

   private void aa() {
      if (cu != 0) {
         System.nanoTime();
      }

      if (a.currentScreen == null && a.player != null && a.world != null && a.interactionManager != null) {
         if (this.r(Items.RESPAWN_ANCHOR) && this.r(Items.GLOWSTONE)) {
            if (!this.bp) {
               this.au();
            }
         } else {
            if (this.bp) {
               this.am();
            }
         }
      }
   }

   public static void ab() {
      if (cu != 0) {
         new Object().hashCode();
      }

      RenderCZ var0 = bl;
      if (var0 != null && MANUAL) {
         var0.ac();
      }
   }

   private void ac() {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (this.bp) {
         try {
            this.ad();
         } catch (Exception var2) {
            this.am();
         }
      }
   }

   private void ad() {
      if (cu != 0) {
         new Object().hashCode();
      }

      if (a.player != null && a.world != null && a.interactionManager != null) {
         long var1 = System.currentTimeMillis();
         if (var1 - this.bs >= this.ay.g()) {
            if (var1 - this.bt >= this.az.g()) {
               long var3 = this.bs;
               this.bs = var1;
               this.ae(var3);
            }
         }
      }
   }

   private void ae(long var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      long var3 = System.currentTimeMillis();
      if (this.bx == null) {
         this.bw = var3;
      } else if (var3 - this.bw > 5000L) {
         this.al();
         return;
      }

      BlockHitResult var5 = this.ap();
      switch (this.bq) {
         case 0:
            if (this.bx != null || var5 != null && this.ao(var5)) {
               if (this.j(this.bx)) {
                  if (var5 == null || !this.ar(var5).equals(this.bx)) {
                     this.bs = var1;
                     return;
                  }

                  if (!this.ah() || !this.aj(Items.RESPAWN_ANCHOR)) {
                     this.bs = 0L;
                     return;
                  }

                  this.an(var5);
               }

               this.bs = 0L;
               if (this.af()) {
                  this.ak(2);
                  this.bz = false;
                  return;
               }

               this.ak(1);
               break;
            }

            this.al();
            return;
         case 1:
            if (!this.at(this.bx)) {
               this.bs = var1;
               if (++this.br > 40) {
                  this.al();
               }

               return;
            }

            this.br = 0;
            if (this.x(this.bx)) {
               boolean var6 = this.aq(var5, this.bx);
               boolean var7 = !this.ca && !var6 && var5 != null && this.as(var5);
               if (!var6 && !var7) {
                  this.bs = 0L;
                  return;
               }

               if (!this.ah() || !this.aj(Items.GLOWSTONE)) {
                  this.bs = 0L;
                  return;
               }

               this.an(var5);
               if (var7) {
                  this.ca = true;
                  this.bs = 0L;
                  return;
               }
            }

            if (this.ca) {
               this.ag();
               this.bs = 0L;
               return;
            }

            this.ak(2);
            this.bz = false;
            this.bs = 0L;
            break;
         case 2:
            if (!this.at(this.bx)) {
               this.al();
               return;
            }

            if (this.aq(var5, this.bx)) {
               if (this.bz) {
                  this.ag();
               } else {
                  this.bs = 0L;
               }

               return;
            }

            this.bz = true;
            if (var5 == null || !this.as(var5)) {
               this.bs = 0L;
               return;
            }

            if (this.ah() && this.aj(Items.GLOWSTONE)) {
               this.an(var5);
               this.ag();
               break;
            }

            this.bs = 0L;
            return;
         case 3:
            if (!this.ai(this.ba.g() - 1)) {
               this.bs = 0L;
               return;
            }

            this.ak(4);
            if (this.ca) {
               this.bs = 0L;
            }
            break;
         case 4:
            if (!this.at(this.bx)) {
               this.al();
               return;
            }

            if (this.x(this.bx)) {
               if (++this.br > 40) {
                  this.al();
               }

               return;
            }

            this.br = 0;
            if (!this.aq(var5, this.bx)) {
               this.bs = var1;
               return;
            }

            if (!this.ah()) {
               this.bs = 0L;
               return;
            }

            this.an(var5);
            this.al();
            break;
         default:
            this.al();
      }
   }

   private boolean af() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (this.at(this.bx) && this.x(this.bx)) {
         if (!(a.player.raycast(a.player.getBlockInteractionRange(), 1.0F, false) instanceof BlockHitResult var2)) {
            return false;
         } else {
            if (var2.getType() != Type.BLOCK || !var2.getBlockPos().equals(this.bx)) {
               return false;
            }

            if (!this.ah()) {
               return false;
            }

            if (!this.aj(Items.GLOWSTONE)) {
               return false;
            }

            this.an(var2);
            return true;
         }
      } else {
         return false;
      }
   }

   private void ag() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (cu != 0) {
                  new Object().hashCode();
                  var1 = 3;
                  break;
               }
            case 3:
               if (this.ai(this.ba.g() - 1)) {
                  this.ak(4);
                  var1 = 2;
                  break;
               }
            case 1:
               this.ak(3);
               this.bs = 0L;
               var1 = 2;
               break;
            case 2:
               return;
         }
      }
   }

   private boolean ah() {
      if (cu != 0) {
         new Object().hashCode();
      }

      return System.currentTimeMillis() - this.bv >= this.bj.g();
   }

   private boolean ai(int var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (var1 >= 0 && var1 <= 8) {
         if (InitExecutor.a(a.player.getInventory()) == var1) {
            return true;
         }

         if (System.currentTimeMillis() - this.bu < this.bi.g()) {
            return false;
         }

         this.bt = System.currentTimeMillis();
         InitExecutor.a(a.player.getInventory(), var1);
         this.bu = System.currentTimeMillis();
         return true;
      } else {
         return false;
      }
   }

   private boolean aj(Item var1) {
      int var2 = 0;
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (cu != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var3 = 3;
                  break;
               }
            case 3:
               if (a.player.getMainHandStack().isOf(var1)) {
                  return true;
               }
            case 4:
               var2 = 0;
               var3 = 5;
               break;
            case 1:
               return false;
            case 5:
               if (var2 >= 9) {
                  return false;
               }

               if (a.player.getInventory().getStack(var2).isOf(var1)) {
                  return this.ai(var2);
               }
            case 2:
               var2++;
               var3 = 5;
         }
      }
   }

   private void ak(int var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      this.bq = var1;
      this.bw = System.currentTimeMillis();
   }

   private void al() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      this.by = true;
      this.am();
   }

   private void am() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      this.bp = false;
      this.bq = 0;
      this.br = 0;
      this.bs = 0L;
      this.bx = null;
      this.bz = false;
      this.ca = false;
   }

   private void an(BlockHitResult var1) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.bv = System.currentTimeMillis();
      ActionResult var2 = a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var1);
      if (var2 instanceof Success && ((Success)var2).swingSource() == SwingSource.CLIENT) {
         a.player.swingHand(Hand.MAIN_HAND);
      }
   }

   private boolean ao(BlockHitResult var1) {
      if (cu != 0) {
         new Object().hashCode();
      }

      BlockPos var2 = var1.getBlockPos();
      if (!this.at(var2) && !this.j(var2)) {
         this.bx = var2.offset(var1.getSide());
      } else {
         this.bx = var2;
      }

      return a.player.getEyePos().distanceTo(Vec3d.ofCenter(this.bx)) > this.bb.p() + 0.5 ? false : this.j(this.bx) || this.at(this.bx);
   }

   private BlockHitResult ap() {
      if (cu != 0) {
         new Object().hashCode();
      }

      HitResult var1 = a.crosshairTarget;
      return var1 instanceof BlockHitResult && var1.getType() == Type.BLOCK ? (BlockHitResult)var1 : null;
   }

   private boolean aq(BlockHitResult var1, BlockPos var2) {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return var1 != null && var1.getBlockPos().equals(var2);
   }

   private BlockPos ar(BlockHitResult var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      BlockPos var2 = var1.getBlockPos();
      return this.j(var2) ? var2 : var2.offset(var1.getSide());
   }

   private boolean as(BlockHitResult var1) {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (var1.getBlockPos().equals(this.bx)) {
         return false;
      }

      BlockPos var2 = this.ar(var1);
      return !var2.equals(this.bx) && this.j(var2) && !new Box(var2).intersects(a.player.getBoundingBox());
   }

   private boolean at(BlockPos var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      return var1 != null && a.world.getBlockState(var1).isOf(Blocks.RESPAWN_ANCHOR);
   }

   private void au() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      if (!this.t()) {
         this.by = false;
      } else {
         if (!this.by) {
            this.bp = true;
         }
      }
   }

   @Override
   public void e() {
      if (cu != 0) {
         System.nanoTime();
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.f;
   }

   @Override
   public String g() {
      if (cu != 0) {
         System.nanoTime();
      }

      return super.g();
   }

   @Override
   public String h() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (cu != 0) {
         System.nanoTime();
      }

      return super.i();
   }

   @Override
   public int j() {
      if (cu != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (cu != 0) {
         Thread.currentThread().getName().length();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (cu != 0) {
         System.nanoTime();
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (cu != 0) {
         System.nanoTime();
      }

      super.a(var1);
   }
}
