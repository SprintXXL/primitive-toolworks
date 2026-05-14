package com.SprintXXL.primitivetoolworks.tools;

import com.SprintXXL.primitivetoolworks.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.parts.PartRegistry;
import net.minecraft.item.ItemStack;

public class ToolCalculator {

    public static float getMiningSpeed(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        PartDefinition mainPart = PartRegistry.getPart(ToolNBT.getMainPart(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_MAIN_MATERIAL);
        }

        if (mainPart == null) {
            mainPart = PartRegistry.getPart(ToolDefaults.DEFAULT_MAIN_PART);
        }

        if (mainMaterial == null || mainPart == null) {
            return 1;
        }

        return mainMaterial.getMiningSpeed() * mainPart.getMiningSpeedMultiplier();
    }

    public static int getHarvestLevel(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_MAIN_MATERIAL);
        }
        if (mainMaterial == null) {
            return 1;
        }

        return mainMaterial.getHarvestLevel();
    }

    public static int getDurability(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        PartDefinition mainPart = PartRegistry.getPart(ToolNBT.getMainPart(stack));
        PartDefinition extraPart = PartRegistry.getPart(ToolNBT.getExtraPart(stack));
        PartDefinition handlePart = PartRegistry.getPart(ToolNBT.getHandlePart(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_MAIN_MATERIAL);
        }

        if (mainPart == null) {
            mainPart = PartRegistry.getPart(ToolDefaults.DEFAULT_MAIN_PART);
        }

        if (extraPart == null) {
            extraPart = PartRegistry.getPart(ToolDefaults.DEFAULT_EXTRA_PART);
        }

        if (handlePart == null) {
            handlePart = PartRegistry.getPart(ToolDefaults.DEFAULT_HANDLE_PART);
        }

        if (mainMaterial == null || mainPart == null || extraPart == null || handlePart == null) {
            return 1;
        }

        return mainMaterial.getDurability() * mainPart.getDurabilityMultiplier() * extraPart.getDurabilityMultiplier() * handlePart.getDurabilityMultiplier();
    }

    public static float getAttackDamage(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        PartDefinition mainPart = PartRegistry.getPart(ToolNBT.getMainPart(stack));

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_MAIN_MATERIAL);
        }

        if (mainPart == null) {
            mainPart = PartRegistry.getPart(ToolDefaults.DEFAULT_MAIN_PART);
        }

        if (mainMaterial == null || mainPart == null) {
            return 1;
        }

        return mainMaterial.getAttackDamage() * mainPart.getAttackDamageMultiplier();
    }
}
