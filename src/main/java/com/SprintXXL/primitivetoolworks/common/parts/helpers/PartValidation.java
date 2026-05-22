package com.SprintXXL.primitivetoolworks.common.parts.helpers;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.parts.PartIDs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartValidation {

    private static final Map<String, Set<String>> VALID_COMBOS = new HashMap<>();

    private static void register(String materialID, String partID) {

        VALID_COMBOS
                .computeIfAbsent(materialID, k -> new HashSet<>())
                .add(partID);
    }

    public static void init() {

        // Main Parts \\

        register(MaterialIDs.FLINT, PartIDs.SWORD_BLADE);
        register(MaterialIDs.IRON, PartIDs.SWORD_BLADE);
        register(MaterialIDs.BRONZE, PartIDs.SWORD_BLADE);

        register(MaterialIDs.FLINT, PartIDs.PICKAXE_HEAD);
        register(MaterialIDs.IRON, PartIDs.PICKAXE_HEAD);
        register(MaterialIDs.BRONZE, PartIDs.PICKAXE_HEAD);

        register(MaterialIDs.FLINT, PartIDs.AXE_HEAD);
        register(MaterialIDs.IRON, PartIDs.AXE_HEAD);
        register(MaterialIDs.BRONZE, PartIDs.AXE_HEAD);

        register(MaterialIDs.FLINT, PartIDs.SHOVEL_HEAD);
        register(MaterialIDs.IRON, PartIDs.SHOVEL_HEAD);
        register(MaterialIDs.BRONZE, PartIDs.SHOVEL_HEAD);

        register(MaterialIDs.FLINT, PartIDs.HOE_HEAD);
        register(MaterialIDs.IRON, PartIDs.HOE_HEAD);
        register(MaterialIDs.BRONZE, PartIDs.HOE_HEAD);

        register(MaterialIDs.FLINT, PartIDs.HAMMER_HEAD);
        register(MaterialIDs.IRON, PartIDs.HAMMER_HEAD);
        register(MaterialIDs.BRONZE, PartIDs.HAMMER_HEAD);

        // Extra Parts \\
        register(MaterialIDs.BONE, PartIDs.BINDING);

        register(MaterialIDs.BONE, PartIDs.TOUGH_BINDING);

        register(MaterialIDs.BONE, PartIDs.WIDE_GUARD);

        // Handle Parts \\
        register(MaterialIDs.WOOD, PartIDs.HANDLE);
        register(MaterialIDs.OBSIDIAN, PartIDs.HANDLE);

        register(MaterialIDs.WOOD, PartIDs.TOUGH_HANDLE);
        register(MaterialIDs.OBSIDIAN, PartIDs.TOUGH_HANDLE);

    }


    public static boolean isValidMaterialPartCombo(String materialID, String partID) {

        Set<String> validParts = VALID_COMBOS.get(materialID);

        if (validParts == null) {
            return false;
        }

        return validParts.contains(partID);
    }
}
