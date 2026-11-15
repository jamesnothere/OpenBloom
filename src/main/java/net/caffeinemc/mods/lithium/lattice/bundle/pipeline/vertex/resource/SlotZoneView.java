package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public final class SlotZoneView extends InventoryScreen {
   private static int a = 0;

   public SlotZoneView(PlayerEntity var1) {
      super(var1);
   }

   protected void onMouseClick(Slot slot, int slotId, int button, SlotActionType actionType) {
   }

   public boolean mouseClicked(Click click, boolean doubled) {
      if (a != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      return false;
   }
}
