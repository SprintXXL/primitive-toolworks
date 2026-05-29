package com.SprintXXL.primitivetoolworks.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class ContainerBase extends Container {

    protected abstract int getTableSlotCount();

    protected abstract int getInputSlotStart();

    protected abstract int getInputSlotEnd();

    protected int getPlayerSlotStart() {
        return getTableSlotCount();
    }

    protected int getPlayerSlotEnd() {
        return inventorySlots.size();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack stackInSlot = slot.getStack();
        originalStack = stackInSlot.copy();

        if (index < getTableSlotCount()) {

            if (!mergeItemStack(stackInSlot, getPlayerSlotStart(), getPlayerSlotEnd(), true)) {
                return ItemStack.EMPTY;
            }

        } else {

            if (!mergeItemStack(stackInSlot, getInputSlotStart(), getInputSlotEnd(), false)) {
                return ItemStack.EMPTY;
            }
        }

        if (stackInSlot.isEmpty()) {
            slot.putStack(ItemStack.EMPTY);
        }
        else {
            slot.onSlotChanged();
        }
        if (stackInSlot.getCount() == originalStack.getCount()) {
            return ItemStack.EMPTY;
        }
        slot.onTake(playerIn, stackInSlot);

        return originalStack;
    }

    protected void addPlayerInventory(InventoryPlayer playerInventory) {

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlotToContainer(new Slot(
                        playerInventory,
                        column + row * 9 + 9,
                        8 + column * 18,
                        84 + row * 18
                ));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlotToContainer(new Slot(
                    playerInventory,
                    column,
                    8 + column * 18,
                    142
            ));
        }
    }
}
