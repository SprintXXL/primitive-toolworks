package com.SprintXXL.primitivetoolworks.common.materials;

import static com.SprintXXL.primitivetoolworks.common.materials.MaterialDefinitions.*;

public class MaterialRegistry {

    public static MaterialDefinition getMaterial(String id) {

        if (id.equals(MaterialIDs.FLINT)) {
            return FLINT;
        }

        if (id.equals(MaterialIDs.WOOD)) {
            return WOOD;
        }

        if (id.equals(MaterialIDs.BONE)) {
            return BONE;
        }

        return null;
    }
}
