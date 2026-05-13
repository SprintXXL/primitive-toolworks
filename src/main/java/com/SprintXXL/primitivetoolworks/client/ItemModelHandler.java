package com.SprintXXL.primitivetoolworks.client;

import com.SprintXXL.primitivetoolworks.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ItemModelHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        ModelLoader.setCustomModelResourceLocation(
                ModItems.BLANK_PATTERN,
                0,
                new ModelResourceLocation(ModItems.BLANK_PATTERN.getRegistryName(), "inventory")
        );
    }
}
