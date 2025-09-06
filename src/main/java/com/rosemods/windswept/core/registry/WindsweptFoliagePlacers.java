package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.levelgen.tree.foliage_placer.ChestnutFoliagePlacer;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public final class WindsweptFoliagePlacers {
    public static final FoliagePlacerType<?> CHESTNUT_FOLIAGE_PLACER = register("chestnut_foliage_placer", new FoliagePlacerType<>(ChestnutFoliagePlacer.CODEC));

    private static FoliagePlacerType<?> register(String name, FoliagePlacerType<?> type) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, Windswept.id(name), type);
    }

    public static void init() {

    }
}
