package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.StringDecoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;
import net.minecraft.client.MinecraftClient;

public final class BundleSync {
   public static volatile List<BundleSync.Entry> LIST = new ArrayList<>();
   public static volatile boolean ad = false;
   public static volatile String ae = "";
   public static volatile int af = 0;
   public static volatile int ag = 0;
   public static volatile String ah = "";
   private static final Object ai = new Object();
   private static String aj;
   private static Runnable ak;
   private static int al = 0;

   private BundleSync() {
   }

   private static String a() {
      return ConfigBridge.apiBase();
   }

   private static String b() {
      if (al != 0) {
         System.nanoTime();
      }

      try {
         byte[] var0 = SortableData.c[0];
         return var0 == null ? "" : new String(var0, StandardCharsets.UTF_8);
      } catch (Throwable var1) {
         return "";
      }
   }

   private static void c(String var0, Runnable var1) {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      e(var0, var1, false);
   }

   private static void d(String var0, Runnable var1) {
      if (al != 0) {
         System.nanoTime();
      }

      e(var0, var1, true);
   }

   private static void e(String var0, Runnable var1, boolean var2) {
   }

   private static void f(String var0, Runnable var1) {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      String var2 = var0;
      Runnable var3 = var1;

      while (var3 != null) {
         try {
            var3.run();
         } catch (Throwable var7) {
            NoticeQueue.err(
               QueryZone.r(new byte[]{110, 72, 80, 67, 85, 40}, 46) + TokenExtractor.w(new byte[]{-23, -1, -4, -32, -6}, -314291627 ^ -314291503),
               var7.getMessage() == null ? var2 + QueryZone.r(new byte[]{-112, -33, -61, -62, -64, -16, -6}, -1129857309 ^ -1129857456) : var7.getMessage()
            );
         }

         synchronized (ai) {
            var3 = ak;
            var2 = aj;
            ak = null;
            aj = null;
            if (var3 == null) {
               ad = false;
               ae = "";
            } else {
               ae = var2;
            }
         }
      }
   }

   private static JsonObject g(String var0, JsonObject var1) throws Exception {
      return null;
   }

   private static JsonObject h() {
      if (al != 0) {
         new Object().hashCode();
      }

      JsonObject var0 = new JsonObject();
      var0.addProperty(YieldKeeper.v(new byte[]{37, -19, -114, 80}, 77), b());
      return var0;
   }

   private static String i(JsonObject var0) {
      if (al != 0) {
         new Object().hashCode();
      }

      return var0.has(YieldKeeper.v(new byte[]{82, 28, -41, -77, 97}, 55)) && !var0.get(QueryZone.r(new byte[]{43, 53, 46, 58, 32}, 77)).isJsonNull()
         ? var0.get(NotifyResolver.q(new byte[]{-18, -8, -3, -19, -23}, 1301500354 ^ 1301500233)).getAsString()
         : TokenExtractor.w(new byte[]{124, 70, 68, 64, 66, 91, 77, 2}, 43)
            + JoinerWriter.p(new byte[]{44}, 57)
            + JoinerWriter.p(new byte[]{2}, 112)
            + QueryZone.r(new byte[]{-41, -61, -59}, -1375481674 ^ -1375481840);
   }

   public static void j(boolean var0) {
      if (al != 0) {
         System.nanoTime();
      }

      c(
         TokenExtractor.w(new byte[]{89, 121, 118, 116, 120, 124, 116}, 20),
         () -> {
            if (al != 0) {
               Math.abs(Integer.MIN_VALUE);
            }

            try {
               JsonObject var1 = g(
                  TokenExtractor.w(new byte[]{-114, -63, -41, -49, -118, -57, -44, -44, -33, -47, -40, -51, -110, -48, -38, -63, -59}, 1624509383 ^ 1624509292),
                  h()
               );
               if (!var1.has(QueryZone.r(new byte[]{-13, -2}, -1212128761 ^ -1212128616)) || !var1.get(QueryZone.r(new byte[]{63, 50}, 83)).getAsBoolean()) {
                  NoticeQueue.err(JoinerWriter.p(new byte[]{3, 43, 45, 50, 32}, 64), i(var1));
                  return;
               }

               List var2 = s(var1);
               LIST = var2;
               if (!var0) {
                  NoticeQueue.ok(
                     JoinerWriter.p(new byte[]{-65, -25, -23, -18, -36, -105}, 28677708 ^ 28677832) + StringDecoder.d(new byte[]{54, 61, 41, 37, 36, 36}, 69),
                     var2.size()
                        + QueryZone.r(new byte[]{78, 4, 19, 27, 20, 34, 39}, 109)
                        + (var2.size() == 1 ? "" : TokenExtractor.w(new byte[]{30}, 107))
                        + YieldKeeper.v(new byte[]{-93}, -639385278 ^ -639385151)
                        + YieldKeeper.v(new byte[]{92, 12, -42, -99, 93, 15}, 61)
                        + TokenExtractor.w(new byte[]{113, 124, 116}, 18)
                  );
               }
            } catch (Exception var3) {
               NoticeQueue.err(
                  TokenExtractor.w(new byte[]{122, 82, 80, 73, 89, 18, 70, 94, 67}, 58)
                     + TokenExtractor.w(new byte[]{50, 53, 54}, 82)
                     + StringDecoder.d(new byte[]{-12}, 526760059 ^ 526760167)
                     + JoinerWriter.p(new byte[]{-77, -77, -68, -76}, 1809351048 ^ 1809350950),
                  JoinerWriter.p(new byte[]{-111, -68, -63, -73, -82, 105, -74, -74, -70, 101}, 398828932 ^ 398828854)
                     + StringDecoder.d(new byte[]{-35, -33, -46, -42, -107, -64, -33}, 601629936 ^ 601629761)
                     + JoinerWriter.p(new byte[]{23, -47, 19, 30}, 78)
                     + YieldKeeper.v(new byte[]{73, 40, 28, -5, -29, -122, 120, 90, 45, -25, -33, -83}, 39)
               );
            }
         }
      );
   }

   public static void k(String var0, boolean var1) {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      String var2 = var0 == null ? "" : var0.trim();
      if (var2.isEmpty()) {
         NoticeQueue.err(
            StringDecoder.d(new byte[]{57, 23, 24, 17, 83, 0, 20, 1, 10, 23, 15, 25, 31}, 119),
            QueryZone.r(
               new byte[]{
                  -17, -56, -52, -42, -108, -7, -18, -6, -80, -118, -115, -107, -102, -100, -87, -25, -71, -15, 68, 66, 73, 88, 22, 105, 105, 107, 97, 31
               },
               -330111518 ^ -330111671
            )
         );
      } else {
         c(
            StringDecoder.d(new byte[]{52}, 97)
               + NotifyResolver.q(new byte[]{-71, -92, -94, -95, -67}, -1611516418 ^ -1611516617)
               + JoinerWriter.p(new byte[]{-33}, 765346854 ^ 765346988)
               + StringDecoder.d(new byte[]{-22, -30}, 1107810877 ^ 1107811001),
            () -> {
               if (al != 0) {
                  new Object().hashCode();
               }

               try {
                  String var2x = ConfigBridge.c.d99().g();
                  if (var2x == null) {
                     NoticeQueue.err(
                        TokenExtractor.w(new byte[]{-120, -82, -77, -81, -96, -90, -29}, 1886134702 ^ 1886134654)
                           + NotifyResolver.q(new byte[]{19, 21, 24, 16, 0, 8}, 117),
                        JoinerWriter.p(new byte[]{-97, -54, -49, -59}, -875081136 ^ -875080972)
                           + YieldKeeper.v(
                              new byte[]{62, -108, 96, 7, -74, 60, 5, -75, 88, -19, -65, 84, -5, -97, 35, -128, -125, 59, -37, 122, 66, -33, 121, 30}, 90
                           )
                           + QueryZone.r(new byte[]{47}, 74)
                           + YieldKeeper.v(new byte[]{-9, 91}, 563505329 ^ 563505199)
                     );
                     return;
                  }

                  JsonObject var3 = h();
                  var3.addProperty(JoinerWriter.p(new byte[]{-85, -99, -88, -97}, -1785667375 ^ -1785667566), var2);
                  var3.addProperty(StringDecoder.d(new byte[]{-20, -30, -32, -32, -16, -27, -28, -1, -10}, -718710202 ^ -718710069), var1);
                  var3.addProperty(QueryZone.r(new byte[]{-83, -95, -81, -77}, -829151275 ^ -829151457), var2x);
                  JsonObject var4 = g(
                     YieldKeeper.v(new byte[]{81, -99, 10, -111, 89, -105, 29, -98}, 126)
                        + NotifyResolver.q(new byte[]{-43, -37, -48, -55, -116, -39, -10, -12, -106}, -1612379685 ^ -1612379800),
                     var3
                  );
                  if (!var4.has(YieldKeeper.v(new byte[]{123, 67}, 20)) || !var4.get(QueryZone.r(new byte[]{31, 18}, 115)).getAsBoolean()) {
                     NoticeQueue.err(YieldKeeper.v(new byte[]{-32, 26, 115, -69, -24, 90, -45, -50, 60, 123, -85, 25, 85}, -1283918030 ^ -1283917945), i(var4));
                     return;
                  }

                  boolean var5 = var4.has(JoinerWriter.p(new byte[]{-55, -61, -74, -78, -60, -76, -78}, 1358601431 ^ 1358601339))
                     && var4.get(QueryZone.r(new byte[]{-90, -86, -91, -87, -69, -109, -103}, 1167955478 ^ 1167955654)).getAsBoolean();
                  NoticeQueue.ok(
                     var5
                        ? JoinerWriter.p(new byte[]{-47, -4, -6, -15, -13}, 114)
                           + StringDecoder.d(new byte[]{29, 91, 13, 9, 26}, 122)
                           + TokenExtractor.w(new byte[]{-36, -50}, 1170306155 ^ 1170306269)
                           + StringDecoder.d(new byte[]{123, 123}, 30)
                        : NotifyResolver.q(new byte[]{19, 62, 58, 63, 41, 46, 84}, 80)
                           + JoinerWriter.p(new byte[]{29}, 88)
                           + TokenExtractor.w(new byte[]{93, 64, 68, 75, 77, 77, 67}, 47),
                     var2
                        + (
                           var1
                              ? QueryZone.r(new byte[]{-128, 107, 5, -101, -3}, 599575213 ^ 599575054)
                                 + StringDecoder.d(new byte[]{-56, -56, -54, -36, -49}, -779263675 ^ -779263517)
                                 + TokenExtractor.w(new byte[]{-15, -24, -17}, -1221306146 ^ -1221306295)
                              : ""
                        )
                  );
                  r();
               } catch (Exception var6) {
                  NoticeQueue.err(
                     YieldKeeper.v(new byte[]{51, -68, 94, -9, -97, 0, -22, 86, -9, -107, 14, -83, 74}, 102),
                     QueryZone.r(
                        new byte[]{45, 8, 9, 25, 22, 107, 46, 54, 34, 15, 86, 88, 91, 80, 96, 33, 106, 127, -119, -59, -111, -98, -126, -65, -93, -83}, 109
                     )
                  );
               }
            }
         );
      }
   }

   public static void l(String var0, String var1) {
      if (al != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      c(
         YieldKeeper.v(new byte[]{28, -33, 127, 14}, 88)
            + JoinerWriter.p(new byte[]{-72}, -163237468 ^ -163237616)
            + TokenExtractor.w(new byte[]{52, 57, 61, 63, 57, 51}, 94),
         () -> {
            if (al != 0) {
               Math.abs(Integer.MIN_VALUE);
            }

            try {
               JsonObject var2 = h();
               var2.addProperty(YieldKeeper.v(new byte[]{59, -64}, 82), var0);
               JsonObject var3 = g(
                  TokenExtractor.w(new byte[]{-117, -60, -46, -54, -113, -62, -47, -47, -38, -44, -35, -56, -105, -34, -45, -61}, 1327312495 ^ 1327312577),
                  var2
               );
               if (!var3.has(TokenExtractor.w(new byte[]{-1, -8}, 645930736 ^ 645930601)) || !var3.get(StringDecoder.d(new byte[]{57, 60}, 86)).getAsBoolean()) {
                  NoticeQueue.err(
                     JoinerWriter.p(new byte[]{23}, 45)
                        + YieldKeeper.v(new byte[]{73, 59, 28, -12, -47, -123}, 38)
                        + QueryZone.r(new byte[]{27, 86, 11, 5, 10, 54, 52, 44}, 124),
                     i(var3)
                  );
                  return;
               }

               String var4 = var3.get(QueryZone.r(new byte[]{-88, -92, -86, -74}, 1475104210 ^ 1475104029)).getAsString();
               MinecraftClient.getInstance()
                  .execute(
                     () -> {
                        byte var2x = 0;

                        while (true) {
                           switch (var2x) {
                              case 0:
                              default:
                                 if (al != 0) {
                                    new Object().hashCode();
                                    var2x = 2;
                                    break;
                                 }
                              case 2:
                                 if (ConfigBridge.c.d99().o(var4)) {
                                    af++;
                                    NoticeQueue.ok(JoinerWriter.p(new byte[]{-1, 42, 40, 31, 33, 30, -42, 33, 35, 20, 22, 22, 20}, 68), var1);
                                    var2x = 3;
                                    break;
                                 }
                              case 1:
                                 NoticeQueue.err(
                                    NotifyResolver.q(new byte[]{-25}, -1347264966 ^ -1347264876)
                                       + NotifyResolver.q(new byte[]{97, 120, 106, 106, 118, 114, 11, 93, 32}, 15)
                                       + JoinerWriter.p(new byte[]{-69, -78, -76, -79}, -558826109 ^ -558826192),
                                    QueryZone.r(
                                       new byte[]{
                                          104,
                                          93,
                                          75,
                                          7,
                                          68,
                                          118,
                                          101,
                                          101,
                                          104,
                                          18,
                                          23,
                                          11,
                                          13,
                                          5,
                                          122,
                                          55,
                                          45,
                                          49,
                                          -33,
                                          -105,
                                          -45,
                                          -58,
                                          -41,
                                          -9,
                                          -16,
                                          -83,
                                          -24,
                                          -112,
                                          -116,
                                          -47,
                                          -120,
                                          -122,
                                          -4,
                                          -89,
                                          -85,
                                          -90,
                                          -92
                                       },
                                       63
                                    )
                                 );
                                 var2x = 3;
                                 break;
                              case 3:
                                 return;
                           }
                        }
                     }
                  );
            } catch (Exception var5) {
               NoticeQueue.err(
                  TokenExtractor.w(new byte[]{-33, -9, -18, -16, -13, -13, -4, -26, -93, -26}, -1341647863 ^ -1341647717)
                     + JoinerWriter.p(new byte[]{16, 23, 25, 17, 15}, 81),
                  StringDecoder.d(new byte[]{21, 56, 33, 57, 54, 115, 62, 62, 42, 127, 46, 56, 59, 56, 48, 121, 50, 47, 33, 101, 49, 38, 50, 55, 43, 61}, 86)
               );
            }
         }
      );
   }

   public static void m(String var0, String var1) {
      if (al != 0) {
         System.nanoTime();
      }

      c(
         JoinerWriter.p(new byte[]{-105, -63, -56, -66, -69, -67, -82, -80, -76, -72, -80}, -70043627 ^ -70043464),
         () -> {
            if (al != 0) {
               new Object().hashCode();
            }

            try {
               JsonObject var2 = h();
               var2.addProperty(JoinerWriter.p(new byte[]{-52, -58}, 1224260930 ^ 1224261087), var0);
               JsonObject var3 = g(
                  YieldKeeper.v(new byte[]{123, -55, -116, 57, -117, -101, 35, -50, -110, 33, -5, -125, 107, -1}, 84)
                     + JoinerWriter.p(new byte[]{-20, -6}, 121),
                  var2
               );
               if (!var3.has(StringDecoder.d(new byte[]{66, 71}, 45)) || !var3.get(TokenExtractor.w(new byte[]{122, 125}, 20)).getAsBoolean()) {
                  NoticeQueue.err(
                     QueryZone.r(new byte[]{40, 10, 9, 25}, 111)
                        + TokenExtractor.w(new byte[]{85, 81, 94, 88, 29, 84}, 58)
                        + StringDecoder.d(new byte[]{-24, -31, -25}, 2081239379 ^ 2081239514)
                        + YieldKeeper.v(new byte[]{62, -46}, 91),
                     i(var3)
                  );
                  return;
               }

               String var4 = var3.get(YieldKeeper.v(new byte[]{60, -47, 124, 1}, 88)).getAsString();
               MinecraftClient.getInstance().execute(() -> {
                  if (al != 0) {
                     Thread.currentThread().getName().length();
                  }

                  n(var4, var1);
               });
            } catch (Exception var5) {
               NoticeQueue.err(
                  NotifyResolver.q(new byte[]{-28, -50, -45, -57, -36, -42, -27, -11, -64, -105, -91, -80, 92, 108, 0}, -205863462 ^ -205863558),
                  StringDecoder.d(
                        new byte[]{-23, -60, -35, -59, -54, -113, -62, -62, -42, -125, -46, -60, -57, -60, -52, -123, -50, -45, -35, -103},
                        666081670 ^ 666081580
                     )
                     + NotifyResolver.q(new byte[]{-56, -33}, 370285056 ^ 370285243)
                     + TokenExtractor.w(new byte[]{-28}, -78688056 ^ -78688169)
                     + TokenExtractor.w(new byte[]{89, 75, 91}, 45)
               );
            }
         }
      );
   }

   private static void n(String var0, String var1) {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      LoaderBridge var2 = ConfigBridge.c.d99();
      JsonObject var3 = var2.p(var0);
      if (!LoaderBridge.af(var3)) {
         NoticeQueue.err(
            NotifyResolver.q(new byte[]{93, 123, 102, 124, 104, 100, 84, 5, 55}, 20)
               + StringDecoder.d(new byte[]{-83, -83, -90, -88, -95}, -1247889461 ^ -1247889655),
            NotifyResolver.q(new byte[]{59, 6, 14, 70, 27, 25, 60, 48, 67, 81}, 111)
               + JoinerWriter.p(new byte[]{69, 71, 71, 69, 0, 67, 63, 81, 61, -5, 61, 72, 77, 67, 58, -11, 66, 66, 70, -15, 50, 52}, 28)
               + TokenExtractor.w(new byte[]{77, 30}, 107)
               + YieldKeeper.v(new byte[]{127, 85, 42}, 26)
         );
      } else {
         String var4 = var2.w(LoaderBridge.ah(var1));
         if (var2.ae(var4, var3)) {
            ah = var4;
            ag++;
            NoticeQueue.ok(
               NotifyResolver.q(new byte[]{120, 75, 89, 71, 95}, 43)
                  + TokenExtractor.w(new byte[]{-88}, 831827035 ^ 831827163)
                  + StringDecoder.d(new byte[]{111, 47, 111, 98}, 14)
                  + NotifyResolver.q(new byte[]{55, 63}, 71),
               var4
            );
         } else {
            NoticeQueue.err(
               JoinerWriter.p(new byte[]{27, 40, 60, 42}, 56)
                  + JoinerWriter.p(new byte[]{-94, -25, -31, -24}, 126)
                  + TokenExtractor.w(new byte[]{-94}, -1803899093 ^ -1803898903)
                  + StringDecoder.d(new byte[]{93, 93}, 56),
               var4
            );
         }
      }
   }

   public static void o(String var0, String var1) {
      if (al != 0) {
         System.nanoTime();
      }

      c(
         JoinerWriter.p(new byte[]{-44, -12, -6, -14, 0, -12, -8, -16}, 112),
         () -> {
            if (al != 0) {
               System.nanoTime();
            }

            try {
               JsonObject var2 = h();
               var2.addProperty(YieldKeeper.v(new byte[]{91, 0}, 50), var0);
               JsonObject var3 = g(
                  TokenExtractor.w(new byte[]{78, 1, 31, 7, 66, 15, 4, 4, 15}, 103)
                     + QueryZone.r(new byte[]{-23, -18, -31, -76, -8, -64, -62, -46, -52, -92}, -571842059 ^ -571842186),
                  var2
               );
               if (!var3.has(StringDecoder.d(new byte[]{71, 66}, 40)) || !var3.get(JoinerWriter.p(new byte[]{56, 51}, 55)).getAsBoolean()) {
                  NoticeQueue.err(
                     StringDecoder.d(new byte[]{112, 80, 90, 82, 68, 84, 18, 85}, 52)
                        + JoinerWriter.p(new byte[]{-79}, -15454463 ^ -15454287)
                        + NotifyResolver.q(new byte[]{93}, 52)
                        + YieldKeeper.v(new byte[]{-93, -5, 9}, -568071886 ^ -568071683),
                     i(var3)
                  );
                  return;
               }

               NoticeQueue.ok(JoinerWriter.p(new byte[]{36, 68, 74, 66, 80, 64, 62}, 32), var1);
               r();
            } catch (Exception var4) {
               NoticeQueue.err(
                  StringDecoder.d(new byte[]{37, 5, 15}, 97)
                     + TokenExtractor.w(new byte[]{-85, -69, -87, -19, -76}, -1693946907 ^ -1693947097)
                     + YieldKeeper.v(new byte[]{86, 7, -55}, 55)
                     + YieldKeeper.v(new byte[]{-56, 62}, -945786298 ^ -945786133),
                  StringDecoder.d(new byte[]{50}, 113)
                     + TokenExtractor.w(new byte[]{28, 9, 17, 26, 95, 22, 22, 14, 91, 22, 0, 7, 4}, 116)
                     + NotifyResolver.q(new byte[]{79, 6, 87, 70, 82, 30, 112, 115}, 39)
                     + TokenExtractor.w(new byte[]{110, 105, 123, 107}, 29)
               );
            }
         }
      );
   }

   public static void p(String var0, String var1) {
      if (al != 0) {
         new Object().hashCode();
      }

      String var2 = var1 == null ? "" : var1.trim();
      if (var2.isEmpty()) {
         NoticeQueue.err(
            TokenExtractor.w(new byte[]{8, 38, 41, 32, 106, 57, 45, 56, 59, 38, 62, 40, 54}, 66),
            JoinerWriter.p(new byte[]{-10, 26, 16, 4, -66, 17, 4, 0, -70, 7}, 94)
               + StringDecoder.d(new byte[]{27, 8, 92, 19, 27, 22, 29, 89, 16, 30, 6, 6, 6}, 126)
         );
      } else {
         d(
            TokenExtractor.w(new byte[]{-100, -86, -94, -84, -65, -70, -66, -74}, -1187362414 ^ -1187362480),
            () -> {
               if (al != 0) {
                  new Object().hashCode();
               }

               try {
                  JsonObject var2x = h();
                  var2x.addProperty(QueryZone.r(new byte[]{8, 12}, 98), var0);
                  var2x.addProperty(YieldKeeper.v(new byte[]{-51, 39, -124, -23}, 1764619401 ^ 1764619306), var2);
                  JsonObject var3 = g(
                     YieldKeeper.v(new byte[]{122, -53, -113, 61, -122, -99, 60, -58, -101, 59, -64, -113, 126, -44, -98, 62, -60, -105, 42}, 85), var2x
                  );
                  if (!var3.has(YieldKeeper.v(new byte[]{-57, 59}, -1663320769 ^ -1663320681))
                     || !var3.get(NotifyResolver.q(new byte[]{87, 82}, 56)).getAsBoolean()) {
                     NoticeQueue.err(
                        NotifyResolver.q(new byte[]{17, 39, 41, 43, 62, 63, 71, 20, 98, 123, 75}, 67)
                           + JoinerWriter.p(new byte[]{-99, -101}, 409707424 ^ 409707368),
                        i(var3)
                     );
                     return;
                  }

                  NoticeQueue.ok(StringDecoder.d(new byte[]{101, 83, 91, 85, 94, 87, 85}, 55), var2);
                  r();
               } catch (Exception var4) {
                  NoticeQueue.err(
                     NotifyResolver.q(new byte[]{-9, -63, -49, -51, -40, -39, -95, -14, -124, -99, -83, -71, 81}, -1861990376 ^ -1861990211),
                     QueryZone.r(
                        new byte[]{
                           -12, -47, -48, -64, -49, -78, -9, -17, -5, -42, -113, -127, -126, -119, -71, -8, -77, -90, 80, 28, 72, 71, 91, 102, 122, 116
                        },
                        237157551 ^ 237157403
                     )
                  );
               }
            }
         );
      }
   }

   public static void q(String var0, boolean var1) {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      d(
         JoinerWriter.p(new byte[]{48, 74, 61, 57, 75, 63, 67, 59}, 37),
         () -> {
            if (al != 0) {
               new Object().hashCode();
            }

            try {
               JsonObject var2 = h();
               var2.addProperty(NotifyResolver.q(new byte[]{83, 95}, 58), var0);
               var2.addProperty(
                  StringDecoder.d(new byte[]{9, 7}, 104)
                     + TokenExtractor.w(new byte[]{-24, -24}, 12189014 ^ 12189145)
                     + NotifyResolver.q(new byte[]{28, 9}, 101)
                     + NotifyResolver.q(new byte[]{45, 54, 53}, 66),
                  var1
               );
               JsonObject var3 = g(
                  JoinerWriter.p(new byte[]{117, -90, -76, -84, 113, -92, -81, -83, -92, -90, -93, -82, 105, -102, -90, -90, -92}, 1597079582 ^ 1597079716),
                  var2
               );
               if (!var3.has(TokenExtractor.w(new byte[]{-29, -26}, 1870407910 ^ 1870407778))
                  || !var3.get(NotifyResolver.q(new byte[]{46, 43}, 65)).getAsBoolean()) {
                  NoticeQueue.err(YieldKeeper.v(new byte[]{5, -48, -108, 33, -28, -123, 16, -26, -79, 73, 28, -91, 116}, 80), i(var3));
                  return;
               }

               NoticeQueue.ok(
                  var1
                     ? NotifyResolver.q(new byte[]{-45, -13, -18, -76, -20, -22, -42}, 1432212181 ^ 1432212040)
                        + TokenExtractor.w(new byte[]{-27}, 1379582092 ^ 1379581967)
                        + QueryZone.r(new byte[]{30, 3}, 100)
                        + StringDecoder.d(new byte[]{39, 60, 57}, 72)
                     : YieldKeeper.v(new byte[]{110, 33, 13, -27, -128, -82, -113, 119}, 32)
                        + QueryZone.r(new byte[]{83, 9, 9}, 112)
                        + StringDecoder.d(new byte[]{-40}, 628186707 ^ 628186852)
                        + NotifyResolver.q(new byte[]{43, 51}, 92),
                  QueryZone.r(new byte[]{-127, -92, -66, -65, -73}, 1145640875 ^ 1145640810)
                     + JoinerWriter.p(new byte[]{87}, 16)
                     + TokenExtractor.w(new byte[]{-122}, 1745738182 ^ 1745738090)
                     + YieldKeeper.v(new byte[]{74, 14, -39, -99, 79, 31, -35}, 63)
               );
               r();
            } catch (Exception var4) {
               NoticeQueue.err(
                  NotifyResolver.q(new byte[]{120, 92, 77, 69, 73, 81, 41, 122, 12}, 45)
                     + StringDecoder.d(new byte[]{-94, -90, -84, -84}, -726154460 ^ -726154257),
                  QueryZone.r(new byte[]{-57, -30, -29, -13, -4, -127, -60, -36, -56, -27, -68, -78, -79, -70, -118, -53, -128, -107}, 1773456245 ^ 1773456370)
                     + StringDecoder.d(new byte[]{10, 78, 30}, 111)
                     + QueryZone.r(new byte[]{72, 86}, 46)
                     + JoinerWriter.p(new byte[]{-33, -51, -39}, -1653411858 ^ -1653411975)
               );
            }
         }
      );
   }

   private static void r() {
      if (al != 0) {
         Thread.currentThread().getName().length();
      }

      try {
         JsonObject var0 = g(StringDecoder.d(new byte[]{0, 79, 93, 69, 4, 73, 70, 70, 65, 79, 66, 87, 12, 78, 72, 83, 75}, 47), h());
         if (!var0.has(QueryZone.r(new byte[]{-43, -40}, 1237182628 ^ 1237182493))
            || !var0.get(NotifyResolver.q(new byte[]{-53, -50}, -1668678870 ^ -1668678770)).getAsBoolean()) {
            return;
         }

         LIST = s(var0);
      } catch (Exception var1) {
      }
   }

   private static List<BundleSync.Entry> s(JsonObject var0) {
      if (al != 0) {
         System.nanoTime();
      }

      ArrayList var1 = new ArrayList();

      for (JsonElement var4 : var0.getAsJsonArray(TokenExtractor.w(new byte[]{15, 2, 12, 5, 9, 6, 21}, 106))) {
         JsonObject var5 = var4.getAsJsonObject();
         var1.add(
            new BundleSync.Entry(
               var5.get(TokenExtractor.w(new byte[]{92, 86}, 54)).getAsString(),
               var5.get(YieldKeeper.v(new byte[]{119, 83, 38, 1}, 25)).getAsString(),
               var5.has(StringDecoder.d(new byte[]{121, 108, 110, 115, 115, 111}, 24))
                     && !var5.get(TokenExtractor.w(new byte[]{5, 16, 30, 3, 7, 27}, 98)).isJsonNull()
                  ? var5.get(StringDecoder.d(new byte[]{56, 45, 47, 50, 50, 46}, 89)).getAsString()
                  : QueryZone.r(new byte[]{19, 33, 63, 51, 53, 20, 6}, 69),
               var5.has(JoinerWriter.p(new byte[]{85, 80, 84, 74}, 24)) && var5.get(QueryZone.r(new byte[]{32, 45, 49, 51}, 78)).getAsBoolean(),
               var5.has(JoinerWriter.p(new byte[]{-60, -78, -66, -76, -80, -78, -83, -85}, 919170998 ^ 919170820))
                  && var5.get(QueryZone.r(new byte[]{33, 59, 55, 37, 45, 27, 28, 4}, 84)).getAsBoolean(),
               var5.has(
                        JoinerWriter.p(new byte[]{98, 92, 79, 75, 93}, 19)
                           + StringDecoder.d(new byte[]{-58, -58}, 496701696 ^ 496701859)
                           + QueryZone.r(new byte[]{103, 91}, 37)
                     )
                     && !var5.get(
                           JoinerWriter.p(new byte[]{-77, -83}, -2026593380 ^ -2026593442)
                              + TokenExtractor.w(new byte[]{-35}, -43075919 ^ -43076093)
                              + JoinerWriter.p(new byte[]{24}, 73)
                              + QueryZone.r(new byte[]{50, 42, 48, 28, 46}, 69)
                        )
                        .isJsonNull()
                  ? var5.get(
                        QueryZone.r(new byte[]{-24, -28, -21}, -650844340 ^ -650844206)
                           + YieldKeeper.v(new byte[]{-53, 32, -101, -52, 19, -120}, -1346564711 ^ -1346564813)
                     )
                     .getAsLong()
                  : 0L,
               var5.has(
                        JoinerWriter.p(new byte[]{-84, -74, -67}, 355442081 ^ 355441945)
                           + StringDecoder.d(new byte[]{-93, -96, -96}, 1535837464 ^ 1535837653)
                           + StringDecoder.d(new byte[]{84}, 53)
                           + TokenExtractor.w(new byte[]{-57, -47}, -625239186 ^ -625239097)
                     )
                     && !var5.get(
                           NotifyResolver.q(new byte[]{-87, -93}, -135728638 ^ -135728433)
                              + NotifyResolver.q(new byte[]{12, 20}, 123)
                              + TokenExtractor.w(new byte[]{97, 99, 110, 106, 122}, 13)
                        )
                        .isJsonNull()
                  ? var5.get(
                        JoinerWriter.p(new byte[]{8}, 92)
                           + YieldKeeper.v(new byte[]{21, -125, 0, -124}, 122)
                           + NotifyResolver.q(new byte[]{91, 84}, 52)
                           + YieldKeeper.v(new byte[]{80, 27}, 52)
                     )
                     .getAsInt()
                  : 0
            )
         );
      }

      return var1;
   }

   public static final class Entry {
      public final String id;
      public final String a;
      public final String b;
      public final boolean c;
      public final boolean d;
      public final long e;
      public final int f;
      private static int g = 0;

      Entry(String var1, String var2, String var3, boolean var4, boolean var5, long var6, int var8) {
         this.id = var1;
         this.a = var2;
         this.b = var3;
         this.c = var4;
         this.d = var5;
         this.e = var6;
         this.f = var8;
      }
   }
}
