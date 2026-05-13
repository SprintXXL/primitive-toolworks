package com.SprintXXL.primitivetoolworks.parts;

public class PartData {

    private final String materialID;
    private final String partType;

    public PartData(String materialID, String partType) {

        this.materialID = materialID;
        this.partType = partType;
    }

    public String getMaterialID() {
        return materialID;
    }

    public String getPartType() {
        return partType;
    }
}
