package com.SprintXXL.primitivetoolworks.common.container.stations.wrappers;

import com.SprintXXL.primitivetoolworks.common.container.stations.ToolStationTier;
import com.SprintXXL.primitivetoolworks.common.container.stations.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolForge extends ContainerToolWorkbench {

    public ContainerToolForge(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_FORGE);
    }
}