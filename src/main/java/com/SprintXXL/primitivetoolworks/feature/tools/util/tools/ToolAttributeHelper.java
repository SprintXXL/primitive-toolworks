package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public final class ToolAttributeHelper {

    private ToolAttributeHelper() {}

    public static Multimap<String, AttributeModifier> getToolAttributeModifiers(
            Multimap<String, AttributeModifier> modifiers,
            EntityEquipmentSlot slot,
            ItemStack stack,
            UUID attackDamageModifier,
            UUID attackSpeedModifier
    ) {

        if (slot != EntityEquipmentSlot.MAINHAND) {
            return modifiers;
        }

        modifiers.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
        modifiers.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName());

        modifiers.put(
                SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                new AttributeModifier(
                        attackDamageModifier,
                        "Tool Modifier",
                        ToolCalculator.getAttackDamage(stack),
                        0
                )
        );

        modifiers.put(
                SharedMonsterAttributes.ATTACK_SPEED.getName(),
                new AttributeModifier(
                        attackSpeedModifier,
                        "Tool Modifier",
                        ToolCalculator.getAttackSpeed(stack),
                        0
                )
        );

        return modifiers;
    }
}
