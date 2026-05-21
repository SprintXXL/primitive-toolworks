package com.SprintXXL.primitivetoolworks.common.tools.types;

public enum ToolType {

    SWORD("sword"),
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    HAMMER("hammer");

    private final String id;

    ToolType(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public static ToolType fromID(String id) {
        for (ToolType type : values()) {
            if (type.getID().equals(id)) {
                return type;
            }
        }

        return PICKAXE;
    }
}
