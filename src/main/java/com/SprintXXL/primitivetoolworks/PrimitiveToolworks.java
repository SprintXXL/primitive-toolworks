package com.SprintXXL.primitivetoolworks;

import com.SprintXXL.primitivetoolworks.client.handler.GuiHandler;
import com.SprintXXL.primitivetoolworks.library.materials.registry.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.network.PacketSelectStencilPattern;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.logic.PartValidation;
import com.SprintXXL.primitivetoolworks.library.patterns.registry.PatternRegistry;
import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.tileentities.TileEntityPartBuilder;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.tileentities.TileEntityStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tools.types.ToolTypeRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import static com.SprintXXL.primitivetoolworks.Reference.MODID;

@Mod(modid = MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = "required-after:primitivetools")
public class PrimitiveToolworks {

    @Mod.Instance
    public static PrimitiveToolworks INSTANCE;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        PartRegistry.init();
        MaterialRegistry.init();
        PatternRegistry.init();
        ToolTypeRegistry.init();
        PartValidation.init();

        NETWORK.registerMessage(
                PacketSelectStencilPattern.Handler.class,
                PacketSelectStencilPattern.class,
                0,
                Side.SERVER
        );
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());

        GameRegistry.registerTileEntity(TileEntityStencilTable.class, new ResourceLocation(MODID, "stencil_table"));

        GameRegistry.registerTileEntity(TileEntityPartBuilder.class, new ResourceLocation(MODID, "part_builder"));
    }

    public static final SimpleNetworkWrapper NETWORK =
            NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
}
