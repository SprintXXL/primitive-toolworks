package com.SprintXXL.primitivetoolworks.client.handler;

import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.gui.GuiPartBuilder;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.gui.GuiStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.gui.GuiToolForge;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.gui.GuiToolStation;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.containers.ContainerPartBuilder;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.container.ContainerToolForge;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.wrappers.container.ContainerToolStation;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.tileentities.TileEntityPartBuilder;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.tileentities.TileEntityStencilTable;
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