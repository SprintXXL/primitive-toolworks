package com.SprintXXL.primitivetoolworks.core.tools.aoe;

public class AoeProfile {

    private final int radius;

    public AoeProfile(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public static AoeProfile threeByThree() {
        return new AoeProfile(1);
    }
}
