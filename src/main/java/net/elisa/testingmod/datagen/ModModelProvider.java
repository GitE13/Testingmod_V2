package net.elisa.testingmod.datagen;

import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.block.custom.PinkGarnetLampBlock;
import net.elisa.testingmod.component.ModDataComponentTypes;
import net.elisa.testingmod.item.ModArmorMaterials;
import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pink_Garnet_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        pink_Garnet_Pool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pink_Garnet_Pool.slab(ModBlocks.PINK_GARNET_SLAB);
        pink_Garnet_Pool.button(ModBlocks.PINK_GARNET_BUTTON);
        pink_Garnet_Pool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pink_Garnet_Pool.fence(ModBlocks.PINK_GARNET_FENCE);
        pink_Garnet_Pool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pink_Garnet_Pool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.PINK_GARNET_LAMP)
                .with(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED,
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOnIdentifier)).build()),
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOffIdentifier)).build()))));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEIRD_SMITHING_TEMPLATE, Models.GENERATED);

        Item chisel = ModItems.CHISEL;

        ItemModel.Unbaked unusedChisel = ItemModels.basic(itemModelGenerator.upload(chisel, Models.GENERATED));
        ItemModel.Unbaked usedChisel = ItemModels.basic(itemModelGenerator.registerSubModel(chisel, "_used", Models.GENERATED));

        itemModelGenerator.registerCondition(
                chisel,
                new HasComponentProperty(ModDataComponentTypes.COORDINATES, true),
                usedChisel,
                unusedChisel
        );
    }
}
