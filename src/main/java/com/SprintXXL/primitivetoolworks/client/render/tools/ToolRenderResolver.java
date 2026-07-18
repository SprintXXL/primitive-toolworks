package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.client.render.tools.modifiers.ModifierRenderResolver;
import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
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
        String extraPart = ToolNBT.getExtraPart(stack);
        String handlePart = ToolNBT.getHandlePart(stack);


        if ("unknown".equals(mainMaterial)) {
            mainMaterial = toolType.getDefaultMainMaterial();
        }
        if ("unknown".equals(extraMaterial)) {
            extraMaterial = toolType.getDefaultExtraMaterial();
        }
        if ("unknown".equals(handleMaterial)) {
            handleMaterial = toolType.getDefaultHandleMaterial();
        }

        if ("unknown".equals(mainPart)) {
            mainPart = toolType.getDefaultMainPart();
        }
        if ("unknown".equals(extraPart)) {
            extraPart = toolType.getDefaultExtraPart();
        }
        if ("unknown".equals(handlePart)) {
            handlePart = toolType.getDefaultHandlePart();
        }

        Part mainPartID = PartRegistry.getPart(mainPart);
        Part extraPartID = PartRegistry.getPart(extraPart);
        Part handlePartID = PartRegistry.getPart(handlePart);

        if (mainPartID == null || extraPartID == null || handlePartID == null) {
            return null;
        }

        String mainID = mainPartID.getID();
        String extraID = extraPartID.getID();
        String handleID = handlePartID.getID();

        List<ToolLayerRenderData> layers = new ArrayList<>();

        layers.add(new ToolLayerRenderData(
                toolType,
                PartGroup.HANDLE,
                handleMaterial,
                handleID
        ));

        layers.add(new ToolLayerRenderData(
                toolType,
                PartGroup.MAIN,
                mainMaterial,
                mainID
        ));

        if (toolType.shouldRenderExtraLayer()) {

            if("unknown".equals(extraMaterial)) {
                extraMaterial = toolType.getDefaultExtraMaterial();
        }

            layers.add(new ToolLayerRenderData(
                    toolType,
                    PartGroup.EXTRA,
                    extraMaterial,
                    extraID
            ));
        }

        layers.addAll(ModifierRenderResolver.resolveModifiers(stack));

        return new ToolRenderData(toolType, layers);
    }
}
