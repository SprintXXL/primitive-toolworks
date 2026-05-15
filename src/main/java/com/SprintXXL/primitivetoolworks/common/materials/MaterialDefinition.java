package com.SprintXXL.primitivetoolworks.common.materials;

import com.SprintXXL.primitivetoolworks.common.materials.stats.MaterialStats;
import net.minecraft.util.text.TextFormatting;

public class MaterialDefinition {

    private final MaterialGroup group;
    private final String materialid;
    private final String displayName;
    private final TextFormatting displayColor;
    private final MaterialStats stats;

    public MaterialDefinition(MaterialGroup group, String materialid, String displayName, TextFormatting displayColor, MaterialStats stats) {

        this.group = group;
        this.materialid = materialid;
        this.displayName = displayName;
        this.displayColor = displayColor;
        this.stats = stats;

    }

    public MaterialGroup getGroup() {
        return group;
    }
    public String getMaterialID() {
        return materialid;
    }
    public String getDisplayName() {
        return displayName;
    }
    public TextFormatting getDisplayColor() {
        return displayColor;
    }
    public MaterialStats getStats() {
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
