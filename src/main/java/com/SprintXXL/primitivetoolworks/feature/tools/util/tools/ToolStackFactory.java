package com.SprintXXL.primitivetoolworks.feature.tools.util.tools;

import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaultData;
import com.SprintXXL.primitivetoolworks.feature.tools.defaults.ToolDefaults;
import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt.ToolLevelNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
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

        ToolModifierSlotNBT.setModifierSlots(stack, 0);

        ToolLevelNBT.setLevel(stack, 1);
        ToolLevelNBT.setXP(stack, 0);
        ToolLevelNBT.setTotalXP(stack, 0);

        return stack;
    }
}
