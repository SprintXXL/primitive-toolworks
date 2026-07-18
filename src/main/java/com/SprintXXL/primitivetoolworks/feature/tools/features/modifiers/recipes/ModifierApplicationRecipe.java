package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes;

import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolItemHelper;
import net.minecraft.item.ItemStack;

public class ModifierApplicationRecipe {

    private final String modifierID;
    private final ItemStack ingredient;
    private final int levelIncrease;

    public ModifierApplicationRecipe(String modifierID, ItemStack ingredient, int levelIncrease) {

        this.modifierID = modifierID;
        this.ingredient = ingredient;
        this.levelIncrease = levelIncrease;
    }

    public String getID() {
        return modifierID;
    }

    public ItemStack getIngredient() {
        return ingredient;
    }

    public int getLevelIncrease() {
        return levelIncrease;
    }

    public boolean matches(ItemStack toolStack, ItemStack ingredientStack) {

        if (toolStack.isEmpty() || ingredientStack.isEmpty()) {
            return false;
        }

        if (!ItemStack.areItemsEqual(ingredientStack, ingredient)) {
            return false;
        }

        if (!ToolItemHelper.isModularTool(toolStack)) {
            return false;
        }

        return true;
    }
}
