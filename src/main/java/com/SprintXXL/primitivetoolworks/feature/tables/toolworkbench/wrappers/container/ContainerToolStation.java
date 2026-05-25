package com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.container;

import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.containers.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolStation extends ContainerToolWorkbench {

    public ContainerToolStation(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_STATION);
    }
}