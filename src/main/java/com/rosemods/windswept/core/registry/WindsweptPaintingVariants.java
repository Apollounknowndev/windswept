package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.decoration.PaintingVariant;

public final class WindsweptPaintingVariants {
    public static final PaintingVariant CLIFFSIDE = register("cliffside", 3, 2);
    public static final PaintingVariant DRESS_CODES = register("dress_codes", 2, 2);
    public static final PaintingVariant ECOTONAL_PAREIDOLIA = register("ecotonal_pareidolia", 4, 2);
    public static final PaintingVariant THE_FOILS = register("the_foils", 3, 4);
    public static final PaintingVariant AURORAE = register("aurorae", 2, 1);
    public static final PaintingVariant HEARTH_RUG = register("hearth_rug", 1, 4);
    public static final PaintingVariant ALLU_PINE = register("al-lu_pine", 2, 3);

    private static PaintingVariant register(String name, int width, int heght) {
        return Registry.register(BuiltInRegistries.PAINTING_VARIANT, Windswept.id(name), new PaintingVariant(width * 16, heght * 16));
    }

    public static void init() {

    }
}
