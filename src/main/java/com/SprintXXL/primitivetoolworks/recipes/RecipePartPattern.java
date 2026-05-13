package com.SprintXXL.primitivetoolworks.recipes;
import com.SprintXXL.primitivetoolworks.init.ModItems;
import com.SprintXXL.primitivetoolworks.patterns.PatternIDs;
import com.SprintXXL.primitivetoolworks.patterns.PatternNBT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipePartPattern extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        return !getResultPatternType(inv).equals("unknown");
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        String patternType = getResultPatternType(inv);

        if (patternType.equals("unknown")) {
            return ItemStack.EMPTY;
        }
        ItemStack result = new ItemStack(ModItems.PART_PATTERN);
        PatternNBT.setPatternType(result, patternType);

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

    private String getResultPatternType(InventoryCrafting inv) {

        if (matchesPickaxeHeadPattern(inv)) {
            return PatternIDs.PICKAXE_HEAD;
        }
        if (matchesHandlePattern(inv)) {
            return PatternIDs.HANDLE;
        }
        return "unknown";
    }

    private boolean matchesPickaxeHeadPattern(InventoryCrafting inv) {

        if (inv.getWidth() != 3 || inv.getHeight() != 3) {
            return false;
        }

        ItemStack knifeStack = inv.getStackInSlot(0);
        ItemStack patternStack = inv.getStackInSlot(4);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 0 || i == 4) {
                continue;
            }
            if (!inv.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }

    private boolean matchesHandlePattern(InventoryCrafting inv) {

        if (inv.getWidth() != 3 || inv.getHeight() != 3) {
            return false;
        }

        ItemStack knifeStack = inv.getStackInSlot(1);
        ItemStack patternStack = inv.getStackInSlot(4);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 1 || i == 4) {
                continue;
            }
            if (!inv.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }
}
