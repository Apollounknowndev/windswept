package com.rosemods.windswept.core.other;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.LivingEntity;

public final class WindsweptEntityData {
    public static final EntityDataAccessor<Boolean> IS_FREEZE_CONVERTING = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> CLOAKED = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Integer> FREEZE_CONVERT_TIME = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> POWDER_SNOW_TIME = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.INT);

    public static void init() {
    }
}
