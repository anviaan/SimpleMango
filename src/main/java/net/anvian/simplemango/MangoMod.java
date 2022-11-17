package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.anvian.simplemango.util.ModComposting;
import net.anvian.simplemango.util.ModFlammableBlock;
import net.anvian.simplemango.util.ModLootTableModifiers;
import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.anvian.simplemango.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MangoMod implements ModInitializer {
	public static final String MOD_ID = "simplemango";
	public static final Logger LOGGER = LogManager.getLogger("simplemango");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFlammableBlock.registerFlammableBlock();

		ModLootTableModifiers.modifyLootTable();

		ModRegistries.registerStrippables();
		ModRegistries.VillagerTrades();

		ModComposting.regisster();

		ModWorldGen.generateModWorldGen();
	}
}
