package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public final class InitCacheAdapter extends BuilderFactory implements InitNotifier {
   private final ItemDescriptor c99;
   private final TimingEntry d99;
   private final CheckerBridge e;
   private final TimingEntry f99;
   private boolean g99;
   private boolean h;
   private int i99;
   private long j;
   private static final long q = 25000000L;
   private static int s = 0;

   public InitCacheAdapter() {
      super("", "", ParserEngine.Z4);
      this.setName(new char[]{'㘥', '㚣', '㛉', '㚲', '㚺', '㝬', '㝉', '㜵', '㜊'}, -1124977042, new char[0], -1623123041);
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(new char[]{'ﭤ', 'ﭪ', 'ﬀ', 'ﯶ', '\ufbc8', '﮶', '﮾', 'ﮊ', 'ﱸ', 'ﰜ', 'ﰐ', 'ﰟ', 'ﳠ'}, 1028979493);
      this.c99 = var10001;
      TimingEntry var1 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var1.n(new char[]{'㞦', '㠯', '㡅', '㡓', '㠿', '㠄'}, 1717254114);
      this.d99 = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'뒕', '듋', '땳', '땊', '딶', '딂', '뗨', '떿', '뗼', '떼', '떟', '뙰'}, 452179142);
      this.e = var2;
      TimingEntry var3 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var3.n(new char[]{'싯', '싵', '슍', '썰', '썌', '쌴', '쌞', '쎵', '쏰', '쎶', '쎞', '쑰', '쑉'}, 1274266300);
      this.f99 = var3;
      this.i99 = -1;
      this.a(this.c99, this.d99, this.e, this.f99);
   }

   @Override
   public void c() {
      if (s != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.b.a(InitNotifier.class, this);
      this.b();
      super.c();
   }

   @Override
   public void d() {
      if (s != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {
      if (s != 0) {
         System.nanoTime();
      }

      if (a.player != null && a.currentScreen == null) {
         if (SlotInspector.b(this.c99.g()) && !this.g99) {
            this.g99 = true;
            this.j = FrameClockCache.g(this.d99.p());
         }

         if (this.g99) {
            this.a(a.player);
         }
      }
   }

   private void a(ClientPlayerEntity var1) {
      if (s != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      if (this.i99 == -1) {
         this.i99 = InitExecutor.a(var1.getInventory());
      }

      if (a.interactionManager != null) {
         if (!FrameClockCache.i(var1)) {
            FrameClockCache.j(var1);
         } else {
            boolean var2 = System.nanoTime() - (this.j - 25000000L) >= 0L;
            if (!this.h) {
               ViewLocator.a(Items.ENDER_PEARL);
               if (var2) {
                  ActionResult var3 = a.interactionManager.interactItem(var1, Hand.MAIN_HAND);
                  if (var3.isAccepted()) {
                     var1.swingHand(Hand.MAIN_HAND);
                  }

                  this.h = true;
                  if (!this.e.f()) {
                     this.b();
                  } else {
                     this.j = FrameClockCache.g(this.f99.p());
                  }
               }
            } else {
               if (var2) {
                  ViewLocator.a(this.i99);
                  this.b();
               }
            }
         }
      }
   }

   private void b() {
      if (s != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      this.i99 = -1;
      this.g99 = false;
      this.h = false;
   }
}
