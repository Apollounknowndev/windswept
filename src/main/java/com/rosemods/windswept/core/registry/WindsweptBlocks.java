package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.block.*;
import com.rosemods.windswept.common.block.grower.ChestnutTreeGrower;
import com.rosemods.windswept.common.block.grower.FloweringAcaciaTreeGrower;
import com.rosemods.windswept.common.block.grower.HollyTreeGrower;
import com.rosemods.windswept.common.block.grower.PineTreeGrower;
import com.rosemods.windswept.common.item.WearableBlockItem;
import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.duck.BlockEntityTypeDuck;
import com.rosemods.windswept.core.mixin.BlockSetTypeAccessor;
import com.rosemods.windswept.core.mixin.WoodTypeAccessor;
import com.rosemods.windswept.core.other.WindsweptSoundTypes;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Consumer;

public class WindsweptBlocks {

    // Holly //
    public static final Block HOLLY_LOG = register("holly_log", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block HOLLY_WOOD = register("holly_wood", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block STRIPPED_HOLLY_LOG = register("stripped_holly_log", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block STRIPPED_HOLLY_WOOD = register("stripped_holly_wood", new RotatedPillarBlock(Properties.HOLLY.log()));
    public static final Block HOLLY_PLANKS = register("holly_planks", new Block(Properties.HOLLY.planks()));
    public static final Block HOLLY_STAIRS = register("holly_stairs", new StairBlock(HOLLY_PLANKS.defaultBlockState(), Properties.HOLLY.planks()));
    public static final Block HOLLY_SLAB = register("holly_slab", new SlabBlock(Properties.HOLLY.planks()));
    public static final Block HOLLY_FENCE = register("holly_fence", new FenceBlock(Properties.HOLLY.planks()));
    public static final Block HOLLY_FENCE_GATE = register("holly_fence_gate", new FenceGateBlock(Properties.HOLLY.planks(), Properties.HOLLY_WOOD_TYPE));
    public static final Block HOLLY_PRESSURE_PLATE = register("holly_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.HOLLY.pressurePlate().sound(SoundType.CHERRY_WOOD), Properties.HOLLY_BLOCK_SET));
    public static final Block HOLLY_BUTTON = register("holly_button", new ButtonBlock(Properties.HOLLY.button(), Properties.HOLLY_BLOCK_SET, 30, true));
    public static final Block HOLLY_DOOR = register("holly_door", new DoorBlock(Properties.HOLLY.door(), Properties.HOLLY_BLOCK_SET));
    public static final Block HOLLY_TRAPDOOR = register("holly_trapdoor", new TrapDoorBlock(Properties.HOLLY.trapdoor(), Properties.HOLLY_BLOCK_SET));
    public static final Block HOLLY_STANDING_SIGN = rawRegister("holly_sign", new StandingSignBlock(Properties.HOLLY.sign().sound(SoundType.CHERRY_WOOD), Properties.HOLLY_WOOD_TYPE));
    public static final Block HOLLY_WALL_SIGN = rawRegister("holly_wall_sign", new WallSignBlock(Properties.HOLLY.sign().sound(SoundType.CHERRY_WOOD), Properties.HOLLY_WOOD_TYPE));
    public static final Block HOLLY_CEILING_HANGING_SIGN = rawRegister("holly_hanging_sign", new CeilingHangingSignBlock(Properties.HOLLY.hangingSign().sound(SoundType.CHERRY_WOOD_HANGING_SIGN), Properties.HOLLY_WOOD_TYPE));
    public static final Block HOLLY_WALL_HANGING_SIGN = rawRegister("holly_wall_hanging_sign", new WallHangingSignBlock(Properties.HOLLY.hangingSign().sound(SoundType.CHERRY_WOOD_HANGING_SIGN), Properties.HOLLY_WOOD_TYPE));

    public static final Block HOLLY_BEEHIVE = register("holly_beehive", new WindsweptBeehiveBlock(Properties.HOLLY.beehive()));
    public static final Block HOLLY_LADDER = register("holly_ladder", new LadderBlock(Properties.HOLLY.ladder()));
    public static final Block HOLLY_BOOKSHELF = register("holly_bookshelf", new Block(Properties.HOLLY.bookshelf()));
    public static final Block HOLLY_BOARDS = register("holly_boards", new RotatedPillarBlock(Properties.HOLLY.planks()));
    public static final Block HOLLY_CHEST = register("holly_chest", new ChestBlock(Properties.HOLLY.chest(), () -> BlockEntityType.CHEST));
    public static final Block TRAPPED_HOLLY_CHEST = register("trapped_holly_chest", new ChestBlock(Properties.HOLLY.chest(), () -> BlockEntityType.TRAPPED_CHEST));

    public static final Block HOLLY_SAPLING = register("holly_sapling", new HollySaplingBlock(new HollyTreeGrower(), Properties.SAPLING));
    public static final Block POTTED_HOLLY_SAPLING = rawRegister("potted_holly_sapling", new FlowerPotBlock(HOLLY_SAPLING, Properties.FLOWER_POT));
    public static final Block HOLLY_LEAVES = register("holly_leaves", new HollyLeavesBlock(Properties.HOLLY.leaves()));

    // Chestnut //
    public static final Block CHESTNUT_LOG = register("chestnut_log", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block CHESTNUT_WOOD = register("chestnut_wood", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block STRIPPED_CHESTNUT_LOG = register("stripped_chestnut_log", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block STRIPPED_CHESTNUT_WOOD = register("stripped_chestnut_wood", new RotatedPillarBlock(Properties.CHESTNUT.log()));
    public static final Block CHESTNUT_PLANKS = register("chestnut_planks", new Block(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_STAIRS = register("chestnut_stairs", new StairBlock(CHESTNUT_PLANKS.defaultBlockState(), Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_SLAB = register("chestnut_slab", new SlabBlock(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_FENCE = register("chestnut_fence", new FenceBlock(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_FENCE_GATE = register("chestnut_fence_gate", new FenceGateBlock(Properties.CHESTNUT.planks(), Properties.CHESTNUT_WOOD_TYPE));
    public static final Block CHESTNUT_PRESSURE_PLATE = register("chestnut_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.CHESTNUT.pressurePlate(), Properties.CHESTNUT_BLOCK_SET));
    public static final Block CHESTNUT_BUTTON = register("chestnut_button", new ButtonBlock(Properties.CHESTNUT.button(), Properties.CHESTNUT_BLOCK_SET, 30, true));
    public static final Block CHESTNUT_DOOR = register("chestnut_door", new DoorBlock(Properties.CHESTNUT.door(), Properties.CHESTNUT_BLOCK_SET));
    public static final Block CHESTNUT_TRAPDOOR = register("chestnut_trapdoor", new TrapDoorBlock(Properties.CHESTNUT.trapdoor(), Properties.CHESTNUT_BLOCK_SET));
    public static final Block CHESTNUT_STANDING_SIGN = rawRegister("chestnut_sign", new StandingSignBlock(Properties.CHESTNUT.sign(), Properties.CHESTNUT_WOOD_TYPE));
    public static final Block CHESTNUT_WALL_SIGN = rawRegister("chestnut_wall_sign", new WallSignBlock(Properties.CHESTNUT.sign(), Properties.CHESTNUT_WOOD_TYPE));
    public static final Block CHESTNUT_CEILING_HANGING_SIGN = rawRegister("chestnut_hanging_sign", new CeilingHangingSignBlock(Properties.CHESTNUT.hangingSign(), Properties.CHESTNUT_WOOD_TYPE));
    public static final Block CHESTNUT_WALL_HANGING_SIGN = rawRegister("chestnut_wall_hanging_sign", new WallHangingSignBlock(Properties.CHESTNUT.hangingSign(), Properties.CHESTNUT_WOOD_TYPE));

    public static final Block CHESTNUT_BEEHIVE = register("chestnut_beehive", new WindsweptBeehiveBlock(Properties.CHESTNUT.beehive()));
    public static final Block CHESTNUT_LADDER = register("chestnut_ladder", new LadderBlock(Properties.CHESTNUT.ladder()));
    public static final Block CHESTNUT_BOOKSHELF = register("chestnut_bookshelf", new Block(Properties.CHESTNUT.bookshelf()));
    public static final Block CHESTNUT_BOARDS = register("chestnut_boards", new RotatedPillarBlock(Properties.CHESTNUT.planks()));
    public static final Block CHESTNUT_CHEST = register("chestnut_chest", new ChestBlock(Properties.CHESTNUT.chest(), () -> BlockEntityType.CHEST));
    public static final Block TRAPPED_CHESTNUT_CHEST = register("trapped_chestnut_chest", new ChestBlock(Properties.CHESTNUT.chest(), () -> BlockEntityType.TRAPPED_CHEST));

    public static final Block CHESTNUT_SAPLING = register("chestnut_sapling", new SaplingBlock(new ChestnutTreeGrower(), Properties.SAPLING));
    public static final Block POTTED_CHESTNUT_SAPLING = rawRegister("potted_chestnut_sapling", new FlowerPotBlock(CHESTNUT_SAPLING, Properties.FLOWER_POT));
    public static final Block CHESTNUT_LEAVES = register("chestnut_leaves", new LeavesBlock(Properties.CHESTNUT.leaves()));

    // Pine //
    public static final Block PINE_LOG = register("pine_log", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block PINE_WOOD = register("pine_wood", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block WEATHERED_PINE_LOG = register("weathered_pine_log", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block WEATHERED_PINE_WOOD = register("weathered_pine_wood", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block STRIPPED_PINE_LOG = register("stripped_pine_log", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block STRIPPED_PINE_WOOD = register("stripped_pine_wood", new RotatedPillarBlock(Properties.PINE.log()));
    public static final Block PINE_PLANKS = register("pine_planks", new Block(Properties.PINE.planks()));
    public static final Block PINE_STAIRS = register("pine_stairs", new StairBlock(PINE_PLANKS.defaultBlockState(), Properties.PINE.planks()));
    public static final Block PINE_SLAB = register("pine_slab", new SlabBlock(Properties.PINE.planks()));
    public static final Block PINE_FENCE = register("pine_fence", new FenceBlock(Properties.PINE.planks()));
    public static final Block PINE_FENCE_GATE = register("pine_fence_gate", new FenceGateBlock(Properties.PINE.planks(), Properties.PINE_WOOD_TYPE));
    public static final Block PINE_PRESSURE_PLATE = register("pine_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PINE.pressurePlate(), Properties.PINE_BLOCK_SET));
    public static final Block PINE_BUTTON = register("pine_button", new ButtonBlock(Properties.PINE.button(), Properties.PINE_BLOCK_SET, 30, true));
    public static final Block PINE_DOOR = register("pine_door", new DoorBlock(Properties.PINE.door(), Properties.PINE_BLOCK_SET));
    public static final Block PINE_TRAPDOOR = register("pine_trapdoor", new TrapDoorBlock(Properties.PINE.trapdoor(), Properties.PINE_BLOCK_SET));
    public static final Block PINE_STANDING_SIGN = rawRegister("pine_sign", new StandingSignBlock(Properties.PINE.sign(), Properties.PINE_WOOD_TYPE));
    public static final Block PINE_WALL_SIGN = rawRegister("pine_wall_sign", new WallSignBlock(Properties.PINE.sign(), Properties.PINE_WOOD_TYPE));
    public static final Block PINE_CEILING_HANGING_SIGN = rawRegister("pine_hanging_sign", new CeilingHangingSignBlock(Properties.PINE.hangingSign(), Properties.PINE_WOOD_TYPE));
    public static final Block PINE_WALL_HANGING_SIGN = rawRegister("pine_wall_hanging_sign", new WallHangingSignBlock(Properties.PINE.hangingSign(), Properties.PINE_WOOD_TYPE));

    public static final Block PINE_BEEHIVE = register("pine_beehive", new WindsweptBeehiveBlock(Properties.PINE.beehive()));
    public static final Block PINE_LADDER = register("pine_ladder", new LadderBlock(Properties.PINE.ladder()));
    public static final Block PINE_BOOKSHELF = register("pine_bookshelf", new Block(Properties.PINE.bookshelf()));
    public static final Block PINE_BOARDS = register("pine_boards", new RotatedPillarBlock(Properties.PINE.planks()));
    public static final Block PINE_CHEST = register("pine_chest", new ChestBlock(Properties.PINE.chest(), () -> BlockEntityType.CHEST));
    public static final Block TRAPPED_PINE_CHEST = register("trapped_pine_chest", new ChestBlock(Properties.PINE.chest(), () -> BlockEntityType.TRAPPED_CHEST));

    public static final Block PINE_SAPLING = register("pine_sapling", new SaplingBlock(new PineTreeGrower(), Properties.SAPLING));
    public static final Block POTTED_PINE_SAPLING = rawRegister("potted_pine_sapling", new FlowerPotBlock(PINE_SAPLING, Properties.FLOWER_POT));
    public static final Block PINE_LEAVES = register("pine_leaves", new LeavesBlock(Properties.PINE.leaves()));

    // Moss //
    public static final Block MOSSY_SPROUTS = register("mossy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block DRY_MOSSY_SPROUTS = register("dry_mossy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block DRY_MOSS_CARPET = register("dry_moss_carpet", new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET)));
    public static final Block DRY_MOSS_BLOCK = register("dry_moss_block", new DryMossBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));

    // Gelisol Blocks //
    public static final Block GELISOL_GRASS = register("gelisol_grass", new SproutsBlock(Properties.SPROUTS));
    public static final Block GELISOL = register("gelisol", new GelisolBlock(BlockBehaviour.Properties.copy(Blocks.PODZOL)));
    public static final Block GELISOL_PATH = register("gelisol_path", new DirtPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));

    // Tall Flowers//
    public static final Block LUPINE = register("lupine", new TallFlowerBlock(Properties.FLOWER));
    public static final Block LIONS_TAIL = register("lions_tail", new TallFlowerBlock(Properties.FLOWER));
    public static final Block RED_ROSE_BUSH = register("red_rose_bush", new TallFlowerBlock(Properties.FLOWER));
    public static final Block BLUE_ROSE_BUSH = register("blue_rose_bush", new TallFlowerBlock(Properties.FLOWER));
    public static final Block WHITE_ROSE_BUSH = register("white_rose_bush", new TallFlowerBlock(Properties.FLOWER));
    public static final Block YELLOW_ROSE_BUSH = register("yellow_rose_bush", new TallFlowerBlock(Properties.FLOWER));

    // Plants //
    public static final Block RED_ROSE = register("red_rose", new RoseFlowerBlock(WindsweptBlocks.RED_ROSE_BUSH, MobEffects.WITHER, 5, Properties.FLOWER));
    public static final Block BLUE_ROSE = register("blue_rose", new RoseFlowerBlock(WindsweptBlocks.BLUE_ROSE_BUSH, MobEffects.WITHER, 5, Properties.FLOWER));
    public static final Block WHITE_ROSE = register("white_rose", new RoseFlowerBlock(WindsweptBlocks.WHITE_ROSE_BUSH, MobEffects.WITHER, 5, Properties.FLOWER));
    public static final Block YELLOW_ROSE = register("yellow_rose", new RoseFlowerBlock(WindsweptBlocks.YELLOW_ROSE_BUSH, MobEffects.WITHER, 5, Properties.FLOWER));
    public static final Block FOXGLOVE = register("foxglove", new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5, Properties.FLOWER));
    public static final Block BLUEBELLS = register("bluebells", new FlowerBlock(MobEffects.SLOW_FALLING, 5, Properties.FLOWER));
    public static final Block SNOWY_SPROUTS = register("snowy_sprouts", new SproutsBlock(Properties.SPROUTS));
    public static final Block SNOWDROP = register("snowdrop", new SnowdropBlock(WindsweptEffects.FROST_RESISTANCE, 5, Properties.FLOWER.sound(SoundType.NETHER_SPROUTS)));
    public static final Block MOSS_CAMPION = register("moss_campion", new MossCampionBlock(WindsweptEffects.THORNS, 5, Properties.FLOWER.sound(SoundType.AZALEA)));
    public static final Block WILD_GINGER = register("wild_ginger", new FlowerBlock(MobEffects.DAMAGE_BOOST, 5, Properties.FLOWER));
    public static final Block NIGHTSHADE = register("nightshade", new NightshadeFlowerBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(state -> 9)));
    public static final Block MIMOSA = register("mimosa", new MimosaBlock(MobEffects.FIRE_RESISTANCE, 5, Properties.FLOWER.sound(SoundType.NETHER_SPROUTS)));

    // Lavender //
    public static final Block LAVENDER = register("lavender", new LavenderBlock(Properties.FLOWER.sound(SoundType.AZALEA).randomTicks()));
    public static final Block LAVENDER_BALE = register("lavender_bale", new LavenderBaleBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));
    public static final Block LAVENDER_THATCH = register("lavender_thatch", new ThatchBlock(Properties.LAVENDER_THATCH));
    public static final Block LAVENDER_THATCH_STAIRS = register("lavender_thatch_stairs", new ThatchStairsBlock(LAVENDER_THATCH, Properties.LAVENDER_THATCH));
    public static final Block LAVENDER_THATCH_SLAB = register("lavender_thatch_slab", new ThatchSlabBlock(Properties.LAVENDER_THATCH));

    // Acacia //
    public static final Block FLOWERING_ACACIA_SAPLING = register("flowering_acacia_sapling", new SaplingBlock(new FloweringAcaciaTreeGrower(), Properties.SAPLING));
    public static final Block POTTED_FLOWERING_ACACIA_SAPLING = rawRegister("potted_flowering_acacia_sapling", new FlowerPotBlock(FLOWERING_ACACIA_SAPLING, Properties.FLOWER_POT));
    public static final Block FLOWERING_ACACIA_LEAVES = register("flowering_acacia_leaves", new FloweringAcaciaLeavesBlock(Properties.HOLLY.leaves()));
    public static final Block YELLOW_PETALS = register("yellow_petals", new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));

    // Decoration Blocks //
    //public static final Block HOLLY_WREATH = register("holly_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.HOLLY_WREATH, new Item.Properties()));
    //public static final Block PINECONE_WREATH = register("pinecone_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.PINECONE_WREATH, new Item.Properties()));
    //public static final Block VINE_WREATH = register("vine_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.VINE_WREATH, new Item.Properties()));
    //public static final Block CHERRY_WREATH = register("cherry_wreath", new WallDecorationBlock(Block.Properties.of().instabreak().sound(SoundType.AZALEA).noCollission()), new WearableBlockItem(WindsweptBlocks.CHERRY_WREATH, new Item.Properties()));
    public static final Block CHRISTMAS_PUDDING = rawRegister("christmas_pudding", new ChristmasPuddingBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion()));
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
    public static final Block CARVED_PINECONE_BLOCK = rawRegister("carved_pinecone_block", new CarvedPineconeBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK).randomTicks()));
    public static final Block WILL_O_THE_WISP = register("will_o_the_wisp", new WillOTheWispBlock(BlockBehaviour.Properties.copy(PINECONE_BLOCK).lightLevel(s -> 10)), new Item(new Item.Properties().rarity(Rarity.RARE)));

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
    public static final Block ICICLE_TRAPDOOR = register("icicle_trapdoor", new TrapDoorBlock(Block.Properties.of().mapColor(MapColor.ICE).strength(3f).sound(SoundType.GLASS).noOcclusion().isValidSpawn(Blocks::never), Properties.ICICLE_SET));
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
    public static final Block GINGER_SOIL = register("ginger_soil", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(.5f).sound(SoundType.GRAVEL)));
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
    public static final Block CHESTNUT_CRATE = register("chestnut_crate", new WindsweptCompressedBlock(Properties.CRATE));
    public static final Block ROASTED_CHESTNUT_CRATE = register("roasted_chestnut_crate", new WindsweptCompressedBlock(Properties.CRATE));
    public static final Block GINGER_ROOT_CRATE = register("ginger_root_crate", new WindsweptCompressedBlock(Properties.CRATE));
    public static final Block HOLLY_BERRY_BASKET = register("holly_berry_basket", new WindsweptCompressedBlock(Properties.HOLLY_BERRY_BASKET));
    public static final Block WILD_BERRY_BASKET = register("wild_berry_basket", new WindsweptCompressedBlock(Properties.CRATE));
    public static final Block FROZEN_FLESH_BLOCK = register("frozen_flesh_block", new Block(BlockBehaviour.Properties.of().strength(.8f).sound(SoundType.CORAL_BLOCK)));

    // Pots //
    public static final Block POTTED_RED_ROSE = rawRegister("potted_red_rose", new FlowerPotBlock(RED_ROSE, Properties.FLOWER_POT));
    public static final Block POTTED_BLUE_ROSE = rawRegister("potted_blue_rose", new FlowerPotBlock(BLUE_ROSE, Properties.FLOWER_POT));
    public static final Block POTTED_WHITE_ROSE = rawRegister("potted_white_rose", new FlowerPotBlock(WHITE_ROSE, Properties.FLOWER_POT));
    public static final Block POTTED_YELLOW_ROSE = rawRegister("potted_yellow_rose", new FlowerPotBlock(YELLOW_ROSE, Properties.FLOWER_POT));
    public static final Block POTTED_FOXGLOVE = rawRegister("potted_foxglove", new FlowerPotBlock(FOXGLOVE, Properties.FLOWER_POT));
    public static final Block POTTED_BLUEBELLS = rawRegister("potted_bluebells", new FlowerPotBlock(BLUEBELLS, Properties.FLOWER_POT));
    public static final Block POTTED_SNOWDROP = rawRegister("potted_snowdrop", new FlowerPotBlock(SNOWDROP, Properties.FLOWER_POT));
    public static final Block POTTED_MOSS_CAMPION = rawRegister("potted_moss_campion", new FlowerPotBlock(MOSS_CAMPION, Properties.FLOWER_POT));
    public static final Block POTTED_WILD_GINGER = rawRegister("potted_wild_ginger", new FlowerPotBlock(WILD_GINGER, Properties.FLOWER_POT));
    public static final Block POTTED_NIGHTSHADE = rawRegister("potted_nightshade", new NightShadeFlowerPotBlock(NIGHTSHADE, BlockBehaviour.Properties.of().instabreak().noOcclusion().lightLevel(state -> 9)));
    public static final Block POTTED_SNOWY_SPROUTS = rawRegister("potted_snowy_sprouts", new FlowerPotBlock(SNOWY_SPROUTS, Properties.FLOWER_POT));
    public static final Block POTTED_GELISOL_GRASS = rawRegister("potted_gelisol_grass", new FlowerPotBlock(GELISOL_GRASS, Properties.FLOWER_POT));
    public static final Block POTTED_DRY_MOSSY_SPROUTS = rawRegister("potted_dry_mossy_sprouts", new FlowerPotBlock(DRY_MOSSY_SPROUTS, Properties.FLOWER_POT));
    public static final Block POTTED_MOSSY_SPROUTS = rawRegister("potted_mossy_sprouts", new FlowerPotBlock(MOSSY_SPROUTS, Properties.FLOWER_POT));
    public static final Block POTTED_LAVENDER = rawRegister("potted_lavender", new FlowerPotBlock(LAVENDER, Properties.FLOWER_POT));
    public static final Block POTTED_MIMOSA = rawRegister("potted_mimosa", new FlowerPotBlock(MIMOSA, Properties.FLOWER_POT));
    
    // Misc //
    public static final Block WILD_BERRY_BUSH = rawRegister("wild_berry_bush", new WildBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).offsetType(BlockBehaviour.OffsetType.XZ)));

    private static Block register(String name, Block block) {
        return register(name, block, new BlockItem(block, new Item.Properties()));
    }

    private static Block register(String name, Block block, Item item) {
        Registry.register(BuiltInRegistries.ITEM, Windswept.id(name), item);
        if (item instanceof BlockItem) {
            Item.BY_BLOCK.put(block, item);
        }
        return rawRegister(name, block);
    }
    
    private static Block rawRegister(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Windswept.id(name), block);
    }

    public static void init() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(CHESTNUT_CRATE, 300);
        registry.add(GINGER_ROOT_CRATE, 300);
        registry.add(ROASTED_CHESTNUT_CRATE, 300);
        registry.add(HOLLY_BERRY_BASKET, 300);
        registry.add(WILD_BERRY_BASKET, 300);
        registry.add(HOLLY_FENCE, 300);
        registry.add(HOLLY_FENCE_GATE, 300);
        registry.add(HOLLY_LADDER, 300);
        registry.add(HOLLY_BOOKSHELF, 300);
        registry.add(CHESTNUT_FENCE, 300);
        registry.add(CHESTNUT_FENCE_GATE, 300);
        registry.add(CHESTNUT_LADDER, 300);
        registry.add(CHESTNUT_BOOKSHELF, 300);
        registry.add(PINE_FENCE, 300);
        registry.add(PINE_FENCE_GATE, 300);
        registry.add(PINE_LADDER, 300);
        registry.add(PINE_BOOKSHELF, 300);

        ((BlockEntityTypeDuck) BlockEntityType.BEEHIVE).addBlocks(HOLLY_BEEHIVE, CHESTNUT_BEEHIVE, PINE_BEEHIVE);
        ((BlockEntityTypeDuck) BlockEntityType.SIGN).addBlocks(
            HOLLY_STANDING_SIGN, HOLLY_WALL_SIGN,
            CHESTNUT_STANDING_SIGN, CHESTNUT_WALL_SIGN,
            PINE_STANDING_SIGN, PINE_WALL_SIGN
        );
        ((BlockEntityTypeDuck) BlockEntityType.HANGING_SIGN).addBlocks(
            HOLLY_CEILING_HANGING_SIGN, HOLLY_WALL_HANGING_SIGN,
            CHESTNUT_CEILING_HANGING_SIGN, CHESTNUT_WALL_HANGING_SIGN,
            PINE_CEILING_HANGING_SIGN, PINE_WALL_HANGING_SIGN
        );
        ((BlockEntityTypeDuck) BlockEntityType.CHEST).addBlocks(
            HOLLY_CHEST, CHESTNUT_CHEST, PINE_CHEST
        );
        ((BlockEntityTypeDuck) BlockEntityType.TRAPPED_CHEST).addBlocks(
            TRAPPED_HOLLY_CHEST, TRAPPED_CHESTNUT_CHEST, TRAPPED_PINE_CHEST
        );
    }


    public interface Properties {
        // Block Sets //
        BlockSetType HOLLY_BLOCK_SET = registerSet(new BlockSetType(Windswept.MOD_ID + ":holly", true, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON));
        BlockSetType CHESTNUT_BLOCK_SET = registerSet(new BlockSetType(Windswept.MOD_ID + ":chestnut"));
        BlockSetType PINE_BLOCK_SET = registerSet(new BlockSetType(Windswept.MOD_ID + ":pine"));
        BlockSetType ICICLE_SET = registerSet(new BlockSetType(Windswept.MOD_ID + ":icicles", true, SoundType.GLASS, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));
        BlockSetType GINGERBREAD_SET = registerSet(new BlockSetType(Windswept.MOD_ID + ":gingerbread", true, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON));

        WoodType HOLLY_WOOD_TYPE = registerWood(new WoodType(Windswept.MOD_ID + ":holly", HOLLY_BLOCK_SET, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN));
        WoodType CHESTNUT_WOOD_TYPE = registerWood(new WoodType(Windswept.MOD_ID + ":chestnut", CHESTNUT_BLOCK_SET));
        WoodType PINE_WOOD_TYPE = registerWood(new WoodType(Windswept.MOD_ID + ":pine", PINE_BLOCK_SET));
        WoodSetProperties HOLLY = WoodSetProperties.builder(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).logSound(SoundType.CHERRY_WOOD).build();
        WoodSetProperties CHESTNUT = WoodSetProperties.builder(MapColor.COLOR_BROWN).build();
        WoodSetProperties PINE = WoodSetProperties.builder(MapColor.TERRACOTTA_BROWN).build();

        // Blocks //
        BlockBehaviour.Properties FLOWER = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);
        BlockBehaviour.Properties FLOWER_POT = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        BlockBehaviour.Properties SAPLING = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY);
        
        BlockBehaviour.Properties SNOW_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(.85f).sound(SoundType.SNOW);
        BlockBehaviour.Properties ICE_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(2.8f).sound(SoundType.STONE);
        BlockBehaviour.Properties CRATE = BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.WOOD);
        BlockBehaviour.Properties HOLLY_BERRY_BASKET = BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.CHERRY_WOOD);
        BlockBehaviour.Properties SPROUTS = BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).replaceable();
        BlockBehaviour.Properties PINECONE_BLOCK = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2f, 3f).sound(WindsweptSoundTypes.PINECONE);
        BlockBehaviour.Properties SHALE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5f, 1f);
        BlockBehaviour.Properties LUNALITE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(.8f);
        BlockBehaviour.Properties GINGERBREAD = Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).strength(2f, 3f).sound(SoundType.CHERRY_WOOD);
        BlockBehaviour.Properties ELDER_ORNAMENT = Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(.1f).noOcclusion().noCollission().sound(SoundType.AZALEA);
        BlockBehaviour.Properties LAVENDER_THATCH = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(.5f).sound(SoundType.NETHER_SPROUTS).noOcclusion();
    
        private static BlockSetType registerSet(BlockSetType set) {
            return BlockSetTypeAccessor.registerBlockSet(set);
        }

        private static WoodType registerWood(WoodType set) {
            return WoodTypeAccessor.registerWoodSet(set);
        }
    }
    public record WoodSetProperties(MapColor woodColor, MapColor barkColor, MapColor leavesColor, Consumer<BlockBehaviour.Properties> basePropertiesConsumer, SoundType sound, SoundType logSound, SoundType leavesSound, SoundType chiseledBookshelfSound, NoteBlockInstrument instrument) {

        public static Builder builder(MapColor woodColor, MapColor barkColor) {
            return new Builder(woodColor, barkColor);
        }

        public static Builder builder(MapColor woodColor) {
            return new Builder(woodColor, woodColor);
        }

        public BlockBehaviour.Properties planks() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(2.0F, 3.0F).sound(this.sound);
        }

        public BlockBehaviour.Properties log() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(state -> state.hasProperty(BlockStateProperties.AXIS) && state.getValue(BlockStateProperties.AXIS) != Direction.Axis.Y ? barkColor : woodColor).instrument(this.instrument).strength(2.0F).sound(this.logSound);
        }

        public BlockBehaviour.Properties leaves() {
            return BlockBehaviour.Properties.of().mapColor(this.leavesColor).strength(0.2F).randomTicks().sound(this.leavesSound).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).isViewBlocking(Blocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::never);
        }

        public BlockBehaviour.Properties pressurePlate() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).forceSolidOn().instrument(this.instrument).noCollission().strength(0.5F).sound(this.sound).pushReaction(PushReaction.DESTROY);
        }

        public BlockBehaviour.Properties trapdoor() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).sound(this.sound);
        }

        public BlockBehaviour.Properties button() {
            return BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).sound(this.sound);
        }

        public BlockBehaviour.Properties door() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(3.0F).noOcclusion().sound(this.sound).pushReaction(PushReaction.DESTROY);
        }

        public BlockBehaviour.Properties beehive() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(0.6F).sound(this.sound);
        }

        public BlockBehaviour.Properties bookshelf() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(1.5F).sound(this.sound);
        }

        public BlockBehaviour.Properties chiseledBookshelf() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(1.5F).sound(this.chiseledBookshelfSound);
        }

        public BlockBehaviour.Properties ladder() {
            return BlockBehaviour.Properties.of().forceSolidOff().strength(0.4F).sound(SoundType.LADDER).noOcclusion().pushReaction(PushReaction.DESTROY);
        }

        public BlockBehaviour.Properties sapling() {
            return BlockBehaviour.Properties.of().mapColor(this.leavesColor).noCollission().randomTicks().instabreak().sound(this.leavesSound).pushReaction(PushReaction.DESTROY);
        }

        public BlockBehaviour.Properties chest() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(2.5F).sound(this.sound);
        }

        public BlockBehaviour.Properties sign() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return BlockBehaviour.Properties.of().mapColor(this.woodColor).forceSolidOn().instrument(this.instrument).noCollission().strength(1.0F);
        }

        public BlockBehaviour.Properties hangingSign() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).forceSolidOn().instrument(this.instrument).noCollission().strength(1.0F);
        }

        public BlockBehaviour.Properties leafPile() {
            return BlockBehaviour.Properties.of().mapColor(this.leavesColor).replaceable().noCollission().strength(0.2F).sound(this.leavesSound).ignitedByLava().pushReaction(PushReaction.DESTROY);
        }

        @Deprecated
        public BlockBehaviour.Properties leafCarpet() {
            return BlockBehaviour.Properties.of().mapColor(this.leavesColor).noCollission().strength(0.0F).sound(this.leavesSound).noOcclusion().ignitedByLava();
        }

        @Deprecated
        public BlockBehaviour.Properties post() {
            BlockBehaviour.Properties properties = BlockBehaviour.Properties.of();
            this.basePropertiesConsumer.accept(properties);
            return properties.mapColor(this.woodColor).instrument(this.instrument).strength(2.0F, 3.0F).sound(this.logSound);
        }

        public static final class Builder {
            private final MapColor woodColor;
            private final MapColor barkColor;
            private MapColor leavesColor = MapColor.PLANT;
            private Consumer<BlockBehaviour.Properties> basePropertiesConsumer = BlockBehaviour.Properties::ignitedByLava;
            private SoundType sound = SoundType.WOOD;
            private SoundType logSound = SoundType.WOOD;
            private SoundType leavesSound = SoundType.GRASS;
            private SoundType chiseledBookshelfSound = SoundType.CHISELED_BOOKSHELF;
            private NoteBlockInstrument instrument = NoteBlockInstrument.BASS;

            private Builder(MapColor woodColor, MapColor barkColor) {
                this.woodColor = woodColor;
                this.barkColor = barkColor;
            }

            public Builder basePropertiesConsumer(Consumer<BlockBehaviour.Properties> basePropertiesConsumer) {
                this.basePropertiesConsumer = basePropertiesConsumer;
                return this;
            }

            public Builder fireproof() {
                this.basePropertiesConsumer = block -> BlockBehaviour.Properties.of();
                return this;
            }

            public Builder leavesColor(MapColor color) {
                this.leavesColor = color;
                return this;
            }

            public Builder sound(SoundType soundType) {
                this.sound = soundType;
                return this;
            }

            public Builder logSound(SoundType soundType) {
                this.logSound = soundType;
                return this;
            }

            public Builder leavesSound(SoundType soundType) {
                this.leavesSound = soundType;
                return this;
            }

            public Builder chiseledBookshelfSound(SoundType soundType) {
                this.chiseledBookshelfSound = soundType;
                return this;
            }

            public Builder instrument(NoteBlockInstrument instrument) {
                this.instrument = instrument;
                return this;
            }

            public WoodSetProperties build() {
                return new WoodSetProperties(this.barkColor, this.woodColor, this.leavesColor, this.basePropertiesConsumer, this.sound, this.logSound, this.leavesSound, this.chiseledBookshelfSound, this.instrument);
            }
        }
    }
}
