package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@ObjectHolder(ApparatusCraft.MOD_ID)
public class ModItems {
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ApparatusCraft.MOD_ID);

	// Rubber Tree
	public static final RegistryObject<Item> RUBBER_TREE_LOG = ITEMS.register("rubber_tree_log", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LOG_STRIPPED = ITEMS.register("rubber_tree_log_stripped", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG_STRIPPED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LOG_TRIMMED = ITEMS.register("rubber_tree_log_trimmed", () -> new BlockItem(ModBlocks.RUBBER_TREE_LOG_TRIMMED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_WOOD = ITEMS.register("rubber_tree_wood", () -> new BlockItem(ModBlocks.RUBBER_TREE_WOOD.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_WOOD_STRIPPED = ITEMS.register("rubber_tree_wood_stripped", () -> new BlockItem(ModBlocks.RUBBER_TREE_WOOD_STRIPPED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_LEAVES = ITEMS.register("rubber_tree_leaves", () -> new BlockItem(ModBlocks.RUBBER_TREE_LEAVES.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_PLANK = ITEMS.register("rubber_tree_plank", () -> new BlockItem(ModBlocks.RUBBER_TREE_PLANK.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_SAPLING = ITEMS.register("rubber_tree_sapling", () -> new BlockItem(ModBlocks.RUBBER_TREE_SAPLING.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_SAPLING_POTTED = ITEMS.register("rubber_tree_sapling_potted", () -> new BlockItem(ModBlocks.RUBBER_TREE_SAPLING_POTTED.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_STAIRS = ITEMS.register("rubber_tree_stairs", () -> new BlockItem(ModBlocks.RUBBER_TREE_STAIRS.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_SIGN = ITEMS.register("rubber_tree_sign", () -> new BlockItem(ModBlocks.RUBBER_TREE_SIGN.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_DOOR = ITEMS.register("rubber_tree_door", () -> new BlockItem(ModBlocks.RUBBER_TREE_DOOR.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_PRESSURE_PLATE = ITEMS.register("rubber_tree_pressure_plate", () -> new BlockItem(ModBlocks.RUBBER_TREE_PRESSURE_PLATE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_FENCE = ITEMS.register("rubber_tree_fence", () -> new BlockItem(ModBlocks.RUBBER_TREE_FENCE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_TRAPDOOR = ITEMS.register("rubber_tree_trapdoor", () -> new BlockItem(ModBlocks.RUBBER_TREE_TRAPDOOR.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_FENCE_GATE = ITEMS.register("rubber_tree_fence_gate", () -> new BlockItem(ModBlocks.RUBBER_TREE_FENCE_GATE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_BUTTON = ITEMS.register("rubber_tree_button", () -> new BlockItem(ModBlocks.RUBBER_TREE_BUTTON.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_SLAB = ITEMS.register("rubber_tree_slab", () -> new BlockItem(ModBlocks.RUBBER_TREE_SLAB.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBBER_TREE_BOAT = ITEMS.register("rubber_tree_boat", () -> new BoatItem(BoatEntity.Type.OAK, (new Item.Properties()).maxStackSize(1).group(ModItemGroups.MOD_ITEM_GROUP))); // fix this - Is BoatEntity.Type.OAK okay to use?

	// Blocks & Ores
	public static final RegistryObject<Item> SILICON_ORE = ITEMS.register("silicon_ore", () -> new BlockItem(ModBlocks.SILICON_ORE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", () -> new BlockItem(ModBlocks.BAUXITE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_ORE = ITEMS.register("aluminum_ore", () -> new BlockItem(ModBlocks.ALUMINUM_ORE.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));

	// Dust, Ingots, Minerals, Gems
	public static final RegistryObject<Item> SILICON = ITEMS.register("silicon", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_DUST_DIRTY = ITEMS.register("aluminum_dust_dirty", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));

	// Misc
	public static final RegistryObject<Item> POOP = ITEMS.register("poop", () -> new Item((new Item.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> MACHINE_FRAME = ITEMS.register("machine_frame", () -> new BlockItem(ModBlocks.MACHINE_FRAME.get(), (new BlockItem.Properties()).group(ModItemGroups.MOD_ITEM_GROUP)));
}
