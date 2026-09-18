package net.anvian.simplemango.entity;

import net.anvian.simplemango.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MangoChestBoat extends ChestBoat {
    public MangoChestBoat(EntityType<MangoChestBoat> entityType, Level level) {
        super(entityType, level);
        setType(Type.OAK);
    }

    public MangoChestBoat(Level level, double x, double y, double z) {
        this(ModEntities.MANGO_CHEST_BOAT, level);
        setPos(x, y, z);
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.MANGO_CHEST_BOAT;
    }

    @Override
    protected void checkFallDamage(double fallDistance, boolean onGround, BlockState blockState, BlockPos blockPos) {
        MangoBoatSupport.checkFallDamage(this, fallDistance, onGround, this.fallDistance);
    }
}
