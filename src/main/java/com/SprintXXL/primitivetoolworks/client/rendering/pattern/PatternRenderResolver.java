package com.SprintXXL.primitivetoolworks.client.rendering.pattern;

import com.SprintXXL.primitivetoolworks.patterns.PatternNBT;
import net.minecraft.item.ItemStack;

public class PatternRenderResolver {

    public static PatternRenderData resolve(ItemStack stack) {

        String patternType = PatternNBT.getPatternType(stack);

        return new PatternRenderData(patternType);
    }
}
