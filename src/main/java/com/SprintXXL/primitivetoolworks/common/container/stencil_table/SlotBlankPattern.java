package com.SprintXXL.primitivetoolworks.common.container.stencil_table;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBlankPattern extends Slot {

    public SlotBlankPattern(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x ,y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ModItems.BLANK_PATTERN;
    }
}
