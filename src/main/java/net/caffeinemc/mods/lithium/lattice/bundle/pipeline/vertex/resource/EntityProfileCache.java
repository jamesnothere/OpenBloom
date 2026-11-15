package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.ProfileResult;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TextEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.SkinTextures;

public final class EntityProfileCache extends BuilderFactory implements InitNotifier {
   public static volatile boolean ON = false;
   public static volatile String FAKE = "";
   public static volatile String REAL = "";
   public static volatile boolean SKIN_ON = true;
   public static volatile SkinTextures SKIN = null;
   private final TextEntry h;
   private final PlacementEntry i99;
   private final PlacementEntry j;
   private final PlacementEntry k99;
   private final PlacementEntry l99;
   private final CheckerBridge m99;
   private String n99;
   private int o;
   private final String[] p;
   private static int q = 0;

   public EntityProfileCache() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'ⵈ', 'ⴋ', 'ⴥ', 'ⴎ', 'ⷧ', 'ⶁ', 'ⶐ', 'ⶭ', 'ⶑ', '\u2e69', '⹙', '⸸', '⸎'},
         452996358,
         new char[]{
            '\ud9cb',
            '\ud9df',
            '\ud9b9',
            '\ud982',
            '\uda34',
            '\uda52',
            '\uda3c',
            '\uda1e',
            '\udae4',
            '\udac7',
            '\udaab',
            '\uda9f',
            '\udb2c',
            '\udb45',
            '\udb2b',
            '\udb04',
            '\udbed',
            '\udb87',
            '\udbaf',
            '\udb8b',
            '\udc77',
            '\udc57',
            '\udc27',
            '\udc00',
            '\udce4',
            '\udcbf',
            '\udcd1',
            '\udcbb',
            '\udcdc',
            '\udd62',
            '\udd55',
            '\udd2c',
            '\udd0a',
            '\udde4',
            '\udd9a',
            '\uddf5',
            '\udd9b',
            '\ude7d',
            '\ude5e',
            '\ude28',
            '\ude50',
            '\udee0',
            '\udec0',
            '\udeed',
            '\ude95',
            '\udf64',
            '\udf5f',
            '\udf3b',
            '\udf48',
            '\udff4',
            '\udfc5',
            '\udfb7',
            '\udf81',
            '\ue066',
            '\ue04c'
         },
         -1624516200
      );
      TextEntry var10001 = new TextEntry("", QueryZone.r(new byte[]{-62, -9, -31, -16, -21, -59}, 145), 16);
      var10001.n(new char[]{'\uf551', '\uf55f', '\uf530', '\uf519'}, 1539175711);
      this.h = var10001;
      PlacementEntry var1 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var1.n(new char[]{'\uf635', '\uf6e1', '\uf6fd', '\uf69e', '\uf691', '\uf695', '\uf768', '\uf74e'}, 147912289);
      this.i99 = var1;
      PlacementEntry var2 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var2.n(new char[]{'忼', '徰', '徝', '恪', '恚', '怬', '怋', '惸'}, 1666015154);
      this.j = var2;
      PlacementEntry var3 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var3.n(new char[]{'\udc7f', '\udc33', '\udc1b', '\udced'}, 993254460);
      this.k99 = var3;
      PlacementEntry var4 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var4.n(new char[]{'ꇘ', 'ꇂ', 'ꆾ', 'ꆅ', 'ꉭ', 'ꉔ'}, -1897029236);
      this.l99 = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'朱', '柾', '柀', '架', '柎', '桞', '桇', '栢', '栄'}, -1541118094);
      this.m99 = var5;
      this.n99 = "";
      this.o = 0;
      this.p = new String[2];
      this.a(this.h, this.i99, this.j, this.k99, this.l99, this.m99);
   }

   @Override
   public void c() {
      if (q != 0) {
         System.nanoTime();
      }

      this.b.a(InitNotifier.class, this);
      super.c();
      this.a(true);
   }

   @Override
   public void d() {
      if (q != 0) {
         Thread.currentThread().getName().length();
      }

      this.b.b(InitNotifier.class, this);
      ON = false;
      SKIN = null;
      this.n99 = "";
      ProfileTextCache.set(false, this.p, "");
      ProfileTextCache.EDIT = false;
      this.b();
      super.d();
   }

   @Override
   public void a() {
      if (q != 0) {
         new Object().hashCode();
      }

      try {
         this.a(super.f);
      } catch (Throwable var2) {
      }
   }

   public void a(boolean var1) {
      if (q != 0) {
         new Object().hashCode();
      }

      ProfileTextCache.EDIT = false;
      String var2 = a.getSession() != null ? a.getSession().getUsername() : "";
      REAL = var2 == null ? "" : var2;
      String var3 = this.h.f();
      String var4 = var3 == null ? "" : var3.trim();
      FAKE = var4;
      SKIN_ON = this.m99.f();
      ON = var1 && !var4.isEmpty();
      String[] var5 = this.p;
      var5[0] = REAL;
      var5[1] = a.player != null && a.player.getGameProfile() != null ? a.player.getGameProfile().name() : null;
      ProfileTextCache.set(ON, var5, var4);
      if (ProfileTextCache.GEN != this.o) {
         this.b();
      }

      if (ON && SKIN_ON && a.player != null) {
         if (!var4.equalsIgnoreCase(this.n99)) {
            this.n99 = var4;
            SKIN = null;
            PlayerListEntry var6 = a.getNetworkHandler() != null ? a.getNetworkHandler().getCaseInsensitivePlayerInfo(var4) : null;
            if (var6 != null) {
               SKIN = var6.getSkinTextures();
            } else {
               c(var4);
            }
         }
      } else if (!ON || !SKIN_ON) {
         SKIN = null;
         this.n99 = "";
      }
   }

   private void b() {
      if (q != 0) {
         new Object().hashCode();
      }

      this.o = ProfileTextCache.GEN;

      try {
         if (a.inGameHud != null) {
            ChatHud var1 = a.inGameHud.getChatHud();
            if (var1 != null) {
               var1.reset();
            }
         }
      } catch (Throwable var2) {
      }
   }

   private static void c(String var0) {
      if (q != 0) {
         System.nanoTime();
      }

      CompletableFuture.runAsync(() -> {
         if (q != 0) {
            Math.abs(Integer.MIN_VALUE);
         }

         try {
            String var1 = d(var0);
            if (var1 == null) {
               return;
            }

            UUID var2 = e(var1);
            GameProfile var3 = new GameProfile(var2, var0);
            ProfileResult var4 = a.getApiServices().sessionService().fetchProfile(var2, false);
            GameProfile var5 = var4 != null ? var4.profile() : var3;
            a.getSkinProvider().fetchSkinTextures(var5).thenAccept(var1x -> {
               if (q != 0) {
                  System.nanoTime();
               }

               if (var1x != null && var1x.isPresent() && var0.equalsIgnoreCase(FAKE)) {
                  SKIN = (SkinTextures)var1x.get();
               }
            });
         } catch (Throwable var6) {
         }
      });
   }

   private static String d(String var0) {
      if (q != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         HttpURLConnection var1 = (HttpURLConnection)URI.create(
               JoinerWriter.p(
                     new byte[]{
                        3,
                        14,
                        13,
                        8,
                        10,
                        -48,
                        -60,
                        -61,
                        -12,
                        2,
                        -6,
                        -66,
                        -4,
                        -3,
                        -9,
                        -19,
                        -7,
                        -15,
                        -73,
                        -21,
                        -10,
                        -13,
                        -76,
                        -7,
                        -10,
                        -25,
                        -13,
                        -13,
                        -82,
                        -18,
                        -17,
                        -21,
                        -31,
                        -29,
                        -27
                     },
                     101
                  )
                  + QueryZone.r(new byte[]{-55, -42, -111, -38, -39, -25, -25, -8, -26, -116, -128, -117, -41}, 354607210 ^ 354607301)
                  + var0
            )
            .toURL()
            .openConnection();
         var1.setConnectTimeout(-2031839493 ^ -2031843981);
         var1.setReadTimeout(612091005 ^ 612095989);
         if (var1.getResponseCode() != (898007379 ^ 898007451)) {
            return null;
         }

         String var2 = new String(var1.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
         JsonObject var3 = JsonParser.parseString(var2).getAsJsonObject();
         return var3.has(StringDecoder.d(new byte[]{-60, -56}, 1996426047 ^ 1996426130))
            ? var3.get(JoinerWriter.p(new byte[]{-43, -49}, -1081931217 ^ -1081931077)).getAsString()
            : null;
      } catch (Throwable var4) {
         return null;
      }
   }

   private static UUID e(String var0) {
      if (q != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return UUID.fromString(
         var0.replaceFirst(
            TokenExtractor.w(new byte[]{10, 13, 95, 29, 91, 14, 0, 7, 81, 31, 81, 4, 6, 1, 75, 5, 79, 26, 28, 27}, 32)
               + YieldKeeper.v(new byte[]{56, -78, -76, 37, 103, -68, -82, 41, 105, -29, -56}, 67),
            StringDecoder.d(new byte[]{-18, -6, -27, -19, -4, -30, -24, -2, -17, -25, -12, -20, -30, -14}, -1644096923 ^ -1644096849)
         )
      );
   }
}
