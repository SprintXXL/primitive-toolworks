package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierIDs;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ModifierTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        int hasteLevel = ToolModifierNBT.getModifierLevel(context.getStack(), ModifierIDs.HASTE);

        if (hasteLevel <= 0) {
            return;
        }

        tooltip.add("Haste: " + TextFormatting.WHITE + hasteLevel);
        tooltip.add("");
    }
}
