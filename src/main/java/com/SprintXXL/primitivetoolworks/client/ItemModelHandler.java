package com.SprintXXL.primitivetoolworks.client;

import com.SprintXXL.primitivetoolworks.client.rendering.part.ModelToolPart;
import com.SprintXXL.primitivetoolworks.client.rendering.part.PartRenderData;
import com.SprintXXL.primitivetoolworks.client.rendering.part.PartTextureResolver;
import com.SprintXXL.primitivetoolworks.client.rendering.pattern.ModelPartPattern;
import com.SprintXXL.primitivetoolworks.client.rendering.pattern.PatternRenderData;
import com.SprintXXL.primitivetoolworks.client.rendering.pattern.PatternTextureResolver;
import com.SprintXXL.primitivetoolworks.client.rendering.tool.ModelModularTool;
import com.SprintXXL.primitivetoolworks.client.rendering.tool.ToolLayerRenderData;
import com.SprintXXL.primitivetoolworks.client.rendering.tool.ToolTextureResolver;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialDefinition;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.PartDefinition;
import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.ToolType;
import com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternRegistry;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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

        // Tool Layer Stitching \\
        for (ToolType toolType : ToolType.values()) {

            for (PartDefinition part : PartRegistry.getAllParts()) {

                for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {

                    String materialID = material.getMaterialID();
                    String partID = part.getPartID();

                    if(!PartValidation.isValidMaterialPartCombo(materialID, partID)) {
                        continue;
                    }

                    if (part.getGroup() != PartGroup.MAIN &&
                    part.getGroup() != PartGroup.HANDLE) {
                        continue;
                    }

                    ToolLayerRenderData toolData = new ToolLayerRenderData(
                            toolType,
                            part.getGroup(),
                            materialID
                    );

                    event.getMap().registerSprite(
                            ToolTextureResolver.getToolLayerTexture(toolData)
                    );
                }
            }
        }

        // Part Stitching \\
        for (PartDefinition part : PartRegistry.getAllParts()) {

            for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {

                String materialID = material.getMaterialID();
                String partID = part.getPartID();

                if (!PartValidation.isValidMaterialPartCombo(materialID, partID)) {
                    continue;
                }

                PartRenderData partData = new PartRenderData(
                        materialID,
                        partID,
                        part.getGroup()
                );

                event.getMap().registerSprite(
                        PartTextureResolver.getPartTexture(partData)
                );
            }
        }

        // Pattern Stitching \\
        for (String patternID : PatternRegistry.getAllPatterns()) {

            PatternRenderData patternData =
                    new PatternRenderData(patternID);

            event.getMap().registerSprite(
                    PatternTextureResolver.getPatternTexture(patternData)
            );
        }
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

        IBakedModel toolModel = event.getModelRegistry().getObject(pickaxeLocation);
        IBakedModel baseModel = event.getModelRegistry().getObject(toolPartLocation);
        IBakedModel patternModel = event.getModelRegistry().getObject(partPatternLocation);

        if (toolModel == null || baseModel == null || patternModel == null) {
            return;
        }

        event.getModelRegistry().putObject(
                pickaxeLocation,
                new ModelModularTool(toolModel, null)
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
