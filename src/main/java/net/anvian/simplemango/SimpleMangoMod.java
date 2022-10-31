package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.event.ModComposter;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.feature.ModConfiguredFeatures;
import net.anvian.simplemango.world.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(SimpleMangoMod.MOD_ID)
public class SimpleMangoMod
{
    public static final String MOD_ID = "simplemango";

    public SimpleMangoMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);


        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(ModComposter::init);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
