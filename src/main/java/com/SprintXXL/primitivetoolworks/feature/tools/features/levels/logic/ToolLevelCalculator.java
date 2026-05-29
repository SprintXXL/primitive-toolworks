package com.SprintXXL.primitivetoolworks.feature.tools.features.levels.logic;

public final class ToolLevelCalculator {

    private ToolLevelCalculator() {}

    public static int getRequiredXP(int level) {

        return level * 100;
    }


}
