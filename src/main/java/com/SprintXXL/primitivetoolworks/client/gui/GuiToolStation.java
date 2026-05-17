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
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        mc.getTextureManager().bindTexture(GUI);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String title = "Tool Station";

        int gridLeft = 30;
        int gridWidth = 54;

        int titleX = gridLeft + (gridWidth / 2) - (this.fontRenderer.getStringWidth(title) / 2);

        this.fontRenderer.drawString(title, titleX, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);

    }

    private static final ResourceLocation GUI =
            new ResourceLocation(
                    MODID,
                    "textures/gui/tool_station.png"
            );
}
