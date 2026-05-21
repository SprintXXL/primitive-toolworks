package com.SprintXXL.primitivetoolworks.common.patterns;

public class PatternDefinition {

    private final String ID;
    private final String title;

    public PatternDefinition(
            String ID,
            String title
    ) {

        this.ID = ID;
        this.title = title;
    }

    public String getPatternID() {
        return ID;
    }

    public String getPatternTitle() {
        return title;
    }
}
