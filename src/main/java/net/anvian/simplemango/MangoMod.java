package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.fabricmc.api.ModInitializer;
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

		ModRegistries.registerStrippables();
	}
}
