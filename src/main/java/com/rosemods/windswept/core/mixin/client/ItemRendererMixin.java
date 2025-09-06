package com.rosemods.windswept.core.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.blaze3d.vertex.PoseStack;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Shadow @Final private ItemModelShaper itemModelShaper;
    @Unique private static final ModelResourceLocation ANTLER_HELMET_IN_HEAD = new ModelResourceLocation("windswept", "antler_helmet_in_hand", "inventory");

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/resources/model/BakedModel;getTransforms()Lnet/minecraft/client/renderer/block/model/ItemTransforms;",
            ordinal = 0
        )
    )
    private void useAntlerHelmetInHand(ItemStack stack, ItemDisplayContext $$1, boolean $$2, PoseStack $$3, MultiBufferSource $$4, int $$5, int $$6, BakedModel $$7, CallbackInfo ci, @Local(ordinal = 1) LocalBooleanRef bl, @Local(ordinal = 0, argsOnly = true) LocalRef<BakedModel> model) {
        if (bl.get() && stack.is(WindsweptItems.ANTLER_HELMET)) {
            model.set(this.itemModelShaper.getModelManager().getModel(ANTLER_HELMET_IN_HEAD));
        }
    }

    @Inject(
        method = "getModel",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/resources/model/BakedModel;getOverrides()Lnet/minecraft/client/renderer/block/model/ItemOverrides;",
            ordinal = 0
        )
    )
    private void useAntlerHelmetInHand(ItemStack stack, Level level, LivingEntity entity, int i, CallbackInfoReturnable<BakedModel> cir, @Local(ordinal = 0) LocalRef<BakedModel> model) {
        if (stack.is(WindsweptItems.ANTLER_HELMET)) {
            model.set(this.itemModelShaper.getModelManager().getModel(ANTLER_HELMET_IN_HEAD));
        }
    }
}
