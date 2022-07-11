package net.anvian.simplemango.item;

import net.anvian.simplemango.SimpleMangoMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SimpleMangoMod.MOD_ID);


    public static final RegistryObject<Item> SEED = ITEMS.register("seed",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .tab(MangoItemGroup.MANGO)));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationMod(0.875f)
                            .build())
                    .rarity(Rarity.COMMON)
                    .tab(MangoItemGroup.MANGO)));
    public static final RegistryObject<Item> GOLDEN_MANGO = ITEMS.register("golden_mango",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .alwaysEat()
                            .saturationMod(1.25f)
                            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
                            .effect(new MobEffectInstance(MobEffects.ABSORPTION,2400,0),1.0f)
                            .effect(new MobEffectInstance(MobEffects.REGENERATION,100,1),1.0f)
                            .build())
                    .tab(MangoItemGroup.MANGO)));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_MANGO = ITEMS.register("enchanted_golden_mango",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .alwaysEat()
                            .saturationMod(2.3f)
                            .effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1),1.0f)
                            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400,1),1.0f)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,3600,0),1.0f)
                            .effect(new MobEffectInstance(MobEffects.HARM,6000,1),1.0f)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,3000,0),1.0f)
                            .build())));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}