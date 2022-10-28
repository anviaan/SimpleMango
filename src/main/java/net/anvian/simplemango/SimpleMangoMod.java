package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.event.ModComposter;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.BiomeMod.ModBiomeModifiers;
import net.anvian.simplemango.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(SimpleMangoMod.MOD_ID)
public class SimpleMangoMod
{
    public static final String MOD_ID = "simplemango";

    public SimpleMangoMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModBiomeModifiers.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(ModComposter::init);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_SAPLING.get(), RenderType.cutout());
    }
}
