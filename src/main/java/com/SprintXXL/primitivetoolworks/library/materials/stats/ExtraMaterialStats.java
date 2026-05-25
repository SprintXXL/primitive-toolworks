package com.SprintXXL.primitivetoolworks.library.materials.stats;

public class ExtraMaterialStats implements MaterialStats {

    private final float miningSpeedBonus;

    public ExtraMaterialStats(float miningSpeedBonus) {

        this.miningSpeedBonus = miningSpeedBonus;
    }

    public float getMiningSpeedBonus() {
        return miningSpeedBonus;
    }
}
