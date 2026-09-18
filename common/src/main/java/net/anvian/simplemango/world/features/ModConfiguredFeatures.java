package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public final class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE_KEY = key("mango_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_SPAWN_KEY = key("mango_spawn");
    private static Holder<? extends ConfiguredFeature<?, ?>> mangoTreeHolder;

    private ModConfiguredFeatures() {}

    public static void setMangoTreeHolder(Holder<? extends ConfiguredFeature<?, ?>> holder) {
        mangoTreeHolder = holder;
    }

    public static Holder<? extends ConfiguredFeature<?, ?>> getMangoTreeHolder() {
        return mangoTreeHolder != null
                ? mangoTreeHolder
                : net.minecraft.data.BuiltinRegistries.CONFIGURED_FEATURE.getHolderOrThrow(MANGO_TREE_KEY);
    }

    public static ConfiguredFeature<?, ?> createMangoTree() {
        return new ConfiguredFeature<>(
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.MANGO_LOG),
                                new StraightTrunkPlacer(5, 3, 1),
                                BlockStateProvider.simple(ModBlocks.MANGO_LEAVES),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                                new TwoLayersFeatureSize(1, 0, 2))
                        .build());
    }

    public static ConfiguredFeature<?, ?> createMangoSpawn(Holder<PlacedFeature> mangoChecked) {
        return new ConfiguredFeature<>(
                Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(mangoChecked, 0.1F)), mangoChecked));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(MangoMod.MOD_ID, name));
    }
}
