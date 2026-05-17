package com.SprintXXL.primitivetoolworks.client.gui;

import com.SprintXXL.primitivetoolworks.common.container.ContainerToolStation;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

public class GuiToolStation extends GuiContainer {

    public GuiToolStation(ContainerToolStation container) {
        super(container);

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        mc.getTextureManager().bindTexture(GUI);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

    private static final ResourceLocation GUI =
            new ResourceLocation(
                    MODID,
                    "textures/gui/tool_station.png"
            );
}
