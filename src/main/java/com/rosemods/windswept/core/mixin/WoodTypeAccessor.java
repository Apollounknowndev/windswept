package com.rosemods.windswept.core.mixin;

import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccessor {
    @Invoker("register")
    static WoodType registerWoodSet(WoodType type) {
        throw new AssertionError("Implemented via mixin");
    }
}
