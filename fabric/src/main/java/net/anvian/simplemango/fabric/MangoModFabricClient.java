package net.anvian.simplemango.fabric;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.client.MangoBoatRenderer;
import net.anvian.simplemango.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public final class MangoModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_LEAVES, RenderType.cutout());
        EntityRendererRegistry.register(ModEntities.MANGO_BOAT, context -> new MangoBoatRenderer(context, false));
        EntityRendererRegistry.register(ModEntities.MANGO_CHEST_BOAT, context -> new MangoBoatRenderer(context, true));
    }
}
