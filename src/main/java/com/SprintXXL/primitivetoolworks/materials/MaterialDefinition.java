package com.SprintXXL.primitivetoolworks.materials;

import net.minecraft.util.text.TextFormatting;

public class MaterialDefinition {

    private final String materialid;
    private final String displayName;
    private final TextFormatting displayColor;
    private final int harvestLevel;
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;

    public MaterialDefinition(String materialid, String displayName, TextFormatting displayColor, int harvestLevel, int durability, float miningSpeed, float attackDamage) {

        this.materialid = materialid;
        this.displayName = displayName;
        this.displayColor = displayColor;
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
    }

    public String getMaterialID() {
        return materialid;
    }
    public String getDisplayName() {
        return displayName;
    }
    public TextFormatting getDisplayColor() {
        return displayColor;
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
    public String getFormattedDisplayName() {
        return displayColor + displayName;
    }
    public String getTitleDisplayName() {
        String lower = displayName.toLowerCase();

        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }
}
