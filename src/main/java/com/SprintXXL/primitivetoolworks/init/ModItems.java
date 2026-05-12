package com.SprintXXL.primitivetoolworks.init;

import com.SprintXXL.primitivetoolworks.items.ItemModularPickaxe;
import com.SprintXXL.primitivetoolworks.items.ItemToolPart;
import com.SprintXXL.primitivetoolworks.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.parts.PartIDs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static final Item WOODEN_HANDLE = new ItemToolPart("wooden_handle", MaterialIDs.WOOD, PartIDs.HANDLE);

    public static final Item FLINT_PICKAXE_HEAD = new ItemToolPart("flint_pickaxe_head", MaterialIDs.FLINT, PartIDs.PICKAXE_HEAD);

    public static final Item TEST_PICKAXE = new ItemModularPickaxe("test_pickaxe");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register <Item> event) {
        event.getRegistry().registerAll(
                WOODEN_HANDLE,
                FLINT_PICKAXE_HEAD,
                TEST_PICKAXE
        );
    }
}
