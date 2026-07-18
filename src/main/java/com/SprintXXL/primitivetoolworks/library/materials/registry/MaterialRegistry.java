package com.SprintXXL.primitivetoolworks.library.materials.registry;

import com.SprintXXL.primitivetoolworks.library.materials.Material;

import java.util.*;

import static com.SprintXXL.primitivetoolworks.library.materials.definitions.ModMaterials.initMaterialDefinitions;

public class MaterialRegistry {

    private static final Map<String, Material> MATERIALS = new HashMap<>();

    private static final List<Material> ALL_MATERIALS = new ArrayList<>();

    public static List<Material> getAllMaterials() {
        return Collections.unmodifiableList(ALL_MATERIALS);
    }

    public static Material getMaterial(String id) {
        return MATERIALS.get(id);
    }

    public static void register(Material material) {
        MATERIALS.put(material.getID(), material);
        ALL_MATERIALS.add(material);
    }

    public static void initMaterialRegistry() {

        initMaterialDefinitions(MaterialRegistry::register);
    }
}
