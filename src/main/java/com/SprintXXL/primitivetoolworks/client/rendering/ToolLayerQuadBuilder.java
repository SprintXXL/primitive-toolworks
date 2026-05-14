package com.SprintXXL.primitivetoolworks.client.rendering;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.model.ItemLayerModel;

import java.util.List;
import java.util.Optional;

public class ToolLayerQuadBuilder {

    public static List<BakedQuad> buildLayer(TextureAtlasSprite sprite) {

        return ItemLayerModel.getQuadsForSprite(
                0,
                sprite,
                DefaultVertexFormats.ITEM,
                Optional.empty()
        );
    }
}
