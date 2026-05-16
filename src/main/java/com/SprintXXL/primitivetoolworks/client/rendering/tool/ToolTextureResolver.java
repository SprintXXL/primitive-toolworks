package com.SprintXXL.primitivetoolworks.client.rendering.tool;

import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.parts.ToolType;
import net.minecraft.util.ResourceLocation;

public class ToolTextureResolver {

    public static ResourceLocation getToolLayerTexture(ToolLayerRenderData data) {

        return new ResourceLocation(
                "primitivetoolworks",
                "tool_layers/" + getToolFolder(data.toolType) + "/" + getLayerFolder(data.partGroup) + "/" + data.materialID
        );
    }

    private static String getLayerFolder(PartGroup group) {

        if (group == PartGroup.HANDLE) {
            return "0_handle";
        }

        if (group == PartGroup.MAIN) {
            return "1_main";
        }

        return "unknown";
    }

    private static String getToolFolder(ToolType toolType) {
        return toolType.getID();
    }
}
