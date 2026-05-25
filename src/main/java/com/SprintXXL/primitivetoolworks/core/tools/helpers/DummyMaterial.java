package com.SprintXXL.primitivetoolworks.core.tools.helpers;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class DummyMaterial {

    public static final Item.ToolMaterial DUMMY_MATERIAL =
            EnumHelper.addToolMaterial(
                    "MODULAR_DUMMY",0,0,2,0,0
            );
}
