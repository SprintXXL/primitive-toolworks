package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaultData;
import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaults;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolStackFactory {

    private ToolStackFactory() {}

    public static ItemStack createDefaultTool(Item item, ToolType toolType) {

        ItemStack stack = new ItemStack(item);

        ToolDefaultData defaults = ToolDefaults.getDefaultsFor(toolType);

        ToolNBT.setToolType(stack, toolType);

        ToolNBT.setMainPart(stack, defaults.getMainPart());
        ToolNBT.setMainMaterial(stack, defaults.getMainMaterial());

        ToolNBT.setExtraPart(stack, defaults.getExtraPart());
        ToolNBT.setExtraMaterial(stack, defaults.getExtraMaterial());

        ToolNBT.setHandlePart(stack, defaults.getHandlePart());
        ToolNBT.setHandleMaterial(stack, defaults.getHandleMaterial());

        return stack;
    }
}
