package com.SprintXXL.primitivetoolworks.client.render.part;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverrideToolPart extends ItemOverrideList {

    private final IBakedModel partModel;

    public ModelOverrideToolPart(IBakedModel partModel) {
        super(Collections.emptyList());

        this.partModel = partModel;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel partModel, ItemStack stack, World world, EntityLivingBase entity) {

        PartRenderData data = PartRenderResolver.resolve(stack);

        return new ModelToolPart(partModel, data);
    }
}
