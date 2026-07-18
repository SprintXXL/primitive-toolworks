package com.SprintXXL.primitivetoolworks.library.tooltypes.definitions;

import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.SprintXXL.primitivetoolworks.library.materials.definitions.MaterialIDs;
import com.SprintXXL.primitivetoolworks.library.parts.definitions.PartIDs;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

public final class ModToolTypes {
    
    private ModToolTypes() {}
    
    public static void initToolTypeDefinitions(DefinitionRegistrar<ToolType> registrar) {

        registrar.register(SWORD);
        registrar.register(PICKAXE);
        registrar.register(AXE);
        registrar.register(SHOVEL);
        registrar.register(HOE);
        registrar.register(HAMMER);
    }
    
    public static final ToolType SWORD =
            new ToolType(
                    ToolTypeIDs.SWORD,
                    ToolStationTier.TOOL_STATION,
                    PartIDs.SWORD_BLADE,
                    MaterialIDs.FLINT,
                    PartIDs.HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.WIDE_GUARD,
                    MaterialIDs.BONE,
                    true
            );

    public static final ToolType PICKAXE =
            new ToolType(
                    ToolTypeIDs.PICKAXE,
                    ToolStationTier.TOOL_STATION,
                    PartIDs.PICKAXE_HEAD,
                    MaterialIDs.FLINT,
                    PartIDs.HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.BINDING,
                    MaterialIDs.BONE,
                    false
    );

    public static final ToolType AXE =
            new ToolType(
                    ToolTypeIDs.AXE,
                    ToolStationTier.TOOL_STATION,
                    PartIDs.AXE_HEAD,
                    MaterialIDs.FLINT,
                    PartIDs.HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.BINDING,
                    MaterialIDs.BONE,
                    false
    );

    public static final ToolType SHOVEL =
            new ToolType(
                    ToolTypeIDs.SHOVEL,
                    ToolStationTier.TOOL_STATION,
                    PartIDs.SHOVEL_HEAD,
                    MaterialIDs.FLINT,
                    PartIDs.HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.BINDING,
                    MaterialIDs.BONE,
                    false
    );

    public static final ToolType HOE =
            new ToolType(
                    ToolTypeIDs.HOE,
                    ToolStationTier.TOOL_STATION,
                    PartIDs.HOE_HEAD,
                    MaterialIDs.FLINT,
                    PartIDs.HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.BINDING,
                    MaterialIDs.BONE,
                    false
    );

    public static final ToolType HAMMER =
            new ToolType(
                    ToolTypeIDs.HAMMER,
                    ToolStationTier.TOOL_FORGE,
                    PartIDs.HAMMER_HEAD,
                    MaterialIDs.FLINT,
                    PartIDs.TOUGH_HANDLE,
                    MaterialIDs.WOOD,
                    PartIDs.TOUGH_BINDING,
                    MaterialIDs.BONE,
                    false
    );
}
