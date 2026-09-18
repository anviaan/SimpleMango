package net.anvian.simplemango.forge;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.entity.MangoBoatDispenseItemBehavior;
import net.anvian.simplemango.entity.ModEntities;
import net.anvian.simplemango.item.ModItems;
import net.anvian.simplemango.world.features.ModConfiguredFeatures;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = MangoMod.MOD_ID)
public final class ForgeEvents {
    private ForgeEvents() {}

    public static void registerCompostables(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModConfiguredFeatures.setMangoTreeHolder(
                    MangoModForge.MANGO_TREE.getHolder().get());
            ModEntities.setMangoBoat(MangoModForge.MANGO_BOAT.get());
            ModEntities.setMangoChestBoat(MangoModForge.MANGO_CHEST_BOAT.get());
            ComposterBlock.COMPOSTABLES.put(ModItems.SEED, 0.25F);
            ComposterBlock.COMPOSTABLES.put(ModItems.MANGO, 0.65F);
            DispenserBlock.registerBehavior(ModItems.MANGO_BOAT, new MangoBoatDispenseItemBehavior(false));
            DispenserBlock.registerBehavior(ModItems.MANGO_CHEST_BOAT, new MangoBoatDispenseItemBehavior(true));
        });
    }

    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(2)
                    .add((trader, random) -> new MerchantOffer(
                            new ItemStack(ModItems.MANGO, 10), new ItemStack(Items.EMERALD), 12, 45, 0.5F));
        }
    }

    @SubscribeEvent
    public static void stripMangoLogs(BlockEvent.BlockToolModificationEvent event) {
        if (!event.isSimulated() && event.getToolAction() == ToolActions.AXE_STRIP) {
            BlockState state = event.getState();
            if (state.is(ModBlocks.MANGO_LOG)) {
                event.setFinalState(strippedState(ModBlocks.STRIPPED_MANGO_LOG, state));
            } else if (state.is(ModBlocks.MANGO_WOOD)) {
                event.setFinalState(strippedState(ModBlocks.STRIPPED_MANGO_WOOD, state));
            }
        }
    }

    private static BlockState strippedState(net.minecraft.world.level.block.Block stripped, BlockState state) {
        return stripped.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
    }
}
