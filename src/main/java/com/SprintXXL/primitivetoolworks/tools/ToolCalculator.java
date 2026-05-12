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

        return mainMaterial.getMiningSpeed() * mainPart.getMiningSpeedMultiplier();
    }

    public static int getHarvestLevel(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));

        return mainMaterial.getHarvestLevel();
    }

    public static int getDurability(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        PartDefinition mainPart = PartRegistry.getPart(ToolNBT.getMainPart(stack));
        PartDefinition handlePart = PartRegistry.getPart(ToolNBT.getHandlePart(stack));

        return mainMaterial.getDurability() * mainPart.getDurabilityMultiplier() * handlePart.getDurabilityMultiplier();
    }

    public static float getAttackDamage(ItemStack stack) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        PartDefinition mainPart = PartRegistry.getPart(ToolNBT.getMainPart(stack));

        return mainMaterial.getAttackDamage() * mainPart.getAttackDamageMultiplier();
    }
}
