package com.SprintXXL.primitivetoolworks.recipes;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import com.SprintXXL.primitivetoolworks.parts.PartIDs;
import com.SprintXXL.primitivetoolworks.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.tools.ToolNBT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeModularPickaxe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        boolean inventoryGridMatch =
                inv.getWidth() == 2 &&
                        inv.getHeight() == 2 &&
                        PartIDs.PICKAXE_HEAD.equals(PartNBT.getPartType(inv.getStackInSlot(0))) &&
                        PartIDs.HANDLE.equals(PartNBT.getPartType(inv.getStackInSlot(2)));

        boolean craftingGridMatch =
                inv.getWidth() == 3 &&
                        inv.getHeight() == 3 &&
                        PartIDs.PICKAXE_HEAD.equals(PartNBT.getPartType(inv.getStackInSlot(0))) &&
                        PartIDs.HANDLE.equals(PartNBT.getPartType(inv.getStackInSlot(3)));

        return inventoryGridMatch || craftingGridMatch;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        int handleSlot = inv.getWidth() == 2 ? 2 : 3;

        ItemStack mainStack = inv.getStackInSlot(0);
        ItemStack handleStack = inv.getStackInSlot(handleSlot);

        ItemStack result = new ItemStack(ModItems.TEST_PICKAXE);

        ToolNBT.setMainMaterial(result, PartNBT.getMaterial(mainStack));
        ToolNBT.setMainPart(result, PartNBT.getPartType(mainStack));

        ToolNBT.setHandleMaterial(result, PartNBT.getMaterial(handleStack));
        ToolNBT.setHandlePart(result, PartNBT.getPartType(handleStack));

        return result;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 1 && height >= 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.TEST_PICKAXE);
    }
}