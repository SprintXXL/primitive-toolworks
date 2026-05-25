package com.SprintXXL.primitivetoolworks.core.tools.helpers;

import net.minecraft.item.ItemStack;

public class ToolDamageHelper {

    public static boolean isBroken(ItemStack stack) {
        return stack.getItemDamage() >= stack.getMaxDamage() - 1;
    }

    public static int clampDamage(ItemStack stack, int damage) {

        int max = stack.getMaxDamage();

        if (damage >= max) {
            return max - 1;
        }

        return damage;
    }
}
