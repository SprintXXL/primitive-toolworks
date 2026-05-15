package com.SprintXXL.primitivetoolworks.client.rendering.common;

import com.SprintXXL.primitivetoolworks.client.rendering.part.ModelToolPart;
import com.SprintXXL.primitivetoolworks.client.rendering.pattern.ModelPartPattern;
import com.SprintXXL.primitivetoolworks.client.rendering.tool.ModelModularTool;
import com.SprintXXL.primitivetoolworks.init.ModItems;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
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
    public static void onTextureStitch(TextureStitchEvent.Pre event) {

        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "tool_layers/pickaxe/0_handle/wood")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "tool_layers/pickaxe/1_main/flint")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "parts/main/pickaxe_head/flint")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "parts/extra/binding/bone")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "parts/handle/handle/wood")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "patterns/pickaxe_head")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "patterns/binding")
        );
        event.getMap().registerSprite(
                new ResourceLocation("primitivetoolworks", "patterns/handle")
        );
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

        ModelResourceLocation pickaxeLocation = new ModelResourceLocation(
                "primitivetoolworks:modular_pickaxe",
                "inventory"
        );
        ModelResourceLocation toolPartLocation = new ModelResourceLocation(
                "primitivetoolworks:tool_part",
                "inventory"
        );
        ModelResourceLocation partPatternLocation = new ModelResourceLocation(
                "primitivetoolworks:part_pattern",
                "inventory"
        );

        IBakedModel originalModel = event.getModelRegistry().getObject(pickaxeLocation);
        IBakedModel baseModel = event.getModelRegistry().getObject(toolPartLocation);
        IBakedModel patternModel = event.getModelRegistry().getObject(partPatternLocation);

        if (originalModel == null || baseModel == null || patternModel == null) {
            return;
        }

        event.getModelRegistry().putObject(
                pickaxeLocation,
                new ModelModularTool(originalModel, null)
        );
        event.getModelRegistry().putObject(
                toolPartLocation,
                new ModelToolPart(baseModel, null)
        );
        event.getModelRegistry().putObject(
                partPatternLocation,
                new ModelPartPattern(patternModel, null)
        );
    }
}
