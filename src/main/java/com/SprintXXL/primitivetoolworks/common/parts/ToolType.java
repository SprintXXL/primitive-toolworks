package com.SprintXXL.primitivetoolworks.common.parts;

public enum ToolType {

    SWORD("sword"),
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe");

    private final String id;

    ToolType(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
}
