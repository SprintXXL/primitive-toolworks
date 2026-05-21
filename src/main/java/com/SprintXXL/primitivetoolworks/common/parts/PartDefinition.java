package com.SprintXXL.primitivetoolworks.common.parts;

import com.SprintXXL.primitivetoolworks.common.parts.stats.PartStats;

public class PartDefinition {

    private final PartGroup group;
    private final String ID;
    private final String title;
    private final int materialCost;
    private final PartStats stats;

    public PartDefinition (PartGroup group, String ID, String title, int materialCost, PartStats stats) {

        this.group = group;
        this.ID = ID;
        this.title = title;
        this.materialCost = materialCost;
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

    public PartStats getPartStats() {
        return stats;
    }
}
