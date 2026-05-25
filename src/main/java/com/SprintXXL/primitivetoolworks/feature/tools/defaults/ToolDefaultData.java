package com.SprintXXL.primitivetoolworks.feature.tools.defaults;

public class ToolDefaultData {

    private String mainPart;
    private String mainMaterial;

    private String extraPart;
    private String extraMaterial;

    private String handlePart;
    private String handleMaterial;

    public ToolDefaultData(
            String mainPart,
            String mainMaterial,

            String extraPart,
            String extraMaterial,

            String handlePart,
            String handleMaterial
    ) {
        this.mainPart = mainPart;
        this.mainMaterial = mainMaterial;

        this.extraPart = extraPart;
        this.extraMaterial = extraMaterial;

        this.handlePart = handlePart;
        this.handleMaterial = handleMaterial;
    }

    public String getMainPart() {
        return mainPart;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public String getExtraPart() {
        return extraPart;
    }

    public String getExtraMaterial() {
        return extraMaterial;
    }

    public String getHandlePart() {
        return handlePart;
    }

    public String getHandleMaterial() {
        return handleMaterial;
    }
}
