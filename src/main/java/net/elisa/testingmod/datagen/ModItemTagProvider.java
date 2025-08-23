package net.elisa.testingmod.datagen;

import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

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
    }
}
