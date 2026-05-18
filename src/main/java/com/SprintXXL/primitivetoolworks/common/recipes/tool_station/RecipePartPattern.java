package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.patterns.PatternIDs;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class RecipePartPattern {

    public boolean matches(InventoryCrafting craftMatrix) {
        return !getResultPatternType(craftMatrix).equals("unknown");
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        String patternType = getResultPatternType(craftMatrix);

        if (patternType.equals("unknown")) {
            return ItemStack.EMPTY;
        }
        ItemStack result = new ItemStack(ModItems.PART_PATTERN);
        PatternNBT.setPatternType(result, patternType);

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        int toolSlot = getToolSlot(craftMatrix);
        int consumedPatternSlot = getConsumedPatternSlot(craftMatrix);

        if (toolSlot == -1 || consumedPatternSlot == -1) {
            return;
        }

        ItemStack toolStack = craftMatrix.getStackInSlot(toolSlot);
        ItemStack patternStack = craftMatrix.getStackInSlot(consumedPatternSlot);

        if (!patternStack.isEmpty()) {
            patternStack.shrink(1);
        }

        if (!toolStack.isEmpty()) {

            int newDamage = toolStack.getItemDamage() + 1;

            if (newDamage >= toolStack.getMaxDamage()) {
                craftMatrix.setInventorySlotContents(toolSlot, ItemStack.EMPTY);
            }
            else {
                toolStack.setItemDamage(newDamage);
            }
        }
    }

    private String getResultPatternType(InventoryCrafting craftMatrix) {

        if (matchesPickaxeHeadPattern(craftMatrix)) {
            return PatternIDs.PICKAXE_HEAD;
        }
        if (matchesHandlePattern(craftMatrix)) {
            return PatternIDs.HANDLE;
        }
        if (matchesBindingPattern(craftMatrix)) {
            return PatternIDs.BINDING;
        }
        return "unknown";
    }

    private int getConsumedPatternSlot(InventoryCrafting craftMatrix) {

        if (matchesPickaxeHeadPattern(craftMatrix)) {
            return 1;
        }
        if (matchesBindingPattern(craftMatrix)) {
            return 4;
        }
        if (matchesHandlePattern(craftMatrix)) {
            return 7;
        }

        return -1;
    }

    private int getToolSlot(InventoryCrafting craftMatrix) {
        return 0;
    }

    private boolean matchesPickaxeHeadPattern(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        ItemStack knifeStack = craftMatrix.getStackInSlot(0);
        ItemStack patternStack = craftMatrix.getStackInSlot(1);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }

    private boolean matchesBindingPattern(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        ItemStack knifeStack = craftMatrix.getStackInSlot(0);
        ItemStack patternStack = craftMatrix.getStackInSlot(4);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == 0 || i == 4) {
                continue;
            }
            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }

    private boolean matchesHandlePattern(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        ItemStack knifeStack = craftMatrix.getStackInSlot(0);
        ItemStack patternStack = craftMatrix.getStackInSlot(7);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == 0 || i == 7) {
                continue;
            }
            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }
}
