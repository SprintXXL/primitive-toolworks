package com.SprintXXL.primitivetoolworks.init;

import com.SprintXXL.primitivetoolworks.recipes.RecipeModularPickaxe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

@Mod.EventBusSubscriber
public class ModRecipes {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        event.getRegistry().register(
                new RecipeModularPickaxe().setRegistryName(MODID, "modular_pickaxe")
        );
    }
}
