package com.SprintXXL.primitivetoolworks.feature.tools.recipes;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.util.RecipeHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolItemHelper;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartDefinition;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class RecipePartReplacement {

    private static final int PART_STACK = 1;
    private static final int TOOL_STACK = 4;

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!RecipeHelper.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        if (!areAllOtherSlotsEmpty(craftMatrix)) {
            return false;
        }

        ItemStack partStack = getPartStack(craftMatrix);
        ItemStack toolStack = getToolStack(craftMatrix);

        if (partStack.isEmpty() || toolStack.isEmpty()) {
            return false;
        }

        if (partStack.getItem() != ModItems.PART) {
            return false;
        }

        if (!ToolItemHelper.isModularTool(toolStack)) {
            return false;
        }

        if (!isValidPartReplacement(toolStack, partStack)) {
            return false;
        }

        return true;
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        ItemStack partStack = getPartStack(craftMatrix);
        ItemStack toolStack = getToolStack(craftMatrix);

        String material = PartNBT.getMaterial(partStack);
        String partType = PartNBT.getPartType(partStack);
        PartGroup group = PartNBT.getPartGroup(partStack);

        ItemStack result = toolStack.copy();

        if (group == PartGroup.MAIN) {
            ToolNBT.setMainMaterial(result, material);
            ToolNBT.setMainPart(result, partType);
        }

        else if (group == PartGroup.EXTRA) {
            ToolNBT.setExtraMaterial(result, material);
            ToolNBT.setExtraPart(result, partType);
        }

        else if (group == PartGroup.HANDLE) {
            ToolNBT.setHandleMaterial(result, material);
            ToolNBT.setHandlePart(result, partType);
        }

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        ItemStack partStack = getPartStack(craftMatrix);
        ItemStack toolStack = getToolStack(craftMatrix);

        if (!partStack.isEmpty()) {
            partStack.shrink(1);
        }

        if (!toolStack.isEmpty()) {
            toolStack.shrink(1);
        }
    }

    private ItemStack getPartStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(1);
    }

    private ItemStack getToolStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(4);
    }

    private boolean areAllOtherSlotsEmpty(InventoryCrafting craftMatrix) {

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i != PART_STACK && i != TOOL_STACK) {
                if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidPartReplacement(ItemStack toolStack, ItemStack partStack) {

        ToolType toolType = ToolNBT.getToolType(toolStack);
        String partType = PartNBT.getPartType(partStack);

        PartDefinition part = PartRegistry.getPart(partType);

        if (part == null) {
            return false;
        }

        return part.getAllowedToolTypes().contains(toolType);
    }
}
