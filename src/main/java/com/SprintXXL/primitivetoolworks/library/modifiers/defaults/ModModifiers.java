package com.SprintXXL.primitivetoolworks.library.modifiers.defaults;

import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierIDs;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierType;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.LuckModifierStats;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.MiningSpeedModifierStats;

import java.util.EnumSet;

public final class ModModifiers {

    private ModModifiers() {}

    public static final ModifierDefinition HASTE =
            new ModifierDefinition(
                    ModifierIDs.HASTE,
                    "HASTE",
                    ModifierType.MINING,
                    new MiningSpeedModifierStats(1.0F),
                    10,
                    EnumSet.of(
                            ToolType.PICKAXE,
                            ToolType.AXE,
                            ToolType.SHOVEL,
                            ToolType.HAMMER
                    )
            );

    public static final ModifierDefinition LUCK =
            new ModifierDefinition(
                    ModifierIDs.LUCK,
                    "LUCK",
                    ModifierType.MINING,
                    new LuckModifierStats(1),
                    10,
                    EnumSet.of(
                            ToolType.PICKAXE,
                            ToolType.SWORD,
                            ToolType.HAMMER
                    )
            );
}
