package com.SprintXXL.primitivetoolworks.common.tools.types;

import com.SprintXXL.primitivetoolworks.common.stations.ToolStationTier;

public class ToolTypeDefinition {

    private final ToolType toolType;

    private final ToolStationTier requiredStationTier;

    private final String defaultMainPart;
    private final String defaultMainMaterial;

    private final String defaultHandlePart;
    private final String defaultHandleMaterial;

    private final String defaultExtraPart;
    private final String defaultExtraMaterial;

    private final boolean renderExtraLayer;

    public ToolTypeDefinition(
            ToolType toolType,
            ToolStationTier requiredStationTier,
            String defaultMainPart,
            String defaultMainMaterial,
            String defaultHandlePart,
            String defaultHandleMaterial,
            String defaultExtraPart,
            String defaultExtraMaterial,
            boolean renderExtraLayer) {

        this.toolType = toolType;

        this.requiredStationTier = requiredStationTier;

        this.defaultMainPart = defaultMainPart;
        this.defaultMainMaterial = defaultMainMaterial;

        this.defaultHandlePart = defaultHandlePart;
        this.defaultHandleMaterial = defaultHandleMaterial;

        this.defaultExtraPart = defaultExtraPart;
        this.defaultExtraMaterial = defaultExtraMaterial;

        this.renderExtraLayer = renderExtraLayer;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public ToolStationTier getRequiredStationTier() {
        return requiredStationTier;
    }

    public String getDefaultMainPart() {
        return defaultMainPart;
    }
    public String getDefaultMainMaterial() {
        return defaultMainMaterial;
    }

    public String getDefaultHandlePart() {
        return defaultHandlePart;
    }
    public String getDefaultHandleMaterial() {
        return defaultHandleMaterial;
    }

    public String getDefaultExtraPart() {
        return defaultExtraPart;
    }
    public String getDefaultExtraMaterial() {
        return defaultExtraMaterial;
    }

    public boolean shouldRenderExtraLayer() {
        return renderExtraLayer;
    }
}
