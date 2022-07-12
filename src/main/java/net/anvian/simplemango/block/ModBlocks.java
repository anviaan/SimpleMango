package net.anvian.simplemango.block;

import net.anvian.simplemango.SimpleMangoMod;
import net.anvian.simplemango.block.custom.ModFlammableRotadedPillarBlock;
import net.anvian.simplemango.item.MangoItemGroup;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.feature.tree.MangoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleMangoMod.MOD_ID);

    public static final RegistryObject<Block> BLOCKOFMANGO = registerBlock("blockofmango",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(0.5f)),
            MangoItemGroup.MANGO);
    //logs
    public static final RegistryObject<Block> MANGO_LOG  = registerBlock("mango_log",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            MangoItemGroup.MANGO);
    public static final RegistryObject<Block> MANGO_WOOD   = registerBlock("mango_wood",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            MangoItemGroup.MANGO);
    public static final RegistryObject<Block> STRIPPED_MANGO_LOG  = registerBlock("stripped_mango_log",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            MangoItemGroup.MANGO);
    public static final RegistryObject<Block> STRIPPED_MANGO_WOOD  = registerBlock("stripped_mango_wood",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            MangoItemGroup.MANGO);
    //plank
    public static final RegistryObject<Block> MANGO_PLANKS = registerBlock("mango_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, MangoItemGroup.MANGO);
    //leaves
    public static final RegistryObject<Block> MANGO_LEAVES  = registerBlock("mango_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, MangoItemGroup.MANGO);

    //sapling
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            () -> new SaplingBlock(new MangoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            MangoItemGroup.MANGO);

    //stairs
    public static final RegistryObject<Block> MANGO_STAIR = registerBlock("mango_stair",
            () -> new StairBlock(() -> ModBlocks.MANGO_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops()),
            MangoItemGroup.MANGO);
    //slab
    public static final RegistryObject<Block> MANGO_SLAB = registerBlock("mango_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), MangoItemGroup.MANGO);
    //fence
    public static final RegistryObject<Block> MANGO_FENCE = registerBlock("mango_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), MangoItemGroup.MANGO);
    public static final RegistryObject<Block> MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), MangoItemGroup.MANGO);
    //button
    public static final RegistryObject<Block> MANGO_BUTTON = registerBlock("mango_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops().noCollission()), MangoItemGroup.MANGO);
    //pressure_plate
    public static final RegistryObject<Block> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), MangoItemGroup.MANGO);
    //door
    public static final RegistryObject<Block> MANGO_DOOR = registerBlock("mango_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), MangoItemGroup.MANGO);
    //trapdoor
    public static final RegistryObject<Block> MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), MangoItemGroup.MANGO);
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
