package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRecipe;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import net.minecraft.item.ItemStack;

public class ToolModifierValidator {

    public static boolean canApplyModifier(ItemStack toolStack, ModifierApplicationRecipe recipe) {

        if (toolStack.isEmpty() || recipe == null) {
            return false;
        }

        String modifierID = recipe.getModifierID();

        ModifierDefinition modifier = ModifierRegistry.getModifier(modifierID);

        if (modifier == null) {
            return false;
        }

        int remainingSlots = ToolModifierSlotNBT.getRemainingModifierSlots(toolStack);
        int requiredSlots = recipe.getLevelIncrease();

        if (requiredSlots > remainingSlots) {
            return false;
        }

        int currentLevel = ToolModifierNBT.getModifierLevel(toolStack, modifierID);
        int addedLevel = recipe.getLevelIncrease();
        int maxLevel = modifier.getMaxLevel();

        return currentLevel + addedLevel <= maxLevel;
    }
}
