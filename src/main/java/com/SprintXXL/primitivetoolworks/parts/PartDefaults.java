package com.SprintXXL.primitivetoolworks.parts;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import com.SprintXXL.primitivetoolworks.materials.MaterialIDs;
import net.minecraft.item.ItemStack;

public class PartDefaults {

    public static final String DEFAULT_MAIN_MATERIAL = MaterialIDs.FLINT;
    public static final String DEFAULT_EXTRA_MATERIAL = MaterialIDs.BONE;
    public static final String DEFAULT_HANDLE_MATERIAL = MaterialIDs.WOOD;

    public static final String DEFAULT_MAIN_PART = PartIDs.PICKAXE_HEAD;
    public static final String DEFAULT_EXTRA_PART = PartIDs.BINDING;
    public static final String DEFAULT_HANDLE_PART = PartIDs.HANDLE;

    public static final String DEFAULT_MAIN_RENDER_ROLE = "main";
    public static final String DEFAULT_EXTRA_RENDER_ROLE = "extra";
    public static final String DEFAULT_HANDLE_RENDER_ROLE = "handle";

    public static ItemStack createDefaultPickaxeHead() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_MAIN_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_MAIN_PART);
        PartNBT.setRenderRole(stack, DEFAULT_MAIN_RENDER_ROLE);

        return stack;
    }
    public static ItemStack createDefaultBinding() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_EXTRA_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_EXTRA_PART);
        PartNBT.setRenderRole(stack, DEFAULT_EXTRA_RENDER_ROLE);

        return stack;
    }
    public static ItemStack createDefaultHandle() {
        ItemStack stack = new ItemStack(ModItems.TOOL_PART);

        PartNBT.setMaterial(stack, DEFAULT_HANDLE_MATERIAL);
        PartNBT.setPartType(stack, DEFAULT_HANDLE_PART);
        PartNBT.setRenderRole(stack, DEFAULT_HANDLE_RENDER_ROLE);

        return stack;
    }
}
