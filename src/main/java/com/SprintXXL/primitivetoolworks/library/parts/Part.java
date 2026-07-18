package com.SprintXXL.primitivetoolworks.library.parts;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.stats.PartStats;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;

import java.util.Set;

public class Part implements AscentDefinition {

    private final PartGroup group;
    private final String id;
    private final String title;
    private final int materialCost;
    private final Set<ToolType> allowedToolType;
    private final PartStats stats;

    public Part(PartGroup group, String id, String title, int materialCost, Set<ToolType> allowedToolType, PartStats stats) {

        this.group = group;
        this.id = id;
        this.title = title;
        this.materialCost = materialCost;
        this.allowedToolType = allowedToolType;
        this.stats = stats;
    }

    @Override
    public String getID() {
        return id;
    }

    public PartGroup getPartGroup() {
        return group;
    }

    public String getPartTitle() {
        return title;
    }

    public int getPartMaterialCost() {
        return materialCost;
    }

    public Set<ToolType> getAllowedToolType() {
        return allowedToolType;
    }

    public PartStats getPartStats() {
        return stats;
    }
}
