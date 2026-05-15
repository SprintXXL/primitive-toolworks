package com.SprintXXL.primitivetoolworks.common.parts;

import java.util.*;

public class PartRegistry {

    private static final Map<String, PartDefinition> PARTS =
            new HashMap<>();

    private static final List<PartDefinition> ALL_PARTS =
            new ArrayList<>();

    public static List<PartDefinition> getAllParts() {
        return Collections.unmodifiableList(ALL_PARTS);
    }

    public static PartDefinition getPart(String id) {
        return PARTS.get(id);
    }

    public static void register(PartDefinition part) {
        PARTS.put(part.getPartID(), part);
        ALL_PARTS.add(part);
    }

    public static void init() {

        register(PartDefinitions.PICKAXE_HEAD);
        register(PartDefinitions.BINDING);
        register(PartDefinitions.HANDLE);
    }
}
