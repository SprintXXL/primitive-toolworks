package com.SprintXXL.primitivetoolworks.common.patterns;

import java.util.*;

public class PatternRegistry {

    private static final List<String> ALL_PATTERNS =
            new ArrayList<>();

    public static void register(String patternID) {
        ALL_PATTERNS.add(patternID);
    }

    public static List<String> getAllPatterns() {
        return Collections.unmodifiableList(ALL_PATTERNS);
    }

    public static void init() {

        register(PatternIDs.PICKAXE_HEAD);
        register(PatternIDs.BINDING);
        register(PatternIDs.HANDLE);
    }
}
