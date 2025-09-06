package com.rosemods.windswept.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.rosemods.windswept.core.other.WindsweptTiers;
import com.rosemods.windswept.core.registry.WindsweptAttributes;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;

import java.util.UUID;

public class AntlerHelmetItem extends ArmorItem {
    private static final UUID SPRINT_DAMAGE_UUID = UUID.fromString("e97abdf0-cd94-45f4-8cd4-581a0a75515f");
    private static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("cd559dfd-c166-4043-b9eb-a69e85abb04b");

    public AntlerHelmetItem(Properties properties) {
        super(WindsweptTiers.ANTLER_HELMET, Type.HELMET, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getDefaultAttributeModifiers(slot));

        if (slot == this.type.getSlot()) {
            builder.put(WindsweptAttributes.SPRINT_DAMAGE, new AttributeModifier(SPRINT_DAMAGE_UUID, "Sprint damage modifier", 4, AttributeModifier.Operation.ADDITION));
        }

        return builder.build();
    }

    // Util //

    public static void removeSprintDamage(LivingEntity entity) {
        AttributeInstance damage = entity.getAttribute(Attributes.ATTACK_DAMAGE);

        if (damage != null && damage.getModifier(ATTACK_DAMAGE_UUID) != null)
            damage.removeModifier(ATTACK_DAMAGE_UUID);
    }

    public static void tryAddSprintDamage(LivingEntity entity) {
        if (entity.getItemBySlot(EquipmentSlot.HEAD).is(WindsweptItems.ANTLER_HELMET) && entity.isSprinting()) {
            AttributeInstance damage = entity.getAttribute(Attributes.ATTACK_DAMAGE);

            if (damage != null && damage.getModifier(ATTACK_DAMAGE_UUID) == null)
                damage.addTransientModifier(new AttributeModifier(ATTACK_DAMAGE_UUID, "Sprint damage boost", 4, AttributeModifier.Operation.ADDITION));
        }
    }

}