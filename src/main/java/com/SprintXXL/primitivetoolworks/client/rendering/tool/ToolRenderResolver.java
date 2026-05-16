package com.SprintXXL.primitivetoolworks.client.rendering.tool;

import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.ToolType;
import com.SprintXXL.primitivetoolworks.common.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.PartStats;
import com.SprintXXL.primitivetoolworks.common.tools.defaults.ToolDefaults;
import com.SprintXXL.primitivetoolworks.common.tools.ToolNBT;
import net.minecraft.item.ItemStack;

public class ToolRenderResolver {

    public static ToolRenderData resolve(ItemStack stack) {

        String mainMaterial = ToolNBT.getMainMaterial(stack);
        String mainPart = ToolNBT.getMainPart(stack);

        String handleMaterial = ToolNBT.getHandleMaterial(stack);
        String handlePart = ToolNBT.getHandlePart(stack);

        if ("unknown".equals(mainMaterial)) {
            mainMaterial = ToolDefaults.DEFAULT_MAIN_MATERIAL;
        }
        if ("unknown".equals(mainPart)) {
            mainPart = ToolDefaults.DEFAULT_MAIN_PART;
        }

        if ("unknown".equals(handleMaterial)) {
            handleMaterial = ToolDefaults.DEFAULT_HANDLE_MATERIAL;
        }
        if ("unknown".equals(handlePart)) {
            handlePart = ToolDefaults.DEFAULT_HANDLE_PART;
        }

        PartDefinition partDefinition = PartRegistry.getPart(mainPart);

        if (partDefinition == null) {
            return null;
        }

        PartStats stats = partDefinition.getStats();

        if(!(stats instanceof MainPartStats)) {
            return null;
        }

        MainPartStats mainStats = (MainPartStats) stats;

        ToolType toolType = mainStats.getType();

        return new ToolRenderData(
                toolType,
                mainMaterial,
                mainPart,
                handleMaterial,
                handlePart
        );
    }
}
