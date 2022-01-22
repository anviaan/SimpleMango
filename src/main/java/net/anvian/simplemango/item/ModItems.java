package net.anvian.simplemango.item;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.item.custom.Mango;
import net.anvian.simplemango.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
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

    private static Item registerItem(String name,Item item){
        return Registry.register(Registry.ITEM, new Identifier(MangoMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registering Mod Items for " + MangoMod.MOD_ID);
    }
}
