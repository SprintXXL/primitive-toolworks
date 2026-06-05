package com.SprintXXL.primitivetoolworks.library.materials.util;

import com.SprintXXL.primitivematerials.library.ModMaterials;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialIDs;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.common.util.RecipeHelper.isPlankWood;

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
        if (stack.getItem() == com.SprintXXL.primitivematerials.library.MaterialRegistry.getItem(MaterialForm.INGOT, ModMaterials.IRON)) {
            return MaterialIDs.IRON;
        }
        if (stack.getItem() == com.SprintXXL.primitivematerials.library.MaterialRegistry.getItem(MaterialForm.INGOT, ModMaterials.BRONZE)) {
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

    public static MaterialDefinition getMaterialOrDefault(String materialID, String defaultMaterialID) {

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material != null) {
            return material;
        }

        return MaterialRegistry.getMaterial(defaultMaterialID);
    }
}
