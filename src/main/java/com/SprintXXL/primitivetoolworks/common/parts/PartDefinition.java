package com.SprintXXL.primitivetoolworks.common.parts;

import com.SprintXXL.primitivetoolworks.common.parts.stats.PartStats;

public class PartDefinition {

    private final PartGroup group;
    private final String partid;
    private final String title;
    private final PartStats stats;

    public PartDefinition (PartGroup group, String partid, String title, PartStats stats) {

        this.group = group;
        this.partid = partid;
        this.title = title;
        this.stats = stats;
    }

    public PartGroup getGroup() {
        return group;
    }

    public String getPartID() {
        return partid;
    }

    public String getTitle() {
        return title;
    }

    public PartStats getStats() {
        return stats;
    }
}
