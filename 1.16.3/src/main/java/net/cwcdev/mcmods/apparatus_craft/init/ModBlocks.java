package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.cwcdev.mcmods.apparatus_craft.blocks.RubberTreeLeavesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

//@ObjectHolder(ApparatusCraft.MODID)
public final class ModBlocks {
	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ApparatusCraft.MODID);

	// Rubber Tree
	public static final RegistryObject<Block> RUBBER_TREE_LOG = BLOCKS.register("rubber_tree_log", () -> new Block(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_LOG_STRIPPED = BLOCKS.register("rubber_tree_log_stripped", () -> new Block(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_LOG_PARTIALLY_STRIPPED = BLOCKS.register("rubber_tree_log_partially_stripped", () -> new Block(Block.Properties.create(Material.WOOD)));
	//public static final RegistryObject<Block> RUBBER_TREE_LEAVES = BLOCKS.register("rubber_tree_leaves", () -> new Block(Block.Properties.create(Material.LEAVES)));
	public static final RegistryObject<Block> RUBBER_TREE_LEAVES = BLOCKS.register("rubber_tree_leaves", () -> new RubberTreeLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final RegistryObject<Block> RUBBER_TREE_PLANK = BLOCKS.register("rubber_tree_plank", () -> new Block(Block.Properties.create(Material.WOOD)));

	// Misc
	public static final RegistryObject<Block> MACHINE_FRAME = BLOCKS.register("machine_frame", () -> new Block(Block.Properties.create(Material.ROCK)));
}
