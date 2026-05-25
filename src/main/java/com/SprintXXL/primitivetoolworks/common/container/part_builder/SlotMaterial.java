package com.SprintXXL.primitivetoolworks.common.container.part_builder;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.core.materials.helpers.MaterialHelper.getMaterialID;

public class SlotMaterial extends Slot {

    private final ContainerPartBuilder container;

    public SlotMaterial(IInventory inventory, int index, int x, int y, ContainerPartBuilder container) {
        super(inventory, index, x ,y);

        this.container = container;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return !getMaterialID(stack).equals("unknown");
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();

        container.updateOutput();
    }
}
