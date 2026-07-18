package com.SprintXXL.primitivetoolworks.feature.tools.items.parts;

import com.SprintXXL.primitivetoolworks.feature.tools.util.parts.PartStackFactory;
import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.logic.PartCalculator;
import com.SprintXXL.primitivetoolworks.library.parts.logic.PartValidation;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemPart extends Item {

    public ItemPart(String name) {

        setRegistryName(MODID, name);
        setTranslationKey(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        String partType = PartNBT.getPartType(stack);
        String materialID = PartNBT.getMaterial(stack);

        Part part = PartRegistry.getPart(partType);
        Material material = MaterialRegistry.getMaterial(materialID);

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

        for (Material material : MaterialRegistry.getAllMaterials()) {
            for (Part part : PartRegistry.getAllParts()) {
                if (PartValidation.isValidMaterialPartCombo(material.getID(), part.getID())) {
                    subItems.add(PartStackFactory.createDefaultPart(
                            material.getID(),
                            part.getID(),
                            part.getPartGroup()
                    ));
                }
            }
        }
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
