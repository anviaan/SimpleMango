package net.anvian.simplemango.entity;

import net.minecraft.world.entity.EntityType;

public final class ModEntities {
    public static EntityType<MangoBoat> MANGO_BOAT;
    public static EntityType<MangoChestBoat> MANGO_CHEST_BOAT;

    private ModEntities() {}

    public static void setMangoBoat(EntityType<MangoBoat> type) {
        MANGO_BOAT = type;
    }

    public static void setMangoChestBoat(EntityType<MangoChestBoat> type) {
        MANGO_CHEST_BOAT = type;
    }
}
