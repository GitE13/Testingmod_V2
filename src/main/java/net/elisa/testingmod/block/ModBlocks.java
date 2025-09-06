package net.elisa.testingmod.block;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.block.custom.MagicBlock;
import net.elisa.testingmod.block.custom.PinkGarnetLampBlock;
import net.elisa.testingmod.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerNormalBlock("pink_garnet_block",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RAW_PINK_GARNET_BLOCK = registerNormalBlock("raw_pink_garnet_block",
            AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block PINK_GARNET_ORE = registerAdvancedBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    getSettings("pink_garnet_ore",
                            AbstractBlock.Settings.create().strength(3f)
                                    .requiresTool().sounds(BlockSoundGroup.STONE)) ) );
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerAdvancedBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    getSettings("deepslate_pink_garnet_ore",
                            AbstractBlock.Settings.create().strength(4f)
                                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)) ) );

    public static final Block MAGIC_BLOCK = registerAdvancedBlock("magic_block",
            new MagicBlock(
                    getSettings("magic_block",
                            AbstractBlock.Settings.create().strength(1f)
                                    .requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)) ) );


    public static final Block PINK_GARNET_STAIRS = registerAdvancedBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    getSettings("pink_garnet_stairs",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool()) ) );
    public static final Block PINK_GARNET_SLAB = registerAdvancedBlock("pink_garnet_slab",
            new SlabBlock(
                    getSettings("pink_garnet_slab",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool()) ) );
    public static final Block PINK_GARNET_BUTTON = registerAdvancedBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON,2,
                    getSettings("pink_garnet_button",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool().noCollision()) ) );
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerAdvancedBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    getSettings("pink_garnet_pressure_plate",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool().noCollision()) ) );
    public static final Block PINK_GARNET_FENCE = registerAdvancedBlock("pink_garnet_fence",
            new FenceBlock(
                    getSettings("pink_garnet_fence",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool()) ) );
    public static final Block PINK_GARNET_FENCE_GATE = registerAdvancedBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    getSettings("pink_garnet_fence_gate",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool()) ) );
    public static final Block PINK_GARNET_WALL = registerAdvancedBlock("pink_garnet_wall",
            new WallBlock(
                    getSettings("pink_garnet_wall",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool().nonOpaque()) ) );
    public static final Block PINK_GARNET_DOOR = registerAdvancedBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON,
                    getSettings("pink_garnet_door",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool().nonOpaque()) ) );
    public static final Block PINK_GARNET_TRAPDOOR = registerAdvancedBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    getSettings("pink_garnet_trapdoor",
                            AbstractBlock.Settings.create().strength(2f)
                                    .requiresTool().nonOpaque()) ) );

    public static final Block PINK_GARNET_LAMP = registerAdvancedBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(
                    getSettings("pink_garnet_lamp",
                            AbstractBlock.Settings.create().strength(1f)
                                    .requiresTool()
                                    .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)) ) );


    private static Block registerNormalBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Testingmod.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }


    private static AbstractBlock.Settings getSettings(String name, AbstractBlock.Settings blockSettings){
        return blockSettings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Testingmod.MOD_ID, name)));
    }

    private static Block registerAdvancedBlock(String name, Block block) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Testingmod.MOD_ID, name));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testingmod.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        Testingmod.LOGGER.info("Registering Mod Blocks for " + Testingmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
