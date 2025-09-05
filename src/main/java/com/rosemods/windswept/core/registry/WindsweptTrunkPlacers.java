package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.levelgen.tree.trunk_placer.ChestnutTrunkPlacer;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public final class WindsweptTrunkPlacers {
    public static final TrunkPlacerType<ChestnutTrunkPlacer> CHESTNUT_TRUNK_PLACER = register("chestnut_trunk_placer", new TrunkPlacerType<>(ChestnutTrunkPlacer.CODEC));

    private static <T extends TrunkPlacer> TrunkPlacerType<T> register(String name, TrunkPlacerType<T> type) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, Windswept.id(name), type);
    }

    public static void init() {

    }
}
