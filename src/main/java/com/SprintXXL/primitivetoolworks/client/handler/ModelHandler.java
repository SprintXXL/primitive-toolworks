package com.SprintXXL.primitivetoolworks.client.handler;

import com.SprintXXL.primitivetoolworks.client.render.parts.ModelToolPart;
import com.SprintXXL.primitivetoolworks.client.render.parts.PartRenderData;
import com.SprintXXL.primitivetoolworks.client.render.parts.PartTextureResolver;
import com.SprintXXL.primitivetoolworks.client.render.patterns.ModelPartPattern;
import com.SprintXXL.primitivetoolworks.client.render.patterns.PatternRenderData;
import com.SprintXXL.primitivetoolworks.client.render.patterns.PatternTextureResolver;
import com.SprintXXL.primitivetoolworks.client.render.tools.ModelModularTool;
import com.SprintXXL.primitivetoolworks.client.render.tools.ToolLayerRenderData;
import com.SprintXXL.primitivetoolworks.client.render.tools.ToolTextureResolver;
import com.SprintXXL.primitivetoolworks.library.materials.Material;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.library.modifiers.Modifier;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.patterns.Pattern;
import com.SprintXXL.primitivetoolworks.library.parts.logic.PartValidation;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.common.registry.ModBlocks;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.SprintXXL.primitivetoolworks.library.tooltypes.registry.ToolTypeRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

@Mod.EventBusSubscriber(Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ModelHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        // Patterns \\
        ModelLoader.setCustomModelResourceLocation(
                ModItems.BLANK_PATTERN,
                0,
                new ModelResourceLocation(MODID + ":patterns/blank_pattern", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.PATTERN,
                0,
                new ModelResourceLocation(MODID + ":patterns/patterns", "inventory")
        );

        // Parts \\
        ModelLoader.setCustomModelResourceLocation(
                ModItems.PART,
                0,
                new ModelResourceLocation(MODID + ":icons/icons", "inventory")
        );

        // Tools \\
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_SWORD,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_sword", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_PICKAXE,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_pickaxe", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_AXE,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_axe", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_SHOVEL,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_shovel", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_HOE,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_hoe", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ModItems.MODULAR_HAMMER,
                0,
                new ModelResourceLocation(MODID + ":tools/modular_hammer", "inventory")
        );

        registerBlock(ModBlocks.TOOL_STATION, "tables/tool_station");
        registerBlock(ModBlocks.PART_BUILDER, "tables/part_builder");
        registerBlock(ModBlocks.STENCIL_TABLE, "tables/stencil_table");
        registerBlock(ModBlocks.TOOL_FORGE, "tables/tool_forge");
    }

    public static void registerBlock(Block block, String modelPath) {

        Item item = Item.getItemFromBlock(block);

        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(MODID + ":" + modelPath, "inventory")
        );
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {

        // Tool Layer Stitching \\
        for (ToolType toolType : ToolTypeRegistry.getAllToolTypes()) {

            for (Part part : PartRegistry.getAllParts()) {

                if (!part.getAllowedToolType().contains(toolType)) {
                    continue;
                }

                if (part.getPartGroup() == PartGroup.EXTRA && !toolType.shouldRenderExtraLayer()) {
                    continue;
                }

                for (Material material : MaterialRegistry.getAllMaterials()) {

                    String materialID = material.getID();
                    String partID = part.getID();

                    if(!PartValidation.isValidMaterialPartCombo(materialID, partID)) {
                        continue;
                    }

                    if (part.getPartGroup() == null) {
                        continue;
                    }

                    ToolLayerRenderData toolData = new ToolLayerRenderData(
                            toolType,
                            part.getPartGroup(),
                            materialID,
                            partID
                    );

                    event.getMap().registerSprite(
                            ToolTextureResolver.getToolLayerTexture(toolData)
                    );
                }
            }
        }

        // Modifier Stitching \\
        for (Modifier modifier : ModifierRegistry.getAllModifiers()) {

            String modifierID = modifier.getID();

            for (ToolType toolType : modifier.getAllowedToolType()) {

                event.getMap().registerSprite(
                        new ResourceLocation(
                                "primitivetoolworks",
                                "modifiers/" + modifierID + "/" + toolType.getID() + "/" + modifierID
                        )
                );
            }
        }

        // Part Stitching \\
        for (Part part : PartRegistry.getAllParts()) {

            for (Material material : MaterialRegistry.getAllMaterials()) {

                String materialID = material.getID();
                String partID = part.getID();

                if (!PartValidation.isValidMaterialPartCombo(materialID, partID)) {
                    continue;
                }

                PartRenderData partData = new PartRenderData(
                        materialID,
                        partID,
                        part.getPartGroup()
                );

                event.getMap().registerSprite(
                        PartTextureResolver.getPartTexture(partData)
                );
            }
        }

        // Pattern Stitching \\
        for (Pattern pattern : PatternRegistry.getAllPatterns()) {

            String patternID = pattern.getID();

            PatternRenderData patternData =
                    new PatternRenderData(patternID);

            event.getMap().registerSprite(
                    PatternTextureResolver.getPatternTexture(patternData)
            );
        }
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

        replaceToolModel(event, "tools/modular_sword");
        replaceToolModel(event, "tools/modular_pickaxe");
        replaceToolModel(event, "tools/modular_axe");
        replaceToolModel(event, "tools/modular_shovel");
        replaceToolModel(event, "tools/modular_hoe");
        replaceToolModel(event, "tools/modular_hammer");

        replacePartModel(event, "icons/icons");
        replacePatternModel(event, "patterns/patterns");
    }
    private static void replaceToolModel(ModelBakeEvent event, String modelName) {

        ModelResourceLocation location = new ModelResourceLocation(
                MODID + ":" + modelName,
                "inventory"
        );

        IBakedModel model = event.getModelRegistry().getObject(location);

        if (model != null) {
            event.getModelRegistry().putObject(
                    location,
                    new ModelModularTool(model, null)
            );
        }
    }

    private static void replacePartModel(ModelBakeEvent event, String modelName) {

        ModelResourceLocation location = new ModelResourceLocation(
                MODID + ":" + modelName,
                "inventory"
        );

        IBakedModel model = event.getModelRegistry().getObject(location);

        if (model != null) {
            event.getModelRegistry().putObject(
                    location,
                    new ModelToolPart(model, null)
            );
        }
    }

    private static void replacePatternModel(ModelBakeEvent event, String modelName) {

        ModelResourceLocation location = new ModelResourceLocation(
                MODID + ":" + modelName,
                "inventory"
        );

        IBakedModel model = event.getModelRegistry().getObject(location);

        if (model != null) {
            event.getModelRegistry().putObject(
                    location,
                    new ModelPartPattern(model, null)
            );
        }
    }
}
