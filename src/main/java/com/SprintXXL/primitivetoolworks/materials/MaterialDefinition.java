package com.SprintXXL.primitivetoolworks.materials;

public class MaterialDefinition {

    private final String materialid;
    private final int harvestLevel;
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;

    public MaterialDefinition(String materialid, int harvestLevel, int durability, float miningSpeed, float attackDamage) {

        this.materialid = materialid;
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    public String getMaterialID() {
        return materialid;
    }
    public int getHarvestLevel() {
        return harvestLevel;
    }
    public int getDurability() {
        return durability;
    }
    public float getMiningSpeed() {
        return miningSpeed;
    }
    public float getAttackDamage() {
        return attackDamage;
    }
}
