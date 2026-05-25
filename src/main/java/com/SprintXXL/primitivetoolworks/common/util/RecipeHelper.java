package com.SprintXXL.primitivetoolworks.common.util;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeHelper {

    public static boolean matchesCraftMatrix(InventoryCrafting craftMatrix) {

        if (craftMatrix.getWidth() != 3 || craftMatrix.getHeight() != 3) {
            return false;
        }

        return true;
    }

    public static boolean isPlankWood(ItemStack stack) {
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
