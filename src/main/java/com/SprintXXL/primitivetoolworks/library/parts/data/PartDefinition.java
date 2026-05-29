package com.SprintXXL.primitivetoolworks.library.parts.data;

import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.library.parts.stats.PartStats;

import java.util.Set;

public class PartDefinition {

    private final PartGroup group;
    private final String ID;
    private final String title;
    private final int materialCost;
    private final Set<ToolType> allowedToolTypes;
    private final PartStats stats;

    public PartDefinition (PartGroup group, String ID, String title, int materialCost, Set<ToolType> allowedToolTypes, PartStats stats) {

        this.group = group;
        this.ID = ID;
        this.title = title;
        this.materialCost = materialCost;
        this.allowedToolTypes = allowedToolTypes;
        this.stats = stats;
    }

    public PartGroup getPartGroup() {
        return group;
    }

    public String getPartID() {
        return ID;
    }

    public String getPartTitle() {
        return title;
    }

    public int getPartMaterialCost() {
        return materialCost;
    }

    public Set<ToolType> getAllowedToolTypes() {
        return allowedToolTypes;
    }

    public PartStats getPartStats() {
        return stats;
    }
}
