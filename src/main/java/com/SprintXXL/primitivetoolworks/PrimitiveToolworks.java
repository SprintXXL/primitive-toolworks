package com.SprintXXL.primitivetoolworks;

import com.SprintXXL.primitivetoolworks.client.handler.GuiHandler;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.logic.LuckDropEventHandler;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRegistry;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.network.PacketSelectStencilPattern;
import com.SprintXXL.primitivetoolworks.library.modifiers.registry.ModifierRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.logic.PartValidation;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.tileentities.TileEntityPartBuilder;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.tileentities.TileEntityStencilTable;
import com.SprintXXL.primitivetoolworks.library.tooltypes.registry.ToolTypeRegistry;
import com.SprintXXL.primitivetoolworks.common.util.dev.DevCommands;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import static com.SprintXXL.primitivetoolworks.Reference.*;
import static com.SprintXXL.primitivetoolworks.ascent.ToolworksDefinitionProvider.initToolworksDefinitionProvider;
import static com.SprintXXL.primitivetoolworks.ascent.ToolworksRecipes.initToolworksRecipes;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveToolworks {

    @Mod.Instance
    public static PrimitiveToolworks INSTANCE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PartRegistry.initPartRegistry();
        MaterialRegistry.initMaterialRegistry();
        PatternRegistry.initPatternRegistry();
        ModifierRegistry.initModifierRegistry();
        ToolTypeRegistry.initToolTypeRegistry();
        PartValidation.init();
        ModifierApplicationRegistry.init();

        MinecraftForge.EVENT_BUS.register(new LuckDropEventHandler());

        NETWORK.registerMessage(
                PacketSelectStencilPattern.Handler.class,
                PacketSelectStencilPattern.class,
                0,
                Side.SERVER
        );

        // ARRI \\
        initToolworksRecipes();

        // HUB \\
        initToolworksDefinitionProvider();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());

        GameRegistry.registerTileEntity(TileEntityStencilTable.class, new ResourceLocation(MODID, "stencil_table"));

        GameRegistry.registerTileEntity(TileEntityPartBuilder.class, new ResourceLocation(MODID, "part_builder"));
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new DevCommands());
    }

    public static final SimpleNetworkWrapper NETWORK =
            NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
}
