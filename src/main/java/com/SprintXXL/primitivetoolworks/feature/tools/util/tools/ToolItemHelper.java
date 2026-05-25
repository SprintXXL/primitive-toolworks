package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.item.ItemStack;

public class ToolItemHelper {

    public static boolean isModularTool(ItemStack stack) {

        if (stack.isEmpty()) {
            return false;
        }

        return stack.getItem() == ModItems.MODULAR_SWORD
                || stack.getItem() == ModItems.MODULAR_PICKAXE
                || stack.getItem() == ModItems.MODULAR_AXE
                || stack.getItem() == ModItems.MODULAR_SHOVEL
                || stack.getItem() == ModItems.MODULAR_HOE
                || stack.getItem() == ModItems.MODULAR_HAMMER;
    }
}
