package com.SprintXXL.primitivetoolworks.recipes;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import com.SprintXXL.primitivetoolworks.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.parts.PartData;
import com.SprintXXL.primitivetoolworks.parts.PartIDs;
import com.SprintXXL.primitivetoolworks.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.patterns.PatternNBT;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeToolPart extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return getResultPartData(inv) != null;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        PartData partData = getResultPartData(inv);

        if (partData == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(ModItems.TOOL_PART);
        PartNBT.setMaterial(result, partData.getMaterialID());
        PartNBT.setPartType(result, partData.getPartType());

        return result;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.TOOL_PART);
    }

    private PartData getResultPartData(InventoryCrafting inv) {

        ItemStack materialStack = inv.getStackInSlot(1);
        ItemStack patternStack = inv.getStackInSlot(4);

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 1 || i == 4) {
                continue;
            }

            if (!inv.getStackInSlot(i).isEmpty()) {
                return null;
            }
        }

        String materialID = getMaterialID(materialStack);
        String partType = PatternNBT.getPatternType(patternStack);

        if (!isValidMaterialPartCombo(materialID, partType)) {
            return null;
        }

        if (materialID.equals("unknown") || partType.equals("unknown")) {
            return null;
        }

        return new PartData(materialID, partType);
    }

    private String getMaterialID(ItemStack stack) {

        if (stack.getItem() == Items.FLINT) {
            return MaterialIDs.FLINT;
        }
        if (isPlankWood(stack)) {
            return MaterialIDs.WOOD;
        }

        return "unknown";
    }

    private boolean isValidMaterialPartCombo(String materialID, String partType) {

        if (materialID.equals(MaterialIDs.FLINT) &&  partType.equals(PartIDs.PICKAXE_HEAD)) {
            return true;
        }
        if (materialID.equals(MaterialIDs.WOOD) && partType.equals(PartIDs.HANDLE)) {
            return true;
        }
        return false;
    }

    private boolean isPlankWood(ItemStack stack) {
        int[] oreIDs = OreDictionary.getOreIDs(stack);

        for (int id : oreIDs) {
            if (OreDictionary.getOreName(id).equals("plankWood")) {
                return true;
            }
        }
        return false;
    }
}
