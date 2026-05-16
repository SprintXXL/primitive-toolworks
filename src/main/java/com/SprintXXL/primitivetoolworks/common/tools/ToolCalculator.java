package com.SprintXXL.primitivetoolworks.common.tools;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.common.parts.defaults.PartDefaults;
import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.common.tools.defaults.ToolDefaults;
import net.minecraft.item.ItemStack;

public class ToolCalculator {

    public static float getMiningSpeed(ItemStack stack) {

        MainMaterialStats mainMaterialStats = getMainMaterialStats(stack);
        ExtraMaterialStats extraMaterialStats = getExtraMaterialStats(stack);

        MainPartStats mainPartStats = getMainPartStats(stack);
        ExtraPartStats extraPartStats = getExtraPartStats(stack);

        return (
                (mainMaterialStats.getMiningSpeed()
                + extraMaterialStats.getMiningSpeedBonus())
                * mainPartStats.getMiningSpeedMultiplier()
                * extraPartStats.getMiningSpeedMultiplier()
        );
    }

    public static int getHarvestLevel(ItemStack stack) {

        MainMaterialStats mainMaterialStats = getMainMaterialStats(stack);

        return mainMaterialStats.getHarvestLevel();
    }

    public static int getDurability(ItemStack stack) {

        MainMaterialStats mainMaterialStats = getMainMaterialStats(stack);
        HandleMaterialStats handleMaterialStats = getHandleMaterialStats(stack);

        HandlePartStats handlePartStats = getHandlePartStats(stack);

        return (int)(
                (mainMaterialStats.getDurability()
                + handleMaterialStats.getDurabilityBonus())
                * handlePartStats.getDurabilityMultiplier()
        );

    }

    public static float getAttackDamage(ItemStack stack) {

        MainMaterialStats mainMaterialStats = getMainMaterialStats(stack);

        MainPartStats mainPartStats = getMainPartStats(stack);

        return (
                mainMaterialStats.getAttackDamage()
                * mainPartStats.getAttackDamageModifier()
                );
    }

    public static float getAttackSpeed(ItemStack stack) {

        MainPartStats mainPartStats = getMainPartStats(stack);

        return mainPartStats.getAttackSpeedModifier();
    }



    // MATERIAL HELPER METHODS \\
    private static MainMaterialStats getMainMaterialStats(ItemStack stack) {

        String materialID = ToolNBT.getMainMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_MAIN_MATERIAL);
        }

        return (MainMaterialStats) material.getStats();
    }

    private static ExtraMaterialStats getExtraMaterialStats(ItemStack stack) {

        String materialID = ToolNBT.getExtraMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_EXTRA_MATERIAL);
        }

        return (ExtraMaterialStats) material.getStats();
    }

    private static HandleMaterialStats getHandleMaterialStats(ItemStack stack) {

        String materialID = ToolNBT.getHandleMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.DEFAULT_HANDLE_MATERIAL);
        }

        return (HandleMaterialStats) material.getStats();
    }

    // PART HELPER METHODS \\
    private static MainPartStats getMainPartStats(ItemStack stack) {

        String partID = ToolNBT.getMainPart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(PartDefaults.DEFAULT_MAIN_PART);
        }

        return (MainPartStats) part.getStats();
    }

    private static ExtraPartStats getExtraPartStats(ItemStack stack) {

        String partID = ToolNBT.getExtraPart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(PartDefaults.DEFAULT_EXTRA_PART);
        }

        return (ExtraPartStats) part.getStats();
    }

    private static HandlePartStats getHandlePartStats(ItemStack stack) {

        String partID = ToolNBT.getHandlePart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(PartDefaults.DEFAULT_HANDLE_PART);
        }

        return (HandlePartStats) part.getStats();
    }
}
