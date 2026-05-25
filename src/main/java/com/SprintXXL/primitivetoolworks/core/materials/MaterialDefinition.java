package com.SprintXXL.primitivetoolworks.core.materials;

import com.SprintXXL.primitivetoolworks.core.materials.stats.MaterialStats;
import net.minecraft.util.text.TextFormatting;

public class MaterialDefinition {

    private final MaterialGroup group;
    private final String ID;
    private final String displayName;
    private final TextFormatting displayColor;
    private final MaterialStats stats;

    public MaterialDefinition(MaterialGroup group, String ID, String displayName, TextFormatting displayColor, MaterialStats stats) {

        this.group = group;
        this.ID = ID;
        this.displayName = displayName;
        this.displayColor = displayColor;
        this.stats = stats;

    }

    public MaterialGroup getMaterialGroup() {
        return group;
    }
    public String getMaterialID() {
        return ID;
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
