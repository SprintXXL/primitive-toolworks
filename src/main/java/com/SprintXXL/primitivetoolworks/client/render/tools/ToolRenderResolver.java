package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.client.render.tools.modifiers.ModifierRenderResolver;
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
        String extraPart = ToolNBT.getExtraPart(stack);
        String handlePart = ToolNBT.getHandlePart(stack);


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
        if ("unknown".equals(extraPart)) {
            extraPart = ToolDefaults.getDefaultExtraPart(toolType);
        }
        if ("unknown".equals(handlePart)) {
            handlePart = ToolDefaults.getDefaultHandlePart(toolType);
        }

        PartDefinition mainPartID = PartRegistry.getPart(mainPart);
        PartDefinition extraPartID = PartRegistry.getPart(extraPart);
        PartDefinition handlePartID = PartRegistry.getPart(handlePart);

        if (mainPartID == null || extraPartID == null || handlePartID == null) {
            return null;
        }

        String mainID = mainPartID.getPartID();
        String extraID = extraPartID.getPartID();
        String handleID = handlePartID.getPartID();

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

        if (ToolDefaults.shouldRenderExtraLayer(toolType)) {

            if("unknown".equals(extraMaterial)) {
                extraMaterial = ToolDefaults.getDefaultExtraMaterial(toolType);
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
