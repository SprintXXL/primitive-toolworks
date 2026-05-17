package com.SprintXXL.primitivetoolworks.common.container;

import com.SprintXXL.primitivetoolworks.common.recipes.tool_station.RecipeModularPickaxe;
import com.SprintXXL.primitivetoolworks.common.recipes.tool_station.RecipePartPattern;
import com.SprintXXL.primitivetoolworks.common.recipes.tool_station.RecipeToolPart;
import com.SprintXXL.primitivetoolworks.common.recipes.tool_station.RecipeToolRepair;
import com.SprintXXL.primitivetoolworks.common.slots.SlotToolStationOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerToolStation extends Container {

    private final InventoryCrafting craftMatrix =
            new InventoryCrafting(this, 3, 3);

    private final InventoryCraftResult craftResult =
            new InventoryCraftResult();

    private final RecipePartPattern patternRecipe =
            new RecipePartPattern();

    private final RecipeToolPart partRecipe =
            new RecipeToolPart();

    private final RecipeModularPickaxe pickaxeRecipe =
            new RecipeModularPickaxe();

    private final RecipeToolRepair repairRecipe =
            new RecipeToolRepair();

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

    private ItemStack findMatchingResult() {

        if (patternRecipe.matches(craftMatrix)) {
            return patternRecipe.getOutput(craftMatrix);
        }
        if (partRecipe.matches(craftMatrix)) {
            return partRecipe.getOutput(craftMatrix);
        }
        if (pickaxeRecipe.matches(craftMatrix)) {
            return pickaxeRecipe.getOutput(craftMatrix);
        }
        if (repairRecipe.matches(craftMatrix)) {
            return repairRecipe.getOutput(craftMatrix);
        }

        return ItemStack.EMPTY;
    }

    public void consumeIngredients() {

        if (patternRecipe.matches(craftMatrix)) {
            patternRecipe.consumeIngredients(craftMatrix);
        }
        if (partRecipe.matches(craftMatrix)) {
            partRecipe.consumeIngredients(craftMatrix);
        }
        if (pickaxeRecipe.matches(craftMatrix)) {
            pickaxeRecipe.consumeIngredients(craftMatrix);
        }
        if (repairRecipe.matches(craftMatrix)) {
            repairRecipe.consumeIngredients(craftMatrix);
        }

        onCraftMatrixChanged(craftMatrix);
    }
}