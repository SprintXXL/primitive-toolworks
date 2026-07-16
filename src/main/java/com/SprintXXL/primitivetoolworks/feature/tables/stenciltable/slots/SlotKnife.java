package com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.slots;

import com.sprintxxl.ascentresourcerecipeindex.resources.definitions.ModResources;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotKnife extends Slot {

    public SlotKnife(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x ,y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ModResources.KNIFE.getItem();
    }
}
