package com.SprintXXL.primitivetoolworks.client.rendering.part;

import com.SprintXXL.primitivetoolworks.client.rendering.common.LayerQuadBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelToolPart implements IBakedModel {

    private final IBakedModel baseModel;
    private final PartRenderData renderData;

    public ModelToolPart(IBakedModel baseModel, PartRenderData renderData) {

        this.baseModel = baseModel;
        this.renderData = renderData;
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (renderData == null) {
            return baseModel.getQuads(state, side, rand);
        }

        if (side != null) {
            return Collections.emptyList();
        }

        ResourceLocation texture = PartTextureResolver.getPartTexture(renderData);

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());

        List<BakedQuad> quads = new ArrayList<>();

        quads.addAll(LayerQuadBuilder.buildLayer(sprite));

        return quads;
     }

    @Override
    public boolean isGui3d() {
        return baseModel.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return baseModel.isBuiltInRenderer();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return baseModel.isAmbientOcclusion();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return baseModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ModelOverrideToolPart(this);
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return baseModel.getItemCameraTransforms();
    }
}
