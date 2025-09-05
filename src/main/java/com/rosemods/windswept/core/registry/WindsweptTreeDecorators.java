package com.rosemods.windswept.core.registry;

import com.rosemods.windswept.common.levelgen.tree.decorator.BranchDecorator;
import com.rosemods.windswept.common.levelgen.tree.decorator.MimosaDecorator;
import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class WindsweptTreeDecorators {
    public static final TreeDecoratorType<?> BRANCH_DECORATOR = register("branch", new TreeDecoratorType<>(BranchDecorator.CODEC));
    public static final TreeDecoratorType<?> MIMOSA_DECORATOR = register("mimosa", new TreeDecoratorType<>(MimosaDecorator.CODEC));

    private static TreeDecoratorType<?> register(String name, TreeDecoratorType<?> type) {
        return Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, Windswept.id(name), type);
    }

    public static void init() {

    }
}
