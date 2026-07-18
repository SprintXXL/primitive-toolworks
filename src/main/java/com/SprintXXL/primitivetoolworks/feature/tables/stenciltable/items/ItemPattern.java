package com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.items;

import com.SprintXXL.primitivetoolworks.library.patterns.Pattern;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.library.patterns.util.PatternDefaults;
import com.SprintXXL.primitivetoolworks.library.patterns.definitions.PatternIDs;
import com.SprintXXL.primitivetoolworks.library.patterns.nbt.PatternNBT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemPattern extends Item {

    public ItemPattern(String name) {

        setRegistryName(MODID, name);
        setTranslationKey(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        String patternID = PatternNBT.getPatternType(stack);

        Pattern pattern = PatternRegistry.getPattern(patternID);

        if (pattern == null) {
            return "Part Pattern";
        }

        String title = pattern.getPatternTitle();

        if (title == null) {
            return "Part Pattern";
        }

        return title + " Pattern";
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
