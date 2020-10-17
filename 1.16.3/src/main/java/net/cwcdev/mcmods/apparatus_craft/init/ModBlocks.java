package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.cwcdev.mcmods.apparatus_craft.blocks.RubberTreeLeavesBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks {
	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ApparatusCraft.MODID);

	// Rubber Tree
	public static final RegistryObject<Block> RUBBER_TREE_LOG = BLOCKS.register("rubber_tree_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_LOG_STRIPPED = BLOCKS.register("rubber_tree_log_stripped", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_LOG_TRIMMED = BLOCKS.register("rubber_tree_log_trimmed", () -> new Block(Block.Properties.create(Material.WOOD).notSolid()));
	public static final RegistryObject<Block> RUBBER_TREE_WOOD = BLOCKS.register("rubber_tree_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_WOOD_STRIPPED = BLOCKS.register("rubber_tree_wood_stripped", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_LEAVES = BLOCKS.register("rubber_tree_leaves", () -> new RubberTreeLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
	public static final RegistryObject<Block> RUBBER_TREE_PLANK = BLOCKS.register("rubber_tree_plank", () -> new Block(Block.Properties.create(Material.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_SAPLING = BLOCKS.register("rubber_tree_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RUBBER_TREE_SAPLING_POTTED = BLOCKS.register("rubber_tree_sapling_potted", () -> new FlowerPotBlock(RUBBER_TREE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));  // fix this - Deprecated Block Constructor
	public static final RegistryObject<Block> RUBBER_TREE_STAIRS = BLOCKS.register("rubber_tree_stairs", () -> new StairsBlock(RUBBER_TREE_PLANK.get().getDefaultState(), AbstractBlock.Properties.from(RUBBER_TREE_PLANK.get()))); // fix this - Deprecated Block Constructor
	public static final RegistryObject<Block> RUBBER_TREE_SIGN = BLOCKS.register("rubber_tree_sign", () -> new StandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.OAK)); // fix this - What's WoodType used for..?  The enums not protected so I can't just extend the class.
	public static final RegistryObject<Block> RUBBER_TREE_WALL_SIGN = BLOCKS.register("rubber_tree_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(RUBBER_TREE_SIGN.get()), WoodType.OAK));  // fix this - What's WoodType used for..?  The enums not protected so I can't just extend the class.
	public static final RegistryObject<Block> RUBBER_TREE_DOOR = BLOCKS.register("rubber_tree_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, RUBBER_TREE_PLANK.get().func_235697_s_()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> RUBBER_TREE_PRESSURE_PLATE = BLOCKS.register("rubber_tree_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, RUBBER_TREE_PLANK.get().func_235697_s_()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_FENCE = BLOCKS.register("rubber_tree_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD, RUBBER_TREE_PLANK.get().func_235697_s_()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_TRAPDOOR = BLOCKS.register("rubber_tree_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid())); // can't access .func_235827_a_(Blocks::func_235427_a_) on properties builder
	public static final RegistryObject<Block> RUBBER_TREE_FENCE_GATE = BLOCKS.register("rubber_tree_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD, RUBBER_TREE_PLANK.get().func_235697_s_()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_BUTTON = BLOCKS.register("rubber_tree_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_TREE_SLAB = BLOCKS.register("rubber_tree_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	// Silicon
	public static final RegistryObject<Block> SILICON_ORE = BLOCKS.register("silicon_ore", () -> new Block(Block.Properties.create(Material.ROCK)));


	// Misc
	public static final RegistryObject<Block> MACHINE_FRAME = BLOCKS.register("machine_frame", () -> new Block(Block.Properties.create(Material.ROCK)));
}
