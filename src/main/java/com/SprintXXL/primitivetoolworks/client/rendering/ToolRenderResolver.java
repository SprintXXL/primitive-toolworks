package com.SprintXXL.primitivetoolworks.client.rendering;

import com.SprintXXL.primitivetoolworks.tools.ToolDefaults;
import com.SprintXXL.primitivetoolworks.tools.ToolNBT;
import net.minecraft.item.ItemStack;

public class ToolRenderResolver {

    public static ToolRenderData resolve(ItemStack stack) {

        String mainMaterial = ToolNBT.getMainMaterial(stack);
        String mainPart = ToolNBT.getMainPart(stack);

        String extraMaterial = ToolNBT.getExtraMaterial(stack);
        String extraPart = ToolNBT.getExtraPart(stack);

        String handleMaterial = ToolNBT.getHandleMaterial(stack);
        String handlePart = ToolNBT.getHandlePart(stack);

        if ("unknown".equals(mainMaterial)) {
            mainMaterial = ToolDefaults.DEFAULT_MAIN_MATERIAL;
        }
        if ("unknown".equals(mainPart)) {
            mainPart = ToolDefaults.DEFAULT_MAIN_PART;
        }

        if ("unknown".equals(extraMaterial)) {
            extraMaterial = ToolDefaults.DEFAULT_EXTRA_MATERIAL;
        }
        if ("unknown".equals(extraPart)) {
            extraPart = ToolDefaults.DEFAULT_EXTRA_PART;
        }

        if ("unknown".equals(handleMaterial)) {
            handleMaterial = ToolDefaults.DEFAULT_HANDLE_MATERIAL;
        }
        if ("unknown".equals(handlePart)) {
            handlePart = ToolDefaults.DEFAULT_HANDLE_PART;
        }

        return new ToolRenderData(
                mainMaterial,
                mainPart,
                extraMaterial,
                extraPart,
                handleMaterial,
                handlePart
        );
    }
}
