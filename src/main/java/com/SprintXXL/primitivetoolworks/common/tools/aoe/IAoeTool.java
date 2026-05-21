package com.SprintXXL.primitivetoolworks.common.tools.aoe;

import net.minecraft.item.ItemStack;

public interface IAoeTool {
    AoeProfile getAoeProfile(ItemStack stack);
}
