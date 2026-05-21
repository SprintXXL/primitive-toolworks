package com.SprintXXL.primitivetoolworks.client.stations.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class GuiToolWorkbench extends GuiContainer {

    private final String title;

    public GuiToolWorkbench(Container container, String title) {
        super(container);

        this.xSize = 176;
        this.ySize = 166;

        this.title = title;
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

        int gridLeft = 30;
        int gridWidth = 54;

        int titleX = gridLeft + (gridWidth / 2) - (this.fontRenderer.getStringWidth(title) / 2);

        this.fontRenderer.drawString(title, titleX, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);

    }

    private static final ResourceLocation GUI =
            new ResourceLocation(
                    MODID,
                    "textures/gui/tools.png"
            );
}
