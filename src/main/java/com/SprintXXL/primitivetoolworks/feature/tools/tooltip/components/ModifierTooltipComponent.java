package com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipComponent;
import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipContext;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class ModifierTooltipComponent implements TooltipComponent {

    @Override
    public void addLines(TooltipContext context, List<String> tooltip) {

        int remainingSlots = ToolModifierSlotNBT.getRemainingModifierSlots(context.getStack());

        tooltip.add("Modifiers");
        tooltip.add("Slots Remaining:" + " " + TextFormatting.WHITE + remainingSlots);
        tooltip.add("");

        for (ModifierDefinition modifier : ModifierRegistry.getAllModifiers()) {

            int level = ToolModifierNBT.getModifierLevel(context.getStack(), modifier.getModifierID());

            if (level > 0) {
                tooltip.add(modifier.getDisplayName() + " " + TextFormatting.WHITE + toRoman(level));
                tooltip.add("");
            }
        }
    }

    private String toRoman(int level) {
        switch (level) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            default: return String.valueOf(level);
        }
    }
}
