package com.SprintXXL.primitivetoolworks.common.parts;

import static com.SprintXXL.primitivetoolworks.common.parts.PartDefinitions.*;

public class PartRegistry {

    public static PartDefinition getPart(String id) {

        if (id.equals(PartIDs.HANDLE)) {
            return HANDLE;
        }
        if (id.equals(PartIDs.PICKAXE_HEAD)) {
            return PICKAXE_HEAD;
        }
        if (id.equals(PartIDs.BINDING)) {
            return BINDING;
        }
        return null;
    }
}
