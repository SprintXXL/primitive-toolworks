package com.SprintXXL.primitivetoolworks.items;

import com.SprintXXL.primitivetoolworks.tools.ToolCalculator;
import com.SprintXXL.primitivetoolworks.tools.ToolNBT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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

        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        String main = ToolNBT.getMainMaterial(stack);

        tooltip.add("Material: " + main);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return ToolCalculator.getMiningSpeed(stack);
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, EntityPlayer player, IBlockState blockState) {
        return ToolCalculator.getHarvestLevel(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return ToolCalculator.getDurability(stack);
    }
}
