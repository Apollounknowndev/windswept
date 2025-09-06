package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.item.*;
import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.WindsweptConfig;
import com.rosemods.windswept.core.other.WindsweptFoods;
import com.rosemods.windswept.core.other.tags.WindsweptBannerPatternTags;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;

public class WindsweptItems {
    public static final Item HOLLY_SIGN = register("holly_sign", new SignItem(new Item.Properties().stacksTo(16), WindsweptBlocks.HOLLY_STANDING_SIGN, WindsweptBlocks.HOLLY_WALL_SIGN));
    public static final Item CHESTNUT_SIGN = register("chestnut_sign", new SignItem(new Item.Properties().stacksTo(16), WindsweptBlocks.CHESTNUT_STANDING_SIGN, WindsweptBlocks.CHESTNUT_WALL_SIGN));
    public static final Item PINE_SIGN = register("pine_sign", new SignItem(new Item.Properties().stacksTo(16), WindsweptBlocks.PINE_STANDING_SIGN, WindsweptBlocks.PINE_WALL_SIGN));
    public static final Item HOLLY_HANGING_SIGN = register("holly_hanging_sign", new HangingSignItem(WindsweptBlocks.HOLLY_CEILING_HANGING_SIGN, WindsweptBlocks.HOLLY_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item CHESTNUT_HANGING_SIGN = register("chestnut_hanging_sign", new HangingSignItem(WindsweptBlocks.CHESTNUT_CEILING_HANGING_SIGN, WindsweptBlocks.CHESTNUT_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item PINE_HANGING_SIGN = register("pine_hanging_sign", new HangingSignItem(WindsweptBlocks.PINE_CEILING_HANGING_SIGN, WindsweptBlocks.PINE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    // Misc //
    public static final Item HOLLY_BERRIES = register("holly_berries", new Item(new Item.Properties().food(WindsweptFoods.HOLLY_BERRIES)));
    public static final Item HOLLY_BERRIES_ON_A_STICK = register("holly_berries_on_a_stick", new HollyBerriesOnAStickItem(new Item.Properties().durability(25)));
    public static final Item ELDER_FEATHER = register("elder_feather", new Item(new Item.Properties()));
    public static final Item FROST_ARROW = register("frost_arrow", new FrostArrowItem(new Item.Properties()));
    public static final Item FROZEN_BRANCH = register("frozen_branch", new Item(new Item.Properties()));
    public static final Item FROZEN_FLESH = register("frozen_flesh", new Item(new Item.Properties().food(WindsweptFoods.FROZEN_FLESH)));

    // Armour //
    public static final Item LAVENDER_CROWN = register("lavender_crown", new LavenderCrownItem(new Item.Properties()));
    public static final Item ANTLER_HELMET = register("antler_helmet", new AntlerHelmetItem(new Item.Properties()));
    public static final Item FEATHER_CLOAK = register("feather_cloak", new FeatherCloakItem(new Item.Properties()));
    public static final Item SNOW_BOOTS = register("snow_boots", new SnowBootsItem(new Item.Properties()));

    // Wooden Buckets //
    public static final Item WOODEN_BUCKET = register("wooden_bucket", new EmptyWoodenBucketItem(Fluids.EMPTY, new Item.Properties().durability(WindsweptConfig.COMMON.woodenBucketDurabilty.get())));
    public static final Item WOODEN_WATER_BUCKET = register("wooden_water_bucket", new WoodenBucketItem(Fluids.WATER, new Item.Properties().craftRemainder(WOODEN_BUCKET).durability(WindsweptConfig.COMMON.woodenBucketDurabilty.get())));
    public static final Item WOODEN_MILK_BUCKET = register("wooden_milk_bucket", new WoodenMilkBucketItem(new Item.Properties().craftRemainder(WOODEN_BUCKET).durability(WindsweptConfig.COMMON.woodenBucketDurabilty.get())));
    public static final Item WOODEN_POWDER_SNOW_BUCKET = register("wooden_powder_snow_bucket", new WoodenPowderSnowBucketItem(new Item.Properties().craftRemainder(WOODEN_BUCKET).durability(WindsweptConfig.COMMON.woodenBucketDurabilty.get())));

    // Food //
    public static final Item WILD_BERRIES = register("wild_berries", new ItemNameBlockItem(WindsweptBlocks.WILD_BERRY_BUSH, new Item.Properties().food(WindsweptFoods.WILD_BERRIES)));
    public static final Item WILD_BERRY_PIPS = register("wild_berry_pips", new Item(new Item.Properties()));
    public static final Item CANDY_CANE = register("candy_cane", new Item(new Item.Properties().food(WindsweptFoods.CANDY_CANE)));

    public static final Item CHESTNUTS = register("chestnuts", new Item(new Item.Properties().food(WindsweptFoods.CHESTNUTS)));
    public static final Item ROASTED_CHESTNUTS = register("roasted_chestnuts", new Item(new Item.Properties().food(WindsweptFoods.ROASTED_CHESTNUTS)));
    public static final Item CHESTNUT_SOUP = register("chestnut_soup", new BowlFoodItem(new Item.Properties().food(WindsweptFoods.CHESTNUT_SOUP).craftRemainder(Items.BOWL).stacksTo(1)));

    public static final Item GINGER_ROOT = register("ginger_root", new ItemNameBlockItem(WindsweptBlocks.GINGER, new Item.Properties().food(WindsweptFoods.GINGER_ROOT)));
    public static final Item GINGERBREAD_COOKIE = register("gingerbread_cookie", new Item(new Item.Properties().food(WindsweptFoods.GINGERBREAD_COOKIE)));
    public static final Item GINGER_TEA = register("ginger_tea", new DrinkableBottleItem(WindsweptFoods.GINGER_TEA));

    public static final Item SPICY_SNOW_CONE = register("spicy_snow_cone", new FoodRemainderItem(WindsweptBlocks.PINECONE, new Item.Properties().food(WindsweptFoods.SPICY_SNOW_CONE)));
    public static final Item SWEET_SNOW_CONE = register("sweet_snow_cone", new FoodRemainderItem(WindsweptBlocks.PINECONE, new Item.Properties().food(WindsweptFoods.SWEET_SNOW_CONE)));
    public static final Item MINTY_SNOW_CONE = register("minty_snow_cone", new FoodRemainderItem(WindsweptBlocks.PINECONE, new Item.Properties().food(WindsweptFoods.MINY_SNOW_CONE)));

    public static final Item PINECONE_JAM_BOTTLE = register("pinecone_jam_bottle", new DrinkableBottleItem(SoundEvents.HONEY_DRINK, WindsweptFoods.PINECONE_JAM));

    public static final Item LAVENDER_TEA = register("lavender_tea", new DrinkableBottleItem(WindsweptFoods.LAVENDER_TEA));

    public static final Item GOAT = register("goat", new Item(new Item.Properties().food(WindsweptFoods.GOAT)));
    public static final Item COOKED_GOAT = register("cooked_goat", new Item(new Item.Properties().food(WindsweptFoods.COOKED_GOAT)));
    public static final Item GOAT_STEW = register("goat_stew", new BowlFoodItem(new Item.Properties().food(WindsweptFoods.GOAT_STEW).craftRemainder(Items.BOWL).stacksTo(1)));
    public static final Item MUTTON_PIE = register("mutton_pie", new Item(new Item.Properties().food(WindsweptFoods.MUTTON_PIE)));

    // Pottery Sherds //
    public static final Item HOOT_POTTERY_SHERD = register("hoot_pottery_sherd", new Item(new Item.Properties()));
    public static final Item PLUMAGE_POTTERY_SHERD = register("plumage_pottery_sherd", new Item(new Item.Properties()));
    public static final Item OFFSHOOT_POTTERY_SHERD = register("offshoot_pottery_sherd", new Item(new Item.Properties()));
    public static final Item FLAKE_POTTERY_SHERD = register("flake_pottery_sherd", new Item(new Item.Properties()));
    public static final Item DRUPES_POTTERY_SHERD = register("drupes_pottery_sherd", new Item(new Item.Properties()));

    // Banner Patterns //
    public static final Item SNOW_GOLEM_BANNER_PATTERN = register("snow_golem_banner_pattern", new BannerPatternItem(WindsweptBannerPatternTags.SNOW_GOLEM, new Item.Properties().stacksTo(1)));
    public static final Item SNOW_CHARGE_BANNER_PATTERN = register("snow_charge_banner_pattern", new BannerPatternItem(WindsweptBannerPatternTags.SNOW_CHARGE, new Item.Properties().stacksTo(1)));
    public static final Item ROSE_FLOWER_BANNER_PATTERN = register("rose_flower_banner_pattern", new BannerPatternItem(WindsweptBannerPatternTags.ROSE_FLOWER, new Item.Properties().stacksTo(1)));

    // Music Discs //
    public static final Item MUSIC_DISC_RAIN = register("music_disc_rain", new RecordItem(2, WindsweptSounds.MUSIC_DISC_RAIN, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 124 * 20));
    public static final Item MUSIC_DISC_SNOW = register("music_disc_snow", new RecordItem(2, WindsweptSounds.MUSIC_DISC_SNOW, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 121 * 20));
    public static final Item MUSIC_DISC_BUMBLEBEE = register("music_disc_bumblebee", new RecordItem(2, WindsweptSounds.MUSIC_DISC_BUMBLEBEE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 55 * 20));

    // Spawn Eggs //
    public static final Item CHILLED_SPAWN_EGG = register("chilled", new SpawnEggItem(WindsweptEntityTypes.CHILLED, 0x9e9cbe, 0x98654a, new Item.Properties()));
    public static final Item FROSTBITER_SPAWN_EGG = register("frostbiter", new SpawnEggItem(WindsweptEntityTypes.FROSTBITER, 0xe2e2e2, 0x8fb5ff, new Item.Properties()));

    // Boats //
    //public static final Pair<Item, Item> HOLLY_BOAT = HELPER.createBoatAndChestBoatItem("holly", WindsweptBlocks.HOLLY_PLANKS);
    public static final Item HOLLY_FURNACE_BOAT = register("holly_furnace_boat", new Item(new Item.Properties()));
    public static final Item LARGE_HOLLY_BOAT = register("large_holly_boat", new Item(new Item.Properties()));
    //public static final Pair<Item, Item> CHESTNUT_BOAT = HELPER.createBoatAndChestBoatItem("chestnut", WindsweptBlocks.CHESTNUT_PLANKS);
    public static final Item CHESTNUT_FURNACE_BOAT = register("chestnut_furnace_boat", new Item(new Item.Properties()));
    public static final Item LARGE_CHESTNUT_BOAT = register("large_chestnut_boat", new Item(new Item.Properties()));
    //public static final Pair<Item, Item> PINE_BOAT = HELPER.createBoatAndChestBoatItem("pine", WindsweptBlocks.PINE_PLANKS);
    public static final Item PINE_FURNACE_BOAT = register("pine_furnace_boat", new Item(new Item.Properties()));
    public static final Item LARGE_PINE_BOAT = register("large_pine_boat", new Item(new Item.Properties()));

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Windswept.id(name), item);
    }

    public static void init() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(WOODEN_BUCKET, 600);

    }
}
