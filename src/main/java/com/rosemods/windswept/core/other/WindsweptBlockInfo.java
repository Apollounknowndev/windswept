package com.rosemods.windswept.core.other;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

import static com.rosemods.windswept.core.registry.WindsweptBlocks.*;
import static com.rosemods.windswept.core.registry.WindsweptItems.*;

public final class WindsweptBlockInfo {
    public static void registerCompostables() {
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
        registry.add(WILD_BERRIES, .3f);
        registry.add(WILD_BERRY_PIPS, .3f);
        registry.add(HOLLY_BERRIES, .3f);
        registry.add(CHESTNUTS, .3f);
        registry.add(GINGER_ROOT, .3f);
        registry.add(ROASTED_CHESTNUTS, .3f);
        registry.add(PINECONE, .3f);

        registry.add(CHESTNUT_CRATE, 1f);
        registry.add(ROASTED_CHESTNUT_CRATE, 1f);
        registry.add(GINGER_ROOT_CRATE, 1f);
        registry.add(HOLLY_BERRY_BASKET, 1f);
        registry.add(WILD_BERRY_BASKET, 1f);

        registry.add(RED_ROSE, .65f);
        registry.add(BLUE_ROSE, .65f);
        registry.add(WHITE_ROSE, .65f);
        registry.add(YELLOW_ROSE, .65f);
        registry.add(FOXGLOVE, .65f);
        registry.add(SNOWDROP, .65f);
        registry.add(MOSS_CAMPION, .65f);
        registry.add(NIGHTSHADE, .65f);
        registry.add(BLUEBELLS, .65f);
        registry.add(MIMOSA, .65f);
        registry.add(YELLOW_PETALS, .3f);

        registry.add(RED_ROSE_BUSH, .65f);
        registry.add(BLUE_ROSE_BUSH, .65f);
        registry.add(WHITE_ROSE_BUSH, .65f);
        registry.add(YELLOW_ROSE_BUSH, .65f);
        registry.add(LUPINE, .65f);
        registry.add(LIONS_TAIL, .65f);

        registry.add(HOLLY_LEAVES, .3f);
        registry.add(CHESTNUT_LEAVES, .3f);
        registry.add(PINE_LEAVES, .3f);
        registry.add(HOLLY_SAPLING, .3f);
        registry.add(CHESTNUT_SAPLING, .3f);
        registry.add(PINE_SAPLING, .3f);

        registry.add(SNOWY_SPROUTS, .5f);
        registry.add(GELISOL_GRASS, .5f);
        registry.add(DRY_MOSSY_SPROUTS, .5f);
        registry.add(MOSSY_SPROUTS, .5f);

        registry.add(GINGERBREAD_COOKIE, .85f);
        registry.add(MUTTON_PIE, 1f);
        registry.add(CHRISTMAS_PUDDING, 1f);

        registry.add(PINECONE_BLOCK, 1f);
        registry.add(PINECONE_JAM_BLOCK, 1f);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(STRIPPED_HOLLY_LOG, 5, 5);
        registry.add(STRIPPED_HOLLY_WOOD, 5, 5);
        registry.add(HOLLY_LOG, 5, 5);
        registry.add(HOLLY_WOOD, 5, 5);
        registry.add(HOLLY_PLANKS, 5, 20);
        registry.add(HOLLY_SLAB, 5, 20);
        registry.add(HOLLY_STAIRS, 5, 20);
        registry.add(HOLLY_FENCE, 5, 20);
        registry.add(HOLLY_FENCE_GATE, 5, 20);
        registry.add(HOLLY_BOARDS, 5, 20);
        registry.add(HOLLY_LEAVES, 30, 60);
        registry.add(HOLLY_BOOKSHELF, 30, 20);
        registry.add(HOLLY_BEEHIVE, 5, 20);
        registry.add(HOLLY_LEAF_PILE, 30, 60);

        registry.add(STRIPPED_CHESTNUT_LOG, 5, 5);
        registry.add(STRIPPED_CHESTNUT_WOOD, 5, 5);
        registry.add(CHESTNUT_LOG, 5, 5);
        registry.add(CHESTNUT_WOOD, 5, 5);
        registry.add(CHESTNUT_PLANKS, 5, 20);
        registry.add(CHESTNUT_SLAB, 5, 20);
        registry.add(CHESTNUT_STAIRS, 5, 20);
        registry.add(CHESTNUT_FENCE, 5, 20);
        registry.add(CHESTNUT_FENCE_GATE, 5, 20);
        registry.add(CHESTNUT_BOARDS, 5, 20);
        registry.add(CHESTNUT_LEAVES, 30, 60);
        registry.add(CHESTNUT_BOOKSHELF, 30, 20);
        registry.add(CHESTNUT_BEEHIVE, 5, 20);
        registry.add(CHESTNUT_LEAF_PILE, 30, 60);

        registry.add(STRIPPED_PINE_LOG, 5, 5);
        registry.add(STRIPPED_PINE_WOOD, 5, 5);
        registry.add(PINE_LOG, 5, 5);
        registry.add(PINE_WOOD, 5, 5);
        registry.add(PINE_PLANKS, 5, 20);
        registry.add(PINE_SLAB, 5, 20);
        registry.add(PINE_STAIRS, 5, 20);
        registry.add(PINE_FENCE, 5, 20);
        registry.add(PINE_FENCE_GATE, 5, 20);
        registry.add(PINE_BOARDS, 5, 20);
        registry.add(PINE_LEAVES, 30, 60);
        registry.add(PINE_BOOKSHELF, 30, 20);
        registry.add(PINE_BEEHIVE, 5, 20);
        registry.add(PINE_LEAF_PILE, 30, 60);

        registry.add(PINECONE_BLOCK, 5, 20);
        registry.add(CARVED_PINECONE_BLOCK, 5, 20);
        registry.add(PINECONE_SHINGLES, 5, 20);
        registry.add(PINECONE_SHINGLE_STAIRS, 5, 20);
        registry.add(PINECONE_SHINGLE_SLAB, 5, 20);

        registry.add(HOLLY_BERRY_BASKET, 5, 20);
        registry.add(CHESTNUT_CRATE, 5, 20);
        registry.add(GINGER_ROOT_CRATE, 5, 20);
        registry.add(ROASTED_CHESTNUT_CRATE, 5, 20);

        registry.add(WILD_BERRY_BUSH, 60, 100);
        registry.add(SNOWY_SPROUTS, 60, 100);
        registry.add(GELISOL_GRASS, 60, 100);
        registry.add(DRY_MOSSY_SPROUTS, 60, 100);
        registry.add(RED_ROSE, 60, 100);
        registry.add(BLUE_ROSE, 60, 100);
        registry.add(WHITE_ROSE, 60, 100);
        registry.add(YELLOW_ROSE, 60, 100);
        registry.add(FOXGLOVE, 60, 100);
        registry.add(SNOWDROP, 60, 100);
        registry.add(MOSS_CAMPION, 60, 100);
        registry.add(NIGHTSHADE, 60, 100);
        registry.add(BLUEBELLS, 60, 100);
        registry.add(MIMOSA, 60, 100);
        registry.add(LUPINE, 60, 100);
        registry.add(RED_ROSE_BUSH, 60, 100);
        registry.add(BLUE_ROSE_BUSH, 60, 100);
        registry.add(WHITE_ROSE_BUSH, 60, 100);
        registry.add(YELLOW_ROSE_BUSH, 60, 100);
        registry.add(LIONS_TAIL, 60, 100);
    }

}
