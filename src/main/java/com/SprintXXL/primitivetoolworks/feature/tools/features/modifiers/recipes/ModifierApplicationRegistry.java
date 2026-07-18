package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes;

import com.SprintXXL.primitivetoolworks.library.modifiers.definitions.ModifierIDs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ModifierApplicationRegistry {

    private static final List<ModifierApplicationRecipe> RECIPES =
            new ArrayList<>();

    private ModifierApplicationRegistry() {}

    public static void register(ModifierApplicationRecipe recipe) {
        RECIPES.add(recipe);
    }

    public static ModifierApplicationRecipe findMatch(ItemStack toolStack, ItemStack ingredientStack) {

        for (ModifierApplicationRecipe recipe : RECIPES) {
            if (recipe.matches(toolStack, ingredientStack)) {
                return recipe;
            }
        }

        return null;
    }

    public static void init() {
        register(new ModifierApplicationRecipe(
                ModifierIDs.HASTE,
                new ItemStack(Blocks.REDSTONE_BLOCK),
                1
        ));
        register(new ModifierApplicationRecipe(
                ModifierIDs.LUCK,
                new ItemStack(Blocks.GOLD_BLOCK),
                1
        ));
    }
}
