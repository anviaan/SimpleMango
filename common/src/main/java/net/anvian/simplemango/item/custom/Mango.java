package net.anvian.simplemango.item.custom;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Mango extends Item {
    public Mango(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack seed = new ItemStack(ModItems.SEED);
        super.finishUsingItem(stack, level, livingEntity);

        if (stack.isEmpty()) {
            return seed;
        }
        if (livingEntity instanceof Player player
                && !player.isCreative()
                && !player.getInventory().add(seed)) {
            player.drop(seed, false);
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
