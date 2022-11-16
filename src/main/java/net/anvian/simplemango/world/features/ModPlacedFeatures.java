package net.anvian.simplemango.world.features;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> MANGO_PLACED = PlacedFeatures.register("mango_placed",
            ModConfiguredFeatures.MANGO_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.2f, 1)));
}
