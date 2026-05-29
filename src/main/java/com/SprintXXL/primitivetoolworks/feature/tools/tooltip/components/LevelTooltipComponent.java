package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.logic.ToolLevelCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt.ToolLevelNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class LevelTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        int level = ToolLevelNBT.getLevel(context.getStack());
        int xp = ToolLevelNBT.getXP(context.getStack());
        int totalXP = ToolLevelNBT.getTotalXP(context.getStack());

        int requiredXP = ToolLevelCalculator.getRequiredXP(level);

        tooltip.add("Level: " + TextFormatting.WHITE + level);
        tooltip.add("XP: " + TextFormatting.WHITE + xp + " / " + requiredXP);
        tooltip.add("Total XP: " + TextFormatting.WHITE + totalXP);
        tooltip.add("");
    }
}
