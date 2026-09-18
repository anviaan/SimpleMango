package net.anvian.simplemango.fabric;

import net.anvian.simplemango.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public final class LootTableModifier {
    private static final ResourceLocation END_CITY = new ResourceLocation("minecraft", "chests/end_city_treasure");
    private static final ResourceLocation RUINED_PORTAL = new ResourceLocation("minecraft", "chests/ruined_portal");
    private static final ResourceLocation DESERT_PYRAMID = new ResourceLocation("minecraft", "chests/desert_pyramid");

    private LootTableModifier() {}

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (END_CITY.equals(id)) {
                addMango(tableBuilder, 0.031F);
            } else if (RUINED_PORTAL.equals(id)) {
                addMango(tableBuilder, 0.015F);
            } else if (DESERT_PYRAMID.equals(id)) {
                addMango(tableBuilder, 0.026F);
            }
        });
    }

    private static void addMango(net.minecraft.world.level.storage.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(LootItemRandomChanceCondition.randomChance(chance))
                .add(LootItem.lootTableItem(ModItems.ENCHANTED_GOLDEN_MANGO))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)));
        tableBuilder.pool(pool.build());
    }
}
