package com.SprintXXL.primitivetoolworks.common.recipes.helpers;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RH {

    public static boolean matchesCraftMatrix(InventoryCrafting craftMatrix) {

        if (craftMatrix.getWidth() != 3 || craftMatrix.getHeight() != 3) {
            return false;
        }

        return true;
    }

    public static String getMaterialID(ItemStack stack) {

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
