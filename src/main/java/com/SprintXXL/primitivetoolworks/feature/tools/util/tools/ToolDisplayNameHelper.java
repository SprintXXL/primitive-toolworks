package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaults;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import net.minecraft.item.ItemStack;

public final class ToolDisplayNameHelper {

    private ToolDisplayNameHelper() {}

    public static String getDisplayName(ItemStack stack, ToolType fallbackToolType, String toolName) {

        ToolType toolType = ToolNBT.getToolType(stack);

        if (toolType == null) {
            toolType = fallbackToolType;
        }

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.getDefaultMainMaterial(toolType));
        }

        if (mainMaterial == null) {
            return "Modular " + toolName;
        }

        return mainMaterial.getTitleDisplayName() + " " + toolName;
    }


}
