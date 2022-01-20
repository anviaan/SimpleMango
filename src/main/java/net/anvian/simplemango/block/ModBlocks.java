package net.anvian.simplemango.block;

import net.anvian.simplemango.MangoMod;
import net.anvian.simplemango.block.custom.ModPressurePlateBlock;
import net.anvian.simplemango.block.custom.ModStairsBlock;
import net.anvian.simplemango.block.custom.ModWoodButton;
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

    //mangoblock
    public static final Block BLOCKOFMANGO = registerBlock("blockofmango",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f).breakByHand(true)));

    //logs
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

    //stair
    public static final Block MANGO_STAIR = registerBlock("mango_stair",
            new ModStairsBlock(ModBlocks.MANGO_PLANKS.getDefaultState(),
                    FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f)
                            .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));

    //slab
    public static final Block MANGO_SLAB = registerBlock("mango_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f)
                    .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));

    //fences
    public static final Block MANGO_FENCE = registerBlock("mango_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f)
                    .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));
    public static final Block MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f)
                    .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));

    //button
    public static final Block MANGO_BUTTON = registerBlock("mango_button",
            new ModWoodButton(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f)
                    .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));

    //presure_plate
    public static final Block MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f)
                    .breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)));


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
