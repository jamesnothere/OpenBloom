package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SpanEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CalculateMapper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;

public final class ItemCacheData extends BuilderFactory implements InitNotifier, CalculateRange {
   private static final long f99 = 100000000L;
   private static final int g99 = 3;
   private final SpanEntry h;
   private final BlockCalculator i99;
   private final CheckerBridge j;
   private boolean n99;
   private long o99;
   private final Runnable p;
   private static int q = 0;

   public ItemCacheData() {
      super("", "", ParserEngine.Z4);
      this.setName(
         new char[]{'\udc46', '\udc13', '\udc0c', '\udc5b', '\udcd7', '\udcd8', '\udcb6', '\udc96', '\udd71', '\udd50', '\udd26'},
         1257364510,
         new char[0],
         -1068062282
      );
      SpanEntry var10001 = new SpanEntry("", 0.0, 250.0, 50.0, 50.0, 1.0, 50.0, 50.0);
      var10001.n(new char[]{'\uef18', '\uef55', '\uefff', '\uefd5', '\uefb9', '\uef8e'}, -29954212);
      this.h = var10001;
      BlockCalculator var1 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var1.n(new char[]{'\ue4ef', '\ue4e5', '\ue482', '\ue568', '\ue546', '\ue524', '\ue503'}, -856693588);
      this.i99 = var1;
      CheckerBridge var2 = new CheckerBridge("", false);
      var2.n(
         new char[]{
            '\uf649',
            '\uf607',
            '\uf624',
            '\uf60e',
            '\uf6e5',
            '\uf6ce',
            '\uf6e4',
            '\uf6b0',
            '\uf76b',
            '\uf74c',
            '\uf735',
            '\uf733',
            '\uf71f',
            '\uf7e9',
            '\uf7d5',
            '\uf7b4',
            '\uf794'
         },
         14153226
      );
      this.j = var2;
      this.p = this::b;
      this.a(this.h, this.i99, this.j);
   }

   @Override
   public void c() {
      if (q != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.b.a(InitNotifier.class, this);
      this.b.a(CalculateRange.class, this);
      this.n99 = false;
      this.o99 = System.nanoTime();
      FrameClockCache.a(this.p);
      super.c();
   }

   @Override
   public void d() {
      if (q != 0) {
         new Object().hashCode();
      }

      this.b.b(InitNotifier.class, this);
      this.b.b(CalculateRange.class, this);
      FrameClockCache.b(this.p);
      this.n99 = false;
      super.d();
   }

   private boolean a99() {
      if (q != 0) {
         System.nanoTime();
      }

      return a.player != null
         && a.world != null
         && a.interactionManager != null
         && a.currentScreen == null
         && a.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE
         && GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 1) == 1;
   }

   @Override
   public void a() {
      byte var1 = 0;

      label23:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (q != 0) {
                  System.nanoTime();
                  var1 = 3;
                  break;
               }
            case 3:
               if (!this.a99()) {
                  this.n99 = false;
                  return;
               }
            case 1:
               if (!this.n99) {
                  this.n99 = true;
                  if (System.nanoTime() - this.o99 > 0L) {
                     this.o99 = System.nanoTime();
                     var1 = 2;
                     break;
                  }
               }
            case 2:
               break label23;
         }
      }

      this.e();
   }

   private void b() {
      if (q != 0) {
         Thread.currentThread().getName().length();
      }

      if (this.n99 && System.nanoTime() - this.o99 >= 0L) {
         if (this.a99()) {
            this.e();
         } else {
            this.n99 = false;
         }
      }
   }

   public void e() {
      if (q != 0) {
         System.nanoTime();
      }

      if (FrameClockCache.n) {
         long var1 = System.nanoTime();
         if (var1 - this.o99 >= 0L) {
            if (var1 - this.o99 > 100000000L) {
               this.o99 = var1;
            }

            if (FrameClockCache.k(a.player)) {
               this.o99 = var1;
            } else {
               for (int var3 = 0; var3 < 3 && var1 - this.o99 >= 0L; var3++) {
                  if (var3 > 0 && a.player.getMainHandStack().getItem() != Items.EXPERIENCE_BOTTLE) {
                     return;
                  }

                  int var4 = CalculateMapper.a(1, 100);
                  boolean var5 = var4 <= this.i99.g();
                  if (var5) {
                     if (this.j.f()) {
                        BufferNormalizer.d(1);
                     }

                     ActionResult var6 = a.interactionManager.interactItem(a.player, Hand.MAIN_HAND);
                     if (var6.isAccepted()) {
                        a.player.swingHand(Hand.MAIN_HAND);
                     }
                  }

                  long var8 = this.h.b();
                  this.o99 = this.o99 + (var5 ? var8 : Math.min(var8, 50000000L));
               }
            }
         }
      }
   }

   @Override
   public void a(BufferEncoder var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (q != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var2 = 1;
                  break;
               }
            case 1:
               if (a.player != null && a.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
                  var1.b();
                  var2 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }
}
