package com.SprintXXL.primitivetoolworks.client.rendering.part;

import net.minecraft.util.ResourceLocation;

public class PartTextureResolver {

    public static ResourceLocation getMainPartTexture(PartRenderData data) {
        return new ResourceLocation("primitivetoolworks", "parts/main/" + data.partType + "/" + data.materialID);
    }
    public static ResourceLocation getExtraPartTexture(PartRenderData data) {
        return new ResourceLocation("primitivetoolworks", "parts/extra/" + data.partType + "/" + data.materialID);
    }
    public static ResourceLocation getHandlePartTexture(PartRenderData data) {
        return new ResourceLocation("primitivetoolworks", "parts/handle/" + data.partType + "/" + data.materialID);
    }
}
