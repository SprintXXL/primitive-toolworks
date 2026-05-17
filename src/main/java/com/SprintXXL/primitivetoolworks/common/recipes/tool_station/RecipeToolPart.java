package com.SprintXXL.primitivetoolworks.common.recipes.tool_station;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.data.PartData;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import com.SprintXXL.primitivetoolworks.common.recipes.helpers.helpers;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation.isValidMaterialPartCombo;

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

        ItemStack stack = craftMatrix.getStackInSlot(1);

        if (!stack.isEmpty()) {
            stack.shrink(1);
        }
    }

    private PartData getResultPartData(InventoryCrafting craftMatrix) {

        if (!helpers.matchesCraftMatrix(craftMatrix)) {
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

    private String getMaterialID(ItemStack stack) {

        if (stack.isEmpty()) {
            return "unknown";
        }

        if (stack.getItem() == Items.FLINT) {
            return MaterialIDs.FLINT;
        }
        if (isPlankWood(stack)) {
            return MaterialIDs.WOOD;
        }
        if (stack.getItem() == Items.BONE) {
            return MaterialIDs.BONE;
        }

        return "unknown";
    }

    private boolean isPlankWood(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }

        int[] oreIDs = OreDictionary.getOreIDs(stack);

        for (int id : oreIDs) {
            if (OreDictionary.getOreName(id).equals("plankWood")) {
                return true;
            }
        }
        return false;
    }
}
