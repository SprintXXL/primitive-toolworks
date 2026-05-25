package com.SprintXXL.primitivetoolworks.library.parts.stats;

public class ExtraPartStats implements PartStats {

    private final float miningSpeedMultiplier;

    public ExtraPartStats(float miningSpeedMultiplier) {

        this.miningSpeedMultiplier = miningSpeedMultiplier;
    }

    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }
}
