package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.MangoItemGroup;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.anvian.simplemango.util.ModComposting;
import net.anvian.simplemango.util.ModFlammableBlock;
import net.anvian.simplemango.util.ModLootTableModifiers;
import net.anvian.simplemango.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MangoMod implements ModInitializer {
	public 	static final String MOD_ID = "simplemango";
	public static final Logger LOGGER = LoggerFactory.getLogger("simplemango");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		MangoItemGroup.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFlammableBlock.registerFlammableBlock();

		ModLootTableModifiers.modifyLootTable();

		ModRegistries.registerStrippables();
		ModRegistries.VillagerTrades();

		ModComposting.register();

		ModWorldGen.generateModWorldGen();
	}
}