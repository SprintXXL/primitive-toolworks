package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;

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
