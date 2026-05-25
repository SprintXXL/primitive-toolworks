package com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.containers;

import com.SprintXXL.primitivetoolworks.feature.tables.common.IIngredientConsumer;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeModularTool;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolRepair;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.slots.SlotToolOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerToolWorkbench extends Container implements IIngredientConsumer {

    private final ToolStationTier stationTier;

    private final InventoryCrafting craftMatrix =
            new InventoryCrafting(this, 3, 3);

    private final InventoryCraftResult craftResult =
            new InventoryCraftResult();

    private final RecipeModularTool modularToolRecipe;

    private final RecipeToolRepair repairRecipe =
            new RecipeToolRepair();

    public ContainerToolWorkbench(
            InventoryPlayer playerInventory,
            ToolStationTier stationTier
    ) {

        this.stationTier = stationTier;
        this.modularToolRecipe = new RecipeModularTool(stationTier);

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
        this.addSlotToContainer(new SlotToolOutput(
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

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            originalStack = stackInSlot.copy();

            if (index >= 10 && index < 46) {
                if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (index >= 0 && index < 9) {
                if (!this.mergeItemStack(stackInSlot, 10, 46, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (index == 9) {
                if (!this.mergeItemStack(stackInSlot, 10, 46, true)) {
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

    // Recipe Methods \\

    private ItemStack findMatchingResult() {

        if (modularToolRecipe.matches(craftMatrix)) {
            return modularToolRecipe.getOutput(craftMatrix);
        }
        if (repairRecipe.matches(craftMatrix)) {
            return repairRecipe.getOutput(craftMatrix);
        }

        return ItemStack.EMPTY;
    }

    public void consumeIngredients() {

        if (modularToolRecipe.matches(craftMatrix)) {
            modularToolRecipe.consumeIngredients(craftMatrix);
        }
        else if (repairRecipe.matches(craftMatrix)) {
            repairRecipe.consumeIngredients(craftMatrix);
        }

        onCraftMatrixChanged(craftMatrix);
    }
}
