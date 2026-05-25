package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class HarvestLevelTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        tooltip.add("Harvest Level: " + TextFormatting.WHITE + ToolCalculator.getHarvestLevel(context.getStack()));
    }
}
