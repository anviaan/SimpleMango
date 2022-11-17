package net.anvian.simplemango.event;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModComposter extends ComposterBlock{

    public ModComposter(Properties pProperties) {
        super(pProperties);
    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
        });
    }
    public static void registerCompostables(){
        ComposterBlock.COMPOSTABLES.put(ModItems.SEED.get(),0.25f);
        ComposterBlock.COMPOSTABLES.put(ModItems.MANGO.get(), 0.65f);
    }
}
