package com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.container;

import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.containers.ContainerToolWorkbench;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerToolForge extends ContainerToolWorkbench {

    public ContainerToolForge(InventoryPlayer playerInventory) {
        super(playerInventory, ToolStationTier.TOOL_FORGE);
    }
}