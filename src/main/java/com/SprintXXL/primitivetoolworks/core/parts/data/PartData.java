package com.SprintXXL.primitivetoolworks.core.parts.data;

import com.SprintXXL.primitivetoolworks.core.parts.PartGroup;

public class PartData {

    private final String materialID;
    private final String partType;
    private final PartGroup group;

    public PartData(String materialID, String partType, PartGroup group) {

        this.materialID = materialID;
        this.partType = partType;
        this.group = group;
    }

    public String getMaterialID() {
        return materialID;
    }

    public String getPartType() {
        return partType;
    }

    public PartGroup getPartGroup() {
        return group;
    }
}
