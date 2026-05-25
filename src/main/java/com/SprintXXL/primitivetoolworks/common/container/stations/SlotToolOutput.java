package com.SprintXXL.primitivetoolworks.common.container.stations;

import com.SprintXXL.primitivetoolworks.common.container.IIngredientConsumer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotToolOutput extends Slot {

    private final IIngredientConsumer ingredientConsumer;

    public SlotToolOutput(
            IInventory inventoryIn,
            IIngredientConsumer ingredientConsumer,
            int index,
            int xPosition,
            int yPosition
    ) {
        super(inventoryIn, index, xPosition, yPosition);

        this.ingredientConsumer = ingredientConsumer;
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {
        ingredientConsumer.consumeIngredients();
        return super.onTake(player, stack);
    }
}
