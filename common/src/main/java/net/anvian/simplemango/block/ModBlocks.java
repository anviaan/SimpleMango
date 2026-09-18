package net.anvian.simplemango.block;

import net.anvian.simplemango.block.custom.MangoButtonBlock;
import net.anvian.simplemango.block.custom.MangoDoorBlock;
import net.anvian.simplemango.block.custom.MangoFlammableBlock;
import net.anvian.simplemango.block.custom.MangoFlammableFenceBlock;
import net.anvian.simplemango.block.custom.MangoFlammableFenceGateBlock;
import net.anvian.simplemango.block.custom.MangoFlammableLeavesBlock;
import net.anvian.simplemango.block.custom.MangoFlammablePillarBlock;
import net.anvian.simplemango.block.custom.MangoFlammableSlabBlock;
import net.anvian.simplemango.block.custom.MangoFlammableStairBlock;
import net.anvian.simplemango.block.custom.MangoPressurePlateBlock;
import net.anvian.simplemango.block.custom.MangoSaplingBlock;
import net.anvian.simplemango.block.custom.MangoTrapDoorBlock;
import net.anvian.simplemango.world.features.tree.MangoSaplingGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.anvian.simplemango.wood.ModWoodTypes;

public final class ModBlocks {
    public static Block BLOCKOFMANGO;
    public static Block MANGO_LOG;
    public static Block MANGO_WOOD;
    public static Block STRIPPED_MANGO_LOG;
    public static Block STRIPPED_MANGO_WOOD;
    public static Block MANGO_PLANKS;
    public static Block MANGO_STAIR;
    public static Block MANGO_SLAB;
    public static Block MANGO_FENCE;
    public static Block MANGO_FENCE_GATE;
    public static Block MANGO_BUTTON;
    public static Block MANGO_PRESSURE_PLATE;
    public static Block MANGO_DOOR;
    public static Block MANGO_TRAPDOOR;
    public static Block MANGO_LEAVES;
    public static Block MANGO_SAPLING;
    public static Block MANGO_SIGN;
    public static Block MANGO_WALL_SIGN;

    private static boolean initialized;

    public static void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        BLOCKOFMANGO = new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F, 3.0F));
        MANGO_LOG = new MangoFlammablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG), 5, 5);
        MANGO_WOOD = new MangoFlammablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD), 5, 5);
        STRIPPED_MANGO_LOG =
                new MangoFlammablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG), 5, 5);
        STRIPPED_MANGO_WOOD =
                new MangoFlammablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD), 5, 5);
        MANGO_PLANKS = new MangoFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5);
        MANGO_STAIR = new MangoFlammableStairBlock(
                MANGO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5);
        MANGO_SLAB = new MangoFlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5);
        MANGO_FENCE = new MangoFlammableFenceBlock(
                BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(2.0F, 2.0F), 20, 5);
        MANGO_FENCE_GATE = new MangoFlammableFenceGateBlock(
                BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(2.0F, 2.0F), 20, 5);
        MANGO_BUTTON = new MangoButtonBlock(
                BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(1.0F, 2.0F));
        MANGO_PRESSURE_PLATE = new MangoPressurePlateBlock(
                MangoPressurePlateBlock.Sensitivity.EVERYTHING,
                BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(2.0F, 2.0F));
        MANGO_DOOR = new MangoDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                .strength(2.0F, 2.0F)
                .noOcclusion());
        MANGO_TRAPDOOR = new MangoTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
                .strength(1.5F, 2.0F)
                .noOcclusion());
        MANGO_LEAVES = new MangoFlammableLeavesBlock(
                BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion(), 30, 60);
        MANGO_SAPLING =
                new MangoSaplingBlock(new MangoSaplingGenerator(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING));
        MANGO_SIGN = new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MANGO);
        MANGO_WALL_SIGN = new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MANGO);
        MangoSignBlockEntitySupport.register(MANGO_SIGN, MANGO_WALL_SIGN);
    }

    private ModBlocks() {}
}
