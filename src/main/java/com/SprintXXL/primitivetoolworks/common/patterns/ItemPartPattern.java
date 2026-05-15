package com.SprintXXL.primitivetoolworks.common.patterns;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
        if (patternType.equals(PatternIDs.BINDING)) {
            return "Binding Pattern";
        }

        return "Part Pattern";
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        subItems.add(PatternDefaults.createDefaultPickaxeHeadPattern());
        subItems.add(PatternDefaults.createDefaultBindingPattern());
        subItems.add(PatternDefaults.createDefaultHandlePattern());

    }
}
