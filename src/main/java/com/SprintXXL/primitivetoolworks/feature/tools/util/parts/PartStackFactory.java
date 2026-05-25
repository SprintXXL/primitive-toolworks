package com.SprintXXL.primitivetoolworks.feature.tools.util.parts;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import net.minecraft.item.ItemStack;

public final class PartStackFactory {

    private PartStackFactory() {}

    public static ItemStack createDefaultPart(String materialID, String partID, PartGroup group) {

        ItemStack stack = new ItemStack(ModItems.PART);

        PartNBT.setMaterial(stack, materialID);
        PartNBT.setPartType(stack, partID);
        PartNBT.setPartGroup(stack, group);

        return stack;
    }
}
