package com.rosemods.windswept.core.mixin;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

import static com.rosemods.windswept.core.registry.WindsweptBlocks.*;

@Mixin(AxeItem.class)
public class AxeItemMixin {
    @Shadow @Final @Mutable
    protected static Map<Block, Block> STRIPPABLES;

    static {
        STRIPPABLES = new HashMap<>(STRIPPABLES);
        STRIPPABLES.put(HOLLY_LOG, STRIPPED_HOLLY_LOG);
        STRIPPABLES.put(HOLLY_WOOD, STRIPPED_HOLLY_WOOD);
        STRIPPABLES.put(CHESTNUT_LOG, STRIPPED_CHESTNUT_LOG);
        STRIPPABLES.put(CHESTNUT_WOOD, STRIPPED_CHESTNUT_WOOD);
        STRIPPABLES.put(PINE_LOG, WEATHERED_PINE_LOG);
        STRIPPABLES.put(PINE_WOOD, WEATHERED_PINE_WOOD);
        STRIPPABLES.put(WEATHERED_PINE_LOG, STRIPPED_PINE_LOG);
        STRIPPABLES.put(WEATHERED_PINE_WOOD, STRIPPED_PINE_WOOD);
    }
}
