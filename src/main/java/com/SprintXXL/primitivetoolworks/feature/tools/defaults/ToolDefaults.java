package com.SprintXXL.primitivetoolworks.feature.tools.defaults;

import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolTypeRegistry;
import com.SprintXXL.primitivetoolworks.library.materials.data.MaterialIDs;
import com.SprintXXL.primitivetoolworks.library.parts.data.PartIDs;

public class ToolDefaults {

    public static String getDefaultMainPart(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultMainPart();
    }
    public static String getDefaultMainMaterial(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultMainMaterial();
    }

    public static String getDefaultHandlePart(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultHandlePart();
    }
    public static String getDefaultHandleMaterial(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultHandleMaterial();
    }

    public static String getDefaultExtraPart(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultExtraPart();
    }
    public static String getDefaultExtraMaterial(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .getDefaultExtraMaterial();
    }

    public static boolean shouldRenderExtraLayer(ToolType toolType) {

        return ToolTypeRegistry
                .getToolTypeDefinition(toolType)
                .shouldRenderExtraLayer();
    }

    public static ToolDefaultData getDefaultsFor(ToolType toolType) {

        switch (toolType) {

            case SWORD:
                return new ToolDefaultData(
                        PartIDs.SWORD_BLADE,
                        MaterialIDs.FLINT,
                        PartIDs.WIDE_GUARD,
                        MaterialIDs.BONE,
                        PartIDs.HANDLE,
                        MaterialIDs.WOOD
                );

            case PICKAXE:
                return new ToolDefaultData(
                        PartIDs.PICKAXE_HEAD,
                        MaterialIDs.FLINT,
                        PartIDs.BINDING,
                        MaterialIDs.BONE,
                        PartIDs.HANDLE,
                        MaterialIDs.WOOD
                );

            case AXE:
                return new ToolDefaultData(
                        PartIDs.AXE_HEAD,
                        MaterialIDs.FLINT,
                        PartIDs.BINDING,
                        MaterialIDs.BONE,
                        PartIDs.HANDLE,
                        MaterialIDs.WOOD
                );

            case SHOVEL:
                return new ToolDefaultData(
                        PartIDs.SHOVEL_HEAD,
                        MaterialIDs.FLINT,
                        PartIDs.BINDING,
                        MaterialIDs.BONE,
                        PartIDs.HANDLE,
                        MaterialIDs.WOOD
                );

            case HOE:
                return new ToolDefaultData(
                        PartIDs.HOE_HEAD,
                        MaterialIDs.FLINT,
                        PartIDs.BINDING,
                        MaterialIDs.BONE,
                        PartIDs.HANDLE,
                        MaterialIDs.WOOD
                );

            case HAMMER:
                return new ToolDefaultData(
                        PartIDs.HAMMER_HEAD,
                        MaterialIDs.FLINT,
                        PartIDs.TOUGH_BINDING,
                        MaterialIDs.BONE,
                        PartIDs.TOUGH_HANDLE,
                        MaterialIDs.WOOD
                );

            default:
                return null;
        }
    }
}
