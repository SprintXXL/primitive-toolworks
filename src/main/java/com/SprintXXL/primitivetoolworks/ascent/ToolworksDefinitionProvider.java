package com.SprintXXL.primitivetoolworks.ascent;

import com.SprintXXL.primitivetoolworks.library.materials.definitions.ModMaterials;
import com.SprintXXL.primitivetoolworks.library.modifiers.definitions.ModModifiers;
import com.SprintXXL.primitivetoolworks.library.parts.definitions.ModParts;
import com.SprintXXL.primitivetoolworks.library.patterns.definitions.ModPatterns;
import com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ModToolTypes;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;
import com.sprintxxl.ascenthub.definitions.AscentDefinitionProvider;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;
import static com.sprintxxl.ascenthub.definitions.registry.DefinitionProviderRegistry.registerProvider;

public class ToolworksDefinitionProvider implements AscentDefinitionProvider {

    private ToolworksDefinitionProvider() {}

    public static void initToolworksDefinitionProvider() {
        registerProvider(MODID, new ToolworksDefinitionProvider());
    }

    @Override
    public void registerDefinitions(DefinitionRegistrar<AscentDefinition> registrar) {

        ModMaterials.initMaterialDefinitions(registrar::register);
        ModModifiers.initModifierDefinitions(registrar::register);
        ModParts.initPartDefinitions(registrar::register);
        ModPatterns.initPatternDefinitions(registrar::register);
        ModToolTypes.initToolTypeDefinitions(registrar::register);
    }
}
