package com.SprintXXL.primitivetoolworks.client.render.tools;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import net.minecraft.util.ResourceLocation;

public class ToolLayerRenderData {

    public final ToolType toolType;
    public final PartGroup partGroup;
    public final String materialID;
    public final String partID;

    public final ResourceLocation customTexture;

    public ToolLayerRenderData(ToolType toolType, PartGroup partGroup, String materialID, String partID) {

        this.toolType = toolType;
        this.partGroup = partGroup;
        this.materialID = materialID;
        this.partID = partID;

        this.customTexture = null;
    }

    public ToolLayerRenderData(ResourceLocation customTexture) {

        this.toolType = null;
        this.partGroup = null;
        this.materialID = null;
        this.partID = null;

        this.customTexture = customTexture;
    }
}