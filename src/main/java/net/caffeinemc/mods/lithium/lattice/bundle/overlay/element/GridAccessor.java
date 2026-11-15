package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface GridAccessor {
   @Accessor("field_2776")
   int getX();

   @Accessor("field_2800")
   int getY();
}
