package com.SprintXXL.primitivetoolworks.library.materials;

import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialGroup;
import com.SprintXXL.primitivetoolworks.library.materials.stats.MaterialStats;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;
import net.minecraft.util.text.TextFormatting;

public class Material implements AscentDefinition {

    private final MaterialGroup group;
    private final String id;
    private final String displayName;
    private final TextFormatting displayColor;
    private final MaterialStats stats;

    public Material(MaterialGroup group,
                    String id,
                    String displayName,
                    TextFormatting displayColor,
                    MaterialStats stats
    ) {
        this.group = group;
        this.id = id;
        this.displayName = displayName;
        this.displayColor = displayColor;
        this.stats = stats;
    }

    @Override
    public String getID() {
        return id;
    }

    public MaterialGroup getMaterialGroup() {
        return group;
    }

    public String getMaterialDisplayName() {
        return displayName;
    }

    public TextFormatting getMaterialDisplayColor() {
        return displayColor;
    }

    public MaterialStats getMaterialStats() {
        return stats;
    }

    public String getFormattedDisplayName() {
        return displayColor + displayName;
    }

    public String getTitleDisplayName() {
        String lower = displayName.toLowerCase();

        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }
}
