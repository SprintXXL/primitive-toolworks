package com.SprintXXL.primitivetoolworks.library.modifiers.definitions;

import com.SprintXXL.primitivetoolworks.library.modifiers.Modifier;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierType;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.LuckModifierStats;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.MiningSpeedModifierStats;
import com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ModToolTypes;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

import java.util.Set;

public final class ModModifiers {

    private ModModifiers() {}

    public static void initModifierDefinitions(DefinitionRegistrar<Modifier> registrar) {

        registrar.register(HASTE);
        registrar.register(LUCK);
    }

    public static final Modifier HASTE =
            new Modifier(
                    ModifierIDs.HASTE,
                    "HASTE",
                    ModifierType.MINING,
                    new MiningSpeedModifierStats(1.0F),
                    10,
                    Set.of(
                            ModToolTypes.PICKAXE,
                            ModToolTypes.AXE,
                            ModToolTypes.SHOVEL,
                            ModToolTypes.HAMMER
                    )
            );

    public static final Modifier LUCK =
            new Modifier(
                    ModifierIDs.LUCK,
                    "LUCK",
                    ModifierType.MINING,
                    new LuckModifierStats(1),
                    10,
                    Set.of(
                            ModToolTypes.PICKAXE,
                            ModToolTypes.SWORD,
                            ModToolTypes.HAMMER
                    )
            );
}
