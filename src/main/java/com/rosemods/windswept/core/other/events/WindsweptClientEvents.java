package com.rosemods.windswept.core.other.events;

import com.rosemods.windswept.client.render.entity.ChilledRenderer;
import com.rosemods.windswept.client.render.entity.FrostArrowRenderer;
import com.rosemods.windswept.client.render.entity.FrostbiterRenderer;
import com.rosemods.windswept.core.other.WindsweptModelLayers;
import com.rosemods.windswept.core.registry.WindsweptBlockEntities;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptEntityTypes;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.BrushableBlockRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class WindsweptClientEvents {
    private static final List<Block> FOLIAGE_COLOR_BLOCKS = List.of(WindsweptBlocks.CHESTNUT_LEAVES, WindsweptBlocks.FLOWERING_ACACIA_LEAVES);
    private static final List<Block> GRASS_COLOR_BLOCKS = List.of(WindsweptBlocks.YELLOW_PETALS);

    public static void registerItemColors() {
        ColorProviderRegistry.ITEM.register(
            (stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack),
            WindsweptItems.SNOW_BOOTS
        );
        ColorProviderRegistry.ITEM.register(
            (stack, c) -> {
                Block block = ((BlockItem) stack.getItem()).getBlock();
                return ColorProviderRegistry.BLOCK.get(block).getColor(block.defaultBlockState(), null, null, c);
            },
            FOLIAGE_COLOR_BLOCKS.stream().map(Block::asItem).toArray(ItemLike[]::new)
        );
    }

    public static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register(
            (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageFoliageColor(tint, pos) : FoliageColor.getDefaultColor(),
            FOLIAGE_COLOR_BLOCKS.toArray(Block[]::new)
        );
        ColorProviderRegistry.BLOCK.register(
            (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageGrassColor(tint, pos) : GrassColor.getDefaultColor(),
            GRASS_COLOR_BLOCKS.toArray(Block[]::new)
        );
    }

    public static void registerLayerDefinitions() {
        EntityModelLayerRegistry.registerModelLayer(WindsweptModelLayers.CHILLED, WindsweptModelLayers::createChilledBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(WindsweptModelLayers.FROSTBITER, WindsweptModelLayers::createFrostbiterBodyLayer);
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(WindsweptEntityTypes.CHILLED, ChilledRenderer::new);
        EntityRendererRegistry.register(WindsweptEntityTypes.FROSTBITER, FrostbiterRenderer::new);
        EntityRendererRegistry.register(WindsweptEntityTypes.FROST_ARROW, FrostArrowRenderer::new);
        BlockEntityRenderers.register(WindsweptBlockEntities.SUSPICIOUS_SNOW, BrushableBlockRenderer::new);
    }
}
