package com.SprintXXL.primitivetoolworks.common.container;

import com.SprintXXL.primitivetoolworks.common.recipes.tool_station.RecipePartPattern;
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

    private final RecipePartPattern patternRecipe =
            new RecipePartPattern();

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
                this,
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

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (!playerIn.world.isRemote) {
            for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
                ItemStack stack = craftMatrix.removeStackFromSlot(i);

                if (!stack.isEmpty()) {
                    if (!playerIn.inventory.addItemStackToInventory(stack)) {
                        playerIn.dropItem(stack, false);
                    }
                }
            }

            playerIn.inventory.markDirty();
        }
    }

    private ItemStack findMatchingResult() {

        if (patternRecipe.matches(craftMatrix)) {
            return patternRecipe.getOutput(craftMatrix);
        }

        return ItemStack.EMPTY;
    }

    public void consumeIngredients() {

        if (patternRecipe.matches(craftMatrix)) {
            patternRecipe.consumeIngredients(craftMatrix);
        }

        onCraftMatrixChanged(craftMatrix);
    }
}