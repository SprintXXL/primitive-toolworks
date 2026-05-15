package com.SprintXXL.primitivetoolworks.common.patterns;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemBlankPattern extends Item {

    public ItemBlankPattern() {

        setRegistryName(MODID, "blank_pattern");
        setUnlocalizedName(MODID + ".blank_pattern");
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
