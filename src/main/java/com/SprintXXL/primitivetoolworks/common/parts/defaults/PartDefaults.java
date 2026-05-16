package com.SprintXXL.primitivetoolworks.common.parts.defaults;

import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartIDs;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import net.minecraft.item.ItemStack;

public class PartDefaults {

    public static final String DEFAULT_MAIN_MATERIAL = MaterialIDs.FLINT;
    public static final String DEFAULT_EXTRA_MATERIAL = MaterialIDs.BONE;
    public static final String DEFAULT_HANDLE_MATERIAL = MaterialIDs.WOOD;

    public static final String DEFAULT_MAIN_PART = PartIDs.PICKAXE_HEAD;
    public static final String DEFAULT_EXTRA_PART = PartIDs.BINDING;
    public static final String DEFAULT_HANDLE_PART = PartIDs.HANDLE;

    public static final PartGroup DEFAULT_MAIN_GROUP = PartGroup.MAIN;
    public static final PartGroup DEFAULT_EXTRA_GROUP = PartGroup.EXTRA;
    public static final PartGroup DEFAULT_HANDLE_GROUP = PartGroup.HANDLE;

    public static ItemStack createDefaultPickaxeHead() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_MAIN_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_MAIN_PART);
        PartNBT.setPartGroup(stack, DEFAULT_MAIN_GROUP);

        return stack;
    }
    public static ItemStack createDefaultBinding() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_EXTRA_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_EXTRA_PART);
        PartNBT.setPartGroup(stack, DEFAULT_EXTRA_GROUP);

        return stack;
    }
    public static ItemStack createDefaultHandle() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_HANDLE_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_HANDLE_PART);
        PartNBT.setPartGroup(stack, DEFAULT_HANDLE_GROUP);

        return stack;
    }
}
