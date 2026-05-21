package com.SprintXXL.primitivetoolworks.common.patterns.defaults;

import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.item.ItemStack;

public class PatternDefaults {

    // Main Patterns \\
    public static ItemStack createPattern(String patternID) {

        ItemStack stack = new ItemStack(ModItems.PATTERN);
        PatternNBT.setPatternType(stack, patternID);
        return stack;
    }
}
