package com.SprintXXL.primitivetoolworks.common.materials;

import com.SprintXXL.primitivetoolworks.common.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.MainMaterialStats;
import net.minecraft.util.text.TextFormatting;

public class MaterialDefinitions {

    private MaterialDefinitions() {}

    // MAIN MATERIALS \\
    public static final MaterialDefinition FLINT =
            new MaterialDefinition(
                    MaterialGroup.MAIN,
                    MaterialIDs.FLINT,
                    "FLINT",
                    TextFormatting.DARK_GRAY,
                    new MainMaterialStats(
                            250, // Durability
                            5.0F, // Mining Speed
                            1, // Harvest Level
                            5.0F // Attack Damage
                    )
            );

    // EXTRA MATERIALS \\
    public static final MaterialDefinition BONE =
            new MaterialDefinition(
                    MaterialGroup.EXTRA,
                    MaterialIDs.BONE,
                    "BONE",
                    TextFormatting.WHITE,
                    new ExtraMaterialStats(
                            2.0F // Mining Speed Bonus
                    )
            );

    // HANDLE MATERIALS \\
    public static final MaterialDefinition WOOD =
            new MaterialDefinition(
                    MaterialGroup.HANDLE,
                    MaterialIDs.WOOD,
                    "WOOD",
                    TextFormatting.GOLD,
                    new HandleMaterialStats(
                            50 // Durability Bonus
                    )
            );
}
