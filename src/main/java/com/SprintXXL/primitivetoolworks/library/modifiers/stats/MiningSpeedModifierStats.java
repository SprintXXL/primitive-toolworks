package com.SprintXXL.primitivetoolworks.library.modifiers.stats;

public class MiningSpeedModifierStats implements ModifierStats {

    private final float speedPerLevel;

    public MiningSpeedModifierStats(float speedPerLevel) {

        this.speedPerLevel = speedPerLevel;
    }

    public float getSpeedPerLevel() {
        return speedPerLevel;
    }
}
