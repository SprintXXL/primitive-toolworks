package com.SprintXXL.primitivetoolworks.common.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class NBTHelper {

    public static final String UNKNOWN = "unknown";

    private NBTHelper() {}

    public static NBTTagCompound getOrCreateSubCompound(ItemStack stack, String compoundKey) {
        return stack.getOrCreateSubCompound(compoundKey);
    }

    public static NBTTagCompound getSubCompound(ItemStack stack, String compoundKey) {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.getSubCompound(compoundKey);
    }

    public static void setString(ItemStack stack, String compoundKey, String key, String value) {
        getOrCreateSubCompound(stack, compoundKey).setString(key, value);
    }

    public static String getString(ItemStack stack, String compoundKey, String key) {

        NBTTagCompound nbt = getSubCompound(stack, compoundKey);

        if (nbt == null) {
            return UNKNOWN;
        }

        String value = nbt.getString(key);

        if (value.isEmpty()) {
            return UNKNOWN;
        }

        return value;
    }


}
