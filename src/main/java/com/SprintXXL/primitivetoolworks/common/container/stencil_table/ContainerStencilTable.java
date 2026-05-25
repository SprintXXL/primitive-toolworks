package com.SprintXXL.primitivetoolworks.common.container.stencil_table;

import com.SprintXXL.primitivetoolworks.core.patterns.PatternDefinition;
import com.SprintXXL.primitivetoolworks.core.patterns.PatternRegistry;
import com.SprintXXL.primitivetoolworks.common.container.IIngredientConsumer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerStencilTable extends Container implements IIngredientConsumer {

    private final IInventory inventory;

    public ContainerStencilTable(
            InventoryPlayer playerInventory,
            IInventory inventory
    ) {
        this.inventory = inventory;

        this.addSlotToContainer(new SlotKnife(inventory, 0, 50, 25));
        this.addSlotToContainer(new SlotBlankPattern(inventory, 1, 50, 44));
        this.addSlotToContainer(new SlotOutput(inventory, 2, 108, 35, this));

        addPlayerInventory(playerInventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return inventory.isUsableByPlayer(player);
    }

    private void addPlayerInventory(InventoryPlayer playerInventory) {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(
                        playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        84 + row * 18
                ));
            }
        }

        // Player Hotbar \\
        for (int col = 0; col < 9; col++) {
            this.addSlotToContainer(new Slot(
                    playerInventory,
                    col,
                    8 + col * 18,
                    142
            ));
        }
    }

    @Override
    public void consumeIngredients() {

        ItemStack knifeSlot = inventory.getStackInSlot(0);
        ItemStack patternSlot = inventory.getStackInSlot(1);

        if (!patternSlot.isEmpty()) {
            patternSlot.shrink(1);
        }

        if (!knifeSlot.isEmpty()) {

            int newDamage = knifeSlot.getItemDamage() + 1;

            if (newDamage >= knifeSlot.getMaxDamage()) {
                inventory.setInventorySlotContents(0, ItemStack.EMPTY);
            }
            else {
                knifeSlot.setItemDamage(newDamage);
            }
        }

        inventory.setInventorySlotContents(2, ItemStack.EMPTY);
        inventory.markDirty();

        updateOutput();
        detectAndSendChanges();
    }

    private PatternDefinition selectedPattern;

    public void setSelectedPatternID(String patternID) {
        this.selectedPattern = PatternRegistry.getPattern(patternID);
        updateOutput();
        detectAndSendChanges();
    }

    private void updateOutput() {

        ItemStack knifeSlot = inventory.getStackInSlot(0);
        ItemStack patternSlot = inventory.getStackInSlot(1);

        if (selectedPattern == null || knifeSlot.isEmpty() || patternSlot.isEmpty()) {
            inventory.setInventorySlotContents(2, ItemStack.EMPTY);
            return;
        }

        inventory.setInventorySlotContents(2, selectedPattern.getPatternIconStack().copy());
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        inventory.setInventorySlotContents(2, ItemStack.EMPTY);
        inventory.markDirty();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            originalStack = stackInSlot.copy();

            if (index >= 3 && index < 39) {
                if (!this.mergeItemStack(stackInSlot, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (index >= 0 && index < 2) {
                if (!this.mergeItemStack(stackInSlot, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (index == 2) {
                if (!this.mergeItemStack(stackInSlot, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stackInSlot, originalStack);
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
        }

        return originalStack;
    }
}
