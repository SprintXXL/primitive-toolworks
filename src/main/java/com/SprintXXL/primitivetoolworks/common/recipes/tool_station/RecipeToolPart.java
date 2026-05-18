package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.data.PartData;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation.isValidMaterialPartCombo;
import static com.SprintXXL.primitivetoolworks.common.recipes.helpers.RH.*;

public class RecipeToolPart {

    public boolean matches(InventoryCrafting craftMatrix) {
        return getResultPartData(craftMatrix) != null;
    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        PartData partData = getResultPartData(craftMatrix);

        if (partData == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(ModItems.TOOL_PART);
        PartNBT.setMaterial(result, partData.getMaterialID());
        PartNBT.setPartType(result, partData.getPartType());
        PartNBT.setPartGroup(result, partData.getPartGroup());

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        consumeSlot(craftMatrix, 1);
    }

    private void consumeSlot(InventoryCrafting craftMatrix, int slot) {

        ItemStack stack = craftMatrix.getStackInSlot(slot);

        if (!stack.isEmpty()) {
            stack.shrink(1);
        }
    }

    private PartData getResultPartData(InventoryCrafting craftMatrix) {

        if (!RH.matchesCraftMatrix(craftMatrix)) {
            return null;
        }

        ItemStack materialStack = craftMatrix.getStackInSlot(1);
        ItemStack patternStack = craftMatrix.getStackInSlot(4);

        if (materialStack.isEmpty() || patternStack.isEmpty()) {
            return null;
        }
        if (patternStack.getItem() != ModItems.PART_PATTERN) {
            return null;
        }

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i == 1 || i == 4) {
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

        PartGroup group = partDefinition.getGroup();

        if (!isValidMaterialPartCombo(materialID, partType)) {
            return null;
        }

        if (materialID.equals("unknown") || partType.equals("unknown") || group.equals("unknown")) {
            return null;
        }

        return new PartData(materialID, partType, group);
    }
}
