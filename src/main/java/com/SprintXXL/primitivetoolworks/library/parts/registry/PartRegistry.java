package com.SprintXXL.primitivetoolworks.library.parts.registry;

import com.SprintXXL.primitivetoolworks.library.parts.Part;

import java.util.*;

import static com.SprintXXL.primitivetoolworks.library.parts.definitions.ModParts.initPartDefinitions;

public class PartRegistry {

    private static final Map<String, Part> PARTS =
            new HashMap<>();

    private static final List<Part> ALL_PARTS =
            new ArrayList<>();

    public static List<Part> getAllParts() {
        return Collections.unmodifiableList(ALL_PARTS);
    }

    public static Part getPart(String id) {
        return PARTS.get(id);
    }

    public static void register(Part part) {
        PARTS.put(part.getID(), part);
        ALL_PARTS.add(part);
    }

    public static void initPartRegistry() {

        initPartDefinitions(PartRegistry::register);
    }
}
