package net.anvian.simplemango.forge;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class MangoItemGroup {
    public static final CreativeModeTab MANGO = new CreativeModeTab("mango") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANGO);
        }
    };

    private MangoItemGroup() {}
}
