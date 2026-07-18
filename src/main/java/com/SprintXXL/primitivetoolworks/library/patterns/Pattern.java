package com.SprintXXL.primitivetoolworks.library.patterns;

import com.sprintxxl.ascenthub.definitions.AscentDefinition;
import net.minecraft.item.ItemStack;

public class Pattern implements AscentDefinition {

    private final String id;
    private final String title;
    private final ItemStack iconStack;

    public Pattern(
            String ID,
            String title,
            ItemStack iconStack
    ) {

        this.id = ID;
        this.title = title;
        this.iconStack = iconStack;
    }

    @Override
    public String getID() {
        return id;
    }

    public String getPatternTitle() {
        return title;
    }

    public ItemStack getPatternIconStack() {
        return iconStack;
    }
}
