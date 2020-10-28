package net.cwcdev.mcmods.apparatus_craft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class SiliconOreBlock extends OreBlock {
	public SiliconOreBlock(AbstractBlock.Properties properties) {
		super(properties);
	}

	@Override
	protected int getExperience(Random rand) {
		return MathHelper.nextInt(rand, 0, 2); // Same experience drop as coal
	}
}
