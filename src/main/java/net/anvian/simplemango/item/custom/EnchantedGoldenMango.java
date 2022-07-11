package net.anvian.simplemango.item.custom;

import net.minecraft.world.item.ItemStack;

public class EnchantedGoldenMango extends Mango{
    public EnchantedGoldenMango(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
