package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
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

        if (group == PartGroup.EXTRA) {
            return "2_extra";
        }

        return "unknown";
    }

    private static String getToolFolder(ToolType toolType) {
        return toolType.getID();
    }
}
