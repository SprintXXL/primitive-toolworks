package com.SprintXXL.primitivetoolworks.client;

import com.SprintXXL.primitivetoolworks.client.rendering.ModelModularTool;
import com.SprintXXL.primitivetoolworks.init.ModItems;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
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
        ModelLoader.setCustomModelResourceLocation(
                ModItems.PART_PATTERN,
                0,
                new ModelResourceLocation(ModItems.PART_PATTERN.getRegistryName(), "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.TOOL_PART,
                0,
                new ModelResourceLocation(ModItems.TOOL_PART.getRegistryName(), "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_PICKAXE,
                0,
                new ModelResourceLocation(ModItems.MODULAR_PICKAXE.getRegistryName(), "inventory")
        );
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

        ModelResourceLocation location = new ModelResourceLocation(
                "primitivetoolworks:modular_pickaxe",
                "inventory"
        );

        System.out.println("ModelBakeEvent Fired");

        IBakedModel originalModel = event.getModelRegistry().getObject(location);

        System.out.println("Original Model: " + originalModel);

        if (originalModel == null) {
            return;
        }

        event.getModelRegistry().putObject(
                location,
                new ModelModularTool(originalModel)
        );
    }
}
