package com.SprintXXL.primitivetoolworks.common.stations.container.stations.wrappers;

import com.SprintXXL.primitivetoolworks.common.stations.container.stations.ToolStationTier;
import com.SprintXXL.primitivetoolworks.common.stations.container.stations.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolForge extends ContainerToolWorkbench {

    public ContainerToolForge(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_FORGE);
    }
}