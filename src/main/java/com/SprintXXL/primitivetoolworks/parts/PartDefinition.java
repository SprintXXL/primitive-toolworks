package com.SprintXXL.primitivetoolworks.parts;

public class PartDefinition {

    private final String partid;
    private final String title;
    private final int durabilityMultiplier;
    private final int miningSpeedMultiplier;
    private final int attackDamageMultiplier;

    public PartDefinition (String partid, String title, int durabilityMultiplier, int miningSpeedMultiplier, int attackDamageMultiplier) {

        this.partid = partid;
        this.title = title;
        this.durabilityMultiplier = durabilityMultiplier;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamageMultiplier = attackDamageMultiplier;
    }

    public String getPartID() {
        return partid;
    }
    public String getTitle() {
        return title;
    }
    public int getDurabilityMultiplier() {
        return durabilityMultiplier;
    }
    public int getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }
    public int getAttackDamageMultiplier() {
        return attackDamageMultiplier;
    }
}
