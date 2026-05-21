package com.SprintXXL.primitivetoolworks.common.materials;

import java.util.*;

public class MaterialRegistry {

    private static final Map<String, MaterialDefinition> MATERIALS =
            new HashMap<>();

    private static final List<MaterialDefinition> ALL_MATERIALS =
            new ArrayList<>();

    public static List<MaterialDefinition> getAllMaterials() {
        return Collections.unmodifiableList(ALL_MATERIALS);
    }

    public static MaterialDefinition getMaterial(String id) {
        return MATERIALS.get(id);
    }

    public static void register(MaterialDefinition material) {
        MATERIALS.put(material.getMaterialID(), material);
        ALL_MATERIALS.add(material);
    }

    public static void init() {

        // Main Materials \\
        register(ModMaterials.FLINT);
        register(ModMaterials.IRON);
        register(ModMaterials.BRONZE);

        // Extra Materials \\
        register(ModMaterials.BONE);

        // Handle Materials \\
        register(ModMaterials.WOOD);
    }
}
