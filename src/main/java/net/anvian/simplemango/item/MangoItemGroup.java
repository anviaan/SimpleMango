package net.anvian.simplemango.item;

import net.anvian.simplemango.MangoMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MangoItemGroup {
    public static final ItemGroup MANGO = FabricItemGroupBuilder.build
            (new Identifier(MangoMod.MOD_ID, "mango"),
                    () -> new ItemStack(ModItems.MANGO));
}
