package net.elisa.testingmod.item;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Testingmod.MOD_ID,"pink_garnet_items"),
            FabricItemGroup.builder()
                    .icon(() ->new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.testingmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                    }).build());

    public static final ItemGroup PINK_GARNET_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Testingmod.MOD_ID,"pink_garnet_blocks"),
            FabricItemGroup.builder()
                    .icon(() ->new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.testingmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

                    }).build());

    public static void registerItemGroups() {
        Testingmod.LOGGER.info("Registering Item Groups for " + Testingmod.MOD_ID);
    }
}
