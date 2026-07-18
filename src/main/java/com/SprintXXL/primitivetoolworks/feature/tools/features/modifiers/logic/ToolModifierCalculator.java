package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.library.modifiers.Modifier;
import com.SprintXXL.primitivetoolworks.library.modifiers.definitions.ModifierIDs;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.MiningSpeedModifierStats;
import net.minecraft.item.ItemStack;

public final class ToolModifierCalculator {

    private ToolModifierCalculator() {}

    public static float getMiningSpeedBonus(ItemStack stack) {

        int hasteLevel = ToolModifierNBT.getModifierLevel(stack, ModifierIDs.HASTE);

        Modifier haste = ModifierRegistry.getModifier(ModifierIDs.HASTE);

        if (haste == null || !(haste.getStats() instanceof MiningSpeedModifierStats)) {
            return 0.0F;
        }

        MiningSpeedModifierStats stats = (MiningSpeedModifierStats) haste.getStats();

        return hasteLevel * stats.getSpeedPerLevel();
    }
}
