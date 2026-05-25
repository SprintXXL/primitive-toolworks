package com.SprintXXL.primitivetoolworks.library.materials.defaults;

import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialGroup;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialIDs;
import com.SprintXXL.primitivetoolworks.library.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.MainMaterialStats;
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

    public static final MaterialDefinition IRON =
            new MaterialDefinition(
                    MaterialGroup.MAIN,
                    MaterialIDs.IRON,
                    "IRON",
                    TextFormatting.WHITE,
                    new MainMaterialStats(
                            256,
                            2.0F,
                            2,
                            6.0F
                    )
            );

    public static final MaterialDefinition BRONZE =
            new MaterialDefinition(
                    MaterialGroup.MAIN,
                    MaterialIDs.BRONZE,
                    "BRONZE",
                    TextFormatting.GOLD,
                    new MainMaterialStats(
                            512,
                            4.0F,
                            2,
                            12.0F
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
    public static final MaterialDefinition OBSIDIAN =
            new MaterialDefinition(
                    MaterialGroup.HANDLE,
                    MaterialIDs.OBSIDIAN,
                    "OBISDIAN",
                    TextFormatting.DARK_PURPLE,
                    new HandleMaterialStats(
                            100
                    )
            );
}
