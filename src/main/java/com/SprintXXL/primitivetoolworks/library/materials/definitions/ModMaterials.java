package com.SprintXXL.primitivetoolworks.library.materials.definitions;

import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialGroup;
import com.SprintXXL.primitivetoolworks.library.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.MainMaterialStats;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;
import net.minecraft.util.text.TextFormatting;

public class ModMaterials {

    private ModMaterials() {}

    public static void initMaterialDefinitions(DefinitionRegistrar<Material> registrar) {

        registrar.register(FLINT);
        registrar.register(IRON);
        registrar.register(BRONZE);
        registrar.register(BONE);
        registrar.register(WOOD);
        registrar.register(OBSIDIAN);
    }

    // MAIN MATERIALS \\
    public static final Material FLINT =
            new Material(
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

    public static final Material IRON =
            new Material(
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

    public static final Material BRONZE =
            new Material(
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
    public static final Material BONE =
            new Material(
                    MaterialGroup.EXTRA,
                    MaterialIDs.BONE,
                    "BONE",
                    TextFormatting.WHITE,
                    new ExtraMaterialStats(
                            1.0F // Mining Speed Bonus
                    )
            );

    // HANDLE MATERIALS \\
    public static final Material WOOD =
            new Material(
                    MaterialGroup.HANDLE,
                    MaterialIDs.WOOD,
                    "WOOD",
                    TextFormatting.GOLD,
                    new HandleMaterialStats(
                            10 // Durability Bonus
                    )
            );
    public static final Material OBSIDIAN =
            new Material(
                    MaterialGroup.HANDLE,
                    MaterialIDs.OBSIDIAN,
                    "OBISDIAN",
                    TextFormatting.DARK_PURPLE,
                    new HandleMaterialStats(
                            100
                    )
            );
}
