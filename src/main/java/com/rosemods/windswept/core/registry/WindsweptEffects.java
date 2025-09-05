package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

public class WindsweptEffects {
    // Effects //
    public static final MobEffect THORNS = register("thorns", MobEffectCategory.BENEFICIAL, 0x295230);
    public static final MobEffect FROST_RESISTANCE = register("frost_resistance", MobEffectCategory.BENEFICIAL, 0x618cff);

    // Potions //
    public static final Potion THORNS_POTION = register("thorns", THORNS, 3600, 0);
    public static final Potion LONG_THORNS_POTION = register("long_thorns", THORNS, 9600, 0);
    public static final Potion STRONG_THORNS_POTION = register("strong_thorns", THORNS, 1800, 1);
    public static final Potion FROST_RESISTANCE_POTION = register("frost_resistance", FROST_RESISTANCE, 3600, 0);
    public static final Potion LONG_FROST_RESISTANCE_POTION = register("long_frost_resistance", FROST_RESISTANCE, 9600, 0);

    private static MobEffect register(String name, MobEffectCategory category, int color) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, Windswept.id(name), new WindsweptEffect(category, color));
    }

    private static Potion register(String name, MobEffect effect, int duration, int amplifier) {
        return Registry.register(BuiltInRegistries.POTION, Windswept.id(name), new Potion(new MobEffectInstance(effect, duration, amplifier)));
    }

    public static void init() {
        PotionBrewing.addMix(Potions.AWKWARD, WindsweptBlocks.NIGHTSHADE.asItem(), Potions.NIGHT_VISION);

        PotionBrewing.addMix(Potions.AWKWARD, WindsweptItems.HOLLY_BERRIES, THORNS_POTION);
        PotionBrewing.addMix(THORNS_POTION, Items.REDSTONE, LONG_THORNS_POTION);
        PotionBrewing.addMix(THORNS_POTION, Items.GLOWSTONE_DUST, STRONG_THORNS_POTION);

        PotionBrewing.addMix(Potions.AWKWARD, WindsweptItems.FROZEN_BRANCH, FROST_RESISTANCE_POTION);
        PotionBrewing.addMix(FROST_RESISTANCE_POTION, Items.REDSTONE, LONG_FROST_RESISTANCE_POTION);
    }

    private static class WindsweptEffect extends MobEffect {
        public WindsweptEffect(MobEffectCategory category, int color) {
            super(category, color);
        }
    }
}
