package net.cwcdev.mcmods.apparatus_craft.blocks.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTree extends Tree {
	public static final BaseTreeFeatureConfig RUBBER_TREE_CONFIG = null;/* = (new BaseTreeFeatureConfig.Builder(
		new RubberTreeBlockStateProvider(ModBlocks.RUBBER_LOG.getDefaultState()),
		new SimpleBlockStateProvider(ModBlocks.RUBBER_LEAVES.getDefaultState()),
		new RubberFoliagePlacer(2, 0),
		new StraightTrunkPlacer(4, 2, 0),
		new TwoLayerFeature(1, 0, 1)
	)).build();*/

	@Nullable
	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;//Feature.TREE.withConfiguration(RUBBER_TREE_CONFIG);
	}
}
