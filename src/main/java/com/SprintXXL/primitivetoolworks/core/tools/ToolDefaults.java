package com.SprintXXL.primitivetoolworks.core.tools;

import com.SprintXXL.primitivetoolworks.core.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.core.tools.types.ToolTypeRegistry;

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
}
