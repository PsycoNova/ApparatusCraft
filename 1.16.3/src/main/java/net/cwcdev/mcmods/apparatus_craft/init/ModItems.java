package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

//@ObjectHolder(ApparatusCraft.MODID)
public class ModItems {
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ApparatusCraft.MODID);

	// Rubber Tree
	public static final RegistryObject<Item> RUBBER_TREE_LOG = ITEMS.register("rubber_tree_log", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LOG_STRIPPED = ITEMS.register("rubber_tree_log_stripped", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG_STRIPPED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LOG_PARTIALLY_STRIPPED = ITEMS.register("rubber_tree_log_partially_stripped", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG_PARTIALLY_STRIPPED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LEAVES = ITEMS.register("rubber_tree_leaves", () -> new BlockItem(ModBlocks.RUBBER_TREE_LEAVES.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));

	// Misc
	public static final RegistryObject<Item> MACHINE_FRAME = ITEMS.register("machine_frame", () -> new BlockItem(ModBlocks.MACHINE_FRAME.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
}
