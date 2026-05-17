package com.SprintXXL.primitivetoolworks.common.recipes.helpers;

import net.minecraft.inventory.InventoryCrafting;

public class helpers {

    public static boolean matchesCraftMatrix(InventoryCrafting craftMatrix) {

        if (craftMatrix.getWidth() != 3 || craftMatrix.getHeight() != 3) {
            return false;
        }

        return true;
    }
}
