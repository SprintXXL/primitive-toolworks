package com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.slots;

import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.containers.ContainerPartBuilder;
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
