package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.render.RenderLayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MangoMod implements ModInitializer {
	public static final String MOD_ID = "simplemango";
	public static final Logger LOGGER = LogManager.getLogger("modid");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_PLANKS, 20,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MANGO_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MANGO_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_STAIR, 20,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_SLAB,20,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_FENCE,20,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGO_FENCE_GATE,20,5);

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGO_DOOR, RenderLayer.getCutout());

		ModRegistries.registerStrippables();
		ModRegistries.VillagerTrades();

		CompostingChanceRegistry.INSTANCE.add(ModItems.SEED,0.25f);
	}
}
