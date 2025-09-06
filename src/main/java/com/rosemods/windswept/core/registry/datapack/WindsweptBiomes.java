package com.rosemods.windswept.core.registry.datapack;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class WindsweptBiomes {
    public static final ResourceKey<Biome> CHESTNUT_FOREST = createKey("chestnut_forest");
    public static final ResourceKey<Biome> SNOWY_CHESTNUT_FOREST = createKey("snowy_chestnut_forest");
    public static final ResourceKey<Biome> PINE_BARRENS = createKey("pine_barrens");
    public static final ResourceKey<Biome> SNOWY_PINE_BARRENS = createKey("snowy_pine_barrens");
    public static final ResourceKey<Biome> LAVENDER_HILLS = createKey("lavender_hills");
    public static final ResourceKey<Biome> LAVENDER_FIELDS = createKey("lavender_fields");
    public static final ResourceKey<Biome> TUNDRA = createKey("tundra");
    public static final ResourceKey<Biome> FLOWERING_SAVANNA = createKey("flowering_savanna");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, Windswept.id(name));
    }
}
