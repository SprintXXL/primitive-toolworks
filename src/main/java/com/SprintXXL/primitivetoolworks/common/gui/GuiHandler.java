package com.SprintXXL.primitivetoolworks.common.gui;

import com.SprintXXL.primitivetoolworks.client.gui.GuiToolStation;
import com.SprintXXL.primitivetoolworks.common.container.ContainerToolStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int TOOL_STATION = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == TOOL_STATION) {

            return new ContainerToolStation();
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == TOOL_STATION) {

            return new GuiToolStation(new ContainerToolStation());
        }

        return null;
    }
}
