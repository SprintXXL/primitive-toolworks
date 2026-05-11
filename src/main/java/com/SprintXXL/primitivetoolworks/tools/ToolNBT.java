package com.SprintXXL.primitivetoolworks.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ToolNBT {

    public static void setHeadMaterial(ItemStack stack, String material) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");

        nbt.setString("HeadMaterial", material);
    }

    public static String getHeadMaterial(ItemStack stack) {

        NBTTagCompound nbt = stack.getSubCompound("ToolData");

        if (nbt == null) {

            return "unknown";
        }

        return nbt.getString("HeadMaterial");
    }

    public static void setHandleMaterial(ItemStack stack, String material) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");

        nbt.setString("HandleMaterial", material);
    }

    public static String getHandleMaterial(ItemStack stack) {

        NBTTagCompound nbt = stack.getSubCompound("ToolData");

        if (nbt == null) {
            return "unknown";
        }

        return nbt.getString("HandleMaterial");
    }
}
