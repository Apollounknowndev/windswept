package com.rosemods.windswept.core.other;

import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.other.util.SimpleArmorMaterial;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;

public final class WindsweptTiers {
    public static final ArmorMaterial SNOW_BOOTS = new SimpleArmorMaterial(Windswept.id("snow_boots"), 12, protection(ArmorItem.Type.BOOTS), 17, () -> SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0f, () -> Ingredient.of(Items.LEATHER));
    public static final ArmorMaterial LAVENDER_CROWN = new SimpleArmorMaterial(Windswept.id("lavender_crown"), 2, protection(null), 10, () -> SoundEvents.AZALEA_BREAK, 0f, 0f, () -> Ingredient.of(WindsweptBlocks.LAVENDER));
    public static final ArmorMaterial ANTLER_HELMET = new SimpleArmorMaterial(Windswept.id("antler_helmet"), 8, protection(ArmorItem.Type.HELMET), 17, () -> SoundEvents.ARMOR_EQUIP_GENERIC, 0f, .1f, () -> Ingredient.of(Items.BONE));
    public static final ArmorMaterial FEATHER_CLOAK = new SimpleArmorMaterial(Windswept.id("feather_cloak"), 8, protection(ArmorItem.Type.CHESTPLATE), 17, () -> SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(WindsweptItems.ELDER_FEATHER));
    private static EnumMap<ArmorItem.Type, Integer> protection(@Nullable ArmorItem.Type type) {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, type != null && type.equals(ArmorItem.Type.BOOTS) ? 1 : 0);
            map.put(ArmorItem.Type.LEGGINGS, type != null && type.equals(ArmorItem.Type.LEGGINGS) ? 1 : 0);
            map.put(ArmorItem.Type.CHESTPLATE, type != null && type.equals(ArmorItem.Type.CHESTPLATE) ? 1 : 0);
            map.put(ArmorItem.Type.HELMET, type != null && type.equals(ArmorItem.Type.HELMET) ? 1 : 0);
        });
    }
}
