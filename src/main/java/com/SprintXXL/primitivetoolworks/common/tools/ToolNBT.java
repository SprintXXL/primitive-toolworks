package com.SprintXXL.primitivetoolworks.common.tools;

import com.SprintXXL.primitivetoolworks.common.tools.types.ToolType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ToolNBT {

    public static String TOOL_TYPE = "ToolType";

    // Tool Type

    public static void setToolType(ItemStack stack, ToolType toolType) {

        NBTTagCompound nbt = stack.getOrCreateSubCompound("ToolData");

        nbt.setString(TOOL_TYPE, toolType.getID());
    }

    public static ToolType getToolType(ItemStack stack) {

        if (stack.isEmpty()) {
            return ToolType.PICKAXE;
        }

        NBTTagCompound nbt = stack.getSubCompound("ToolData");

        if (nbt == null) {

            return ToolType.PICKAXE;
        }

        String toolTypeID = nbt.getString(TOOL_TYPE);

        return ToolType.fromID(toolTypeID);
    }

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

        String value = nbt.getString("MainMaterial");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
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

        String value = nbt.getString("MainPart");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
    }

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

        String value = nbt.getString("HandleMaterial");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
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

        String value = nbt.getString("HandlePart");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
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

        String value = nbt.getString("ExtraMaterial");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
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

        String value = nbt.getString("ExtraPart");

        if (value.isEmpty()) {
            return "unknown";
        }

        return value;
    }
}
