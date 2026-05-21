package com.SprintXXL.primitivetoolworks.common.recipes;

import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.data.PartData;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RecipeHelper;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.materials.helpers.MaterialHelper.getMaterialID;
import static com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation.isValidMaterialPartCombo;

public class RecipePart {

    private static final int MATERIAL_SLOT = 1;
    private static final int PATTERN_SLOT = 4;

    public boolean matches(InventoryCrafting craftMatrix) {
        return getResultPartData(craftMatrix) != null;
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        PartData partData = getResultPartData(craftMatrix);

        if (partData == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(ModItems.PART);
        PartNBT.setMaterial(result, partData.getMaterialID());
        PartNBT.setPartType(result, partData.getPartType());
        PartNBT.setPartGroup(result, partData.getPartGroup());

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        consumeSlot(craftMatrix, MATERIAL_SLOT);
    }

    private void consumeSlot(InventoryCrafting craftMatrix, int slot) {

        ItemStack stack = craftMatrix.getStackInSlot(slot);

        if (!stack.isEmpty()) {
            stack.shrink(1);
        }
    }

    private PartData getResultPartData(InventoryCrafting craftMatrix) {

        if (!RecipeHelper.matchesCraftMatrix(craftMatrix)) {
            return null;
        }

        ItemStack materialStack = getMaterialStack(craftMatrix);
        ItemStack patternStack = getPatternStack(craftMatrix);

        if (materialStack.isEmpty() || patternStack.isEmpty()) {
            return null;
        }
        if (patternStack.getItem() != ModItems.PATTERN) {
            return null;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == MATERIAL_SLOT || i == PATTERN_SLOT) {
                continue;
            }

            if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                return null;
            }
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

    private ItemStack getMaterialStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(MATERIAL_SLOT);
    }
    private ItemStack getPatternStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(PATTERN_SLOT);
    }
}
