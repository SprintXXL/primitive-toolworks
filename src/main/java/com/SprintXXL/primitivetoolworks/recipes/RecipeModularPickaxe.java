package com.SprintXXL.primitivetoolworks.recipes;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static com.SprintXXL.primitivetoolworks.tools.ToolNBT.*;

public class RecipeModularPickaxe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldin) {

        boolean inventoryGridMatch =
                inv.getStackInSlot(0).getItem() == ModItems.FLINT_PICKAXE_HEAD &&
                        inv.getStackInSlot(2).getItem() == ModItems.WOODEN_HANDLE;

        boolean craftingTableMatch =
                inv.getStackInSlot(0).getItem() == ModItems.FLINT_PICKAXE_HEAD &&
                        inv.getStackInSlot(3).getItem() == ModItems.WOODEN_HANDLE;

        return inventoryGridMatch || craftingTableMatch;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        ItemStack result = new ItemStack(ModItems.TEST_PICKAXE);

        setHeadMaterial(result, "flint");
        setHandleMaterial(result, "wood");

        return result;

    }

    @Override
    public boolean canFit(int width, int height) {

        return width * height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {

        return new ItemStack(ModItems.TEST_PICKAXE);
    }

    @Override
    public boolean isDynamic() {

        return true;
    }
}
