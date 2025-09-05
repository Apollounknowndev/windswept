package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.client.particle.AcaciaLeavesParticle;
import com.rosemods.windswept.client.particle.FrostLeafParticle;
import com.rosemods.windswept.client.particle.WillOTheWispParticle;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

// TODO: FIX
public class WindsweptParticleTypes {
    public static final SimpleParticleType WILL_O_THE_WISP = register("will_o_the_wisp", new SimpleParticleType(false));
    public static final SimpleParticleType FROST_LEAF = register("frost_leaf", new SimpleParticleType(false));
    public static final SimpleParticleType FEATHER_CLOAK = register("feather_cloak", new SimpleParticleType(false));
    public static final SimpleParticleType ACACIA_LEAVES = register("acacia_leaves", new SimpleParticleType(false));

    @SubscribeEvent
    public static void register(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(WILL_O_THE_WISP.get(), WillOTheWispParticle.Provider::new);
        event.registerSpriteSet(FROST_LEAF.get(), FrostLeafParticle.Provider::new);
        event.registerSpriteSet(FEATHER_CLOAK.get(), EndRodParticle.Provider::new);
        event.registerSpriteSet(ACACIA_LEAVES.get(), AcaciaLeavesParticle.Provider::new);
    }

    private static SimpleParticleType register(String name, SimpleParticleType particle) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, Windswept.id(name), particle);
    }

    public static void init() {

    }
}
