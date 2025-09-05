package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BannerPattern;

public class WindsweptBannerPatterns {
    public static final BannerPattern SNOW_CHARGE = register("snow_charge", new BannerPattern("wsc"));
    public static final BannerPattern SNOW_GOLEM = register("snow_golem", new BannerPattern("wsg"));
    public static final BannerPattern ROSE_FLOWER = register("rose_flower", new BannerPattern("wrf"));

    private static BannerPattern register(String name, BannerPattern bannerPattern) {
        return Registry.register(BuiltInRegistries.BANNER_PATTERN, Windswept.id(name), bannerPattern);
    }

    public static void init() {

    }
}
