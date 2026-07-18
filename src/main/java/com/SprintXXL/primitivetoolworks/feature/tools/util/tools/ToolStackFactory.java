package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt.ToolLevelNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolStackFactory {

    private ToolStackFactory() {}

    public static ItemStack createDefaultTool(Item item, ToolType toolType) {

        ItemStack stack = new ItemStack(item);

        ToolNBT.setToolType(stack, toolType);

        ToolNBT.setMainPart(stack, toolType.getDefaultMainPart());
        ToolNBT.setMainMaterial(stack, toolType.getDefaultMainMaterial());

        ToolNBT.setExtraPart(stack, toolType.getDefaultExtraPart());
        ToolNBT.setExtraMaterial(stack, toolType.getDefaultExtraMaterial());

        ToolNBT.setHandlePart(stack, toolType.getDefaultHandlePart());
        ToolNBT.setHandleMaterial(stack, toolType.getDefaultHandleMaterial());

        ToolModifierSlotNBT.setModifierSlots(stack, 0);

        ToolLevelNBT.setLevel(stack, 1);
        ToolLevelNBT.setXP(stack, 0);
        ToolLevelNBT.setTotalXP(stack, 0);

        return stack;
    }
}
