package com.SprintXXL.primitivetoolworks.common.stations.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

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
}
