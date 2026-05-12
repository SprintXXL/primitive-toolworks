package com.SprintXXL.primitivetoolworks.items;

import com.SprintXXL.primitivetoolworks.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.parts.PartNBT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemToolPart extends Item {

    public ItemToolPart(String name, String MaterialID, String PartID) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
