package net.cwcdev.mcmods.apparatus_craft;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.cwcdev.mcmods.apparatus_craft.init.ModBlocks;
import net.cwcdev.mcmods.apparatus_craft.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = ApparatusCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		//event.getRegistry().registerAll(
		//		setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "machine_frame")
		//);
	}

	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		//event.getRegistry().registerAll(
		//	setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "machine_frame")
		//);

		ModBlocks.BLOCKS.register("machine_frame", () -> ModBlocks.MACHINE_FRAME.get());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(ApparatusCraft.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
}
