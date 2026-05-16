package com.SprintXXL.primitivetoolworks.client.rendering.part;

import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import net.minecraft.item.ItemStack;

public class PartRenderResolver {

    public static PartRenderData resolve(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partType = PartNBT.getPartType(stack);
        PartGroup group = PartNBT.getPartGroup(stack);

        return new PartRenderData(materialID, partType, group);
    }
}
