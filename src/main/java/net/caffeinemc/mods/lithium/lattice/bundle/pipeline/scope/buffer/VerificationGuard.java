package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.lang.management.ManagementFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.TokenExtractor;

public final class VerificationGuard {
   private static final String[] f = new String[]{
      TokenExtractor.w(new byte[]{1, 25, 30, 31, 25}, 116),
      NotifyResolver.q(new byte[]{3, 25}, 97)
         + StringDecoder.d(new byte[]{24, 8, 13}, 108)
         + JoinerWriter.p(new byte[]{-39, -51, -51, -35, -49, -54, -37, -56, -44}, 150),
      TokenExtractor.w(new byte[]{19, 7, 11, 25}, 118) + QueryZone.r(new byte[]{-13, -10, -26, -18, -95, -61, -41, -62, -33, -76, -88}, 147),
      JoinerWriter.p(new byte[]{-42, -20, -26, -42, -35, -48, -36}, 140),
      NotifyResolver.q(new byte[]{-45, -39, -53, -47, -38, -45, -12, -5, -115, -58}, 185)
         + TokenExtractor.w(new byte[]{116, 113}, 20)
         + QueryZone.r(new byte[]{-12}, 146)
         + StringDecoder.d(new byte[]{19, 8}, 125),
      NotifyResolver.q(new byte[]{17, 29, 17, 25, 6, 19}, 121),
      TokenExtractor.w(new byte[]{18, 19, 91, 18, 1, 26}, 127),
      StringDecoder.d(new byte[]{-86, -82, -71}, 201),
      QueryZone.r(new byte[]{88, 83, 85, 80, 77, 98, 104}, 43),
      TokenExtractor.w(new byte[]{28}, 125) + YieldKeeper.v(new byte[]{-84, -32, 53, 66, -127, -39}, 201) + YieldKeeper.v(new byte[]{-24, 91, -81}, 159),
      TokenExtractor.w(new byte[]{75, 83, 85, 93, 95, 90, 88, 67, 80, 64}, 62),
      QueryZone.r(new byte[]{-21, -5, -13, -16, -3, -47, -49, -62}, 131),
      YieldKeeper.v(new byte[]{-96, -11, 58, 80}, 202)
   };
   private static int g = 0;

   private VerificationGuard() {
   }

   public static boolean a() {
      return true;
   }

   private static boolean d() {
      if (g != 0) {
         new Object().hashCode();
      }

      try {
         for (String var2 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            String var3 = var2.toLowerCase();

            for (String var7 : f) {
               if (var3.contains(var7)) {
                  return false;
               }
            }
         }
      } catch (Exception var8) {
      }

      return true;
   }

   private static boolean e() {
      if (g != 0) {
         new Object().hashCode();
      }

      try {
         for (String var2 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            String var3 = var2.toLowerCase();
            if (var3.contains(TokenExtractor.w(new byte[]{23, 22, 4, 0}, 122))
               || var3.contains(QueryZone.r(new byte[]{108, 99, 126, 116, 102, 84, 85, 21}, 28))
               || var3.contains(
                  TokenExtractor.w(new byte[]{-1, -8, -24, -26, -4, -2}, 1074450810 ^ 1074450937)
                     + TokenExtractor.w(new byte[]{-78, -84, -85, -3, -91, -74, -100, -73, -86, -91, -84, -83, -67}, 1325781619 ^ 1325781667)
               )) {
               return false;
            }
         }
      } catch (Exception var5) {
      }

      try {
         String var6 = System.getProperty(
            NotifyResolver.q(new byte[]{87}, 52)
               + StringDecoder.d(new byte[]{17, 18, 82}, 126)
               + NotifyResolver.q(new byte[]{-24, -17, -15, -68, -26, -29, -47, -53, -68, -81, -110, -121, 101, 70, 113, 16}, 1992607584 ^ 1992607739)
               + YieldKeeper.v(new byte[]{79, 60, 20, -19, -57, -93, -102, 117}, 34)
         );
      } catch (Exception var4) {
      }

      return true;
   }
}
