package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.LoaderDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RasterCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.StyleSpriteSource.Font;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.joml.Matrix3x2fStack;

public final class CoreZoneProcessor extends BuilderFactory {
   static final String[] L = new String[]{
      NotifyResolver.q(new byte[]{35, 12, 21, 3, 17, 31, 40, 42}, 104),
      TokenExtractor.w(new byte[]{89, 123, 53, 112}, 22)
         + NotifyResolver.q(new byte[]{85, 83, 92}, 60)
         + NotifyResolver.q(new byte[]{61, 111}, 78)
         + QueryZone.r(new byte[]{94, 65, 75}, 46),
      StringDecoder.d(new byte[]{52, 22, 0, 7, 23, 3, 21, 15, 29, 29}, 103),
      QueryZone.r(new byte[]{10, 34, 52, 48, 60, 24}, 71),
      TokenExtractor.w(new byte[]{27, 2, 0}, 122),
      JoinerWriter.p(new byte[]{36, 41}, 73),
      JoinerWriter.p(new byte[]{84, 79, 81}, 32),
      NotifyResolver.q(new byte[]{-105}, 207),
      NotifyResolver.q(new byte[]{2}, 91),
      QueryZone.r(new byte[]{-44}, 141),
      YieldKeeper.v(new byte[]{81}, 30) + NotifyResolver.q(new byte[]{124, 110, 124, 116, 117, 97, 66, 95}, 10),
      JoinerWriter.p(new byte[]{-36, -14, 0, -13, -17, -5}, 114),
      JoinerWriter.p(new byte[]{-82, -83}, 127),
      JoinerWriter.p(new byte[]{77, 25, 15}, 162)
         + NotifyResolver.q(new byte[]{109, 62, 15, 100, 47, 21, 73, 14, 69, 60, 91, 119, -3, -106, -61}, 130)
         + JoinerWriter.p(new byte[]{-123, 82, 36, -126, 79, 29, 127, 76, 15, 124, 73, 36, 121, 70, 13, 118, 67, 23}, 106),
      NotifyResolver.q(new byte[]{101}, 75),
      QueryZone.r(new byte[]{75}, 101),
      TokenExtractor.w(new byte[]{21}, 127)
   };
   static final int L_KEYS = 0;
   static final int L_NOBINDS = 1;
   static final int L_SPEC = 2;
   static final int L_NOBODY = 3;
   static final int L_FPS = 4;
   static final int L_MS = 5;
   static final int L_TPS = 6;
   static final int L_X = 7;
   static final int L_Y = 8;
   static final int L_Z = 9;
   static final int L_OVER = 10;
   static final int L_NETHER = 11;
   static final int L_NONE = 12;
   static final int L_SP = 13;
   static final int L_DOT = 14;
   static final int L_DASH = 15;
   static final int L_M = 16;
   private static final String[] bk = new String[]{
      TokenExtractor.w(new byte[]{-44}, 166),
      TokenExtractor.w(new byte[]{117}, 12),
      QueryZone.r(new byte[]{-65}, 198),
      YieldKeeper.v(new byte[]{12}, 44),
      TokenExtractor.w(new byte[]{-128, -115}, 166),
      NotifyResolver.q(new byte[]{70, 101, 107, 119, 119, 119, 92}, 11)
   };
   private static final int bl = 0;
   private static final int bm = 3;
   private static final int bn = 4;
   private static final int bo = 5;
   private static final int bp = 352321535;
   private static final byte[] bq = new byte[]{-125, -25, 47, 38, 52, 54, 44, 47, 58, 102, 51, 51, 55};
   public static final int P_INFO = 0;
   public static final int P_MODS = 1;
   public static final int P_KEYS = 2;
   public static final int P_SPEC = 3;
   public static final int P_CMP = 4;
   public static final int P_WM = 5;
   public static final int P_POT = 6;
   public static final int P_SPEED = 7;
   public static final int P_ALERT = 8;
   public static final int P_HOTBAR = 9;
   public static final int P_COUNT = 10;
   static final int F_BAR = 10;
   static final int F_CO = 11;
   static final int F_NETHER = 12;
   static final int F_COUNT = 13;
   static final float FADE_S = 0.18F;
   static final float SINK = 4.0F;
   private static final long br = 250000000L;
   public static volatile boolean HOTBAR_ON = false;
   public static volatile boolean POTIONS_ON = false;
   public static volatile float ACTION_LIFT = 0.0F;
   public static boolean LIFT_PUSHED = false;
   private final ItemDescriptor bs;
   final BlockCalculator bt;
   final CheckerBridge o99;
   final CheckerBridge q;
   final CheckerBridge m99;
   final PlacementEntry bu;
   final PlacementEntry bv;
   final CheckerBridge n99;
   final PlacementEntry bw;
   final PlacementEntry bx;
   final CheckerBridge by;
   final PlacementEntry kbX;
   final PlacementEntry kbY;
   final CheckerBridge bz;
   final PlacementEntry spX;
   final PlacementEntry spY;
   final BlockCalculator ca;
   final BlockCalculator cb;
   final SlotEntry cc;
   final CheckerBridge cmp;
   final CheckerBridge cd;
   final CheckerBridge ce;
   final PlacementEntry cmpX;
   final PlacementEntry cmpY;
   final CheckerBridge wm;
   final PlacementEntry wmX;
   final PlacementEntry wmY;
   final SlotEntry cf;
   final CheckerBridge cg;
   final PlacementEntry ch;
   final SlotEntry ci;
   final BlockCalculator cj;
   final CheckerBridge ck;
   final CheckerBridge cl;
   final CheckerBridge cm;
   final CheckerBridge cn;
   final CheckerBridge co;
   final CheckerBridge cp;
   final SlotEntry cq;
   final CheckerBridge cr;
   final PlacementEntry cs;
   final PlacementEntry ct;
   final CheckerBridge cu;
   final PlacementEntry cv;
   final PlacementEntry cw;
   final CheckerBridge cx;
   final SlotEntry cy;
   final CheckerBridge cz;
   final CheckerBridge da;
   final CheckerBridge db;
   final PlacementEntry dc;
   final PlacementEntry dd;
   private static final String[] de = new String[]{
      QueryZone.r(new byte[]{43, 113, 113, 48, 101, 116, 5, 78, 117}, 199),
      JoinerWriter.p(new byte[]{111, 59, 53, 108, 57, 3, 105, 54, 1, 102, 51, 9, 99, 48, -9}, 128),
      YieldKeeper.v(new byte[]{-16, -126, -6, -109, 38, 53, 54, 69, -101, -39, -24, -16}, 31),
      NotifyResolver.q(new byte[]{73, 27, 16, 64, 11, 58, 109, 42, 98}, 166),
      TokenExtractor.w(new byte[]{110, 60, 51, 109, 56, 13, 104, 59, 23, 119, 38, 17}, 137),
      NotifyResolver.q(new byte[]{-30, -80, -90, -21, -96, -122, -58, -127, -52, -77, -44, -6, 114, 25, 78, 3, -80, -87}, 13)
   };
   private static final String[] df = new String[]{
      TokenExtractor.w(new byte[]{36, 118, 100, 39, 106, 89, 58, 105, 92, 61, 108, 94}, 199),
      NotifyResolver.q(new byte[]{-51, -97, -107, -60, -113, -70, -23, -82, -23, -100, -5, -50, 93, 54, 116, 44, -97, -126}, 34)
   };
   private static final String[] dg = new String[]{
      YieldKeeper.v(new byte[]{-127, 96, -24, 87, -101, 21, -19, -51, 76, -93, 7, -69}, 110),
      QueryZone.r(new byte[]{-76, -18, -19, -81, -6, -15, -102, -47, -9, -11, -84, -101}, 88)
   };
   static final int LOGO_MOON = 0;
   static final int LOGO_SAKURA = 1;
   static final int BAR_BARS = 0;
   static final int BAR_DOTS = 1;
   private String dh;
   private String di;
   private String dj;
   int dk;
   int dl;
   int dm;
   float dn;
   boolean do99;
   float dp;
   float dq;
   private long dr;
   private long ds;
   private float dt;
   private long du;
   float dv;
   private static final String[] dw = new String[]{
      TokenExtractor.w(new byte[]{89, 13, 28, 92, 15, 36, 67, 18, 41, 70, 21, 35, 69, 24, 48}, 189),
      JoinerWriter.p(new byte[]{62, 10, -1, 59, 8, -49, 56, 5, -50, 53, 2, -39, 50, -1, -51, 47, -4, -65, 44, -7, -51}, 177),
      NotifyResolver.q(new byte[]{-92, -10, -30, -83, -26, -41, -128, -57, -113, -11, -110, -69, 52, 95, 26, 69, -10, -25}, 75),
      TokenExtractor.w(new byte[]{64, 18, 11, 71, 22, 37, 90, 9, 59, 89, 12, 52}, 165),
      QueryZone.r(new byte[]{33, 123, 126, 58, 111, 103, 15, 68, 119, 96, 57, 30, 117, 46, 35}, 205)
   };
   private static final Style[][] dx = new Style[5][3];
   private static final Style[][] dy = new Style[5][3];
   private String dz;
   private int ea;
   private int eb;
   private final ArrayList<BuilderFactory> ec;
   private final Object2FloatOpenHashMap<BuilderFactory> ed;
   private boolean[] ee;
   private boolean ef;
   private int eg;
   private float eh;
   private final IdentityHashMap<BuilderFactory, OrderedText> ei;
   private final Object2FloatOpenHashMap<BuilderFactory> ej;
   private final IdentityHashMap<BuilderFactory, OrderedText> ek;
   private final IdentityHashMap<BuilderFactory, float[]> el;
   private long em;
   int en;
   boolean eo;
   boolean ep;
   private OrderedText eq;
   OrderedText er;
   private float es;
   private int et;
   private float eu;
   private long ev;
   final int[][] ew;
   private final boolean[] ex;
   final float[] ey;
   private float ez;
   final boolean[] fa;
   final float[] fb;
   final float[] fc;
   int fd;
   private float fe;
   private float ff;
   private static volatile long fg;
   private static volatile long fh;
   private static volatile float fi;
   static float fj;
   static float fk;
   private int fl;
   private int fm;
   private int fn;
   private int fo;
   private int fp;
   private int fq;
   private int fr;
   private int fs;
   private int ft;
   private int fu;
   private int fv;
   private int fw;
   private int fx;
   private int fy;
   private int fz;
   private int ga;
   private int gb;
   private int gc;
   private int gd;
   private String ge;
   private String gf;
   private static String gg;
   private final Text[] gh;
   private final float[] gi;
   private final Text[] gj;
   private final float[] gk;
   private int gl;
   private Text gm;
   private Text gn;
   private float go;
   private float gp;
   private int gq;
   private int gr;
   private int gs;
   private int gt;
   private int gu;
   private long gv;
   private int gw;
   private int gx;
   private int gy;
   private final float[] gz;
   private Text ha;
   private float hb;
   private int hc;
   private int hd;
   private int he;
   private int hf;
   private int hg;
   private float hh;
   private float hi;
   private float hj;
   private float hk;
   private float hl;
   private long hm;
   private final HashMap<UUID, Long> hn;
   private final ArrayList<CoreZoneProcessor.Spec> ho;
   private long hp;
   private static final String[] hq;
   private static final String[] hr;
   public static volatile CoreZoneProcessor I;
   private static final String[] hs;
   static final int S_GENERAL = 0;
   static final int S_TOP = 1;
   static final int S_WM = 2;
   static final int S_COORDS = 3;
   static final int S_MODS = 4;
   static final int S_KEYS = 5;
   static final int S_SPEC = 6;
   static final int S_POT = 7;
   static final int S_SPEED = 8;
   static final int S_HOTBAR = 9;
   static final int S_ALERTS = 10;
   private NodeZoneRenderer.Vis[] ht;
   private InitAdapter[] hu;
   private Object[] hv;
   private long hw;
   private boolean hx;
   private boolean hy;
   private boolean hz;
   private boolean ia;
   private boolean ib;
   private double ic;
   private double id;
   private String ie;
   private String if99;
   private String ig;
   private String ih;
   private static final long ii = 50000000L;
   static volatile long ij;
   private Throwable ik;
   private long il;
   private int im;
   private static final int in = 32;
   private final Style[] io;
   private int ip;
   private int iq;
   private int ir;
   private int is;
   private int it;
   private static float iu;
   private static int iv;
   private static Style iw;
   private static Style ix;
   private static final HashMap<String, Text> iy;
   private static int ja = 0;

   public CoreZoneProcessor() {
      super("", "", ParserEngine.Z3);
      this.setName(new char[]{'瞴', '砵', '硯', '砝'}, -1385400324, new char[0], -684128070);
      PlacementEntry var10001 = new PlacementEntry("", 1.0, 3.0, 2.0, 1.0);
      var10001.n(new char[]{'㘊', '㙖', '㛴', '㛗', '㚹', '㚑'}, 2018260569);
      this.bt = var10001;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'츘', '칗', '컹', '컔', '캽', '캒', '콦', '콜', '켧', '켟', '쿴'}, -1863463334);
      this.o99 = var3;
      CheckerBridge var4 = new CheckerBridge("", false);
      var4.n(new char[]{'ᰋ', '᱖', 'ᳶ', '᳟', '\u1cbb', 'Ზ', 'ᵼ', 'ᵅ'}, -1408033703);
      this.q = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'ᥗ', 'ᤓ', 'ᤲ', 'ᤝ', '᧵'}, 1277368606);
      this.m99 = var5;
      var10001 = new PlacementEntry("", 0.0, 100.0, 50.0, 0.1);
      var10001.n(new char[]{'냺', '냼', '낟', '녶', '녀', '녮', '넵'}, 123842739);
      this.bu = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 1.2, 0.1);
      var10001.n(new char[]{'쑀', '쐆', '쐩', '쐀', '쓪', '쒄', '쒚'}, 1170981897);
      this.bv = var10001;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'屮', '屬', '導', '峤', '峪', '峒', '岸', '岏'}, 840391715);
      this.n99 = var8;
      var10001 = new PlacementEntry("", 0.0, 100.0, 99.0, 0.1);
      var10001.n(new char[]{'\uf116', '\uf154', '\uf1f6', '\uf1dc', '\uf1a2', '\uf19a', '\uf270', '\uf247', '\uf273', '\uf22a'}, -947130021);
      this.bw = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 1.0, 0.1);
      var10001.n(new char[]{'쥤', '쥦', '줈', '짢', '짐', '즨', '즆', '쩱', '쨁', '쨙'}, 1158924585);
      this.bx = var10001;
      CheckerBridge var11 = new CheckerBridge("", true);
      var11.n(new char[]{'\udf3d', '\udfbb', '\udfd1', '\udfaa', '\udf90', '\ue078', '\ue05e', '\ue02b', '\ue01d'}, 2081021814);
      this.by = var11;
      var10001 = new PlacementEntry("", 0.0, 100.0, 97.5, 0.1);
      var10001.n(new char[]{'\ue416', '\ue452', '\ue4fe', '\ue4c3', '\ue4bb', '\ue491', '\ue579', '\ue552', '\ue526', '\ue554', '\ue5cb'}, -455023523);
      this.kbX = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 44.0, 0.1);
      var10001.n(new char[]{'⹑', '⸗', '⸽', '⸎', '\u2ef4', '⻜', '⺺', '⺗', '⽡', '⼑', '⼉'}, 483536410);
      this.kbY = var10001;
      CheckerBridge var14 = new CheckerBridge("", true);
      var14.n(new char[]{'ຸ', '༤', 'ཙ', '༭', '༄', '\u0ff2', '࿄', 'ྰ', 'ྌ', 'ၰ', 'ၒ'}, 996937451);
      this.bz = var14;
      var10001 = new PlacementEntry("", 0.0, 100.0, 2.0, 0.1);
      var10001.n(new char[]{'蠩', '袷', '裈', '袲', '袕', '襡', '襕', '褧', '褝', '解', '觃', '觯', '覶'}, -2080864134);
      this.spX = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 30.0, 0.1);
      var10001.n(new char[]{'텽', '텣', '턜', '퇮', '퇉', '톽', '톉', '퉳', '퉉', '툷', '툗', '튣', '틻'}, 1297142062);
      this.spY = var10001;
      var10001 = new PlacementEntry("", 0.0, 15.0, 5.0, 0.5);
      var10001.n(new char[]{'侥', '倻', '偄', '倶', '們', '傱', '僴', '傪', '傂', '公', '兕'}, 953044982);
      this.ca = var10001;
      var10001 = new PlacementEntry("", 0.0, 20.0, 4.0, 0.5);
      var10001.n(new char[]{'ᇆ', 'ᆈ', 'ᆧ', 'ᆋ', 'ት', 'ቇ', 'ቡ', 'ረ', 'ሚ', 'ዷ', 'ዚ', 'ኴ', '\u128f'}, 707924359);
      this.cb = var10001;
      this.cc = new SlotEntry(
         StringDecoder.d(new byte[]{-5, -121, -38, -50, -49, -115, -3, -64, -46, -43}, 168),
         TokenExtractor.w(new byte[]{36, 118, 109, 39, 106, 95, 58, 105, 64, 61, 108, 68, 48, 99, 92, 51, 102, 84, 54, 101, 100, 9, 88, 97}, 199),
         TokenExtractor.w(new byte[]{82, 6, 31, 87, 4, 47, 72, 25, 54, 77, 30, 52, 78, 19, 46, 67, 16, 36, 68, 21, 42, 121, 42, 17}, 182),
         NotifyResolver.q(new byte[]{93, 15, 24, 84, 31, 42, 121, 62, 127, 12, 107, 78}, 178)
      );
      CheckerBridge var19 = new CheckerBridge("", false);
      var19.n(new char[]{'ﳈ', 'ﲄ', 'ﲦ', 'ﲅ', 'ﵷ', '﵇', 'ﴶ', 'ﴗ'}, -1769603957);
      this.cmp = var19;
      CheckerBridge var20 = new CheckerBridge("", true);
      var20.n(new char[]{'Ꭷ', 'ᐭ', 'ᑍ', 'ᐮ', 'ᐒ', 'ᐛ', 'ᓷ', 'ᓓ', 'ᒽ', 'ᒏ', 'ᕿ', 'ᕊ'}, -745401372);
      this.cd = var20;
      CheckerBridge var21 = new CheckerBridge("", false);
      var21.n(new char[]{'썥', '썤', '쌌', '쏼', '쏏', '쎣', '쎗', '쐤', '쑠', '쐭', '쐎', '쓲', '쓻', '쓍'}, 417710891);
      this.ce = var21;
      var10001 = new PlacementEntry("", 0.0, 100.0, 50.0, 0.1);
      var10001.n(new char[]{'惌', '悀', '悢', '悁', '慻', '態', '愺', '愛', '憧', '懾'}, 81879183);
      this.cmpX = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 20.5, 0.1);
      var10001.n(new char[]{'翚', '羖', '羸', '羛', '聥', '聕', '耠', '老', '肱', '胩'}, 1574535065);
      this.cmpY = var10001;
      CheckerBridge var24 = new CheckerBridge("", true);
      var24.n(new char[]{'땫', '땵', '딛', '뗭', '뗝', '떥', '떛', '뙴', '뙆', '똸'}, 846968124);
      this.wm = var24;
      var10001 = new PlacementEntry("", 0.0, 100.0, 50.0, 0.1);
      var10001.n(new char[]{'⻛', '⺅', '⺫', '⺝', '⽭', '⽕', '⼫', '⼄', '⿶', '⿈', '\u2fe2', '⾹'}, 1109012108);
      this.wmX = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 1.2, 0.1);
      var10001.n(new char[]{'愯', '憹', '懗', '憡', '憑', '扡', '扟', '戰', '戂', '拤', '抎', '抔'}, 1175282040);
      this.wmY = var10001;
      this.cf = new SlotEntry(NotifyResolver.q(new byte[]{-48, -71, -3, -15, -14}, 150), dw[2], dw);
      CheckerBridge var27 = new CheckerBridge("", true);
      var27.n(new char[]{'䙝', '䘗', '䘪', '䘖', '䛲', '䛜', '䚱', '䚝', '䝦'}, -1892661734);
      this.cg = var27;
      var10001 = new PlacementEntry("", 0.0, 100.0, 0.0, 1.0);
      var10001.n(new char[]{'瞬', '矑', '硿', '硄', '砳', '砎', '磮', '碙', '碎', '碒', '祤'}, -1755416608);
      this.ch = var10001;
      this.ci = new SlotEntry(
         NotifyResolver.q(new byte[]{60, 91, 37}, 116) + TokenExtractor.w(new byte[]{-21}, 165) + QueryZone.r(new byte[]{62, 67, 100, 96, 111, 94}, 29),
         de[0],
         de
      );
      var10001 = new PlacementEntry("", 40.0, 100.0, 95.0, 1.0);
      var10001.n(new char[]{'㷵', '㷷', '㶈', '㹶', '㹕', '㸼', '㸀', '㻪'}, 1430928826);
      this.cj = var10001;
      CheckerBridge var30 = new CheckerBridge("", true);
      var30.n(new char[]{'ᾇ', 'Ὴ', '\u2062', '⁐', '\u2061', '\u202e', '„', '\u20f3', '⃘'}, -997056571);
      this.ck = var30;
      CheckerBridge var31 = new CheckerBridge("", true);
      var31.n(new char[]{'氡', '沬', '泀', '沲', '泿', '沭', '浸', '济', '洭', '洟', '淫'}, -1529451421);
      this.cl = var31;
      CheckerBridge var32 = new CheckerBridge("", true);
      var32.n(new char[]{'齲', '齡', '鼏', '鿿', '龌', '龍', '龺', 'ꁚ'}, 1487642416);
      this.cm = var32;
      CheckerBridge var33 = new CheckerBridge("", false);
      var33.n(new char[]{'嫐', '媟', '媱', '媝', '嬮', '孽', '嬥', '嬅', '寭'}, -545760622);
      this.cn = var33;
      CheckerBridge var34 = new CheckerBridge("", false);
      var34.n(new char[]{'符', '箭', '篃', '箳', '節', '箫', '籎', '籮'}, 2067757924);
      this.co = var34;
      CheckerBridge var35 = new CheckerBridge("", true);
      var35.n(new char[]{'轸', '轷', '輙', '迥', '辖', '辖', '辘', '遼', '遑', '逺'}, 703041338);
      this.cp = var35;
      this.cq = new SlotEntry(JoinerWriter.p(new byte[]{57, 26, 90, 81, 88}, 19), df[0], df);
      CheckerBridge var36 = new CheckerBridge("", true);
      var36.n(new char[]{'\ude14', '\ude4d', '\udeed', '\uded5', '\udea9', '\udeb0', '\ude90', '\udf6e'}, 1081794116);
      this.cr = var36;
      var10001 = new PlacementEntry("", 0.0, 100.0, 97.5, 0.1);
      var10001.n(new char[]{'ষ', 'ਨ', '\u0a4a', 'ਰ', 'ਊ', '૭', '\u0acf', 'ળ', '૿', 'દ'}, 960432615);
      this.cs = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 26.0, 0.1);
      var10001.n(new char[]{'备', '奘', '姺', '姀', '妺', '妝', '婿', '婃', '婯', '娷'}, -962700969);
      this.ct = var10001;
      CheckerBridge var39 = new CheckerBridge("", true);
      var39.n(new char[]{'\ud9fb', '\ud9e9', '\ud996', '\uda60', '\uda41', '\uda27'}, 1076353448);
      this.cu = var39;
      var10001 = new PlacementEntry("", 0.0, 100.0, 2.0, 0.1);
      var10001.n(new char[]{'덢', '덾', '댟', '돫', '돈', '뎨', '돋', '둒'}, 600945457);
      this.cv = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 61.7, 0.1);
      var10001.n(new char[]{'\udf22', '\udfbe', '\udfdf', '\udfab', '\udf88', '\ue068', '\ue00b', '\ue013'}, 652337009);
      this.cw = var10001;
      CheckerBridge var42 = new CheckerBridge("", true);
      var42.n(new char[]{'뫞', '몛', '못', '몇', '뭰', '뭐', '묢'}, 1145420438);
      this.cx = var42;
      this.cy = new SlotEntry(
         TokenExtractor.w(new byte[]{95, 58, 122, 102, 113, 113, 99, 62}, 22) + JoinerWriter.p(new byte[]{51, 83, 87, 73, 65}, 32), dg[0], dg
      );
      CheckerBridge var43 = new CheckerBridge("", true);
      var43.n(new char[]{'鱁', '鰟', '鰼', '鰀', '鳺', '鲍', '鲂', '鲞', '鵧', '鵋', '鴭', '鴕', '鷵'}, -67134446);
      this.cz = var43;
      CheckerBridge var44 = new CheckerBridge("", true);
      var44.n(new char[]{'닍', '늅', '늸', '늄', '덧', '덕', '덦', '댵', '돭', '돏', '뎮', '뎒'}, -1259425140);
      this.da = var44;
      CheckerBridge var45 = new CheckerBridge("", true);
      var45.n(new char[]{'㵅', '㴍', '㴮', '㴄', '㷲', '㷫', '㷍'}, 501562628);
      this.db = var45;
      var10001 = new PlacementEntry("", 0.0, 100.0, 50.0, 0.1);
      var10001.n(new char[]{'\udd72', '\udd7c', '\udd1d', '\uddf5', '\udddd', '\uddba', '\udd9e', '\ude2c', '\ude73'}, 640671027);
      this.dc = var10001;
      var10001 = new PlacementEntry("", 0.0, 100.0, 74.0, 0.1);
      var10001.n(new char[]{'샋', '삇', '삤', '삂', '셴', '셑', '섷', '셃', '쇛'}, 548454538);
      this.dd = var10001;
      this.dk = 0;
      this.dl = 0;
      this.dm = 0;
      this.dn = 0.0F;
      this.do99 = false;
      this.dp = 1.0F;
      this.dq = 0.0F;
      this.dr = 0L;
      this.ds = 0L;
      this.dt = 0.0F;
      this.du = 0L;
      this.dv = 0.0F;
      this.ea = 0;
      this.eb = -1;
      this.ec = new ArrayList<>();
      this.ed = new Object2FloatOpenHashMap();
      this.ee = new boolean[0];
      this.ef = false;
      this.eg = -1;
      this.eh = 0.0F;
      this.ei = new IdentityHashMap<>();
      this.ej = new Object2FloatOpenHashMap();
      this.ek = new IdentityHashMap<>();
      this.el = new IdentityHashMap<>();
      this.em = 0L;
      this.en = 0;
      this.eo = true;
      this.ep = false;
      this.es = -1.0F;
      this.et = 0;
      this.eu = 0.0F;
      this.ev = 0L;
      this.ew = new int[10][4];
      this.ex = new boolean[13];
      this.ey = new float[13];
      this.ez = 0.0F;
      this.fa = new boolean[13];
      this.fb = new float[13];
      this.fc = new float[13];
      this.fd = 2;
      this.fe = 0.0F;
      this.ff = 0.0F;
      this.fl = 0;
      this.fy = -1;
      this.gh = new Text[8];
      this.gi = new float[8];
      this.gj = new Text[24];
      this.gk = new float[24];
      this.gl = -1;
      this.go = 0.0F;
      this.gp = 0.0F;
      this.gt = -1;
      this.gu = -1;
      this.gv = 0L;
      this.gw = 15;
      this.gx = 15;
      this.gy = -1;
      this.gz = new float[12];
      this.hb = 0.0F;
      this.he = -1;
      this.hf = -1;
      this.hg = -1;
      this.hk = 0.0F;
      this.hl = 0.0F;
      this.hm = 0L;
      this.hn = new HashMap<>();
      this.ho = new ArrayList<>();
      this.hp = 0L;
      this.hw = 0L;
      this.il = 0L;
      this.im = 0;
      this.io = new Style[33];
      this.is = Integer.MAX_VALUE;
      this.it = -1;
      I = this;
      ItemDescriptor var48 = new ItemDescriptor("", 344, false);
      var48.n(new char[]{'蝫', '蝥', '蜿', '蟀', '螈', '螌', '螃', '衼'}, -1040218324);
      this.bs = var48;
      InitAdapter[] var1 = new InitAdapter[]{
         this.bs,
         this.bt,
         this.o99,
         this.q,
         this.m99,
         this.bu,
         this.bv,
         this.n99,
         this.bw,
         this.bx,
         this.by,
         this.kbX,
         this.kbY,
         this.bz,
         this.spX,
         this.spY,
         this.ca,
         this.cb,
         this.cc,
         this.cmp,
         this.cd,
         this.ce,
         this.cmpX,
         this.cmpY,
         this.wm,
         this.wmX,
         this.wmY,
         this.cf,
         this.cg,
         this.ch,
         this.ci,
         this.cj,
         this.ck,
         this.cl,
         this.cm,
         this.cn,
         this.co,
         this.cp,
         this.cq,
         this.cr,
         this.cs,
         this.ct,
         this.cu,
         this.cv,
         this.cw,
         this.cx,
         this.cy,
         this.cz,
         this.da,
         this.db,
         this.dc,
         this.dd
      };
      this.a(var1);
      this.hu = var1;
      this.hv = new Object[var1.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         this.hv[var2] = var1[var2].c();
      }
   }

   @Override
   public void c() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.hn.clear();
      super.c();
      this.d(System.nanoTime());
      this.f99();
   }

   @Override
   public void d() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.hn.clear();
      NoticeQueue.n = 0;
      HOTBAR_ON = false;
      POTIONS_ON = false;
      ACTION_LIFT = 0.0F;
      super.d();
   }

   @Override
   public void e() {
      if (ja != 0) {
         new Object().hashCode();
      }

      super.e();
   }

   @Override
   public boolean f() {
      if (ja != 0) {
         System.nanoTime();
      }

      return super.f;
   }

   @Override
   public String g() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return super.g();
   }

   @Override
   public String h() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.h();
   }

   @Override
   public ParserEngine i() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return super.i();
   }

   @Override
   public int j() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return super.k();
   }

   @Override
   public ItemDescriptor l() {
      if (ja != 0) {
         new Object().hashCode();
      }

      return super.l();
   }

   @Override
   public void a(boolean var1) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      super.a(var1);
   }

   @Override
   public void a(int var1) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      super.a(var1);
   }

   public NodeZoneRenderer.Vis[] a() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      NodeZoneRenderer.Vis[] var1 = this.ht;
      if (var1 == null) {
         String[] var2 = hs;
         var1 = new NodeZoneRenderer.Vis[]{
            new NodeZoneRenderer.Vis(var2[0], null, new InitAdapter[]{this.ci, this.cj, this.bt, this.o99, super.i, this.bs}),
            new NodeZoneRenderer.Vis(var2[1], this.m99, new InitAdapter[]{this.ck, this.cl, this.cm, this.cn, this.co, this.cp}),
            new NodeZoneRenderer.Vis(var2[2], this.wm, new InitAdapter[]{this.cq}),
            new NodeZoneRenderer.Vis(var2[3], this.cd, new InitAdapter[]{this.cmp, this.ce}),
            new NodeZoneRenderer.Vis(var2[4], this.n99, new InitAdapter[]{this.cf, this.cg, this.q}),
            new NodeZoneRenderer.Vis(var2[5], this.by, new InitAdapter[0]),
            new NodeZoneRenderer.Vis(var2[6], this.bz, new InitAdapter[]{this.ca, this.cb, this.cc}),
            new NodeZoneRenderer.Vis(var2[7], this.cr, new InitAdapter[0]),
            new NodeZoneRenderer.Vis(var2[8], this.cu, new InitAdapter[0]),
            new NodeZoneRenderer.Vis(var2[9], this.cx, new InitAdapter[]{this.cy, this.cz, this.da}),
            new NodeZoneRenderer.Vis(var2[10], this.db, new InitAdapter[0])
         };
         this.ht = var1;
      }

      return var1;
   }

   public boolean b99(int var1) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      NodeZoneRenderer.Vis[] var2 = this.a();
      if (var1 >= 0 && var1 < var2.length) {
         for (InitAdapter var6 : var2[var1].c) {
            if (!(var6 instanceof ItemDescriptor)) {
               this.c(var6);
            }
         }

         switch (var1) {
            case 1:
               this.c(this.bu);
               this.c(this.bv);
               break;
            case 2:
               this.c(this.wmX);
               this.c(this.wmY);
               break;
            case 3:
               this.c(this.cmpX);
               this.c(this.cmpY);
               break;
            case 4:
               this.c(this.bw);
               this.c(this.bx);
               break;
            case 5:
               this.c(this.kbX);
               this.c(this.kbY);
               break;
            case 6:
               this.c(this.spX);
               this.c(this.spY);
               break;
            case 7:
               this.c(this.cs);
               this.c(this.ct);
               break;
            case 8:
               this.c(this.cv);
               this.c(this.cw);
            case 9:
            default:
               break;
            case 10:
               this.c(this.dc);
               this.c(this.dd);
         }

         return true;
      } else {
         return false;
      }
   }

   private void c(InitAdapter var1) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      InitAdapter[] var2 = this.hu;
      Object[] var3 = this.hv;
      if (var2 != null && var3 != null) {
         for (int var4 = 0; var4 < var2.length; var4++) {
            if (var2[var4] == var1) {
               if (var3[var4] != null) {
                  var1.a(var3[var4]);
               }

               return;
            }
         }
      }
   }

   private void d(long var1) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.hw = var1 == 0L ? 1L : var1;
      this.hx = this.cx.f();
      this.hy = this.cr.f();
      this.ic = this.bt.p();
      this.hz = this.o99.f();
      this.ie = this.cf.f();
      this.if99 = this.ci.f();
      this.id = this.cj.p();
      this.ig = this.cq.f();
      this.ih = this.cy.f();
      this.ia = this.q.f();
      this.ib = this.cg.f();
      boolean[] var3 = this.ex;
      boolean var4 = this.cmp.f();
      boolean var5 = this.cd.f();
      var3[0] = this.m99.f();
      var3[1] = this.n99.f();
      var3[2] = this.by.f();
      var3[3] = this.bz.f();
      var3[4] = var4 || var5;
      var3[5] = this.wm.f();
      var3[6] = this.hy;
      var3[7] = this.cu.f();
      var3[8] = this.db.f();
      var3[9] = false;
      var3[10] = var4;
      var3[11] = var5;
      var3[12] = var5 && this.ce.f();
   }

   private void f99() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      boolean var1 = super.f;
      boolean var2 = var1 && this.hx;
      HOTBAR_ON = var2;
      if (!var2) {
         ACTION_LIFT = 0.0F;
      }

      POTIONS_ON = var1 && PanelZoneCache.POT_LIVE && this.hy && System.nanoTime() - ij < 250000000L;
   }

   private void g(boolean var1, float var2) {
      if (ja != 0) {
         new Object().hashCode();
      }

      boolean[] var3 = this.ex;
      boolean var4 = super.f;
      float var5 = var2 / 0.18F;
      float var6 = this.ez;
      if (var4) {
         var6 = var1 ? (var6 > 0.0F ? 1.0F : 0.0F) : (var6 + var5 > 1.0F ? 1.0F : var6 + var5);
      } else {
         var6 = var1 ? 0.0F : (var6 - var5 < 0.0F ? 0.0F : var6 - var5);
      }

      this.ez = var6;
      float[] var7 = this.ey;
      float[] var8 = this.fb;
      float[] var9 = this.fc;
      boolean[] var10 = this.fa;

      for (int var11 = 0; var11 < 13; var11++) {
         boolean var12 = var3[var11];
         float var13 = var7[var11];
         if (var1) {
            var13 = var12 ? 1.0F : 0.0F;
         } else if (var12) {
            var13 = var13 + var5 > 1.0F ? 1.0F : var13 + var5;
         } else {
            var13 = var13 - var5 < 0.0F ? 0.0F : var13 - var5;
         }

         var7[var11] = var13;
         float var14 = var13 < var6 ? var13 : var6;
         var8[var11] = var14;
         var9[var11] = var14 * var14 * (3.0F - 2.0F * var14);
         var10[var11] = var4 && var12;
      }
   }

   void h99() {
      if (ja != 0) {
         System.nanoTime();
      }

      this.bu.a(50.0);
      this.bv.a(1.2);
      this.cmpX.a(50.0);
      this.cmpY.a(20.5);
      this.wmX.a(50.0);
      this.wmY.a(1.2);
      this.kbX.a(97.5);
      this.kbY.a(44.0);
      this.bw.a(99.0);
      this.bx.a(1.0);
      this.spX.a(2.0);
      this.spY.a(30.0);
      this.cmp.a(Boolean.FALSE);
      this.ch.a(1.0);
      this.hw = 0L;
   }

   public void i(InitAdapter var1) {
      byte var2 = 0;

      label17:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (ja != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 == this.ch) {
                  this.ch.a(0.0);
                  var2 = 2;
                  break;
               }
            case 2:
               break label17;
         }
      }

      this.hw = 0L;
   }

   private static int j(String var0, String[] var1) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].equals(var0)) {
            return var2;
         }
      }

      return 0;
   }

   private void k(int var1) {
      if (ja != 0) {
         new Object().hashCode();
      }

      String var2 = this.if99;
      if (var2 != this.dh) {
         this.dh = var2;
         this.dk = j(var2, de);
      }

      StyleKeyCache.e(var1);
      StyleKeyCache.a(this.dk, (int)Math.round(this.id));
   }

   public static void l(DrawContext var0) {
      if (ja != 0) {
         System.nanoTime();
      }

      CoreZoneProcessor var1 = I;
      if (var1 == null) {
         NoticeQueue.n = 0;
      } else {
         CoreZoneProcessor var2 = var1;
         if (!var2.f) {
            if (var1.ez > 0.0F && System.nanoTime() - var1.ev > 250000000L) {
               var1.ez = 0.0F;
            }

            if (var1.ez <= 0.0F) {
               NoticeQueue.n = 0;
               return;
            }
         }

         var1.f99();
         boolean var3 = false;

         try {
            var3 = a.debugHudEntryList.isF3Enabled();
         } catch (Throwable var6) {
         }

         if (!(a.currentScreen instanceof LoaderDelegate) && a.player != null && !a.options.hudHidden && !var3) {
            var0.createNewRootLayer();

            try {
               var1.o(var0, 274320098 ^ -274319621, -1199115702 ^ 1199115859, -1);
            } catch (Throwable var5) {
               var1.p(var5);
               var1.q(var0);
            }
         } else {
            NoticeQueue.n = 0;
         }
      }
   }

   public static boolean m(DrawContext var0, RenderTickCounter var1) {
      if (ja != 0) {
         new Object().hashCode();
      }

      CoreZoneProcessor var2 = I;
      CoreZoneProcessor var3 = var2;
      ACTION_LIFT = 0.0F;
      if (var2 != null && var3.f) {
         long var4 = System.nanoTime();
         if (var2.hw == 0L || a.currentScreen != null || var4 - var2.hw >= 50000000L || var4 - var2.hw < 0L) {
            var2.d(var4);
         }

         if (!var2.hx) {
            HOTBAR_ON = false;
            return false;
         }

         if (a.player != null && !a.options.hudHidden && a.interactionManager != null && a.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
            boolean var6 = false;
            Matrix3x2fStack var7 = var0.getMatrices();
            var7.pushMatrix();

            try {
               if (var2.ch.p() < 1.0) {
                  var2.h99();
               }

               double var8 = a.getWindow().getScaleFactor();
               if (var8 <= 0.0) {
                  var8 = 1.0;
               }

               int var10 = Math.max(1, Math.min(3, (int)Math.round(var2.ic)));
               var2.fd = var10;
               float var11 = (float)(var10 / var8);
               var2.dp = var11;
               int var12 = Math.max(1, (int)(a.getWindow().getScaledWidth() / var11));
               int var13 = Math.max(1, (int)(a.getWindow().getScaledHeight() / var11));
               var2.k(var10);
               String var14 = var2.ih;
               if (var14 != var2.dj) {
                  var2.dj = var14;
                  var2.dm = j(var14, dg);
               }

               long var15 = System.nanoTime();
               var2.dq = var2.dr == 0L ? 0.0F : Math.min(0.1F, (float)(var15 - var2.dr) / 1.0E9F);
               var2.dr = var15;
               var2.dv = var13;
               var7.scale(var11, var11);
               var6 = BarZoneCache.a(var0, var1, var2, var12, var13);
               if (var6) {
                  var2.ds = var15;
                  float var17 = a.getWindow().getScaledHeight() - 61.0F + 2.0F - var2.dv * var11;
                  ACTION_LIFT = var17 > 0.0F ? (float)(Math.ceil(var17 * var8 - 0.001) / var8) : 0.0F;
               } else {
                  var2.ew[9][2] = 0;
               }
            } catch (Throwable var21) {
               var2.p(var21);
               var6 = false;
               ACTION_LIFT = 0.0F;
            } finally {
               var7.popMatrix();
            }

            return var6;
         } else {
            var2.ew[9][2] = 0;
            return false;
         }
      } else {
         HOTBAR_ON = false;
         return false;
      }
   }

   public static void n(long var0) {
      if (ja != 0) {
         new Object().hashCode();
      }

      try {
         long var2 = System.nanoTime();
         long var4 = fg;
         if (var4 != 0L) {
            double var6 = (var2 - var4) / 1.0E9;
            long var8 = var0 - fh;
            if (var6 > 0.25 && var6 < 15.0 && var8 > 0L && var8 <= 600L) {
               float var10 = (float)Math.min(20.0, var8 / var6);
               float var11 = fi;
               fi = var11 + (var10 - var11) * 0.4F;
            }
         }

         fh = var0;
         fg = var2;
      } catch (Throwable var12) {
      }
   }

   public void o(DrawContext var1, int var2, int var3, int var4) {
      if (ja != 0) {
         System.nanoTime();
      }

      if (this.ch.p() < 1.0) {
         this.h99();
      }

      long var5 = System.nanoTime();
      if (this.hw == 0L || a.currentScreen != null || var2 > (1457128649 ^ -1457129264) || var4 != -1 || var5 - this.hw >= 50000000L || var5 - this.hw < 0L) {
         this.d(var5);
      }

      double var7 = a.getWindow().getScaleFactor();
      if (var7 <= 0.0) {
         var7 = 1.0;
      }

      int var9 = Math.max(1, Math.min(3, (int)Math.round(this.ic)));
      this.fd = var9;
      this.ba(var9);
      iu = 1.0F / var9;
      this.eo = this.hz;
      this.ep = !this.eo;
      boolean var10 = var2 > (1191237505 ^ -1191236712) || var4 != -1;
      this.do99 = var10;
      float var11 = (float)(var9 / var7);
      this.dp = var11;
      int var12 = Math.max(1, (int)(a.getWindow().getScaledWidth() / var11));
      int var13 = Math.max(1, (int)(a.getWindow().getScaledHeight() / var11));
      int var14 = var2 <= (1632947971 ^ -1632947430) ? 425417721 ^ -425416736 : (int)(var2 / var11);
      int var15 = var3 <= (1234231315 ^ -1234232310) ? 966044409 ^ -966043936 : (int)(var3 / var11);
      long var16 = System.nanoTime();
      boolean var18 = this.ev == 0L || var16 - this.ev > 250000000L;
      float var19 = this.ev == 0L ? 0.0F : Math.min(0.1F, (float)(var16 - this.ev) / 1.0E9F);
      this.ev = var16;
      this.dn = var19;
      this.g(var18, var19);

      try {
         this.k(var9);
         String var20 = this.ig;
         if (var20 != this.di) {
            this.di = var20;
            this.dl = j(var20, df);
         }
      } catch (Throwable var53) {
         this.p(var53);
      }

      int var56 = a.getCurrentFps();
      int var21 = Math.max(0, this.bc());
      if (!(var19 <= 0.0F) && !(fj < 0.0F)) {
         float var22 = 1.0F - (float)Math.exp(-var19 * 4.0F);
         fj = fj + (var56 - fj) * var22;
         fk = fk + (var21 - fk) * var22;
      } else {
         fj = var56;
         fk = var21;
      }

      int var57 = a.world == null ? 0 : System.identityHashCode(a.world);
      if (var57 != this.fl) {
         this.fl = var57;
         fg = 0L;
         fi = 20.0F;
         fk = -1.0F;
      }

      if (var16 - this.em > 5000000000L) {
         this.em = var16;
         this.ej.clear();
         this.es = -1.0F;
         this.en++;
      }

      Matrix3x2fStack var23 = var1.getMatrices();
      var23.pushMatrix();

      try {
         var23.scale(var11, var11);
         boolean[] var24 = this.fa;
         float[] var25 = this.fb;
         if (!var24[0] && !(var25[0] > 0.0F)) {
            this.ew[0][2] = 0;
         } else {
            try {
               HeaderZoneCache.a(var1, this, var12, var13, var10);
            } catch (Throwable var52) {
               this.p(var52);
            }
         }

         boolean var26 = var24[4] || var25[10] > 0.0F || var25[11] > 0.0F;
         if (var26) {
            try {
               this.ai(var1, var12, var13);
            } catch (Throwable var51) {
               this.p(var51);
            }
         } else {
            this.ew[4][2] = 0;
         }

         if (!var24[5] && !(var25[5] > 0.0F)) {
            this.ew[5][2] = 0;
         } else {
            try {
               HeaderZoneCache.o(var1, this, var12, var13, var26, var10);
            } catch (Throwable var50) {
               this.p(var50);
            }
         }

         int var27 = 0;
         if (!var24[1] && !(var25[1] > 0.0F)) {
            this.ew[1][2] = 0;
         } else {
            try {
               this.ar(var1, var12, var13, var19);
               int[] var28 = this.ew[1];
               if (var24[1] && var28[2] > 0 && var28[0] + var28[2] > var12 * 0.6F && var28[1] < var13 * 0.3F) {
                  var27 = Math.max(0, Math.round((var28[1] + var28[3]) * var11) + 4 - 8);
               }
            } catch (Throwable var49) {
               this.p(var49);
            }
         }

         if (var2 <= (-898729908 ^ 898729045) && var4 == -1) {
            NoticeQueue.n = var27;
         }

         if (!var24[2] && !(var25[2] > 0.0F)) {
            this.ew[2][2] = 0;
         } else {
            try {
               PanelZoneCache.m(var1, this, var12, var13, var10);
            } catch (Throwable var48) {
               this.p(var48);
            }
         }

         if (!var24[3] && !(var25[3] > 0.0F)) {
            this.ew[3][2] = 0;
         } else {
            try {
               if (var24[3] && System.currentTimeMillis() - this.hp >= 250L) {
                  this.av();
               }

               this.au(var1, var12, var13);
            } catch (Throwable var47) {
               this.p(var47);
            }
         }

         if (!var24[6] && !(var25[6] > 0.0F)) {
            this.ew[6][2] = 0;
         } else {
            try {
               PanelZoneCache.a(var1, this, var12, var13, var10);
            } catch (Throwable var46) {
               this.p(var46);
            }
         }

         if (!var24[7] && !(var25[7] > 0.0F)) {
            this.ew[7][2] = 0;
         } else {
            try {
               PanelZoneCache.y(var1, this, var12, var13, var10);
            } catch (Throwable var45) {
               this.p(var45);
            }
         }

         if (!var24[8] && !(var25[8] > 0.0F)) {
            this.ew[8][2] = 0;
         } else if (!var10 && !NoticeZoneCache.at) {
            this.ew[8][2] = 0;
         } else {
            try {
               NoticeZoneCache.a(var1, this, var12, var13, var10);
            } catch (Throwable var44) {
               this.p(var44);
            }
         }

         if (var4 < 0 && var14 <= (-1703217652 ^ 1703217685)) {
            this.du = Long.MIN_VALUE;
         } else {
            try {
               this.r();
               this.v(var1, var14, var15, var4, var18);
            } catch (Throwable var43) {
               this.p(var43);
            }
         }
      } catch (Throwable var54) {
         this.p(var54);
      } finally {
         var23.popMatrix();
      }

      if (this.ik != null) {
         this.q(var1);
      }
   }

   void p(Throwable var1) {
      if (ja != 0) {
         System.nanoTime();
      }

      if (this.im++ == 0) {
         try {
            System.err
               .println(
                  StringDecoder.d(
                     new byte[]{
                        -19, -5, -35, -63, -38, -38, -59, -36, -29, -97, -12, -24, -2, -101, -37, -40, -44, -61, -124, -61, -61, -54, -52, -60, -54, -107
                     },
                     -351782002 ^ -351782088
                  )
               );
            var1.printStackTrace();
         } catch (Throwable var3) {
         }
      }

      this.ik = var1;
      this.il = System.nanoTime();
   }

   private void q(DrawContext var1) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      Throwable var2 = this.ik;
      if (var2 != null && System.nanoTime() - this.il <= 3000000000L) {
         try {
            String var3 = var2.getMessage();
            String var4 = QueryZone.r(new byte[]{113, 101, 111, 24, 5}, 58)
               + var2.getClass().getSimpleName()
               + (var3 == null ? "" : TokenExtractor.w(new byte[]{-74, -83}, 660468850 ^ 660468982) + var3);
            if (var4.length() > 110) {
               var4 = var4.substring(0, 110);
            }

            StackTraceElement[] var5 = var2.getStackTrace();
            String var6 = var5.length > 0
               ? YieldKeeper.v(new byte[]{10, 20}, 42)
                  + var5[0].getClassName()
                  + TokenExtractor.w(new byte[]{102}, 76)
                  + var5[0].getMethodName()
                  + QueryZone.r(new byte[]{92}, 101)
                  + var5[0].getLineNumber()
               : "";
            var1.drawText(a.textRenderer, Text.literal(var4 + var6), 4, a.getWindow().getScaledHeight() - 60, -1598279103 ^ 1598252820, true);
         } catch (Throwable var7) {
         }
      }
   }

   private void r() {
      if (ja != 0) {
         System.nanoTime();
      }

      int[] var1 = ThemeCache.e();
      int[] var2 = ThemeCache.f();
      if (var1[0] != this.fy || var1[1] != this.fz || var1[2] != this.ga || var2[0] != this.gb || var2[1] != this.gc || var2[2] != this.gd) {
         int[] var3 = new int[]{255, 255, 255};
         int[] var4 = ThemeCache.l(var3, var1, 0.35);
         int[] var5 = ThemeCache.l(var3, var1, 0.1);
         this.fm = ThemeCache.mix(var2, var1, 0.06, 1365630973 ^ 1365630777);
         this.fn = ThemeCache.m(var4[0], var4[1], var4[2], 34);
         this.fo = ThemeCache.m(var5[0], var5[1], var5[2], -596136659 ^ -596136494);
         this.fp = ThemeCache.mix(ThemeCache.l(var2, var5, 0.56), var1, 0.1, 478687808 ^ 478687935);
         this.fq = ThemeCache.mix(ThemeCache.l(var2, var5, 0.46), var1, 0.34, -2132218543 ^ -2132218450);
         this.fr = ThemeCache.m(var1[0], var1[1], var1[2], 1179717604 ^ 1179717403);
         this.fs = ThemeCache.mix(var1, var3, 0.38, -135016736 ^ -135016929);
         this.ft = ThemeCache.mix(var2, var1, 0.2, 1872863745 ^ 1872863968);
         int[] var6 = ThemeCache.l(var3, var1, 0.55);
         this.fu = ThemeCache.mix(var2, var1, 0.3, 498035001 ^ 498035191);
         this.fv = ThemeCache.m(var6[0], var6[1], var6[2], 70);
         this.fw = ThemeCache.mix(var1, new int[]{255, 190, 214}, 0.55, 1078045680 ^ 1078045455);
         this.fx = ThemeCache.m(-523432427 ^ -523432214, 268645257 ^ 268645215, 1755667601 ^ 1755667485, 1372264136 ^ 1372263991);
         iv = (int)(var2[0] * 0.22F) << 16 | (int)(var2[1] * 0.22F) << 8 | (int)(var2[2] * 0.22F);
         this.fy = var1[0];
         this.fz = var1[1];
         this.ga = var1[2];
         this.gb = var2[0];
         this.gc = var2[1];
         this.gd = var2[2];
      }
   }

   private void s() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var1 = StyleKeyCache.A;
      int[] var2 = new int[]{var1 >> 16 & (2054633611 ^ 2054633588), var1 >> 8 & (1850300789 ^ 1850300810), var1 & (711326283 ^ 711326388)};
      int[] var3 = new int[]{255, 255, 255};
      int[] var4 = ThemeCache.l(var3, var2, 0.36);
      float[] var5 = Color.RGBtoHSB(var2[0], var2[1], var2[2], null);
      float var6 = 0.8333333F - var5[0];
      if (var6 > 0.5F) {
         var6--;
      } else if (var6 < -0.5F) {
         var6++;
      }

      float var7 = var5[0] + Math.max(-0.16666667F, Math.min(0.16666667F, var6));
      int var8 = Color.HSBtoRGB(var7 - (float)Math.floor(var7), var5[1], var5[2]);
      int[] var9 = ThemeCache.l(
         var3, new int[]{var8 >> 16 & (1423175420 ^ 1423175171), var8 >> 8 & (-424345517 ^ -424345428), var8 & (1200789736 ^ 1200789527)}, 0.5
      );
      this.ip = 1488682962 ^ 1483515918;
      this.iq = var4[0] << 16 | var4[1] << 8 | var4[2];
      this.ir = var9[0] << 16 | var9[1] << 8 | var9[2];
      this.it = StyleKeyCache.gen;
   }

   private Style[] t() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      int var1 = (this.ip * 31 + this.iq) * 31 + this.ir ^ this.eb << 26;
      if (var1 != this.is) {
         this.is = var1;

         for (int var2 = 0; var2 <= 32; var2++) {
            float var3 = var2 / 32.0F;
            int var4 = var3 < 0.5F ? this.ip : this.iq;
            int var5 = var3 < 0.5F ? this.iq : this.ir;
            float var6 = var3 < 0.5F ? var3 * 2.0F : var3 * 2.0F - 1.0F;
            int var7 = (int)(
               (var4 >> 16 & (1442346501 ^ 1442346746)) + ((var5 >> 16 & (-387419550 ^ -387419491)) - (var4 >> 16 & (580764531 ^ 580764556))) * var6 + 0.5F
            );
            int var8 = (int)(
               (var4 >> 8 & (1352263727 ^ 1352263888)) + ((var5 >> 8 & (169906502 ^ 169906617)) - (var4 >> 8 & (146659800 ^ 146659623))) * var6 + 0.5F
            );
            int var9 = (int)((var4 & (392013854 ^ 392014049)) + ((var5 & (1375252286 ^ 1375252417)) - (var4 & (1007779011 ^ 1007778876))) * var6 + 0.5F);
            this.io[var2] = iw.withColor(var7 << 16 | var8 << 8 | var9);
         }
      }

      return this.io;
   }

   private OrderedText u(BuilderFactory var1, float[] var2) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return var3 -> {
         if (ja != 0) {
            System.nanoTime();
         }

         assert var3 != null
            && var1 != null
            && var1.c != null
            && var2 != null
            && var2.length == 3
            && this.io != null
            && this.io.length == 33
            && dw.length == 5
            && de.length == 6
            && df.length == 2
            && dg.length == 2
            && dx.length == 5
            && dy.length == 5
            && bk.length == 6
            && L.length > 8 : YieldKeeper.v(new byte[]{108, 100, 64, 72, 120, 36}, 11);
         char[] var4 = var1.c;
         int var5 = var1.cK;
         int var6 = var4.length;
         boolean var7 = false;
         if (var6 > 1) {
            char var8 = (char)(var4[1] ^ var5 + 31);
            var7 = var8 == '.' || var8 == (-1690139321 ^ -1690142135);
         }

         int var21 = var7 ? var6 - 1 : var6;
         float var9 = var21 > 0 ? 1.0F / var21 : 0.0F;
         Style[] var10 = this.io;
         float var11 = var2[0];
         float var12 = var2[1];
         float var13 = var2[2];

         try {
            int var14 = 0;
            int var15 = 0;

            while (var14 < var6) {
               if (!var7 || var14 != 1) {
                  char var16 = (char)(var4[var14] ^ var5 + var14 * 31);
                  if (var16 >= (251860807 ^ 251914310) && var16 <= (-1221037212 ^ -1221030854)) {
                     var16 = (char)(var16 - (-713964953 ^ -713999225));
                  }

                  float var17 = var12 + var13 * (var15 + 0.5F) * var9;
                  float var18 = var11 + 0.4F * (0.5F - var17);
                  int var19 = (int)((var18 < 0.0F ? 0.0F : (var18 > 1.0F ? 1.0F : var18)) * 32.0F + 0.5F);
                  if (!var3.accept(var15++, var10[var19], var16)) {
                     return false;
                  }
               }

               var14++;
            }

            return true;
         } catch (RuntimeException var20) {
            throw var20;
         }
      };
   }

   private void v(DrawContext var1, int var2, int var3, int var4, boolean var5) {
      if (ja != 0) {
         System.nanoTime();
      }

      long var6 = this.ds;
      long var8 = this.du;
      boolean var10 = var6 != var8 && HOTBAR_ON && System.nanoTime() - var6 < 250000000L;
      this.du = var6;
      float var11 = this.dt;
      float var12 = this.dn / 0.18F;
      if (var5 || var8 == Long.MIN_VALUE) {
         var11 = var10 ? 1.0F : 0.0F;
      } else if (var10) {
         var11 = var11 + var12 > 1.0F ? 1.0F : var11 + var12;
      } else {
         var11 = var11 - var12 < 0.0F ? 0.0F : var11 - var12;
      }

      this.dt = var11;
      float[] var13 = this.fc;
      boolean[] var14 = this.fa;

      for (int var15 = 0; var15 < 10; var15++) {
         int[] var16 = this.ew[var15];
         if (var16[2] > 0) {
            float var17 = var15 == 9 ? var11 * var11 * (3.0F - 2.0F * var11) : var13[var15];
            if (var15 == 5 && this.ew[0][2] > 0) {
               float var18 = this.ey[0];
               var17 *= 1.0F - var18 * var18 * (3.0F - 2.0F * var18);
            }

            if (!(var17 < 0.02F)) {
               boolean var21 = var15 != 9
                  && var14[var15]
                  && (var15 == var4 || var2 >= var16[0] && var2 <= var16[0] + var16[2] && var3 >= var16[1] && var3 <= var16[1] + var16[3]);
               int var19 = var21 ? (var17 < 1.0F ? az(this.fs, var17) : this.fs) : az(this.fr, 0.4F * var17);
               var1.fill(var16[0] - 1, var16[1] - 1, var16[0] + var16[2] + 1, var16[1], var19);
               var1.fill(var16[0] - 1, var16[1] + var16[3], var16[0] + var16[2] + 1, var16[1] + var16[3] + 1, var19);
               var1.fill(var16[0] - 1, var16[1], var16[0], var16[1] + var16[3], var19);
               var1.fill(var16[0] + var16[2], var16[1], var16[0] + var16[2] + 1, var16[1] + var16[3], var19);
            }
         }
      }
   }

   boolean w(int var1) {
      if (ja != 0) {
         new Object().hashCode();
      }

      switch (var1) {
         case 0:
            return this.m99.f();
         case 1:
            return this.n99.f();
         case 2:
            return this.by.f();
         case 3:
            return this.bz.f();
         case 4:
            return this.cmp.f() || this.cd.f();
         case 5:
            return this.wm.f();
         case 6:
            return this.cr.f();
         case 7:
            return this.cu.f();
         case 8:
            return this.db.f();
         case 9:
            return this.cx.f();
         default:
            return false;
      }
   }

   private static boolean x(int var0) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return var0 == 0 || var0 == 4 || var0 == 5 || var0 == 8;
   }

   private float y() {
      if (ja != 0) {
         System.nanoTime();
      }

      double var1 = a.getWindow().getScaleFactor();
      if (var1 <= 0.0) {
         var1 = 1.0;
      }

      return (float)(Math.max(1, this.fd) / var1);
   }

   public int z(int var1, int var2) {
      if (ja != 0) {
         System.nanoTime();
      }

      float var3 = this.y();
      float var4 = var1 / var3;
      float var5 = var2 / var3;

      for (int var6 = 9; var6 >= 0; var6--) {
         if (var6 != 9) {
            int[] var7 = this.ew[var6];
            if (var7[2] > 0 && this.w(var6) && var4 >= var7[0] && var4 <= var7[0] + var7[2] && var5 >= var7[1] && var5 <= var7[1] + var7[3]) {
               this.fe = var4 - var7[0];
               this.ff = var5 - var7[1];
               return var6;
            }
         }
      }

      return -1;
   }

   public void aa(int var1, int var2, int var3) {
      if (ja != 0) {
         System.nanoTime();
      }

      if (var1 >= 0 && var1 < 10 && var1 != 9) {
         float var4 = this.y();
         int var5 = Math.max(1, (int)(a.getWindow().getScaledWidth() / var4));
         int var6 = Math.max(1, (int)(a.getWindow().getScaledHeight() / var4));
         int[] var7 = this.ew[var1];
         double var8 = var2 / var4 - this.fe;
         double var10 = var3 / var4 - this.ff;
         var8 = Math.max(0.0, Math.min(Math.max(0, var5 - var7[2]), var8));
         var10 = Math.max(0.0, Math.min(Math.max(0, var6 - var7[3]), var10));
         double var12;
         double var14;
         if (x(var1)) {
            var12 = Math.max(0.0, Math.min(100.0, (var8 + var7[2] / 2.0) / var5 * 100.0));
            var14 = Math.max(0.0, Math.min(100.0, var10 / var6 * 100.0));
         } else {
            if (var8 + var7[2] / 2.0 < var5 / 2.0) {
               var12 = Math.max(0.0, Math.min(49.9, var8 / var5 * 100.0));
            } else {
               var12 = Math.max(50.0, Math.min(100.0, (var8 + var7[2]) / var5 * 100.0));
            }

            if (var10 + var7[3] / 2.0 < var6 / 2.0) {
               var14 = Math.max(0.0, Math.min(49.9, var10 / var6 * 100.0));
            } else {
               var14 = Math.max(50.0, Math.min(100.0, (var10 + var7[3]) / var6 * 100.0));
            }
         }

         switch (var1) {
            case 0:
               this.bu.a(var12);
               this.bv.a(var14);
               break;
            case 1:
               this.bw.a(var12);
               this.bx.a(var14);
               break;
            case 2:
               this.kbX.a(var12);
               this.kbY.a(var14);
               break;
            case 3:
               this.spX.a(var12);
               this.spY.a(var14);
               break;
            case 4:
               this.cmpX.a(var12);
               this.cmpY.a(var14);
               break;
            case 5:
               this.wmX.a(var12);
               this.wmY.a(var14);
               break;
            case 6:
               this.cs.a(var12);
               this.ct.a(var14);
               break;
            case 7:
               this.cv.a(var12);
               this.cw.a(var14);
               break;
            case 8:
               this.dc.a(var12);
               this.dd.a(var14);
         }
      }
   }

   void ab(int var1, int var2, int var3, int var4, int var5) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int[] var6 = this.ew[var1];
      var6[0] = var2;
      var6[1] = var3;
      var6[2] = var4;
      var6[3] = var5;
   }

   static int ac(double var0, int var2, int var3) {
      if (ja != 0) {
         new Object().hashCode();
      }

      return Math.max(2, Math.min(Math.max(2, var3 - var2 - 2), (int)(var0 / 100.0 * var3 - var2 / 2.0)));
   }

   static int ad(double var0, int var2, int var3) {
      if (ja != 0) {
         System.nanoTime();
      }

      return Math.max(2, Math.min(Math.max(2, var3 - var2 - 2), (int)(var0 / 100.0 * var3)));
   }

   static int ae(double var0, int var2, int var3) {
      if (ja != 0) {
         System.nanoTime();
      }

      double var4 = var0 / 100.0 * var3;
      return Math.max(2, Math.min(Math.max(2, var3 - var2 - 2), (int)(var0 >= 50.0 ? var4 - var2 : var4)));
   }

   static int af(double var0, int var2, int var3) {
      if (ja != 0) {
         new Object().hashCode();
      }

      double var4 = var0 / 100.0 * var3;
      return Math.max(2, Math.min(Math.max(2, var3 - var2 - 2), (int)(var0 >= 50.0 ? var4 - var2 : var4)));
   }

   private static float ag(double var0, float var2, int var3, int var4) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      float var5 = (float)(var0 / 100.0 * var3);
      float var6 = var0 >= 50.0 ? var5 - var2 : var5;
      float var7 = Math.max(2.0F, var3 - var2 - 2.0F);
      var6 = var6 < 2.0F ? 2.0F : (var6 > var7 ? var7 : var6);
      return (float)Math.round(var6 * var4) / var4;
   }

   int ah() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      long var1 = fg;
      if (var1 == 0L) {
         return -1;
      }

      double var3 = (System.nanoTime() - var1) / 1.0E9;
      if (var3 > 30.0) {
         return -1;
      }

      float var5 = fi;
      if (var3 > 1.6) {
         var5 = (float)Math.min(var5, 20.0 / var3);
      }

      return Math.round(Math.max(0.0F, Math.min(20.0F, var5)) * 10.0F);
   }

   private void ai(DrawContext var1, int var2, int var3) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      float[] var4 = this.fb;
      float[] var5 = this.fc;
      boolean var6 = var4[10] > 0.0F;
      boolean var7 = var4[11] > 0.0F && a.player != null;
      boolean var8 = false;
      if (var7) {
         int var9 = MathHelper.floor(a.player.getX());
         int var10 = MathHelper.floor(a.player.getY());
         int var11 = MathHelper.floor(a.player.getZ());
         if (this.gm == null || var9 != this.gq || var10 != this.gr || var11 != this.gs || this.gt != StyleKeyCache.gen || this.gu != StyleKeyCache.ba) {
            this.aj(var9, var10, var11);
         }

         long var12 = System.nanoTime();
         float var14 = 27.5F + this.go + 8.5F;
         if (!(this.gp <= 0.0F) && var12 - this.gv <= 250000000L) {
            this.gp = this.gp + (var14 - this.gp) * (1.0F - (float)Math.exp(-this.dn * 13.0F));
            if (Math.abs(var14 - this.gp) < 0.02F) {
               this.gp = var14;
            }

            if (this.gp < var14 - 8.5F) {
               this.gp = var14 - 8.5F;
            }
         } else {
            this.gp = var14;
         }

         this.gv = var12;
         if (var4[12] > 0.0F && a.world != null) {
            boolean var15 = a.world.getRegistryKey() == World.NETHER;
            if (var15 || a.world.getRegistryKey() == World.OVERWORLD) {
               double var16 = var15 ? 8.0 : 0.125;
               int var18 = MathHelper.floor(a.player.getX() * var16);
               int var19 = MathHelper.floor(a.player.getZ() * var16);
               int var20 = var15 ? 1 : 0;
               if (this.ha == null || var18 != this.hc || var19 != this.hd || var20 != this.he || this.hf != StyleKeyCache.ba) {
                  this.am(var18, var19, var20);
               }

               var8 = true;
            }
         }
      }

      float var30 = this.ey[10];
      var30 = var30 * var30 * (3.0F - 2.0F * var30);
      float var32 = var6 ? var30 * 17.0F : 0.0F;
      float var33 = Math.max(var6 ? 164.0F : 0.0F, Math.max(var7 ? this.gp : 0.0F, var8 ? this.hb : 0.0F));
      float var34 = Math.max(var6 ? 14.0F : 0.0F, var7 ? var32 + 21.0F + (var8 ? 11.0F : 0.0F) : 0.0F);
      float var13 = Math.max(var6 ? var5[10] : 0.0F, var7 ? var5[11] : 0.0F);
      if (!(var33 <= 0.0F) && !(var34 <= 0.0F) && !(var13 < 0.02F)) {
         float var35 = var33 / 2.0F;
         float var36 = (float)(this.cmpX.p() / 100.0 * var2);
         var36 = Math.max(2.0F + var35, Math.min(var2 - 2.0F - var35, var36));
         int var38 = (int)Math.ceil(var34);
         int var17 = ad(this.cmpY.p(), var38, var3);
         int var39 = (int)Math.floor(var36 - var35);
         this.ab(4, var39, var17, (int)Math.ceil(var36 + var35) - var39, var38);
         var1.createNewRootLayer();
         int var40 = this.fd;
         float var41 = (float)Math.round((var17 + (1.0F - var13) * 4.0F) * var40) / var40;
         int var21 = StyleKeyCache.PANEL;
         int var22 = var21 >>> 24;
         int var23 = var21 & (1332862734 ^ 1334714609);
         if (var6) {
            float var24 = var5[10];
            float var25 = (float)Math.round((var36 - 82.0F) * var40) / var40;
            if (this.eo) {
               StyleKeyCache.r(var1, var25, var41, 164.0F, 14.0F, 6.0F, (int)(var22 * var24 + 0.5F) << 24 | var23);
            }

            this.an(var1, var25, var41, 164.0F, 14.0F, var24);
         }

         if (var7) {
            float var42 = var5[11];
            float var43 = (float)Math.round((var41 + var32) * var40) / var40;
            float var26 = (float)Math.round((var36 - this.gp / 2.0F) * var40) / var40;
            if (this.eo) {
               StyleKeyCache.s(var1, var26, var43, this.gp, 21.0F, (int)(var22 * var42 + 0.5F) << 24 | var23);
            }

            int var27 = StyleKeyCache.A;
            StyleKeyCache.ab(var1, 4, var26 + 8.5F, var43 + 5.5F, 10.0F, (int)((var27 >>> 24) * var42 + 0.5F) << 24 | var27 & (-1171126884 ^ -1160906141));
            int var28 = (int)(255.0F * var42 + 0.5F) << 24 | 1301931794 ^ 1298928357;
            if (this.ep) {
               StyleKeyCache.k(var1, this.gm, this.gn, var26 + 27.5F, var43 + 13.6F, var28);
            } else {
               StyleKeyCache.i(var1, this.gm, var26 + 27.5F, var43 + 13.6F, var28, false);
            }

            if (var8) {
               float var29 = var5[12];
               StyleKeyCache.i(
                  var1, this.ha, var36 - this.hb / 2.0F, var43 + 21.0F + 3.0F + 4.7F, (int)(255.0F * var29 + 0.5F) << 24 | -49451569 ^ -41688228, true
               );
            }
         }
      } else {
         this.ew[4][2] = 0;
      }
   }

   private void aj(int var1, int var2, int var3) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (this.gy != StyleKeyCache.ba) {
         this.ak();
      }

      Style var4 = StyleKeyCache.ST[6];
      Style var5 = var4.withColor(StyleKeyCache.A & (-1597040031 ^ -1607408226));
      Style var6 = StyleKeyCache.ST[this.gw >> 4];
      Style var7 = StyleKeyCache.ST[this.gx >> 4];
      int var8 = this.gw & 15;
      int var9 = this.gx & 15;
      String var10 = bk[3];
      MutableText var11 = Text.empty();
      MutableText var12 = Text.empty();

      for (int var13 = 0; var13 < 3; var13++) {
         String var14 = bk[0 + var13];
         String var15 = Integer.toString(var13 == 0 ? var1 : (var13 == 1 ? var2 : var3));
         var11.append(Text.literal(var14).setStyle(var5));
         var12.append(Text.literal(var14).setStyle(var4));
         MutableText var16 = Text.literal(var10).setStyle(var6);
         var11.append(var16);
         var12.append(var16);
         if (var8 < 12) {
            MutableText var17 = Text.literal(var10).setStyle(StyleKeyCache.ST[var8]);
            var11.append(var17);
            var12.append(var17);
         }

         MutableText var20 = Text.literal(var15).setStyle(var4);
         var11.append(var20);
         var12.append(var20);
         if (var13 < 2) {
            MutableText var18 = Text.literal(var10).setStyle(var7);
            var11.append(var18);
            var12.append(var18);
            if (var9 < 12) {
               MutableText var19 = Text.literal(var10).setStyle(StyleKeyCache.ST[var9]);
               var11.append(var19);
               var12.append(var19);
            }
         }
      }

      this.gm = var11;
      this.gn = var12;
      this.go = StyleKeyCache.g(var12);
      this.gq = var1;
      this.gr = var2;
      this.gs = var3;
      this.gt = StyleKeyCache.gen;
      this.gu = StyleKeyCache.ba;
   }

   private void ak() {
      if (ja != 0) {
         new Object().hashCode();
      }

      String var1 = bk[3];
      float[] var2 = this.gz;

      for (int var3 = 0; var3 < 12; var3++) {
         var2[var3] = StyleKeyCache.f(var3, var1);
      }

      this.gw = al(var2, 3.5F);
      this.gx = al(var2, 5.5F);
      this.gy = StyleKeyCache.ba;
   }

   private static int al(float[] var0, float var1) {
      if (ja != 0) {
         System.nanoTime();
      }

      int var2 = 111;
      float var3 = Float.MAX_VALUE;

      for (int var4 = 0; var4 < var0.length; var4++) {
         float var5 = Math.abs(var0[var4] - var1);
         if (var5 < var3 - 0.001F) {
            var3 = var5;
            var2 = var4 * 16 + 15;
         }

         for (int var6 = var4; var6 < var0.length; var6++) {
            float var7 = Math.abs(var0[var4] + var0[var6] - var1);
            if (var7 < var3 - 0.001F) {
               var3 = var7;
               var2 = var4 * 16 + var6;
            }
         }
      }

      return var2;
   }

   private void am(int var1, int var2, int var3) {
      if (ja != 0) {
         System.nanoTime();
      }

      String var4 = (var3 != 0 ? L[10] : L[11]) + ' ' + var1 + bk[4] + var2;
      MutableText var5 = StyleKeyCache.lit(1, var4);
      this.ha = var5;
      this.hb = StyleKeyCache.g(var5);
      this.hc = var1;
      this.hd = var2;
      this.he = var3;
      this.hf = StyleKeyCache.ba;
   }

   private void an(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      float var7;
      try {
         var7 = a.player.getYaw(a.getRenderTickCounter().getTickProgress(true));
      } catch (Throwable var55) {
         var7 = a.gameRenderer.getCamera().getYaw();
      }

      float var8 = (var7 % 360.0F + 360.0F) % 360.0F;
      float var9 = 1.45F;
      float var10 = var4 / 2.0F - 5.0F;
      float var11 = var2 + var4 / 2.0F;
      int var12 = this.fd;
      if (this.gl != StyleKeyCache.ba) {
         for (int var13 = 0; var13 < 8; var13++) {
            this.gh[var13] = StyleKeyCache.txt(5, hq[var13]);
            this.gi[var13] = StyleKeyCache.f(5, hq[var13]);
         }

         for (int var56 = 0; var56 < 24; var56++) {
            this.gj[var56] = StyleKeyCache.txt(0, hr[var56]);
            this.gk[var56] = StyleKeyCache.f(0, hr[var56]);
         }

         this.gl = StyleKeyCache.ba;
      }

      Matrix3x2fStack var57 = var1.getMatrices();
      TextRenderer var14 = a.textRenderer;
      float var16 = 1.0F / var12;
      boolean var17 = this.ep;
      int var18 = StyleKeyCache.SHADOW & (2144360741 ^ 2133829338);
      float var19 = (float)Math.round((var3 + (var5 + 5.5F) / 2.0F - 7.0F) * var12) / var12;
      float var20 = (float)Math.round((var3 + (var5 + 3.7F) / 2.0F - 7.0F) * var12) / var12;
      int var21 = Math.round((var3 + 5.0F) * var12);
      int var22 = Math.round((var3 + var5 - 5.0F) * var12);
      int var23 = (int)Math.floor((var8 - var10 / var9) / 5.0F) * 5;
      int var24 = (int)Math.ceil((var8 + var10 / var9) / 5.0F) * 5;

      for (int var25 = var23; var25 <= var24; var25 += 5) {
         float var26 = (var25 - var8) * var9;
         float var27 = Math.abs(var26);
         if (!(var27 > var10)) {
            float var28 = (var27 - (var10 - 24.0F)) / 24.0F;
            var28 = var28 < 0.0F ? 0.0F : (var28 > 1.0F ? 1.0F : var28);
            float var29 = (1.0F - var28 * var28 * (3.0F - 2.0F * var28)) * var6;
            var29 = var29 < 0.0F ? 0.0F : (var29 > 1.0F ? 1.0F : var29);
            int var30 = (var25 % (-1562723166 ^ -1562722870) + (2026572272 ^ 2026571928)) % (-272261290 ^ -272261570);
            float var31 = var11 + var26;
            if (var30 % 15 == 0) {
               boolean var32 = var30 % 45 == 0;
               int var33 = var32 ? (var30 == (848363098 ^ 848363246) ? StyleKeyCache.A : 2098938071 ^ -2098285280) : -2111009148 ^ 2107768855;
               int var34 = (int)((var33 >>> 24 & (1115594233 ^ 1115593990)) * var29);
               if (var34 >= 5) {
                  Text var15 = var32 ? this.gh[var30 / 45] : this.gj[var30 / 15];
                  float var35 = var32 ? this.gi[var30 / 45] : this.gk[var30 / 15];
                  var57.pushMatrix();

                  try {
                     var57.translate((float)Math.round((var31 - var35 / 2.0F) * var12) / var12, var32 ? var19 : var20);
                     int var36 = (int)(var34 * 0.78F);
                     if (var17 && var36 >= 5) {
                        var57.translate(var16, var16);
                        var1.drawText(var14, var15, 0, 0, var36 << 24 | var18, false);
                        var57.translate(-var16, -var16);
                     }

                     var1.drawText(var14, var15, 0, 0, var34 << 24 | var33 & (-736644295 ^ -722973498), false);
                  } finally {
                     var57.popMatrix();
                  }
               }
            } else {
               int var61 = (int)(255.0F * var29 * 0.55F);
               if (var61 >= 4) {
                  var57.pushMatrix();

                  try {
                     var57.scale(var16, var16);
                     int var62 = Math.round(var31 * var12);
                     var1.fill(var62, var21, var62 + 1, var22, var61 << 24 | -10768100 ^ -2801777);
                  } finally {
                     var57.popMatrix();
                  }
               }
            }
         }
      }

      var57.pushMatrix();

      try {
         var57.scale(var16, var16);
         int var58 = StyleKeyCache.A;
         RasterCache.glyph(
            var1,
            6,
            Math.round((var11 - 2.5F) * var12),
            Math.round((var3 + var5 - 4.8F) * var12),
            5 * var12,
            (int)((var58 >>> 24) * var6 + 0.5F) << 24 | var58 & (-1988119278 ^ -1988080915)
         );
      } finally {
         var57.popMatrix();
      }
   }

   OrderedText ao() {
      if (ja != 0) {
         new Object().hashCode();
      }

      try {
         this.r();
      } catch (Throwable var4) {
         this.p(var4);
      }

      int var1 = this.fs & (1745889723 ^ 1760548420);
      if (this.eq == null || var1 != this.et) {
         this.et = var1;
         Style var2 = iw.withColor(var1);
         byte[] var3 = bq;
         this.eq = var2x -> {
            if (ja != 0) {
               new Object().hashCode();
            }

            int var3x = -1;

            for (int var4x = 3; var4x < var3.length; var4x++) {
               if (((var3[var4x] ^ 65 ^ var4x) & (640322321 ^ 640322542)) == 46) {
                  var3x = var4x;
               }
            }

            int var7 = 3;
            int var5 = 0;

            while (var7 < var3.length) {
               char var6 = (char)((var3[var7] ^ 65 ^ var7) & (321289822 ^ 321289889));
               if (!var2x.accept(var5++, var7 == var3x ? var2 : iw, var6)) {
                  return false;
               }

               var7++;
            }

            return true;
         };
         this.er = var1x -> {
            if (ja != 0) {
               Thread.currentThread().getName().length();
            }

            int var2x = 3;
            int var3x = 0;

            while (var2x < var3.length) {
               if (!var1x.accept(var3x++, iw, (char)((var3[var2x] ^ 65 ^ var2x) & (1392139467 ^ 1392139316)))) {
                  return false;
               }

               var2x++;
            }

            return true;
         };
      }

      return this.eq;
   }

   OrderedText ap(BuilderFactory var1) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      OrderedText var2 = this.ei.get(var1);
      if (var2 == null) {
         var2 = var1x -> {
            if (ja != 0) {
               System.nanoTime();
            }

            assert var1x != null
               && var1 != null
               && var1.c != null
               && iw != null
               && ix != null
               && dw.length == 5
               && de.length == 6
               && df.length == 2
               && dg.length == 2
               && dx.length == 5
               && dy.length == 5
               && bk.length == 6
               && L.length > 8 : YieldKeeper.v(new byte[]{68, 53, 19, -51, -99, -102}, 42);
            char[] var2x = var1.c;
            int var3 = var1.cK;
            int var4 = var2x.length;
            boolean var5 = false;
            if (var4 > 1) {
               char var6 = (char)(var2x[1] ^ var3 + 31);
               var5 = var6 == '.' || var6 == (-383797517 ^ -383825411);
            }

            try {
               int var10 = 0;
               int var7 = 0;

               while (var10 < var4) {
                  if (!var5 || var10 != 1) {
                     char var8 = (char)(var2x[var10] ^ var3 + var10 * 31);
                     if (var8 >= (-1171060429 ^ -1170999758) && var8 <= (-202899173 ^ -202834363)) {
                        var8 = (char)(var8 - (-1740429925 ^ -1740383365));
                     }

                     if (!var1x.accept(var7++, iw, var8)) {
                        return false;
                     }
                  }

                  var10++;
               }

               return true;
            } catch (RuntimeException var9) {
               throw var9;
            }
         };
         this.ei.put(var1, var2);
      }

      return var2;
   }

   float aq(BuilderFactory var1) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      if (this.ej.containsKey(var1)) {
         return this.ej.getFloat(var1);
      }

      float var2 = a.textRenderer.getTextHandler().getWidth(this.ap(var1));
      this.ej.put(var1, var2);
      return var2;
   }

   private void ar(DrawContext var1, int var2, int var3, float var4) {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      assert var1 != null
         && var2 > 0
         && var3 > 0
         && var4 >= 0.0F
         && this.ew.length > 1
         && this.fc.length > 1
         && this.ee != null
         && this.ec != null
         && this.ed != null
         && this.ej != null
         && dw.length == 5
         && de.length == 6
         && df.length == 2
         && dg.length == 2
         && dx.length == 5
         && dy.length == 5
         && bk.length == 6
         && L.length > 8 : StringDecoder.d(new byte[]{-8, -17, -1, -24, -44, -16, -23, -17}, -95567507 ^ -95567375);
      SyncDispatcher var5 = ConfigBridge.c != null ? ConfigBridge.c.c99() : null;
      if (var5 != null) {
         float var6 = 1.0F - (float)Math.exp(-var4 * 13.0F);
         List var7 = var5.a();
         int var8 = var7.size();
         boolean var9 = this.ef && this.eg == this.en && this.ee.length == var8;

         try {
            for (int var11 = 0; var9 && var11 < var8; var11++) {
               BuilderFactory var10 = (BuilderFactory)var7.get(var11);
               var9 = var10.f == this.ee[var11];
            }
         } catch (RuntimeException var24) {
            throw var24;
         }

         float var25 = this.eh;
         if (!var9) {
            this.ef = false;
            if (this.ee.length != var8) {
               this.ee = new boolean[var8];
            }

            this.ec.clear();
            var25 = 0.0F;
            boolean var12 = true;

            for (int var13 = 0; var13 < var8; var13++) {
               BuilderFactory var14 = (BuilderFactory)var7.get(var13);
               boolean var15 = var14.f;
               this.ee[var13] = var15;
               if (var14 != this) {
                  float var16 = var15 ? 1.0F : 0.0F;
                  float var17 = this.ed.containsKey(var14) ? this.ed.getFloat(var14) : var16;
                  var17 += (var16 - var17) * var6;
                  if (Math.abs(var16 - var17) < 0.004F) {
                     var17 = var16;
                  }

                  this.ed.put(var14, var17);
                  if (var17 != var16) {
                     var12 = false;
                  }

                  if (var17 > 0.004F) {
                     float var18 = this.ej.containsKey(var14) ? this.ej.getFloat(var14) : this.aq(var14);
                     this.ec.add(var14);
                     if (var16 > 0.0F) {
                        var25 = Math.max(var25, var18);
                     }
                  }
               }
            }

            this.ef = var12;
            this.eg = this.en;
            this.eh = var25;
         }

         if (this.ec.isEmpty()) {
            this.ew[1][2] = 0;
            this.eu = 0.0F;
         } else {
            ArrayList var26 = this.ec;
            int var27 = 1;

            for (int var29 = var26.size(); var27 < var29; var27++) {
               BuilderFactory var31 = (BuilderFactory)var26.get(var27);
               float var33 = this.ej.getFloat(var31);

               int var36;
               for (var36 = var27 - 1; var36 >= 0 && Float.compare(this.ej.getFloat(var26.get(var36)), var33) < 0; var36--) {
                  var26.set(var36 + 1, (BuilderFactory)var26.get(var36));
               }

               var26.set(var36 + 1, var31);
            }

            if (this.hg != StyleKeyCache.ba) {
               this.at();
            }

            float var28 = 9.0F + this.hh + 12.0F + 9.0F + 9.0F;
            float var30 = Math.max(var28, 10.0F + var25 + 7.0F);
            if (var25 <= 0.0F) {
               var30 = this.eu;
            }

            this.eu = this.eu <= 0.0F ? var30 : this.eu + (var30 - this.eu) * var6;
            if (Math.abs(var30 - this.eu) < 0.02F) {
               this.eu = var30;
            }

            float var32 = this.fc[1];
            if (var32 < 0.02F) {
               this.ew[1][2] = 0;
            } else {
               float var34 = 25.5F;
               int var37 = 0;

               for (int var39 = var26.size(); var37 < var39; var37++) {
                  float var19 = this.ed.getFloat(var26.get(var37));
                  var19 = var19 < 0.0F ? 0.0F : (var19 > 1.0F ? 1.0F : var19);
                  var34 += 11.5F * (var19 * var19 * (3.0F - 2.0F * var19));
               }

               var37 = this.fd;
               float var40 = Math.max(var28, this.eu);
               float var42 = ag(this.bw.p(), var40, var2, var37);
               float var20 = ag(this.bx.p(), var34, var3, var37);
               int var21 = (int)Math.floor(var42);
               int var22 = (int)Math.floor(var20);
               this.ab(1, var21, var22, (int)Math.ceil(var42 + var40) - var21, (int)Math.ceil(var20 + var34) - var22);
               var20 = (float)Math.round((var20 + (1.0F - var32) * 4.0F) * var37) / var37;
               var1.createNewRootLayer();
               if (this.eo) {
                  int var23 = StyleKeyCache.PANEL;
                  StyleKeyCache.r(var1, var42, var20, var40, var34, 6.0F, (int)((var23 >>> 24) * var32 + 0.5F) << 24 | var23 & (-248776646 ^ -237762619));
               }

               StyleKeyCache.l(var1, 5, bk[5], var42 + 9.0F, var20 + 13.0F, (int)(255.0F * var32 + 0.5F) << 24 | -623729558 ^ -634957411, this.ep);
               int var44 = StyleKeyCache.A;
               StyleKeyCache.ab(
                  var1, 15, var42 + var40 - 18.0F, var20 + 4.5F, 9.0F, (int)((var44 >>> 24) * var32 + 0.5F) << 24 | var44 & (1827757427 ^ 1812898444)
               );
               this.as(var1, var42, var20, var40, var34, var32);
            }
         }
      }
   }

   private void as(DrawContext var1, float var2, float var3, float var4, float var5, float var6) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      boolean var7 = this.ia;
      boolean var8 = !var7 && this.ib;
      if (var8) {
         if (this.it != StyleKeyCache.gen) {
            this.s();
         }

         this.t();
      }

      ArrayList var9 = this.ec;
      int var10 = var9.size();
      int var11 = this.fd;
      int var12 = StyleKeyCache.A;
      Matrix3x2fStack var13 = var1.getMatrices();
      TextRenderer var14 = a.textRenderer;
      boolean var19 = !this.ef || var4 + 0.01F < 17.0F + this.eh;
      if (var19) {
         var1.enableScissor((int)Math.floor(var2), (int)Math.floor(var3), (int)Math.ceil(var2 + var4), (int)Math.ceil(var3 + var5));
      }

      try {
         var13.pushMatrix();

         try {
            var13.scale(1.0F / var11, 1.0F / var11);
            float var20 = var3 + 29.5F;

            for (int var21 = 0; var21 < var10; var21++) {
               BuilderFactory var15 = (BuilderFactory)var9.get(var21);
               float var22 = this.ed.getFloat(var15);
               float var23 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
               float var24 = var23 * var23 * (3.0F - 2.0F * var23);
               int var25 = (int)((var12 >>> 24 & (-1353982090 ^ -1353982071)) * var23 * var6);
               if (var25 >= 4) {
                  float var26 = var2 + 5.0F + (1.0F - var24) * 6.0F;
                  int var27 = Math.round(var26 * var11);
                  int var28 = Math.round((var20 - 6.5F) * var11);
                  int var29 = Math.max(var27 + 1, Math.round((var26 + 1.5F) * var11));
                  int var30 = Math.max(var28 + 1, Math.round((var20 + 0.5F) * var11));
                  var1.fill(var27, var28, var29, var30, var25 << 24 | var12 & (-1531300814 ^ -1538929715));
               }

               var20 += 11.5F * var24;
            }
         } finally {
            var13.popMatrix();
         }

         float var49 = var3 + 29.5F;
         float var50 = Math.max(1.0F, var5 - 37.0F);
         float var51 = var4 - 17.0F;
         boolean var52 = this.ep;
         float var53 = iu;
         int var54 = StyleKeyCache.SHADOW & (-1798210271 ^ -1808891170);

         for (int var55 = 0; var55 < var10; var55++) {
            BuilderFactory var48 = (BuilderFactory)var9.get(var55);
            float var56 = this.ed.getFloat(var48);
            float var57 = var56 < 0.0F ? 0.0F : (var56 > 1.0F ? 1.0F : var56);
            float var58 = var57 * var57 * (3.0F - 2.0F * var57);
            float var59 = var2 + 10.0F + (1.0F - var58) * 6.0F;
            OrderedText var16;
            int var31;
            if (var8) {
               float[] var18 = this.el.get(var48);
               var16 = this.ek.get(var48);
               if (var18 == null || var16 == null) {
                  var18 = new float[3];
                  var16 = this.u(var48, var18);
                  this.el.put(var48, var18);
                  this.ek.put(var48, var16);
               }

               float var32 = (var49 - (var3 + 29.5F)) / var50;
               var18[0] = var32 < 0.0F ? 0.0F : (var32 > 1.0F ? 1.0F : var32);
               var18[1] = 0.0F;
               var18[2] = var51 > 0.0F ? this.ej.getFloat(var48) / var51 : 1.0F;
               var31 = (int)(var57 * var6 * 255.0F) << 24 | 802230216 ^ 791605303;
            } else {
               int var60 = -455316663 ^ 453754005;
               if (var7) {
                  float var33 = (float)((System.currentTimeMillis() + var55 * 20 * 12L) % 4000L) / 4000.0F;
                  var60 = -1159582297 ^ 1172450727 | Color.HSBtoRGB(var33, 0.55F, 0.95F) & (-1215044259 ^ -1217652062);
               }

               var16 = this.ei.get(var48);
               if (var16 == null) {
                  var16 = this.ap(var48);
               }

               var31 = (int)((var60 >>> 24 & (-1826776846 ^ -1826777075)) * var57 * var6) << 24 | var60 & (1198207312 ^ 1200934575);
            }

            int var61 = var31 >>> 24 & (-1453753877 ^ -1453754092);
            if (var61 >= 5) {
               OrderedText var17 = var52 ? this.ei.get(var48) : null;
               var13.pushMatrix();

               try {
                  var13.translate((float)Math.round(var59 * var11) / var11, (float)Math.round((var49 - 7.0F) * var11) / var11);
                  int var62 = (int)(var61 * 0.78F);
                  if (var17 != null && var62 >= 5) {
                     var13.translate(var53, var53);
                     var1.drawText(var14, var17, 0, 0, var62 << 24 | var54, false);
                     var13.translate(-var53, -var53);
                  }

                  var1.drawText(var14, var16, 0, 0, var31, false);
               } finally {
                  var13.popMatrix();
               }
            }

            var49 += 11.5F * var58;
         }
      } finally {
         if (var19) {
            var1.disableScissor();
         }
      }
   }

   private void at() {
      if (ja != 0) {
         System.nanoTime();
      }

      this.hh = StyleKeyCache.f(5, bk[5]);
      this.hi = StyleKeyCache.f(5, L[2]);
      this.hj = StyleKeyCache.f(4, L[3]);
      this.hg = StyleKeyCache.ba;
   }

   private void au(DrawContext var1, int var2, int var3) {
      if (ja != 0) {
         new Object().hashCode();
      }

      int var4 = StyleKeyCache.ba;
      float var5 = 0.0F;
      float var6 = 0.0F;
      ArrayList var7 = this.ho;
      int var8 = var7.size();

      for (int var10 = 0; var10 < var8; var10++) {
         CoreZoneProcessor.Spec var9 = (CoreZoneProcessor.Spec)var7.get(var10);
         if (var9.gen != var4) {
            String var11 = var9.a == null ? YieldKeeper.v(new byte[]{-15}, 1282725277 ^ 1282725203) : var9.a;
            var9.e = StyleKeyCache.txt(2, var11);
            var9.g = StyleKeyCache.f(2, var11);
            var9.f = StyleKeyCache.txt(1, var9.d);
            var9.h = StyleKeyCache.f(1, var9.d);
            var9.gen = var4;
         }

         var5 = Math.max(var5, var9.g);
         var6 = Math.max(var6, var9.h + 7.0F);
      }

      if (this.hg != var4) {
         this.at();
      }

      boolean var50 = var8 == 0;
      float var51 = Math.max(9.0F + this.hi + 12.0F + 9.0F + 9.0F, var50 ? 7.5F + this.hj + 7.5F : 7.5F + var5 + 12.0F + var6 + 6.0F);
      float var12 = 30.5F + 12.0F * (Math.max(1, var8) - 1) + 7.5F;
      long var13 = System.nanoTime();
      if (!(this.hk <= 0.0F) && var13 - this.hm <= 250000000L) {
         float var15 = 1.0F - (float)Math.exp(-this.dn * 13.0F);
         this.hk = this.hk + (var51 - this.hk) * var15;
         if (Math.abs(var51 - this.hk) < 0.02F) {
            this.hk = var51;
         }

         this.hl = this.hl + (var12 - this.hl) * var15;
         if (Math.abs(var12 - this.hl) < 0.02F) {
            this.hl = var12;
         }
      } else {
         this.hk = var51;
         this.hl = var12;
      }

      this.hm = var13;
      float var52 = this.fc[3];
      if (var52 < 0.02F) {
         this.ew[3][2] = 0;
      } else {
         int var16 = this.fd;
         float var17 = this.hk;
         float var18 = this.hl;
         float var19 = ag(this.spX.p(), var17, var2, var16);
         float var20 = ag(this.spY.p(), var18, var3, var16);
         int var21 = (int)Math.floor(var19);
         int var22 = (int)Math.floor(var20);
         this.ab(3, var21, var22, (int)Math.ceil(var19 + var17) - var21, (int)Math.ceil(var20 + var18) - var22);
         var20 = (float)Math.round((var20 + (1.0F - var52) * 4.0F) * var16) / var16;
         var1.createNewRootLayer();
         boolean var23 = this.eo;
         boolean var24 = this.ep;
         if (var23) {
            int var25 = StyleKeyCache.PANEL;
            StyleKeyCache.r(var1, var19, var20, var17, var18, 6.0F, (int)((var25 >>> 24) * var52 + 0.5F) << 24 | var25 & (-876529986 ^ -885077695));
         }

         int var54 = (int)(255.0F * var52 + 0.5F);
         StyleKeyCache.l(var1, 5, L[2], var19 + 9.0F, var20 + 13.0F, var54 << 24 | -782504687 ^ -777119514, var24);
         StyleKeyCache.ab(var1, 12, var19 + var17 - 18.0F, var20 + 5.0F, 9.0F, var54 << 24 | StyleKeyCache.A & (1786350927 ^ 1787196080));
         float var26 = var20 + 30.5F;
         if (var50) {
            StyleKeyCache.l(var1, 4, L[3], var19 + 7.5F, var26, var54 << 24 | 969121228 ^ 961352543, var24);
         } else {
            Matrix3x2fStack var27 = var1.getMatrices();
            TextRenderer var28 = a.textRenderer;
            float var31 = 1.0F / var16;
            int var32 = StyleKeyCache.SHADOW & (1215119202 ^ 1217577117);

            for (int var33 = 0; var33 < var8; var33++) {
               float var34 = (var18 - (32.0F + 12.0F * var33)) / 6.0F;
               if (var34 <= 0.0F) {
                  break;
               }

               var34 = var34 > 1.0F ? 1.0F : var34;
               CoreZoneProcessor.Spec var49 = (CoreZoneProcessor.Spec)var7.get(var33);
               Text var29 = var49.e;
               Text var30 = var49.f;
               float var35 = var49.h + 7.0F;
               float var36 = var19 + var17 - 6.0F - var35;
               if (var23) {
                  int var37 = (int)(20.0F * var34 * var52) << 24 | 848763674 ^ 845735141;
                  StyleKeyCache.r(var1, var36, var26 - 7.2F, var35, 9.0F, 3.0F, var37);
               }

               int var56 = (int)(255.0F * var34 * var52);
               if (var56 >= 5 && var29 != null && var30 != null) {
                  int var38 = (int)(var56 * 0.78F);
                  boolean var39 = var24 && var38 >= 5;
                  int var40 = var49.c ? StyleKeyCache.A : 970085274 ^ -972716986;
                  var27.pushMatrix();

                  try {
                     var27.translate((float)Math.round((var19 + 7.5F) * var16) / var16, (float)Math.round((var26 - 7.0F) * var16) / var16);
                     if (var39) {
                        var27.translate(var31, var31);
                        var1.drawText(var28, var29, 0, 0, var38 << 24 | var32, false);
                        var27.translate(-var31, -var31);
                     }

                     var1.drawText(var28, var29, 0, 0, var56 << 24 | var40 & (-1795830007 ^ -1811271434), false);
                  } finally {
                     var27.popMatrix();
                  }

                  var27.pushMatrix();

                  try {
                     var27.translate((float)Math.round((var36 + 3.5F) * var16) / var16, (float)Math.round((var26 - 7.5F) * var16) / var16);
                     if (var39) {
                        var27.translate(var31, var31);
                        var1.drawText(var28, var30, 0, 0, var38 << 24 | var32, false);
                        var27.translate(-var31, -var31);
                     }

                     var1.drawText(var28, var30, 0, 0, var56 << 24 | -1115901842 ^ -1108197635, false);
                  } finally {
                     var27.popMatrix();
                  }
               }

               var26 += 12.0F;
            }
         }
      }
   }

   private void av() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      long var1 = System.currentTimeMillis();
      if (var1 - this.hp >= 250L) {
         this.hp = var1;
         if (a.player != null && a.world != null) {
            long var3 = (long)(this.ca.p() * 1000.0);
            double var5 = this.cb.p();
            UUID var7 = a.player.getUuid();
            HashMap var8 = new HashMap();

            try {
               if (a.getNetworkHandler() != null) {
                  for (PlayerListEntry var10 : a.getNetworkHandler().getPlayerList()) {
                     if (var10 != null && var10.getProfile() != null) {
                        UUID var11 = var10.getProfile().id();
                        if (var11 != null && !var11.equals(var7) && var10.getGameMode() == GameMode.SPECTATOR) {
                           CoreZoneProcessor.Spec var12 = new CoreZoneProcessor.Spec();
                           var12.a = var10.getProfile().name();
                           var12.b = -1.0;
                           var8.put(var11, var12);
                        }
                     }
                  }
               }
            } catch (Throwable var16) {
            }

            try {
               for (PlayerEntity var20 : a.world.getPlayers()) {
                  if (var20 != null && var20 != a.player) {
                     UUID var23 = var20.getUuid();
                     if (!var23.equals(var7)) {
                        boolean var25 = var20.getY() - a.player.getY() >= var5;
                        CoreZoneProcessor.Spec var13 = (CoreZoneProcessor.Spec)var8.get(var23);
                        if (var13 != null) {
                           var13.b = a.player.distanceTo(var20);
                           var13.c = var25;
                        } else if (var25) {
                           CoreZoneProcessor.Spec var14 = new CoreZoneProcessor.Spec();
                           var14.a = var20.getGameProfile().name();
                           var14.b = a.player.distanceTo(var20);
                           var14.c = true;
                           var8.put(var23, var14);
                        }
                     }
                  }
               }
            } catch (Throwable var15) {
            }

            this.hn.keySet().retainAll(var8.keySet());
            this.ho.clear();

            for (Entry var21 : (java.util.Set<Entry>)var8.entrySet()) {
               Long var24 = this.hn.get(var21.getKey());
               if (var24 == null) {
                  this.hn.put((UUID)var21.getKey(), var1);
               } else if (var1 - var24 >= var3) {
                  this.ho.add((CoreZoneProcessor.Spec)var21.getValue());
               }
            }

            for (CoreZoneProcessor.Spec var22 : this.ho) {
               var22.d = aw(var22.b);
            }

            if (this.cc.b(QueryZone.r(new byte[]{116, 46, 39, 111, 58, 63, 90, 17, 46, 53, 108, 77}, -1438946612 ^ -1438946732))) {
               this.ho.sort((var0, var1x) -> {
                  if (ja != 0) {
                     new Object().hashCode();
                  }

                  return String.CASE_INSENSITIVE_ORDER.compare(var0.a == null ? "" : var0.a, var1x.a == null ? "" : var1x.a);
               });
            } else {
               this.ho.sort((var0, var1x) -> {
                  if (ja != 0) {
                     System.nanoTime();
                  }

                  return Double.compare(var0.b < 0.0 ? Double.MAX_VALUE : var0.b, var1x.b < 0.0 ? Double.MAX_VALUE : var1x.b);
               });
            }
         }
      }
   }

   private static String aw(double var0) {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var0 < 0.0) {
         return L[15];
      }

      long var2 = Math.round(var0 * 10.0);
      return var2 / 10L + L[14] + var2 % 10L + L[16];
   }

   static String ax(int var0) {
      if (ja != 0) {
         System.nanoTime();
      }

      try {
         return SlotInspector.c(var0);
      } catch (Throwable var2) {
         return YieldKeeper.v(new byte[]{95}, 96);
      }
   }

   private static char ay(char var0) {
      if (ja != 0) {
         new Object().hashCode();
      }

      return var0 >= (-1373559458 ^ -1373513121) && var0 <= (818669900 ^ 818615826) ? (char)(var0 - (536317409 ^ 536310529)) : var0;
   }

   private static int az(int var0, float var1) {
      if (ja != 0) {
         new Object().hashCode();
      }

      var1 = var1 < 0.0F ? 0.0F : (var1 > 1.0F ? 1.0F : var1);
      int var2 = (int)((var0 >>> 24 & (51644546 ^ 51644541)) * var1);
      return var2 << 24 | var0 & (218216675 ^ 234768156);
   }

   private void ba(int var1) {
      if (ja != 0) {
         System.nanoTime();
      }

      String var2 = this.ie;
      if (var2 != this.dz) {
         this.dz = var2;
         int var3 = 0;

         for (int var4 = 0; var4 < dw.length; var4++) {
            if (dw[var4].equals(var2)) {
               var3 = var4;
               break;
            }
         }

         this.ea = var3;
      }

      int var5 = this.ea * 3 + (var1 - 1);
      if (var5 != this.eb) {
         this.eb = var5;
         iw = dx[this.ea][var1 - 1];
         ix = dy[this.ea][var1 - 1];
         iy.clear();
         this.ei.clear();
         this.ej.clear();
         this.eq = null;
         this.es = -1.0F;
         this.is = -1767588536 ^ -379895113;
         this.en++;
      }
   }

   private static String bb(String var0) {
      if (ja != 0) {
         System.nanoTime();
      }

      if (var0 == null) {
         return "";
      }

      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         var1.append(ay(var0.charAt(var2)));
      }

      String var3 = var1.toString();
      if (var3.length() > 1 && var3.charAt(1) == '.') {
         var3 = var3.charAt(0) + var3.substring(2);
      }

      return var3;
   }

   int bc() {
      if (ja != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         if (a.getNetworkHandler() != null && a.player != null) {
            PlayerListEntry var1 = a.getNetworkHandler().getPlayerListEntry(a.player.getUuid());
            if (var1 != null) {
               return var1.getLatency();
            }
         }
      } catch (Throwable var2) {
      }

      return 0;
   }

   String bd() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         if (a.getCurrentServerEntry() != null) {
            String var3 = a.getCurrentServerEntry().address;
            if (var3 != this.ge) {
               this.ge = var3;
               this.gf = var3 != null && var3.endsWith(JoinerWriter.p(new byte[]{-29, -38, -36, -37, -37, -39}, 87))
                  ? var3.substring(0, var3.length() - 6)
                  : var3;
            }

            return this.gf;
         }
      } catch (Throwable var2) {
      }

      String var1 = gg;
      if (var1 == null) {
         var1 = bb(L[13]);
         gg = var1;
      }

      return var1;
   }

   public int p() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return this.bs.g();
   }

   public void d(int var1) {
      if (ja != 0) {
         new Object().hashCode();
      }

      this.bs.a(var1);
   }

   public ItemDescriptor q() {
      if (ja != 0) {
         Thread.currentThread().getName().length();
      }

      return this.bs;
   }

   static {
      String[] var0 = new String[]{
         NotifyResolver.q(new byte[]{65, 69, 78, 76, 73}, 45),
         TokenExtractor.w(new byte[]{98, 118, 117, 96, 120, 118, 100}, 17),
         StringDecoder.d(new byte[]{16, 25, 27, 23, 12, 21}, 125),
         JoinerWriter.p(new byte[]{-73, -61, -65, -74}, 171),
         YieldKeeper.v(new byte[]{6, -92, 77, -13, -97}, 100)
      };

      for (int var1 = 0; var1 < 5; var1++) {
         for (int var2 = 0; var2 < 3; var2++) {
            dx[var1][var2] = Style.EMPTY
               .withFont(
                  new Font(
                     Identifier.of(
                        QueryZone.r(new byte[]{-50, -62, -60, -47, -41, -14, -31}, 161),
                        NotifyResolver.q(new byte[]{57, 37, 49, 106, 30, 42, 6, 63}, 81) + var0[var1] + TokenExtractor.w(new byte[]{14}, 84) + (var2 + 1)
                     )
                  )
               );
            dy[var1][var2] = Style.EMPTY
               .withFont(
                  new Font(
                     Identifier.of(
                        TokenExtractor.w(new byte[]{83, 81, 77, 82, 82, 65, 88}, 60),
                        JoinerWriter.p(new byte[]{42, 54, 36, 30}, 62) + var0[var1] + QueryZone.r(new byte[]{-111, -76}, 205) + (var2 + 1)
                     )
                  )
               );
         }
      }

      fg = 0L;
      fh = 0L;
      fi = 20.0F;
      fj = -1.0F;
      fk = -1.0F;
      hq = new String[]{
         JoinerWriter.p(new byte[]{-23}, 106),
         JoinerWriter.p(new byte[]{-50, -47}, 133),
         YieldKeeper.v(new byte[]{91}, 12),
         NotifyResolver.q(new byte[]{94, 70}, 16),
         YieldKeeper.v(new byte[]{120}, 54),
         StringDecoder.d(new byte[]{26, 16}, 84),
         QueryZone.r(new byte[]{-118}, 204),
         NotifyResolver.q(new byte[]{-13, -28}, 160)
      };
      hr = new String[24];

      for (int var3 = 0; var3 < 24; var3++) {
         hr[var3] = Integer.toString(var3 * 15);
      }

      hs = new String[]{
         QueryZone.r(new byte[]{50, 25, 9, 11, 27, 49, 55}, 118),
         YieldKeeper.v(new byte[]{120, 55, -12, -112, -98, 105, 70}, 44),
         StringDecoder.d(new byte[]{97, 86}, 54) + NotifyResolver.q(new byte[]{40, 56, 42, 56}, 92) + QueryZone.r(new byte[]{-21, -15, -13}, 137),
         QueryZone.r(new byte[]{53, 16, 11, 31, 14, 58}, 117)
            + YieldKeeper.v(new byte[]{-87}, 199)
            + TokenExtractor.w(new byte[]{-83}, 192)
            + NotifyResolver.q(new byte[]{53, 37, 54}, 65),
         TokenExtractor.w(new byte[]{-10, -45, -39, -53, -45, -59, -46}, 176),
         StringDecoder.d(new byte[]{60, 19, 12, 22, 26, 28, 21, 3}, 119),
         TokenExtractor.w(new byte[]{70, 102, 114, 115, 101, 115, 103, 115, 111, 109}, 20),
         QueryZone.r(new byte[]{-110, -92, -92, -80, -79, -119, -97}, 193),
         JoinerWriter.p(new byte[]{-101, -73, -85, -86, -88}, 184),
         YieldKeeper.v(new byte[]{24, -49, -124, 34, -15, -110}, 80),
         QueryZone.r(new byte[]{11, 47, 61, 35, 34, 28}, 73)
      };
      ij = 0L;
      iu = 0.5F;
      iv = 657937;
      iw = dx[0][1];
      ix = dy[0][1];
      iy = new HashMap<>();
   }

   private static final class Spec {
      String a;
      double b;
      boolean c;
      String d;
      Text e;
      Text f;
      float g;
      float h;
      int gen = -1;
      private static int i = 0;
   }
}
