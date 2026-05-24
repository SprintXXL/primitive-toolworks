package com.SprintXXL.primitivetoolworks.common.recipes;

import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.data.PartData;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RecipeHelper;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.materials.helpers.MaterialHelper.getMaterialID;
import static com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation.isValidMaterialPartCombo;

public class RecipePart {

    private static final int MATERIAL_SLOT = 0;
    private static final int PATTERN_SLOT = 1;

    public boolean matches(IInventory inventory) {
        return getResultPartData(inventory) != null;
    }

    public ItemStack getOutput(IInventory inventory) {

        PartData partData = getResultPartData(inventory);

        if (partData == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(ModItems.PART);
        PartNBT.setMaterial(result, partData.getMaterialID());
        PartNBT.setPartType(result, partData.getPartType());
        PartNBT.setPartGroup(result, partData.getPartGroup());

        return result;
    }

    public void consumeIngredients(IInventory inventory) {

        consumeSlot(inventory, MATERIAL_SLOT);
    }

    private void consumeSlot(IInventory inventory, int slot) {

        ItemStack stack = inventory.getStackInSlot(slot);

        if (!stack.isEmpty()) {
            stack.shrink(1);
        }
    }

    private PartData getResultPartData(IInventory inventory) {

        ItemStack materialStack = getMaterialStack(inventory);
        ItemStack patternStack = getPatternStack(inventory);

        if (materialStack.isEmpty() || patternStack.isEmpty()) {
            return null;
        }
        if (patternStack.getItem() != ModItems.PATTERN) {
            return null;
        }

        String materialID = getMaterialID(materialStack);
        String partType = PatternNBT.getPatternType(patternStack);

        PartDefinition partDefinition = PartRegistry.getPart(partType);

        if (partDefinition == null) {
            return null;
        }

        PartGroup group = partDefinition.getPartGroup();

        if (!isValidMaterialPartCombo(materialID, partType)) {
            return null;
        }

        if (materialID.equals("unknown") || partType.equals("unknown")) {
            return null;
        }

        if (group == PartGroup.UNKNOWN) {
            return null;
        }

        return new PartData(materialID, partType, group);
    }

    private ItemStack getMaterialStack(IInventory inventory) {
        return inventory.getStackInSlot(MATERIAL_SLOT);
    }
    private ItemStack getPatternStack(IInventory inventory) {
        return inventory.getStackInSlot(PATTERN_SLOT);
    }
}
