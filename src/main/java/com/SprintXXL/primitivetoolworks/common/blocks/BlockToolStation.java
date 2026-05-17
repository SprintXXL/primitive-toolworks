package com.SprintXXL.primitivetoolworks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

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
}
