package net.anvian.simplemango.entity;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MangoBoat extends Boat {
    public MangoBoat(EntityType<MangoBoat> entityType, Level level) {
        super(entityType, level);
        setType(Type.OAK);
    }

    public MangoBoat(Level level, double x, double y, double z) {
        this(ModEntities.MANGO_BOAT, level);
        setPos(x, y, z);
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.MANGO_BOAT;
    }

    @Override
    protected void checkFallDamage(double fallDistance, boolean onGround, BlockState blockState, BlockPos blockPos) {
        MangoBoatSupport.checkFallDamage(this, fallDistance, onGround, this.fallDistance);
    }
}
