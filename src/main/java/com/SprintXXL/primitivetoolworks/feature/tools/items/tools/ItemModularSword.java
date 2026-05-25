package com.SprintXXL.primitivetoolworks.feature.tools.items.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipBuilder;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolAttributeHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDisplayNameHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolStackFactory;
import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDummyMaterial.DUMMY_MATERIAL;
import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemModularSword extends ItemSword {

    private static final ToolType toolType = ToolType.SWORD;

    public ItemModularSword(String name) {
        super(DUMMY_MATERIAL);

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return ToolDisplayNameHelper.getDisplayName(stack, toolType, "Sword");
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        TooltipBuilder.forType(toolType).addToTooltip(stack, tooltip);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        items.add(ToolStackFactory.createDefaultTool(this, ToolType.SWORD));
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        return ToolAttributeHelper.getToolAttributeModifiers(
                super.getItemAttributeModifiers(slot),
                slot,
                stack,
                ATTACK_DAMAGE_MODIFIER,
                ATTACK_SPEED_MODIFIER
        );
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return ToolCalculator.getDurability(stack);
    }
}
