package com.SprintXXL.primitivetoolworks.core.patterns;

import net.minecraft.item.ItemStack;

public class PatternDefinition {

    private final String ID;
    private final String title;
    private final ItemStack iconStack;

    public PatternDefinition(
            String ID,
            String title,
            ItemStack iconStack
    ) {

        this.ID = ID;
        this.title = title;
        this.iconStack = iconStack;
    }

    public String getPatternID() {
        return ID;
    }

    public String getPatternTitle() {
        return title;
    }

    public ItemStack getPatternIconStack() {
        return iconStack;
    }
}
