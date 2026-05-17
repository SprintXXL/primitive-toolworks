package com.SprintXXL.primitivetoolworks.common.recipes;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternIDs;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class OLDRecipePartPattern extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

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
        if (matchesBindingPattern(inv)) {
            return PatternIDs.BINDING;
        }
        return "unknown";
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);

            if (stack.isEmpty()) {
                continue;
            }

            if (stack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE) {
                ItemStack knife = stack.copy();
                knife.setCount(1);

                int newDamage = knife.getItemDamage() + 1;

                if (newDamage >= knife.getMaxDamage()) {
                    remaining.set(i, ItemStack.EMPTY);
                }
                else {
                    knife.setItemDamage(newDamage);
                    remaining.set(i, knife);
                }
            }
        }
        return remaining;
    }

    private boolean matchesPickaxeHeadPattern(InventoryCrafting inv) {

        if (inv.getWidth() != 3 || inv.getHeight() != 3) {
            return false;
        }

        ItemStack knifeStack = inv.getStackInSlot(0);
        ItemStack patternStack = inv.getStackInSlot(1);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            if (!inv.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }

        return knifeStack.getItem() == com.SprintXXL.primitivetools.init.ModItems.FLINT_KNIFE &&
                patternStack.getItem() == ModItems.BLANK_PATTERN;
    }

    private boolean matchesBindingPattern(InventoryCrafting inv) {

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

        ItemStack knifeStack = inv.getStackInSlot(0);
        ItemStack patternStack = inv.getStackInSlot(7);

        if (knifeStack.isEmpty() || patternStack.isEmpty()) {
            return false;
        }

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 0 || i == 7) {
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
