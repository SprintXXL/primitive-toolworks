package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt;

import com.SprintXXL.primitivetoolworks.common.util.NBTHelper;
import net.minecraft.item.ItemStack;

public final class ToolModifierNBT {

    private static final String MODIFIER_DATA = "ToolModifiers";

    private ToolModifierNBT () {}

    public static void setModifierLevel(ItemStack stack, String modifierID, int level) {
        NBTHelper.setInteger(stack, MODIFIER_DATA, modifierID, level);
    }

    public static int getModifierLevel(ItemStack stack, String modifierID) {
        return NBTHelper.getInteger(stack, MODIFIER_DATA, modifierID);
    }
}
