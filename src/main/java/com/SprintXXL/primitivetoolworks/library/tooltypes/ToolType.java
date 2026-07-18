package com.SprintXXL.primitivetoolworks.library.tooltypes;

import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;

public class ToolType implements AscentDefinition {

    private final String id;

    private final ToolStationTier requiredStationTier;

    private final String defaultMainPart;
    private final String defaultMainMaterial;

    private final String defaultHandlePart;
    private final String defaultHandleMaterial;

    private final String defaultExtraPart;
    private final String defaultExtraMaterial;

    private final boolean renderExtraLayer;

    public ToolType(
            String id,
            ToolStationTier requiredStationTier,
            String defaultMainPart,
            String defaultMainMaterial,
            String defaultHandlePart,
            String defaultHandleMaterial,
            String defaultExtraPart,
            String defaultExtraMaterial,
            boolean renderExtraLayer) {

        this.id = id;

        this.requiredStationTier = requiredStationTier;

        this.defaultMainPart = defaultMainPart;
        this.defaultMainMaterial = defaultMainMaterial;

        this.defaultHandlePart = defaultHandlePart;
        this.defaultHandleMaterial = defaultHandleMaterial;

        this.defaultExtraPart = defaultExtraPart;
        this.defaultExtraMaterial = defaultExtraMaterial;

        this.renderExtraLayer = renderExtraLayer;
    }

    @Override
    public String getID() {
        return id;
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
