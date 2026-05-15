package com.SprintXXL.primitivetoolworks.client.rendering.part;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverrideToolPart extends ItemOverrideList {

    private final IBakedModel baseModel;

    public ModelOverrideToolPart(IBakedModel baseModel) {
        super(Collections.emptyList());

        this.baseModel = baseModel;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel baseModel, ItemStack stack, World world, EntityLivingBase entity) {

        PartRenderData data = PartRenderResolver.resolve(stack);

        return new ModelToolPart(baseModel, data);
    }
}
