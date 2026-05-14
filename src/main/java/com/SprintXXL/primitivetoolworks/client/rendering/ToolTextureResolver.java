package com.SprintXXL.primitivetoolworks.client.rendering;

import net.minecraft.util.ResourceLocation;

public class ToolTextureResolver {

    public static ResourceLocation getMainTexture(ToolRenderData data) {
        return new ResourceLocation("primitivetoolworks", "tools/pickaxe_head_flint");
    }

    public static ResourceLocation getExtraTexture(ToolRenderData data) {
        return null;
    }

    public static ResourceLocation getHandleTexture(ToolRenderData data) {
        return new ResourceLocation("primitivetoolworks", "tools/handle_wood");
    }
}
