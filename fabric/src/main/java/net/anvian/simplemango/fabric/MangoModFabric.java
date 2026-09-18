package net.anvian.simplemango.fabric;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.entity.MangoBoat;
import net.anvian.simplemango.entity.MangoBoatDispenseItemBehavior;
import net.anvian.simplemango.entity.MangoChestBoat;
import net.anvian.simplemango.entity.ModEntities;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.anvian.simplemango.world.features.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class MangoModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MangoMod.init();
        ModBlocks.init();
        registerBlocks();
        registerEntities();
        ModItems.init();
        registerItems();
        registerDispenserBehaviors();
        registerWorldgen();
        registerFlammability();
        registerStrippables();
        registerCompostables();
        registerTrades();
        registerLootTables();
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.MANGO_PLACED_KEY);
    }

    private static void registerBlocks() {
        registerBlock("blockofmango", ModBlocks.BLOCKOFMANGO);
        registerBlock("mango_log", ModBlocks.MANGO_LOG);
        registerBlock("mango_wood", ModBlocks.MANGO_WOOD);
        registerBlock("stripped_mango_log", ModBlocks.STRIPPED_MANGO_LOG);
        registerBlock("stripped_mango_wood", ModBlocks.STRIPPED_MANGO_WOOD);
        registerBlock("mango_planks", ModBlocks.MANGO_PLANKS);
        registerBlock("mango_stair", ModBlocks.MANGO_STAIR);
        registerBlock("mango_slab", ModBlocks.MANGO_SLAB);
        registerBlock("mango_fence", ModBlocks.MANGO_FENCE);
        registerBlock("mango_fence_gate", ModBlocks.MANGO_FENCE_GATE);
        registerBlock("mango_button", ModBlocks.MANGO_BUTTON);
        registerBlock("mango_pressure_plate", ModBlocks.MANGO_PRESSURE_PLATE);
        registerBlock("mango_door", ModBlocks.MANGO_DOOR);
        registerBlock("mango_trapdoor", ModBlocks.MANGO_TRAPDOOR);
        registerBlock("mango_leaves", ModBlocks.MANGO_LEAVES);
        registerBlock("mango_sapling", ModBlocks.MANGO_SAPLING);
        registerBlock("mango_sign", ModBlocks.MANGO_SIGN);
        registerBlock("mango_wall_sign", ModBlocks.MANGO_WALL_SIGN);
    }

    private static void registerEntities() {
        ModEntities.setMangoBoat(Registry.register(
                Registry.ENTITY_TYPE,
                new ResourceLocation(MangoMod.MOD_ID, "mango_boat"),
                EntityType.Builder.<MangoBoat>of(MangoBoat::new, MobCategory.MISC)
                        .sized(1.375F, 0.5625F)
                        .clientTrackingRange(10)
                        .build(MangoMod.MOD_ID + ":mango_boat")));
        ModEntities.setMangoChestBoat(Registry.register(
                Registry.ENTITY_TYPE,
                new ResourceLocation(MangoMod.MOD_ID, "mango_chest_boat"),
                EntityType.Builder.<MangoChestBoat>of(MangoChestBoat::new, MobCategory.MISC)
                        .sized(1.375F, 0.5625F)
                        .clientTrackingRange(10)
                        .build(MangoMod.MOD_ID + ":mango_chest_boat")));
    }

    private static void registerItems() {
        registerItem("blockofmango", ModItems.BLOCKOFMANGO);
        registerItem("mango_log", ModItems.MANGO_LOG);
        registerItem("mango_wood", ModItems.MANGO_WOOD);
        registerItem("stripped_mango_log", ModItems.STRIPPED_MANGO_LOG);
        registerItem("stripped_mango_wood", ModItems.STRIPPED_MANGO_WOOD);
        registerItem("mango_planks", ModItems.MANGO_PLANKS);
        registerItem("mango_stair", ModItems.MANGO_STAIR);
        registerItem("mango_slab", ModItems.MANGO_SLAB);
        registerItem("mango_fence", ModItems.MANGO_FENCE);
        registerItem("mango_fence_gate", ModItems.MANGO_FENCE_GATE);
        registerItem("mango_button", ModItems.MANGO_BUTTON);
        registerItem("mango_pressure_plate", ModItems.MANGO_PRESSURE_PLATE);
        registerItem("mango_door", ModItems.MANGO_DOOR);
        registerItem("mango_trapdoor", ModItems.MANGO_TRAPDOOR);
        registerItem("mango_leaves", ModItems.MANGO_LEAVES);
        registerItem("mango_sapling", ModItems.MANGO_SAPLING);
        registerItem("mango_sign", ModItems.MANGO_SIGN);
        registerItem("mango_boat", ModItems.MANGO_BOAT);
        registerItem("mango_chest_boat", ModItems.MANGO_CHEST_BOAT);
        registerItem("mango", ModItems.MANGO);
        registerItem("seed", ModItems.SEED);
        registerItem("mango_seed_helmet", ModItems.MANGO_SEED_HELMET);
        registerItem("golden_mango", ModItems.GOLDEN_MANGO);
        registerItem("enchanted_golden_mango", ModItems.ENCHANTED_GOLDEN_MANGO);
    }

    private static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ModItems.MANGO_BOAT, new MangoBoatDispenseItemBehavior(false));
        DispenserBlock.registerBehavior(ModItems.MANGO_CHEST_BOAT, new MangoBoatDispenseItemBehavior(true));
    }

    private static void registerWorldgen() {
        Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                ModConfiguredFeatures.MANGO_TREE_KEY.location(),
                ModConfiguredFeatures.createMangoTree());
        ModConfiguredFeatures.setMangoTreeHolder(
                BuiltinRegistries.CONFIGURED_FEATURE.getHolderOrThrow(ModConfiguredFeatures.MANGO_TREE_KEY));
        Registry.register(
                BuiltinRegistries.PLACED_FEATURE,
                ModPlacedFeatures.MANGO_CHECKED_KEY.location(),
                ModPlacedFeatures.createMangoChecked(
                        BuiltinRegistries.CONFIGURED_FEATURE.getHolderOrThrow(ModConfiguredFeatures.MANGO_TREE_KEY)));
        Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                ModConfiguredFeatures.MANGO_SPAWN_KEY.location(),
                ModConfiguredFeatures.createMangoSpawn(
                        BuiltinRegistries.PLACED_FEATURE.getHolderOrThrow(ModPlacedFeatures.MANGO_CHECKED_KEY)));
        Registry.register(
                BuiltinRegistries.PLACED_FEATURE,
                ModPlacedFeatures.MANGO_PLACED_KEY.location(),
                ModPlacedFeatures.createMangoPlaced(
                        BuiltinRegistries.CONFIGURED_FEATURE.getHolderOrThrow(ModConfiguredFeatures.MANGO_SPAWN_KEY)));
    }

    private static void registerFlammability() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(ModBlocks.MANGO_LOG, 5, 5);
        registry.add(ModBlocks.MANGO_PLANKS, 20, 5);
        registry.add(ModBlocks.MANGO_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_MANGO_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_MANGO_WOOD, 5, 5);
        registry.add(ModBlocks.MANGO_STAIR, 20, 5);
        registry.add(ModBlocks.MANGO_SLAB, 20, 5);
        registry.add(ModBlocks.MANGO_FENCE, 20, 5);
        registry.add(ModBlocks.MANGO_FENCE_GATE, 20, 5);
        registry.add(ModBlocks.MANGO_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.MANGO_LOG, ModBlocks.STRIPPED_MANGO_LOG);
        StrippableBlockRegistry.register(ModBlocks.MANGO_WOOD, ModBlocks.STRIPPED_MANGO_WOOD);
    }

    private static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.SEED, 0.25F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.MANGO, 0.65F);
    }

    private static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.FARMER,
                2,
                factories -> factories.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.MANGO, 10), new ItemStack(Items.EMERALD), 12, 45, 0.5F)));
    }

    private static void registerLootTables() {
        net.anvian.simplemango.fabric.LootTableModifier.register();
    }

    private static void registerBlock(String name, net.minecraft.world.level.block.Block block) {
        Registry.register(Registry.BLOCK, new ResourceLocation(MangoMod.MOD_ID, name), block);
    }

    private static void registerItem(String name, net.minecraft.world.item.Item item) {
        Registry.register(Registry.ITEM, new ResourceLocation(MangoMod.MOD_ID, name), item);
    }
}
