package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MinecraftClient.class)
public interface PacketBinder {
   @Accessor("field_1729")
   Mouse Z7();

   @Accessor("field_1752")
   void sIUC(int var1);

   @Invoker("method_1583")
   void dIU();
}
