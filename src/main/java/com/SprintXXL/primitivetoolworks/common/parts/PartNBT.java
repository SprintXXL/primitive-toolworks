package com.SprintXXL.primitivetoolworks.common.parts;

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

    public static void setPartGroup(ItemStack stack, PartGroup group) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("PartData");

        nbt.setString("PartGroup", group.name());
    }

    public static PartGroup getPartGroup(ItemStack stack) {

        if (stack.isEmpty()) {
            return null;
        }

        NBTTagCompound nbt = stack.getSubCompound("PartData");

        if (nbt == null) {
            return null;
        }

        String group = nbt.getString("PartGroup");

        return PartGroup.valueOf(group);
    }
}
