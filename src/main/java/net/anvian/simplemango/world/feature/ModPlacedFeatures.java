package net.anvian.simplemango.world.feature;

import net.anvian.simplemango.SimpleMangoMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SimpleMangoMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> MANGO_PLACED = PLACED_FEATURE.register("mango_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.MANGO_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(2, 0.2f, 3))));

    public static void register(IEventBus eventBus){
        PLACED_FEATURE.register(eventBus);
    }
}
