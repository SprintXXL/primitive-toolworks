package com.SprintXXL.primitivetoolworks.feature.tools.items.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.TooltipBuilder;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolAttributeHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDisplayNameHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolStackFactory;
import com.SprintXXL.primitivetoolworks.feature.tools.logic.ToolCalculator;
import com.SprintXXL.primitivetoolworks.feature.tools.features.aoe.AoeProfile;
import com.SprintXXL.primitivetoolworks.feature.tools.features.aoe.IAoeTool;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDamageHelper;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.google.common.collect.Multimap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDamageHelper.isBroken;
import static com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolDummyMaterial.DUMMY_MATERIAL;
import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemModularHammer extends ItemPickaxe implements IAoeTool {

    private static final ToolType toolType = ToolType.HAMMER;

    public ItemModularHammer(String name) {
        super(DUMMY_MATERIAL);

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return ToolDisplayNameHelper.getDisplayName(stack, toolType, "Hammer");
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

        items.add(ToolStackFactory.createDefaultTool(this, ToolType.HAMMER));
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

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, ToolDamageHelper.clampDamage(stack, damage));
    }

    @Override
    public AoeProfile getAoeProfile(ItemStack stack) {
        return AoeProfile.threeByThree();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        float vanillaSpeed = super.getDestroySpeed(stack, state);

        if (vanillaSpeed <= 1) {
            return 1;
        }

        if (isBroken(stack)) {
            return 0.01F;
        }

        return ToolCalculator.getMiningSpeed(stack);
    }
}
