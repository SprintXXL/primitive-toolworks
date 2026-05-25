package com.SprintXXL.primitivetoolworks.common.container.stencil_table;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot {

    private final ContainerStencilTable container;

    public SlotOutput(IInventory inventory, int index, int x, int y, ContainerStencilTable container) {
        super(inventory, index, x ,y);
        this.container = container;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {

        container.consumeIngredients();
        return super.onTake(player, stack);
    }
}
