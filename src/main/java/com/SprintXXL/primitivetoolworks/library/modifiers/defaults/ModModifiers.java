package com.SprintXXL.primitivetoolworks.library.modifiers.defaults;

import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierIDs;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierType;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.MiningSpeedModifierStats;

public final class ModModifiers {

    private ModModifiers() {}

    public static final ModifierDefinition HASTE =
            new ModifierDefinition(
                    ModifierIDs.HASTE,
                    "HASTE",
                    ModifierType.MINING,
                    new MiningSpeedModifierStats(1.0F),
                    10
            );
}
