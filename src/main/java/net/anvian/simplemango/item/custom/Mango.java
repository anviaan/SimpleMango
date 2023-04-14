package net.anvian.simplemango.item.custom;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Mango extends Item {
    public Mango(Properties pProperties) {super(pProperties);}

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        ItemStack retval = new ItemStack(ModItems.SEED.get());
        super.finishUsingItem(pStack, pLevel, pLivingEntity);

        if (pStack.isEmpty()){
            return retval;
        }else{
            if (pLivingEntity instanceof Player player){
                if (!player.isCreative() && !player.getInventory().add(retval)){
                    player.drop(retval,false);
                }
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
