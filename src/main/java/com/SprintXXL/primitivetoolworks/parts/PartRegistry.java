package com.SprintXXL.primitivetoolworks.parts;

public class PartRegistry {

    public static PartDefinition getPart(String id) {

        if (id.equals(PartIDs.HANDLE)) {
            return HANDLE;
        }
        if (id.equals(PartIDs.PICKAXE_HEAD)) {
            return PICKAXE_HEAD;
        }
        return PICKAXE_HEAD;
    }

    public static final PartDefinition HANDLE =
            new PartDefinition(
                    PartIDs.HANDLE,
                    1,
                    1,
                    1
            );
    public static final PartDefinition PICKAXE_HEAD =
            new PartDefinition(
                    PartIDs.PICKAXE_HEAD,
                    1,
                    1,
                    1
            );
}
