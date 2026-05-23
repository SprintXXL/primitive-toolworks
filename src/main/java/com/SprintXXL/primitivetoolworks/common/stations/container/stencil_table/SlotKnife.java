package com.SprintXXL.primitivetoolworks.common.stations.container.stencil_table;

import com.SprintXXL.primitivetools.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotKnife extends Slot {

    public SlotKnife(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x ,y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ModItems.FLINT_KNIFE;
    }
}
