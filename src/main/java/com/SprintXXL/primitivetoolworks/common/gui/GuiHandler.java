package com.SprintXXL.primitivetoolworks.common.gui;

import com.SprintXXL.primitivetoolworks.client.stations.gui.wrappers.GuiToolForge;
import com.SprintXXL.primitivetoolworks.client.stations.gui.wrappers.GuiToolStation;
import com.SprintXXL.primitivetoolworks.common.stations.container.wrappers.ContainerToolForge;
import com.SprintXXL.primitivetoolworks.common.stations.container.wrappers.ContainerToolStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int TOOL_STATION = 0;
    public static final int TOOL_FORGE = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case TOOL_STATION:
                return new ContainerToolStation(player.inventory);
            case TOOL_FORGE:
                return new ContainerToolForge(player.inventory);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case TOOL_STATION:
                return new GuiToolStation(new ContainerToolStation(player.inventory));
            case TOOL_FORGE:
                return new GuiToolForge(new ContainerToolForge(player.inventory));
        }

        return null;
    }
}
