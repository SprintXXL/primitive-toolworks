package com.SprintXXL.primitivetoolworks.client.render.tools;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverrideModularTool extends ItemOverrideList {

    private final IBakedModel toolModel;

    public ModelOverrideModularTool(IBakedModel toolModel) {
        super(Collections.emptyList());

        this.toolModel = toolModel;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel toolModel, ItemStack stack, World world, EntityLivingBase entity) {

        ToolRenderData data = ToolRenderResolver.resolve(stack);

        return new ModelModularTool(toolModel, data);
    }


}
