package net.anvian.simplemango;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.registries.ModRegistries;
import net.anvian.simplemango.util.ModComposting;
import net.anvian.simplemango.util.ModFlammableBlock;
import net.anvian.simplemango.util.ModLootTableModifiers;
import net.anvian.simplemango.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMango implements ModInitializer {
	public static final String MOD_ID = "simplemango";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<ItemGroup> MANGO = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "mango_item_group"));

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from Simple Mango Mod!");

		Registry.register(Registries.ITEM_GROUP, MANGO, FabricItemGroup.builder()
				.icon(()-> new ItemStack(ModItems.MANGO))
				.displayName(Text.translatable("itemGroup.simplemango.mango"))
				.build());

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