package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.Arrays;
import java.util.List;

public class SlotEntry extends InitAdapter {
   private String a99;
   private final List<String> b99;
   private static int c = 0;

   public SlotEntry(String var1, String var2, String... var3) {
      super(var1);
      this.b99 = Arrays.asList(var3);
      this.a99 = var2;
   }

   public String f() {
      if (c != 0) {
         Thread.currentThread().getName().length();
      }

      return this.a99;
   }

   @Override
   public Object c() {
      if (c != 0) {
         System.nanoTime();
      }

      return this.f();
   }

   @Override
   public void a(Object var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (c != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 instanceof String) {
                  this.a99 = (String)var1;
                  var2 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public List<String> g() {
      if (c != 0) {
         new Object().hashCode();
      }

      return this.b99;
   }

   public void h() {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      byte var4 = 0;

      while (true) {
         switch (var4) {
            case 0:
            default:
               if (c != 0) {
                  Thread.currentThread().getName().length();
                  var4 = 1;
                  break;
               }
            case 1:
               var1 = BlockCalculator.n();
               var2 = this.b99.indexOf(this.a99);
               var3 = var1;
               var2 = (var2 + 1) % this.b99.size();
               this.a99 = this.b99.get(var2);
               if (InitAdapter.e() == 0) {
                  BlockCalculator.a(++var3);
                  var4 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public boolean b(String var1) {
      if (c != 0) {
         System.nanoTime();
      }

      return this.a99.equals(var1);
   }
}
