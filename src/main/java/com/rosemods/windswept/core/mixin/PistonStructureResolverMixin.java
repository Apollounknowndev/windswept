package com.rosemods.windswept.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonStructureResolver.class)
public class PistonStructureResolverMixin {

    @ModifyReturnValue(method = "isSticky", at = @At("RETURN"))
    private static boolean isSticky(boolean original, BlockState state) {
        return original || state.is(WindsweptBlocks.PINECONE_JAM_BLOCK);
    }

    @Inject(method = "canStickToEachOther", at = @At("HEAD"))
    private static void preventStickyness(BlockState state1, BlockState state2, CallbackInfoReturnable<Boolean> cir) {
        if (state1.is(WindsweptBlocks.PINECONE_JAM_BLOCK) && (state2.is(Blocks.HONEY_BLOCK) || state2.is(Blocks.SLIME_BLOCK))) {
            cir.setReturnValue(false);
        }
        if (state2.is(WindsweptBlocks.PINECONE_JAM_BLOCK) && (state1.is(Blocks.HONEY_BLOCK) || state1.is(Blocks.SLIME_BLOCK))) {
            cir.setReturnValue(false);
        }
    }
}
