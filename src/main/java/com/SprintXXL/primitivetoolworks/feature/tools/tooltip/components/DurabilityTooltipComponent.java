package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class DurabilityTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        int maxDurability = ToolCalculator.getDurability(context.getStack());
        int remainingDurability = maxDurability - context.getStack().getItemDamage();

        tooltip.add("Durability: " + TextFormatting.WHITE + remainingDurability + " / " + maxDurability);
    }
}
