package com.rosemods.windswept.core.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SolidBucketItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SolidBucketItem.class)
public class SolidBucketItemMixin extends Item {
    protected SolidBucketItemMixin(Properties properties) {
        super(properties.craftRemainder(Items.BUCKET));
    }
}
