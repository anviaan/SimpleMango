package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MANGO_TREE =
            ConfiguredFeatures.register("mango_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.MANGO_LOG),
                    new StraightTrunkPlacer(3, 4, 2),
                    BlockStateProvider.of(ModBlocks.MANGO_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> MANGO_CHECKED =
            PlacedFeatures.register("mango_checked", ModConfiguredFeatures.MANGO_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.MANGO_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>>MANGO_SPAWN =
            ConfiguredFeatures.register("mango_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MANGO_CHECKED, 0.1f)), MANGO_CHECKED));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MangoMod.MOD_ID);
    }
}
