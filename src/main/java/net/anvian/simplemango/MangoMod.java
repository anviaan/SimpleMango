package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.anvian.simplemango.util.ModLootTableModifiers;
import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.anvian.simplemango.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MangoMod implements ModInitializer {
	public static final String MOD_ID = "simplemango";
	public static final Logger LOGGER = LogManager.getLogger("modid");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModConfiguredFeatures.registerConfiguredFeatures();

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

		ModLootTableModifiers.modifyLootTable();

		ModRegistries.registerStrippables();
		ModRegistries.VillagerTrades();

		CompostingChanceRegistry.INSTANCE.add(ModItems.SEED,0.25f);

		ModWorldGen.generateModWorldGen();
	}
}
