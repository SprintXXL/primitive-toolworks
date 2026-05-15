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
import net.minecraft.util.NonNullList;
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
        PartNBT.setRenderRole(result, partData.getRenderRole());

        return result;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            if (stack.getItem() == ModItems.PART_PATTERN) {
                ItemStack pattern = stack.copy();
                pattern.setCount(1);
                remaining.set(i, pattern);
            }
        }
        return remaining;
    }

    private PartData getResultPartData(InventoryCrafting inv) {

        if (inv.getWidth() != 3 || inv.getHeight() != 3) {
            return null;
        }

        ItemStack materialStack = inv.getStackInSlot(1);
        ItemStack patternStack = inv.getStackInSlot(4);

        if (materialStack.isEmpty() || patternStack.isEmpty()) {
            return null;
        }
        if (patternStack.getItem() != ModItems.PART_PATTERN) {
            return null;
        }

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
        String renderRole = getRenderRole(partType);

        if (!isValidMaterialPartCombo(materialID, partType)) {
            return null;
        }

        if (materialID.equals("unknown") || partType.equals("unknown") || renderRole.equals("unknown")) {
            return null;
        }

        return new PartData(materialID, partType, renderRole);
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

    private boolean isValidMaterialPartCombo(String materialID, String partType) {

        if (materialID.equals(MaterialIDs.FLINT) &&  partType.equals(PartIDs.PICKAXE_HEAD)) {
            return true;
        }
        if (materialID.equals(MaterialIDs.WOOD) && partType.equals(PartIDs.HANDLE)) {
            return true;
        }
        if (materialID.equals(MaterialIDs.BONE) && partType.equals(PartIDs.BINDING)) {
            return true;
        }
        return false;
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

    private String getRenderRole(String partType) {

        if (partType.equals(PartIDs.PICKAXE_HEAD)) {
            return "main";
        }

        if (partType.equals(PartIDs.BINDING)) {
            return "extra";
        }

        if (partType.equals(PartIDs.HANDLE)) {
            return "handle";
        }

        return "unknown";
    }
}
