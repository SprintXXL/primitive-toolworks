package com.SprintXXL.primitivetoolworks.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerToolStation extends Container {

    @Override
    public boolean canInteractWith(EntityPlayer playIn) {
        return true;
    }
}
