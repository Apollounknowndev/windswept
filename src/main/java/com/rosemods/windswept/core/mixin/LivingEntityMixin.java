package com.rosemods.windswept.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.rosemods.windswept.common.enchantment.curse.SlippingCurseEnchantment;
import com.rosemods.windswept.common.item.AntlerHelmetItem;
import com.rosemods.windswept.common.item.SnowBootsItem;
import com.rosemods.windswept.core.other.WindsweptEntityData;
import com.rosemods.windswept.core.other.events.WindsweptEntityEvents;
import com.rosemods.windswept.core.other.tags.WindsweptEntityTypeTags;
import com.rosemods.windswept.core.registry.WindsweptEffects;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    private LivingEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(
        method = "defineSynchedData",
        at = @At("TAIL")
    )
    private void addCloakedData(CallbackInfo ci) {
        this.entityData.define(WindsweptEntityData.CLOAKED, false);
        this.entityData.define(WindsweptEntityData.IS_FREEZE_CONVERTING, false);
        this.entityData.define(WindsweptEntityData.FREEZE_CONVERT_TIME, 0);
        this.entityData.define(WindsweptEntityData.POWDER_SNOW_TIME, 0);

    }

    @WrapOperation(
        method = "travel",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;getFriction()F"
        )
    )
    private float applySlipping(Block block, Operation<Float> operation) {
        return SlippingCurseEnchantment.getFriction(this, operation.call(block));
    }

    @ModifyReturnValue(method = "hurt", at = @At("RETURN"))
    private boolean applyThorns(boolean bl, DamageSource source, float amount) {
        if (bl) {
            WindsweptEntityEvents.onEntityHurt(((LivingEntity) (Object) this), source);
            return true;
        }
        return false;
    }

    @Override
    public void setTicksFrozen(int ticks) {
        boolean hasFrostResist = ((LivingEntity) (Object) this).hasEffect(WindsweptEffects.FROST_RESISTANCE);

        if (!hasFrostResist && !this.getType().is(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES))
            super.setTicksFrozen(ticks);
        else if (hasFrostResist)
            super.setTicksFrozen(0);
    }

    @Override
    public int getTicksFrozen() {
        if (((LivingEntity) (Object) this).hasEffect(WindsweptEffects.FROST_RESISTANCE) || this.getType().is(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES))
            return 0;

        return super.getTicksFrozen();
    }

    @Override
    public boolean isFullyFrozen() {
        if (this.isInPowderSnow && this.getType().is(WindsweptEntityTypeTags.CONVERT_TO_CHILLED))
            return false;

        return super.isFullyFrozen();
    }

    @Inject(method = "canFreeze", at = @At("HEAD"), cancellable = true)
    private void canFreeze(CallbackInfoReturnable<Boolean> info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        info.setReturnValue(!entity.getType().is(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES) && !entity.isSpectator() && !entity.hasEffect(WindsweptEffects.FROST_RESISTANCE));
    }

    @Inject(method = "onChangedBlock", at = @At("TAIL"))
    private void onChangedBlock(BlockPos pos, CallbackInfo info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (SnowBootsItem.canApplySnowSpeed(entity))
            SnowBootsItem.tryAddSnowSpeed(entity);
        else if (!entity.level().getBlockState(entity.getOnPos()).isAir() || entity.isFallFlying() || !entity.getItemBySlot(EquipmentSlot.FEET).is(WindsweptItems.SNOW_BOOTS))
            SnowBootsItem.removeSnowSpeed(entity);

        if (!entity.isSprinting() || !entity.getItemBySlot(EquipmentSlot.HEAD).is(WindsweptItems.ANTLER_HELMET))
            AntlerHelmetItem.removeSprintDamage(entity);

        AntlerHelmetItem.tryAddSprintDamage(entity);
        SlippingCurseEnchantment.attemptDamageBoots(entity);
    }

    @Inject(method = "checkFallDamage", at = @At("HEAD"))
    private void checkFallDamage(double d, boolean p_20991_, BlockState state, BlockPos pos, CallbackInfo info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.level().isClientSide && p_20991_ && entity.fallDistance > 0f) {
            SnowBootsItem.removeSnowSpeed(entity);
            if (SnowBootsItem.canApplySnowSpeed(entity))
                SnowBootsItem.tryAddSnowSpeed(entity);

            SlippingCurseEnchantment.attemptDamageBoots(entity);
        }
    }

}
