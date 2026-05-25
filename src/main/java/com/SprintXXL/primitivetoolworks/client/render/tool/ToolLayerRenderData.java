package com.SprintXXL.primitivetoolworks.client.render.tool;

import com.SprintXXL.primitivetoolworks.core.parts.PartGroup;
import com.SprintXXL.primitivetoolworks.core.tools.types.ToolType;

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
