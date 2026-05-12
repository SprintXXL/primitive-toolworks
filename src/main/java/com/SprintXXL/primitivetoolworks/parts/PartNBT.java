package com.SprintXXL.primitivetoolworks.parts;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PartNBT {

    public static void setMaterial(ItemStack stack, String material) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("PartData");

        nbt.setString("Material", material);
    }

    public static String getMaterial(ItemStack stack) {

        if (stack.isEmpty()) {
            return "unknown";
        }

        NBTTagCompound nbt = stack.getSubCompound("PartData");

        if (nbt == null) {

            return "unknown";
        }

        return nbt.getString("Material");
    }

    public static void setPartType(ItemStack stack, String partType) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("PartData");

        nbt.setString("PartType", partType);
    }

    public static String getPartType(ItemStack stack) {

        if (stack.isEmpty()) {
            return "unknown";
        }

        NBTTagCompound nbt = stack.getSubCompound("PartData");

        if (nbt == null) {
            return "unknown";
        }

        return nbt.getString("PartType");
    }
}
