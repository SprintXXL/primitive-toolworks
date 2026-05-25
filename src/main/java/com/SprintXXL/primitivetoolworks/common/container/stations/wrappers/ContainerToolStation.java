package com.SprintXXL.primitivetoolworks.common.container.stations.wrappers;

import com.SprintXXL.primitivetoolworks.common.container.stations.ToolStationTier;
import com.SprintXXL.primitivetoolworks.common.container.stations.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolStation extends ContainerToolWorkbench {

    public ContainerToolStation(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_STATION);
    }
}