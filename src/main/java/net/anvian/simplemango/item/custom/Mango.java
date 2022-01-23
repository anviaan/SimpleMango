package net.anvian.simplemango.item.custom;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Mango extends Item {
    public Mango(Settings settings) {super(settings);}

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        ItemStack retval = new ItemStack(ModItems.SEED);
        super.finishUsing(stack, world,user);
        if (stack.isEmpty()){
            return retval;
        }else{
            if (user instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) user;
                if (!player.isCreative() && !player.getInventory().insertStack(retval))
                player.dropItem(retval,false);
            }
        }

        return super.finishUsing(stack, world, user);
    }
}
