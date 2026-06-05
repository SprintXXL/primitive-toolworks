package com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemBlankPattern extends Item {

    public ItemBlankPattern() {

        setRegistryName(MODID, "blank_pattern");
        setTranslationKey(MODID + ".blank_pattern");
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
