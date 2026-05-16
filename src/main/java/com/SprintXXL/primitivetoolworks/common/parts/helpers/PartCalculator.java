package com.SprintXXL.primitivetoolworks.common.parts.helpers;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.common.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartNBT;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.common.parts.stats.MainPartStats;
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

            if (!(material.getStats() instanceof MainMaterialStats)) {
                return 0;
            }

            MainMaterialStats materialStats = (MainMaterialStats) material.getStats();

            return materialStats.getDurability();
        }

        if (group == PartGroup.HANDLE) {

            if (!(material.getStats() instanceof HandleMaterialStats) || !(part.getStats() instanceof HandlePartStats)) {
                return 0;
            }

            HandleMaterialStats materialStats = (HandleMaterialStats) material.getStats();
            HandlePartStats partStats = (HandlePartStats) part.getStats();

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

            if (!(material.getStats() instanceof MainMaterialStats) || !(part.getStats() instanceof MainPartStats)) {
                return 0;
            }

            MainMaterialStats materialStats = (MainMaterialStats) material.getStats();
            MainPartStats partStats = (MainPartStats) part.getStats();

            return materialStats.getMiningSpeed() * partStats.getMiningSpeedMultiplier();
        }

        if (group == PartGroup.EXTRA) {

            if (!(material.getStats() instanceof ExtraMaterialStats) || !(part.getStats() instanceof ExtraPartStats)) {
                return 0;
            }

            ExtraMaterialStats materialStats = (ExtraMaterialStats) material.getStats();
            ExtraPartStats partStats = (ExtraPartStats) part.getStats();

            return materialStats.getMiningSpeedBonus() * partStats.getMiningSpeedMultiplier();
        }

        return 0;
    }
}
