package net.anvian.simplemango.item;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.custom.EnchantedGoldenMango;
import net.anvian.simplemango.item.custom.Mango;
import net.anvian.simplemango.item.custom.MangoBoatItem;
import net.anvian.simplemango.item.custom.ModArmorItem;
import net.anvian.simplemango.platform.Services;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;

public final class ModItems {
    public static Item BLOCKOFMANGO;
    public static Item MANGO_LOG;
    public static Item MANGO_WOOD;
    public static Item STRIPPED_MANGO_LOG;
    public static Item STRIPPED_MANGO_WOOD;
    public static Item MANGO_PLANKS;
    public static Item MANGO_STAIR;
    public static Item MANGO_SLAB;
    public static Item MANGO_FENCE;
    public static Item MANGO_FENCE_GATE;
    public static Item MANGO_BUTTON;
    public static Item MANGO_PRESSURE_PLATE;
    public static Item MANGO_DOOR;
    public static Item MANGO_TRAPDOOR;
    public static Item MANGO_LEAVES;
    public static Item MANGO_SAPLING;
    public static Item MANGO_SIGN;
    public static Item MANGO_BOAT;
    public static Item MANGO_CHEST_BOAT;
    public static Item MANGO;
    public static Item SEED;
    public static Item MANGO_SEED_HELMET;
    public static Item GOLDEN_MANGO;
    public static Item ENCHANTED_GOLDEN_MANGO;

    private static boolean initialized;

    public static void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        BLOCKOFMANGO = blockItem(ModBlocks.BLOCKOFMANGO);
        MANGO_LOG = blockItem(ModBlocks.MANGO_LOG);
        MANGO_WOOD = blockItem(ModBlocks.MANGO_WOOD);
        STRIPPED_MANGO_LOG = blockItem(ModBlocks.STRIPPED_MANGO_LOG);
        STRIPPED_MANGO_WOOD = blockItem(ModBlocks.STRIPPED_MANGO_WOOD);
        MANGO_PLANKS = blockItem(ModBlocks.MANGO_PLANKS);
        MANGO_STAIR = blockItem(ModBlocks.MANGO_STAIR);
        MANGO_SLAB = blockItem(ModBlocks.MANGO_SLAB);
        MANGO_FENCE = blockItem(ModBlocks.MANGO_FENCE);
        MANGO_FENCE_GATE = blockItem(ModBlocks.MANGO_FENCE_GATE);
        MANGO_BUTTON = blockItem(ModBlocks.MANGO_BUTTON);
        MANGO_PRESSURE_PLATE = blockItem(ModBlocks.MANGO_PRESSURE_PLATE);
        MANGO_DOOR = blockItem(ModBlocks.MANGO_DOOR);
        MANGO_TRAPDOOR = blockItem(ModBlocks.MANGO_TRAPDOOR);
        MANGO_LEAVES = blockItem(ModBlocks.MANGO_LEAVES);
        MANGO_SAPLING = blockItem(ModBlocks.MANGO_SAPLING);
        MANGO_SIGN = new net.minecraft.world.item.SignItem(
                tabProperties().stacksTo(16), ModBlocks.MANGO_SIGN, ModBlocks.MANGO_WALL_SIGN);
        MANGO_BOAT = new MangoBoatItem(false, tabProperties().stacksTo(1));
        MANGO_CHEST_BOAT = new MangoBoatItem(true, tabProperties().stacksTo(1));
        MANGO = new Mango(tabProperties()
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(0.875F)
                        .build())
                .rarity(Rarity.COMMON));
        SEED = new ItemNameBlockItem(ModBlocks.MANGO_SAPLING, plainProperties().rarity(Rarity.COMMON));
        MANGO_SEED_HELMET = new ModArmorItem(ModArmorMaterial.SEED, EquipmentSlot.HEAD, tabProperties());
        GOLDEN_MANGO = new Mango(tabProperties()
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .alwaysEat()
                        .saturationMod(1.25F)
                        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
                        .build()));
        ENCHANTED_GOLDEN_MANGO = new EnchantedGoldenMango(tabProperties()
                .rarity(Rarity.UNCOMMON)
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .alwaysEat()
                        .saturationMod(2.3F)
                        .effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 1), 1.0F)
                        .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000), 1.0F)
                        .build()));
    }

    private ModItems() {}

    private static Item blockItem(net.minecraft.world.level.block.Block block) {
        return new BlockItem(block, tabProperties());
    }

    private static Item.Properties tabProperties() {
        return Services.PLATFORM.createItemProperties(true);
    }

    private static Item.Properties plainProperties() {
        return Services.PLATFORM.createItemProperties(false);
    }
}
