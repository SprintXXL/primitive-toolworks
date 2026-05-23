package com.SprintXXL.primitivetoolworks.common.registry;

import com.SprintXXL.primitivetoolworks.common.parts.items.ItemPart;
import com.SprintXXL.primitivetoolworks.common.patterns.items.ItemBlankPattern;
import com.SprintXXL.primitivetoolworks.common.patterns.items.ItemPattern;
import com.SprintXXL.primitivetoolworks.common.tools.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    // Patterns
    public static final Item BLANK_PATTERN = new ItemBlankPattern();
    public static final Item PATTERN = new ItemPattern("patterns");

    // Parts
    public static final Item PART = new ItemPart("part");

    // Tools
    public static final Item MODULAR_SWORD = new ItemModularSword("modular_sword");
    public static final Item MODULAR_PICKAXE = new ItemModularPickaxe("modular_pickaxe");
    public static final Item MODULAR_AXE = new ItemModularAxe("modular_axe");
    public static final Item MODULAR_SHOVEL = new ItemModularShovel("modular_shovel");
    public static final Item MODULAR_HOE = new ItemModularHoe("modular_hoe");
    public static final Item MODULAR_HAMMER = new ItemModularHammer("modular_hammer");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                BLANK_PATTERN,
                PATTERN,
                PART,
                MODULAR_SWORD,
                MODULAR_PICKAXE,
                MODULAR_AXE,
                MODULAR_SHOVEL,
                MODULAR_HOE,
                MODULAR_HAMMER
        );

        event.getRegistry().register(
                new ItemBlock(ModBlocks.TOOL_STATION)
                        .setRegistryName(ModBlocks.TOOL_STATION.getRegistryName())
        );
        event.getRegistry().register(
                new ItemBlock(ModBlocks.PART_BUILDER)
                        .setRegistryName(ModBlocks.PART_BUILDER.getRegistryName())
        );
        event.getRegistry().register(
                new ItemBlock(ModBlocks.STENCIL_TABLE)
                        .setRegistryName(ModBlocks.STENCIL_TABLE.getRegistryName())
        );
        event.getRegistry().register(
                new ItemBlock(ModBlocks.TOOL_FORGE)
                        .setRegistryName(ModBlocks.TOOL_FORGE.getRegistryName())
        );
    }
}
