package com.SprintXXL.primitivetoolworks.library.parts.definitions;

import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ModToolTypes;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

import java.util.Set;

public class ModParts {

    public static void initPartDefinitions(DefinitionRegistrar<Part> registrar) {

        registrar.register(SWORD_BLADE);
        registrar.register(PICKAXE_HEAD);
        registrar.register(AXE_HEAD);
        registrar.register(SHOVEL_HEAD);
        registrar.register(HOE_HEAD);
        registrar.register(HAMMER_HEAD);
        registrar.register(BINDING);
        registrar.register(TOUGH_BINDING);
        registrar.register(WIDE_GUARD);
        registrar.register(HANDLE);
        registrar.register(TOUGH_HANDLE);
    }

    // MAIN PARTS \\
    public static final Part SWORD_BLADE =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.SWORD_BLADE,
                    "Sword Blade",
                    3,
                    Set.of(
                            ModToolTypes.SWORD
                    ),
                    new MainPartStats(
                            ModToolTypes.SWORD,
                            0.0F,
                            1.0F,
                            1.0F,
                            -2.0F
                    )
            );

    public static final Part PICKAXE_HEAD =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.PICKAXE_HEAD,
                    "Pickaxe Head",
                    3,
                    Set.of(
                            ModToolTypes.PICKAXE
                    ),
                    new MainPartStats(
                            ModToolTypes.PICKAXE,
                            1.0F, // Mining Speed Multiplier
                            1.0F,
                            0.7F, // Attack Damage Modifier
                            -3.2F // Attack Speed Modifier
                    )
            );

    public static final Part AXE_HEAD =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.AXE_HEAD,
                    "Axe Head",
                    3,
                    Set.of(
                            ModToolTypes.AXE
                    ),
                    new MainPartStats(
                            ModToolTypes.AXE,
                            1.0F,
                            1.0F,
                            0.8F,
                            -2.8F
                    )
            );

    public static final Part SHOVEL_HEAD =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.SHOVEL_HEAD,
                    "Shovel Head",
                    3,
                    Set.of(
                            ModToolTypes.SHOVEL
                    ),
                    new MainPartStats(
                            ModToolTypes.SHOVEL,
                            1.0F,
                            1.0F,
                            0.5F,
                            -3.0F
                    )
            );

    public static final Part HOE_HEAD =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.HOE_HEAD,
                    "Hoe Head",
                    3,
                    Set.of(
                            ModToolTypes.HOE
                    ),
                    new MainPartStats(
                            ModToolTypes.HOE,
                            0.3F,
                            1.0F,
                            0.3F,
                            -3.0F
                    )
            );

    public static final Part HAMMER_HEAD =
            new Part(
                    PartGroup.MAIN,
                    PartIDs.HAMMER_HEAD,
                    "Hammer Head",
                    9,
                    Set.of(
                            ModToolTypes.HAMMER
                    ),
                    new MainPartStats(
                            ModToolTypes.HAMMER,
                            0.1F,
                            9.0F,
                            0.3F,
                            -3.5F
                    )
            );

    // EXTRA PARTS \\
    public static final Part BINDING =
            new Part(
                    PartGroup.EXTRA,
                    PartIDs.BINDING,
                    "Binding",
                    1,
                    Set.of(
                            ModToolTypes.PICKAXE,
                            ModToolTypes.AXE,
                            ModToolTypes.SHOVEL,
                            ModToolTypes.HOE
                    ),
                    new ExtraPartStats(
                            1.0F // Mining Speed Multiplier
                    )
            );

    public static final Part TOUGH_BINDING =
            new Part(
                    PartGroup.EXTRA,
                    PartIDs.TOUGH_BINDING,
                    "Tough Binding",
                    3,
                    Set.of(
                            ModToolTypes.HAMMER
                    ),
                    new ExtraPartStats(
                            3.0F
                    )
            );

    public static final Part WIDE_GUARD =
            new Part(
                    PartGroup.EXTRA,
                    PartIDs.WIDE_GUARD,
                    "Wide Guard",
                    1,
                    Set.of(
                            ModToolTypes.SWORD
                    ),
                    new ExtraPartStats(
                            0.0F
                    )
            );

    // HANDLE PARTS \\
    public static final Part HANDLE =
            new Part(
                    PartGroup.HANDLE,
                    PartIDs.HANDLE,
                    "Handle",
                    2,
                    Set.of(
                            ModToolTypes.SWORD,
                            ModToolTypes.PICKAXE,
                            ModToolTypes.AXE,
                            ModToolTypes.SHOVEL,
                            ModToolTypes.HOE
                    ),
                    new HandlePartStats(
                            1.0F // Durability Multiplier
                    )
            );

    public static final Part TOUGH_HANDLE =
            new Part(
                    PartGroup.HANDLE,
                    PartIDs.TOUGH_HANDLE,
                    "Tough Handle",
                    6,
                    Set.of(
                            ModToolTypes.HAMMER
                    ),
                    new HandlePartStats(
                            1.0F
                    )
            );
}
