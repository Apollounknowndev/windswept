package com.rosemods.windswept.core.other.tags;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class WindsweptBlockTags {
    public static final TagKey<Block> HOLLY_LOGS = tag(Windswept.MOD_ID, "holly_logs");
    public static final TagKey<Block> CHESTNUT_LOGS = tag(Windswept.MOD_ID, "chestnut_logs");
    public static final TagKey<Block> PINE_LOGS = tag(Windswept.MOD_ID, "pine_logs");
    public static final TagKey<Block> LUNALITE = tag(Windswept.MOD_ID, "lunalite");
    public static final TagKey<Block> SNOW_BOOTS_BLOCKS = tag(Windswept.MOD_ID, "snow_boots_blocks");
    public static final TagKey<Block> FROSTBITER_FOOD = tag(Windswept.MOD_ID, "frostbiter_food");
    public static final TagKey<Block> PINECONE_NOTE_BLOCKS = tag(Windswept.MOD_ID, "pinecone_note_blocks");

    public static final TagKey<Block> CHEST_MOUNTED_STORAGE = tag("create", "chest_mounted_storage");
    public static final TagKey<Block> PINECONE_GOLEM_BASE_BLOCKS = tag("environmental", "pinecone_golem_base_blocks");
    public static final TagKey<Block> GINGERBREADS = tag("snowy_spirit", "gingerbreads");

    private static TagKey<Block> tag(String namespace, String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(namespace, path));
    }
}
