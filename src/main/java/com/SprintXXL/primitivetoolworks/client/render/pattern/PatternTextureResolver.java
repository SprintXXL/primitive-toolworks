package com.SprintXXL.primitivetoolworks.client.render.pattern;

import net.minecraft.util.ResourceLocation;

public class PatternTextureResolver {

    public static ResourceLocation getPatternTexture(PatternRenderData data) {
        return new ResourceLocation("primitivetoolworks", "patterns/" + data.patternType);
    }
}
