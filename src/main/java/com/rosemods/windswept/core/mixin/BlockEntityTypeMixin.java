package com.rosemods.windswept.core.mixin;

import com.rosemods.windswept.core.duck.BlockEntityTypeDuck;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin implements BlockEntityTypeDuck {
    @Shadow @Final @Mutable
    private Set<Block> validBlocks;

    @Override
    public void addBlocks(Block... blocks) {
        Set<Block> supportedBlocks = new HashSet<>(this.validBlocks);
        supportedBlocks.addAll(Arrays.stream(blocks).toList());
        this.validBlocks = supportedBlocks;
    }
}
