package com.SprintXXL.primitivetoolworks.feature.tools.recipes;

import com.SprintXXL.primitivetoolworks.common.util.RecipeHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic.ToolModifierApplier;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRecipe;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRegistry;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class RecipeToolModifier {

    private static final int INGREDIENT_STACK = 1;
    private static final int TOOL_STACK = 4;

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!RecipeHelper.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        if (!areAllOtherSlotsEmpty(craftMatrix)) {
            return false;
        }

        return getMatchingRecipe(craftMatrix) != null;
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        ModifierApplicationRecipe recipe = getMatchingRecipe(craftMatrix);

        ItemStack toolStack = getToolStack(craftMatrix);

        if (recipe == null) {
            return ItemStack.EMPTY;
        }

        return ToolModifierApplier.applyModifier(toolStack, recipe);
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        ModifierApplicationRecipe recipe = getMatchingRecipe(craftMatrix);

        ItemStack ingredientStack = getIngredientStack(craftMatrix);
        ItemStack toolStack = getToolStack(craftMatrix);

        if (recipe == null) {
            return;
        }

        ingredientStack.shrink(1);
        toolStack.shrink(1);


    }

    private ModifierApplicationRecipe getMatchingRecipe(InventoryCrafting craftMatrix) {

        ItemStack ingredientStack = getIngredientStack(craftMatrix);
        ItemStack toolStack = getToolStack(craftMatrix);

        return ModifierApplicationRegistry.findMatch(toolStack, ingredientStack);
    }

    private ItemStack getIngredientStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(INGREDIENT_STACK);
    }

    private ItemStack getToolStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(TOOL_STACK);
    }

    private boolean areAllOtherSlotsEmpty(InventoryCrafting craftMatrix) {

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i != INGREDIENT_STACK && i != TOOL_STACK) {
                if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
}
