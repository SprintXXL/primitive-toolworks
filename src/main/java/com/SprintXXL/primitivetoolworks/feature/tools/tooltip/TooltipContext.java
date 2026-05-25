package com.SprintXXL.primitivetoolworks.feature.tools.tooltip;

import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import net.minecraft.item.ItemStack;

public class TooltipContext {

    private final ItemStack stack;
    private final ToolType toolType;

    public TooltipContext(ItemStack stack, ToolType toolType) {
        this.stack = stack;
        this.toolType = toolType;
    }

    public ItemStack getStack() {
        return stack;
    }

    public ToolType getToolType() {
        return toolType;
    }
}
