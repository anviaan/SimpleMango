package net.anvian.simplemango.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> MANGO_PLACED = PlacementUtils.register("mango_placed",
            ModConfiguredFeatures.MANGO_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.2f, 1)));
}
