package net.cwcdev.mcmods.apparatus_craft.init;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.AlwaysTrueRuleTest;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ModOres {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void generateOverworldOres(BiomeLoadingEvent evt) {
        switch(evt.getCategory()) {
            case NETHER:
            case THEEND:
            case NONE:
                break;
            default:
                // Bauxite
                evt.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.BAUXITE);

                // SILICON_ORE
                //OreFeatureConfig siliconOreFeatureConfig = new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE), ModBlocks.SILICON_ORE.get().getDefaultState(), 6);
                //evt.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.SILICON_ORE.get().withConfiguration(siliconOreFeatureConfig).func_242733_d(64).func_242728_a().func_242731_b(20));
                evt.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.SILICON_ORE);

                // ALUMINUM_ORE
                //OreFeatureConfig aluminumOreFeatureConfig = new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE), ModBlocks.ALUMINUM_ORE.get().getDefaultState(), 6);
                //evt.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.ALUMINUM_ORE.get().withConfiguration(aluminumOreFeatureConfig).func_242733_d(64).func_242728_a().func_242731_b(20));
                evt.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.ALUMINNUM_ORE);

        }
    }
}
