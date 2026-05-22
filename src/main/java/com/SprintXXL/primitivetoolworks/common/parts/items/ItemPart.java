package com.SprintXXL.primitivetoolworks.common.parts.items;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.*;
import com.SprintXXL.primitivetoolworks.common.parts.helpers.PartCalculator;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.common.parts.defaults.PartDefaults.createDefaultPart;
import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemPart extends Item {

    public ItemPart(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        String partType = PartNBT.getPartType(stack);
        String materialID = PartNBT.getMaterial(stack);

        PartDefinition part = PartRegistry.getPart(partType);
        MaterialDefinition material = MaterialRegistry.getMaterial(materialID);

        if (part == null || material == null) {
            return "Tool Part";
        }

        String partName = part.getPartTitle();
        String materialName = material.getTitleDisplayName();

        if (partName == null || materialName == null) {
            return "Tool Part";
        }
        return materialName + " " + partName;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        // Main Parts \\
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.SWORD_BLADE,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.PICKAXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.AXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.SHOVEL_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.HOE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.FLINT,
                PartIDs.HAMMER_HEAD,
                PartGroup.MAIN
        ));

        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.SWORD_BLADE,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.PICKAXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.AXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.SHOVEL_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.HOE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.IRON,
                PartIDs.HAMMER_HEAD,
                PartGroup.MAIN
        ));

        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.SWORD_BLADE,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.PICKAXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.AXE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.SHOVEL_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.HOE_HEAD,
                PartGroup.MAIN
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BRONZE,
                PartIDs.HAMMER_HEAD,
                PartGroup.MAIN
        ));


        // Extra Parts \\
        subItems.add(createDefaultPart(
                MaterialIDs.BONE,
                PartIDs.BINDING,
                PartGroup.EXTRA
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BONE,
                PartIDs.TOUGH_BINDING,
                PartGroup.EXTRA
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.BONE,
                PartIDs.WIDE_GUARD,
                PartGroup.EXTRA
        ));

        // Handle Parts \\
        subItems.add(createDefaultPart(
                MaterialIDs.WOOD,
                PartIDs.HANDLE,
                PartGroup.HANDLE
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.OBSIDIAN,
                PartIDs.HANDLE,
                PartGroup.HANDLE
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.WOOD,
                PartIDs.TOUGH_HANDLE,
                PartGroup.HANDLE
        ));
        subItems.add(createDefaultPart(
                MaterialIDs.OBSIDIAN,
                PartIDs.TOUGH_HANDLE,
                PartGroup.HANDLE
        ));


    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        int durability = PartCalculator.getPartDurability(stack);

        if (durability != 0) {
            tooltip.add("+" + durability + " Durability");
        }

        float miningSpeed = PartCalculator.getPartMiningSpeed(stack);

        if (miningSpeed != 0) {
            tooltip.add("+" + miningSpeed + " Mining Speed");
        }
    }
}
