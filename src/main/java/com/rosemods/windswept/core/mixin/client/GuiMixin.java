package com.rosemods.windswept.core.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Unique
    private static final ResourceLocation PINECONE_BLUR = Windswept.id("textures/misc/pineconeblur.png");

    @Shadow public abstract void renderTextureOverlay(GuiGraphics $$0, ResourceLocation $$1, float $$2);

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
        )
    )
    private void getTextureLocation(GuiGraphics guiGraphics, float f, CallbackInfo ci, @Local(ordinal = 0) ItemStack stack) {
        if (stack.is(WindsweptItems.CARVED_PINECONE_BLOCK.asItem())) {
            this.renderTextureOverlay(guiGraphics, PINECONE_BLUR, 1.0F);
        }
    }
}
