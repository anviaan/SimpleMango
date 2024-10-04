package net.anvian.simplemango.item;

import net.anvian.simplemango.SimpleMango;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.custom.EnchantedGoldenMango;
import net.anvian.simplemango.item.custom.Mango;
import net.anvian.simplemango.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item MANGO = registerItem("mango", new Mango(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.875f)
                    .build())
            .rarity(Rarity.COMMON)));
    public static final Item SEED = registerItem("seed", new AliasedBlockItem(ModBlocks.MANGO_SAPLING,
            new Item.Settings().rarity(Rarity.COMMON)));

    public static final Item MANGO_SEED_HELMET = registerItem("mango_seed_helmet",
            new ModArmorItem(ModArmorMaterial.SEED, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));

    public static final Item GOLDEN_MANGO = registerItem("golden_mango",
            new Mango(new FabricItemSettings().food(new FoodComponent.Builder()
                    .hunger(4)
                    .alwaysEdible()
                    .saturationModifier(1.25f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1f)
                    .build())
            ));

    public static final Item ENCHANTED_GOLDEN_MANGO = registerItem("enchanted_golden_mango",
            new EnchantedGoldenMango(new FabricItemSettings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder()
                    .hunger(4)
                    .alwaysEdible()
                    .saturationModifier(2.3f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3000), 1f)
                    .build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SimpleMango.MOD_ID, name), item);
    }

    private static void addItemsToItemGroup() {
        addToItemGroup(MANGO);
        addToItemGroup(GOLDEN_MANGO);
        addToItemGroup(ENCHANTED_GOLDEN_MANGO);
        addToItemGroup(SEED);
        addToItemGroup(MANGO_SEED_HELMET);
    }

    private static void addToItemGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(SimpleMango.MANGO).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SimpleMango.LOGGER.debug("Registering Mod Items for " + SimpleMango.MOD_ID);
        addItemsToItemGroup();
    }
}
