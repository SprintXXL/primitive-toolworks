package com.SprintXXL.primitivetoolworks.core.tools;

import com.SprintXXL.primitivetoolworks.core.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.core.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.core.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.core.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.core.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.core.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.core.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.core.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.core.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.core.tools.types.ToolType;
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

        MainPartStats mainPartStats = getMainPartStats(stack);
        HandlePartStats handlePartStats = getHandlePartStats(stack);

        return (int)(
                (mainMaterialStats.getDurability()
                + handleMaterialStats.getDurabilityBonus())
                * mainPartStats.getDurabilityMultiplier()
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

        ToolType toolType = ToolNBT.getToolType(stack);

        String materialID = ToolNBT.getMainMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.getDefaultMainMaterial(toolType));
        }

        return (MainMaterialStats) material.getMaterialStats();
    }

    private static ExtraMaterialStats getExtraMaterialStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String materialID = ToolNBT.getExtraMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.getDefaultExtraMaterial(toolType));
        }

        return (ExtraMaterialStats) material.getMaterialStats();
    }

    private static HandleMaterialStats getHandleMaterialStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String materialID = ToolNBT.getHandleMaterial(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(ToolDefaults.getDefaultHandleMaterial(toolType));
        }

        return (HandleMaterialStats) material.getMaterialStats();
    }

    // PART HELPER METHODS \\
    private static MainPartStats getMainPartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getMainPart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(ToolDefaults.getDefaultMainPart(toolType));
        }

        return (MainPartStats) part.getPartStats();
    }

    private static ExtraPartStats getExtraPartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getExtraPart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(ToolDefaults.getDefaultExtraPart(toolType));
        }

        return (ExtraPartStats) part.getPartStats();
    }

    private static HandlePartStats getHandlePartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getHandlePart(stack);

        PartDefinition part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(ToolDefaults.getDefaultHandlePart(toolType));
        }

        return (HandlePartStats) part.getPartStats();
    }
}
