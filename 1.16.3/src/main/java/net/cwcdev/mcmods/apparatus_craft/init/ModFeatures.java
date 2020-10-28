package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: IMPORTANT! - Figure out the proper way to handle Features with a DeferredRegistry.. feels like the current implementation is a bit of a hack.

public class ModFeatures {
	private static final Logger LOGGER = LogManager.getLogger();

	//public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ApparatusCraft.MOD_ID);
	//public static final RegistryObject<Feature<OreFeatureConfig>> SILICON_ORE = FEATURES.register("silicon_ore", () -> new SiliconOreFeature(OreFeatureConfig.field_236566_a_));

	public static final ConfiguredFeature<?, ?> BAUXITE = createConfiguredFeature("bauxite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.BAUXITE.get().getDefaultState(), 33)).func_242733_d(80).func_242728_a().func_242731_b(10));

	//public static final ConfiguredFeature<?, ?> SILICON_ORE = createConfiguredFeature("silicon_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ModBlocks.SILICON_ORE.get().getDefaultState(), 4)).func_242733_d(32).func_242728_a().func_242731_b(2));
	public static final ConfiguredFeature<?, ?> SILICON_ORE = createConfiguredFeature("silicon_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE), ModBlocks.SILICON_ORE.get().getDefaultState(), 9)).func_242733_d(64).func_242728_a().func_242731_b(20));
	public static final ConfiguredFeature<?, ?> ALUMINNUM_ORE = createConfiguredFeature("aluminum_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(ModBlocks.BAUXITE.get()), ModBlocks.ALUMINUM_ORE.get().getDefaultState(), 9)).func_242733_d(64).func_242728_a().func_242731_b(20));

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> createConfiguredFeature(String nameIn, ConfiguredFeature<FC, ?> featureIn)
	{
		return Registry.register(WorldGenRegistries.field_243653_e, ApparatusCraft.MOD_ID+':'+nameIn, featureIn);
	}
}
