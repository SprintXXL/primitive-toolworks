package com.SprintXXL.primitivetoolworks.common.tools.aoe;

import com.SprintXXL.primitivetoolworks.common.tools.ToolCalculator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class AoeMiningHandler {

    private static boolean isMiningAoe = false;

    public static void mineAoe(World world, EntityPlayer player, ItemStack tool, BlockPos center, EnumFacing side) {

        if (isMiningAoe) {
            return;
        }

        isMiningAoe = true;

        try {
            if (world.isRemote) {
                return;
            }

            if (tool.isEmpty()) {
                return;
            }

            if (!(tool.getItem() instanceof IAoeTool)) {
                return;
            }

            if (player.isSneaking()) {
                return;
            }

            IAoeTool aoeTool = (IAoeTool) tool.getItem();
            AoeProfile profile = aoeTool.getAoeProfile(tool);

            List<BlockPos> positions = AoeBlockFinder.findBlocks(center, side, profile);

            int blocksMined = 0;

            int remainingDurability = tool.getMaxDamage() - tool.getItemDamage();
            int availableAoeBlocks = remainingDurability - 1;

            if (availableAoeBlocks <= 0) {
                return;
            }

            for (BlockPos pos : positions) {

                if (blocksMined >= availableAoeBlocks) {
                    break;
                }

                IBlockState state = world.getBlockState(pos);

                if (!canMineExtraBlock(world, pos, state, tool)) {
                    continue;
                }

                Block block = state.getBlock();
                block.dropBlockAsItem(world, pos, state, 0);
                world.setBlockToAir(pos);

                blocksMined++;
        }

            if (blocksMined > 0) {
                tool.damageItem(blocksMined, player);
            }
        } finally {
            isMiningAoe = false;
        }
    }

    private static boolean canHarvestExtraBlock(ItemStack tool, IBlockState state) {

        int toolHarvestLevel = ToolCalculator.getHarvestLevel(tool);
        int blockHarvestLevel = state.getBlock().getHarvestLevel(state);

        if (blockHarvestLevel < 0) {
            return true;
        }

        return toolHarvestLevel >= blockHarvestLevel;
    }

    private static boolean canMineExtraBlock(World world, BlockPos pos, IBlockState state, ItemStack tool) {

        if (state.getBlock().isAir(state, world, pos)) {
            return false;
        }

        if (state.getBlockHardness(world, pos) < 0) {
            return false;
        }

        if (!canHarvestExtraBlock(tool, state)) {
            return false;
        }

        return true;
    }
}
