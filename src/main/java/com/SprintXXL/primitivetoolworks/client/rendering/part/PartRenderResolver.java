package com.SprintXXL.primitivetoolworks.client.rendering.part;

import com.SprintXXL.primitivetoolworks.parts.PartNBT;
import net.minecraft.item.ItemStack;

public class PartRenderResolver {

    public static PartRenderData resolve(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partType = PartNBT.getPartType(stack);

        return new PartRenderData(materialID, partType);
    }
}
