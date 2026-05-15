package com.SprintXXL.primitivetoolworks.client.rendering.tool;

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
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelModularTool implements IBakedModel {

    private final IBakedModel originalModel;
    private final ToolRenderData renderData;

    public ModelModularTool(IBakedModel originalModel, ToolRenderData renderData) {

        this.originalModel = originalModel;
        this.renderData = renderData;
    }

    @Override
    public boolean isGui3d() {
        return originalModel.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return originalModel.isBuiltInRenderer();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return originalModel.isAmbientOcclusion();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return originalModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ModelOverrideModularTool(originalModel);
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return originalModel.getItemCameraTransforms();
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        Pair<? extends IBakedModel, Matrix4f> pair = originalModel.handlePerspective(cameraTransformType);

        return Pair.of(this, pair.getRight());
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (renderData == null) {
            return originalModel.getQuads(state, side, rand);
        }

        if (side != null) {
            return Collections.emptyList();
        }

        ResourceLocation mainTexture = ToolTextureResolver.getMainTexture(renderData);
        ResourceLocation handleTexture = ToolTextureResolver.getHandleTexture(renderData);

        TextureAtlasSprite mainSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(mainTexture.toString());
        TextureAtlasSprite handleSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(handleTexture.toString());

        List<BakedQuad> quads = new ArrayList<>();

        quads.addAll(LayerQuadBuilder.buildLayer(handleSprite));
        quads.addAll(LayerQuadBuilder.buildLayer(mainSprite));

        return quads;
    }
}
