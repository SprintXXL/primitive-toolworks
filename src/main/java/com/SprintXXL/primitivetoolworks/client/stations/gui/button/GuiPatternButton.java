package com.SprintXXL.primitivetoolworks.client.stations.gui.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiPatternButton extends GuiButton {

    private final ItemStack iconStack;

    public GuiPatternButton(
            int buttonID,
            int x,
            int y,
            ItemStack iconStack
    ) {
        super(buttonID, x, y, 20, 20, "");

        this.iconStack = iconStack;
    }

    @Override
    public void drawButton(Minecraft mc,int mouseX, int mouseY, float partialTicks) {

        super.drawButton(mc, mouseX, mouseY, partialTicks);

        if (this.visible) {

            mc.getRenderItem().renderItemAndEffectIntoGUI(
                    iconStack,
                    this.x + 2,
                    this.y + 2
            );
        }
    }
}
