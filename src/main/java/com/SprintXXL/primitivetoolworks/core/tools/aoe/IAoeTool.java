package com.SprintXXL.primitivetoolworks.core.tools.aoe;

import net.minecraft.item.ItemStack;

public interface IAoeTool {
    AoeProfile getAoeProfile(ItemStack stack);
}
