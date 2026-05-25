package com.SprintXXL.primitivetoolworks.feature.tools.features.aoe;

import net.minecraft.item.ItemStack;

public interface IAoeTool {
    AoeProfile getAoeProfile(ItemStack stack);
}
