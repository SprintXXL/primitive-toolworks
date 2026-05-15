package com.SprintXXL.primitivetoolworks.common.materials.stats;

public class HandleMaterialStats implements MaterialStats {

    private final int durabilityBonus;

    public HandleMaterialStats(int durabilityBonus) {

        this.durabilityBonus = durabilityBonus;
    }

    public int getDurabilityBonus() {
        return durabilityBonus;
    }
}
