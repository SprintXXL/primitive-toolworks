package com.SprintXXL.primitivetoolworks.common.stations.container.stencil_table;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;

public class ContainerStencilTable extends Container {

    private final IInventory inventory;

    public ContainerStencilTable(
            InventoryPlayer playerInventory,
            IInventory inventory
    ) {
        this.inventory = inventory;

        this.addSlotToContainer(new SlotKnife(inventory, 0, 50, 25));
        this.addSlotToContainer(new SlotBlankPattern(inventory, 1, 50, 44));
        this.addSlotToContainer(new SlotOutput(inventory, 2, 108, 35));

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

    private final InventoryBasic stencilInventory =
            new InventoryBasic("Stencil Table", false, 3);
}
