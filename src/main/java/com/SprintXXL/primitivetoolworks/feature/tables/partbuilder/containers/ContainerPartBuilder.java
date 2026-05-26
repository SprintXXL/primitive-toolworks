package com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.containers;

import com.SprintXXL.primitivetoolworks.common.util.container.ContainerBase;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.recipes.RecipePart;
import com.SprintXXL.primitivetoolworks.feature.tables.common.IIngredientConsumer;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.slots.SlotMaterial;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.slots.SlotOutput;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.slots.SlotPattern;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ContainerPartBuilder extends ContainerBase implements IIngredientConsumer {

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
    protected int getTableSlotCount() {
        return 3;
    }

    @Override
    protected int getInputSlotStart() {
        return 0;
    }

    @Override
    protected int getInputSlotEnd() {
        return 2;
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
}
