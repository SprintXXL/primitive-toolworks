package com.SprintXXL.primitivetoolworks.common.stations.container.wrappers;

import com.SprintXXL.primitivetoolworks.common.stations.ToolStationTier;
import com.SprintXXL.primitivetoolworks.common.stations.container.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolForge extends ContainerToolWorkbench {

    public ContainerToolForge(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_FORGE);
    }
}