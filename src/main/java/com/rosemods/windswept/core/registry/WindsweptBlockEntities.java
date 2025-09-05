package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.block_entity.NightFairyLightBlockEntity;
import com.rosemods.windswept.common.block_entity.SuspiciousSnowBlockEntity;
import com.rosemods.windswept.common.block_entity.WillOTheWispBlockEntity;
import com.rosemods.windswept.core.Windswept;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class WindsweptBlockEntities {
    public static final BlockEntityType<WillOTheWispBlockEntity> WILL_O_THE_WISP = register("will_o_the_wisp", WillOTheWispBlockEntity::new, WindsweptBlocks.WILL_O_THE_WISP);
    public static final BlockEntityType<NightFairyLightBlockEntity> NIGHT_FAIRY_LIGHT = register("night_fairy_light", NightFairyLightBlockEntity::new, WindsweptBlocks.NIGHT_FAIRY_LIGHT);
    public static final BlockEntityType<SuspiciousSnowBlockEntity> SUSPICIOUS_SNOW = register("suspicious_snow", SuspiciousSnowBlockEntity::new, WindsweptBlocks.SUSPICIOUS_SNOW);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> factory, Block... blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Windswept.id(name), FabricBlockEntityTypeBuilder.<T>create(factory, blocks).build());
    }

    public static void init() {

    }
}

