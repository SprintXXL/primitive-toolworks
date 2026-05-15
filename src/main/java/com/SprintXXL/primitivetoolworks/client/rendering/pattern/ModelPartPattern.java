package com.SprintXXL.primitivetoolworks.client.rendering.pattern;

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

public class ModelPartPattern implements IBakedModel {

    private final IBakedModel patternModel;
    private final PatternRenderData renderData;

    public ModelPartPattern(IBakedModel patternModel, PatternRenderData renderData) {

        this.patternModel = patternModel;
        this.renderData = renderData;
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (renderData == null) {
            return patternModel.getQuads(state, side, rand);
        }

        if (side != null) {
            return Collections.emptyList();
        }

        ResourceLocation texture = PatternTextureResolver.getPatternTexture(renderData);

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());

        List<BakedQuad> quads = new ArrayList<>();

        quads.addAll(LayerQuadBuilder.buildLayer(sprite));

        return quads;
    }

    @Override
    public boolean isGui3d() {
        return patternModel.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return patternModel.isBuiltInRenderer();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return patternModel.isAmbientOcclusion();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return patternModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ModelOverridePartPattern(this);
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return patternModel.getItemCameraTransforms();
    }
}
