package com.SprintXXL.primitivetoolworks.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ToolNBT {

    // Main Material

    public static void setMainMaterial(ItemStack stack, String material) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");

        nbt.setString("MainMaterial", material);
    }

    public static String getMainMaterial(ItemStack stack) {

        NBTTagCompound nbt = stack.getSubCompound("ToolData");

        if (nbt == null) {

            return "unknown";
        }

        return nbt.getString("MainMaterial");
    }

    // Main Part

    public static void setMainPart(ItemStack stack, String part) {
        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");
        nbt.setString("MainPart", part);
    }

    public static String getMainPart(ItemStack stack) {
        NBTTagCompound nbt = stack.getSubCompound("ToolData");
        if (nbt == null) {
            return "unknown";
        }
        return nbt.getString("MainPart");
    }

    //
    //
    //

    // Handle Material

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

    // Handle Part

    public static void setHandlePart(ItemStack stack, String part) {
        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");
        nbt.setString("HandlePart", part);
    }

    public static String getHandlePart(ItemStack stack) {
        NBTTagCompound nbt = stack.getSubCompound("ToolData");
        if (nbt == null) {
            return "unknown";
        }
        return nbt.getString("HandlePart");
    }

    //
    //
    //

    // Extra Material

    public static void setExtraMaterial(ItemStack stack, String material) {
        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");
        nbt.setString("ExtraMaterial", material);
    }

    public static String getExtraMaterial(ItemStack stack) {

        NBTTagCompound nbt = stack.getSubCompound("ToolData");

        if (nbt == null) {
            return "unknown";
        }

        return nbt.getString("ExtraMaterial");
    }

    // Extra Part

    public static void setExtraPart(ItemStack stack, String part) {
        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");
        nbt.setString("ExtraPart", part);
    }

    public static String getExtraPart(ItemStack stack) {
        NBTTagCompound nbt = stack.getSubCompound("ToolData");
        if (nbt == null) {
            return "unknown";
        }
        return nbt.getString("ExtraPart");
    }
}
