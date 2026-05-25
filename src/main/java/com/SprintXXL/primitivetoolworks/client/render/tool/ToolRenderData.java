package com.SprintXXL.primitivetoolworks.client.render.tool;

import com.SprintXXL.primitivetoolworks.core.tools.types.ToolType;

import java.util.List;

public class ToolRenderData {

    public final ToolType toolType;
    public final List<ToolLayerRenderData> layers;

    public ToolRenderData(ToolType toolType, List<ToolLayerRenderData> layers) {

        this.toolType = toolType;
        this.layers = layers;
    }
}
