package com.SprintXXL.primitivetoolworks.common.blocks;

import com.SprintXXL.primitivetoolworks.PrimitiveToolworks;
import com.SprintXXL.primitivetoolworks.common.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class BlockToolStation extends Block {

    public BlockToolStation() {
        super(Material.WOOD);

        setRegistryName(MODID, "tool_station");
        setUnlocalizedName(MODID + ".tool_station");

        setHardness(2.5F);
        setResistance(5.0F);
        setCreativeTab(CreativeTabs.DECORATIONS);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
                                    EntityPlayer playerIn, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {
            playerIn.openGui(
                    PrimitiveToolworks.INSTANCE,
                    GuiHandler.TOOL_STATION,
                    worldIn,
                    pos.getX(),
                    pos.getY(),
                    pos.getZ()
            );
        }

        return true;
    }
}
