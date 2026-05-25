package com.SprintXXL.primitivetoolworks.feature.tools.features.aoe;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class AoeBlockFinder {

    public static List<BlockPos> findBlocks(BlockPos center, EnumFacing side, AoeProfile profile) {

        List<BlockPos> positions = new ArrayList<>();

        int radius = profile.getRadius();

        for (int a = -radius; a <= radius; a++) {
            for (int b = -radius; b <= radius; b++) {

                if (a == 0 && b == 0) {
                    continue;
                }

                BlockPos offsetPos;

                if (side == EnumFacing.UP || side == EnumFacing.DOWN) {
                    offsetPos = center.add(a, 0, b);
                }
                else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH) {
                    offsetPos = center.add(a, b, 0);
                }
                else {
                    offsetPos = center.add(0, b, a);
                }

                positions.add(offsetPos);
            }
        }

        return positions;
    }
}
