package com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.containers;

import com.SprintXXL.primitivetoolworks.common.util.container.ContainerBase;
import com.SprintXXL.primitivetoolworks.feature.tables.common.IIngredientConsumer;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic.ToolModifierApplier;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRecipe;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRegistry;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeModularTool;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolModifier;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolRepair;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.slots.SlotToolOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerToolWorkbench extends ContainerBase implements IIngredientConsumer {

    private final ToolStationTier stationTier;

    private final InventoryCrafting craftMatrix =
            new InventoryCrafting(this, 3, 3);

    private final InventoryCraftResult craftResult =
            new InventoryCraftResult();

    private final RecipeModularTool modularToolRecipe;

    private final RecipeToolRepair repairRecipe =
            new RecipeToolRepair();

    private final RecipeToolModifier modifierRecipe =
            new RecipeToolModifier();

    public ContainerToolWorkbench(
            InventoryPlayer playerInventory,
            ToolStationTier stationTier
    ) {

        this.stationTier = stationTier;
        this.modularToolRecipe = new RecipeModularTool(stationTier);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlotToContainer(new Slot(craftMatrix, col + row * 3, 30 + col * 18, 17 + row * 18));
            }
        }

        this.addSlotToContainer(new SlotToolOutput(craftResult, this, 0, 124, 35));

        addPlayerInventory(playerInventory);
    }

    @Override
    protected int getTableSlotCount() {
        return 10;
    }

    @Override
    protected int getInputSlotStart() {
        return 0;
    }

    @Override
    protected int getInputSlotEnd() {
        return 9;
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



    private ItemStack findMatchingResult() {

        if (modularToolRecipe.matches(craftMatrix)) {
            return modularToolRecipe.getOutput(craftMatrix);
        }
        if (repairRecipe.matches(craftMatrix)) {
            return repairRecipe.getOutput(craftMatrix);
        }
        if (modifierRecipe.matches(craftMatrix)) {
            return modifierRecipe.getOutput(craftMatrix);
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
        else if(modifierRecipe.matches(craftMatrix)) {
            modifierRecipe.consumeIngredients(craftMatrix);
        }

        onCraftMatrixChanged(craftMatrix);
    }
}
