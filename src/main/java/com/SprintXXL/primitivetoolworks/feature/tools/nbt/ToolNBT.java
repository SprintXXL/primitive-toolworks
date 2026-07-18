package com.SprintXXL.primitivetoolworks.feature.tools.nbt;

import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.SprintXXL.primitivetoolworks.library.tooltypes.registry.ToolTypeRegistry;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.util.NBTHelper.*;

public final class ToolNBT {

    private static final String TOOL_DATA = "ToolData";

    private static final String TOOL_TYPE = "ToolType";

    private static final String MAIN_PART = "MainPart";
    private static final String MAIN_MATERIAL = "MainMaterial";

    private static final String EXTRA_PART = "ExtraPart";
    private static final String EXTRA_MATERIAL = "ExtraMaterial";

    private static final String HANDLE_PART = "HandlePart";
    private static final String HANDLE_MATERIAL = "HandleMaterial";

    private ToolNBT() {}

    public static void setToolType(ItemStack stack, ToolType toolType) {
        setString(stack, TOOL_DATA, TOOL_TYPE, toolType.getID());
    }

    public static ToolType getToolType(ItemStack stack) {

        String toolTypeID = getString(stack, TOOL_DATA, TOOL_TYPE);

        if (UNKNOWN.equals(toolTypeID)) {
            return null;
        }

        ToolType toolType = ToolTypeRegistry.getToolType(toolTypeID);

        if (toolType == null) {
            return null;
        }

        return toolType;
    }

    public static void setMainPart(ItemStack stack, String part) {
        setString(stack, TOOL_DATA, MAIN_PART, part);
    }
    public static String getMainPart(ItemStack stack) {
        return getString(stack, TOOL_DATA, MAIN_PART);
    }

    public static void setMainMaterial(ItemStack stack, String material) {
        setString(stack, TOOL_DATA, MAIN_MATERIAL, material);
    }
    public static String getMainMaterial(ItemStack stack) {
        return getString(stack, TOOL_DATA, MAIN_MATERIAL);
    }

    public static void setExtraPart(ItemStack stack, String part) {
        setString(stack, TOOL_DATA, EXTRA_PART, part);
    }
    public static String getExtraPart(ItemStack stack) {
        return getString(stack, TOOL_DATA, EXTRA_PART);
    }

    public static void setExtraMaterial(ItemStack stack, String material) {
        setString(stack, TOOL_DATA, EXTRA_MATERIAL, material);
    }
    public static String getExtraMaterial(ItemStack stack) {
        return getString(stack, TOOL_DATA, EXTRA_MATERIAL);
    }

    public static void setHandlePart(ItemStack stack, String part) {
        setString(stack, TOOL_DATA, HANDLE_PART, part);
    }
    public static String getHandlePart(ItemStack stack) {
        return getString(stack, TOOL_DATA, HANDLE_PART);
    }

    public static void setHandleMaterial(ItemStack stack, String material) {
        setString(stack, TOOL_DATA, HANDLE_MATERIAL, material);
    }
    public static String getHandleMaterial(ItemStack stack) {
        return getString(stack, TOOL_DATA, HANDLE_MATERIAL);
    }
}
