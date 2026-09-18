package net.anvian.simplemango.forge;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.entity.MangoBoat;
import net.anvian.simplemango.entity.MangoChestBoat;
import net.anvian.simplemango.forge.loot.ModLootModifiers;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.anvian.simplemango.world.features.ModPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod(MangoMod.MOD_ID)
public final class MangoModForge {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MangoMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MangoMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MangoMod.MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MangoMod.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MangoMod.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGO_TREE =
            CONFIGURED_FEATURES.register("mango_tree", ModConfiguredFeatures::createMangoTree);
    public static final RegistryObject<PlacedFeature> MANGO_CHECKED = PLACED_FEATURES.register(
            "mango_checked",
            () -> ModPlacedFeatures.createMangoChecked(MANGO_TREE.getHolder().get()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGO_SPAWN = CONFIGURED_FEATURES.register(
            "mango_spawn",
            () -> ModConfiguredFeatures.createMangoSpawn(
                    MANGO_CHECKED.getHolder().get()));
    public static final RegistryObject<PlacedFeature> MANGO_PLACED = PLACED_FEATURES.register(
            "mango_placed",
            () -> ModPlacedFeatures.createMangoPlaced(MANGO_SPAWN.getHolder().get()));
    public static final RegistryObject<EntityType<MangoBoat>> MANGO_BOAT = ENTITY_TYPES.register(
            "mango_boat",
            () -> EntityType.Builder.<MangoBoat>of(MangoBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10)
                    .build(MangoMod.MOD_ID + ":mango_boat"));
    public static final RegistryObject<EntityType<MangoChestBoat>> MANGO_CHEST_BOAT = ENTITY_TYPES.register(
            "mango_chest_boat",
            () -> EntityType.Builder.<MangoChestBoat>of(MangoChestBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10)
                    .build(MangoMod.MOD_ID + ":mango_chest_boat"));

    public MangoModForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        MangoMod.init();
        registerBlocks();
        registerItems();
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        ENTITY_TYPES.register(modBus);
        CONFIGURED_FEATURES.register(modBus);
        PLACED_FEATURES.register(modBus);
        ModLootModifiers.register(modBus);
        modBus.addListener(ForgeEvents::registerCompostables);
        MinecraftForge.EVENT_BUS.register(ForgeEvents.class);
    }

    private static void registerBlock(String name, Supplier<Block> block) {
        BLOCKS.register(name, () -> {
            ModBlocks.init();
            return block.get();
        });
    }

    private static void registerItem(String name, Supplier<Item> item) {
        ITEMS.register(name, () -> {
            ModItems.init();
            return item.get();
        });
    }

    private void registerBlocks() {
        registerBlock("blockofmango", () -> ModBlocks.BLOCKOFMANGO);
        registerBlock("mango_log", () -> ModBlocks.MANGO_LOG);
        registerBlock("mango_wood", () -> ModBlocks.MANGO_WOOD);
        registerBlock("stripped_mango_log", () -> ModBlocks.STRIPPED_MANGO_LOG);
        registerBlock("stripped_mango_wood", () -> ModBlocks.STRIPPED_MANGO_WOOD);
        registerBlock("mango_planks", () -> ModBlocks.MANGO_PLANKS);
        registerBlock("mango_stair", () -> ModBlocks.MANGO_STAIR);
        registerBlock("mango_slab", () -> ModBlocks.MANGO_SLAB);
        registerBlock("mango_fence", () -> ModBlocks.MANGO_FENCE);
        registerBlock("mango_fence_gate", () -> ModBlocks.MANGO_FENCE_GATE);
        registerBlock("mango_button", () -> ModBlocks.MANGO_BUTTON);
        registerBlock("mango_pressure_plate", () -> ModBlocks.MANGO_PRESSURE_PLATE);
        registerBlock("mango_door", () -> ModBlocks.MANGO_DOOR);
        registerBlock("mango_trapdoor", () -> ModBlocks.MANGO_TRAPDOOR);
        registerBlock("mango_leaves", () -> ModBlocks.MANGO_LEAVES);
        registerBlock("mango_sapling", () -> ModBlocks.MANGO_SAPLING);
        registerBlock("mango_sign", () -> ModBlocks.MANGO_SIGN);
        registerBlock("mango_wall_sign", () -> ModBlocks.MANGO_WALL_SIGN);
    }

    private void registerItems() {
        registerItem("blockofmango", () -> ModItems.BLOCKOFMANGO);
        registerItem("mango_log", () -> ModItems.MANGO_LOG);
        registerItem("mango_wood", () -> ModItems.MANGO_WOOD);
        registerItem("stripped_mango_log", () -> ModItems.STRIPPED_MANGO_LOG);
        registerItem("stripped_mango_wood", () -> ModItems.STRIPPED_MANGO_WOOD);
        registerItem("mango_planks", () -> ModItems.MANGO_PLANKS);
        registerItem("mango_stair", () -> ModItems.MANGO_STAIR);
        registerItem("mango_slab", () -> ModItems.MANGO_SLAB);
        registerItem("mango_fence", () -> ModItems.MANGO_FENCE);
        registerItem("mango_fence_gate", () -> ModItems.MANGO_FENCE_GATE);
        registerItem("mango_button", () -> ModItems.MANGO_BUTTON);
        registerItem("mango_pressure_plate", () -> ModItems.MANGO_PRESSURE_PLATE);
        registerItem("mango_door", () -> ModItems.MANGO_DOOR);
        registerItem("mango_trapdoor", () -> ModItems.MANGO_TRAPDOOR);
        registerItem("mango_leaves", () -> ModItems.MANGO_LEAVES);
        registerItem("mango_sapling", () -> ModItems.MANGO_SAPLING);
        registerItem("mango_sign", () -> ModItems.MANGO_SIGN);
        registerItem("mango_boat", () -> ModItems.MANGO_BOAT);
        registerItem("mango_chest_boat", () -> ModItems.MANGO_CHEST_BOAT);
        registerItem("mango", () -> ModItems.MANGO);
        registerItem("seed", () -> ModItems.SEED);
        registerItem("mango_seed_helmet", () -> ModItems.MANGO_SEED_HELMET);
        registerItem("golden_mango", () -> ModItems.GOLDEN_MANGO);
        registerItem("enchanted_golden_mango", () -> ModItems.ENCHANTED_GOLDEN_MANGO);
    }
}
