package com.SprintXXL.primitivetoolworks.feature.tools.items.parts;

import com.SprintXXL.primitivetoolworks.feature.tools.util.parts.PartStackFactory;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartDefinition;
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

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {
            for (PartDefinition part : PartRegistry.getAllParts()) {
                if (PartValidation.isValidMaterialPartCombo(material.getMaterialID(), part.getPartID())) {
                    subItems.add(PartStackFactory.createDefaultPart(
                            material.getMaterialID(),
                            part.getPartID(),
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
