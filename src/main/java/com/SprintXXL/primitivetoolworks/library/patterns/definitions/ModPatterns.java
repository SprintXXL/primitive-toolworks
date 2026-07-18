package com.SprintXXL.primitivetoolworks.library.patterns.definitions;

import com.SprintXXL.primitivetoolworks.library.patterns.Pattern;
import com.SprintXXL.primitivetoolworks.library.patterns.nbt.PatternNBT;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

public class ModPatterns {

    public static void initPatternDefinitions(DefinitionRegistrar<Pattern> registrar) {

        registrar.register(SWORD_BLADE);
        registrar.register(PICKAXE_HEAD);
        registrar.register(AXE_HEAD);
        registrar.register(SHOVEL_HEAD);
        registrar.register(HOE_HEAD);
        registrar.register(HAMMER_HEAD);
        registrar.register(BINDING);
        registrar.register(TOUGH_BINDING);
        registrar.register(WIDE_GUARD);
        registrar.register(HANDLE);
        registrar.register(TOUGH_HANDLE);
    }

    // Main Patterns \\
    public static final Pattern SWORD_BLADE =
            new Pattern(
                    PatternIDs.SWORD_BLADE,
                    "Sword Blade",
                    PatternNBT.createPatternStack(PatternIDs.SWORD_BLADE)
            );
    public static final Pattern PICKAXE_HEAD =
            new Pattern(
                    PatternIDs.PICKAXE_HEAD,
                    "Pickaxe Head",
                    PatternNBT.createPatternStack(PatternIDs.PICKAXE_HEAD)
            );
    public static final Pattern AXE_HEAD =
            new Pattern(
                    PatternIDs.AXE_HEAD,
                    "Axe Head",
                    PatternNBT.createPatternStack(PatternIDs.AXE_HEAD)
            );
    public static final Pattern SHOVEL_HEAD =
            new Pattern(
                    PatternIDs.SHOVEL_HEAD,
                    "Shovel Head",
                    PatternNBT.createPatternStack(PatternIDs.SHOVEL_HEAD)
            );
    public static final Pattern HOE_HEAD =
            new Pattern(
                    PatternIDs.HOE_HEAD,
                    "Hoe Head",
                    PatternNBT.createPatternStack(PatternIDs.HOE_HEAD)
            );
    public static final Pattern HAMMER_HEAD =
            new Pattern(
                    PatternIDs.HAMMER_HEAD,
                    "Hammer Head",
                    PatternNBT.createPatternStack(PatternIDs.HAMMER_HEAD)
            );

    // Extra Patterns \\
    public static final Pattern BINDING =
            new Pattern(
                    PatternIDs.BINDING,
                    "Binding",
                    PatternNBT.createPatternStack(PatternIDs.BINDING)
            );
    public static final Pattern TOUGH_BINDING =
            new Pattern(
                    PatternIDs.TOUGH_BINDING,
                    "Tough Binding",
                    PatternNBT.createPatternStack(PatternIDs.TOUGH_BINDING)
            );
    public static final Pattern WIDE_GUARD =
            new Pattern(
                    PatternIDs.WIDE_GUARD,
                    "Wide Guard",
                    PatternNBT.createPatternStack(PatternIDs.WIDE_GUARD)
            );

    // Handle Patterns \\
    public static final Pattern HANDLE =
            new Pattern(
                    PatternIDs.HANDLE,
                    "Handle",
                    PatternNBT.createPatternStack(PatternIDs.HANDLE)
            );
    public static final Pattern TOUGH_HANDLE =
            new Pattern(
                    PatternIDs.TOUGH_HANDLE,
                    "Tough Handle",
                    PatternNBT.createPatternStack(PatternIDs.TOUGH_HANDLE)
            );
}
