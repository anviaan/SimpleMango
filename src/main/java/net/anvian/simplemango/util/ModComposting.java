package net.anvian.simplemango.util;

import net.anvian.simplemango.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class ModComposting {
    public static void regisster(){
        CompostingChanceRegistry.INSTANCE.add(ModItems.SEED,0.25f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.MANGO, 0.65f);
    }
}
