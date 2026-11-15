package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

public final class BuilderExecutor extends BuilderFactory implements InitNotifier {
   private final TimingEntry r;
   private final TimingEntry s;
   private final CheckerBridge t;
   private final CheckerBridge u;
   private final PlacementEntry v;
   private final CheckerBridge w;
   private final CheckerBridge x;
   private static final long y = 25000000L;
   private static final long z = 50000000L;
   private static final long aa = 60000000L;
   private long ab;
   private long ac;
   private BlockPos ad;
   private long ae;
   private boolean af;
   private Entity ag;
   private long ah;
   private int ai;
   private boolean aj;
   private final Runnable ak;
   private static int al = 0;

   public BuilderExecutor() {
      super("", "", ParserEngine.V2);
      this.setName(new char[]{'澳', '瀰', '灪', '瀚', '瀳', '為', '烺', '炪', '炎', '煥', '煁', '焵', '焟'}, 2091741183, new char[0], -1715617842);
      TimingEntry var10001 = new TimingEntry("", 0.0, 550.0, 150.0, 1.0, 50.0, 50.0, true);
      var10001.n(new char[]{'엩', '얖', '얻', '얗', '왶', '왑', '옚', '옜', '웥', '웕', '욽', '욘', '읬', '은'}, 842843545);
      this.r = var10001;
      var10001 = new TimingEntry("", 0.0, 550.0, 200.0, 1.0, 50.0, 50.0, true);
      var10001.n(new char[]{'尣', '屎', '對', '峻', '峜', '岷', '岲', '嵴', '嵍', '崽', '崅', '巠', '巔', '嶸'}, 413621313);
      this.s = var10001;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'ු', '෨', 'එ', '\u0e6b', '๓', 'ญ', 'ฏ', '໋', '\u0ef6', '໒', 'ັ'}, -1909125721);
      this.t = var2;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'僵', '傝', '傱', '傅', '兹', '兙', '儯', '儙', '凩', '凤', '冤', '冻', '剡', '剀', '刮', '刑', '勇', '勏', '劫', '劂', '卫'}, -1975037804);
      this.u = var3;
      PlacementEntry var4 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var4.n(new char[]{'켂', '쾫', '쿅', '쾮', '쾃', '큦', '큅', '큋', '퀷', '퀞', '탷'}, -1319907482);
      this.v = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'䗡', '䖆', '䖨', '䖊', '䙡', '䙧', '䘱', '䘛', '䛲', '䛔', '䛞', '䚲'}, -1487911543);
      this.w = var5;
      CheckerBridge var6 = new CheckerBridge("", true);
      var6.n(new char[]{'뮀', '밫', '뱅', '밨', '밇', '병', '볕', '병', '벽', '법'}, 725203942);
      this.x = var6;
      this.ai = -1073741824;
      this.ak = this::f99;
      this.a(this.r, this.s, this.t, this.u, this.v, this.w, this.x);
   }

   @Override
   public void c() {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      this.b.a(InitNotifier.class, this);
      long var1 = System.nanoTime();
      this.ab = var1;
      this.ac = var1;
      this.ad = null;
      this.af = false;
      this.ag = null;
      this.aj = false;
      FrameClockCache.a(this.ak);
      super.c();
   }

   @Override
   public void d() {
      if (al != 0) {
         new Object().hashCode();
      }

      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.ak);
      this.aj = false;
      this.ag = null;
      super.d();
   }

   private boolean a99() {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      if (a.world != null && a.player != null) {
         List var1 = a.world.getPlayers();

         for (int var2 = 0; var2 < var1.size(); var2++) {
            AbstractClientPlayerEntity var3 = (AbstractClientPlayerEntity)var1.get(var2);
            if (var3 != a.player && var3.squaredDistanceTo(a.player) < 36.0 && (var3.isRemoved() || var3.isDead() || var3.getHealth() <= 0.0F)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean c99() {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      List var1 = a.world.getPlayers();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         AbstractClientPlayerEntity var3 = (AbstractClientPlayerEntity)var1.get(var2);
         if (var3 != a.player && var3.squaredDistanceTo(a.player) <= 25.0 && a.player.getY() - var3.getY() <= 0.8) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void a() {
      if (al != 0) {
         new Object().hashCode();
      }

      this.aj = false;
      if (a.player != null && a.world != null && a.currentScreen == null) {
         if (this.ab - System.nanoTime() > 25000000L && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
            a.options.attackKey.setPressed(false);
         }

         if (!this.u.f() || GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 1) == 1) {
            this.aj = true;
            if (this.w.f() && a.player.getMainHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
               ItemStack var1 = a.player.getMainHandStack();
               ItemStack var2 = a.player.getOffHandStack();
               boolean var3 = var1.getItem().getComponents().contains(DataComponentTypes.FOOD);
               boolean var4 = var2.getItem().getComponents().contains(DataComponentTypes.FOOD);
               boolean var5 = var3 || var4 || a.player.isUsingItem() && a.player.getActiveItem().isOf(Items.EXPERIENCE_BOTTLE);
               if (!var5 && this.c99()) {
                  boolean var6 = false;
                  if (a.crosshairTarget instanceof EntityHitResult var7 && var7.getEntity() instanceof EndCrystalEntity) {
                     var6 = true;
                  }

                  boolean var10 = false;
                  if (a.crosshairTarget instanceof BlockHitResult var11
                     && (a.world.getBlockState(var11.getBlockPos()).isOf(Blocks.OBSIDIAN) || a.world.getBlockState(var11.getBlockPos()).isOf(Blocks.BEDROCK))) {
                     var10 = true;
                  }

                  if ((var6 || var10) && !a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
                     for (int var12 = 0; var12 < 9; var12++) {
                        ItemStack var13 = a.player.getInventory().getStack(var12);
                        if (var13.isOf(Items.END_CRYSTAL)) {
                           if (FrameClockCache.i(a.player)) {
                              InitExecutor.a(a.player.getInventory(), var12);
                           } else {
                              this.k99();
                           }
                           break;
                        }
                     }
                  }
               }
            }

            this.g(a.crosshairTarget, true);
         }
      }
   }

   private void f99() {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (this.aj) {
         long var1 = System.nanoTime();
         if (var1 - this.ab >= 0L || var1 - this.ac >= 0L) {
            if (a.player != null
               && a.world != null
               && a.interactionManager != null
               && a.currentScreen == null
               && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
               if ((!this.u.f() || GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 1) == 1) && (!this.t.f() || !this.a99())) {
                  this.g(a.player.getCrosshairTarget(1.0F, a.player), false);
               }
            }
         }
      }
   }

   private void g(HitResult var1, boolean var2) {
      if (al != 0) {
         new Object().hashCode();
      }

      if (FrameClockCache.n) {
         ItemStack var3 = a.player.getMainHandStack();
         if (var3.isOf(Items.END_CRYSTAL) && (!this.t.f() || !this.a99())) {
            long var4 = System.nanoTime();
            boolean var6 = this.j99();
            if (var1 instanceof EntityHitResult var7 && var7.getEntity() instanceof EndCrystalEntity var8) {
               this.h(var8);
               if (!var6 && var4 - this.ac >= 0L && (var8 != this.ag || var4 - this.ah >= 50000000L)) {
                  this.ac = i(this.ac, var4) + this.s.ns();
                  this.ag = var8;
                  this.ah = var4;
                  a.interactionManager.attackEntity(a.player, var8);
                  a.player.swingHand(Hand.MAIN_HAND);
               }
            }

            if (!var6 && var1 instanceof BlockHitResult var11) {
               BlockPos var12 = var11.getBlockPos();
               boolean var13 = NodeKeeper.b(var12);
               if (var4 - this.ab < 0L || !var13 || !this.af && var4 - this.ae < 50000000L && var12.equals(this.ad)) {
                  if (var2 && (this.ab - var4 > 25000000L || !var13) && this.x.f() && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
                     a.interactionManager.attackBlock(var12, var11.getSide());
                     a.player.swingHand(Hand.MAIN_HAND);
                     if (Math.random() < 0.6) {
                        a.particleManager
                           .addParticle(
                              new BlockStateParticleEffect(ParticleTypes.BLOCK, a.world.getBlockState(var12)),
                              var12.getX() + 0.5,
                              var12.getY() + 0.5,
                              var12.getZ() + 0.5,
                              0.0,
                              0.0,
                              0.0
                           );
                     }

                     a.interactionManager.updateBlockBreakingProgress(var12, var11.getSide());
                  }
               } else {
                  this.ab = i(this.ab, var4) + this.r.ns();
                  this.ad = var12;
                  this.ae = var4;
                  this.af = false;
                  ActionResult var10 = a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var11);
                  if (var10.isAccepted()) {
                     a.player.swingHand(Hand.MAIN_HAND);
                  }
               }
            }
         }
      }
   }

   private void h(Entity var1) {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      BlockPos var2 = this.ad;
      if (var2 != null && var1 instanceof EndCrystalEntity) {
         BlockPos var3 = var1.getBlockPos();
         if (var3.getX() == var2.getX() && var3.getY() == var2.getY() + 1 && var3.getZ() == var2.getZ()) {
            this.af = true;
         }
      }
   }

   private static long i(long var0, long var2) {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      return var2 - var0 <= 60000000L ? var0 : var2;
   }

   private boolean j99() {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return FrameClockCache.k(a.player) && a.player.age != this.ai + 1;
   }

   private void k99() {
      if (al != 0) {
         new Object().hashCode();
      }

      FrameClockCache.j(a.player);
      this.ai = a.player.age;
   }

   @Override
   public void e() {
      if (al != 0) {
         System.nanoTime();
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (al != 0) {
         new Object().hashCode();
      }

      return super.f;
   }

   @Override
   public String g() {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.g();
   }

   @Override
   public String h() {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (al != 0) {
         new Object().hashCode();
      }

      return super.i();
   }

   @Override
   public int j() {
      if (al != 0) {
         System.nanoTime();
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (al != 0) {
         new Object().hashCode();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (al != 0) {
         new Object().hashCode();
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (al != 0) {
         System.nanoTime();
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      super.a(var1);
   }
}
