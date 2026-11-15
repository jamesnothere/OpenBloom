package com.blamejared.clumps.api.events;

import net.minecraft.entity.player.PlayerEntity;

public interface IRepairEvent {
   void setValue(int var1);

   int getValue();

   PlayerEntity getPlayer();
}
