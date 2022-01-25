package net.anvian.simplemango.util;

import net.anvian.simplemango.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ModRenderHelper {
    public static void setRenderLayers(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_LEAVES, RenderLayer.getCutout());
    }
}
