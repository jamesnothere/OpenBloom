package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import org.lwjgl.glfw.GLFW;

public final class CoreCacheKeeper extends BuilderFactory implements CalculateRange, InitNotifier {
   private final PlacementEntry g99;
   private final BlockCalculator h;
   private long i99;
   private long j;
   public static volatile boolean ON;
   private static int k99 = 0;

   public CoreCacheKeeper() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'笘', '筀', '篬', '節', '箠', '箙', '籰', '簈', '簈', '簖', '糱', '糍', '粮', '粋', '絻', '絅', '絍'},
         -868779185,
         new char[]{
            '큾',
            '큣',
            '퀀',
            '탪',
            '탉',
            '킬',
            '킛',
            '턧',
            '텇',
            '텥',
            '턇',
            '퇱',
            '퇛',
            '톲',
            '톔',
            '톞',
            '퉲',
            '툝',
            '툹',
            '툍',
            '틿',
            '틋',
            '튡',
            '틗',
            '퍢',
            '퍜',
            '팷',
            '팘',
            '펲',
            '폆',
            '편',
            '펆',
            '푢',
            '푈',
            '푬',
            '퐒',
            '퓥',
            '퓜',
            '퓨',
            '풏',
            '합',
            '핉',
            '픠',
            '핃',
            '헰',
            '허',
            '햧',
            '햷',
            '햊',
            '혰',
            '홟',
            '혷',
            '혓',
            '훺',
            '훓',
            '훻',
            '훖',
            '흴',
            '흚',
            '휷',
            '흒',
            'ퟲ',
            'ퟜ',
            '\ud7aa',
            '힏',
            '\ud87f',
            '\ud85f',
            '\ud86b',
            '\ud80b',
            '\ud8a9',
            '\ud8cb',
            '\ud8b5',
            '\ud89f',
            '\ud976',
            '\ud950',
            '\ud922',
            '\ud90e',
            '\ud9a1',
            '\ud9d9',
            '\ud9d0',
            '\ud9ab',
            '\ud9dd',
            '\uda7e',
            '\uda49',
            '\uda3f',
            '\uda18',
            '\udaf3',
            '\uda97',
            '\udab7',
            '\uda81',
            '\udb34',
            '\udb5c',
            '\udb3c',
            '\udb12',
            '\udbf5'
         },
         155897902
      );
      PlacementEntry var10001 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var10001.n(
         new char[]{'휚', '흖', 'ퟻ', 'ퟟ', 'ힶ', '힟', '\ud833', '\ud861', '\ud838', '\ud81d', '\ud8fa', '\ud8c2', '\ud8ac', '\ud898', '\ud962', '\ud945', '\ud927'},
         1660278617
      );
      this.g99 = var10001;
      BlockCalculator var1 = new BlockCalculator("", 0.0, 500.0, 0.0, 1.0);
      var1.n(new char[]{'㍅', '㌞', '㌦', '㌃', '㏤', '㏂', '㎬', '㏊', '㑆', '㑎', '㐡', '㐕', '㓠', '㓐'}, -560712943);
      this.h = var1;
      this.i99 = Long.MIN_VALUE;
      this.j = 0L;
      this.a(this.g99, this.h);
   }

   @Override
   public void c() {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      ON = true;
      this.b.a(CalculateRange.class, this);
      this.b.a(InitNotifier.class, this);
      this.i99 = Long.MIN_VALUE;
      this.j = 0L;
      super.c();
   }

   @Override
   public void d() {
      if (k99 != 0) {
         System.nanoTime();
      }

      ON = false;
      this.b.b(CalculateRange.class, this);
      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a(BufferEncoder var1) {
      if (k99 != 0) {
         new Object().hashCode();
      }

      BlockHitResult var2 = this.a99();
      if (var2 != null) {
         if (this.b()) {
            var1.b();
            this.c(var2);
         } else if (a.world != null && a.world.getTime() == this.i99) {
            var1.b();
         }
      }
   }

   @Override
   public void a() {
      if (k99 != 0) {
         new Object().hashCode();
      }

      if (GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 1) == 1) {
         BlockHitResult var1 = this.a99();
         if (var1 != null && this.b()) {
            this.c(var1);
         }
      }
   }

   private BlockHitResult a99() {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (a.player != null && a.crosshairTarget != null && a.currentScreen == null) {
         if (!a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
            return null;
         }

         if (a.crosshairTarget.getType() != Type.BLOCK) {
            return null;
         }

         BlockHitResult var1 = (BlockHitResult)a.crosshairTarget;
         boolean var2 = TaskJoiner.a(var1.getBlockPos(), Blocks.OBSIDIAN) || TaskJoiner.a(var1.getBlockPos(), Blocks.BEDROCK);
         return var2 && NodeKeeper.a(var1.getBlockPos()) ? var1 : null;
      } else {
         return null;
      }
   }

   private boolean b() {
      if (k99 != 0) {
         System.nanoTime();
      }

      if (a.world == null) {
         return false;
      }

      if (a.world.getTime() == this.i99) {
         return false;
      }

      double var1 = this.h.p();
      return !(var1 > 0.0) || System.nanoTime() - this.j >= var1 * 1000000.0;
   }

   private void c(BlockHitResult var1) {
      if (k99 != 0) {
         new Object().hashCode();
      }

      GridResolver.a(var1, true);
      this.i99 = a.world != null ? a.world.getTime() : this.i99;
      this.j = System.nanoTime();
   }

   public static void d(Entity var0) {
      if (k99 != 0) {
         Thread.currentThread().getName().length();
      }

      if (var0 instanceof EndCrystalEntity var1 && a.player != null) {
         if (e99()) {
            var1.discard();
            var1.setRemoved(RemovalReason.KILLED);
            var1.onRemoved();
         }
      }
   }

   private static boolean e99() {
      if (k99 != 0) {
         Thread.currentThread().getName().length();
      }

      StatusEffectInstance var0 = a.player.getStatusEffect(StatusEffects.WEAKNESS);
      StatusEffectInstance var1 = a.player.getStatusEffect(StatusEffects.STRENGTH);
      return var0 == null || var1 != null && var1.getAmplifier() > var0.getAmplifier() || f(a.player.getMainHandStack().getItem());
   }

   private static boolean f(Item var0) {
      if (k99 != 0) {
         System.nanoTime();
      }

      return var0 == Items.DIAMOND_SWORD
         || var0 == Items.DIAMOND_PICKAXE
         || var0 == Items.DIAMOND_AXE
         || var0 == Items.DIAMOND_SHOVEL
         || var0 == Items.DIAMOND_HOE
         || var0 == Items.NETHERITE_SWORD
         || var0 == Items.NETHERITE_PICKAXE
         || var0 == Items.NETHERITE_AXE
         || var0 == Items.NETHERITE_SHOVEL
         || var0 == Items.NETHERITE_HOE;
   }

   @Override
   public void e() {
      if (k99 != 0) {
         new Object().hashCode();
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (k99 != 0) {
         new Object().hashCode();
      }

      return super.f;
   }

   @Override
   public String g() {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.g();
   }

   @Override
   public String h() {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.i();
   }

   @Override
   public int j() {
      if (k99 != 0) {
         new Object().hashCode();
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (k99 != 0) {
         System.nanoTime();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (k99 != 0) {
         new Object().hashCode();
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (k99 != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (k99 != 0) {
         Thread.currentThread().getName().length();
      }

      super.a(var1);
   }
}
