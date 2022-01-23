package net.anvian.simplemango.item;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.item.custom.EnchantedGoldenMango;
import net.anvian.simplemango.item.custom.Mango;
import net.anvian.simplemango.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MANGO =registerItem("mango", new Mango(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.875f)
                    .build())
            .group(MangoItemGroup.MANGO)
            .rarity(Rarity.COMMON)));

    public static final Item SEED = registerItem("seed", new Item(new FabricItemSettings()
            .rarity(Rarity.COMMON)
            .group(MangoItemGroup.MANGO)));

    public static final Item MANGO_SEED_HELMET = registerItem("mango_seed_helmet",
            new ModArmorItem(ModArmorMaterial.SEED, EquipmentSlot.HEAD,
                     new FabricItemSettings().group(MangoItemGroup.MANGO)));

    public static final Item GOLDEN_MANGO =  registerItem("golden_mango",
            new Mango(new FabricItemSettings().food(new FoodComponent.Builder()
                    .hunger(4)
                    .alwaysEdible()
                    .saturationModifier(1.25f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,2400),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,2400),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100,1),1f)
                    .build())
                    .group(MangoItemGroup.MANGO)));

    public static final Item ENCHANTED_GOLDEN_MANGO = registerItem("enchanted_golden_mango",
            new EnchantedGoldenMango(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(MangoItemGroup.MANGO).food(new FoodComponent.Builder()
                    .hunger(4)
                    .alwaysEdible()
                    .saturationModifier(2.3f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,2400,1),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,3600),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,6000,1),1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,3000),1f)
                    .build())));


    private static Item registerItem(String name,Item item){
        return Registry.register(Registry.ITEM, new Identifier(MangoMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registering Mod Items for " + MangoMod.MOD_ID);
    }
}
