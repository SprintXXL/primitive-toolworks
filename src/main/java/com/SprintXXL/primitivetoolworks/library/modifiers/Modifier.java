package com.SprintXXL.primitivetoolworks.library.modifiers;

import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierType;
import com.SprintXXL.primitivetoolworks.library.modifiers.stats.ModifierStats;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;

import java.util.Set;

public class Modifier implements AscentDefinition {

    private final String id;
    private final String displayName;
    private final ModifierType type;
    private final ModifierStats stats;
    private final int maxLevel;
    private final Set<ToolType> allowedToolType;

    public Modifier(
            String modifierID,
            String displayName,
            ModifierType type,
            ModifierStats stats,
            int maxLevel,
            Set<ToolType> allowedToolType
    ) {
        this.id = modifierID;
        this.displayName = displayName;
        this.type = type;
        this.stats = stats;
        this.maxLevel = maxLevel;
        this.allowedToolType = allowedToolType;
    }

    @Override
    public String getID() {
        return id;
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

    public Set<ToolType> getAllowedToolType() {
        return allowedToolType;
    }
}
