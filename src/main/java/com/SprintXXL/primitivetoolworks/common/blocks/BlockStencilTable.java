package com.SprintXXL.primitivetoolworks.common.blocks;

import com.SprintXXL.primitivetoolworks.PrimitiveToolworks;
import com.SprintXXL.primitivetoolworks.client.gui.GuiHandler;
import com.SprintXXL.primitivetoolworks.common.tileentity.TileEntityStencilTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class BlockStencilTable extends Block {

    public BlockStencilTable() {
        super(Material.WOOD);

        setRegistryName(MODID, "stencil_table");
        setUnlocalizedName(MODID + ".stencil_table");

        setHardness(2.5F);
        setResistance(5.0F);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
                                    EntityPlayer playerIn, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {
            playerIn.openGui(
                    PrimitiveToolworks.INSTANCE,
                    GuiHandler.STENCIL_TABLE,
                    worldIn,
                    pos.getX(),
                    pos.getY(),
                    pos.getZ()
            );
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityStencilTable();
    }

}
