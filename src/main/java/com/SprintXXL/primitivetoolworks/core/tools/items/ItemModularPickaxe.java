package com.SprintXXL.primitivetoolworks.core.tools.items;

import com.SprintXXL.primitivetoolworks.core.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.core.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.core.tools.ToolCalculator;
import com.SprintXXL.primitivetoolworks.core.tools.ToolDefaults;
import com.SprintXXL.primitivetoolworks.core.tools.ToolNBT;
import com.SprintXXL.primitivetoolworks.core.tools.types.ToolType;
import com.google.common.collect.Multimap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitivetoolworks.core.tools.helpers.DummyMaterial.DUMMY_MATERIAL;
import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class ItemModularPickaxe extends ItemPickaxe {

    private static final ToolType toolType = ToolType.PICKAXE;

    public ItemModularPickaxe(String name) {
        super(DUMMY_MATERIAL);

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        float vanillaSpeed = super.getDestroySpeed(stack, state);

        if (vanillaSpeed <= 1) {
            return 1;
        }
        return ToolCalculator.getMiningSpeed(stack);
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, EntityPlayer player, IBlockState blockState) {
        return ToolCalculator.getHarvestLevel(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return ToolCalculator.getDurability(stack);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> modifiers =
                super.getItemAttributeModifiers(slot);

        if (slot == EntityEquipmentSlot.MAINHAND) {

            modifiers.removeAll(
                    SharedMonsterAttributes.ATTACK_DAMAGE.getName()
            );

            modifiers.removeAll(
                    SharedMonsterAttributes.ATTACK_SPEED.getName()
            );

            modifiers.put(
                    SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(
                            ATTACK_DAMAGE_MODIFIER,
                            "Tool Modifier",
                            ToolCalculator.getAttackDamage(stack),
                            0
                    )
            );

            modifiers.put(
                    SharedMonsterAttributes.ATTACK_SPEED.getName(),
                    new AttributeModifier(
                            ATTACK_SPEED_MODIFIER,
                            "Tool Modifier",
                            ToolCalculator.getAttackSpeed(stack),
                            0
                    )
            );
        }

        return modifiers;
    }

    // Item Display Name
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));

        ToolType toolType = ToolNBT.getToolType(stack);

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.getDefaultMainMaterial(toolType));
        }

        if (mainMaterial == null) {
            return "Modular Pickaxe";
        }

        return mainMaterial.getTitleDisplayName() + " Pickaxe";
    }

    // Tooltip
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        MaterialDefinition mainMaterial = MaterialRegistry.getMaterial(ToolNBT.getMainMaterial(stack));
        MaterialDefinition extraMaterial = MaterialRegistry.getMaterial(ToolNBT.getExtraMaterial(stack));
        MaterialDefinition handleMaterial = MaterialRegistry.getMaterial(ToolNBT.getHandleMaterial(stack));
        int maxDurability = ToolCalculator.getDurability(stack);
        int usedDurability = stack.getItemDamage();
        int remainingDurability = maxDurability - usedDurability;
        int harvestLevel = ToolCalculator.getHarvestLevel(stack);
        float miningSpeed = ToolCalculator.getMiningSpeed(stack);

        if (mainMaterial == null) {
            mainMaterial = MaterialRegistry.getMaterial(ToolDefaults.getDefaultMainMaterial(toolType));
        }

        if (mainMaterial == null) {
            tooltip.add("Unknown");
        }

        if (extraMaterial == null) {
            extraMaterial = MaterialRegistry.getMaterial(ToolDefaults.getDefaultExtraMaterial(toolType));
        }

        if (extraMaterial == null) {
            tooltip.add("Unknown");
        }

        if (handleMaterial == null) {
            handleMaterial = MaterialRegistry.getMaterial(ToolDefaults.getDefaultHandleMaterial(toolType));
        }

        if (handleMaterial == null) {
            tooltip.add("Unknown");
        }

        tooltip.add("");
        tooltip.add("Main Material: " + mainMaterial.getFormattedDisplayName());
        tooltip.add("Extra Material: " + extraMaterial.getFormattedDisplayName());
        tooltip.add("Handle Material: " + handleMaterial.getFormattedDisplayName());
        tooltip.add("");
        tooltip.add("Mining Speed: " + TextFormatting.WHITE + miningSpeed);
        tooltip.add("Harvest Level: " + TextFormatting.WHITE + harvestLevel);
        tooltip.add("Durability: " + TextFormatting.WHITE + remainingDurability + " / " + maxDurability);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        ItemStack stack = new ItemStack(this);

        ToolNBT.setToolType(stack, toolType);

        ToolNBT.setMainMaterial(stack, ToolDefaults.getDefaultMainMaterial(toolType));
        ToolNBT.setMainPart(stack, ToolDefaults.getDefaultMainPart(toolType));

        ToolNBT.setExtraMaterial(stack, ToolDefaults.getDefaultExtraMaterial(toolType));
        ToolNBT.setExtraPart(stack, ToolDefaults.getDefaultExtraPart(toolType));

        ToolNBT.setHandleMaterial(stack, ToolDefaults.getDefaultHandleMaterial(toolType));
        ToolNBT.setHandlePart(stack, ToolDefaults.getDefaultHandlePart(toolType));

        items.add(stack);
    }
}
