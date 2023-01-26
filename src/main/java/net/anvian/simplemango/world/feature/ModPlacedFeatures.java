package net.anvian.simplemango.world.feature;

import net.anvian.simplemango.SimpleMangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MANGO_TREE_CHECKED_KEY = createKey("mango_tree_checked");
    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY  = createKey("mango_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MANGO_TREE_CHECKED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MANGO_KEY),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING.get())));
        register(context, MANGO_TREE_PLACED_KEY , configuredFeatures.getOrThrow(ModConfiguredFeatures.MANGO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2f, 1)));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SimpleMangoMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
