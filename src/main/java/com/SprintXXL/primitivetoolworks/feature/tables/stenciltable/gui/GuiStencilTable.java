package com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.gui;

import com.SprintXXL.primitivetoolworks.PrimitiveToolworks;
import com.SprintXXL.primitivetoolworks.client.gui.widgets.GuiPatternButton;
import com.SprintXXL.primitivetoolworks.common.network.PacketSelectStencilPattern;
import com.SprintXXL.primitivetoolworks.library.patterns.data.PatternDefinition;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

public class GuiStencilTable extends GuiContainer {

    private final ContainerStencilTable container;

    public GuiStencilTable(ContainerStencilTable container) {
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

        String title = "Stencil Table";
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

    @Override
    public void initGui() {
        super.initGui();

        this.buttonList.clear();

        List<PatternDefinition> patterns = PatternRegistry.getAllPatterns();

        int columns = 4;

        for (int i = 0; i < patterns.size(); i++) {

            PatternDefinition pattern = patterns.get(i);

            int column = i % columns;
            int row = i / columns;

            int x = guiLeft - 96 + (column * 22);
            int y = guiTop + 20 + (row * 22);

            this.buttonList.add(new GuiPatternButton(
                    i,
                    x,
                    y,
                    pattern.getPatternIconStack()
            ));
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {

        PatternDefinition selected = PatternRegistry.getAllPatterns().get(button.id);

        PrimitiveToolworks.NETWORK.sendToServer(
                new PacketSelectStencilPattern(selected.getPatternID())
        );
    }
}
