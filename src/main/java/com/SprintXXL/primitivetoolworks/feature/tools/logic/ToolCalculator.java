package com.SprintXXL.primitivetoolworks.feature.tools.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic.ToolModifierCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import net.minecraft.item.ItemStack;

public class ToolCalculator {

    public static float getMiningSpeed(ItemStack stack) {

        MainMaterialStats mainMaterialStats = getMainMaterialStats(stack);
        ExtraMaterialStats extraMaterialStats = getExtraMaterialStats(stack);

        MainPartStats mainPartStats = getMainPartStats(stack);
        ExtraPartStats extraPartStats = getExtraPartStats(stack);

        return (
                (mainMaterialStats.getMiningSpeed()
                + extraMaterialStats.getMiningSpeedBonus()
                + ToolModifierCalculator.getMiningSpeedBonus(stack))
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

        Material material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(toolType.getDefaultMainMaterial());
        }

        return (MainMaterialStats) material.getMaterialStats();
    }

    private static ExtraMaterialStats getExtraMaterialStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String materialID = ToolNBT.getExtraMaterial(stack);

        Material material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(toolType.getDefaultExtraMaterial());
        }

        return (ExtraMaterialStats) material.getMaterialStats();
    }

    private static HandleMaterialStats getHandleMaterialStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String materialID = ToolNBT.getHandleMaterial(stack);

        Material material = MaterialRegistry.getMaterial(materialID);

        if (material == null) {
            material = MaterialRegistry.getMaterial(toolType.getDefaultHandleMaterial());
        }

        return (HandleMaterialStats) material.getMaterialStats();
    }

    // PART HELPER METHODS \\
    private static MainPartStats getMainPartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getMainPart(stack);

        Part part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(toolType.getDefaultMainPart());
        }

        return (MainPartStats) part.getPartStats();
    }

    private static ExtraPartStats getExtraPartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getExtraPart(stack);

        Part part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(toolType.getDefaultExtraPart());
        }

        return (ExtraPartStats) part.getPartStats();
    }

    private static HandlePartStats getHandlePartStats(ItemStack stack) {

        ToolType toolType = ToolNBT.getToolType(stack);

        String partID = ToolNBT.getHandlePart(stack);

        Part part = PartRegistry.getPart(partID);

        if (part == null) {
            part = PartRegistry.getPart(toolType.getDefaultHandlePart());
        }

        return (HandlePartStats) part.getPartStats();
    }
}
