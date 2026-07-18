package com.SprintXXL.primitivetoolworks.feature.tools.features.levels.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt.ToolLevelNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolItemHelper;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ModToolTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ToolExperienceHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        EntityPlayer player = event.getPlayer();

        ItemStack heldStack = player.getHeldItemMainhand();

        if (heldStack.isEmpty()) {
            return;
        }

        if (!ToolItemHelper.isModularTool(heldStack)) {
            return;
        }

        ToolType toolType = ToolNBT.getToolType(heldStack);

        if (toolType == null) {
            return;
        }

        if (toolType == ModToolTypes.SWORD) {
            return;
        }

        addToolXP(heldStack, 1);
    }

    public static void addToolXP(ItemStack toolStack, int amount) {

        int level = ToolLevelNBT.getLevel(toolStack);

        if (level <= 0) {
            level = 1;
            ToolLevelNBT.setLevel(toolStack, level);
        }

        ToolLevelNBT.addXP(toolStack, amount);
        ToolLevelNBT.addTotalXP(toolStack, amount);

        int xp = ToolLevelNBT.getXP(toolStack);
        int requiredXP = ToolLevelCalculator.getRequiredXP(level);

        if (xp >= requiredXP) {
            level++;
            xp = xp - requiredXP;

            ToolLevelNBT.setLevel(toolStack, level);
            ToolLevelNBT.setXP(toolStack, xp);

            ToolModifierSlotNBT.addModifierSlots(toolStack, 1);
        }

        ToolLevelNBT.setXP(toolStack, xp);
    }
}
