package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MaceItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class EventCycleHandler extends BuilderFactory implements InitNotifier, CoreSerializer {
   private final BlockCalculator q;
   private final SlotEntry r;
   private final PlacementEntry s;
   private final BlockCalculator t;
   private final PlacementEntry u;
   private final PlacementEntry v;
   private final BlockCalculator w;
   private final CheckerBridge x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final BlockCalculator aa;
   private int ab;
   private static final int ac = -2;
   private static final double ad = 1.5;
   private static final int ae = 0;
   private static final int af = 3;
   private static final int ag = 20;
   private int ah;
   private PlayerEntity ai;
   private int aj;
   private int ak;
   private int al;
   private static final int am = 0;
   private static final int an = 3;
   private static final int ao = 4;
   private static final int ap = 11;
   private static final int aq = 12;
   private static final int ar = 13;
   private static final int as = 14;
   private static final int at = 15;
   private static final int au = 16;
   private static final int av = 17;
   private static final int aw = 18;
   private static final int ax = 19;
   private static final int ay = 20;
   private static final String[] az = new String[]{
      StringDecoder.d(new byte[]{-44, -54}, 167)
         + QueryZone.r(new byte[]{38, 35}, 68)
         + QueryZone.r(new byte[]{76, 95, 5}, 117)
         + JoinerWriter.p(new byte[]{38, 18, -52, -21}, 82),
      TokenExtractor.w(new byte[]{32, 45, 99, 110, 107, 108, 42, 75}, 12),
      QueryZone.r(new byte[]{-120, -50, -47}, 171),
      NotifyResolver.q(new byte[]{5}, 118) + YieldKeeper.v(new byte[]{-28, 113, -11}, 136) + QueryZone.r(new byte[]{66, 81, 7, 2, 7, 56, 118, 15}, 123),
      QueryZone.r(new byte[]{101, 100, 57, 49}, 70) + TokenExtractor.w(new byte[]{28, 72, 82, 80, 93, 91, 82, 28}, 63),
      JoinerWriter.p(new byte[]{-63, -56, 18, 6, 6, 1, 7, -2}, 95)
         + NotifyResolver.q(new byte[]{80, 21, 29, 10, 1, 11, 56, 36, 84, 1, 118, 112, -64}, 112)
         + JoinerWriter.p(new byte[]{12, 17, 13, -70}, 99)
         + YieldKeeper.v(new byte[]{-93, -4, 35, 33}, 194),
      NotifyResolver.q(new byte[]{-120, -127, -61}, 168)
         + YieldKeeper.v(new byte[]{-24, 78, -92, 29, 117, -53, 107, -127, -15, 81, -97, 47, -111, -1, 86, -68, 9, 42, -58, 54}, 157)
         + TokenExtractor.w(new byte[]{125, 52}, 31),
      StringDecoder.d(new byte[]{27, 18, 74}, 59)
         + TokenExtractor.w(new byte[]{61, 63, 50, 52, 61, 122, 53, 51, 41, 126, 42, 48, 97, 59, 38, 48, 101, 39, 51, 104, 61, 34, 46, 108}, 80)
         + QueryZone.r(new byte[]{54, 41, 37}, 70)
         + JoinerWriter.p(new byte[]{-68, -86, -74}, 186),
      YieldKeeper.v(new byte[]{-106, 120, 113, -61, 57, 40}, 172),
      QueryZone.r(new byte[]{16, 65, 86, 19, 25, 38, 106}, 103),
      NotifyResolver.q(new byte[]{120}, 85),
      JoinerWriter.p(new byte[]{10, 2, -10, 1, -51, -78, 4, -15, -4, -13, -83, 0, -12, -19}, 105)
         + JoinerWriter.p(new byte[]{-50, -126, -62, -40, -60, -119, -54, -67, -66, -65, 121, -104}, 157),
      JoinerWriter.p(new byte[]{88, 80, 68, 79, 27, 0, 77, 77, -3, 83, 68, 72}, 27)
         + NotifyResolver.q(new byte[]{92, 86, 75, 29, 8, 88, 115, 124, 88, 5, 61, 47, -52, -79, -102, -80, 74, 106, 8, 113, -24}, 56),
      QueryZone.r(new byte[]{-54, -36}, 186)
         + YieldKeeper.v(new byte[]{43, -7, -28, 8, 28, -45, 38, 39, -13, -118, 74, 23, -75, 32, 118, -49, -97, 64, 94, -89, 116, 124}, 74)
         + JoinerWriter.p(new byte[]{8, -6}, 106)
         + JoinerWriter.p(new byte[]{43, 44, 48, -25, 53, 55, -28, 49, 49, -31, 51, 44, 31, 48, 36, -37, 40, 30, 48, 43, -42, 41, 29, 22, 29, -47, -16}, 54),
      TokenExtractor.w(
         new byte[]{
            17, 15, 13, 0, 84, 79, 27, 1, 3, 14, 24, 17, 86, 3, 25, 28, 27, 29, 27, 93, 11, 17, 11, 12, 8, 30, 104, 101, 49, 38, 41, 53, 43, 45, 43, 109, 14
         },
         100
      ),
      NotifyResolver.q(new byte[]{120, 102, 110, 111, 33, 50, 92, 82, 34, 63, 3, 22, -69, -42, -90, -121, 98, 68, 40, 66, -18, -36, -100, 111, 57, 31}, 11)
         + JoinerWriter.p(new byte[]{-16, -29, 48, 48, -32, 54, 39, 43, 32}, 60)
         + StringDecoder.d(new byte[]{46}, 65)
         + StringDecoder.d(new byte[]{110, 56, 119, 127, 123, 104, 63, 94}, 25),
      YieldKeeper.v(
            new byte[]{
               78,
               22,
               -42,
               -103,
               11,
               78,
               -40,
               -128,
               76,
               7,
               -13,
               -72,
               124,
               50,
               -77,
               -78,
               120,
               62,
               -89,
               -86,
               110,
               30,
               26,
               -64,
               -112,
               18,
               6,
               -62,
               -55,
               82,
               11,
               -59,
               -3,
               114,
               56,
               -32
            },
            61
         )
         + QueryZone.r(new byte[]{61, 55, 63, 100, 3}, 92),
      TokenExtractor.w(
         new byte[]{
            75,
            83,
            95,
            80,
            6,
            19,
            94,
            80,
            94,
            83,
            83,
            81,
            20,
            73,
            79,
            79,
            71,
            93,
            75,
            13,
            88,
            75,
            71,
            1,
            77,
            70,
            69,
            64,
            8,
            59,
            121,
            107,
            119,
            108,
            109,
            117,
            125,
            122,
            96,
            49,
            124,
            120,
            101,
            97,
            52,
            35,
            107,
            113,
            109,
            47,
            78
         },
         59
      ),
      NotifyResolver.q(new byte[]{78, 80, 88, 89, 23, 4, 106, 100, 20, 9, 53, 32, -115, -25, -115, -75, 81, 112, 89, 33, -35, -92, -72, 88, 93}, 61)
         + YieldKeeper.v(new byte[]{93, 58, 30, -124, -96, -105, 124, 45, 93, -70, -89, -98}, 41)
         + StringDecoder.d(new byte[]{-52, -46, -47, -59, -61, -122, -115, -59, -45, -49, -119, -24}, 163),
      StringDecoder.d(new byte[]{80, 78}, 35)
         + StringDecoder.d(
            new byte[]{
               25,
               20,
               64,
               91,
               24,
               15,
               17,
               15,
               0,
               20,
               22,
               73,
               84,
               17,
               31,
               18,
               12,
               69,
               74,
               24,
               15,
               31,
               11,
               10,
               14,
               77,
               66,
               23,
               5,
               23,
               1,
               2,
               44,
               121,
               61,
               52,
               50,
               56,
               126,
               48,
               34,
               113,
               60,
               60,
               116,
               56,
               55,
               52,
               45,
               105,
               98,
               42,
               52,
               40,
               110,
               15
            },
            120
         ),
      JoinerWriter.p(new byte[]{57, 49, 37, 48, -4, -31, 35, 49, 45, 48, 47, 35, 27, 34, 42, -41}, 58)
         + TokenExtractor.w(new byte[]{117, 117, 104, 104, 49, 62, 120, 113}, 24)
         + TokenExtractor.w(new byte[]{107, 123, 63, 109, 105, 58, 51}, 28)
         + YieldKeeper.v(new byte[]{9, -88, 93, -128, 72}, 104),
      YieldKeeper.v(new byte[]{-107, 82, 69, -117, -22, 118, 79}, 185),
      StringDecoder.d(new byte[]{74}, 99),
      YieldKeeper.v(new byte[]{-80, -95}, 196),
      NotifyResolver.q(new byte[]{-125, -118, -46, -39, -42, -102}, 163)
   };
   private boolean ba;
   private Object bb;
   private static int bc = 0;

   public EventCycleHandler() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'⩓', '⨱', '⩊', '⨨', '⨒', '⪻', '⫩', '⪵', '⪙', '⭺'},
         1026828800,
         new char[]{
            'ẉ',
            'ỉ',
            'έ',
            'ὑ',
            'Ἣ',
            'Ἆ',
            'ΰ',
            '\u1fd5',
            'ᾩ',
            'ᾼ',
            'ᾟ',
            'ⁱ',
            '⁐',
            '•',
            '⁚',
            '\u20f8',
            '⃀',
            '₲',
            '⃖',
            'ⅴ',
            '⅚',
            'ℷ',
            '⅒',
            '⇼',
            '⇑',
            '↬',
            '↋',
            '∭',
            '≟',
            '∣',
            '∃',
            '⋬',
            '⋄',
            '⊣',
            '⊃',
            '⍡',
            '⌄',
            '⌳',
            '⌎',
            '⏠',
            '⏙',
            '⏚',
            '⎬',
            '⎎'
         },
         302522056
      );
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 10.0, 1.5, 0.1);
      var10001.n(new char[]{'䈀', '䈅', '䋥', '䊄', '䋩', '䊠', '䍢', '䍏', '䌢', '䌌', '䏷'}, 310395469);
      this.q = var10001;
      this.r = new SlotEntry(
         QueryZone.r(new byte[]{37, 79, 27, 16, 17, 109, 22, 45}, 107)
            + YieldKeeper.v(new byte[]{60}, 85)
            + JoinerWriter.p(new byte[]{75, 77, 67}, 36)
            + QueryZone.r(new byte[]{-73, -77}, 192),
         QueryZone.r(new byte[]{105, 15, 79, 71, 91}, 43),
         NotifyResolver.q(new byte[]{15, 97, 63, 51, 49}, 78),
         NotifyResolver.q(new byte[]{68, 60, 126, 116, 103}, 19),
         StringDecoder.d(new byte[]{1, 108, 51, 37, 38, 37, 45}, 67)
      );
      var10001 = new PlacementEntry("", 1.0, 10.0, 5.0, 1.0);
      var10001.n(new char[]{'♦', '♺', '☄', '⛳', '⛁', '⛰', '⚼', '❾', '❈', '✩', '✏', '➪', '➁', '➽', '➉', '⡳', '⡖', '⠡', '⠇', '⢫'}, 1074472501);
      this.s = (PlacementEntry)var10001;
      var10001 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var10001.n(new char[]{'쐶', '쒿', '쓕', '쒣', '쒏', '앴'}, -358693774);
      this.t = var10001;
      var10001 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var10001.n(new char[]{'海', '福', '蘒', '度', '\ufafb', '㮝', '瘝', '𢡊', 'ﬦ', 'ﭘ', 'ﬢ', 'ﬞ', 'ﯹ', '\ufbcc', 'ﮬ', '\ufbce'}, -569050602);
      this.u = (PlacementEntry)var10001;
      var10001 = new PlacementEntry("", 1.0, 180.0, 60.0, 1.0);
      var10001.n(new char[]{'\ue362', '\ue36d', '\ue32d', '\ue3d7'}, -1767775452);
      this.v = (PlacementEntry)var10001;
      var10001 = new BlockCalculator("", 1.0, 6.0, 4.5, 0.1);
      var10001.n(new char[]{'멄', '먛', '먱', '먒', '뫱', '뫙'}, 2132458006);
      this.w = var10001;
      CheckerBridge var6 = new CheckerBridge("", false);
      var6.n(new char[]{'塩', '塷', '堙', '壺', '壓', '壵', '墠', '奺', '契', '夺'}, 1132550202);
      this.x = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'㮓', '㯘', '㱰', '㱖', '㰦', '㰕'}, 1233796055);
      this.y = var7;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'䀼', '䂳', '䃎', '䂾', '䂛', '䅺', '䅐', '䅷', '䄴', '䇰', '䇘', '䆼', '䆅'}, 678051966);
      this.z = var8;
      var10001 = new BlockCalculator("", 0.0, 30.0, 8.0, 0.5);
      var10001.n(new char[]{'ሣ', 'ኮ', 'ይ', 'ዛ', 'ኼ', 'ኟ', '፳', 'ጚ', 'ጟ', 'ጙ', 'ᏻ', 'Ꮪ', 'Ᏽ', 'Ꮀ', 'ᑺ', 'ᑁ', 'ᐥ', 'ᐑ', 'ᓡ', 'ᓍ', 'ᒨ'}, 1127944801);
      this.aa = var10001;
      this.ab = 0;
      this.ah = 0;
      this.ai = null;
      this.aj = 0;
      this.ak = 0;
      this.al = -1;
      this.ba = false;
      this.bb = null;
      this.a(this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.aa);
   }

   @Override
   public void c() {
      if (bc != 0) {
         System.nanoTime();
      }

      super.c();
      this.b.a(InitNotifier.class, this, -2);
      this.b.a(CoreSerializer.class, this, -2);
      this.ab = 0;
      this.j99();
      InitExecutor.u = true;
   }

   @Override
   public void d() {
      byte var1 = 0;

      label17:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (bc != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               super.d();
               this.b.b(InitNotifier.class, this);
               this.b.b(CoreSerializer.class, this);
               InitExecutor.u = false;
               if (InitExecutor.m == 2) {
                  InitExecutor.m = 0;
                  InitExecutor.n = null;
                  var1 = 2;
                  break;
               }
            case 2:
               break label17;
         }
      }

      this.j99();
   }

   @Override
   public void a() {
      if (bc != 0) {
         new Object().hashCode();
      }

      if (a.player != null && a.world != null && a.interactionManager != null) {
         if (this.bb != a.player) {
            this.j99();
            this.bb = a.player;
            if (InitExecutor.n != null && InitExecutor.n != a.player) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }

         int var1 = a.player.age;
         InitExecutor.k(a);
         boolean var2 = a.player.isOnGround() || a.player.isTouchingWater();
         if (var2 || a.player.fallDistance < this.q.p()) {
            this.ba = false;
         }

         if (var2) {
            this.al = -1;
         }

         boolean var3 = false;
         if (this.ah == 0 && this.ab > 0) {
            this.ab--;
            var3 = true;
         }

         boolean var4 = !a.player.isAlive();
         if (!var2 && !var4 && a.currentScreen == null) {
            if (a.player.isGliding() && this.ah == 0 && InitExecutor.m == 2) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }

            if (this.ah != 0 && this.ai != null) {
               InitExecutor.r = var1;
               InitExecutor.s = var1;
               if (!this.g(var1)) {
                  this.e(var1);
               }
            } else if (!var3 && !this.ba && !a.player.isGliding() && !a.player.isUsingItem() && !a.player.hasVehicle()) {
               double var5 = a.player.fallDistance;
               double var7 = a.player.getVelocity().y;
               double var9 = var7 < 0.0 ? var5 - var7 : var5;
               if (!(var9 < this.q.p()) && var9 > 1.5) {
                  PlayerInventory var14 = a.player.getInventory();
                  int var12 = this.k(var14);
                  if (var12 != -1) {
                     InitExecutor.r = var1;
                     InitExecutor.s = var1;
                     PlayerEntity var13 = this.n99();
                     if (var13 != null) {
                        this.a(var13, var14, var12, var1);
                     }
                  }
               } else {
                  double var11 = Math.max(this.q.p(), 1.5) + 0.05 - var5 - (var7 > 0.0 ? this.d(var7) : 0.0);
                  if ((var11 <= 0.0 || a.world.isSpaceEmpty(a.player, a.player.getBoundingBox().stretch(0.0, -var11, 0.0)))
                     && this.k(a.player.getInventory()) != -1) {
                     InitExecutor.s = var1;
                  }
               }
            }
         } else {
            if (this.ah != 0) {
               this.f(var2 ? 17 : 19, var1);
               this.i99();
            }

            if ((var2 || var4) && InitExecutor.m == 2) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }
      } else {
         if (a.player == null) {
            if (this.bb != null) {
               this.j99();
               InitExecutor.j();
            }

            if (InitExecutor.n != null) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }
      }
   }

   private boolean a(PlayerEntity var1, PlayerInventory var2, int var3, int var4) {
      if (bc != 0) {
         System.nanoTime();
      }

      double var5 = a.player.fallDistance;
      boolean var7 = var5 >= this.q.p() && var5 > 1.5;
      boolean var8 = InitExecutor.a(var1);
      int var9 = var8 ? InitExecutor.d(var1, a.player, 0) : 0;
      if (var9 < 2) {
         if (!var7) {
            return false;
         }

         if (!var8) {
            int var12 = InitExecutor.n == a.player ? InitExecutor.m : 0;
            if (var12 == 3 || var12 == 1) {
               return false;
            }

            if (var12 == 0 && InitExecutor.t && (InitExecutor.q == var4 || InitExecutor.q == var4 - 1)) {
               return false;
            }
         }

         if (this.g(var4)) {
            return false;
         }

         this.b(var1);
         InitExecutor.a(var2, var3);
         this.h99();
         InitExecutor.i(var1, a.player);
         this.f(var8 ? 3 : 4, var4);
         this.i99();
         return true;
      } else {
         int var10 = this.m(AxeItem.class);
         if (var10 == -1) {
            this.f(16, var4);
            return false;
         }

         if (this.g(var4)) {
            return false;
         }

         if (this.x.f() && var7) {
            this.b(var1);
            InitExecutor.a(var2, var10);
            this.h99();
            if (var9 == 3) {
               InitExecutor.e(var1, a.player);
            }

            InitExecutor.a(var2, var3);
            this.h99();
            this.f(11, var4);
            this.i99();
            return true;
         } else if (var9 == 2) {
            if (this.y.f()) {
               int var13 = Math.max(1, InitExecutor.z - InitExecutor.w - InitExecutor.x);
               this.f(this.c(var1, var13 + 1) == 0 ? 14 : 15, var4);
            }

            return false;
         } else {
            int var11 = this.c(var1, 1);
            if (var11 != 0) {
               this.f(var11 == 1 ? 12 : 13, var4);
               return false;
            } else {
               this.b(var1);
               InitExecutor.a(var2, var10);
               this.h99();
               InitExecutor.e(var1, a.player);
               this.ak = var4;
               this.aj = 20;
               this.ah = 3;
               return true;
            }
         }
      }
   }

   private void b(PlayerEntity var1) {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      InitExecutor.m = 2;
      InitExecutor.n = a.player;
      this.ai = var1;
   }

   private int c(PlayerEntity var1, int var2) {
      if (bc != 0) {
         new Object().hashCode();
      }

      double var3 = a.player.getFinalGravity();
      Vec3d var5 = a.player.getVelocity();
      double var6 = var5.x;
      double var8 = var5.y;
      double var10 = var5.z;
      Box var12 = a.player.getBoundingBox();
      double var13 = 0.0;
      double var15 = 0.0;
      double var17 = 0.0;
      double var19 = a.player.fallDistance;

      for (int var21 = 0; var21 < var2; var21++) {
         if (var8 < 0.0 && !a.world.isSpaceEmpty(a.player, var12.offset(0.0, var15, 0.0).stretch(0.0, var8, 0.0), true)) {
            return 1;
         }

         var13 += var6;
         var15 += var8;
         var17 += var10;
         if (var8 < 0.0) {
            var19 -= var8;
         }

         var6 *= 0.91;
         var10 *= 0.91;
         var8 = (var8 - var3) * 0.98;
      }

      if (!(var19 < this.q.p()) && var19 > 1.5) {
         Vec3d var43 = a.player.getEyePos();
         double var22 = var43.x + var13;
         double var24 = var43.y + var15;
         double var26 = var43.z + var17;
         Box var28 = var1.getBoundingBox();
         double var29 = (var1.getX() - var1.lastX) * var2;
         double var31 = (var1.getY() - var1.lastY) * var2;
         double var33 = (var1.getZ() - var1.lastZ) * var2;
         double var35 = MathHelper.clamp(var22, var28.minX + var29, var28.maxX + var29) - var22;
         double var37 = MathHelper.clamp(var24, var28.minY + var31, var28.maxY + var31) - var24;
         double var39 = MathHelper.clamp(var26, var28.minZ + var33, var28.maxZ + var33) - var26;
         double var41 = Math.min(this.w.p(), a.player.getEntityInteractionRange());
         return var35 * var35 + var37 * var37 + var39 * var39 <= var41 * var41 ? 0 : 2;
      } else {
         return 2;
      }
   }

   private double d(double var1) {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      double var3 = a.player.getFinalGravity();
      double var5 = 0.0;

      for (int var7 = 0; var7 < 100 && var1 > 0.0; var7++) {
         var5 += var1;
         var1 = (var1 - var3) * 0.98;
      }

      return var5;
   }

   private boolean e(int var1) {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      PlayerEntity var2 = this.ai;
      PlayerInventory var3 = a.player.getInventory();
      int var4 = this.k(var3);
      if (var4 != -1 && var2.isAlive() && !var2.isRemoved()) {
         if (InitExecutor.a(var2) && InitExecutor.d(var2, a.player, 0) >= 2) {
            this.f(18, var1);
            this.i99();
            return false;
         }

         if (!a.player.isUsingItem() && !a.player.isGliding() && InitExecutor.c(a, var2, this.w.p())) {
            InitExecutor.a(var3, var4);
            this.h99();
            this.f(0, var1);
            this.i99();
            return true;
         }

         if (--this.aj < 0) {
            this.f(20, var1);
            this.i99();
         }

         return false;
      } else {
         this.f(19, var1);
         this.i99();
         return false;
      }
   }

   private void f(int var1, int var2) {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (this.y.f() && var1 != this.al && a.player != null) {
         this.al = var1;
         String var3;
         if (var1 == 0) {
            var3 = az[0] + this.ak + az[1] + var2 + az[2];
         } else if (var1 == 4) {
            var3 = az[3] + var2 + az[4];
         } else if (var1 == 3) {
            int var4 = InitExecutor.shWhy;
            if (var4 == 1) {
               var3 = az[3] + var2 + az[5];
            } else if (var4 == 2) {
               var3 = az[3] + var2 + az[6];
            } else {
               var3 = az[3] + var2 + az[7] + az[8] + InitExecutor.w + az[9] + InitExecutor.x + az[10] + InitExecutor.y + az[23];
            }
         } else if (var1 == 14 || var1 == 15) {
            var3 = az[var1] + var2 + az[24] + InitExecutor.w + az[9] + InitExecutor.x + az[10] + InitExecutor.y + az[23];
         } else if (var1 >= 17) {
            var3 = az[var1] + this.ak + az[21] + var2 + az[22];
         } else {
            var3 = az[var1] + var2;
         }

         a.player.sendMessage(Text.literal(var3), false);
      }
   }

   @Override
   public void a(LinkerFactory var1) {
      if (bc != 0) {
         System.nanoTime();
      }

      if (a.player != null && InitExecutor.p == a.player.age) {
         var1.b();
      }
   }

   private boolean g(int var1) {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      return InitExecutor.o == var1 || InitExecutor.p == var1 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private void h99() {
      if (bc != 0) {
         System.nanoTime();
      }

      a.interactionManager.attackEntity(a.player, this.ai);
      a.player.swingHand(Hand.MAIN_HAND);
      InitExecutor.p = a.player.age;
      if (a.player.getMainHandStack().getItem() instanceof MaceItem) {
         this.ba = true;
      }
   }

   private void i99() {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.ah = 0;
      this.ai = null;
      this.ab = this.t.g();
   }

   private void j99() {
      if (bc != 0) {
         System.nanoTime();
      }

      this.ah = 0;
      this.ai = null;
      this.aj = 0;
      this.ba = false;
      this.bb = null;
      InitExecutor.r = -169422914 ^ 1978060734;
      InitExecutor.s = -1161570657 ^ 985912991;
      this.al = -1;
   }

   private int k(PlayerInventory var1) {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var2 = this.r.g().indexOf(this.r.f());
      if (var2 != 1 && var2 != 2 && this.z.f()) {
         return a.player.fallDistance < this.aa.p()
            ? InitExecutor.g(var1, Enchantments.BREACH, null)
            : InitExecutor.g(var1, Enchantments.DENSITY, Enchantments.BREACH);
      }

      int var3 = -1;

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = var1.getStack(var4);
         if (var5.getItem() instanceof MaceItem) {
            if (var2 != 1 && var2 != 2) {
               return var4;
            }

            if (var3 == -1) {
               var3 = var4;
            }

            if (l(var5, var2 == 1 ? Enchantments.WIND_BURST : Enchantments.BREACH)) {
               return var4;
            }
         }
      }

      return var3;
   }

   private static boolean l(ItemStack var0, RegistryKey<Enchantment> var1) {
      if (bc != 0) {
         System.nanoTime();
      }

      for (RegistryEntry var3 : var0.getEnchantments().getEnchantments()) {
         if (var3.matchesKey(var1)) {
            return true;
         }
      }

      return false;
   }

   private int m(Class<?> var1) {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      for (int var2 = 0; var2 < 9; var2++) {
         ItemStack var3 = a.player.getInventory().getStack(var2);
         if (var1.isInstance(var3.getItem())) {
            return var2;
         }
      }

      return -1;
   }

   private PlayerEntity n99() {
      if (bc != 0) {
         System.nanoTime();
      }

      return InitExecutor.b(a, this.w.p()) instanceof PlayerEntity var2 && this.o(var2) ? var2 : null;
   }

   private boolean o(PlayerEntity var1) {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      if (var1 == null || var1 == a.player) {
         return false;
      } else {
         return !var1.isDead() && !var1.isRemoved() ? !var1.isCreative() && !var1.isSpectator() : false;
      }
   }

   @Override
   public void e() {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.f;
   }

   @Override
   public String g() {
      if (bc != 0) {
         new Object().hashCode();
      }

      return super.g();
   }

   @Override
   public String h() {
      if (bc != 0) {
         System.nanoTime();
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (bc != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.i();
   }

   @Override
   public int j() {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (bc != 0) {
         Thread.currentThread().getName().length();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (bc != 0) {
         new Object().hashCode();
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (bc != 0) {
         new Object().hashCode();
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (bc != 0) {
         System.nanoTime();
      }

      super.a(var1);
   }
}
