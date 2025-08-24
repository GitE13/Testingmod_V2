package net.elisa.testingmod.datagen;

import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

                offerSmelting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC,
                        ModBlocks.PINK_GARNET_BLOCK, 0.25f, 200, "pink_garnet_block");
                offerBlasting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC,
                        ModBlocks.PINK_GARNET_BLOCK, 0.25f, 100, "pink_garnet_block");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,ModItems.PINK_GARNET,
                        RecipeCategory.DECORATIONS,ModBlocks.PINK_GARNET_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,ModItems.RAW_PINK_GARNET,
                        RecipeCategory.DECORATIONS,ModBlocks.RAW_PINK_GARNET_BLOCK);

                createShaped(RecipeCategory.MISC, ModItems.CHISEL)
                        .pattern(" % ")
                        .pattern(" * ")
                        .pattern(" # ")
                        .input('%', ModBlocks.PINK_GARNET_BLOCK)
                        .input('*', Items.NETHER_STAR)
                        .input('#', Items.STICK)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                net.minecraft.recipe.Ingredient pink_Garnet_Ingredient = Ingredient.ofItem(ModItems.PINK_GARNET);

                createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createSlabRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_SLAB,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createFenceRecipe(ModBlocks.PINK_GARNET_FENCE,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createButtonRecipe(ModBlocks.PINK_GARNET_BUTTON,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createPressurePlateRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_PRESSURE_PLATE,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                getWallRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_WALL,pink_Garnet_Ingredient).criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Testingmod Recipes";
    }
}
