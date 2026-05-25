package com.SprintXXL.primitivetoolworks.client.render.part;

import com.SprintXXL.primitivetoolworks.core.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.core.parts.PartNBT;
import net.minecraft.item.ItemStack;

public class PartRenderResolver {

    public static PartRenderData resolve(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partType = PartNBT.getPartType(stack);
        PartGroup group = PartNBT.getPartGroup(stack);

        return new PartRenderData(materialID, partType, group);
    }
}
