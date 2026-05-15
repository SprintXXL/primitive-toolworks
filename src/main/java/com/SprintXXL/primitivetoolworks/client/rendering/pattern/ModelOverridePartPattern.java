package com.SprintXXL.primitivetoolworks.client.rendering.pattern;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverridePartPattern extends ItemOverrideList {

    private final IBakedModel patternModel;

    public ModelOverridePartPattern(IBakedModel patternModel) {
        super(Collections.emptyList());

        this.patternModel = patternModel;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel patternModel, ItemStack stack, World world, EntityLivingBase entity) {

        PatternRenderData data = PatternRenderResolver.resolve(stack);

        return new ModelPartPattern(patternModel, data);
    }
}
