package com.SprintXXL.primitivetoolworks.common.slots;

import com.SprintXXL.primitivetoolworks.common.container.ContainerToolStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotToolStationOutput extends Slot {

    private final ContainerToolStation container;

    public SlotToolStationOutput(IInventory inventoryIn, ContainerToolStation container, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
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
