package com.SprintXXL.primitivetoolworks.library.modifiers.data;

import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.ModifierStats;

import java.util.Set;

public class ModifierDefinition {

    private final String modifierID;
    private final String displayName;
    private final ModifierType type;
    private final ModifierStats stats;
    private final int maxLevel;
    private final Set<ToolType> allowedToolTypes;

    public ModifierDefinition(
            String modifierID,
            String displayName,
            ModifierType type,
            ModifierStats stats,
            int maxLevel,
            Set<ToolType> allowedToolTypes
    ) {
        this.modifierID = modifierID;
        this.displayName = displayName;
        this.type = type;
        this.stats = stats;
        this.maxLevel = maxLevel;
        this.allowedToolTypes = allowedToolTypes;
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

    public Set<ToolType> getAllowedToolTypes() {
        return allowedToolTypes;
    }
}
