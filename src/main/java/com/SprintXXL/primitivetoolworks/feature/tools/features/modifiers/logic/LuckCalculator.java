package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierIDs;
import net.minecraft.item.ItemStack;

public final class LuckCalculator {

    private LuckCalculator() {}

    public static int getFortuneLevel(ItemStack stack) {

        int luckLevel = ToolModifierNBT.getModifierLevel(stack, ModifierIDs.LUCK);

        return luckLevel;
    }

    public static int getLootingLevel(ItemStack stack) {

        int lootingLevel = ToolModifierNBT.getModifierLevel(stack, ModifierIDs.LUCK);

        return lootingLevel;
    }
}
