package com.SprintXXL.primitivetoolworks.common.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotToolStationOutput extends Slot {

    private final InventoryCrafting craftMatrix;

    public SlotToolStationOutput(IInventory inventoryIn, InventoryCrafting craftMatrix, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);

        this.craftMatrix = craftMatrix;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {

        ItemStack input = craftMatrix.getStackInSlot(4);

        if (!input.isEmpty()) {
            input.shrink(1);
        }

        return super.onTake(player, stack);
    }
}
