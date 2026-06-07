package com.SprintXXL.primitivetoolworks.client.render.tools;

import net.minecraft.util.ResourceLocation;

public class ToolTextureResolver {

    public static ResourceLocation getToolLayerTexture(ToolLayerRenderData data) {

        if (data.customTexture != null) {
            return data.customTexture;
        }

        return new ResourceLocation(
                "primitivetoolworks",
                "generated/" + data.materialID + "_" + data.partID + "_layer"
        );
    }
}
