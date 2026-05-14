package com.SprintXXL.primitivetoolworks.client.rendering;

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
