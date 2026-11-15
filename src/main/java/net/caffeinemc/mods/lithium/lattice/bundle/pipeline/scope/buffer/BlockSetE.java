package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.LinkedHashSet;
import java.util.Set;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.NotifyResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.JoinerWriter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.YieldKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.QueryZone;

public class BlockSetE extends TextEntry {
   public static final BlockSetE.Opt[] OPTIONS = new BlockSetE.Opt[]{
      new BlockSetE.Opt(StringDecoder.d(new byte[]{103, 75, 89, 66, 72, 68, 79, 65}, 40), YieldKeeper.v(new byte[]{-35, 6, 101, -95, 30, 69, -65, -2}, 178)),
      new BlockSetE.Opt(
         NotifyResolver.q(new byte[]{20}, 70)
            + StringDecoder.d(new byte[]{-75, -94, -94, -78, -93, -69}, 208)
            + NotifyResolver.q(new byte[]{-79, -47}, 145)
            + NotifyResolver.q(new byte[]{69, 73, 71, 77, 73}, 43),
         QueryZone.r(new byte[]{72, 86, 91, 81, 71, 104, 122, 82, 99, 21, 19, 1, 1, 21}, 57)
      ),
      new BlockSetE.Opt(
         StringDecoder.d(new byte[]{-52, -26, -26, -1, -4, -6, -30, -30, -26}, 139),
         StringDecoder.d(new byte[]{-42, -36, -36, -59, -58, -64}, 177) + JoinerWriter.p(new byte[]{-11}, 122) + StringDecoder.d(new byte[]{-29, -23}, 141)
      )
   };
   private static int c = 0;

   public BlockSetE(String var1, String var2, int var3) {
      super(var1, var2, var3);
   }

   public Set<String> ids() {
      if (c != 0) {
         System.nanoTime();
      }

      LinkedHashSet var1 = new LinkedHashSet();
      String var2 = this.f();
      if (var2 == null) {
         return var1;
      }

      for (String var6 : var2.split(NotifyResolver.q(new byte[]{-122}, 1536281037 ^ 1536280935))) {
         String var7 = var6.trim().toLowerCase();
         if (var7.startsWith(
            QueryZone.r(new byte[]{-10, -5, -25, -27, -28, -52, -44, -54}, -1847150322 ^ -1847150186)
               + NotifyResolver.q(new byte[]{-23, -90}, -856528654 ^ -856528785)
         )) {
            var7 = var7.substring(10);
         }

         if (!var7.isEmpty()) {
            var1.add(var7);
         }
      }

      return var1;
   }

   public void a(String var1) {
      if (c != 0) {
         new Object().hashCode();
      }

      Set var2 = this.ids();
      if (!var2.remove(var1)) {
         var2.add(var1);
      }

      this.b(String.join(QueryZone.r(new byte[]{34}, 13), var2));
   }

   public int b() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.ids().size();
   }

   public static final class Opt {
      public final String a;
      public final String id;
      private static int b = 0;

      public Opt(String var1, String var2) {
         this.a = var1;
         this.id = var2;
      }
   }
}
