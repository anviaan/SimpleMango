package net.anvian.simplemango.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MangoItemGroup {
    public static final CreativeModeTab MANGO = new CreativeModeTab("mango") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANGO.get());
        }
    };
}
