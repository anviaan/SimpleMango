package net.anvian.simplemango.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MangoFlammableBlock extends Block {
    private final int flammability;
    private final int fireSpreadSpeed;

    public MangoFlammableBlock(BlockBehaviour.Properties properties, int flammability, int fireSpreadSpeed) {
        super(properties);
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }

    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpreadSpeed;
    }
}
