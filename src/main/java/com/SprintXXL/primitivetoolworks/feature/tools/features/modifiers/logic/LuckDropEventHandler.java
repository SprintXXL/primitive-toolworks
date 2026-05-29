package com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic;

import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LuckDropEventHandler {


    @SubscribeEvent
    public void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {

        EntityPlayer player = event.getHarvester();

        if (player == null) {
            return;
        }

        ItemStack tool = player.getHeldItemMainhand();

        if (!ToolItemHelper.isModularTool(tool)) {
            return;
        }

        int fortuneLevel = LuckCalculator.getFortuneLevel(tool);

        if (fortuneLevel <= 0) {
            return;
        }

        event.getDrops().clear();

        event.getDrops().addAll(
                event.getState().getBlock().getDrops(
                        event.getWorld(),
                        event.getPos(),
                        event.getState(),
                        fortuneLevel
                )
        );
    }

    @SubscribeEvent
    public void onLootingLevel(LootingLevelEvent event) {

        EntityPlayer player = event.getDamageSource().getTrueSource() instanceof EntityPlayer
                ? (EntityPlayer) event.getDamageSource().getTrueSource()
                : null;

        if (player == null) {
            return;
        }

        ItemStack tool = player.getHeldItemMainhand();

        if (!ToolItemHelper.isModularTool(tool)) {
            return;
        }

        int lootingLevel = LuckCalculator.getLootingLevel(tool);

        if (lootingLevel <= 0) {
            return;
        }

        event.setLootingLevel(event.getLootingLevel() + lootingLevel);
    }
}
