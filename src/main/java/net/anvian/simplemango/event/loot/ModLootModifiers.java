package net.anvian.simplemango.event.loot;

import com.mojang.serialization.Codec;
import net.anvian.simplemango.SimpleMangoMod;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SimpleMangoMod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> MOD_END_CITY =
            LOOT_MODIFIER_SERIALIZERS.register("mod_end_city", ModEndCity.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> MOD_DESERT_PYRAMID =
            LOOT_MODIFIER_SERIALIZERS.register("mod_desert_pyramid", ModDesertPyramid.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> MOD_RUINED_PORTAL =
            LOOT_MODIFIER_SERIALIZERS.register("mod_ruined_portal", ModRuinedPortal.CODEC);


    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
