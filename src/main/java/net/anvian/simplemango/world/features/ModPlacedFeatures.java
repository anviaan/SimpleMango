package net.anvian.simplemango.world.features;

import net.anvian.simplemango.MangoMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MANGO_PLACED_KEY = registerKey("cherry_blossom_placed");

    public static final PlacedFeature MANGO_PLACED = registerPlacedFeature("cherry_blossom_placed",
            ModConfiguredFeatures.MANGO_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.2f, 3))));



    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MangoMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MangoMod.MOD_ID, name));
    }
}
