package com.SprintXXL.primitivetoolworks.feature.tools.tooltip;

import com.SprintXXL.primitivetoolworks.feature.tools.tooltip.components.*;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TooltipBuilder {

    private final ToolType toolType;
    private final List<TooltipComponent> components = new ArrayList<>();

    private TooltipBuilder(ToolType toolType) {
        this.toolType = toolType;
    }

    public static TooltipBuilder forType(ToolType toolType) {

        TooltipBuilder builder = new TooltipBuilder(toolType);

        builder.add(new MaterialTooltipComponent());

        builder.add(new LevelTooltipComponent());

        builder.add(new ModifierTooltipComponent());

        if (showsMiningSpeed(toolType)) {
            builder.add(new MiningSpeedTooltipComponent());
        }

        if (showsHarvestLevel(toolType)) {
            builder.add(new HarvestLevelTooltipComponent());
        }

        builder.add(new DurabilityTooltipComponent());

        return builder;
    }

    public TooltipBuilder add(TooltipComponent component) {
        components.add(component);
        return this;
    }

    public void addToTooltip(ItemStack stack, List<String> tooltip) {

        TooltipContext context = new TooltipContext(stack, toolType);

        for (TooltipComponent component : components) {
            component.addLines(context, tooltip);
        }
    }

    private static boolean showsMiningSpeed(ToolType toolType) {
        return toolType != ToolType.SWORD;
    }

    private static boolean showsHarvestLevel(ToolType toolType) {
        return toolType == ToolType.PICKAXE || toolType == ToolType.HAMMER;
    }
}
