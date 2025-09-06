package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.levelgen.feature.*;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public final class WindsweptFeatures {
    public static final Feature<NoneFeatureConfiguration> SNOWY_SPROUTS_PATCH = register("snowy_sprouts_patch", new SnowySproutsFeature());
    public static final Feature<NoneFeatureConfiguration> NIGHTSHADE_PATCH = register("nightshade_patch", new NightshadeFeature());
    public static final Feature<NoneFeatureConfiguration> BLUEBELL_PATCH = register("bluebell_patch", new BluebellsFeature());
    public static final Feature<NoneFeatureConfiguration> LAVENDER_PATCH = register("lavender_patch", new LavenderFeature());
    public static final Feature<NoneFeatureConfiguration> ICICLES_PATCH = register("icicles_patch", new IciclesFeature());
    public static final Feature<NoneFeatureConfiguration> FLOOR_ICICLES_PATCH = register("floor_icicles_patch", new FloorIciclesFeature());
    public static final Feature<SimpleBlockConfiguration> FALLEN_LOG = register("fallen_log", new FallenLogFeature());
    public static final Feature<NoneFeatureConfiguration> SNOWY_GELISOL = register("snowy_gelisol", new SnowyGelisolFeature());
    public static final Feature<TreeConfiguration> PINE_TREE = register("pine_tree", new PineTreeFeature());

    private static <T extends FeatureConfiguration> Feature<T> register(String name, Feature<T> feature) {
        return Registry.register(BuiltInRegistries.FEATURE, Windswept.id(name), feature);
    }

    public static void init() {

    }
}
