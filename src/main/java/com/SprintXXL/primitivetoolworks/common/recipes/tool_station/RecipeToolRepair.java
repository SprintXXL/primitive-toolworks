package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.tools.ToolNBT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH.*;

public class RecipeToolRepair {

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        ItemStack mainMaterialSlot = craftMatrix.getStackInSlot(1);
        ItemStack modularToolSlot = craftMatrix.getStackInSlot(4);

        if (mainMaterialSlot.isEmpty() || modularToolSlot.isEmpty()) {
            return false;
        }

        if (modularToolSlot.getItem() != ModItems.MODULAR_PICKAXE) {
            return false;
        }

        String repairMaterial = getMaterialID(mainMaterialSlot);
        String toolMainMaterial = ToolNBT.getMainMaterial(modularToolSlot);

        if (!toolMainMaterial.equals(repairMaterial)) {
            return false;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == 1 || i == 4) {
                continue;
            }

            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        if (!modularToolSlot.isItemDamaged()) {
            return false;
        }

        return true;
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        if (!matches(craftMatrix)) {
            return ItemStack.EMPTY;
        }

        ItemStack toolStack = craftMatrix.getStackInSlot(4);

        ItemStack result = toolStack.copy();

        int currentDamage = result.getItemDamage();
        int repairAmount = Math.max(1, result.getMaxDamage() / 4);

        int newDamage = Math.max(0, currentDamage - repairAmount);

        result.setItemDamage(newDamage);

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        ItemStack materialStack = craftMatrix.getStackInSlot(1);
        ItemStack toolStack = craftMatrix.getStackInSlot(4);

        if (!materialStack.isEmpty()) {
            materialStack.shrink(1);
        }

        if (!toolStack.isEmpty()) {
            toolStack.shrink(1);
        }
    }
}
