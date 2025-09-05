package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;

import java.util.HashMap;
import java.util.Map;

public final class WindsweptPotPatterns {
    public static final ResourceKey<String> HOOT = register("hoot_pottery_pattern");
    public static final ResourceKey<String> PLUMAGE = register("plumage_pottery_pattern");
    public static final ResourceKey<String> OFFSHOOT = register("offshoot_pottery_pattern");
    public static final ResourceKey<String> FLAKE = register("flake_pottery_pattern");
    public static final ResourceKey<String> DRUPES = register("drupes_pottery_pattern");

    private static ResourceKey<String> register(String name) {
        Registry.register(BuiltInRegistries.DECORATED_POT_PATTERNS, Windswept.id(name), name);
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, Windswept.id(name));
    }

    public static void init() {
        DecoratedPotPatterns.ITEM_TO_POT_TEXTURE = new HashMap<>(DecoratedPotPatterns.ITEM_TO_POT_TEXTURE);
        DecoratedPotPatterns.ITEM_TO_POT_TEXTURE.putAll(Map.of(
                WindsweptItems.HOOT_POTTERY_SHERD, HOOT,
                WindsweptItems.PLUMAGE_POTTERY_SHERD, PLUMAGE,
                WindsweptItems.OFFSHOOT_POTTERY_SHERD, OFFSHOOT,
                WindsweptItems.FLAKE_POTTERY_SHERD, FLAKE,
                WindsweptItems.DRUPES_POTTERY_SHERD, DRUPES
        ));
    }
}
