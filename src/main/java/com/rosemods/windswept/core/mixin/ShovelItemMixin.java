package com.rosemods.windswept.core.mixin;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

import static com.rosemods.windswept.core.registry.WindsweptBlocks.*;

@Mixin(ShovelItem.class)
public class ShovelItemMixin {
    @Shadow @Final @Mutable
    protected static Map<Block, BlockState> FLATTENABLES;

    static {
        FLATTENABLES = new HashMap<>(FLATTENABLES);
        FLATTENABLES.put(GELISOL, GELISOL_PATH.defaultBlockState());
    }
}
