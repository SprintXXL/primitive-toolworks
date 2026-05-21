package com.SprintXXL.primitivetoolworks;

import com.SprintXXL.primitivetoolworks.common.gui.GuiHandler;
import com.SprintXXL.primitivetoolworks.common.materials.MaterialRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.PartRegistry;
import com.SprintXXL.primitivetoolworks.common.parts.helpers.PartValidation;
import com.SprintXXL.primitivetoolworks.common.patterns.PatternRegistry;
import com.SprintXXL.primitivetoolworks.common.tools.types.ToolTypeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = "required-after:primitivetools")
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
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
    }
}
