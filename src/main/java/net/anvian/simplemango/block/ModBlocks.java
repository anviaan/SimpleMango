package net.anvian.simplemango.block;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.world.features.tree.MangoSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModBlocks {

    //mangoblock
    public static final Block BLOCKOFMANGO = registerBlock("blockofmango",
            new Block(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).strength(2.0f, 3.0f)));

    //logs
    public static final Block MANGO_LOG = registerBlock("mango_log",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block MANGO_WOOD = registerBlock("mango_wood",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block STRIPPED_MANGO_WOOD = registerBlock("stripped_mango_wood",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block MANGO_PLANKS = registerBlock("mango_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    //stair
    public static final Block MANGO_STAIR = registerBlock("mango_stair",
            new StairsBlock(ModBlocks.MANGO_PLANKS.getDefaultState(),
                    FabricBlockSettings.create().strength(2.0f, 3.0f)
                           .sounds(BlockSoundGroup.WOOD).burnable()));

    //slab
    public static final Block MANGO_SLAB = registerBlock("mango_slab",
            new SlabBlock(FabricBlockSettings.create().strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD).burnable()));

    //fences
    public static final Block MANGO_FENCE = registerBlock("mango_fence",
            new FenceBlock(FabricBlockSettings.create().strength(2.0f, 2.0f)
                    .sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            new FenceGateBlock(FabricBlockSettings.create().burnable().strength(2.0f, 3.0f), WoodType.OAK));

    //button
    public static final Block MANGO_BUTTON = registerBlock("mango_button",
            new ButtonBlock(FabricBlockSettings.create().burnable().noCollision().strength(0.5f), BlockSetType.OAK, 30, true));

    //pressure_plate
    public static final Block MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.create().burnable().noCollision().strength(0.5f), BlockSetType.OAK));

    //door
    public static final Block MANGO_DOOR = registerBlock("mango_door",
            new DoorBlock(FabricBlockSettings.create().burnable().strength(3.0f).nonOpaque(),  BlockSetType.OAK));
    //trapdoor
    public static final Block MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.OAK_TAN).strength(3.0f).nonOpaque().allowsSpawning(ModBlocks::never),  BlockSetType.OAK));

    //leaves
    public static final Block MANGO_LEAVES = registerBlock("mango_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    //sapling
    public static final Block MANGO_SAPLING = registerBlockWithoutItem("mango_sapling",
            new SaplingBlock(new MangoSaplingGenerator(),
                    FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type){
        return false;
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MangoMod.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MangoMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MangoMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(MangoMod.MANGO).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + MangoMod.MOD_ID);
    }
}
