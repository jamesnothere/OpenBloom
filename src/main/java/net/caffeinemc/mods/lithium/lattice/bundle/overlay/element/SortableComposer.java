package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.Mouse;
import net.minecraft.client.input.MouseInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Mouse.class)
public interface SortableComposer {
   @Invoker("method_1601")
   void iOMB(long var1, MouseInput var3, int var4);

   @Accessor("field_1789")
   double g3Dx();

   @Accessor("field_1787")
   double g3Dy();

   @Accessor("field_1795")
   void g3SetX(double var1);

   @Accessor("field_1794")
   void g3SetY(double var1);
}
