package com.SprintXXL.primitivetoolworks.feature.tools.features.aoe;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class AoeEventHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        EntityPlayer player = event.getPlayer();

        World world = player.world;

        ItemStack heldStack = player.getHeldItemMainhand();

        if (heldStack.isEmpty()) {
            return;
        }

        if (!(heldStack.getItem() instanceof IAoeTool)) {
            return;
        }

        BlockPos center = event.getPos();

        RayTraceResult rayTrace = player.rayTrace(5.0D, 1.0F);

        if (rayTrace == null || rayTrace.sideHit == null) {
            return;
        }

        EnumFacing side = rayTrace.sideHit;

        AoeMiningHandler.mineAoe(world, player, heldStack, center, side);
    }
}
