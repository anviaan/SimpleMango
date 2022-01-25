package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> MANGO_TREE =
            register("cherry_blossom", Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.MANGO_LOG),
                    new StraightTrunkPlacer(3, 4, 2),
                    BlockStateProvider.of(ModBlocks.MANGO_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final ConfiguredFeature<RandomFeatureConfig, ?> MANGO_TREE_RANDOM = register("cherry_blossom_feature",
            Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                    MANGO_TREE.withWouldSurviveFilter(ModBlocks.MANGO_SAPLING), 0.1f)),
                    MANGO_TREE.withWouldSurviveFilter(ModBlocks.MANGO_SAPLING))));



    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MangoMod.MOD_ID, name),
                configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MangoMod.MOD_ID);
    }
}
