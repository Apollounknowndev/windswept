package com.rosemods.windswept.core.other.tags;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class WindsweptBiomeTags {
    public static final TagKey<Biome> HAS_RED_ROSE = tag(Windswept.MOD_ID, "has_feature/red_rose");
    public static final TagKey<Biome> HAS_BLUE_ROSE = tag(Windswept.MOD_ID, "has_feature/blue_rose");
    public static final TagKey<Biome> HAS_WHITE_ROSE = tag(Windswept.MOD_ID, "has_feature/white_rose");
    public static final TagKey<Biome> HAS_YELLOW_ROSE = tag(Windswept.MOD_ID, "has_feature/yellow_rose");
    public static final TagKey<Biome> HAS_BLUEBELLS = tag(Windswept.MOD_ID, "has_feature/bluebells");
    public static final TagKey<Biome> HAS_LIONS_TAIL = tag(Windswept.MOD_ID, "has_feature/lions_tail");
    public static final TagKey<Biome> HAS_WILD_BERRIES = tag(Windswept.MOD_ID, "has_feature/wild_berries");
    public static final TagKey<Biome> HAS_RARE_CHESTNUT_TREES = tag(Windswept.MOD_ID, "has_feature/rare_chestnut_trees");
    public static final TagKey<Biome> HAS_RARE_HOLLY_TREES = tag(Windswept.MOD_ID, "has_feature/rare_holly_trees");
    public static final TagKey<Biome> HAS_RARE_SNOWY_HOLLY_TREES = tag(Windswept.MOD_ID, "has_feature/rare_snowy_holly_trees");

    public static final TagKey<Biome> HAS_GROVE_WEATHERED_HOUSE = tag(Windswept.MOD_ID, "has_structure/grove_weathered_house");
    public static final TagKey<Biome> HAS_CHESTNUT_WEATHERED_HOUSE = tag(Windswept.MOD_ID, "has_structure/chestnut_weathered_house");
    public static final TagKey<Biome> HAS_FROZEN_VILLAGE = tag(Windswept.MOD_ID, "has_structure/frozen_village");
    public static final TagKey<Biome> HAS_PINE_TOTEM = tag(Windswept.MOD_ID, "has_structure/pine_totem");
    public static final TagKey<Biome> HAS_SNOWY_PINE_TOTEM = tag(Windswept.MOD_ID, "has_structure/snowy_pine_totem");

    public static final TagKey<Biome> IS_CHESTNUT_FOREST = tag(Windswept.MOD_ID, "is_chestnut_forest");
    public static final TagKey<Biome> IS_PINE_BARRENS = tag(Windswept.MOD_ID, "is_pine_barrens");
    public static final TagKey<Biome> IS_LAVENDER = tag(Windswept.MOD_ID, "is_lavender");

    public static final TagKey<Biome> HAS_BROWN_GOAT = tag(Windswept.MOD_ID, "has_brown_goat");

    public static final TagKey<Biome> HAS_SPOTTED_ORANGE_MAPLE_TREES = tag("autumnity", "has_feature/spotted_maple_tree/orange");
    public static final TagKey<Biome> HAS_SPOTTED_RED_MAPLE_TREES = tag("autumnity", "has_feature/spotted_maple_tree/red");

    public static final TagKey<Biome> HAS_YAK = tag("environmental", "has_animal/yak");
    public static final TagKey<Biome> HAS_REINDEER = tag("environmental", "has_animal/reindeer");
    public static final TagKey<Biome> HAS_SHEEP = tag("environmental", "has_animal/sheep");
    public static final TagKey<Biome> HAS_DWARF_SPRUCE_SPARSE = tag("environmental", "has_feature/dwarf_spruce_sparse");

    private static TagKey<Biome> tag(String namespace, String path) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(namespace, path));
    }
}
