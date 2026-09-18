package net.anvian.simplemango.forge;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.client.MangoBoatRenderer;
import net.anvian.simplemango.wood.ModWoodTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MangoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class MangoModForgeClient {
    private MangoModForgeClient() {}

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_TRAPDOOR, RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_DOOR, RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_SAPLING, RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGO_LEAVES, RenderType.cutout());
            EntityRenderers.register(MangoModForge.MANGO_BOAT.get(), context -> new MangoBoatRenderer(context, false));
            EntityRenderers.register(
                    MangoModForge.MANGO_CHEST_BOAT.get(), context -> new MangoBoatRenderer(context, true));
            Sheets.addWoodType(ModWoodTypes.MANGO);
        });
    }
}
