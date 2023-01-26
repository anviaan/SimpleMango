package net.anvian.simplemango.item;

import net.anvian.simplemango.SimpleMangoMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimpleMangoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MangoItemGroup {
    public static CreativeModeTab MANGO;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MANGO = event.registerCreativeModeTab(new ResourceLocation(SimpleMangoMod.MOD_ID, "sculkhorn"),
                builder -> builder
                        .icon(()-> new ItemStack(ModItems.MANGO.get()))
                        .title(Component.translatable("itemGroup.mango"))
                        .build());
    }
}
