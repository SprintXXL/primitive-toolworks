package com.SprintXXL.primitivetoolworks.client.rendering.tool;

import net.minecraft.util.ResourceLocation;

public class ToolTextureResolver {

    public static ResourceLocation getHandleTexture(ToolRenderData data) {
        return new ResourceLocation("primitivetoolworks", "tool_layers/pickaxe/0_handle/wood");
    }

    public static ResourceLocation getMainTexture(ToolRenderData data) {
        return new ResourceLocation("primitivetoolworks", "tool_layers/pickaxe/1_main/flint");
    }
}
