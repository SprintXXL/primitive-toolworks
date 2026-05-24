package com.SprintXXL.primitivetoolworks.client.stations.gui;

import com.SprintXXL.primitivetoolworks.common.stations.container.part_builder.ContainerPartBuilder;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class GuiPartBuilder extends GuiContainer {

    private final ContainerPartBuilder container;

    public GuiPartBuilder(ContainerPartBuilder container) {
        super(container);

        this.container = container;

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

        String title = "Part Builder";
        int gridLeft = 30;
        int gridWidth = 54;

        int titleX = gridLeft + (gridWidth / 2) - (this.fontRenderer.getStringWidth(title) / 2);

        this.fontRenderer.drawString(title, titleX, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);

    }

    private static final ResourceLocation GUI =
            new ResourceLocation(
                    MODID,
                    "textures/gui/part_builder.stencil_table.png"
            );
}
