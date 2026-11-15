package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

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
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BevelPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public final class ViewCacheIndex extends BuilderFactory implements InitNotifier {
   private static final String[] c99 = new String[]{
      TokenExtractor.w(new byte[]{84, 55, 119, 113, 123}, 27),
      NotifyResolver.q(new byte[]{-60, -87, -9, -5, -30, -6, -48, -47, -86, -82, -62}, 134)
         + NotifyResolver.q(new byte[]{-4, -40, -38}, 183)
         + YieldKeeper.v(new byte[]{-57, 39}, 161),
      JoinerWriter.p(new byte[]{-10, -40, 10}, 85) + StringDecoder.d(new byte[]{-40, -54, -59, -53, -57, -37}, 170),
      TokenExtractor.w(new byte[]{121, 27, 65, 89, 87, 80}, 49),
      TokenExtractor.w(new byte[]{3, 110, 34, 59, 34, 34, 42, 58}, 69),
      NotifyResolver.q(new byte[]{57, 66, 8, 8, 18, 26}, 109),
      YieldKeeper.v(new byte[]{-21, 110, -127, -12, 65, -82, 1}, 160)
   };
   private static final String[] d99 = new String[]{
      YieldKeeper.v(new byte[]{-125, -114, 7, 47, 98, -124, -61}, 208),
      TokenExtractor.w(new byte[]{120, 4, 90}, 41) + NotifyResolver.q(new byte[]{72, 84, 71, 93, 23, 24, 35, 87, 31, 19, 48}, 39),
      QueryZone.r(new byte[]{-103, -23, -71, -76, -94, -124, -114, -118}, 205),
      QueryZone.r(new byte[]{22}, 84)
         + TokenExtractor.w(new byte[]{60, 127, 105}, 19)
         + StringDecoder.d(new byte[]{61}, 29)
         + JoinerWriter.p(new byte[]{16, 58, 42, 49}, 57)
   };
   private static final String[] e = new String[]{
      TokenExtractor.w(new byte[]{-62, -68, -25, -15, -16, -6}, 152),
      NotifyResolver.q(new byte[]{6, 111, 37, 45, 53}, 64),
      QueryZone.r(new byte[]{85, 54, 108, 122, 125, 88, 90, 84}, 18),
      NotifyResolver.q(new byte[]{35, 88, 26, 25, 2, 28, 115}, 119) + StringDecoder.d(new byte[]{65}, 21) + JoinerWriter.p(new byte[]{78, 77, 81, 68}, 33),
      YieldKeeper.v(new byte[]{-48, 8, -53, 37, -78, 1, 106, -10}, 147),
      JoinerWriter.p(new byte[]{-107, 109, -86, -79, -82, -100}, 192)
         + StringDecoder.d(new byte[]{64, 94, 91}, 54)
         + NotifyResolver.q(new byte[]{52, 60, 40}, 88),
      YieldKeeper.v(new byte[]{-38, 50, -62, 93, -85, 49}, 142)
   };
   private static final String[] f99 = new String[]{
      JoinerWriter.p(new byte[]{62, 20, 77, 77, 87, 71}, 25),
      NotifyResolver.q(new byte[]{78, 53, 118, 118, 103, 102}, 26),
      JoinerWriter.p(new byte[]{55, 34, 95, 103, 86}, 11),
      StringDecoder.d(new byte[]{-11, -118, -46, -44, -47, -52, -58}, 165),
      TokenExtractor.w(new byte[]{78, 49, 123, 125}, 29)
   };
   private static final String[] g99 = new String[]{
      StringDecoder.d(new byte[]{-20, -115, -49, -45, -53, -58, -56}, 162),
      YieldKeeper.v(new byte[]{54, -52, 63, -85, 66}, 113),
      TokenExtractor.w(new byte[]{-58, -95, -27, -23, -18, -18, -26}, 134)
   };
   private static final String[] h = new String[]{
      QueryZone.r(new byte[]{35, 70, 31, 15, 24}, 98),
      QueryZone.r(new byte[]{52, 71, 26, 30, 17, 32}, 99),
      NotifyResolver.q(new byte[]{-46, -83, -13, -7, -30, -9, -61}, 130),
      QueryZone.r(new byte[]{96, 21, 69, 77}, 49),
      YieldKeeper.v(new byte[]{-22, 84, 95, -99, -59, 11}, 189)
   };
   private static final String[] i99 = new String[]{
      YieldKeeper.v(new byte[]{53, -40, 16, -104, 18, -112, 60, -76}, 123),
      NotifyResolver.q(new byte[]{26, 115, 55, 39, 59, 36, 10, 9}, 92),
      QueryZone.r(new byte[]{59, 80, 10, 27}, 116),
      NotifyResolver.q(new byte[]{116, 9, 71, 89, 83, 77, 113, 114}, 38),
      TokenExtractor.w(new byte[]{-100, -25, -93, -89, -96, -80, -78}, 196)
   };
   private static final String[] j = new String[]{
      QueryZone.r(new byte[]{-62, -90, -22, -7, -15, -63}, 130), TokenExtractor.w(new byte[]{98, 25, 87, 91, 80, 84, 87}, 51)
   };
   private static final int[] k99 = new int[]{16777215, -1, 5219071, 11697151, 16730714};
   private static final int[] l99 = new int[]{3046399, -1, 9063423, 15214650, 14542578};
   private static final int[] m99 = new int[]{8845055, -1, 14528767, 16752800, 16777215};
   private final ItemDescriptor n99;
   private final SlotEntry o99;
   private final SlotEntry p;
   private final SlotEntry q;
   private final CheckerBridge r;
   private final CheckerBridge s;
   private final SlotEntry t;
   private final BlockCalculator u;
   private final SlotEntry v;
   private final SlotEntry w;
   private final BlockCalculator x;
   private final CheckerBridge y;
   private final BlockCalculator z;
   private final SlotEntry aa;
   private final BlockCalculator ab;
   private final CheckerBridge ac;
   private final BlockCalculator ad;
   private final CheckerBridge ae;
   private final SlotEntry af;
   private static int ag = 0;

   public ViewCacheIndex() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'蕢', '蕤', '蔝', '藭', '藊', '藦', '薬', '虪', '虐', '蘲', '蘄', '蛣', '蛫'},
         1061913899,
         new char[]{
            '쾛',
            '쿟',
            '큾',
            '큜',
            '퀾',
            '퀈',
            '탯',
            '탟',
            '탪',
            '킐',
            '텧',
            '텒',
            '턴',
            '텅',
            '퇬',
            '퇆',
            '톮',
            '톅',
            '툠',
            '퉶',
            '퉊',
            '툸',
            '툑',
            '튻',
            '틖',
            '튰',
            '튓',
            '퍲',
            '팖',
            '팖',
            '팧',
            '펡',
            '펈',
            '폱',
            '펛',
            '푡',
            '푇',
            '퐫',
            '퐉',
            '풫',
            '퓙',
            '풢',
            '풁',
            '합',
            '핕',
            '합',
            '필',
            '헥',
            '헋',
            '햯',
            '행',
            '햌',
            '홶',
            '환',
            '혯',
            '홗',
            '횺',
            '훞',
            '횴',
            '횘',
            '흡',
            '휕',
            '휵',
            '휝',
            'ퟶ',
            '힑',
            'ힱ',
            'ퟏ',
            '\ud869',
            '\ud841',
            '\ud823',
            '\ud81c',
            '\ud8e3',
            '\ud8c7',
            '\ud8af',
            '\ud8c7',
            '\ud967',
            '\ud957',
            '\ud929'
         },
         282775506
      );
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(new char[]{'㻨', '㻦', '㺄', '㽲', '㽌', '㼲', '㼂', '㿶', '㿄', '㿠', '㾔', '㾛', '䁤'}, -669303127);
      this.n99 = var10001;
      this.o99 = new SlotEntry(NotifyResolver.q(new byte[]{14, 114, 50, 61, 35}, 93), c99[1], c99);
      this.p = new SlotEntry(
         QueryZone.r(new byte[]{107}, 41)
            + NotifyResolver.q(new byte[]{95, 0, 5, 20}, 113)
            + JoinerWriter.p(new byte[]{74, 69}, 31)
            + YieldKeeper.v(new byte[]{76, 94, -23, -109}, 63),
         d99[0],
         d99
      );
      this.q = new SlotEntry(TokenExtractor.w(new byte[]{52, 83, 21, 17, 23, 10, 16}, 117), e[0], e);
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'캀', '컍', '콰', '콀', '켷', '콿', '켿', '쿳', '쿕', '쾶', '쾛', '큭', '큑', '퀸', '퀘'}, -1133654332);
      this.r = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'帋', '幏', '廴', '建', '廓', '廽', '庻', '彷', '录', '弮'}, -821469630);
      this.s = var2;
      this.t = new SlotEntry(
         TokenExtractor.w(new byte[]{-10, -104, -37, -37, -62, -118, -24, -57, -59}, 186) + QueryZone.r(new byte[]{-81, -69}, 195), f99[0], f99
      );
      BlockCalculator var3 = new BlockCalculator("", 0.1, 2.0, 1.0, 0.1);
      var3.n(new char[]{'ｂ', '＊', 'Ｏ', '－', '\ufff6', 'ﾀ', '￬', 'ﾪ', 'ﾏ', 'y', 'U', '=', '\r', 'ð'}, -1265762555);
      this.u = var3;
      this.v = new SlotEntry(TokenExtractor.w(new byte[]{126, 22, 75, 87}, 60), g99[1], g99);
      this.w = new SlotEntry(
         JoinerWriter.p(new byte[]{30, 10}, 35)
            + QueryZone.r(new byte[]{-33, -55}, 174)
            + JoinerWriter.p(new byte[]{-111, -77, -34, -38}, 143)
            + YieldKeeper.v(new byte[]{-15, 78}, 158),
         h[0],
         h
      );
      BlockCalculator var4 = new BlockCalculator("", 0.5, 2.0, 1.0, 0.1);
      var4.n(
         new char[]{'\ue672', '\ue674', '\ue617', '\ue6eb', '\ue6c7', '\ue6b3', '\ue696', '\ue760', '\ue713', '\ue701', '\ue701', '\ue7f5', '\ue7ca', '\ue7aa'},
         1145759291
      );
      this.x = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'䮧', '䰽', '䱅', '䰰', '䰉'}, 1796033524);
      this.y = var5;
      BlockCalculator var6 = new BlockCalculator("", 0.0, 2.0, 1.0, 0.1);
      var6.n(new char[]{'ᆺ', 'ሦ', 'ቐ', 'ሧ', 'ሜ', 'ኤ', 'ዢ', 'ኯ', '\u128e', '፵', '፱', 'ፊ'}, -2107829783);
      this.z = var6;
      this.aa = new SlotEntry(YieldKeeper.v(new byte[]{82, 26, 33, 4, -26, -68, -27, -92}, 26) + QueryZone.r(new byte[]{30, 2, 16}, 100), i99[0], i99);
      BlockCalculator var7 = new BlockCalculator("", 0.3, 1.2, 0.6, 0.05);
      var7.n(new char[]{'\uf500', '\uf54e', '\uf50d', '\uf5f3', '\uf59d', '\uf58f', '\uf592', '\uf660', '\uf65c'}, -1305873087);
      this.ab = var7;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'줠', '즼', '짞', '즥', '즁', '쩪', '쩞'}, -1459697293);
      this.ac = var8;
      BlockCalculator var9 = new BlockCalculator("", 0.0, 1.0, 0.6, 0.05);
      var9.n(new char[]{'媒', '嫎', '媐', '孫', '孓', '嬸', '孛', '富', '寖', '宴', '宂', '屻', '屐'}, 468540097);
      this.ad = var9;
      CheckerBridge var10 = new CheckerBridge("", true);
      var10.n(new char[]{'獱', '獹', '猒', '珹', '珑', '珳', '玴', '瑸', '瑔', '琨', '琋', '瓹', '瓟'}, 957510456);
      this.ae = var10;
      this.af = new SlotEntry(
         TokenExtractor.w(new byte[]{29, 121, 56, 42, 40, 62, 57, 41, 124, 16}, 81)
            + JoinerWriter.p(new byte[]{26}, 88)
            + StringDecoder.d(new byte[]{-40, -40, -52}, 188),
         j[0],
         j
      );
      this.a(
         this.n99,
         this.o99,
         this.p,
         this.q,
         this.r,
         this.s,
         this.t,
         this.u,
         this.v,
         this.w,
         this.x,
         this.y,
         this.z,
         this.aa,
         this.ab,
         this.ac,
         this.ad,
         this.ae,
         this.af
      );
   }

   @Override
   public void c() {
      if (ag != 0) {
         new Object().hashCode();
      }

      this.b.a(InitNotifier.class, this);
      this.b();
      BevelPassCache.a();
      BevelPassCache.ON = true;
      super.c();
   }

   @Override
   public void d() {
      if (ag != 0) {
         new Object().hashCode();
      }

      BevelPassCache.ON = false;
      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {
      if (ag != 0) {
         Thread.currentThread().getName().length();
      }

      this.b();
   }

   public void b() {
      if (ag != 0) {
         new Object().hashCode();
      }

      BevelPassCache.KEY = this.n99.g();
      BevelPassCache.SKIN = Math.max(0, this.o99.g().indexOf(this.o99.f()));
      BevelPassCache.APPLY = Math.max(0, this.p.g().indexOf(this.p.f()));
      BevelPassCache.FINISH = Math.max(0, this.q.g().indexOf(this.q.f()));
      BevelPassCache.DRAW_ANIM = this.r.f();
      BevelPassCache.GLOW = this.s.f();
      BevelPassCache.GLOW_STR = this.u.h();
      BevelPassCache.SPEED = this.x.h();
      BevelPassCache.SWAY = this.y.f();
      BevelPassCache.SWAY_AMT = this.z.h();
      BevelPassCache.HOLD_STYLE = Math.max(0, this.aa.g().indexOf(this.aa.f()));
      BevelPassCache.ARM_SIZE = this.ab.h();
      BevelPassCache.SOUNDS = this.ac.f();
      BevelPassCache.SND_VOL = this.ad.h();
      BevelPassCache.FIDGETS = this.ae.f();
      BevelPassCache.INS_RANDOM = this.af.g().indexOf(this.af.f()) == 1;
      int[] var1 = ThemeCache.j();
      int var2 = (var1[0] & (1496485529 ^ 1496485478)) << 16 | (var1[1] & (-1484496341 ^ -1484496172)) << 8 | var1[2] & (-1786752882 ^ -1786752911);
      BevelPassCache.THEME_RGB = var2;
      int var3 = Math.max(0, this.t.g().indexOf(this.t.f()));
      BevelPassCache.GLOW_RGB = k99[var3] < 0 ? var2 : k99[var3];
      BevelPassCache.ARM = Math.max(0, this.v.g().indexOf(this.v.f()));
      int var4 = Math.max(0, this.w.g().indexOf(this.w.f()));
      if (l99[var4] < 0) {
         BevelPassCache.ARM_RGB = var2;
         int var5 = (var1[0] & (1217226777 ^ 1217226982)) + ((-812332353 ^ -812332480) - (var1[0] & (1653803319 ^ 1653803464))) / 2;
         int var6 = (var1[1] & (-579381700 ^ -579381565)) + ((2040953888 ^ 2040954079) - (var1[1] & (-465781143 ^ -465781098))) / 2;
         int var7 = (var1[2] & (1677511867 ^ 1677511748)) + ((-1594876834 ^ -1594876767) - (var1[2] & (2000488812 ^ 2000488851))) / 2;
         BevelPassCache.ARM_RIM = var5 << 16 | var6 << 8 | var7;
      } else {
         BevelPassCache.ARM_RGB = l99[var4];
         BevelPassCache.ARM_RIM = m99[var4];
      }
   }

   @Override
   public void e() {
      if (ag != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (ag != 0) {
         System.nanoTime();
      }

      return super.f;
   }

   @Override
   public String g() {
      if (ag != 0) {
         Thread.currentThread().getName().length();
      }

      return super.g();
   }

   @Override
   public String h() {
      if (ag != 0) {
         new Object().hashCode();
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (ag != 0) {
         Thread.currentThread().getName().length();
      }

      return super.i();
   }

   @Override
   public int j() {
      if (ag != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (ag != 0) {
         new Object().hashCode();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (ag != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (ag != 0) {
         Thread.currentThread().getName().length();
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (ag != 0) {
         System.nanoTime();
      }

      super.a(var1);
   }
}
