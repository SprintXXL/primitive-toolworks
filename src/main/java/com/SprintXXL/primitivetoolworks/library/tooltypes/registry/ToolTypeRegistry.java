package com.SprintXXL.primitivetoolworks.library.tooltypes.registry;

import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;

import java.util.*;

import static com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ModToolTypes.initToolTypeDefinitions;

public class ToolTypeRegistry {

    public static final Map<String, ToolType> TOOL_TYPES = new LinkedHashMap<>();

    public static ToolType getToolType(String id) {
        return TOOL_TYPES.get(id);
    }

    public static List<ToolType> getAllToolTypes() {
        return new ArrayList<>(TOOL_TYPES.values());
    }

    public static void register(ToolType definition) {
        TOOL_TYPES.put(definition.getID(), definition);
    }

    public static void initToolTypeRegistry() {

        initToolTypeDefinitions(ToolTypeRegistry::register);
    }
}
