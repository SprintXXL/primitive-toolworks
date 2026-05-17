package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.helpers;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.tools.ToolNBT;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeToolRepair {

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!helpers.matchesCraftMatrix(craftMatrix)) {
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

    private String getMaterialID(ItemStack stack) {

        if (stack.isEmpty()) {
            return "unknown";
        }

        if (stack.getItem() == Items.FLINT) {
            return MaterialIDs.FLINT;
        }
        if (isPlankWood(stack)) {
            return MaterialIDs.WOOD;
        }
        if (stack.getItem() == Items.BONE) {
            return MaterialIDs.BONE;
        }

        return "unknown";
    }

    private boolean isPlankWood(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        int[] oreIDs = OreDictionary.getOreIDs(stack);

        for (int id : oreIDs) {
            if (OreDictionary.getOreName(id).equals("plankWood")) {
                return true;
            }
        }
        return false;
    }
}
