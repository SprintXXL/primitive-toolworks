package com.SprintXXL.primitivetoolworks.core.patterns;

import java.util.*;

public class PatternRegistry {

    private static final Map<String, PatternDefinition> PATTERNS =
            new HashMap<>();

    private static final List<PatternDefinition> ALL_PATTERNS =
            new ArrayList<>();

    public static List<PatternDefinition> getAllPatterns() {
        return Collections.unmodifiableList(ALL_PATTERNS);
    }

    public static PatternDefinition getPattern(String ID) {
        return PATTERNS.get(ID);
    }

    public static void register(PatternDefinition pattern) {
        PATTERNS.put(pattern.getPatternID(), pattern);
        ALL_PATTERNS.add(pattern);
    }

    public static void init() {

        // Main Patterns \\
        register(ModPatterns.SWORD_BLADE);
        register(ModPatterns.PICKAXE_HEAD);
        register(ModPatterns.AXE_HEAD);
        register(ModPatterns.SHOVEL_HEAD);
        register(ModPatterns.HOE_HEAD);
        register(ModPatterns.HAMMER_HEAD);

        // Extra Patterns \\
        register(ModPatterns.BINDING);
        register(ModPatterns.TOUGH_BINDING);
        register(ModPatterns.WIDE_GUARD);

        // Handle Patterns \\
        register(ModPatterns.HANDLE);
        register(ModPatterns.TOUGH_HANDLE);
    }
}
