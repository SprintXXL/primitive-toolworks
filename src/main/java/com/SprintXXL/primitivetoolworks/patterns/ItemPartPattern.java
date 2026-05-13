package com.SprintXXL.primitivetoolworks.patterns;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemPartPattern extends Item {

    public ItemPartPattern(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String patternType = PatternNBT.getPatternType(stack);

        if (patternType.equals(PatternIDs.PICKAXE_HEAD)) {
            return "Pickaxe Head Pattern";
        }
        if (patternType.equals(PatternIDs.HANDLE)) {
            return "Handle Pattern";
        }

        return "Part Pattern";
    }
}
