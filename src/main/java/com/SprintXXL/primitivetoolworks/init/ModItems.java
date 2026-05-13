package com.SprintXXL.primitivetoolworks.init;

import com.SprintXXL.primitivetoolworks.parts.ItemToolPart;
import com.SprintXXL.primitivetoolworks.patterns.ItemBlankPattern;
import com.SprintXXL.primitivetoolworks.patterns.ItemPartPattern;
import com.SprintXXL.primitivetoolworks.tools.ItemModularPickaxe;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    // Patterns
    public static final Item BLANK_PATTERN = new ItemBlankPattern();

    public static final Item PART_PATTERN = new ItemPartPattern("part_pattern");

    // Parts

    public static final Item TOOL_PART = new ItemToolPart("tool_part");

    // Tools
    public static final Item MODULAR_PICKAXE = new ItemModularPickaxe("modular_pickaxe");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                BLANK_PATTERN,
                PART_PATTERN,
                TOOL_PART,
                MODULAR_PICKAXE
        );
    }
}
