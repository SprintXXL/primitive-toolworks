package com.SprintXXL.primitivetoolworks.core.tools.types;

import com.SprintXXL.primitivetoolworks.core.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.core.parts.PartIDs;
import com.SprintXXL.primitivetoolworks.common.container.stations.ToolStationTier;

import java.util.HashMap;
import java.util.Map;

public class ToolTypeRegistry {

    public static final Map<ToolType, ToolTypeDefinition> TOOL_TYPES =
            new HashMap<>();

    public static ToolTypeDefinition getToolTypeDefinition(ToolType toolType) {
        return TOOL_TYPES.get(toolType);
    }

    public static ToolStationTier getRequiredStationTier(ToolType toolType) {
        return TOOL_TYPES.get(toolType).getRequiredStationTier();
    }

    public static void register(ToolTypeDefinition definition) {
        TOOL_TYPES.put(definition.getToolType(), definition);
    }

    public static void init() {

        register(new ToolTypeDefinition(
                ToolType.SWORD,
                ToolStationTier.TOOL_STATION,
                PartIDs.SWORD_BLADE,
                MaterialIDs.FLINT,
                PartIDs.HANDLE,
                MaterialIDs.WOOD,
                PartIDs.WIDE_GUARD,
                MaterialIDs.BONE,
                true
        ));

        register(new ToolTypeDefinition(
                ToolType.PICKAXE,
                ToolStationTier.TOOL_STATION,
                PartIDs.PICKAXE_HEAD,
                MaterialIDs.FLINT,
                PartIDs.HANDLE,
                MaterialIDs.WOOD,
                PartIDs.BINDING,
                MaterialIDs.BONE,
                false
        ));

        register(new ToolTypeDefinition(
                ToolType.AXE,
                ToolStationTier.TOOL_STATION,
                PartIDs.AXE_HEAD,
                MaterialIDs.FLINT,
                PartIDs.HANDLE,
                MaterialIDs.WOOD,
                PartIDs.BINDING,
                MaterialIDs.BONE,
                false
        ));

        register(new ToolTypeDefinition(
                ToolType.SHOVEL,
                ToolStationTier.TOOL_STATION,
                PartIDs.SHOVEL_HEAD,
                MaterialIDs.FLINT,
                PartIDs.HANDLE,
                MaterialIDs.WOOD,
                PartIDs.BINDING,
                MaterialIDs.BONE,
                false
        ));

        register(new ToolTypeDefinition(
                ToolType.HOE,
                ToolStationTier.TOOL_STATION,
                PartIDs.HOE_HEAD,
                MaterialIDs.FLINT,
                PartIDs.HANDLE,
                MaterialIDs.WOOD,
                PartIDs.BINDING,
                MaterialIDs.BONE,
                false
        ));

        register(new ToolTypeDefinition(
                ToolType.HAMMER,
                ToolStationTier.TOOL_FORGE,
                PartIDs.HAMMER_HEAD,
                MaterialIDs.FLINT,
                PartIDs.TOUGH_HANDLE,
                MaterialIDs.WOOD,
                PartIDs.TOUGH_BINDING,
                MaterialIDs.BONE,
                false
        ));
    }
}
