package com.SprintXXL.primitivetoolworks.library.modifiers.stats;

public class LuckModifierStats implements ModifierStats {

    private final int luckPower;

    public LuckModifierStats(int luckPower) {

        this.luckPower = luckPower;
    }

    public int getLuckPower() {
        return luckPower;
    }


}
