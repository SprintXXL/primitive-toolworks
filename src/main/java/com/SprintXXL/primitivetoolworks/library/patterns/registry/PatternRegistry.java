package com.SprintXXL.primitivetoolworks.library.patterns.registry;

import com.SprintXXL.primitivetoolworks.library.patterns.Pattern;

import java.util.*;

import static com.SprintXXL.primitivetoolworks.library.patterns.definitions.ModPatterns.initPatternDefinitions;

public class PatternRegistry {

    private static final Map<String, Pattern> PATTERNS =
            new HashMap<>();

    private static final List<Pattern> ALL_PATTERNS =
            new ArrayList<>();

    public static List<Pattern> getAllPatterns() {
        return Collections.unmodifiableList(ALL_PATTERNS);
    }

    public static Pattern getPattern(String ID) {
        return PATTERNS.get(ID);
    }

    public static void register(Pattern pattern) {
        PATTERNS.put(pattern.getID(), pattern);
        ALL_PATTERNS.add(pattern);
    }

    public static void initPatternRegistry() {

        initPatternDefinitions(PatternRegistry::register);
    }
}
