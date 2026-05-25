package com.SprintXXL.primitivetoolworks.library.materials.stats;

public class MainMaterialStats implements MaterialStats {

    private final int durability;
    private final float miningSpeed;
    private final int harvestLevel;
    private final float attackDamage;

    public MainMaterialStats(int durability, float miningSpeed, int harvestLevel, float attackDamage) {

        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.harvestLevel = harvestLevel;
        this.attackDamage = attackDamage;
    }

    public int getDurability() {
        return durability;
    }

    public float getMiningSpeed() {
        return miningSpeed;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public float getAttackDamage() {
        return attackDamage;
    }
}
