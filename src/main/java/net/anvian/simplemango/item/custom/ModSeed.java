package net.anvian.simplemango.item.custom;

import net.anvian.simplemango.block.ModBlocks;
import net.anvian.simplemango.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class ModSeed extends Item {

    public ModSeed(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity entity = context.getPlayer();
        ItemStack stack = context.getStack();
        LivingEntity user = context.getPlayer();
        Inventory inventory = context.getPlayer().getInventory();

        ItemStack retval = new ItemStack(ModItems.SEED);


        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        boolean canBePlaced = false;

        if ((((world.getBlockState(new BlockPos(pos.add(x, y + 1, z))).getBlock() == Blocks.AIR)) ||
                (world.getBlockState(new BlockPos(pos.add(x, y + 1, z))).getBlock() == Blocks.VOID_AIR))) {
            if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.GRASS_BLOCK) {
                canBePlaced = true;
            } else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.MYCELIUM) {
                canBePlaced = true;
            } else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.DIRT) {
                canBePlaced = true;
            } else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.COARSE_DIRT) {
                canBePlaced = true;
            } else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.PODZOL) {
                canBePlaced = true;
            }

            if ((canBePlaced)) {
                if ((((entity instanceof LivingEntity) ? (entity).getMainHandStack() : ItemStack.EMPTY).getItem() == ModItems.SEED)) {
                        world.setBlockState(new BlockPos(x, y + 1, z), ModBlocks.MANGO_SAPLING.getDefaultState());
                        if (entity instanceof LivingEntity) {
                            entity.swingHand(Hand.MAIN_HAND, true);
                        }
                        if (!world.isClient()) {
                            world.playSound(null, new BlockPos(x, y, z),
                                    SoundEvents.BLOCK_ROOTED_DIRT_PLACE, SoundCategory.NEUTRAL, 1f, 0.8f);
                        } else {
                            world.playSound(x, y, z, SoundEvents.BLOCK_ROOTED_DIRT_PLACE, SoundCategory.NEUTRAL, 1f, 0.8f, false);
                        }


                }
            }
        }
        return super.useOnBlock(context);
    }
}