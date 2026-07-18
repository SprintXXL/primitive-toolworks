package com.SprintXXL.primitivetoolworks.client.render.tools.modifiers;

import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import net.minecraft.util.ResourceLocation;

public class ModifierTextureResolver {

    public static ResourceLocation getModifierLayerTexture(String modifierID, ToolType toolType) {

        return new ResourceLocation(
                "primitivetoolworks",
                "modifiers/" + modifierID + "/" + toolType.getID() + "/" + modifierID
        );
    }
}
