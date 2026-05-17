package com.SprintXXL.primitivetoolworks.common.container;

import com.SprintXXL.primitivetoolworks.common.slots.SlotToolStationOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerToolStation extends Container {

    private final InventoryCrafting craftMatrix =
            new InventoryCrafting(this, 3, 3);

    private final InventoryCraftResult craftResult =
            new InventoryCraftResult();

    public ContainerToolStation(InventoryPlayer playerInventory) {

        // 3x3 Crafting Grid \\
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlotToContainer(new Slot(
                        craftMatrix,
                        col + row * 3,
                        30 + col * 18,
                        17 + row * 18
                ));
            }
        }

        // Output Slot \\
        this.addSlotToContainer(new SlotToolStationOutput(
                craftResult,
                craftMatrix,
                0,
                124,
                35
        ));

        // Player Inventory \\
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
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.craftResult.setInventorySlotContents(
                0,
                findMatchingResult()
        );
    }

    private ItemStack findMatchingResult() {

        if(craftMatrix.getWidth() != 3 || craftMatrix.getHeight() != 3) {
            return ItemStack.EMPTY;
        }

        ItemStack slot4 = craftMatrix.getStackInSlot(4);

        if (slot4.isEmpty()){
            return ItemStack.EMPTY;
        }
        if (slot4.getItem() != Items.FLINT) {
            return ItemStack.EMPTY;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if(i == 4) {
                continue;
            }
            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return ItemStack.EMPTY;
            }
        }
            return new ItemStack(Items.STICK);
    }
}