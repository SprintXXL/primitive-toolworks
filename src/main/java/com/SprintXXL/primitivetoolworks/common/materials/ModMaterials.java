package com.SprintXXL.primitivetoolworks.common.materials;

import com.SprintXXL.primitivetoolworks.common.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.MainMaterialStats;
import net.minecraft.util.text.TextFormatting;

public class ModMaterials {

    private ModMaterials() {}

    // MAIN MATERIALS \\
    public static final MaterialDefinition FLINT =
            new MaterialDefinition(
                    MaterialGroup.MAIN,
                    MaterialIDs.FLINT,
                    "FLINT",
                    TextFormatting.DARK_GRAY,
                    new MainMaterialStats(
                            128, // Durability
                            1.0F, // Mining Speed
                            1, // Harvest Level
                            3.0F // Attack Damage
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
                            1.0F // Mining Speed Bonus
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
                            10 // Durability Bonus
                    )
            );
}
