package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class MiningSpeedTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        tooltip.add("Mining Speed: " + TextFormatting.WHITE + ToolCalculator.getMiningSpeed(context.getStack()));
    }
}
