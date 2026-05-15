package com.SprintXXL.primitivetoolworks.common.parts;

import com.SprintXXL.primitivetoolworks.common.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.MainPartStats;

public class PartDefinitions {

    // MAIN PARTS \\
    public static final PartDefinition PICKAXE_HEAD =
            new PartDefinition(
                    PartGroup.MAIN,
                    PartIDs.PICKAXE_HEAD,
                    "Pickaxe Head",
                    new MainPartStats(
                            ToolType.PICKAXE,
                            1.4F, // Mining Speed Multiplier
                            0.7F, // Attack Damage Modifier
                            -3.2F // Attack Speed Modifier
                    )
            );

    // EXTRA PARTS \\
    public static final PartDefinition BINDING =
            new PartDefinition(
                    PartGroup.EXTRA,
                    PartIDs.BINDING,
                    "Binding",
                    new ExtraPartStats(
                            1.5F // Mining Speed Multiplier
                    )
            );

    // HANDLE PARTS \\
    public static final PartDefinition HANDLE =
            new PartDefinition(
                    PartGroup.HANDLE,
                    PartIDs.HANDLE,
                    "Handle",
                    new HandlePartStats(
                            1.5F // Durability Multiplier
                    )
            );
}
