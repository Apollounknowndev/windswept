package com.rosemods.windswept.core;

import com.rosemods.windswept.core.other.*;
import com.rosemods.windswept.core.other.events.WindsweptTradeEvents;
import com.rosemods.windswept.core.registry.*;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.config.ModConfig;

public class Windswept {
    public static final String MOD_ID = "windswept";

    public Windswept() {
        WindsweptAttributes.init();
        WindsweptBannerPatterns.init();
        WindsweptBlocks.init();
        WindsweptBlockEntities.init();
        WindsweptEffects.init();
        WindsweptEnchantments.init();
        WindsweptEntityData.init();
        WindsweptEntityTypes.init();
        WindsweptFeatures.init();
        WindsweptFoliagePlacers.init();
        WindsweptItems.init();
        WindsweptPaintingVariants.init();
        WindsweptParticleTypes.init();
        WindsweptPotPatterns.init();
        WindsweptSounds.init();
        WindsweptTreeDecorators.init();
        WindsweptTrunkPlacers.init();


        WindsweptTradeEvents.registerTrades();
        WindsweptCreativeTabs.setupTabEditors();
        WindsweptVillagerTypes.registerVillagerTypes();
        WindsweptBlockInfo.registerCompostables();
        WindsweptBlockInfo.registerFlammables();
        WindsweptDispenseBehaviors.registerDispenseBehaviors();
        WindsweptCauldronInteractions.registerCauldronInteractions();

        ForgeConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.COMMON, WindsweptConfig.COMMON_SPEC);
        ForgeConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.CLIENT, WindsweptConfig.CLIENT_SPEC);
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MOD_ID, id);
    }

}
