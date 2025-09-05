package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.enchantment.curse.SlippingCurseEnchantment;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class WindsweptEnchantments {
    public static final Enchantment SLIPPING_CURSE = register("slipping_curse", new SlippingCurseEnchantment());

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT, Windswept.id(name), enchantment);
    }

    public static void init() {

    }
}
