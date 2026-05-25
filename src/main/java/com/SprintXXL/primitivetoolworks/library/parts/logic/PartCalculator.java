package com.SprintXXL.primitivetoolworks.library.parts.logic;

import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.materials.stats.ExtraMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.HandleMaterialStats;
import com.SprintXXL.primitivetoolworks.library.materials.stats.MainMaterialStats;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartDefinition;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.stats.ExtraPartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.HandlePartStats;
import com.SprintXXL.primitivetoolworks.library.parts.stats.MainPartStats;
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
