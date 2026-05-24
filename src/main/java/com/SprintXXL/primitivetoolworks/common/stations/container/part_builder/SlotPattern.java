package com.SprintXXL.primitivetoolworks.common.stations.container.part_builder;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotPattern extends Slot {

    private final ContainerPartBuilder container;

    public SlotPattern(IInventory inventory, int index, int x, int y, ContainerPartBuilder container) {
        super(inventory, index, x ,y);

        this.container = container;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ModItems.PATTERN;
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();

        container.updateOutput();
    }
}
