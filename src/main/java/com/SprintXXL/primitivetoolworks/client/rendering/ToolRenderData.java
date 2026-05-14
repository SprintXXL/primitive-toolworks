package com.SprintXXL.primitivetoolworks.client.rendering;

public class ToolRenderData {

    public final String mainMaterial;
    public final String mainPart;

    public final String extraMaterial;
    public final String extraPart;

    public final String handleMaterial;
    public final String handlePart;

    public ToolRenderData(String mainMaterial, String mainPart, String extraMaterial, String extraPart, String handleMaterial, String handlePart) {

        this.mainMaterial = mainMaterial;
        this.mainPart = mainPart;

        this.extraMaterial = extraMaterial;
        this.extraPart = extraPart;

        this.handleMaterial = handleMaterial;
        this.handlePart = handlePart;
    }
}
