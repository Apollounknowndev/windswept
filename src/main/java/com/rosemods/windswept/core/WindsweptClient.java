package com.rosemods.windswept.core;

import com.rosemods.windswept.client.particle.AcaciaLeavesParticle;
import com.rosemods.windswept.client.particle.FrostLeafParticle;
import com.rosemods.windswept.client.particle.WillOTheWispParticle;
import com.rosemods.windswept.core.other.events.WindsweptClientEvents;
import com.rosemods.windswept.core.registry.WindsweptParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;

public class WindsweptClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(WindsweptParticleTypes.WILL_O_THE_WISP, WillOTheWispParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(WindsweptParticleTypes.FROST_LEAF, FrostLeafParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(WindsweptParticleTypes.FEATHER_CLOAK, EndRodParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(WindsweptParticleTypes.ACACIA_LEAVES, AcaciaLeavesParticle.Provider::new);

        WindsweptClientEvents.registerBlockColors();
        WindsweptClientEvents.registerItemColors();
        WindsweptClientEvents.registerLayerDefinitions();
        WindsweptClientEvents.registerEntityRenderers();
    }
}
