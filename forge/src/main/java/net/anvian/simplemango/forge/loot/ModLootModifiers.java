package net.anvian.simplemango.forge.loot;

import com.mojang.serialization.Codec;
import net.anvian.simplemango.MangoMod;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MangoMod.MOD_ID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> END_CITY =
            SERIALIZERS.register("mod_end_city", ModEndCity.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DESERT_PYRAMID =
            SERIALIZERS.register("mod_desert_pyramid", ModDesertPyramid.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> RUINED_PORTAL =
            SERIALIZERS.register("mod_ruined_portal", ModRuinedPortal.CODEC);

    private ModLootModifiers() {}

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}
