package com.rosemods.windswept.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PistonMovingBlockEntity.class)
public class PistonMovingBlockEntityMixin {
    @Shadow private BlockState movedState;

    @ModifyReturnValue(method = "isStickyForEntities", at = @At("RETURN"))
    private boolean isSticky(boolean original) {
        return original || this.movedState.is(WindsweptBlocks.PINECONE_JAM_BLOCK);
    }
}
