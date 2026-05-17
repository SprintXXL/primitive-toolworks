package com.SprintXXL.primitivetoolworks.common.registry;

import com.SprintXXL.primitivetoolworks.common.blocks.BlockToolStation;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlocks {

    public static final Block TOOL_STATION = new BlockToolStation();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                TOOL_STATION
        );
    }
}
