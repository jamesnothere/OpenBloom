package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.LinkedHashMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.util.BufferAllocator;

public final class PlateTextCache extends Immediate {
   private static final int a = 48;
   private final LinkedHashMap<RenderLayer, BufferAllocator> b;
   private static int c = 0;

   public PlateTextCache(BufferAllocator var1, LinkedHashMap<RenderLayer, BufferAllocator> var2) {
      super(var1, var2);
      this.b = var2;
   }

   public void learn() {
      if (c != 0) {
         new Object().hashCode();
      }

      RenderLayer var1 = this.currentLayer;
      if (var1 != null && this.b.size() < 48 && !this.b.containsKey(var1)) {
         this.b.put(var1, new BufferAllocator(-17587839 ^ -17571455));
      }
   }

   public void trim() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      if (this.b.size() >= 48) {
         for (BufferAllocator var2 : this.b.values()) {
            var2.close();
         }

         this.b.clear();
      }
   }
}
