package com.SprintXXL.primitivetoolworks.recipes;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import com.SprintXXL.primitivetoolworks.materials.MaterialIDs;
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

        if (inv.getWidth() != 3 || inv.getHeight() !=3) {
            return false;
        }

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i != 1 && i != 4 && i != 7) {
                if (!inv.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        ItemStack mainStack = inv.getStackInSlot(1);
        ItemStack extraStack = inv.getStackInSlot(4);
        ItemStack handleStack = inv.getStackInSlot(7);

        if (mainStack.isEmpty() || extraStack.isEmpty() || handleStack.isEmpty()) {
            return false;
        }

        if (mainStack.getItem() != ModItems.TOOL_PART || extraStack.getItem() != ModItems.TOOL_PART || handleStack.getItem() != ModItems.TOOL_PART) {
            return false;
        }

        return PartIDs.PICKAXE_HEAD.equals(PartNBT.getPartType(mainStack)) &&
                PartIDs.BINDING.equals(PartNBT.getPartType(extraStack)) &&
                PartIDs.HANDLE.equals(PartNBT.getPartType(handleStack));
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        ItemStack mainStack = inv.getStackInSlot(1);
        ItemStack extraStack = inv.getStackInSlot(4);
        ItemStack handleStack = inv.getStackInSlot(7);

        ItemStack result = new ItemStack(ModItems.MODULAR_PICKAXE);

        ToolNBT.setMainMaterial(result, PartNBT.getMaterial(mainStack));
        ToolNBT.setMainPart(result, PartNBT.getPartType(mainStack));

        ToolNBT.setExtraMaterial(result, PartNBT.getMaterial(extraStack));
        ToolNBT.setExtraPart(result, PartNBT.getPartType(extraStack));

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
        return ItemStack.EMPTY;
    }
}