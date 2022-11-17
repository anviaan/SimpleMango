package net.anvian.simplemango.util;

import net.anvian.simplemango.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlock {
    public static void registerFlammableBlock(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_PLANKS, 20,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MANGO_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MANGO_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_STAIR, 20,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_SLAB,20,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_FENCE,20,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_FENCE_GATE,20,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_LEAVES,30,60);
    }
}
