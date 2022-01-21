package net.anvian.simplemango.registries;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {

    public static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.MANGO_LOG, ModBlocks.STRIPPED_MANGO_LOG);
        StrippableBlockRegistry.register(ModBlocks.MANGO_WOOD, ModBlocks.STRIPPED_MANGO_WOOD);
    }

    public static void VillagerTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2, factories ->{
            factories.add((entity, random) -> new TradeOffer(new ItemStack(ModItems.MANGO, 10),
                    new ItemStack(Items.EMERALD,1),12,45,.5f));
        });
    }
}
