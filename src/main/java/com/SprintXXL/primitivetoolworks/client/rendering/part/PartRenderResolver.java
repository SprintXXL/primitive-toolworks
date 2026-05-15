package com.SprintXXL.primitivetoolworks.client.rendering.part;

import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import net.minecraft.item.ItemStack;

public class PartRenderResolver {

    public static PartRenderData resolve(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partType = PartNBT.getPartType(stack);
        String renderRole = PartNBT.getRenderRole(stack);

        return new PartRenderData(materialID, partType, renderRole);
    }
}
