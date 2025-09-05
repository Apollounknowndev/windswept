package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.entity.Chilled;
import com.rosemods.windswept.common.entity.FrostArrow;
import com.rosemods.windswept.common.entity.Frostbiter;
import com.rosemods.windswept.core.Windswept;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

public class WindsweptEntityTypes {
    public static final EntityType<Chilled> CHILLED = register("chilled", Chilled::new, MobCategory.MONSTER, .6f, 2f);
    public static final EntityType<Frostbiter> FROSTBITER = register("frostbiter", Frostbiter::new, MobCategory.CREATURE, 1.05f, 1.7f);
    public static final EntityType<FrostArrow> FROST_ARROW = register("frost_arrow", FrostArrow::new, MobCategory.MISC, .5f, .5f);

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, Windswept.id(name), EntityType.Builder.of(factory, category).sized(width, height).build(name));
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(CHILLED, Chilled.createChilledAttributes());
        FabricDefaultAttributeRegistry.register(FROSTBITER, Frostbiter.createFrostbiterAttributes());

        SpawnPlacements.register(CHILLED, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(FROSTBITER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Frostbiter::checkFrostbiterSpawnRules);
    }
}
