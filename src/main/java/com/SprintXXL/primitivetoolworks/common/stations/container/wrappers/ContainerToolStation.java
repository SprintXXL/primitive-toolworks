package com.SprintXXL.primitivetoolworks.common.stations.container.wrappers;

import com.SprintXXL.primitivetoolworks.common.stations.ToolStationTier;
import com.SprintXXL.primitivetoolworks.common.stations.container.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolStation extends ContainerToolWorkbench {

    public ContainerToolStation(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_STATION);
    }
}