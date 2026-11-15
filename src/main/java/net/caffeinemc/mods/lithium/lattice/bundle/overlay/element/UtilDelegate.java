package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayerInteractionManager.class)
public interface UtilDelegate {
   @Invoker("method_2911")
   void iSSS();
}
