package net.anvian.simplemango.event;

import net.anvian.simplemango.SimpleMangoMod;
import net.anvian.simplemango.event.loot.EGAEndCity;
import net.anvian.simplemango.event.loot.EGADesertPyramid;
import net.anvian.simplemango.event.loot.EGARuinedPortal;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = SimpleMangoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new EGAEndCity.Serializer().setRegistryName
                        (new ResourceLocation(SimpleMangoMod.MOD_ID,"ega_end_city")),
                new EGARuinedPortal.Serializer().setRegistryName
                        (new ResourceLocation(SimpleMangoMod.MOD_ID,"ega_ruined_portal")),
                new EGADesertPyramid.Serializer().setRegistryName
                        (new ResourceLocation(SimpleMangoMod.MOD_ID,"ega_desert_pyramid"))
        );
    }
}
