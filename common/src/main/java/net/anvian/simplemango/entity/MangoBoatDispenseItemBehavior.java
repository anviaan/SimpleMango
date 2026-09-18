package net.anvian.simplemango.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.server.level.ServerLevel;

public final class MangoBoatDispenseItemBehavior extends DefaultDispenseItemBehavior {
    private final boolean chestBoat;
    private final DefaultDispenseItemBehavior fallback = new DefaultDispenseItemBehavior();

    public MangoBoatDispenseItemBehavior(boolean chestBoat) {
        this.chestBoat = chestBoat;
    }

    @Override
    protected ItemStack execute(BlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        ServerLevel level = source.getLevel();
        double x = source.x() + direction.getStepX() * 1.125D;
        double y = source.y() + direction.getStepY() * 1.125D;
        double z = source.z() + direction.getStepZ() * 1.125D;
        BlockPos front = source.getPos().relative(direction);
        Boat boat = chestBoat ? new MangoChestBoat(level, x, y, z) : new MangoBoat(level, x, y, z);
        boat.setYRot(direction.toYRot());

        double yOffset;
        if (level.getFluidState(front).is(FluidTags.WATER)) {
            yOffset = 1.0D;
        } else {
            if (!level.getBlockState(front).isAir()
                    || !level.getFluidState(front.below()).is(FluidTags.WATER)) {
                return fallback.dispense(source, stack);
            }
            yOffset = 0.0D;
        }

        boat.setPos(x, y + yOffset, z);
        level.addFreshEntity(boat);
        stack.shrink(1);
        return stack;
    }

    @Override
    protected void playSound(BlockSource source) {
        source.getLevel().levelEvent(1000, source.getPos(), 0);
    }
}
