package com.rosemods.windswept.common.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.material.Fluid;

public class EmptyWoodenBucketItem extends WoodenBucketItem implements Equipable {
    public EmptyWoodenBucketItem(Fluid fluid, Properties builder) {
        super(fluid, builder);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
