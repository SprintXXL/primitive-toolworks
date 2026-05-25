package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartDefinition;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaults;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ToolRenderResolver {

    public static ToolRenderData resolve(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String mainMaterial = ToolNBT.getMainMaterial(stack);
        String extraMaterial = ToolNBT.getExtraMaterial(stack);
        String handleMaterial = ToolNBT.getHandleMaterial(stack);

        String mainPart = ToolNBT.getMainPart(stack);


        if ("unknown".equals(mainMaterial)) {
            mainMaterial = ToolDefaults.getDefaultMainMaterial(toolType);
        }
        if ("unknown".equals(extraMaterial)) {
            extraMaterial = ToolDefaults.getDefaultExtraMaterial(toolType);
        }
        if ("unknown".equals(handleMaterial)) {
            handleMaterial = ToolDefaults.getDefaultHandleMaterial(toolType);
        }

        if ("unknown".equals(mainPart)) {
            mainPart = ToolDefaults.getDefaultMainPart(toolType);
        }

        PartDefinition partDefinition = PartRegistry.getPart(mainPart);

        if (partDefinition == null) {
            return null;
        }

        List<ToolLayerRenderData> layers = new ArrayList<>();

        layers.add(new ToolLayerRenderData(
                toolType,
                PartGroup.HANDLE,
                handleMaterial
        ));

        layers.add(new ToolLayerRenderData(
                toolType,
                PartGroup.MAIN,
                mainMaterial
        ));

        if (ToolDefaults.shouldRenderExtraLayer(toolType)) {

            if("unknown".equals(extraMaterial)) {
                extraMaterial = ToolDefaults.getDefaultExtraMaterial(toolType);
        }

            layers.add(new ToolLayerRenderData(
                    toolType,
                    PartGroup.EXTRA,
                    extraMaterial
            ));
        }

        return new ToolRenderData(toolType, layers);
    }
}
