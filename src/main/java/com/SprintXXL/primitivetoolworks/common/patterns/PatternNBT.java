package com.SprintXXL.primitivetoolworks.common.patterns;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PatternNBT {

    public static void setPatternType(ItemStack stack, String partType) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("PatternData");

        nbt.setString("PatternType", partType);
    }

    public static String getPatternType(ItemStack stack) {

        if (stack.isEmpty()) {
            return "unknown";
        }

        NBTTagCompound nbt = stack.getSubCompound("PatternData");

        if (nbt == null) {
            return "unknown";
        }

        return nbt.getString("PatternType");
    }
}
