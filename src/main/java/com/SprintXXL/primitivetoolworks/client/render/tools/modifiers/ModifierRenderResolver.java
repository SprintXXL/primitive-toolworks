package com.SprintXXL.primitivetoolworks.client.render.tools.modifiers;

import com.SprintXXL.primitivetoolworks.client.render.tools.ToolLayerRenderData;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolType;
import com.SprintXXL.primitivetoolworks.library.modifiers.data.ModifierDefinition;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ModifierRenderResolver {

    public static List<ToolLayerRenderData> resolveModifiers(ItemStack stack) {

        List<ToolLayerRenderData> layers = new ArrayList<>();

        ToolType toolType = ToolNBT.getToolType(stack);

        for (ModifierDefinition modifier : ModifierRegistry.getAllModifiers()) {
            int level = ToolModifierNBT.getModifierLevel(stack, modifier.getModifierID());

            if (level > 0) {
                ResourceLocation texture =
                        ModifierTextureResolver.getModifierLayerTexture(modifier.getModifierID(), toolType);

                layers.add(new ToolLayerRenderData(texture));
            }
        }

        return layers;
    }
}
