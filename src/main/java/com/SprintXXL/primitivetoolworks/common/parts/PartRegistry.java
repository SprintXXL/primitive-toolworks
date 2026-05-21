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

        // Main Parts \\
        register(ModParts.SWORD_BLADE);
        register(ModParts.PICKAXE_HEAD);
        register(ModParts.AXE_HEAD);
        register(ModParts.SHOVEL_HEAD);
        register(ModParts.HOE_HEAD);
        register(ModParts.HAMMER_HEAD);

        // Extra Parts \\
        register(ModParts.BINDING);
        register(ModParts.TOUGH_BINDING);
        register(ModParts.WIDE_GUARD);

        // Handle Parts \\
        register(ModParts.HANDLE);
        register(ModParts.TOUGH_HANDLE);
    }
}
