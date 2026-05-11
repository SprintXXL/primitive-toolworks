package com.SprintXXL.primitivetoolworks.items;

import com.SprintXXL.primitivetoolworks.tools.ToolNBT;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemModularPickaxe extends Item {

    public ItemModularPickaxe(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        String head = ToolNBT.getHeadMaterial(stack);

        String handle = ToolNBT.getHandleMaterial(stack);

        tooltip.add("Head: " + head);
        tooltip.add("Handle: " + handle);


    }
}
