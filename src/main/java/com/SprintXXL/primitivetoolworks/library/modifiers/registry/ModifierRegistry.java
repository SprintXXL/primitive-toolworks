package com.SprintXXL.primitivetoolworks.library.modifiers.registry;

import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.defaults.ModModifiers;

import java.util.*;

public final class ModifierRegistry {

    private static final Map<String, ModifierDefinition> MODIFIERS =
            new HashMap<>();

    private static final List<ModifierDefinition> ALL_MODIFIERS =
            new ArrayList<>();

    public static List<ModifierDefinition> getAllModifiers() {
        return Collections.unmodifiableList(ALL_MODIFIERS);
    }

    public static ModifierDefinition getModifier(String id) {
        return MODIFIERS.get(id);
    }

    public static void register(ModifierDefinition modifier) {
        MODIFIERS.put(modifier.getModifierID(), modifier);
        ALL_MODIFIERS.add(modifier);
    }

    public static void init() {

        register(ModModifiers.HASTE);
        register(ModModifiers.LUCK);
    }
}
