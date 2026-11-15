package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface BindingAccessor {
   @Accessor("field_2787")
   Slot Z8();
}
