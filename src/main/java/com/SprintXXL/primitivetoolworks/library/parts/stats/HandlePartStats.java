package com.SprintXXL.primitivetoolworks.library.parts.stats;

public class HandlePartStats implements PartStats {

    private final float durabilityMultiplier;

    public HandlePartStats(float durabilityMultiplier) {

        this.durabilityMultiplier = durabilityMultiplier;
    }

    public float getDurabilityMultiplier() {
        return durabilityMultiplier;
    }
}
