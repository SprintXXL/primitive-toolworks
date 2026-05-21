package com.SprintXXL.primitivetoolworks.common.patterns.items;

import com.SprintXXL.primitivetoolworks.common.patterns.defaults.PatternDefaults;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternIDs;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternNBT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemPattern extends Item {

    public ItemPattern(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String patternType = PatternNBT.getPatternType(stack);

        if (patternType.equals(PatternIDs.SWORD_BLADE)) {
            return "Sword Blade Pattern";
        }
        if (patternType.equals(PatternIDs.PICKAXE_HEAD)) {
            return "Pickaxe Head Pattern";
        }
        if (patternType.equals(PatternIDs.AXE_HEAD)) {
            return "Axe Head Pattern";
        }
        if (patternType.equals(PatternIDs.SHOVEL_HEAD)) {
            return "Shovel Head Pattern";
        }
        if (patternType.equals(PatternIDs.HOE_HEAD)) {
            return "Hoe Head Pattern";
        }
        if (patternType.equals(PatternIDs.HAMMER_HEAD)) {
            return "Hammer Head Pattern";
        }

        if (patternType.equals(PatternIDs.BINDING)) {
            return "Binding Pattern";
        }
        if (patternType.equals(PatternIDs.TOUGH_BINDING)) {
            return "Tough Binding Pattern";
        }
        if (patternType.equals(PatternIDs.WIDE_GUARD)) {
            return "Wide Guard Pattern";
        }

        // Handle Patterns \\
        if (patternType.equals(PatternIDs.HANDLE)) {
            return "Handle Pattern";
        }
        if (patternType.equals(PatternIDs.TOUGH_HANDLE)) {
            return "Tough Handle Pattern";
        }

        return "Part Pattern";
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        // Main Patterns \\
        subItems.add(PatternDefaults.createPattern(PatternIDs.SWORD_BLADE));
        subItems.add(PatternDefaults.createPattern(PatternIDs.PICKAXE_HEAD));
        subItems.add(PatternDefaults.createPattern(PatternIDs.AXE_HEAD));
        subItems.add(PatternDefaults.createPattern(PatternIDs.SHOVEL_HEAD));
        subItems.add(PatternDefaults.createPattern(PatternIDs.HOE_HEAD));
        subItems.add(PatternDefaults.createPattern(PatternIDs.HAMMER_HEAD));

        // Extra Patterns \\
        subItems.add(PatternDefaults.createPattern(PatternIDs.BINDING));
        subItems.add(PatternDefaults.createPattern(PatternIDs.TOUGH_BINDING));
        subItems.add(PatternDefaults.createPattern(PatternIDs.WIDE_GUARD));

        // Handle Patterns \\
        subItems.add(PatternDefaults.createPattern(PatternIDs.HANDLE));
        subItems.add(PatternDefaults.createPattern(PatternIDs.TOUGH_HANDLE));

    }
}
