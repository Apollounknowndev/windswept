package com.rosemods.windswept.core.registry;

import com.mojang.datafixers.util.Pair;
import com.rosemods.windswept.common.block.*;
import com.rosemods.windswept.common.block.grower.ChestnutTreeGrower;
import com.rosemods.windswept.common.block.grower.FloweringAcaciaTreeGrower;
import com.rosemods.windswept.common.block.grower.HollyTreeGrower;
import com.rosemods.windswept.common.block.grower.PineTreeGrower;
import com.rosemods.windswept.common.item.WearableBlockItem;
import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.other.WindsweptSoundTypes;
import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;
import com.teamabnormals.blueprint.common.block.LeafPileBlock;
import com.teamabnormals.blueprint.common.block.LogBlock;
import com.teamabnormals.blueprint.common.block.WoodBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintCeilingHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchSlabBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchStairBlock;
import com.teamabnormals.blueprint.core.api.BlockSetTypeRegistryHelper;
import com.teamabnormals.blueprint.core.api.WoodTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

// TODO: FIX
public class WindsweptBlocks {

    // Holly //
    public static final Block HOLLY_LOG = register("holly_log", new LogBlock(WindsweptBlocks.STRIPPED_HOLLY_LOG, Properties.HOLLY.log()));
    public static final Block HOLLY_WOOD = register("holly_wood", new WoodBlock(WindsweptBlocks.STRIPPED_HOLLY_WOOD, Properties.HOLLY.log()));
    public static final Block STRIPPED_HOLLY_LOG = register("stripped_holly_log", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block STRIPPED_HOLLY_WOOD = register("stripped_holly_wood", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block HOLLY_PLANKS = register("holly_planks", new Block(Properties.HOLLY.planks()));
    public static final Block HOLLY_STAIRS = register("holly_stairs", new StairBlock(HOLLY_PLANKS.defaultBlockState(), Properties.HOLLY.planks()));
    public static final Block HOLLY_SLAB = register("holly_slab", new SlabBlock(Properties.HOLLY.planks()));
    public static final Block HOLLY_FENCE = HELPER.createFuelBlock("holly_fence", new FenceBlock(Properties.HOLLY.planks()), 300);
    public static final Block HOLLY_FENCE_GATE = HELPER.createFuelBlock("holly_fence_gate", new FenceGateBlock(Properties.HOLLY.planks(), Properties.HOLLY_WOOD_TYPE), 300);
    public static final Block HOLLY_PRESSURE_PLATE = register("holly_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.HOLLY.pressurePlate().sound(SoundType.CHERRY_WOOD), Properties.HOLLY_BLOCK_SET));
    public static final Block HOLLY_BUTTON = register("holly_button", new ButtonBlock(Properties.HOLLY.button(), Properties.HOLLY_BLOCK_SET, 30, true));
    public static final Block HOLLY_DOOR = register("holly_door", new DoorBlock(Properties.HOLLY.door(), Properties.HOLLY_BLOCK_SET));
    public static final Block HOLLY_TRAPDOOR = register("holly_trapdoor", new TrapDoorBlock(Properties.HOLLY.trapdoor(), Properties.HOLLY_BLOCK_SET));
    public static final Pair<BlueprintStandingSignBlock, BlueprintWallSignBlock> HOLLY_SIGNS = HELPER.createSignBlock("holly", Properties.HOLLY_WOOD_TYPE, Properties.HOLLY.sign().sound(SoundType.CHERRY_WOOD));
    public static final Pair<BlueprintCeilingHangingSignBlock, BlueprintWallHangingSignBlock> HOLLY_HANGING_SIGNS = HELPER.createHangingSignBlock("holly", Properties.HOLLY_WOOD_TYPE, Properties.HOLLY.hangingSign().sound(SoundType.CHERRY_WOOD_HANGING_SIGN));

    public static final Block HOLLY_BEEHIVE = register("holly_beehive", new BlueprintBeehiveBlock(Properties.HOLLY.beehive()));
    public static final Block HOLLY_LADDER = HELPER.createFuelBlock("holly_ladder", new LadderBlock(Properties.HOLLY.ladder()), 300);
    public static final Block HOLLY_BOOKSHELF = HELPER.createFuelBlock("holly_bookshelf", new Block(Properties.HOLLY.bookshelf()), 300);
    public static final Block HOLLY_BOARDS = register("holly_boards", new RotatedPillarBlock(Properties.HOLLY.planks()));
    public static final BlueprintChestBlock HOLLY_CHEST = HELPER.createChestBlock("holly", Properties.HOLLY.chest());
    public static final BlueprintTrappedChestBlock TRAPPED_HOLLY_CHEST = HELPER.createTrappedChestBlockNamed("holly", Properties.HOLLY.chest());

    public static final Block HOLLY_SAPLING = register("holly_sapling", new HollySaplingBlock(new HollyTreeGrower(), PropertyUtil.sapling()));
    public static final Block POTTED_HOLLY_SAPLING = rawRegister("potted_holly_sapling", new FlowerPotBlock(HOLLY_SAPLING, PropertyUtil.flowerPot()));
    public static final Block HOLLY_LEAVES = register("holly_leaves", new HollyLeavesBlock(Properties.HOLLY.leaves()));
    public static final Block HOLLY_LEAF_PILE = register("holly_leaf_pile", new LeafPileBlock(Properties.HOLLY.leafPile()));

    // Chestnut //
    public static final Block CHESTNUT_LOG = register("chestnut_log", new LogBlock(WindsweptBlocks.STRIPPED_CHESTNUT_LOG, Properties.CHESTNUT.log()));
    public static final Block CHESTNUT_WOOD = register("chestnut_wood", new WoodBlock(WindsweptBlocks.STRIPPED_CHESTNUT_WOOD, Properties.CHESTNUT.log()));
    public static final Block STRIPPED_CHESTNUT_LOG = register("stripped_chestnut_log", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block STRIPPED_CHESTNUT_WOOD = register("stripped_chestnut_wood", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block CHESTNUT_PLANKS = register("chestnut_planks", new Block(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_STAIRS = register("chestnut_stairs", new StairBlock(CHESTNUT_PLANKS.defaultBlockState(), Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_SLAB = register("chestnut_slab", new SlabBlock(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_FENCE = HELPER.createFuelBlock("chestnut_fence", new FenceBlock(Properties.CHESTNUT.planks()), 300);
    public static final Block CHESTNUT_FENCE_GATE = HELPER.createFuelBlock("chestnut_fence_gate", new FenceGateBlock(Properties.CHESTNUT.planks(), Properties.CHESTNUT_WOOD_TYPE), 300);
    public static final Block CHESTNUT_PRESSURE_PLATE = register("chestnut_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.CHESTNUT.pressurePlate(), Properties.CHESTNUT_BLOCK_SET));
    public static final Block CHESTNUT_BUTTON = register("chestnut_button", new ButtonBlock(Properties.CHESTNUT.button(), Properties.CHESTNUT_BLOCK_SET, 30, true));
    public static final Block CHESTNUT_DOOR = register("chestnut_door", new DoorBlock(Properties.CHESTNUT.door(), Properties.CHESTNUT_BLOCK_SET));
    public static final Block CHESTNUT_TRAPDOOR = register("chestnut_trapdoor", new TrapDoorBlock(Properties.CHESTNUT.trapdoor(), Properties.CHESTNUT_BLOCK_SET));
    public static final Pair<BlueprintStandingSignBlock, BlueprintWallSignBlock> CHESTNUT_SIGNS = HELPER.createSignBlock("chestnut", Properties.CHESTNUT_WOOD_TYPE, Properties.CHESTNUT.sign());
    public static final Pair<BlueprintCeilingHangingSignBlock, BlueprintWallHangingSignBlock> CHESTNUT_HANGING_SIGNS = HELPER.createHangingSignBlock("chestnut", Properties.CHESTNUT_WOOD_TYPE, Properties.CHESTNUT.hangingSign());

    public static final Block CHESTNUT_BEEHIVE = register("chestnut_beehive", new BlueprintBeehiveBlock(Properties.CHESTNUT.beehive()));
    public static final Block CHESTNUT_LADDER = HELPER.createFuelBlock("chestnut_ladder", new LadderBlock(Properties.CHESTNUT.ladder()), 300);
    public static final Block CHESTNUT_BOOKSHELF = HELPER.createFuelBlock("chestnut_bookshelf", new Block(Properties.CHESTNUT.bookshelf()), 300);
    public static final Block CHESTNUT_BOARDS = register("chestnut_boards", new RotatedPillarBlock(Properties.CHESTNUT.planks()));
    public static final BlueprintChestBlock CHESTNUT_CHEST = HELPER.createChestBlock("chestnut", Properties.CHESTNUT.chest());
    public static final BlueprintTrappedChestBlock TRAPPED_CHESTNUT_CHEST = HELPER.createTrappedChestBlockNamed("chestnut", Properties.CHESTNUT.chest());

    public static final Block CHESTNUT_SAPLING = register("chestnut_sapling", new SaplingBlock(new ChestnutTreeGrower(), PropertyUtil.sapling()));
    public static final Block POTTED_CHESTNUT_SAPLING = rawRegister("potted_chestnut_sapling", new FlowerPotBlock(CHESTNUT_SAPLING, PropertyUtil.flowerPot()));
    public static final Block CHESTNUT_LEAVES = register("chestnut_leaves", new LeavesBlock(Properties.CHESTNUT.leaves()));
    public static final Block CHESTNUT_LEAF_PILE = register("chestnut_leaf_pile", new LeafPileBlock(Properties.CHESTNUT.leafPile()));

    // Pine //
    public static final Block PINE_LOG = register("pine_log", new LogBlock(WindsweptBlocks.WEATHERED_PINE_LOG, Properties.PINE.log()));
    public static final Block PINE_WOOD = register("pine_wood", new WoodBlock(WindsweptBlocks.WEATHERED_PINE_WOOD, Properties.PINE.log()));
    public static final Block WEATHERED_PINE_LOG = register("weathered_pine_log", new LogBlock(WindsweptBlocks.STRIPPED_PINE_LOG, Properties.PINE.log()));
    public static final Block WEATHERED_PINE_WOOD = register("weathered_pine_wood", new WoodBlock(WindsweptBlocks.STRIPPED_PINE_WOOD, Properties.PINE.log()));
    public static final Block STRIPPED_PINE_LOG = register("stripped_pine_log", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block STRIPPED_PINE_WOOD = register("stripped_pine_wood", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block PINE_PLANKS = register("pine_planks", new Block(Properties.PINE.planks()));
    public static final Block PINE_STAIRS = register("pine_stairs", new StairBlock(PINE_PLANKS.defaultBlockState(), Properties.PINE.planks()));
    public static final Block PINE_SLAB = register("pine_slab", new SlabBlock(Properties.PINE.planks()));
    public static final Block PINE_FENCE = HELPER.createFuelBlock("pine_fence", new FenceBlock(Properties.PINE.planks()), 300);
    public static final Block PINE_FENCE_GATE = HELPER.createFuelBlock("pine_fence_gate", new FenceGateBlock(Properties.PINE.planks(), Properties.PINE_WOOD_TYPE), 300);
    public static final Block PINE_PRESSURE_PLATE = register("pine_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PINE.pressurePlate(), Properties.PINE_BLOCK_SET));
    public static final Block PINE_BUTTON = register("pine_button", new ButtonBlock(Properties.PINE.button(), Properties.PINE_BLOCK_SET, 30, true));
    public static final Block PINE_DOOR = register("pine_door", new DoorBlock(Properties.PINE.door(), Properties.PINE_BLOCK_SET));
    public static final Block PINE_TRAPDOOR = register("pine_trapdoor", new TrapDoorBlock(Properties.PINE.trapdoor(), Properties.PINE_BLOCK_SET));
    public static final Pair<BlueprintStandingSignBlock, BlueprintWallSignBlock> PINE_SIGNS = HELPER.createSignBlock("pine", Properties.PINE_WOOD_TYPE, Properties.PINE.sign());
    public static final Pair<BlueprintCeilingHangingSignBlock, BlueprintWallHangingSignBlock> PINE_HANGING_SIGNS = HELPER.createHangingSignBlock("pine", Properties.PINE_WOOD_TYPE, Properties.PINE.hangingSign());

    public static final Block PINE_BEEHIVE = register("pine_beehive", new BlueprintBeehiveBlock(Properties.PINE.beehive()));
    public static final Block PINE_LADDER = HELPER.createFuelBlock("pine_ladder", new LadderBlock(Properties.PINE.ladder()), 300);
    public static final Block PINE_BOOKSHELF = HELPER.createFuelBlock("pine_bookshelf", new Block(Properties.PINE.bookshelf()), 300);
    public static final Block PINE_BOARDS = register("pine_boards", new RotatedPillarBlock(Properties.PINE.planks()));
    public static final BlueprintChestBlock PINE_CHEST = HELPER.createChestBlock("pine", Properties.PINE.chest());
    public static final BlueprintTrappedChestBlock TRAPPED_PINE_CHEST = HELPER.createTrappedChestBlockNamed("pine", Properties.PINE.chest());

    public static final Block PINE_SAPLING = register("pine_sapling", new SaplingBlock(new PineTreeGrower(), PropertyUtil.sapling()));
    public static final Block POTTED_PINE_SAPLING = rawRegister("potted_pine_sapling", new FlowerPotBlock(PINE_SAPLING, PropertyUtil.flowerPot()));
    public static final Block PINE_LEAVES = register("pine_leaves", new LeavesBlock(Properties.PINE.leaves()));
    public static final Block PINE_LEAF_PILE = register("pine_leaf_pile", new LeafPileBlock(Properties.PINE.leafPile()));

    // Moss //
    public static final Block MOSSY_SPROUTS = register("mossy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block DRY_MOSSY_SPROUTS = register("dry_mossy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block DRY_MOSS_CARPET = register("dry_moss_carpet", new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET)));
    public static final Block DRY_MOSS_BLOCK = register("dry_moss_block", new DryMossBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));

    // Gelisol Blocks //
    public static final Block GELISOL_GRASS = register("gelisol_grass", new SproutsBlock(Properties.SPROUTS));
    public static final Block GELISOL = register("gelisol", new GelisolBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL)));
    public static final Block GELISOL_PATH = register("gelisol_path", new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));

    // Plants //
    public static final Block RED_ROSE = register("red_rose", new RoseFlowerBlock(WindsweptBlocks.RED_ROSE_BUSH, MobEffects.WITHER, 5, PropertyUtil.flower()));
    public static final Block BLUE_ROSE = register("blue_rose", new RoseFlowerBlock(WindsweptBlocks.BLUE_ROSE_BUSH, MobEffects.WITHER, 5, PropertyUtil.flower()));
    public static final Block WHITE_ROSE = register("white_rose", new RoseFlowerBlock(WindsweptBlocks.WHITE_ROSE_BUSH, MobEffects.WITHER, 5, PropertyUtil.flower()));
    public static final Block YELLOW_ROSE = register("yellow_rose", new RoseFlowerBlock(WindsweptBlocks.YELLOW_ROSE_BUSH, MobEffects.WITHER, 5, PropertyUtil.flower()));
    public static final Block FOXGLOVE = register("foxglove", new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5, PropertyUtil.flower()));
    public static final Block BLUEBELLS = register("bluebells", new FlowerBlock(MobEffects.SLOW_FALLING, 5, PropertyUtil.flower()));
    public static final Block SNOWY_SPROUTS = register("snowy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block SNOWDROP = register("snowdrop", new SnowdropBlock(WindsweptEffects.FROST_RESISTANCE, 5, PropertyUtil.flower().sound(SoundType.NETHER_SPROUTS)));
    public static final Block MOSS_CAMPION = register("moss_campion", new MossCampionBlock(WindsweptEffects.THORNS, 5, PropertyUtil.flower().sound(SoundType.AZALEA)));
    public static final Block WILD_GINGER = register("wild_ginger", new FlowerBlock(MobEffects.DAMAGE_BOOST, 5, PropertyUtil.flower()));
    public static final Block NIGHTSHADE = register("nightshade", new NightshadeFlowerBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(state -> 9)));
    public static final Block MIMOSA = register("mimosa", new MimosaBlock(MobEffects.FIRE_RESISTANCE, 5, PropertyUtil.flower().sound(SoundType.NETHER_SPROUTS)));

    // Tall Flowers//
    public static final Block LUPINE = register("lupine", new TallFlowerBlock(PropertyUtil.flower()));
    public static final Block LIONS_TAIL = register("lions_tail", new TallFlowerBlock(PropertyUtil.flower()));
    public static final Block RED_ROSE_BUSH = register("red_rose_bush", new TallFlowerBlock(PropertyUtil.flower()));
    public static final Block BLUE_ROSE_BUSH = register("blue_rose_bush", new TallFlowerBlock(PropertyUtil.flower()));
    public static final Block WHITE_ROSE_BUSH = register("white_rose_bush", new TallFlowerBlock(PropertyUtil.flower()));
    public static final Block YELLOW_ROSE_BUSH = register("yellow_rose_bush", new TallFlowerBlock(PropertyUtil.flower()));

    // Lavender //
    public static final Block LAVENDER = register("lavender", new LavenderBlock(PropertyUtil.flower().sound(SoundType.AZALEA).randomTicks()));
    public static final Block LAVENDER_BALE = register("lavender_bale", new LavenderBaleBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));
    public static final Block LAVENDER_THATCH = register("lavender_thatch", new ThatchBlock(Properties.LAVENDER_THATCH));
    public static final Block LAVENDER_THATCH_STAIRS = register("lavender_thatch_stairs", new ThatchStairBlock(LAVENDER_THATCH.defaultBlockState(), Properties.LAVENDER_THATCH));
    public static final Block LAVENDER_THATCH_SLAB = register("lavender_thatch_slab", new ThatchSlabBlock(Properties.LAVENDER_THATCH));

    // Acacia //
    public static final Block FLOWERING_ACACIA_SAPLING = register("flowering_acacia_sapling", new SaplingBlock(new FloweringAcaciaTreeGrower(), PropertyUtil.sapling()));
    public static final Block POTTED_FLOWERING_ACACIA_SAPLING = rawRegister("potted_flowering_acacia_sapling", new FlowerPotBlock(FLOWERING_ACACIA_SAPLING, PropertyUtil.flowerPot()));
    public static final Block FLOWERING_ACACIA_LEAVES = register("flowering_acacia_leaves", new FloweringAcaciaLeavesBlock(Properties.HOLLY.leaves()));
    public static final Block FLOWERING_ACACIA_LEAF_PILE = register("flowering_acacia_leaf_pile", new LeafPileBlock(Properties.HOLLY.leafPile()));
    public static final Block YELLOW_PETALS = register("yellow_petals", new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));

    // Decoration Blocks //
    public static final Block HOLLY_WREATH = registerWithItem("holly_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.HOLLY_WREATH, new Item.Properties()));
    public static final Block PINECONE_WREATH = registerWithItem("pinecone_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.PINECONE_WREATH, new Item.Properties()));
    public static final Block VINE_WREATH = registerWithItem("vine_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.VINE_WREATH, new Item.Properties()));
    public static final Block CHERRY_WREATH = registerWithItem("cherry_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.CHERRY_WREATH, new Item.Properties()));
    public static final Block CHRISTMAS_PUDDING = register("christmas_pudding", new ChristmasPuddingBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion()), new Item.Properties().stacksTo(1));
    public static final Block FROSTBITER_TROPHY = register("frostbiter_trophy", new WallDecorationBlock(Properties.HOLLY.ladder().sound(SoundType.WOOD)));
    public static final Block ICE_SHEET = register("ice_sheet", new IceSheetBlock(BlockBehaviour.Properties.of().strength(.3f).sound(SoundType.GLASS).noOcclusion().friction(.98f)));

    // Pinecone Blocks //
    public static final Block PINECONE = register("pinecone", new PineconeBlock(Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(.25f).offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape().noOcclusion().sound(WindsweptSoundTypes.PINECONE)));
    public static final Block PINECONE_JAM_BLOCK = register("pinecone_jam_block", new PineconeJamBlock(Block.Properties.of().mapColor(MapColor.COLOR_RED).noOcclusion().sound(SoundType.HONEY_BLOCK)));

    public static final Block FAIRY_LIGHT = register("fairy_light", new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> 14)));
    public static final Block SOUL_FAIRY_LIGHT = register("soul_fairy_light", new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> 10)));
    public static final Block CUPRIC_FAIRY_LIGHT = register("cupric_fairy_light", new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> 10)));
    public static final Block ENDER_FAIRY_LIGHT = register("ender_fairy_light", new PineconeBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> 14)));
    public static final Block NIGHT_FAIRY_LIGHT = register("night_fairy_light", new NightFairyLightBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> s.getValue(NightFairyLightBlock.LIT) ? 9 : 0)));
    public static final Block REDSTONE_FAIRY_LIGHT = register("redstone_fairy_light", new RedstoneFairyLightBlock(BlockBehaviour.Properties.copy(PINECONE).lightLevel(s -> s.getValue(RedstoneFairyLightBlock.LIT) ? 7 : 0)));

    public static final Block ELDER_WING = register("elder_wing", new FeatherWingBlock(Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(.1f).noOcclusion().noCollission().sound(WindsweptSoundTypes.PINECONE)));
    public static final Block ELDER_ORNAMENT = register("elder_ornament", new FeatherOrnamentBlock(Properties.ELDER_ORNAMENT));
    public static final Block DREAM_CATCHER = register("dream_catcher", new DreamCatcherBlock(Properties.ELDER_ORNAMENT));

    public static final Block PINECONE_BLOCK = register("pinecone_block", new PineconeBlockBlock(Properties.PINECONE_BLOCK));
    public static final Block CARVED_PINECONE_BLOCK = registerWithItem("carved_pinecone_block", new CarvedPineconeBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK).randomTicks()), new WearableBlockItem(WindsweptBlocks.CARVED_PINECONE_BLOCK, new Item.Properties()));
    public static final Block WILL_O_THE_WISP = register("will_o_the_wisp", new WillOTheWispBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK).lightLevel(s -> 10)), new Item.Properties().rarity(Rarity.RARE));

    // Pinecone Shingles //
    public static final Block PINECONE_SHINGLES = register("pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block PINECONE_SHINGLE_STAIRS = register("pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block PINECONE_SHINGLE_SLAB = register("pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block WHITE_PINECONE_SHINGLES = register("white_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block WHITE_PINECONE_SHINGLE_STAIRS = register("white_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block WHITE_PINECONE_SHINGLE_SLAB = register("white_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block LIGHT_GRAY_PINECONE_SHINGLES = register("light_gray_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block LIGHT_GRAY_PINECONE_SHINGLE_STAIRS = register("light_gray_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block LIGHT_GRAY_PINECONE_SHINGLE_SLAB = register("light_gray_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block GRAY_PINECONE_SHINGLES = register("gray_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block GRAY_PINECONE_SHINGLE_STAIRS = register("gray_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block GRAY_PINECONE_SHINGLE_SLAB = register("gray_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block BLACK_PINECONE_SHINGLES = register("black_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block BLACK_PINECONE_SHINGLE_STAIRS = register("black_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block BLACK_PINECONE_SHINGLE_SLAB = register("black_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block BROWN_PINECONE_SHINGLES = register("brown_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block BROWN_PINECONE_SHINGLE_STAIRS = register("brown_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block BROWN_PINECONE_SHINGLE_SLAB = register("brown_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block RED_PINECONE_SHINGLES = register("red_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block RED_PINECONE_SHINGLE_STAIRS = register("red_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block RED_PINECONE_SHINGLE_SLAB = register("red_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block ORANGE_PINECONE_SHINGLES = register("orange_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block ORANGE_PINECONE_SHINGLE_STAIRS = register("orange_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block ORANGE_PINECONE_SHINGLE_SLAB = register("orange_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block YELLOW_PINECONE_SHINGLES = register("yellow_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block YELLOW_PINECONE_SHINGLE_STAIRS = register("yellow_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block YELLOW_PINECONE_SHINGLE_SLAB = register("yellow_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block LIME_PINECONE_SHINGLES = register("lime_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block LIME_PINECONE_SHINGLE_STAIRS = register("lime_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block LIME_PINECONE_SHINGLE_SLAB = register("lime_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block GREEN_PINECONE_SHINGLES = register("green_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block GREEN_PINECONE_SHINGLE_STAIRS = register("green_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block GREEN_PINECONE_SHINGLE_SLAB = register("green_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block CYAN_PINECONE_SHINGLES = register("cyan_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block CYAN_PINECONE_SHINGLE_STAIRS = register("cyan_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block CYAN_PINECONE_SHINGLE_SLAB = register("cyan_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block LIGHT_BLUE_PINECONE_SHINGLES = register("light_blue_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block LIGHT_BLUE_PINECONE_SHINGLE_STAIRS = register("light_blue_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block LIGHT_BLUE_PINECONE_SHINGLE_SLAB = register("light_blue_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block BLUE_PINECONE_SHINGLES = register("blue_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block BLUE_PINECONE_SHINGLE_STAIRS = register("blue_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block BLUE_PINECONE_SHINGLE_SLAB = register("blue_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block PURPLE_PINECONE_SHINGLES = register("purple_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block PURPLE_PINECONE_SHINGLE_STAIRS = register("purple_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block PURPLE_PINECONE_SHINGLE_SLAB = register("purple_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block MAGENTA_PINECONE_SHINGLES = register("magenta_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block MAGENTA_PINECONE_SHINGLE_STAIRS = register("magenta_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block MAGENTA_PINECONE_SHINGLE_SLAB = register("magenta_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));
    public static final Block PINK_PINECONE_SHINGLES = register("pink_pinecone_shingles", new Block(Properties.PINECONE_BLOCK));
    public static final Block PINK_PINECONE_SHINGLE_STAIRS = register("pink_pinecone_shingle_stairs", new StairBlock(PINECONE_SHINGLES.defaultBlockState(), Properties.PINECONE_BLOCK));
    public static final Block PINK_PINECONE_SHINGLE_SLAB = register("pink_pinecone_shingle_slab", new SlabBlock(Properties.PINECONE_BLOCK));

    // Icicle Blocks //
    public static final Block ICICLES = register("icicles", new IciclesBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).noOcclusion()));
    public static final Block ICICLE_BLOCK = register("icicle_block", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f)));
    public static final Block CHISELED_ICICLE_BLOCK = register("chiseled_icicle_block", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f)));
    public static final Block ICICLE_DOOR = register("icicle_door", new DoorBlock(Block.Properties.of().mapColor(MapColor.ICE).strength(3f).sound(SoundType.GLASS).noOcclusion(), Properties.ICICLE_SET));
    public static final Block ICICLE_TRAPDOOR = register("icicle_trapdoor", new TrapDoorBlock(Block.Properties.of().mapColor(MapColor.ICE).strength(3f).sound(SoundType.GLASS).noOcclusion().isValidSpawn(PropertyUtil::never), Properties.ICICLE_SET));
    public static final Block ICICLE_BARS = register("icicle_bars", new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).strength(2f)));
    public static final Block ICE_LANTERN = register("ice_lantern", new IceLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(s -> 13)));
    public static final Block ICE_CHAIN = register("ice_chain", new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    // Shale //
    public static final Block SHALE = register("shale", new Block(Properties.SHALE));
    public static final Block SHALE_STAIRS = register("shale_stairs", new StairBlock(SHALE.defaultBlockState(), Properties.SHALE));
    public static final Block SHALE_SLAB = register("shale_slab", new SlabBlock(Properties.SHALE));
    public static final Block SHALE_WALL = register("shale_wall", new WallBlock(Properties.SHALE));

    public static final Block POLISHED_SHALE = register("polished_shale", new Block(Properties.SHALE));
    public static final Block POLISHED_SHALE_STAIRS = register("polished_shale_stairs", new StairBlock(POLISHED_SHALE.defaultBlockState(), Properties.SHALE));
    public static final Block POLISHED_SHALE_SLAB = register("polished_shale_slab", new SlabBlock(Properties.SHALE));
    public static final Block POLISHED_SHALE_WALL = register("polished_shale_wall", new WallBlock(Properties.SHALE));

    public static final Block POLISHED_SHALE_BRICKS = register("polished_shale_bricks", new Block(Properties.SHALE));
    public static final Block ICY_POLISHED_SHALE_BRICKS = register("icy_polished_shale_bricks", new Block(Properties.SHALE));
    public static final Block CHISELED_POLISHED_SHALE_BRICKS = register("chiseled_polished_shale_bricks", new Block(Properties.SHALE));
    public static final Block POLISHED_SHALE_BRICK_STAIRS = register("polished_shale_brick_stairs", new StairBlock(POLISHED_SHALE_BRICKS.defaultBlockState(), Properties.SHALE));
    public static final Block POLISHED_SHALE_BRICK_SLAB = register("polished_shale_brick_slab", new SlabBlock(Properties.SHALE));
    public static final Block POLISHED_SHALE_BRICK_WALL = register("polished_shale_brick_wall", new WallBlock(Properties.SHALE));

    // Packed Ice Blocks //
    public static final Block PACKED_ICE_STAIRS = register("packed_ice_stairs", new StairBlock(Blocks.PACKED_ICE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final Block PACKED_ICE_SLAB = register("packed_ice_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));

    public static final Block PACKED_ICE_BRICKS = register("packed_ice_bricks", new Block(Properties.ICE_BRICKS));
    public static final Block CHISELED_PACKED_ICE_BRICKS = register("chiseled_packed_ice_bricks", new Block(Properties.ICE_BRICKS));
    public static final Block PACKED_ICE_BRICK_STAIRS = register("packed_ice_brick_stairs", new StairBlock(PACKED_ICE_BRICKS.defaultBlockState(), Properties.ICE_BRICKS));
    public static final Block PACKED_ICE_BRICK_SLAB = register("packed_ice_brick_slab", new SlabBlock(Properties.ICE_BRICKS));
    public static final Block PACKED_ICE_BRICK_WALL = register("packed_ice_brick_wall", new WallBlock(Properties.ICE_BRICKS));

    // Blue Ice Blocks //
    public static final Block BLUE_ICE_STAIRS = register("blue_ice_stairs", new StairBlock(Blocks.BLUE_ICE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BLUE_ICE)));
    public static final Block BLUE_ICE_SLAB = register("blue_ice_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_ICE)));

    public static final Block BLUE_ICE_BRICKS = register("blue_ice_bricks", new Block(Properties.ICE_BRICKS));
    public static final Block CHISELED_BLUE_ICE_BRICKS = register("chiseled_blue_ice_bricks", new Block(Properties.ICE_BRICKS));
    public static final Block BLUE_ICE_BRICK_STAIRS = register("blue_ice_brick_stairs", new StairBlock(BLUE_ICE_BRICKS.defaultBlockState(), Properties.ICE_BRICKS));
    public static final Block BLUE_ICE_BRICK_SLAB = register("blue_ice_brick_slab", new SlabBlock(Properties.ICE_BRICKS));
    public static final Block BLUE_ICE_BRICK_WALL = register("blue_ice_brick_wall", new WallBlock(Properties.ICE_BRICKS));

    // Snow Blocks //
    public static final Block SNOW_STAIRS = register("snow_stairs", new StairBlock(Blocks.SNOW_BLOCK.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));
    public static final Block SNOW_SLAB = register("snow_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK)));

    public static final Block SNOW_BRICKS = register("snow_bricks", new Block(Properties.SNOW_BRICKS));
    public static final Block SNOW_BRICK_STAIRS = register("snow_brick_stairs", new StairBlock(SNOW_BRICKS.defaultBlockState(), Properties.SNOW_BRICKS));
    public static final Block SNOW_BRICK_SLAB = register("snow_brick_slab", new SlabBlock(Properties.SNOW_BRICKS));
    public static final Block SNOW_BRICK_WALL = register("snow_brick_wall", new WallBlock(Properties.SNOW_BRICKS));

    public static final Block SUSPICIOUS_SNOW = register("suspicious_snow", new SuspiciousSnowBlock(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK).sound(WindsweptSoundTypes.SUSPICIOUS_SNOW)));

    // Candy Cane Blocks //
    public static final Block CANDY_CANE_BLOCK = register("candy_cane_block", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_PILLAR)));

    // Ginger Blocks //
    public static final Block GINGER_SOIL = register("ginger_soil", new GingerSoilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(.5f).sound(SoundType.GRAVEL)));
    public static final Block GINGER = rawRegister("ginger", new GingerCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final Block GINGERBREAD_BLOCK = register("gingerbread_block", new Block(Properties.GINGERBREAD));
    public static final Block GLAZED_GINGERBREAD_BLOCK = register("glazed_gingerbread_block", new Block(Properties.GINGERBREAD));
    public static final Block GINGERBREAD_COOKIE_BLOCK = register("gingerbread_cookie_block", new Block(Properties.GINGERBREAD));

    public static final Block GINGERBREAD_DOOR = register("gingerbread_door", new DoorBlock(Properties.PINE.door(), Properties.GINGERBREAD_SET));
    public static final Block GINGERBREAD_TRAPDOOR = register("gingerbread_trapdoor", new TrapDoorBlock(Properties.PINE.trapdoor(), Properties.GINGERBREAD_SET));

    public static final Block GINGERBREAD_BRICKS = register("gingerbread_bricks", new Block(Properties.GINGERBREAD));
    public static final Block GINGERBREAD_BRICK_STAIRS = register("gingerbread_brick_stairs", new StairBlock(GINGERBREAD_BRICKS.defaultBlockState(), Properties.GINGERBREAD));
    public static final Block GINGERBREAD_BRICK_SLAB = register("gingerbread_brick_slab", new SlabBlock(Properties.GINGERBREAD));
    public static final Block GINGERBREAD_BRICK_WALL = register("gingerbread_brick_wall", new WallBlock(Properties.GINGERBREAD));

    public static final Block GLAZED_GINGERBREAD_BRICKS = register("glazed_gingerbread_bricks", new Block(Properties.GINGERBREAD));
    public static final Block GLAZED_GINGERBREAD_BRICK_STAIRS = register("glazed_gingerbread_brick_stairs", new StairBlock(GLAZED_GINGERBREAD_BRICKS.defaultBlockState(), Properties.GINGERBREAD));
    public static final Block GLAZED_GINGERBREAD_BRICK_SLAB = register("glazed_gingerbread_brick_slab", new SlabBlock(Properties.GINGERBREAD));
    public static final Block GLAZED_GINGERBREAD_BRICK_WALL = register("glazed_gingerbread_brick_wall", new WallBlock(Properties.GINGERBREAD));

    // Lunalite //
    public static final Block LUNALITE = register("lunalite", new LunaliteBlock(Properties.LUNALITE));
    public static final Block LUNALITE_STAIRS = register("lunalite_stairs", new StairBlock(LUNALITE.defaultBlockState(), Properties.LUNALITE));
    public static final Block LUNALITE_SLAB = register("lunalite_slab", new LunaliteSlabBlock(Properties.LUNALITE));
    public static final Block LUNALITE_WALL = register("lunalite_wall", new WallBlock(Properties.LUNALITE));

    public static final Block CUT_LUNALITE = register("cut_lunalite", new Block(Properties.LUNALITE));
    public static final Block CUT_LUNALITE_STAIRS = register("cut_lunalite_stairs", new StairBlock(CUT_LUNALITE.defaultBlockState(), Properties.LUNALITE));
    public static final Block CUT_LUNALITE_SLAB = register("cut_lunalite_slab", new SlabBlock(Properties.LUNALITE));
    public static final Block CUT_LUNALITE_WALL = register("cut_lunalite_wall", new WallBlock(Properties.LUNALITE));

    public static final Block CUT_LUNALITE_BRICKS = register("cut_lunalite_bricks", new Block(Properties.LUNALITE));
    public static final Block CHISELED_CUT_LUNALITE_BRICKS = register("chiseled_cut_lunalite_bricks", new Block(Properties.LUNALITE));
    public static final Block CUT_LUNALITE_BRICK_STAIRS = register("cut_lunalite_brick_stairs", new StairBlock(CUT_LUNALITE_BRICKS.defaultBlockState(), Properties.LUNALITE));
    public static final Block CUT_LUNALITE_BRICK_SLAB = register("cut_lunalite_brick_slab", new SlabBlock(Properties.LUNALITE));
    public static final Block CUT_LUNALITE_BRICK_WALL = register("cut_lunalite_brick_wall", new WallBlock(Properties.LUNALITE));

    public static final Block SMOOTH_LUNALITE = register("smooth_lunalite", new Block(Properties.LUNALITE));
    public static final Block SMOOTH_LUNALITE_STAIRS = register("smooth_lunalite_stairs", new StairBlock(SMOOTH_LUNALITE.defaultBlockState(), Properties.LUNALITE));
    public static final Block SMOOTH_LUNALITE_SLAB = register("smooth_lunalite_slab", new SlabBlock(Properties.LUNALITE));

    // Dry Mossy Blocks //
    public static final Block DRY_MOSSY_COBBLESTONE = register("dry_mossy_cobblestone", new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final Block DRY_MOSSY_COBBLESTONE_STAIRS = register("dry_mossy_cobblestone_stairs", new StairBlock(DRY_MOSSY_COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final Block DRY_MOSSY_COBBLESTONE_SLAB = register("dry_mossy_cobblestone_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static final Block DRY_MOSSY_COBBLESTONE_WALL = register("dry_mossy_cobblestone_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));

    public static final Block DRY_MOSSY_STONE_BRICKS = register("dry_mossy_stone_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_STONE_BRICK_STAIRS = register("dry_mossy_stone_brick_stairs", new StairBlock(DRY_MOSSY_STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_STONE_BRICK_SLAB = register("dry_mossy_stone_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_STONE_BRICK_WALL = register("dry_mossy_stone_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    public static final Block DRY_MOSSY_COBBLESTONE_BRICKS = register("dry_mossy_cobblestone_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_BRICK_STAIRS = register("dry_mossy_cobblestone_brick_stairs", new StairBlock(DRY_MOSSY_COBBLESTONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_BRICK_SLAB = register("dry_mossy_cobblestone_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_BRICK_WALL = register("dry_mossy_cobblestone_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    public static final Block DRY_MOSSY_COBBLESTONE_TILES = register("dry_mossy_cobblestone_tiles", new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_TILE_STAIRS = register("dry_mossy_cobblestone_tile_stairs", new StairBlock(DRY_MOSSY_COBBLESTONE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_TILE_SLAB = register("dry_mossy_cobblestone_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static final Block DRY_MOSSY_COBBLESTONE_TILE_WALL = register("dry_mossy_cobblestone_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    // Compressed Blocks //
    public static final Block CHESTNUT_CRATE = HELPER.createFuelBlock("chestnut_crate", new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final Block ROASTED_CHESTNUT_CRATE = HELPER.createFuelBlock("roasted_chestnut_crate", new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final Block GINGER_ROOT_CRATE = HELPER.createFuelBlock("ginger_root_crate", new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final Block HOLLY_BERRY_BASKET = HELPER.createFuelBlock("holly_berry_basket", new WindsweptCompressedBlock(Properties.HOLLY_BERRY_BASKET), 300);
    public static final Block WILD_BERRY_BASKET = HELPER.createFuelBlock("wild_berry_basket", new WindsweptCompressedBlock(Properties.CRATE), 300);
    public static final Block FROZEN_FLESH_BLOCK = register("frozen_flesh_block", new Block(BlockBehaviour.Properties.of().strength(.8f).sound(SoundType.CORAL_BLOCK)));

    // Pots //
    public static final Block POTTED_RED_ROSE = rawRegister("potted_red_rose", new FlowerPotBlock(RED_ROSE, PropertyUtil.flowerPot()));
    public static final Block POTTED_BLUE_ROSE = rawRegister("potted_blue_rose", new FlowerPotBlock(BLUE_ROSE, PropertyUtil.flowerPot()));
    public static final Block POTTED_WHITE_ROSE = rawRegister("potted_white_rose", new FlowerPotBlock(WHITE_ROSE, PropertyUtil.flowerPot()));
    public static final Block POTTED_YELLOW_ROSE = rawRegister("potted_yellow_rose", new FlowerPotBlock(YELLOW_ROSE, PropertyUtil.flowerPot()));
    public static final Block POTTED_FOXGLOVE = rawRegister("potted_foxglove", new FlowerPotBlock(FOXGLOVE, PropertyUtil.flowerPot()));
    public static final Block POTTED_BLUEBELLS = rawRegister("potted_bluebells", new FlowerPotBlock(BLUEBELLS, PropertyUtil.flowerPot()));
    public static final Block POTTED_SNOWDROP = rawRegister("potted_snowdrop", new FlowerPotBlock(SNOWDROP, PropertyUtil.flowerPot()));
    public static final Block POTTED_MOSS_CAMPION = rawRegister("potted_moss_campion", new FlowerPotBlock(MOSS_CAMPION, PropertyUtil.flowerPot()));
    public static final Block POTTED_WILD_GINGER = rawRegister("potted_wild_ginger", new FlowerPotBlock(WILD_GINGER, PropertyUtil.flowerPot()));
    public static final Block POTTED_NIGHTSHADE = rawRegister("potted_nightshade", new NightShadeFlowerPotBlock(NIGHTSHADE, BlockBehaviour.Properties.of().instabreak().noOcclusion().lightLevel(state -> 9)));
    public static final Block POTTED_SNOWY_SPROUTS = rawRegister("potted_snowy_sprouts", new FlowerPotBlock(SNOWY_SPROUTS, PropertyUtil.flowerPot()));
    public static final Block POTTED_GELISOL_GRASS = rawRegister("potted_gelisol_grass", new FlowerPotBlock(GELISOL_GRASS, PropertyUtil.flowerPot()));
    public static final Block POTTED_DRY_MOSSY_SPROUTS = rawRegister("potted_dry_mossy_sprouts", new FlowerPotBlock(DRY_MOSSY_SPROUTS, PropertyUtil.flowerPot()));
    public static final Block POTTED_MOSSY_SPROUTS = rawRegister("potted_mossy_sprouts", new FlowerPotBlock(MOSSY_SPROUTS, PropertyUtil.flowerPot()));
    public static final Block POTTED_LAVENDER = rawRegister("potted_lavender", new FlowerPotBlock(LAVENDER, PropertyUtil.flowerPot()));
    public static final Block POTTED_MIMOSA = rawRegister("potted_mimosa", new FlowerPotBlock(MIMOSA, PropertyUtil.flowerPot()));
    
    // Misc //
    public static final Block WILD_BERRY_BUSH = rawRegister("wild_berry_bush", new WildBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).offsetType(BlockBehaviour.OffsetType.XZ)));

    private static Block register(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Windswept.id(name), new BlockItem(block, new Item.Properties()));
        return rawRegister(name, block);
    }
    
    private static Block rawRegister(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Windswept.id(name), block);
    }

    public static void init() {

    }


    public static class Properties {
        // Block Sets //
        public static final BlockSetType HOLLY_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Windswept.MOD_ID + ":holly", true, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON));
        public static final BlockSetType CHESTNUT_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Windswept.MOD_ID + ":chestnut"));
        public static final BlockSetType PINE_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Windswept.MOD_ID + ":pine"));
        public static final BlockSetType ICICLE_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Windswept.MOD_ID + ":icicles", true, SoundType.GLASS, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
        public static final BlockSetType GINGERBREAD_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Windswept.MOD_ID + ":gingerbread", true, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON));

        public static final WoodType HOLLY_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Windswept.MOD_ID + ":holly", HOLLY_BLOCK_SET, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN));
        public static final WoodType CHESTNUT_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Windswept.MOD_ID + ":chestnut", CHESTNUT_BLOCK_SET));
        public static final WoodType PINE_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Windswept.MOD_ID + ":pine", PINE_BLOCK_SET));
        public static final PropertyUtil.WoodSetProperties HOLLY = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).logSound(SoundType.CHERRY_WOOD).build();
        public static final PropertyUtil.WoodSetProperties CHESTNUT = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_BROWN).build();
        public static final PropertyUtil.WoodSetProperties PINE = PropertyUtil.WoodSetProperties.builder(MapColor.TERRACOTTA_BROWN).build();

        // Blocks //
        public static final BlockBehaviour.Properties SNOW_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(.85f).sound(SoundType.SNOW);
        public static final BlockBehaviour.Properties ICE_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(2.8f).sound(SoundType.STONE);
        public static final BlockBehaviour.Properties CRATE = BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties HOLLY_BERRY_BASKET = BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.CHERRY_WOOD);
        public static final BlockBehaviour.Properties SPROUTS = BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).replaceable();
        public static final BlockBehaviour.Properties PINECONE_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2f, 3f).sound(WindsweptSoundTypes.PINECONE);
        public static final BlockBehaviour.Properties SHALE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5f, 1f);
        public static final BlockBehaviour.Properties LUNALITE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(.8f);
        public static final BlockBehaviour.Properties GINGERBREAD = Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(2f, 3f).sound(SoundType.CHERRY_WOOD);
        public static final BlockBehaviour.Properties ELDER_ORNAMENT = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(.1f).noOcclusion().noCollission().sound(SoundType.AZALEA);
        public static final BlockBehaviour.Properties LAVENDER_THATCH = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(.5f).sound(SoundType.NETHER_SPROUTS).noOcclusion();
    }

}
