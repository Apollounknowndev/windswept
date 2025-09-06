package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class WindsweptParticleTypes {
    public static final SimpleParticleType WILL_O_THE_WISP = register("will_o_the_wisp", new SimpleParticleType(false));
    public static final SimpleParticleType FROST_LEAF = register("frost_leaf", new SimpleParticleType(false));
    public static final SimpleParticleType FEATHER_CLOAK = register("feather_cloak", new SimpleParticleType(false));
    public static final SimpleParticleType ACACIA_LEAVES = register("acacia_leaves", new SimpleParticleType(false));


    private static SimpleParticleType register(String name, SimpleParticleType particle) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, Windswept.id(name), particle);
    }

    public static void init() {

    }
}
