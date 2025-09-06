package com.rosemods.windswept.core.registry.datapack;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public final class WindsweptConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY = createKey("holly");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_BEES = createKey("holly_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT = createKey("chestnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT_BEES = createKey("chestnut_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE = createKey("pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_BEES = createKey("pine_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_ACACIA = createKey("flowering_acacia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_ACACIA_BEES = createKey("flowering_acacia_bees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_MOSS_PATCH_SMALL = createKey("dry_moss_patch_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS_PATCH_BONEMEAL = createKey("moss_patch_bonemeal");


    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Windswept.id(name));
    }
}
