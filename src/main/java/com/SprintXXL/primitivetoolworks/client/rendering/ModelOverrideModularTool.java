package com.SprintXXL.primitivetoolworks.client.rendering;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverrideModularTool extends ItemOverrideList {

    private final IBakedModel originalModel;

    public ModelOverrideModularTool(IBakedModel originalModel) {
        super(Collections.emptyList());

        this.originalModel = originalModel;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity) {

        ToolRenderData data = ToolRenderResolver.resolve(stack);

        return new ModelModularTool(originalModel, data);
    }
}
