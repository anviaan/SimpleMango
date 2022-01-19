package net.anvian.simplemango.block;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.item.MangoItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {


    public static final Block BLOCKOFMANGO = registerBlock("blockofmango",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).requiresTool().breakByHand(true)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(MangoMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(MangoMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(MangoItemGroup.MANGO)));
    }


    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + MangoMod.MOD_ID);
    }
}
