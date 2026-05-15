package com.SprintXXL.primitivetoolworks.parts;

public class PartData {

    private final String materialID;
    private final String partType;
    private final String renderRole;

    public PartData(String materialID, String partType, String renderRole) {

        this.materialID = materialID;
        this.partType = partType;
        this.renderRole = renderRole;
    }

    public String getMaterialID() {
        return materialID;
    }

    public String getPartType() {
        return partType;
    }

    public String getRenderRole() {
        return renderRole;
    }
}
