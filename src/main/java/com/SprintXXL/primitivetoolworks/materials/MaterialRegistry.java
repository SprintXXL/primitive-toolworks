package com.SprintXXL.primitivetoolworks.materials;

import net.minecraft.util.text.TextFormatting;

public class MaterialRegistry {

    public static MaterialDefinition getMaterial(String id) {

        if (id.equals(MaterialIDs.FLINT)) {
            return FLINT;
        }

        if (id.equals(MaterialIDs.WOOD)) {
            return WOOD;
        }

        return WOOD;
    }

    public static final MaterialDefinition FLINT =
            new MaterialDefinition(
                    MaterialIDs.FLINT, // Material ID
                    "FLINT", // Display Name
                    TextFormatting.DARK_GRAY, // Display Color
                    1, // Harvest Level
                    128, // Durability
                    15, // Mining Speed
                    3 // Attack Damage

            );

    public static final MaterialDefinition WOOD =
            new MaterialDefinition(
                    MaterialIDs.WOOD,
                    "WOOD",
                    TextFormatting.GOLD,
                    0,
                    256,
                    5,
                    5
            );
}
