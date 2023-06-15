package net.anvian.simplemango.item;

import net.anvian.simplemango.SimpleMangoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MangoItemGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            SimpleMangoMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> MANGO = CREATIVE_MODE_TAB.register("mango", () ->
            CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.MANGO.get()))
                    .title(Component.translatable("itemGroup.mango"))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
