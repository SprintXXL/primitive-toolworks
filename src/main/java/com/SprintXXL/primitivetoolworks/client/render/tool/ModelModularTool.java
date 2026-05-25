package com.SprintXXL.primitivetoolworks.client.render.tool;

import com.SprintXXL.primitivetoolworks.client.render.common.LayerQuadBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelModularTool implements IBakedModel {

    private final IBakedModel toolModel;
    private final ToolRenderData renderData;

    public ModelModularTool(IBakedModel toolModel, ToolRenderData renderData) {

        this.toolModel = toolModel;
        this.renderData = renderData;
    }

    @Override
    public boolean isGui3d() {
        return toolModel.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return toolModel.isBuiltInRenderer();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return toolModel.isAmbientOcclusion();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return toolModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ModelOverrideModularTool(toolModel);
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return toolModel.getItemCameraTransforms();
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        Pair<? extends IBakedModel, Matrix4f> pair = toolModel.handlePerspective(cameraTransformType);

        return Pair.of(this, pair.getRight());
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (renderData == null) {
            return toolModel.getQuads(state, side, rand);
        }

        if (side != null) {
            return Collections.emptyList();
        }

        List<BakedQuad> quads = new ArrayList<>();

        for (ToolLayerRenderData layer : renderData.layers) {

            ResourceLocation texture = ToolTextureResolver.getToolLayerTexture(layer);

            TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());

            quads.addAll(LayerQuadBuilder.buildLayer(sprite));
        }

        return quads;
    }
}
