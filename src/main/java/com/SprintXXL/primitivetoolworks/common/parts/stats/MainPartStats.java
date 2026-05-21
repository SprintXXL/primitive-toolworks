package com.SprintXXL.primitivetoolworks.common.parts.stats;

import com.SprintXXL.primitivetoolworks.common.tools.types.ToolType;

public class MainPartStats implements PartStats {

    private final ToolType type;
    private final float miningSpeedMultiplier;
    private final float durabilityMultiplier;
    private final float attackDamageModifier;
    private final float attackSpeedModifier;

    public MainPartStats(ToolType type, float miningSpeedMultiplier, float durabilityMultiplier, float attackDamageModifier, float attackSpeedModifier) {

        this.type = type;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.durabilityMultiplier = durabilityMultiplier;
        this.attackDamageModifier = attackDamageModifier;
        this.attackSpeedModifier = attackSpeedModifier;
    }

    public ToolType getToolType() {
        return type;
    }

    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    public float getDurabilityMultiplier() {
        return durabilityMultiplier;
    }

    public float getAttackDamageModifier() {
        return attackDamageModifier;
    }

    public float getAttackSpeedModifier() {
        return attackSpeedModifier;
    }
}
