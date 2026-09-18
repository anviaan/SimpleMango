package net.anvian.simplemango.forge;

import net.anvian.simplemango.platform.IPlatformHelper;
import net.anvian.simplemango.wood.ModWoodTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class ForgePlatformHelper implements IPlatformHelper {
    @Override
    public Item.Properties createItemProperties(boolean creativeTab) {
        Item.Properties properties = new Item.Properties();
        return creativeTab ? properties.tab(MangoItemGroup.MANGO) : properties;
    }

    @Override
    public WoodType createWoodType(String name) {
        return ModWoodTypes.registerReflectively(WoodType.create(name));
    }
}
