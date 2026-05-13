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
        return new ItemStack(ModItems.PART_PATTERN);
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
        boolean craftingGridMatch =
                inv.getWidth() == 3 &&
                        inv.getHeight() == 3 &&
                        inv.getStackInSlot(4).getItem() == ModItems.BLANK_PATTERN &&
                        inv.getStackInSlot(0).getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE;

        return craftingGridMatch;
    }

    private boolean matchesHandlePattern(InventoryCrafting inv) {
        boolean craftingGridMatch =
                inv.getWidth() == 3 &&
                        inv.getHeight() == 3 &&
                        inv.getStackInSlot(4).getItem() == ModItems.BLANK_PATTERN &&
                        inv.getStackInSlot(1).getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE;

        return craftingGridMatch;
    }
}
