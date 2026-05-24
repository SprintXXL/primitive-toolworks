package com.SprintXXL.primitivetoolworks.common.gui;

import com.SprintXXL.primitivetoolworks.client.stations.gui.GuiPartBuilder;
import com.SprintXXL.primitivetoolworks.client.stations.gui.GuiStencilTable;
import com.SprintXXL.primitivetoolworks.client.stations.gui.wrappers.GuiToolForge;
import com.SprintXXL.primitivetoolworks.client.stations.gui.wrappers.GuiToolStation;
import com.SprintXXL.primitivetoolworks.common.stations.container.part_builder.ContainerPartBuilder;
import com.SprintXXL.primitivetoolworks.common.stations.container.stations.wrappers.ContainerToolForge;
import com.SprintXXL.primitivetoolworks.common.stations.container.stations.wrappers.ContainerToolStation;
import com.SprintXXL.primitivetoolworks.common.stations.container.stencil_table.ContainerStencilTable;
import com.SprintXXL.primitivetoolworks.common.stations.tileentity.TileEntityPartBuilder;
import com.SprintXXL.primitivetoolworks.common.stations.tileentity.TileEntityStencilTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int TOOL_STATION = 0;
    public static final int PART_BUILDER = 1;
    public static final int STENCIL_TABLE = 2;
    public static final int TOOL_FORGE = 3;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID) {
            case TOOL_STATION:
                return new ContainerToolStation(player.inventory);
            case PART_BUILDER:
                if (tile instanceof TileEntityPartBuilder) {
                    return new ContainerPartBuilder(player.inventory, (TileEntityPartBuilder) tile);
                }
                break;
            case STENCIL_TABLE:
                if (tile instanceof TileEntityStencilTable) {
                    return new ContainerStencilTable(player.inventory, (TileEntityStencilTable) tile);
                }
                break;
            case TOOL_FORGE:
                return new ContainerToolForge(player.inventory);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID) {
            case TOOL_STATION:
                return new GuiToolStation(new ContainerToolStation(player.inventory));
            case PART_BUILDER:
                if (tile instanceof TileEntityPartBuilder) {
                    return new GuiPartBuilder(new ContainerPartBuilder(player.inventory, (TileEntityPartBuilder) tile));
                }
                break;
            case STENCIL_TABLE:
                if (tile instanceof TileEntityStencilTable) {
                    return new GuiStencilTable(new ContainerStencilTable(player.inventory, (TileEntityStencilTable) tile));
                }
                break;
            case TOOL_FORGE:
                return new GuiToolForge(new ContainerToolForge(player.inventory));
        }
        return null;
    }
}