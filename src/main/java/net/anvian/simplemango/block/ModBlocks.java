package net.anvian.simplemango.block;

import net.anvian.simplemango.SimpleMangoMod;
import net.anvian.simplemango.block.custom.ModFlammableRotadedPillarBlock;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.feature.tree.MangoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleMangoMod.MOD_ID);

    public static final RegistryObject<Block> BLOCKOFMANGO = registerBlock("blockofmango",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0f, 3.0f)));
    //logs
    public static final RegistryObject<Block> MANGO_LOG  = registerBlock("mango_log",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MANGO_WOOD   = registerBlock("mango_wood",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MANGO_LOG  = registerBlock("stripped_mango_log",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MANGO_WOOD  = registerBlock("stripped_mango_wood",
            () -> new ModFlammableRotadedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
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
            });
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
            });

    //sapling
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            () -> new SaplingBlock(new MangoTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT)
                    .noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    //stairs
    public static final RegistryObject<Block> MANGO_STAIR = registerBlock("mango_stair",
            () -> new StairBlock(() -> ModBlocks.MANGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    //slab
    public static final RegistryObject<Block> MANGO_SLAB = registerBlock("mango_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    //fence
    public static final RegistryObject<Block> MANGO_FENCE = registerBlock("mango_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD),
                    SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    //button
    public static final RegistryObject<Block> MANGO_BUTTON = registerBlock("mango_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD),30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
    //pressure_plate
    public static final RegistryObject<Block> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .noCollission().strength(0.5F).sound(SoundType.WOOD),
                    SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
    //door
    public static final RegistryObject<Block> MANGO_DOOR = registerBlock("mango_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(),
                    SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    //trapdoor
    public static final RegistryObject<Block> MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F)
                    .sound(SoundType.WOOD).noOcclusion().isValidSpawn(ModBlocks::never),
                    SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
