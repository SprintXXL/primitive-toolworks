package com.SprintXXL.primitivetoolworks.library.materials.util;

import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.definitions.MaterialIDs;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.util.RecipeHelper.isPlankWood;
import static com.sprintxxl.ascentresourcerecipeindex.resources.definitions.ResourceCatalog.*;

public class MaterialUtil {

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
        if (stack.getItem() == IRON_INGOT.getItem()) {
            return MaterialIDs.IRON;
        }
        if (stack.getItem() == BRONZE_INGOT.getItem()) {
            return MaterialIDs.BRONZE;
        }
        if (stack.getItem() == Item.getItemFromBlock(Blocks.OBSIDIAN)) {
            return MaterialIDs.OBSIDIAN;
        }

        return "unknown";
    }

    public static Material getMaterial(ItemStack stack) {

        String materialID = getMaterialID(stack);

        return MaterialRegistry.getMaterial(materialID);
    }

    public static Material getMaterialOrDefault(String materialID, String defaultMaterialID) {

        Material material = MaterialRegistry.getMaterial(materialID);

        if (material != null) {
            return material;
        }

        return MaterialRegistry.getMaterial(defaultMaterialID);
    }
}
