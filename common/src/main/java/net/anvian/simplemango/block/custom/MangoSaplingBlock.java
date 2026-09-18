package net.anvian.simplemango.block.custom;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MangoSaplingBlock extends SaplingBlock {
    public MangoSaplingBlock(AbstractTreeGrower treeGrower, BlockBehaviour.Properties properties) {
        super(treeGrower, properties);
    }
}
