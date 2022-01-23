package net.anvian.simplemango.item.custom;

import net.minecraft.item.ItemStack;

public class EnchantedGoldenMango extends Mango {
    public EnchantedGoldenMango(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
