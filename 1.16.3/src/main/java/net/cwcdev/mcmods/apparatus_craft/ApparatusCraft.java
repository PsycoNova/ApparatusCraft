package net.cwcdev.mcmods.apparatus_craft;

import com.mojang.brigadier.CommandDispatcher;
import net.cwcdev.mcmods.apparatus_craft.commands.ModCommandSide;
import net.cwcdev.mcmods.apparatus_craft.init.*;
import net.minecraft.command.CommandSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("apparatus_craft")
public class ApparatusCraft
{
    public static final String MOD_ID = "apparatus_craft";

    private static final Logger LOGGER = LogManager.getLogger();

    // Testing Settings
    public static final boolean IS_DEV = true;
    public static final int DEV_VERBOSITY = 0;

    public ApparatusCraft() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        // Register ModBlocks
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ModItems
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register Features
        //ModFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());


        // Register Ores
        forgeBus.addListener(EventPriority.HIGH, ModOres::generateOverworldOres);

        // Register Commands
        forgeBus.addListener(EventPriority.HIGH, this::registerClientCommands);
        forgeBus.addListener(EventPriority.HIGH, this::registerServerCommands);


        /*
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        */
    }

	@SubscribeEvent
    public void registerClientCommands(final FMLServerStartingEvent evt) {
        CommandDispatcher<CommandSource> dispatcher = evt.getServer().getCommandManager().getDispatcher();
        ModCommands.register(dispatcher, ModCommandSide.SERVER_ONLY);
    }

    @SubscribeEvent
    public void registerServerCommands(final RegisterCommandsEvent evt) {
        CommandDispatcher<CommandSource> dispatcher = evt.getDispatcher();
        ModCommands.register(dispatcher, ModCommandSide.CLIENT_ONLY);
    }

    /*
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("apparatus_craft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }
    }
    */
}
