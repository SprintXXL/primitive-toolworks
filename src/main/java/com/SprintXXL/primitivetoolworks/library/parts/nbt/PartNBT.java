package com.SprintXXL.primitivetoolworks.library.parts.nbt;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.util.NBTHelper.*;

public final class PartNBT {

    private static final String PART_DATA = "PartData";

    private static final String PART_GROUP = "PartGroup";

    private static final String MATERIAL = "Material";
    private static final String PART_TYPE = "PartType";

    private PartNBT() {}

    public static void setPartGroup(ItemStack stack, PartGroup group) {
        setString(stack, PART_DATA, PART_GROUP, group.name());
    }
    public static PartGroup getPartGroup(ItemStack stack) {

        String value = getString(stack, PART_DATA, PART_GROUP);

        if (value.equals(UNKNOWN)) {
            return PartGroup.UNKNOWN;
        }

        try {
            return PartGroup.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            return PartGroup.UNKNOWN;
        }
    }

    public static void setMaterial(ItemStack stack, String material) {
        setString(stack, PART_DATA, MATERIAL, material);
    }
    public static String getMaterial(ItemStack stack) {
        return getString(stack, PART_DATA, MATERIAL);
    }

    public static void setPartType(ItemStack stack, String partType) {
        setString(stack, PART_DATA, PART_TYPE, partType);
    }
    public static String getPartType(ItemStack stack) {
        return getString(stack, PART_DATA, PART_TYPE);
    }
}
