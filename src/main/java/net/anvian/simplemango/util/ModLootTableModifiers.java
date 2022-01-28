package net.anvian.simplemango.util;

import net.anvian.simplemango.item.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier END_CITY_ID =
            new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier RUINED_PORTAL_ID =
            new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier DESERT_PYRAMID_ID =
            new Identifier("minecraft", "chests/desert_pyramid");

    public static void modifyLootTable(){
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(END_CITY_ID.equals(id)){
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.031f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_GOLDEN_MANGO))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());//entre 1 o 1
                supplier.withPool(poolBuilder.build());
            }
            if(RUINED_PORTAL_ID.equals(id)){
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.015f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_GOLDEN_MANGO))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());//entre 1 o 1
                supplier.withPool(poolBuilder.build());
            }
            if(DESERT_PYRAMID_ID.equals(id)){
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.026f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_GOLDEN_MANGO))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());//entre 1 o 1
                supplier.withPool(poolBuilder.build());
            }
        }));
    }

}
