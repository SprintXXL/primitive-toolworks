package com.SprintXXL.primitivetoolworks.materials;

public class MaterialRegistry {

    public static MaterialDefinition getMaterial(String id) {

        if (id.equals(MaterialIDs.FLINT)) {
            return FLINT;
        }

        if (id.equals(MaterialIDs.WOOD)) {
            return WOOD;
        }

        return WOOD;
    }

    public static final MaterialDefinition FLINT =
            new MaterialDefinition(
                    MaterialIDs.FLINT,
                    1,
                    256,
                    5,
                    5
            );

    public static final MaterialDefinition WOOD =
            new MaterialDefinition(
                    MaterialIDs.WOOD,
                    1,
                    256,
                    5,
                    5
            );
}
