package com.SprintXXL.primitivetoolworks.patterns;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import net.minecraft.item.ItemStack;

public class PatternDefaults {

    public static final String DEFAULT_PICKAXE_HEAD_PATTERN = PatternIDs.PICKAXE_HEAD;
    public static final String DEFAULT_BINDING_PATTERN = PatternIDs.BINDING;
    public static final String DEFAULT_HANDLE_PATTERN = PatternIDs.HANDLE;

    public static ItemStack createDefaultPickaxeHeadPattern() {

        ItemStack stack = new ItemStack(ModItems.PART_PATTERN);

        PatternNBT.setPatternType(stack, PatternIDs.PICKAXE_HEAD);

        return stack;
    }
    public static ItemStack createDefaultBindingPattern() {

        ItemStack stack = new ItemStack(ModItems.PART_PATTERN);

        PatternNBT.setPatternType(stack, PatternIDs.BINDING);

        return stack;
    }
    public static ItemStack createDefaultHandlePattern() {

        ItemStack stack = new ItemStack(ModItems.PART_PATTERN);

        PatternNBT.setPatternType(stack, PatternIDs.HANDLE);

        return stack;
    }
}
