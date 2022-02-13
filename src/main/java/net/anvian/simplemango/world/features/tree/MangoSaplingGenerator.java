package net.anvian.simplemango.world.features.tree;

import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MangoSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.MANGO_TREE;
    }
}
