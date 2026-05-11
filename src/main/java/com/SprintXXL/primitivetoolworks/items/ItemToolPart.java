package com.SprintXXL.primitivetoolworks.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemToolPart extends Item {

    public ItemToolPart(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
