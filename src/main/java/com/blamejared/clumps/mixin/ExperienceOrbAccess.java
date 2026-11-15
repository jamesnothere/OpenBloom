package com.blamejared.clumps.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ExperienceOrbEntity.class)
public interface ExperienceOrbAccess {
   @Accessor("field_6164")
   int clumps$getAge();

   @Accessor("field_6164")
   void clumps$setAge(int var1);

   @Accessor("field_27009")
   void clumps$setCount(int var1);
}
