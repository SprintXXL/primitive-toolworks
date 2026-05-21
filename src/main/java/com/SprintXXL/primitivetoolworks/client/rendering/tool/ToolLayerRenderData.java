package com.SprintXXL.primitivetoolworks.client.rendering.tool;

import com.SprintXXL.primitivetoolworks.common.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.common.tools.types.ToolType;

public class ToolLayerRenderData {

    public final ToolType toolType;
    public final PartGroup partGroup;
    public final String materialID;

    public ToolLayerRenderData(ToolType toolType, PartGroup partGroup, String materialID) {

        this.toolType = toolType;
        this.partGroup = partGroup;
        this.materialID = materialID;
    }
}
