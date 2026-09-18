package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MANGO_CHECKED_KEY = key("mango_checked");
    public static final ResourceKey<PlacedFeature> MANGO_PLACED_KEY = key("mango_placed");

    private ModPlacedFeatures() {}

    public static PlacedFeature createMangoChecked(Holder<ConfiguredFeature<?, ?>> mangoTree) {
        return new PlacedFeature(
                mangoTree, java.util.List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING)));
    }

    public static PlacedFeature createMangoPlaced(Holder<ConfiguredFeature<?, ?>> mangoSpawn) {
        return new PlacedFeature(mangoSpawn, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    }

    private static ResourceKey<PlacedFeature> key(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(MangoMod.MOD_ID, name));
    }
}
