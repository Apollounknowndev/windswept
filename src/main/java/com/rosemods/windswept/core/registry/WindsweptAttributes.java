package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class WindsweptAttributes {
    public static final Attribute SNOW_SPEED = register("snow_speed");
    public static final Attribute FRAGRANCE = register("fragrance");
    public static final Attribute SPRINT_DAMAGE = register("sprint_damage");

    private static Attribute register(String name) {
        return Registry.register(BuiltInRegistries.ATTRIBUTE, Windswept.id(name), new RangedAttribute("attribute." + Windswept.MOD_ID + ".name.generic." + name, 0d, 0d, 1d));
    }

    public static void init() {

    }
}
