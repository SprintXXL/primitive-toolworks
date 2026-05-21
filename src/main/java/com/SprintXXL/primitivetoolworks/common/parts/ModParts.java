package com.SprintXXL.primitivetoolworks.common.parts;

import com.SprintXXL.primitivetoolworks.common.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.common.tools.types.ToolType;

public class ModParts {

    // MAIN PARTS \\
    public static final PartDefinition SWORD_BLADE =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.SWORD_BLADE,
                    "Sword Blade",
                    3,
                    new MainPartStats(
                            ToolType.SWORD,
                            0.0F,
                            1.0F,
                            1.0F,
                            -2.0F
                    )
            );

    public static final PartDefinition PICKAXE_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.PICKAXE_HEAD,
                    "Pickaxe Head",
                    3,
                    new MainPartStats(
                            ToolType.PICKAXE,
                            1.0F, // Mining Speed Multiplier
                            1.0F,
                            0.7F, // Attack Damage Modifier
                            -3.2F // Attack Speed Modifier
                    )
            );

    public static final PartDefinition AXE_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.AXE_HEAD,
                    "Axe Head",
                    3,
                    new MainPartStats(
                            ToolType.AXE,
                            1.0F,
                            1.0F,
                            0.8F,
                            -2.8F
                    )
            );

    public static final PartDefinition SHOVEL_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.SHOVEL_HEAD,
                    "Shovel Head",
                    3,
                    new MainPartStats(
                            ToolType.SHOVEL,
                            1.0F,
                            1.0F,
                            0.5F,
                            -3.0F
                    )
            );

    public static final PartDefinition HOE_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.HOE_HEAD,
                    "Hoe Head",
                    3,
                    new MainPartStats(
                            ToolType.HOE,
                            0.3F,
                            1.0F,
                            0.3F,
                            -3.0F
                    )
            );

    public static final PartDefinition HAMMER_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.HAMMER_HEAD,
                    "Hammer Head",
                    9,
                    new MainPartStats(
                            ToolType.HAMMER,
                            3.0F,
                            9.0F,
                            0.3F,
                            -3.5F
                    )
            );

    // EXTRA PARTS \\
    public static final PartDefinition BINDING =
            new PartDefinition(
                    PartGroup.EXTRA,
                    PartIDs.BINDING,
                    "Binding",
                    1,
                    new ExtraPartStats(
                            1.0F // Mining Speed Multiplier
                    )
            );

    public static final PartDefinition TOUGH_BINDING =
            new PartDefinition(
                    PartGroup.EXTRA,
                    PartIDs.TOUGH_BINDING,
                    "Tough Binding",
                    3,
                    new ExtraPartStats(
                            3.0F
                    )
            );

    public static final PartDefinition WIDE_GUARD =
            new PartDefinition(
                    PartGroup.EXTRA,
                    PartIDs.WIDE_GUARD,
                    "Wide Guard",
                    1,
                    new ExtraPartStats(
                            0.0F
                    )
            );

    // HANDLE PARTS \\
    public static final PartDefinition HANDLE =
            new PartDefinition(
                    PartGroup.HANDLE,
                    PartIDs.HANDLE,
                    "Handle",
                    2,
                    new HandlePartStats(
                            1.0F // Durability Multiplier
                    )
            );

    public static final PartDefinition TOUGH_HANDLE =
            new PartDefinition(
                    PartGroup.HANDLE,
                    PartIDs.TOUGH_HANDLE,
                    "Tough Handle",
                    6,
                    new HandlePartStats(
                            1.0F
                    )
            );
}
