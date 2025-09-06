package com.rosemods.windswept.core.mixin.client;

import com.rosemods.windswept.core.duck.LivingEntityDuck;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin<T extends LivingEntity> {
    @Inject(method = "isShaking", at = @At("HEAD"), cancellable = true)
    public void isShaking(T entity, CallbackInfoReturnable<Boolean> info) {
        if (entity instanceof Mob && ((LivingEntityDuck)entity).isFreezeConverting())
            info.setReturnValue(true);
    }

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private void applyCloaking(T entity, boolean $$1, boolean $$2, boolean $$3, CallbackInfoReturnable<RenderType> cir) {
        if (((LivingEntityDuck)entity).isCloaked()) {
            cir.setReturnValue(null);
        }
    }
}