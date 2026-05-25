package com.SprintXXL.primitivetoolworks.common.container.part_builder;

import com.SprintXXL.primitivetoolworks.common.recipes.RecipePart;
import com.SprintXXL.primitivetoolworks.common.container.IIngredientConsumer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPartBuilder extends Container implements IIngredientConsumer {

    private final IInventory inventory;

    public ContainerPartBuilder(
            InventoryPlayer playerInventory,
            IInventory inventory
    ) {
        this.inventory = inventory;

        this.addSlotToContainer(new SlotMaterial(inventory, 0, 50, 25, this));
        this.addSlotToContainer(new SlotPattern(inventory, 1, 50, 44, this));
        this.addSlotToContainer(new SlotOutput(inventory, 2, 108, 35, this));

        addPlayerInventory(playerInventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return inventory.isUsableByPlayer(player);
    }

    @Override
    public void consumeIngredients() {
        inventory.getStackInSlot(0).shrink(1);
        updateOutput();
        detectAndSendChanges();
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        updateOutput();
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

    private final RecipePart partRecipe = new RecipePart();

    public void updateOutput() {

        if (partRecipe.matches(inventory)) {
            inventory.setInventorySlotContents(2, partRecipe.getOutput(inventory));
        }
        else {
            inventory.setInventorySlotContents(2, ItemStack.EMPTY);
        }

        inventory.markDirty();
        detectAndSendChanges();
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
