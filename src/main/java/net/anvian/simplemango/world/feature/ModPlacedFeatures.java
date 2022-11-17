package net.anvian.simplemango.world.feature;

import net.anvian.simplemango.SimpleMangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SimpleMangoMod.MOD_ID);

public static final RegistryObject<PlacedFeature> MANGO_CHECKED = PLACED_FEATURES.register("mango_checked",
        () -> new PlacedFeature(ModConfiguredFeatures.MANGO_TREE.getHolder().get(),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MANGO_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MANGO_PLACED = PLACED_FEATURES.register("mango_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MANGO_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.2f, 1))));

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
