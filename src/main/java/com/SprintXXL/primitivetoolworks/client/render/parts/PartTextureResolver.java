package com.SprintXXL.primitivetoolworks.client.render.parts;

import com.SprintXXL.primitivetoolworks.library.parts.data.PartGroup;
import net.minecraft.util.ResourceLocation;

public class PartTextureResolver {

    public static ResourceLocation getPartTexture(PartRenderData data) {

        String folder = getFolder(data.group);

        return new ResourceLocation("primitivetoolworks",
                "parts/" + folder + "/" + data.partType + "/" + data.materialID
        );
    }

    public static String getFolder(PartGroup group) {

        if (group == PartGroup.MAIN) {
            return "main";
        }
        if (group == PartGroup.EXTRA) {
            return "extra";
        }
        if (group == PartGroup.HANDLE) {
            return "handle";
        }

        return "unknown";
    }
}
