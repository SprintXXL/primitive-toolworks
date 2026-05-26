package com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers;

import com.SprintXXL.primitivetoolworks.common.util.container.ContainerBase;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.slots.SlotBlankPattern;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.slots.SlotKnife;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.slots.SlotOutput;
import com.SprintXXL.primitivetoolworks.library.patterns.data.PatternDefinition;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.feature.tables.common.IIngredientConsumer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ContainerStencilTable extends ContainerBase implements IIngredientConsumer {

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
}
