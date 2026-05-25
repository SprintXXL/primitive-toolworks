package com.SprintXXL.primitivetoolworks.client.render.parts;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;

public class PartRenderData {

    public final String materialID;
    public final String partType;
    public final PartGroup group;

    public PartRenderData(String materialID, String partType, PartGroup group) {

        this.materialID = materialID;
        this.partType = partType;
        this.group = group;


    }
}
