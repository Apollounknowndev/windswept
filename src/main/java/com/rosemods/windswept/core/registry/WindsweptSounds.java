package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class WindsweptSounds {
    public static final SoundEvent MUSIC_DISC_RAIN = register("music_disc.rain");
    public static final SoundEvent MUSIC_DISC_SNOW = register("music_disc.snow");
    public static final SoundEvent MUSIC_DISC_BUMBLEBEE = register("music_disc.bumblebee");
    public static final SoundEvent PINECONE_NOTE = register("block.pinecone.note");

    public static final SoundEvent CHILLED_DEATH = register("entity.chilled.death");
    public static final SoundEvent CHILLED_HURT = register("entity.chilled.hurt");
    public static final SoundEvent CHILLED_AMBIENT = register("entity.chilled.ambient");

    private static SoundEvent register(String name) {
        ResourceLocation id = Windswept.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {

    }
}
