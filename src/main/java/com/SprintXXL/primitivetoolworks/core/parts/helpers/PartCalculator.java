package com.SprintXXL.primitivetoolworks.core.parts.helpers;

import com.SprintXXL.primitivetoolworks.core.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.core.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.core.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.core.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.core.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.core.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.core.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.core.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.core.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.core.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.core.parts.stats.MainPartStats;
import net.minecraft.item.ItemStack;

public class PartCalculator {

    public static int getPartDurability(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partID = PartNBT.getPartType(stack);
        PartGroup group = PartNBT.getPartGroup(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);
        PartDefinition part = PartRegistry.getPart(partID);

        if (material == null || part == null || group == null) {
            return 0;
        }

        if (group == PartGroup.MAIN) {

            if (!(material.getMaterialStats() instanceof MainMaterialStats)) {
                return 0;
            }

            MainMaterialStats materialStats = (MainMaterialStats) material.getMaterialStats();

            return materialStats.getDurability();
        }

        if (group == PartGroup.HANDLE) {

            if (!(material.getMaterialStats() instanceof HandleMaterialStats) || !(part.getPartStats() instanceof HandlePartStats)) {
                return 0;
            }

            HandleMaterialStats materialStats = (HandleMaterialStats) material.getMaterialStats();
            HandlePartStats partStats = (HandlePartStats) part.getPartStats();

            return (int) (materialStats.getDurabilityBonus() * partStats.getDurabilityMultiplier());
        }

        return 0;
    }

    public static float getPartMiningSpeed(ItemStack stack) {

        String materialID = PartNBT.getMaterial(stack);
        String partID = PartNBT.getPartType(stack);
        PartGroup group = PartNBT.getPartGroup(stack);

        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);
        PartDefinition part = PartRegistry.getPart(partID);

        if (material == null || part == null || group == null) {
            return 0;
        }

        if (group == PartGroup.MAIN) {

            if (!(material.getMaterialStats() instanceof MainMaterialStats) || !(part.getPartStats() instanceof MainPartStats)) {
                return 0;
            }

            MainMaterialStats materialStats = (MainMaterialStats) material.getMaterialStats();
            MainPartStats partStats = (MainPartStats) part.getPartStats();

            return materialStats.getMiningSpeed() * partStats.getMiningSpeedMultiplier();
        }

        if (group == PartGroup.EXTRA) {

            if (!(material.getMaterialStats() instanceof ExtraMaterialStats) || !(part.getPartStats() instanceof ExtraPartStats)) {
                return 0;
            }

            ExtraMaterialStats materialStats = (ExtraMaterialStats) material.getMaterialStats();
            ExtraPartStats partStats = (ExtraPartStats) part.getPartStats();

            return materialStats.getMiningSpeedBonus() * partStats.getMiningSpeedMultiplier();
        }

        return 0;
    }
}
