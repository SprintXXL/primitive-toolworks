package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import net.minecraft.item.ItemStack;

public final class ToolDisplayNameHelper {

    private ToolDisplayNameHelper() {}

    public static String getDisplayName(ItemStack stack, ToolType fallbackToolType, String toolName) {

        ToolType toolType = ToolNBT.getToolType(stack);

        if (toolType == null) {
            toolType = fallbackToolType;
        }

        Material mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(toolType.getDefaultMainMaterial());
        }

        if (mainMaterial == null) {
            return "Modular " + toolName;
        }

        return mainMaterial.getTitleDisplayName() + " " + toolName;
    }


}
