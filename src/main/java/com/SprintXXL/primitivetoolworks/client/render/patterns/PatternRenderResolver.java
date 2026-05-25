package com.SprintXXL.primitivetoolworks.client.render.patterns;

import com.SprintXXL.primitivetoolworks.library.patterns.nbt.PatternNBT;
import net.minecraft.item.ItemStack;

public class PatternRenderResolver {

    public static PatternRenderData resolve(ItemStack stack) {

        String patternType = PatternNBT.getPatternType(stack);

        return new PatternRenderData(patternType);
    }
}
