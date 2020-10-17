package net.cwcdev.mcmods.apparatus_craft.client;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.cwcdev.mcmods.apparatus_craft.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ApparatusCraft.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		// Rubber Tree
		RenderTypeLookup.setRenderLayer(ModBlocks.RUBBER_TREE_LOG_TRIMMED.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.RUBBER_TREE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.RUBBER_TREE_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.RUBBER_TREE_DOOR.get(), RenderType.getCutout());
	}
}
