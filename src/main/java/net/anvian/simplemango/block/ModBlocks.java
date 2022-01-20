package net.anvian.simplemango.block;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.item.MangoItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {


    public static final Block BLOCKOFMANGO = registerBlock("blockofmango",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).breakByHand(true)));

    public static final Block MANGO_LOG = registerBlock("mango_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)));

    public static final Block MANGO_WOOD = registerBlock("mango_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)));

    public static final Block STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)));

    public static final Block STRIPPED_MANGO_WOOD = registerBlock("stripped_mango_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)));

    public static final Block MANGO_PLANKS = registerBlock("mango_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).breakByTool(FabricToolTags.AXES)));

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
