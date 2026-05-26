package com.SprintXXL.primitivetoolworks.library.modifiers.data;

import com.SprintXXL.primitivetoolworks.library.modifiers.stats.ModifierStats;

public class ModifierDefinition {

    private final String modifierID;
    private final String displayName;
    private final ModifierType type;
    private final ModifierStats stats;
    private final int maxLevel;

    public ModifierDefinition(
            String modifierID,
            String displayName,
            ModifierType type,
            ModifierStats stats,
            int maxLevel
    ) {
        this.modifierID = modifierID;
        this.displayName = displayName;
        this.type = type;
        this.stats = stats;
        this.maxLevel = maxLevel;
    }

    public String getModifierID() {
        return modifierID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ModifierType getType() {
        return type;
    }

    public ModifierStats getStats() {
        return stats;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
