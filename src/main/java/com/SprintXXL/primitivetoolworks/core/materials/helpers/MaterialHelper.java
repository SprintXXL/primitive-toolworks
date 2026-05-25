package com.SprintXXL.primitivetoolworks.core.materials.helpers;

import com.SprintXXL.primitiveores.init.ModItems;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.recipes.helpers.RecipeHelper.isPlankWood;

public class MaterialHelper {

    public static String getMaterialID(ItemStack stack) {

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
        if (stack.getItem() == ModItems.IRON_INGOT) {
            return MaterialIDs.IRON;
        }
        if (stack.getItem() == ModItems.BRONZE_INGOT) {
            return MaterialIDs.BRONZE;
        }
        if (stack.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN)) {
            return MaterialIDs.OBSIDIAN;
        }

        return "unknown";
    }

    public static MaterialDefinition getMaterial(ItemStack stack) {

        String materialID = getMaterialID(stack);

        return MaterialRegistry.getMaterial(materialID);
    }
}
