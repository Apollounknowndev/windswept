package com.rosemods.windswept.core.mixin;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockSetType.class)
public interface BlockSetTypeAccessor {
    @Invoker("register")
    static BlockSetType registerBlockSet(BlockSetType set) {
        throw new AssertionError("Implemented via mixin");
    }
}
