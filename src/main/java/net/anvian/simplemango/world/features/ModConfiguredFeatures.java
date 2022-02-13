package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MANGO_TREE_KEY = registerKey("mango_spawn");

    public static final ConfiguredFeature<TreeFeatureConfig, ?> MANGO_TREE = register("mango",
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.MANGO_LOG.getDefaultState()),
                    new StraightTrunkPlacer(3, 4, 2),
                    new SimpleBlockStateProvider(ModBlocks.MANGO_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.MANGO_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final ConfiguredFeature<?, ?> MANGO_TREE_SPAWN = register(MANGO_TREE
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                    .spreadHorizontally().applyChance(3)), MANGO_TREE_KEY);

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MangoMod.MOD_ID, name));
    }

    private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name,
                                                                    ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MangoMod.MOD_ID, name),
                configuredFeature);
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MangoMod.MOD_ID);
    }
}
