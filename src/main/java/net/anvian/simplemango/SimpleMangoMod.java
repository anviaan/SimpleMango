package net.anvian.simplemango;

import com.mojang.logging.LogUtils;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.event.ModComposter;
import net.anvian.simplemango.event.loot.ModLootModifiers;
import net.anvian.simplemango.item.MangoItemGroup;
import net.anvian.simplemango.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SimpleMangoMod.MOD_ID)
public class SimpleMangoMod
{
    public static final String MOD_ID = "simplemango";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SimpleMangoMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModLootModifiers.register(eventBus);

        eventBus.addListener(this::addCreative);
        eventBus.addListener(ModComposter::init);
        eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Hello from Simple Mango!");
    }
    private void addCreative(CreativeModeTabEvent.BuildContents even){
        if (even.getTab() == MangoItemGroup.MANGO){
            even.accept(ModItems.MANGO);
            even.accept(ModItems.GOLDEN_MANGO);
            even.accept(ModItems.ENCHANTED_GOLDEN_MANGO);
            even.accept(ModItems.SEED);
            even.accept(ModItems.MANGO_SEED_HELMET);

            even.accept(ModBlocks.BLOCKOFMANGO);
            even.accept(ModBlocks.MANGO_PLANKS);
            even.accept(ModBlocks.MANGO_LOG);
            even.accept(ModBlocks.STRIPPED_MANGO_LOG);
            even.accept(ModBlocks.MANGO_WOOD);
            even.accept(ModBlocks.STRIPPED_MANGO_WOOD);
            even.accept(ModBlocks.MANGO_LEAVES);
            even.accept(ModBlocks.MANGO_STAIR);
            even.accept(ModBlocks.MANGO_SLAB);
            even.accept(ModBlocks.MANGO_FENCE);
            even.accept(ModBlocks.MANGO_FENCE_GATE);
            even.accept(ModBlocks.MANGO_BUTTON);
            even.accept(ModBlocks.MANGO_PRESSURE_PLATE);
            even.accept(ModBlocks.MANGO_DOOR);
            even.accept(ModBlocks.MANGO_TRAPDOOR);
        }
    }
}
