package com.SprintXXL.primitivetoolworks.parts;

import com.SprintXXL.primitivetoolworks.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.materials.MaterialRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class ItemToolPart extends Item {

    public ItemToolPart(String name) {

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

        String partName = part.getTitle();
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

        subItems.add(PartDefaults.createDefaultPickaxeHead());
        subItems.add(PartDefaults.createDefaultBinding());
        subItems.add(PartDefaults.createDefaultHandle());

    }
}
