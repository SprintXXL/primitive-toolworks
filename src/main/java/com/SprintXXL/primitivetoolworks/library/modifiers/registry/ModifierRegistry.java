package com.SprintXXL.primitivetoolworks.library.modifiers.registry;

import com.SprintXXL.primitivetoolworks.library.modifiers.Modifier;

import java.util.*;

import static com.SprintXXL.primitivetoolworks.library.modifiers.definitions.ModModifiers.initModifierDefinitions;

public final class ModifierRegistry {

    private static final Map<String, Modifier> MODIFIERS =
            new HashMap<>();

    private static final List<Modifier> ALL_MODIFIERS =
            new ArrayList<>();

    public static List<Modifier> getAllModifiers() {
        return Collections.unmodifiableList(ALL_MODIFIERS);
    }

    public static Modifier getModifier(String id) {
        return MODIFIERS.get(id);
    }

    public static void register(Modifier modifier) {
        MODIFIERS.put(modifier.getID(), modifier);
        ALL_MODIFIERS.add(modifier);
    }

    public static void initModifierRegistry() {

        initModifierDefinitions(ModifierRegistry::register);
    }
}
