package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRecipe;
import net.minecraft.item.ItemStack;

public class ToolModifierApplier {

    private ToolModifierApplier() {}

    public static ItemStack applyModifier(ItemStack toolStack, ModifierApplicationRecipe recipe) {

        if (toolStack.isEmpty() || recipe == null) {
            return ItemStack.EMPTY;
        }

        if (!ToolModifierValidator.canApplyModifier(toolStack, recipe)) {
            return ItemStack.EMPTY;
        }

        ItemStack output = toolStack.copy();

        int currentLevel = ToolModifierNBT.getModifierLevel(output, recipe.getID());

        ToolModifierNBT.setModifierLevel(output, recipe.getID(), currentLevel + recipe.getLevelIncrease());

        return output;
    }
}
