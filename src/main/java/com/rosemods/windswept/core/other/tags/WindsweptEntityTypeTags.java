package com.rosemods.windswept.core.other.tags;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public final class WindsweptEntityTypeTags {
    public static final TagKey<EntityType<?>> CONVERT_TO_CHILLED = TagKey.create(Registries.ENTITY_TYPE, Windswept.id("convert_to_chilled"));
}
