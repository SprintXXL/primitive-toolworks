package com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt;

import com.SprintXXL.primitivetoolworks.common.util.NBTHelper;
import net.minecraft.item.ItemStack;

public final class ToolLevelNBT {

    private static final String LEVEL_DATA = "ToolLevels";

    private ToolLevelNBT() {}

    public static void setLevel(ItemStack stack, int level) {
        NBTHelper.setInteger(stack, LEVEL_DATA, "level", level);
    }

    public static int getLevel(ItemStack stack) {
        return NBTHelper.getInteger(stack, LEVEL_DATA, "level");
    }

    public static void setXP(ItemStack stack, int xp) {
        NBTHelper.setInteger(stack, LEVEL_DATA, "xp", xp);
    }

    public static int getXP(ItemStack stack) {
        return NBTHelper.getInteger(stack, LEVEL_DATA, "xp");
    }

    public static void addXP(ItemStack stack, int amount) {

        int currentXP = getXP(stack);

        int newXP = currentXP + amount;

        setXP(stack, newXP);

    }

    public static void setTotalXP(ItemStack stack, int totalXP) {
        NBTHelper.setInteger(stack, LEVEL_DATA, "totalXP", totalXP);
    }

    public static int getTotalXP(ItemStack stack) {
        return NBTHelper.getInteger(stack, LEVEL_DATA, "totalXP");
    }

    public static void addTotalXP(ItemStack stack, int amount) {

        int currentTotalXP = getTotalXP(stack);

        int newTotalXP = currentTotalXP + amount;

        setTotalXP(stack, newTotalXP);
    }
}
