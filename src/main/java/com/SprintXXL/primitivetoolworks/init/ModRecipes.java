package com.SprintXXL.primitivetoolworks.init;

import com.SprintXXL.primitivetoolworks.recipes.RecipeModularPickaxe;
import com.SprintXXL.primitivetoolworks.recipes.RecipePartPattern;
import com.SprintXXL.primitivetoolworks.recipes.RecipeToolPart;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.SprintXXL.primitivetoolworks.util.Reference.MODID;

@Mod.EventBusSubscriber
public class ModRecipes {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        event.getRegistry().registerAll(
                new RecipeModularPickaxe().setRegistryName(MODID, "modular_pickaxe"),
                new RecipePartPattern().setRegistryName(MODID, "part_pattern"),
                new RecipeToolPart().setRegistryName(MODID, "tool_part")
        );
    }
}
