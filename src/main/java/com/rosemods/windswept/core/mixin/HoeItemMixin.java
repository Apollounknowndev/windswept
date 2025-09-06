package com.rosemods.windswept.core.mixin;

import com.mojang.datafixers.util.Pair;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.rosemods.windswept.core.registry.WindsweptBlocks.GELISOL;
import static com.rosemods.windswept.core.registry.WindsweptBlocks.GELISOL_PATH;

@Mixin(HoeItem.class)
public class HoeItemMixin {
    @Shadow @Final @Mutable
    protected static Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> TILLABLES;

    static {
        TILLABLES = new HashMap<>(TILLABLES);
        TILLABLES.put(WindsweptBlocks.GINGER_SOIL, Pair.of((context) -> true, HoeItem.changeIntoStateAndDropItem(Blocks.DIRT.defaultBlockState(), WindsweptItems.GINGER_ROOT)));
    }
}
