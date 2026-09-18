package net.anvian.simplemango.fabric;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.item.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class MangoItemGroup {
    public static final CreativeModeTab MANGO = FabricItemGroupBuilder.build(
            new ResourceLocation(MangoMod.MOD_ID, "mango"), () -> new ItemStack(ModItems.MANGO));

    private MangoItemGroup() {}
}
