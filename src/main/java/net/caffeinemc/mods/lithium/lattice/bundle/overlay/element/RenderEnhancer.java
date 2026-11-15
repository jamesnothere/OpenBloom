package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInventory.class)
public interface RenderEnhancer {
   @Accessor("field_7545")
   int gSS();

   @Accessor("field_7545")
   void sSS(int var1);

   @Accessor("field_7547")
   DefaultedList<ItemStack> Z5();
}
