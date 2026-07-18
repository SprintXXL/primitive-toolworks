package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.util.MaterialUtil;

import java.util.List;

public class MaterialTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        Material mainMaterial = MaterialUtil.getMaterialOrDefault(
                ToolNBT.getMainMaterial(context.getStack()),
                context.getToolType().getDefaultMainMaterial());

        Material extraMaterial = MaterialUtil.getMaterialOrDefault(
                ToolNBT.getExtraMaterial(context.getStack()),
                context.getToolType().getDefaultExtraMaterial());

        Material handleMaterial = MaterialUtil.getMaterialOrDefault(
                ToolNBT.getHandleMaterial(context.getStack()),
                context.getToolType().getDefaultHandleMaterial());

        if (mainMaterial == null || extraMaterial == null || handleMaterial == null) {
            tooltip.add("Unknown");
            return;
        }

        tooltip.add("");
        tooltip.add("Main Material: " + mainMaterial.getFormattedDisplayName());
        tooltip.add("Extra Material: " + extraMaterial.getFormattedDisplayName());
        tooltip.add("Handle Material: " + handleMaterial.getFormattedDisplayName());
        tooltip.add("");
    }
}
