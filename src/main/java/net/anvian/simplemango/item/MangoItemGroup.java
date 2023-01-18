package net.anvian.simplemango.item;

import net.anvian.simplemango.MangoMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MangoItemGroup {
    public static ItemGroup MANGO;
    public static void registerItemGroup(){
        MANGO = FabricItemGroup.builder(new Identifier(MangoMod.MOD_ID, "mango_item_group"))
                .displayName(Text.translatable("itemGroup.simplemango.mango"))
                .icon(()-> new ItemStack(ModItems.MANGO))
                .build();
    }

}
