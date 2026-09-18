package net.anvian.simplemango.platform;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;

public interface IPlatformHelper {
    Item.Properties createItemProperties(boolean creativeTab);

    WoodType createWoodType(String name);
}
