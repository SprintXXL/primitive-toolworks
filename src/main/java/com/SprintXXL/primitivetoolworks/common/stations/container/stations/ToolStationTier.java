package com.SprintXXL.primitivetoolworks.common.stations.container.stations;

public enum ToolStationTier {

    TOOL_STATION(0),
    TOOL_FORGE(1);

    private final int level;

    ToolStationTier(int level) {
        this.level = level;
    }

    public boolean canCraft(ToolStationTier requiredTier) {
        return this.level >= requiredTier.level;
    }
}
