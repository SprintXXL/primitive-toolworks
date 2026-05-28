package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt;

import com.SprintXXL.primitivetoolworks.common.util.NBTHelper;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import net.minecraft.item.ItemStack;

public final class ToolModifierSlotNBT {

    private static final String MODIFIER_SLOT_DATA = "ModifierSlotData";
    private static final String TOTAL_SLOTS = "TotalSlots";

    private ToolModifierSlotNBT() {}

    public static void setModifierSlots(ItemStack stack, int slots) {
        NBTHelper.setInteger(stack, MODIFIER_SLOT_DATA, TOTAL_SLOTS, slots);
    }

    public static int getModifierSlots(ItemStack stack) {
        return NBTHelper.getInteger(stack, MODIFIER_SLOT_DATA, TOTAL_SLOTS);
    }

    public static void addModifierSlots(ItemStack stack, int amount) {

        int currentSlots = getModifierSlots(stack);

        setModifierSlots(stack, currentSlots + amount);

    }

    public static int getUsedModifierSlots(ItemStack stack) {

        int usedSlots = 0;

        for (ModifierDefinition modifier : ModifierRegistry.getAllModifiers()) {

            int level = ToolModifierNBT.getModifierLevel(stack, modifier.getModifierID());
            usedSlots += level;
        }

        return usedSlots;
    }

    public static int getRemainingModifierSlots(ItemStack stack) {

        int totalSlots = getModifierSlots(stack);
        int usedSlots = getUsedModifierSlots(stack);

        return totalSlots - usedSlots;
    }
}
