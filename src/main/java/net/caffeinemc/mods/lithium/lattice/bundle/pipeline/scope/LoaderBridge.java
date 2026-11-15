package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TextEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SyncController;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public final class LoaderBridge {
   private final Gson al = new GsonBuilder().setPrettyPrinting().create();
   private Path am;
   private Path an;
   private static final String ao = QueryZone.r(new byte[]{76, 80, 89, 34, 46}, 11);
   private static final String ap = TokenExtractor.w(new byte[]{-28, -27, -7, -9, -7, -1, -9, -2}, 157)
      + StringDecoder.d(new byte[]{-79, -13, -8, -24, -6}, 159);
   private static final String aq = YieldKeeper.v(new byte[]{-83, 114, -5, 109, -4, 122}, 131);
   private static final String ar = QueryZone.r(new byte[]{123, 111, 124, 106, 112, 79, 67}, 29);
   private static final int as = 20;
   private static final long at = 4194304L;
   private static final byte[] au = new byte[]{55, -101, 17, -60, 94, 42, -48, 99};
   private static int av = 0;

   public LoaderBridge() {
      String var1 = System.getProperty(
         StringDecoder.d(new byte[]{-12}, 129)
            + StringDecoder.d(new byte[]{-67, -86, -66, -29, -94}, 206)
            + TokenExtractor.w(new byte[]{37}, 78)
            + NotifyResolver.q(new byte[]{27, 18}, 118)
      );
      String var2;
      if (System.getProperty(JoinerWriter.p(new byte[]{-92, -89, 97, -96, -110, -99, -108}, 203))
         .toLowerCase()
         .contains(TokenExtractor.w(new byte[]{56, 39, 35}, 75))) {
         var2 = TokenExtractor.w(
            new byte[]{
               124,
               74,
               75,
               124,
               88,
               66,
               86,
               27,
               103,
               93,
               82,
               93,
               88,
               64,
               72,
               3,
               3,
               71,
               66,
               70,
               76,
               69,
               85,
               69,
               67,
               86,
               12,
               14,
               76,
               125,
               92,
               112,
               116,
               127,
               117,
               108,
               52,
               100,
               114,
               122,
               113,
               119,
               97,
               117,
               99,
               35,
               108,
               109,
               110,
               98,
               110
            },
            62
         );
      } else {
         var2 = YieldKeeper.v(new byte[]{-101, 7, 118, -70, -20, 93, -127}, 181)
            + JoinerWriter.p(new byte[]{45, 49, 62, -8, -10, 52, 41, 8, 48, 44, 39, 47, 52, -20, 48, 34, 42, 31, 31, 43, 29, 41, -29, 24, 21, 22, 26, 22}, 52);
      }

      this.am = Paths.get(var1, var2);
      this.an = this.am
         .resolve(
            YieldKeeper.v(new byte[]{-36, 21, 78, -127, -19, 60}, 184)
               + YieldKeeper.v(new byte[]{-3, 60}, 137)
               + YieldKeeper.v(new byte[]{-49, 57, -128, -6}, 165)
         );
   }

   public void a() {
      if (av != 0) {
         System.nanoTime();
      }

      try {
         if (!Files.isRegularFile(this.an)) {
            return;
         }

         byte[] var1 = Files.readAllBytes(this.an);
         if (var1.length == 0) {
            return;
         }

         String var2;
         boolean var3;
         if (var1[0] != 123 && var1[0] != 32 && var1[0] != 10 && var1[0] != 13 && var1[0] != 9) {
            var2 = ak(var1);
            var3 = false;
         } else {
            var2 = new String(var1, StandardCharsets.UTF_8);
            var3 = true;
         }

         JsonObject var4 = (JsonObject)this.al.fromJson(var2, JsonObject.class);
         if (var4 == null) {
            return;
         }

         if (var3) {
            try {
               Files.write(this.an, aj(var2));
            } catch (Exception var6) {
            }
         }

         this.a(var4);
      } catch (Exception var7) {
      }
   }

   public void a(JsonObject var1) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         if (var1 == null) {
            return;
         }

         JsonElement var2 = var1.get(
            JoinerWriter.p(new byte[]{-49, -36, -49, -72}, -494409584 ^ -494409720)
               + YieldKeeper.v(new byte[]{-8}, -999640787 ^ -999640656)
               + StringDecoder.d(new byte[]{-18, -17, -15}, 586746901 ^ 586747023)
               + StringDecoder.d(new byte[]{-23, -31, -10}, 595662809 ^ 595662686)
         );
         if (var2 != null && var2.isJsonObject()) {
            JsonObject var3 = var2.getAsJsonObject();

            try {
               if (var3.has(TokenExtractor.w(new byte[]{87, 95, 91, 82, 91, 120, 75, 84, 111, 88, 91, 85, 93}, 55))) {
                  SyncController.n = var3.get(
                        StringDecoder.d(new byte[]{-42, -40, -34, -43, -38, -9, -58, -37}, -533511913 ^ -533511774)
                           + TokenExtractor.w(new byte[]{-24, -33}, -792891911 ^ -792892087)
                           + TokenExtractor.w(new byte[]{-11}, 17356155 ^ 17356262)
                           + NotifyResolver.q(new byte[]{-33, -41}, -2053998526 ^ -2053998351)
                     )
                     .getAsFloat();
               }
            } catch (Exception var33) {
            }

            try {
               if (var3.has(
                  JoinerWriter.p(new byte[]{65, 67, 64, 63}, 49)
                     + JoinerWriter.p(new byte[]{-52, -61, -49, -76, -57}, 1496755076 ^ 1496754969)
                     + StringDecoder.d(new byte[]{-28}, 88517118 ^ 88516991)
                     + NotifyResolver.q(new byte[]{10, 3}, 103)
               )) {
                  SyncController.m = var3.get(
                        TokenExtractor.w(new byte[]{-76, -78, -73, -74, -77, -70}, -828212921 ^ -828212851)
                           + StringDecoder.d(new byte[]{-26, -35}, -964745837 ^ -964745957)
                           + StringDecoder.d(new byte[]{-85, -89, -84, -91}, -2039269161 ^ -2039269356)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var32) {
            }

            try {
               if (var3.has(NotifyResolver.q(new byte[]{-64, -42, -46, -8, -51, -57, -7, -15}, 55147189 ^ 55147015))) {
                  SyncController.b = var3.get(YieldKeeper.v(new byte[]{-23, 83, -75, 47, 104, -50, 82, -86}, -1074853513 ^ -1074853396)).getAsInt();
               }
            } catch (Exception var31) {
            }

            try {
               if (var3.has(
                  NotifyResolver.q(new byte[]{70, 82}, 33)
                     + YieldKeeper.v(new byte[]{13, -75, 86, -29}, 104)
                     + QueryZone.r(new byte[]{-58}, 668772898 ^ 668773000)
                     + StringDecoder.d(new byte[]{41, 43, 53}, 69)
               )) {
                  SyncController.c = var3.get(YieldKeeper.v(new byte[]{94, 0, -50, -127, 115, 21, -32, -92, 110, 72}, 57)).getAsInt();
               }
            } catch (Exception var30) {
            }

            try {
               if (var3.has(
                  YieldKeeper.v(new byte[]{-33, 22, 66}, -814152755 ^ -814152848)
                     + YieldKeeper.v(new byte[]{104, 89}, 13)
                     + QueryZone.r(new byte[]{75, 65}, 39)
                     + QueryZone.r(new byte[]{50, 38}, 94)
               )) {
                  SyncController.d = var3.get(TokenExtractor.w(new byte[]{55, 58}, 80) + StringDecoder.d(new byte[]{13, 28, 57, 20, 16, 18, 12}, 120))
                     .getAsInt();
               }
            } catch (Exception var29) {
            }

            try {
               if (var3.has(QueryZone.r(new byte[]{91, 87, 121, 71, 65}, 58))) {
                  SyncController.e = var3.get(TokenExtractor.w(new byte[]{4, 0, 58, 12, 14}, 96)).getAsInt();
               }
            } catch (Exception var28) {
            }

            try {
               if (var3.has(NotifyResolver.q(new byte[]{63, 59, 30, 38, 40, 33, 23}, 93))) {
                  SyncController.f = var3.get(YieldKeeper.v(new byte[]{108, 123, 109, 74, 35, 49, 12}, 14)).getAsInt();
               }
            } catch (Exception var27) {
            }

            try {
               if (var3.has(StringDecoder.d(new byte[]{53, 49, 23, 56, 38, 55}, 87))) {
                  SyncController.g = var3.get(TokenExtractor.w(new byte[]{-48, -46, -10, -37, -61, -52}, 1568253987 ^ 1568254106)).getAsInt();
               }
            } catch (Exception var26) {
            }

            try {
               if (var3.has(
                  NotifyResolver.q(new byte[]{-79, -84, -92, -95, -80, -107, -113}, -1830701231 ^ -1830701164)
                     + YieldKeeper.v(new byte[]{46}, 74)
                     + QueryZone.r(new byte[]{-1, -21}, 15695457 ^ 15695608)
               )) {
                  int var4 = var3.get(
                        YieldKeeper.v(new byte[]{-72, -16, 1, 93}, 1432626107 ^ 1432626039)
                           + QueryZone.r(new byte[]{-51, -24, -44, -41, -47, -11}, 1936091058 ^ 1936090905)
                     )
                     .getAsInt();
                  ThemeCache.o = var4 >= 0 && var4 < ThemeCache.ALL.length ? var4 : 0;
               }
            } catch (Exception var34) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{-54, -41}, 1222771245 ^ 1222771347) + YieldKeeper.v(new byte[]{39, -23, -93, 73, 41, -17, -85, 126, 38, -58}, 66)
               )) {
                  ThemeCache.p[0] = ThemeCache.n(
                     var3.get(
                           YieldKeeper.v(new byte[]{18, -92, 87, -11, -101, 37}, 102)
                              + QueryZone.r(new byte[]{117}, 21)
                              + TokenExtractor.w(new byte[]{4, 3, 7}, 97)
                              + NotifyResolver.q(new byte[]{97, 70}, 21)
                        )
                        .getAsInt()
                  );
               }

               if (var3.has(
                  StringDecoder.d(new byte[]{31, 2, 12, 5, 10, 47}, 107) + StringDecoder.d(new byte[]{-51, -52, -55, -61, -34, -20}, 98793301 ^ 98793467)
               )) {
                  ThemeCache.p[1] = ThemeCache.n(
                     var3.get(
                           TokenExtractor.w(new byte[]{-50, -43, -39, -46, -37, -32, -61}, 1326984672 ^ 1326984529)
                              + StringDecoder.d(new byte[]{-93}, -170164425 ^ -170164233)
                              + StringDecoder.d(new byte[]{110, 100}, 11)
                              + StringDecoder.d(new byte[]{77, 127}, 57)
                        )
                        .getAsInt()
                  );
               }

               if (var3.has(
                  YieldKeeper.v(new byte[]{4, -120, 53}, 112)
                     + StringDecoder.d(new byte[]{113, 120, 95, 124, 123, 124, 116}, 28)
                     + StringDecoder.d(new byte[]{62, 9}, 74)
               )) {
                  ThemeCache.p[2] = ThemeCache.n(
                     var3.get(NotifyResolver.q(new byte[]{14, 19, 27, 30, 15}, 122) + JoinerWriter.p(new byte[]{14, 47, 46, 47, 55, 60, 9}, 51)).getAsInt()
                  );
               }

               if (var3.has(StringDecoder.d(new byte[]{-36, -63, -49, -58, -55, -17, -55, -3}, 701967777 ^ 701967625))) {
                  ThemeCache.q[0] = ThemeCache.n(
                     var3.get(TokenExtractor.w(new byte[]{-18, -15, -3, -14, -5, -33, -5, -47}, -720598168 ^ -720598021)).getAsInt()
                  );
               }

               if (var3.has(JoinerWriter.p(new byte[]{-48, -61, -65, -58, -67, -103, -67, -100}, -1024722146 ^ -1024721990))) {
                  ThemeCache.q[1] = ThemeCache.n(var3.get(JoinerWriter.p(new byte[]{64, 51, 47, 54, 45, 9, 45, 12}, 52)).getAsInt());
               }

               if (var3.has(NotifyResolver.q(new byte[]{22, 11, 3, 6, 23, 57, 33, 17}, 98))) {
                  ThemeCache.q[2] = ThemeCache.n(var3.get(YieldKeeper.v(new byte[]{104, 80, 49, 29, -23, -22, -93, -94}, 28)).getAsInt());
               }
            } catch (Exception var25) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{-96, -94, -93, -86, -95, -75, -85, -80}, -1887786987 ^ -1887786793)
                     + TokenExtractor.w(new byte[]{-63, -54, -19, -63, -58}, -1260404130 ^ -1260403973)
               )) {
                  SyncController.q = var3.get(
                        NotifyResolver.q(new byte[]{-82, -84, -85, -82, -69, -89, -121}, 1753489331 ^ 1753489279)
                           + QueryZone.r(new byte[]{-28}, 1824435303 ^ 1824435445)
                           + TokenExtractor.w(new byte[]{68}, 40)
                           + QueryZone.r(new byte[]{-62, -21, -35, -48}, 1824840662 ^ 1824840563)
                     )
                     .getAsBoolean();
               }

               if (var3.has(NotifyResolver.q(new byte[]{83, 73, 76, 66, 67, 87, 115, 101}, 39))) {
                  SyncController.r = var3.get(JoinerWriter.p(new byte[]{15, 9, 8, 4, 11, -1, 5, 7}, 101)).getAsBoolean();
               }

               if (var3.has(StringDecoder.d(new byte[]{60, 60, 50, 46, 21, 41, 59, 18, 48, 41, 60, 39, 33}, 89))) {
                  SyncController.s = var3.get(
                        JoinerWriter.p(new byte[]{-41, -43, -39, -29, -74, -30, -48, -73, -53, -30, -41, -36, -38}, -1671869464 ^ -1671869594)
                     )
                     .getAsBoolean();
               }

               if (var3.has(
                  NotifyResolver.q(new byte[]{-6, -16, -8, -25, -2, -44, -40}, -453549520 ^ -453549395)
                     + QueryZone.r(new byte[]{24}, 117)
                     + QueryZone.r(new byte[]{-9}, -511046802 ^ -511046657)
                     + QueryZone.r(new byte[]{91, 77}, 52)
               )) {
                  SyncController.t = var3.get(
                        JoinerWriter.p(new byte[]{-76, -72, -84}, -1714061 ^ -1713984)
                           + NotifyResolver.q(new byte[]{125, 124, 90, 102}, 14)
                           + StringDecoder.d(new byte[]{72}, 38)
                           + NotifyResolver.q(new byte[]{65, 73, 83}, 36)
                     )
                     .getAsBoolean();
               }

               if (var3.has(StringDecoder.d(new byte[]{84, 71, 88, 3, 83}, 51))) {
                  SyncController.u = var3.get(QueryZone.r(new byte[]{-20, -9, -16, -93, -13}, 411661855 ^ 411661975)).getAsBoolean();
               }

               if (var3.has(StringDecoder.d(new byte[]{-81, -68, -93, -8, -88, -119, -95, -87}, 1488946137 ^ 1488945937))) {
                  SyncController.v = var3.get(QueryZone.r(new byte[]{-35, -58, -63, -110, -62, -37, -5, -21}, -2112497231 ^ -2112497400)).getAsBoolean();
               }

               if (var3.has(
                  JoinerWriter.p(new byte[]{-101, -88}, -854443389 ^ -854443441)
                     + QueryZone.r(new byte[]{-52, -97, -45, -1, -44, -30, -30, -9, -13, -121, -118}, 796613919 ^ 796614073)
               )) {
                  SyncController.w = var3.get(
                        QueryZone.r(new byte[]{72, 83, 84, 7, 87, 75, 108, 122, 126}, 44)
                           + TokenExtractor.w(new byte[]{105, 99}, 12)
                           + TokenExtractor.w(new byte[]{-53, -52}, 279229758 ^ 279229852)
                     )
                     .getAsBoolean();
               }

               if (var3.has(QueryZone.r(new byte[]{126, 101, 98, 49, 97, 110, 82, 74, 84, 59, 54, 7, 34, 48, 22, 25, 7}, 26))) {
                  SyncController.x = var3.get(
                        TokenExtractor.w(new byte[]{118, 103, 122, 39, 113, 68, 114, 124, 108, 121}, 16)
                           + QueryZone.r(new byte[]{21, 52, 13, 31}, 115)
                           + QueryZone.r(new byte[]{6, 9, 19}, 108)
                     )
                     .getAsBoolean();
               }

               if (var3.has(
                  NotifyResolver.q(new byte[]{-37, -56, -47, -122, -56, -26, -12, -30, -113, -120, -105, -85, 104}, -2135775838 ^ -2135775970)
                     + NotifyResolver.q(new byte[]{58, 55, 62, 53, 46}, 91)
               )) {
                  SyncController.y = var3.get(
                        YieldKeeper.v(new byte[]{-53, 45, 109, -125, 56, 75, -40, 15, 127, -35, 43, 126, -8, 9, 121, -95, 11, 125}, 1584051546 ^ 1584051702)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var24) {
            }

            try {
               if (var3.has(JoinerWriter.p(new byte[]{26, 39, 26, 3, 18, 15, 25, 17}, 77))) {
                  SyncController.a = Math.max(
                     1, Math.min(3, var3.get(StringDecoder.d(new byte[]{-20, -1, -32, -37, -20, -17, -31, -23}, 1320724260 ^ 1320724399)).getAsInt())
                  );
               }
            } catch (Exception var23) {
            }

            try {
               if (var3.has(
                  YieldKeeper.v(new byte[]{1, -79, 57, -43, 77, -29, 90}, 111)
                     + StringDecoder.d(new byte[]{5}, 106)
                     + JoinerWriter.p(new byte[]{10}, 107)
                     + QueryZone.r(new byte[]{95, 92}, 50)
               )) {
                  NoticeQueue.m = var3.get(StringDecoder.d(new byte[]{52, 52, 44, 48, 56, 38, 15, 50, 39, 61, 52}, 90)).getAsBoolean();
               }
            } catch (Exception var22) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{-23, -29, -19, -2}, 775511136 ^ 775511278)
                     + StringDecoder.d(new byte[]{-34, -22, -35, -63, -38, -36}, 152712582 ^ 152712491)
               )) {
                  SyncController.h = Math.max(0, Math.min(2, var3.get(QueryZone.r(new byte[]{47, 45, 59, 32, 39, 43, 20, 16, 3, 125}, 75)).getAsInt()));
               }
            } catch (Exception var21) {
            }

            try {
               if (var3.has(
                  TokenExtractor.w(new byte[]{87, 71, 79, 69, 79}, 37)
                     + NotifyResolver.q(new byte[]{-115}, -1470269587 ^ -1470269521)
                     + NotifyResolver.q(new byte[]{-3}, 363833257 ^ 363833124)
                     + TokenExtractor.w(new byte[]{-81, -84, -91, -71, -85}, -1496658155 ^ -1496657961)
               )) {
                  SyncController.i = Math.max(
                     25,
                     Math.min(
                        100,
                        var3.get(
                              TokenExtractor.w(new byte[]{50, 34, 46}, 70)
                                 + StringDecoder.d(new byte[]{-83, -91, -123, -69}, -1728143127 ^ -1728143327)
                                 + StringDecoder.d(new byte[]{-87, -86}, 1135129975 ^ 1135130047)
                                 + JoinerWriter.p(new byte[]{-54, -44, -40}, 588563776 ^ 588563935)
                           )
                           .getAsInt()
                     )
                  );
               }
            } catch (Exception var20) {
            }

            try {
               if (var3.has(
                  TokenExtractor.w(new byte[]{-85, -89, -96}, 96044248 ^ 96044059)
                     + YieldKeeper.v(new byte[]{-124, -25, 32}, 1521523894 ^ 1521523827)
                     + NotifyResolver.q(new byte[]{40}, 93)
                     + NotifyResolver.q(new byte[]{92, 71}, 50)
               )) {
                  SyncController.j = Math.max(
                     10, Math.min(100, var3.get(YieldKeeper.v(new byte[]{-94, -27, 63, 89, -77, -53, 31, 94, -126}, 1857020892 ^ 1857020698)).getAsInt())
                  );
               }
            } catch (Exception var19) {
            }

            try {
               if (var3.has(
                  YieldKeeper.v(new byte[]{-23, 119, -62, 71, -48, 48, -94, 45, -115, 10, -69, -24}, 1570689488 ^ 1570689371)
                     + QueryZone.r(new byte[]{102, 104}, 16)
               )) {
                  SyncController.k = var3.get(
                        QueryZone.r(new byte[]{-47, -37, -62, -61, -56, -28, -14, -15, -27, -106, -69, -116, -110, -100}, -2115853883 ^ -2115853963)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var18) {
            }

            try {
               if (var3.has(
                  TokenExtractor.w(new byte[]{-41, -41, -37, -40, -36, -60, -52, -8, -52, -38}, 483963004 ^ 483963078)
                     + TokenExtractor.w(new byte[]{48}, 84)
                     + QueryZone.r(new byte[]{72, 94}, 39)
               )) {
                  SyncController.l = Math.max(
                     0,
                     Math.min(
                        2,
                        var3.get(
                              JoinerWriter.p(new byte[]{-25, -31, -21, -22, -26, -22, -30, -54}, 127)
                                 + JoinerWriter.p(new byte[]{-14}, 115)
                                 + StringDecoder.d(new byte[]{-10, -30, -20, -14}, -418962297 ^ -418962427)
                           )
                           .getAsInt()
                     )
                  );
               }
            } catch (Exception var17) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{126, 100, 103, 101, 122, 102, 124, 73}, 10)
                     + StringDecoder.d(new byte[]{-82, -90, -88, -79}, -1637680035 ^ -1637679978)
               )) {
                  SyncController.p = Math.max(
                     0,
                     Math.min(
                        -1209973962 ^ -1209974562, var3.get(TokenExtractor.w(new byte[]{122, 96, 99, 97, 126, 98, 120, 77, 99, 107, 101, 124}, 14)).getAsInt()
                     )
                  );
               }
            } catch (Exception var16) {
            }

            try {
               if (var3.has(NotifyResolver.q(new byte[]{57, 53}, 77) + NotifyResolver.q(new byte[]{100, 112, 68, 114, 87, 104, 81, 87, 55, 45}, 20))) {
                  SyncController.z = var3.get(
                        StringDecoder.d(new byte[]{-9, -5, -15, -27, -45, -23, -42, -31, -22}, -1983497365 ^ -1983497240)
                           + TokenExtractor.w(new byte[]{-63}, 1680795717 ^ 1680795901)
                           + YieldKeeper.v(new byte[]{59, -40}, 88)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var15) {
            }

            try {
               if (var3.has(
                  NotifyResolver.q(new byte[]{45, 59, 54, 51, 34, 36, 30}, 95)
                     + YieldKeeper.v(new byte[]{65, 42, -8}, 51)
                     + StringDecoder.d(new byte[]{-2, -23, -16, -16}, 34515886 ^ 34515753)
               )) {
                  SyncController.aa = var3.get(
                        YieldKeeper.v(new byte[]{-30, 69, -35, 37, -67, 2}, -1165108066 ^ -1165108210)
                           + YieldKeeper.v(new byte[]{26, -116, 49, -99}, 127)
                           + JoinerWriter.p(new byte[]{-33, -44, -39, -41}, -242055013 ^ -242055167)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var14) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{77, 93, 81, 91, 85}, 61)
                     + JoinerWriter.p(new byte[]{51, 94}, 16)
                     + TokenExtractor.w(new byte[]{-64, -36, -57, -61}, -139209879 ^ -139209769)
               )) {
                  SyncController.ab = var3.get(
                        JoinerWriter.p(new byte[]{-95, -111}, -209036969 ^ -209036904)
                           + JoinerWriter.p(new byte[]{41, 31, 37, -5, 38, 43}, 69)
                           + QueryZone.r(new byte[]{-43, -58, -38}, -58281478 ^ -58281662)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var13) {
            }

            try {
               if (var3.has(
                  StringDecoder.d(new byte[]{-69, -95, -91, -68}, 864378319 ^ 864378119)
                     + JoinerWriter.p(new byte[]{-54}, 1669680041 ^ 1669679912)
                     + TokenExtractor.w(new byte[]{16}, 114)
                     + YieldKeeper.v(new byte[]{-62, 20, 88, -126, -61, 17}, 1332885072 ^ 1332885227)
               )) {
                  SyncController.ac = var3.get(
                        QueryZone.r(new byte[]{109, 127, 99, 114, 73}, 29)
                           + TokenExtractor.w(new byte[]{93, 70, 92, 84}, 59)
                           + NotifyResolver.q(new byte[]{40}, 70)
                           + StringDecoder.d(new byte[]{50, 36}, 86)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var12) {
            }

            try {
               if (var3.has(QueryZone.r(new byte[]{6, 13, 29, 5, 27, 43, 10, 46, 55, 79, 83}, 104))) {
                  SyncController.ad = Math.max(
                     0,
                     Math.min(
                        1,
                        var3.get(
                              StringDecoder.d(new byte[]{-87}, -1326178428 ^ -1326178496)
                                 + YieldKeeper.v(new byte[]{119, 84, 61, 12, 29, -33, -38, -92, -67, -126}, 24)
                           )
                           .getAsInt()
                     )
                  );
               }
            } catch (Exception var11) {
            }

            try {
               if (var3.has(NotifyResolver.q(new byte[]{84, 90, 90}, 55) + YieldKeeper.v(new byte[]{42, -7, -120, 75, 24, -40, -101, 59}, 73))) {
                  SyncController.ae = var3.get(
                        QueryZone.r(new byte[]{-21, -19, -13, -16}, -1475623172 ^ -1475623305)
                           + NotifyResolver.q(new byte[]{-35}, -946380976 ^ -946380826)
                           + YieldKeeper.v(new byte[]{19, -17, -75, 110}, 64)
                           + JoinerWriter.p(new byte[]{40, 54}, 60)
                     )
                     .getAsBoolean();
               }
            } catch (Exception var10) {
            }

            try {
               if (var3.has(StringDecoder.d(new byte[]{-78, -81, -109, -85, -81, -73, -84, -91}, -1316600902 ^ -1316600963))) {
                  SyncController.af = Math.max(
                     0,
                     Math.min(
                        -1016578802 ^ -1016578664,
                        var3.get(QueryZone.r(new byte[]{-42, -61, -25, -41, -45, -13, -32, -15}, -462880543 ^ -462880703)).getAsInt()
                     )
                  );
               }
            } catch (Exception var9) {
            }

            try {
               if (var3.has(
                  JoinerWriter.p(new byte[]{-37, -24, -37, -92, -44, -77, -41, -32}, -234165821 ^ -234165937)
                     + TokenExtractor.w(new byte[]{82, 70}, 36)
                     + StringDecoder.d(new byte[]{88}, 54)
                     + JoinerWriter.p(new byte[]{62, 63}, 37)
               )) {
                  SyncController.ag = Math.max(
                     0,
                     Math.min(
                        2,
                        var3.get(
                              QueryZone.r(new byte[]{-2, -27, -30, -79, -31, -8, -34, -35, -43, -71, -67}, 217909641 ^ 217909523)
                                 + QueryZone.r(new byte[]{114, 125}, 18)
                           )
                           .getAsInt()
                     )
                  );
               }
            } catch (Exception var8) {
            }

            try {
               if (var3.has(TokenExtractor.w(new byte[]{27, 6, 27, 66, 20, 36, 30, 20, 4, 14}, 123))) {
                  SyncController.ah = Math.max(
                     0,
                     Math.min(
                        1,
                        var3.get(
                              YieldKeeper.v(new byte[]{72, 43, -28, -113}, 47)
                                 + YieldKeeper.v(new byte[]{44, -61, -80}, 72)
                                 + StringDecoder.d(new byte[]{-7}, 250164659 ^ 250164523)
                                 + TokenExtractor.w(new byte[]{89, 77}, 43)
                           )
                           .getAsInt()
                     )
                  );
               }
            } catch (Exception var7) {
            }

            try {
               if (var3.has(YieldKeeper.v(new byte[]{6, -73, 74, -73, -127, 9, -41, 105, 10, -93, 95, -11}, 97))) {
                  SyncController.ai = Math.max(
                     70, Math.min(100, var3.get(JoinerWriter.p(new byte[]{-20, -7, -20, -75, -27, -49, -17, -33, -32, -27, -17, -13}, 123)).getAsInt())
                  );
               }
            } catch (Exception var6) {
            }

            try {
               if (var3.has(JoinerWriter.p(new byte[]{-11, 2, -11, -42, -17, 2}, 114))) {
                  CoreZoneProcessor var36 = ConfigBridge.c.c99().a(CoreZoneProcessor.class);
                  if (var36 != null) {
                     var36.d(var3.get(StringDecoder.d(new byte[]{8, 27, 4, 39, 14, 19}, 111)).getAsInt());
                  }
               }
            } catch (Exception var5) {
            }
         }

         this.d(var1);
      } catch (Exception var35) {
      }
   }

   private static JsonElement b(JsonObject var0, BuilderFactory var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      char[] var2 = var1.c;
      int var3 = var1.cK;

      for (Entry var5 : var0.entrySet()) {
         String var6 = (String)var5.getKey();
         if (var6.length() == var2.length) {
            boolean var7 = true;

            for (int var8 = 0; var8 < var2.length; var8++) {
               if ((char)(var2[var8] ^ var3 + var8 * 31) != var6.charAt(var8)) {
                  var7 = false;
                  break;
               }
            }

            if (var7) {
               return (JsonElement)var5.getValue();
            }
         }
      }

      return null;
   }

   private static JsonElement c(JsonObject var0, InitAdapter var1) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      char[] var2 = var1.a;
      int var3 = var1.aK;

      for (Entry var5 : var0.entrySet()) {
         String var6 = (String)var5.getKey();
         if (var6.length() == var2.length) {
            boolean var7 = true;

            for (int var8 = 0; var8 < var2.length; var8++) {
               if ((char)(var2[var8] ^ var3 + var8 * 31) != var6.charAt(var8)) {
                  var7 = false;
                  break;
               }
            }

            if (var7) {
               return (JsonElement)var5.getValue();
            }
         }
      }

      return null;
   }

   private void d(JsonObject var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      if (ConfigBridge.c != null && ConfigBridge.c.c99() != null) {
         SyncDispatcher var2 = ConfigBridge.c.c99();

         for (BuilderFactory var4 : var2.a()) {
            JsonElement var5 = var1.get(var4.getClass().getSimpleName());
            if (var5 == null || !var5.isJsonObject()) {
               var5 = b(var1, var4);
            }

            if (var5 != null && var5.isJsonObject()) {
               JsonObject var6 = var5.getAsJsonObject();
               JsonElement var7 = var6.get(QueryZone.r(new byte[]{-34, -36, -56, -62, -53, -5, -15}, -2024489029 ^ -2024489213));

               try {
                  if (var7 != null && var7.isJsonPrimitive() && !var7.getAsBoolean()) {
                     var4.a(false);
                  }
               } catch (Exception var23) {
               }

               try {
                  JsonElement var8 = var6.get(new String(new byte[]{107, 101, 121, 66, 105, 110, 100}));
                  if (var8 != null && var8.isJsonPrimitive()) {
                     var4.a(var8.getAsInt());
                  }
               } catch (Exception var22) {
               }

               int var24 = 0;

               for (InitAdapter var10 : var4.k()) {
                  JsonElement var11 = var6.get(Integer.toString(var24++));
                  if (var11 == null) {
                     var11 = c(var6, var10);
                  }

                  if (var11 == null) {
                     if (var4 instanceof CoreZoneProcessor) {
                        try {
                           ((CoreZoneProcessor)var4).i(var10);
                        } catch (Exception var21) {
                        }
                     }
                  } else {
                     try {
                        if (var10 instanceof CheckerBridge var12) {
                           var12.a(var11.getAsBoolean());
                        } else if (var10 instanceof TimingEntry var13) {
                           var13.load(var11.getAsJsonPrimitive().isNumber(), var11.getAsString());
                        } else if (var10 instanceof BlockCalculator var14) {
                           var14.a(var11.getAsDouble());
                        } else if (var10 instanceof ItemDescriptor var15) {
                           var15.a(var11.getAsInt());
                           if (var15.i()) {
                              var4.a(var11.getAsInt());
                           }
                        } else if (var10 instanceof SlotEntry var16) {
                           String var18 = var11.getAsString();
                           if (var16.g().contains(var18)) {
                              var16.a(var18);
                           }
                        } else if (var10 instanceof TextEntry var17) {
                           var17.b(var11.getAsString());
                        }
                     } catch (Exception var20) {
                     }
                  }
               }

               try {
                  if (var7 != null && var7.isJsonPrimitive() && var7.getAsBoolean()) {
                     var4.a(true);
                  }
               } catch (Exception var19) {
               }
            }
         }
      }
   }

   public void c() {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      this.e(StringDecoder.d(new byte[]{-51, -51, -51, -53, -40, -64, -37}, 1533082528 ^ 1533082377));
   }

   public void e(String var1) {
      if (av != 0) {
         new Object().hashCode();
      }

      try {
         Files.createDirectories(this.am);
         Path var2 = this.am.resolve(var1 + JoinerWriter.p(new byte[]{-103, -44, -36, -41, -43}, 1807827109 ^ 1807826992));
         Files.write(var2, aj(this.al.toJson(this.f())));
      } catch (Exception var3) {
      }
   }

   public JsonObject f() {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty(
         StringDecoder.d(new byte[]{-85}, 1865030713 ^ 1865030897) + StringDecoder.d(new byte[]{20, 16, 25, 16, 59, 8, 23, 44, 19, 16, 30, 22}, 120),
         SyncController.n
      );
      var2.addProperty(
         NotifyResolver.q(new byte[]{92, 90, 89, 84, 87, 86, 100, 75, 6}, 46) + YieldKeeper.v(new byte[]{-76, -49, 22}, 557402027 ^ 557401978),
         SyncController.m
      );
      var2.addProperty(StringDecoder.d(new byte[]{-43, -61, -63, -25, -52, -50, -50, -46}, 149756205 ^ 149756298), SyncController.b);
      var2.addProperty(
         StringDecoder.d(new byte[]{79, 91, 79, 78, 66, 110}, 40)
            + NotifyResolver.q(new byte[]{81}, 62)
            + YieldKeeper.v(new byte[]{-2}, -128715212 ^ -128715098)
            + StringDecoder.d(new byte[]{45, 49}, 66),
         SyncController.c
      );
      var2.addProperty(
         JoinerWriter.p(new byte[]{23, 32}, 75) + YieldKeeper.v(new byte[]{-31, 77, -1, 63, -120, 23, 126}, 216948322 ^ 216948470), SyncController.d
      );
      var2.addProperty(TokenExtractor.w(new byte[]{61, 59, 15, 55, 55}, 90), SyncController.e);
      var2.addProperty(YieldKeeper.v(new byte[]{49, -63, -66, 62, -6, -105, 43}, 83), SyncController.f);
      var2.addProperty(NotifyResolver.q(new byte[]{21, 17, 49, 18, 18, 11}, 119), SyncController.g);
      var2.addProperty(
         TokenExtractor.w(new byte[]{-10, -21}, -1627977282 ^ -1627977420)
            + YieldKeeper.v(new byte[]{120, 87, 50, 61, -1}, 29)
            + JoinerWriter.p(new byte[]{-53, -53, -35}, 1963708448 ^ 1963708601),
         ThemeCache.o
      );
      var2.addProperty(
         TokenExtractor.w(new byte[]{4, 23, 27, 16, 25, 58, 25, 26}, 119)
            + TokenExtractor.w(new byte[]{63, 55}, 95)
            + TokenExtractor.w(new byte[]{-11, -46}, -7205895 ^ -7206032),
         ThemeCache.p[0]
      );
      var2.addProperty(
         JoinerWriter.p(new byte[]{-10, -23, -27, -20, -29, -66, -33}, 126)
            + StringDecoder.d(new byte[]{-43, -46}, -1949308654 ^ -1949308508)
            + TokenExtractor.w(new byte[]{-30, -7, -55}, 976924686 ^ 976924810),
         ThemeCache.p[1]
      );
      var2.addProperty(TokenExtractor.w(new byte[]{-10, -21, -27, -20, -29, -58, -25, -26, -1, -11, -20, -37}, 1557762143 ^ 1557762261), ThemeCache.p[2]);
      var2.addProperty(QueryZone.r(new byte[]{51, 38, 48, 49, 62, 32, 14, 34}, 68), ThemeCache.q[0]);
      var2.addProperty(JoinerWriter.p(new byte[]{-12, -25, -29, -22, -31, -67, -31, -64}, 741675839 ^ 741675967), ThemeCache.q[1]);
      var2.addProperty(StringDecoder.d(new byte[]{50, 47, 33, 40, 39, 1, 39, 3}, 70), ThemeCache.q[2]);
      var2.addProperty(
         NotifyResolver.q(new byte[]{-91, -89, -96, -91}, -1268731505 ^ -1268731576)
            + YieldKeeper.v(new byte[]{-92, -12, 38, 121, -95, -10, 17, 113, -74}, -506600690 ^ -506600499),
         SyncController.q
      );
      var2.addProperty(QueryZone.r(new byte[]{-44, -58, -35, -41, -56, -20, -2, -28}, 947909941 ^ 947910038), SyncController.r);
      var2.addProperty(QueryZone.r(new byte[]{-63, -55, -33, -53, -16, -12, -18, -33, -3, -100, -127, -126, -124}, -86704651 ^ -86704814), SyncController.s);
      var2.addProperty(
         YieldKeeper.v(new byte[]{-6, 86, -74}, -836483757 ^ -836483634)
            + TokenExtractor.w(new byte[]{100, 103, 69, 115, 125}, 22)
            + QueryZone.r(new byte[]{30, 30, 26}, 120),
         SyncController.t
      );
      var2.addProperty(JoinerWriter.p(new byte[]{14, 27, 14, -41, 7}, 89), SyncController.u);
      var2.addProperty(NotifyResolver.q(new byte[]{114, 97, 120, 47, 97, 72, 94, 66}, 21), SyncController.v);
      var2.addProperty(
         JoinerWriter.p(new byte[]{-37, -24, -37, -92, -44, -80, -37}, -837148877 ^ -837148737)
            + QueryZone.r(new byte[]{12, 14}, 109)
            + NotifyResolver.q(new byte[]{104, 98, 106, 97}, 13),
         SyncController.w
      );
      var2.addProperty(
         QueryZone.r(new byte[]{-49, -44, -45, -128}, -605168838 ^ -605168751)
            + YieldKeeper.v(new byte[]{72, 10, -31, -44, -87, 107, 81, 45}, 44)
            + NotifyResolver.q(new byte[]{28, 6, 30, 21, 13}, 115),
         SyncController.x
      );
      var2.addProperty(
         YieldKeeper.v(new byte[]{45, -31}, 74)
            + JoinerWriter.p(new byte[]{48, -7, 41, 7, 47, 49, 52, 37}, 57)
            + JoinerWriter.p(new byte[]{-3}, 82)
            + NotifyResolver.q(new byte[]{55, 28, 60, 61, 40, 39, 24}, 89),
         SyncController.y
      );
      var2.addProperty(TokenExtractor.w(new byte[]{12, 31, 12, 55, 4, 7, 13, 5}, 109), SyncController.a);
      var2.addProperty(
         JoinerWriter.p(new byte[]{56, 56}, 54)
            + YieldKeeper.v(new byte[]{73, 19}, 61)
            + StringDecoder.d(new byte[]{-5, -27, -52, -15}, -72285545 ^ -72285686)
            + QueryZone.r(new byte[]{47, 61, 44}, 89),
         NoticeQueue.m
      );
      var2.addProperty(
         QueryZone.r(new byte[]{76, 78, 88}, 40)
            + StringDecoder.d(new byte[]{-20, -19}, 291930192 ^ 291930319)
            + NotifyResolver.q(new byte[]{125, 72}, 59)
            + StringDecoder.d(new byte[]{-14, -17, -21}, -1114085416 ^ -1114085563),
         SyncController.h
      );
      var2.addProperty(
         TokenExtractor.w(new byte[]{11, 21, 27, 19, 27, 63, 1, 19}, 124)
            + TokenExtractor.w(new byte[]{90}, 58)
            + YieldKeeper.v(new byte[]{127}, 22)
            + QueryZone.r(new byte[]{-41, -45}, -1674516672 ^ -1674516512),
         SyncController.i
      );
      var2.addProperty(TokenExtractor.w(new byte[]{62}, 95) + JoinerWriter.p(new byte[]{29, 32, -13, 30, 31, 36, 28, 33}, 76), SyncController.j);
      var2.addProperty(JoinerWriter.p(new byte[]{52, 50, 51, 58, 53, 63, 59, 64, 56, 45, 10, 51, 59, 55}, 46), SyncController.k);
      var2.addProperty(
         QueryZone.r(new byte[]{54}, 83) + NotifyResolver.q(new byte[]{-59, -55, -52, -60, -38, -38, -48, -16, -112, -108, -84, -82}, 1826340889 ^ 1826341053),
         SyncController.l
      );
      var2.addProperty(
         TokenExtractor.w(new byte[]{80, 74, 77, 79, 84, 72, 94, 107, 73}, 38) + StringDecoder.d(new byte[]{118}, 26) + QueryZone.r(new byte[]{74, 91}, 40),
         SyncController.p
      );
      var2.addProperty(
         TokenExtractor.w(new byte[]{-51}, -1514107009 ^ -1514106931)
            + JoinerWriter.p(new byte[]{61, 51}, 60)
            + JoinerWriter.p(new byte[]{-54, -72, -46, -75, -58, -63, -47, -63, -59}, 1231010498 ^ 1231010393),
         SyncController.z
      );
      var2.addProperty(YieldKeeper.v(new byte[]{103, 79, 82, 49, 4, 28, -10, -38, -15, -77, -98, -109, 100, 82}, 21), SyncController.aa);
      var2.addProperty(NotifyResolver.q(new byte[]{92, 76, 70, 64, 80, 118, 103, 104, 2, 9, 59}, 44), SyncController.ab);
      var2.addProperty(
         JoinerWriter.p(new byte[]{50, 38, 44, 51}, 65)
            + StringDecoder.d(new byte[]{105, 70}, 34)
            + TokenExtractor.w(new byte[]{-75}, -1880267071 ^ -1880267263)
            + YieldKeeper.v(new byte[]{113, 79, 87, 40, 44}, 19),
         SyncController.ac
      );
      var2.addProperty(
         NotifyResolver.q(new byte[]{-35}, -1529901063 ^ -1529901239)
            + NotifyResolver.q(new byte[]{73}, 38)
            + TokenExtractor.w(new byte[]{-61, -45, -51, -59, -20, -48}, 1198382609 ^ 1198382780)
            + StringDecoder.d(new byte[]{91, 91, 79}, 63),
         SyncController.ad
      );
      var2.addProperty(StringDecoder.d(new byte[]{115, 125, 123, 112, 127, 70, 121, 98, 118, 125, 105}, 16), SyncController.ae);
      var2.addProperty(NotifyResolver.q(new byte[]{82, 79, 117, 65, 91, 75, 110, 115}, 39), SyncController.af);
      var2.addProperty(
         YieldKeeper.v(new byte[]{106, 111, 78, 7, 37, 10}, 13)
            + NotifyResolver.q(new byte[]{101}, 12)
            + NotifyResolver.q(new byte[]{95, 89}, 44)
            + JoinerWriter.p(new byte[]{80, 92, 80, 81}, 17),
         SyncController.ag
      );
      var2.addProperty(
         StringDecoder.d(new byte[]{67, 80, 79, 20, 68, 114, 74}, 36)
            + YieldKeeper.v(new byte[]{85}, 52)
            + StringDecoder.d(new byte[]{-43, -63}, 1051691232 ^ 1051691077),
         SyncController.ah
      );
      var2.addProperty(YieldKeeper.v(new byte[]{72, 43, -28, -113, -113, 85, 57, 25, -60, -65, 113, 77}, 47), SyncController.ai);

      try {
         CoreZoneProcessor var3 = ConfigBridge.c.c99().a(CoreZoneProcessor.class);
         if (var3 != null) {
            var2.addProperty(TokenExtractor.w(new byte[]{44, 63, 32, 3, 34, 63}, 79), var3.p());
         }
      } catch (Exception var18) {
      }

      var1.add(
         TokenExtractor.w(new byte[]{-39, -52}, 1910218571 ^ 1910218750)
            + JoinerWriter.p(new byte[]{-70, -93}, -1741858493 ^ -1741858324)
            + TokenExtractor.w(new byte[]{-26, -10, -11, -23}, 1873192527 ^ 1873192644)
            + QueryZone.r(new byte[]{-90, -90, -87}, -1099787834 ^ -1099788019),
         var2
      );
      SyncDispatcher var19 = ConfigBridge.c.c99();

      for (BuilderFactory var5 : var19.a()) {
         JsonObject var6 = new JsonObject();
         var6.addProperty(StringDecoder.d(new byte[]{-95, -85, -89, -91, -84, -92, -90}, 285217802 ^ 285217998), var5.f());
         var6.addProperty(new String(new byte[]{107, 101, 121, 66, 105, 110, 100}), var5.j());
         int var7 = 0;

         for (InitAdapter var9 : var5.k()) {
            String var10 = Integer.toString(var7++);

            try {
               if (var9 instanceof CheckerBridge var11) {
                  var6.addProperty(var10, var11.f());
               } else if (var9 instanceof TimingEntry var12) {
                  var6.addProperty(var10, var12.save());
               } else if (var9 instanceof BlockCalculator var13) {
                  var6.addProperty(var10, var13.f());
               } else if (var9 instanceof ItemDescriptor var14) {
                  var6.addProperty(var10, var14.g());
               } else if (var9 instanceof SlotEntry var15) {
                  var6.addProperty(var10, var15.f());
               } else if (var9 instanceof TextEntry var16) {
                  var6.addProperty(var10, var16.f());
               }
            } catch (Exception var17) {
            }
         }

         var1.add(var5.getClass().getSimpleName(), var6);
      }

      return var1;
   }

   public String g() {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         return this.i(this.f());
      } catch (Throwable var2) {
         return null;
      }
   }

   public String h(String var1) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      JsonObject var2 = this.j(var1);
      if (var2 == null) {
         return null;
      }

      try {
         return this.i(var2);
      } catch (Throwable var4) {
         return null;
      }
   }

   private String i(JsonObject var1) throws IOException {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      byte[] var2 = this.al.toJson(var1).getBytes(StandardCharsets.UTF_8);
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();

      try (GZIPOutputStream var4 = new GZIPOutputStream(var3)) {
         var4.write(var2);
      }

      return NotifyResolver.q(new byte[]{-18, -6, -19, -110, -128}, -21388423 ^ -21388333)
         + Base64.getUrlEncoder().withoutPadding().encodeToString(var3.toByteArray());
   }

   private JsonObject j(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      return this.l(this.am.resolve(var1 + StringDecoder.d(new byte[]{19, 86, 76, 81, 87}, 61)));
   }

   public JsonObject k(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      return this.j(var1);
   }

   public JsonObject l(Path var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         if (Files.isRegularFile(var1) && Files.size(var1) <= 4194304L) {
            byte[] var2 = Files.readAllBytes(var1);
            if (var2.length == 0) {
               return null;
            }

            boolean var3 = var2[0] == 123 || var2[0] == 32 || var2[0] == 10 || var2[0] == 13 || var2[0] == 9;
            String var4 = var3 ? new String(var2, StandardCharsets.UTF_8) : ak(var2);
            return (JsonObject)this.al.fromJson(var4, JsonObject.class);
         } else {
            return null;
         }
      } catch (Exception var5) {
         return null;
      }
   }

   public byte[] m(JsonObject var1) {
      if (av != 0) {
         new Object().hashCode();
      }

      if (ConfigBridge.c == null || ConfigBridge.c.c99() == null) {
         return null;
      }

      if (var1 == null) {
         return null;
      }

      List var2 = ConfigBridge.c.c99().a();
      byte[] var3 = new byte[var2.size()];

      for (int var4 = 0; var4 < var3.length; var4++) {
         BuilderFactory var5 = (BuilderFactory)var2.get(var4);
         byte var6 = -1;
         JsonElement var7 = null;
         JsonElement var8 = null;

         try {
            var7 = var1.get(var5.getClass().getSimpleName());
            if (var7 == null || !var7.isJsonObject()) {
               var7 = b(var1, var5);
            }

            if (var7 != null && var7.isJsonObject()) {
               var8 = var7.getAsJsonObject().get(StringDecoder.d(new byte[]{-23, -29, -17, -19, -28, -20, -18}, 1129194953 ^ 1129194821));
               if (var8 != null && var8.isJsonPrimitive()) {
                  var6 = (byte)(var8.getAsBoolean() ? 1 : 0);
               }
            }
         } catch (Exception var10) {
         }

         var3[var4] = var6;
      }

      return var3;
   }

   public long n(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      try {
         return Files.getLastModifiedTime(this.am.resolve(var1 + NotifyResolver.q(new byte[]{49, 116, 104, 121, 97}, 31))).toMillis();
      } catch (Exception var3) {
         return 0L;
      }
   }

   public boolean o(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      JsonObject var2 = this.p(var1);
      if (var2 == null) {
         return false;
      }

      try {
         this.a(var2);
         this.c();
         return true;
      } catch (Throwable var4) {
         return false;
      }
   }

   public JsonObject p(String var1) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         if (var1 == null) {
            return null;
         }

         String var2 = var1.trim();
         if (var2.startsWith(JoinerWriter.p(new byte[]{2, 14, -1, -20, -12}, 66))) {
            var2 = var2.substring(TokenExtractor.w(new byte[]{21, 3, 16, 109, 103}, 84).length());
         }

         var2 = var2.replaceAll(YieldKeeper.v(new byte[]{-97, -11, 98}, -1836455185 ^ -1836455380), "");
         if (var2.isEmpty()) {
            return null;
         }

         byte[] var3;
         try {
            var3 = Base64.getUrlDecoder().decode(var2);
         } catch (IllegalArgumentException var10) {
            var3 = Base64.getDecoder().decode(var2.replace('-', '+').replace('_', '/'));
         }

         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var3));

         Object var8;
         label76: {
            try {
               byte[] var6 = new byte[8192];

               int var7;
               while ((var7 = var5.read(var6)) > 0) {
                  var4.write(var6, 0, var7);
                  if (var4.size() > 4194304L) {
                     var8 = null;
                     break label76;
                  }
               }
            } catch (Throwable var11) {
               try {
                  var5.close();
               } catch (Throwable var9) {
                  var11.addSuppressed(var9);
               }

               throw var11;
            }

            var5.close();
            JsonObject var14 = (JsonObject)this.al
               .fromJson(var4.toString(JoinerWriter.p(new byte[]{-67, -69, -84, -110, -100}, 1975922787 ^ 1975922939)), JsonObject.class);
            if (var14 != null && var14.size() != 0) {
               return var14;
            }

            return null;
         }

         var5.close();
         return (JsonObject)var8;
      } catch (Throwable var12) {
         return null;
      }
   }

   public void q(String var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         Path var2 = this.am.resolve(var1 + QueryZone.r(new byte[]{8, 69, 71, 82, 84}, 37));
         if (!Files.isRegularFile(var2)) {
            return;
         }

         this.an = var2;
         this.a();
         this.an = this.am.resolve(JoinerWriter.p(new byte[]{-29, -29, -29, -35, -16, -26, -19, -90, -31, -23, -28, -30}, -1865384847 ^ -1865384720));
      } catch (Exception var3) {
      }
   }

   public List<String> r() {
      if (av != 0) {
         new Object().hashCode();
      }

      ArrayList var1 = new ArrayList();

      try {
         File var2 = this.am.toFile();
         if (var2.exists() && var2.isDirectory()) {
            File[] var3 = var2.listFiles();
            if (var3 != null) {
               for (File var7 : var3) {
                  if (var7.getName().endsWith(NotifyResolver.q(new byte[]{-120, -51, -47, -64, -40}, 1671348157 ^ 1671347995))) {
                     var1.add(var7.getName().replace(QueryZone.r(new byte[]{89, 20, 22, 3, 5}, 116), ""));
                  }
               }
            }
         }
      } catch (Exception var8) {
      }

      return var1;
   }

   public Path s() {
      if (av != 0) {
         System.nanoTime();
      }

      return this.am;
   }

   public String[] t() {
      if (av != 0) {
         new Object().hashCode();
      }

      ArrayList var1 = new ArrayList();
      String var2 = "";

      try {
         Path var3 = this.am
            .resolve(
               NotifyResolver.q(new byte[]{-30, -31, -7, -3, -21, -25, -45, -48}, 695671313 ^ 695671427)
                  + YieldKeeper.v(new byte[]{96, -15, -113, 76, -25}, 78)
            );
         if (Files.isRegularFile(var3)) {
            for (String var5 : Files.readAllLines(var3, StandardCharsets.UTF_8)) {
               if (var5.length() >= 3 && var5.charAt(1) == '\t') {
                  String var6 = var5.substring(2);
                  if (var5.charAt(0) == 'u') {
                     var2 = var6;
                  } else if (var5.charAt(0) == 'p' && !var1.contains(var6)) {
                     var1.add(var6);
                  }
               }
            }
         }
      } catch (Exception var7) {
      }

      String[] var8 = new String[var1.size() + 1];
      var8[0] = var2;

      for (int var9 = 0; var9 < var1.size(); var9++) {
         var8[var9 + 1] = (String)var1.get(var9);
      }

      return var8;
   }

   public void u(String var1, List<String> var2) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         Files.createDirectories(this.am);
         StringBuilder var3 = new StringBuilder();
         if (var1 != null && !var1.isEmpty()) {
            var3.append('u').append('\t').append(var1).append('\n');
         }

         if (var2 != null) {
            for (String var5 : var2) {
               if (var5 != null && !var5.isEmpty()) {
                  var3.append('p').append('\t').append(var5).append('\n');
               }
            }
         }

         Files.write(
            this.am
               .resolve(
                  NotifyResolver.q(new byte[]{-79, -78, -86, -82, -72, -76, -128, -125}, 997944645 ^ 997944708)
                     + JoinerWriter.p(new byte[]{-90, -28}, -255688296 ^ -255688432)
                     + JoinerWriter.p(new byte[]{-51}, 1449039034 ^ 1449038882)
                     + StringDecoder.d(new byte[]{98, 118}, 22)
               ),
            var3.toString().getBytes(StandardCharsets.UTF_8)
         );
      } catch (Exception var6) {
      }
   }

   public String v(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      for (String var3 : this.r()) {
         if (var3.equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public String w(String var1) {
      if (av != 0) {
         new Object().hashCode();
      }

      List var2 = this.r();
      String var3 = var1;

      for (int var4 = 2; var4 < (-1493719394 ^ -1493728882); var4++) {
         boolean var5 = var3.equalsIgnoreCase(YieldKeeper.v(new byte[]{91, 27, -37, -99, 78, 22, -51}, 63));

         for (int var6 = 0; var6 < var2.size() && !var5; var6++) {
            var5 = ((String)var2.get(var6)).equalsIgnoreCase(var3);
         }

         if (!var5) {
            return var3;
         }

         var3 = var1 + JoinerWriter.p(new byte[]{-6}, 38) + var4;
      }

      return var1 + QueryZone.r(new byte[]{-66}, 2099444121 ^ 2099443972) + System.currentTimeMillis();
   }

   public int x(String var1, String var2) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         Path var3 = this.am.resolve(var1 + QueryZone.r(new byte[]{-92, -23, -21, -2, -8}, -803588955 ^ -803589076));
         if (!Files.isRegularFile(var3)) {
            return 2;
         }

         if (var1.equals(var2)) {
            return 0;
         }

         String var4 = this.v(var2);
         if (var4 != null && !var4.equalsIgnoreCase(var1)) {
            return 1;
         }

         Path var5 = this.am.resolve(var2 + StringDecoder.d(new byte[]{-2, -69, -95, -68, -70}, -1429518804 ^ -1429518596));
         if (var1.equalsIgnoreCase(var2)) {
            Path var6 = this.am.resolve(var1 + StringDecoder.d(new byte[]{95, 2, 22, 28, 20, 25, 30, 24, 30}, 113));
            Files.move(var3, var6);
            Files.move(var6, var5);
         } else {
            Files.move(var3, var5);
         }

         return 0;
      } catch (Exception var7) {
         return 3;
      }
   }

   public String y(String var1) {
      if (av != 0) {
         System.nanoTime();
      }

      try {
         Path var2 = this.am.resolve(var1 + YieldKeeper.v(new byte[]{-1, -56, 0, 43, 123}, -1835893495 ^ -1835893288));
         if (!Files.isRegularFile(var2)) {
            return null;
         }

         String var3 = this.w(var1 + JoinerWriter.p(new byte[]{113, -77, -66, -66, -58}, -377991236 ^ -377991405));
         Files.copy(var2, this.am.resolve(var3 + StringDecoder.d(new byte[]{-96, -27, -1, -30, -28}, 283791216 ^ 283791358)));
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   public Path z(String var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      String var2 = this.h(var1);
      if (var2 == null) {
         return null;
      }

      try {
         Path var3 = this.am.resolve(StringDecoder.d(new byte[]{5, 25, 18, 12, 22, 17, 21}, 96));
         Files.createDirectories(var3);
         Path var4 = var3.resolve(var1 + StringDecoder.d(new byte[]{-106, -51, -62, -49}, 1578368425 ^ 1578368273));
         Files.write(var4, var2.getBytes(StandardCharsets.UTF_8));
         return var4;
      } catch (Exception var5) {
         return null;
      }
   }

   public String aa(String var1) {
      if (av != 0) {
         new Object().hashCode();
      }

      try {
         Path var2 = this.am.resolve(var1 + NotifyResolver.q(new byte[]{8, 77, 81, 64, 88}, 38));
         if (!Files.isRegularFile(var2)) {
            return null;
         }

         Path var3 = this.am.resolve(JoinerWriter.p(new byte[]{-19, 50, 47, 29, 46, 34}, 65));
         Files.createDirectories(var3);
         Path var4 = var3.resolve(
            var1
               + NotifyResolver.q(new byte[]{-109}, -1220606452 ^ -1220606287)
               + System.currentTimeMillis()
               + NotifyResolver.q(new byte[]{-98, -37, -57, -42, -50}, -1904647845 ^ -1904647701)
         );
         Files.move(var2, var4, StandardCopyOption.REPLACE_EXISTING);
         this.ab(var3);
         return var4.toString();
      } catch (Exception var5) {
         return null;
      }
   }

   private void ab(Path var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      File[] var2 = var1.toFile().listFiles();
      if (var2 != null && var2.length > 20) {
         long[] var3 = new long[var2.length];

         for (int var4 = 0; var4 < var2.length; var4++) {
            var3[var4] = ac(var2[var4].getName());
         }

         long[] var11 = (long[])var3.clone();
         Arrays.sort(var11);
         long var5 = var11[var11.length - 20];
         int var7 = 0;

         for (int var8 = var2.length - 1; var8 >= 0; var8--) {
            if (var3[var8] <= var5 && (var3[var8] != var5 || var7 >= 20)) {
               try {
                  Files.deleteIfExists(var2[var8].toPath());
               } catch (Exception var10) {
               }
            } else {
               var7++;
            }
         }
      }
   }

   private static long ac(String var0) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var1 = var0.lastIndexOf(46);
      int var2 = var1 > 0 ? var0.lastIndexOf(46, var1 - 1) : -1;
      if (var2 < 0) {
         return 0L;
      }

      try {
         return Long.parseLong(var0.substring(var2 + 1, var1));
      } catch (NumberFormatException var4) {
         return 0L;
      }
   }

   public String ad(String var1, String var2) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         Path var3 = Paths.get(var1).toAbsolutePath().normalize();
         Path var4 = this.am.resolve(YieldKeeper.v(new byte[]{-29, -18, 21, 85, 114, -90}, 742053402 ^ 742053591)).toAbsolutePath().normalize();
         if (var3.startsWith(var4) && Files.isRegularFile(var3)) {
            String var5 = this.w(var2);
            Files.move(var3, this.am.resolve(var5 + StringDecoder.d(new byte[]{54, 115, 105, 116, 114}, 24)));
            return var5;
         } else {
            return null;
         }
      } catch (Exception var6) {
         return null;
      }
   }

   public boolean ae(String var1, JsonObject var2) {
      if (av != 0) {
         new Object().hashCode();
      }

      try {
         Files.createDirectories(this.am);
         Files.write(this.am.resolve(var1 + TokenExtractor.w(new byte[]{-85, -18, -12, -23, -17}, -1440425382 ^ -1440425257)), aj(this.al.toJson(var2)));
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   public static boolean af(JsonObject var0) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (var0 != null && var0.size() != 0) {
         if (var0.has(StringDecoder.d(new byte[]{109, 126, 97, 90, 107, 123, 120, 100, 108, 100, 115}, 10))
            && var0.get(TokenExtractor.w(new byte[]{116, 101, 120, 69, 114, 96}, 18) + YieldKeeper.v(new byte[]{84, 41, 14, -25, -45}, 32)).isJsonObject()) {
            return true;
         }

         for (Entry var2 : var0.entrySet()) {
            if (((JsonElement)var2.getValue()).isJsonObject()
               && ((JsonElement)var2.getValue()).getAsJsonObject().has(YieldKeeper.v(new byte[]{49, -58, -99, 50, -56, -99, 40}, 84))) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public String ag(Path var1) {
      if (av != 0) {
         Thread.currentThread().getName().length();
      }

      JsonObject var2 = null;

      try {
         if (var1 != null && Files.isRegularFile(var1) && Files.size(var1) <= 4194304L) {
            String var3 = String.valueOf(var1.getFileName());
            int var4 = var3.lastIndexOf(46);
            String var5 = var4 > 0 ? var3.substring(0, var4) : var3;
            String var6 = var4 > 0 ? var3.substring(var4 + 1).toLowerCase(Locale.ROOT) : "";
            if (var6.equals(JoinerWriter.p(new byte[]{-38, -30, -35, -37}, -2007192179 ^ -2007192291))) {
               var2 = this.l(var1);
            } else {
               var2 = this.p(new String(Files.readAllBytes(var1), StandardCharsets.UTF_8));
            }

            if (!af(var2)) {
               return null;
            }

            String var7 = this.w(ah(var5));
            return this.ae(var7, var2) ? var7 : null;
         } else {
            return null;
         }
      } catch (Exception var8) {
         return null;
      }
   }

   public static String ah(String var0) {
      if (av != 0) {
         new Object().hashCode();
      }

      StringBuilder var1 = new StringBuilder();
      String var2 = var0 == null ? "" : var0;

      for (int var3 = 0; var3 < var2.length() && var1.length() < 32; var3++) {
         char var4 = var2.charAt(var3);
         boolean var5 = var4 < ' '
            || var4 == 127
            || var4 == '<'
            || var4 == '>'
            || var4 == ':'
            || var4 == '"'
            || var4 == '/'
            || var4 == '\\'
            || var4 == '|'
            || var4 == '?'
            || var4 == '*';
         var1.append(var5 ? '-' : var4);
      }

      String var6 = var1.toString().trim();

      while (var6.endsWith(NotifyResolver.q(new byte[]{-21}, 121059979 ^ 121059918))) {
         var6 = var6.substring(0, var6.length() - 1).trim();
      }

      while (var6.startsWith(QueryZone.r(new byte[]{-86}, 1102315304 ^ 1102315439))) {
         var6 = var6.substring(1).trim();
      }

      if (var6.isEmpty()) {
         var6 = NotifyResolver.q(new byte[]{11, 6, 2, 7, 17, 22}, 104);
      }

      if (ai(var6) || var6.equalsIgnoreCase(TokenExtractor.w(new byte[]{41, 41, 41, 47, 52, 44, 55}, 73))) {
         var6 = var6 + JoinerWriter.p(new byte[]{-105, -39, -28, -30, -39, -37, -40}, 1006076122 ^ 1006075987);
      }

      return var6;
   }

   public static boolean ai(String var0) {
      if (av != 0) {
         new Object().hashCode();
      }

      String var1 = var0.trim().toLowerCase(Locale.ROOT);
      int var2 = var1.indexOf(46);
      if (var2 >= 0) {
         var1 = var1.substring(0, var2).trim();
      }

      return var1.length() == 3
         ? var1.equals(QueryZone.r(new byte[]{53, 48, 42}, 85))
            || var1.equals(YieldKeeper.v(new byte[]{44, -54, 122}, 92))
            || var1.equals(JoinerWriter.p(new byte[]{-63, -44, -42}, -746112850 ^ -746113010))
            || var1.equals(QueryZone.r(new byte[]{-29, -15, -13}, 1765159209 ^ 1765159335))
         : var1.length() == 4
            && (var1.startsWith(QueryZone.r(new byte[]{40, 45, 52}, 72)) || var1.startsWith(StringDecoder.d(new byte[]{-31, -4, -5}, 1862488048 ^ 1862487933)))
            && var1.charAt(3) >= '1'
            && var1.charAt(3) <= '9';
   }

   private static byte[] aj(String var0) {
      if (av != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      byte[] var1 = var0.getBytes(StandardCharsets.UTF_8);

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (byte)(var1[var2] ^ au[var2 % au.length] + var2 * 31);
      }

      return var1;
   }

   private static String ak(byte[] var0) {
      if (av != 0) {
         new Object().hashCode();
      }

      byte[] var1 = new byte[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = (byte)(var0[var2] ^ au[var2 % au.length] + var2 * 31);
      }

      return new String(var1, StandardCharsets.UTF_8);
   }
}
