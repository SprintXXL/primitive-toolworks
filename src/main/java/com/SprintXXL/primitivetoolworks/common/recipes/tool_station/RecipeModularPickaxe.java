package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.parts.PartIDs;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.tools.ToolNBT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class RecipeModularPickaxe {

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i != 1 && i != 4 && i != 7) {
                if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        ItemStack mainStack = craftMatrix.getStackInSlot(1);
        ItemStack extraStack = craftMatrix.getStackInSlot(4);
        ItemStack handleStack = craftMatrix.getStackInSlot(7);

        if (mainStack.isEmpty() || extraStack.isEmpty() || handleStack.isEmpty()) {
            return false;
        }

        if (mainStack.getItem() != ModItems.TOOL_PART || extraStack.getItem() != ModItems.TOOL_PART || handleStack.getItem() != ModItems.TOOL_PART) {
            return false;
        }

        return PartIDs.PICKAXE_HEAD.equals(PartNBT.getPartType(mainStack)) &&
                PartIDs.BINDING.equals(PartNBT.getPartType(extraStack)) &&
                PartIDs.HANDLE.equals(PartNBT.getPartType(handleStack));
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        ItemStack mainStack = craftMatrix.getStackInSlot(1);
        ItemStack extraStack = craftMatrix.getStackInSlot(4);
        ItemStack handleStack = craftMatrix.getStackInSlot(7);

        ItemStack result = new ItemStack(ModItems.MODULAR_PICKAXE);

        ToolNBT.setMainMaterial(result, PartNBT.getMaterial(mainStack));
        ToolNBT.setMainPart(result, PartNBT.getPartType(mainStack));

        ToolNBT.setExtraMaterial(result, PartNBT.getMaterial(extraStack));
        ToolNBT.setExtraPart(result, PartNBT.getPartType(extraStack));

        ToolNBT.setHandleMaterial(result, PartNBT.getMaterial(handleStack));
        ToolNBT.setHandlePart(result, PartNBT.getPartType(handleStack));

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {

            ItemStack stack = craftMatrix.getStackInSlot(i);

            if (!stack.isEmpty()) {
                stack.shrink(1);
            }
        }
    }
}
