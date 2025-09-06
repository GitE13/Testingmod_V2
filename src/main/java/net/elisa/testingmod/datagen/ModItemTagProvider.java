package net.elisa.testingmod.datagen;

import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.STICK)
                .add(Items.COAL)
                .add(Items.APPLE)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.RAW_PINK_GARNET);

        valueLookupBuilder(ModTags.Items.PINK_GARNET_REPAIR)
                .add(ModItems.PINK_GARNET);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.PINK_GARNET_AXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_GARNET_SHOVEL);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.PINK_GARNET_PICKAXE);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.PINK_GARNET_SWORD);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.PINK_GARNET_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.PINK_GARNET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_CHESTPLATE);
        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_BOOTS);
        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_HELMET);
        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_LEGGINGS);
        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.WEIRD_BOW);
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.WEIRD_BOW)
                .add(ModItems.CHISEL);
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_HAMMER);

        valueLookupBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUSIC_DISC);

    }

}
