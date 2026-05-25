package com.SprintXXL.primitivetoolworks.client.render.parts;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import net.minecraft.item.ItemStack;

public class PartRenderResolver {

    public static PartRenderData resolve(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partType = PartNBT.getPartType(stack);
        PartGroup group = PartNBT.getPartGroup(stack);

        return new PartRenderData(materialID, partType, group);
    }
}
