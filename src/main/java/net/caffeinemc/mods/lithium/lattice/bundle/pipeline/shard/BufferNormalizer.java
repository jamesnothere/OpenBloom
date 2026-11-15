package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PacketBinder;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.SortableComposer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.MouseInput;

public class BufferNormalizer {
   private static final MinecraftClient h = MinecraftClient.getInstance();
   public static HashMap<Integer, Boolean> b = new HashMap<>();
   public static ExecutorService c = Executors.newCachedThreadPool();
   private static int i = 0;

   public static SortableComposer a() {
      if (i != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return (SortableComposer)((PacketBinder)h).Z7();
   }

   public static boolean a(int var0) {
      if (i != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      int var1 = InitExecutor.c();
      Boolean var2 = b.get(var0);
      int var3 = var1;
      Boolean var4 = var2;
      if (var3 == 0) {
         if (var2 == null) {
            return false;
         }

         var4 = var2;
      }

      return var4;
   }

   public static void b(int var0) {
      if (i != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      b.put(var0, true);
      a().iOMB(h.getWindow().getHandle(), new MouseInput(var0, 0), 1);
   }

   public static void c(int var0) {
      if (i != 0) {
         Thread.currentThread().getName().length();
      }

      a().iOMB(h.getWindow().getHandle(), new MouseInput(var0, 0), 0);
   }

   public static void a(int var0, int var1) {
      if (i != 0) {
         System.nanoTime();
      }

      if (h.isOnThread()) {
         try {
            b(var0);
         } catch (Throwable var3) {
         }
      } else {
         h.execute(() -> {
            if (i != 0) {
               Thread.currentThread().getName().length();
            }

            b(var0);
         });
      }

      c.submit(() -> {
         if (i != 0) {
            Math.abs(Integer.MIN_VALUE);
         }

         b(var0, var1);
      });
   }

   public static void d(int var0) {
      byte var1 = 0;

      label16:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (i != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (a(var0)) {
                  return;
               }
            case 2:
               break label16;
         }
      }

      a(var0, 35);
   }

   private static void b(int var0, int var1) {
      if (i != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      try {
         Thread.sleep(var1);
      } catch (InterruptedException var3) {
         return;
      }

      h.execute(() -> {
         if (i != 0) {
            new Object().hashCode();
         }

         c(var0);
      });
   }
}
