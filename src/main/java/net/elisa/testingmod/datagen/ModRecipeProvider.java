package net.elisa.testingmod.datagen;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.trim.ModTrimPatterns;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.WindChargeItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        List<Character> GENERIC_CHARS = Arrays.asList('a','b','c','d','e','f','g','h','i','j');

        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            private void GenerateRecipe(String NameofRecipe, List<Item> Items, RecipeCategory category, Item output, Item ItemToUnlock){
                int UniqueItems = 0;
                List<Character> UsedCharacters = new ArrayList<>();
                List<Item> UsedItems = new ArrayList<>();
                int CharIndex = 0;
                for (int i = 0; i < 9; i++) {
                    if (Items.get(i) != null)
                        if (!UsedItems.contains(Items.get(i))){
                            UsedItems.add(Items.get(i));
                            UsedCharacters.add(GENERIC_CHARS.get(CharIndex));
                            CharIndex++;
                            UniqueItems++;
                        }
                }
                String PatternString = "";
                for (Item item: Items) {
                    if (item == null){
                        PatternString += " ";
                    }
                    else{
                        PatternString += UsedCharacters.get(UsedItems.indexOf(item));
                    }
                }


                net.minecraft.data.recipe.ShapedRecipeJsonBuilder Recipe = createShaped(category, output)
                        .pattern(PatternString.substring(0,3))
                        .pattern(PatternString.substring(3,6))
                        .pattern(PatternString.substring(6,9));
                for (int i = 0; i < UniqueItems; i++) {
                    Recipe.input(UsedCharacters.get(i),UsedItems.get(i));
                }
                Recipe.criterion(hasItem(ItemToUnlock), conditionsFromItem(ItemToUnlock));
                Recipe.offerTo(exporter, NameofRecipe);

            }
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


                GenerateRecipe("chisel",Arrays.asList(
                        null,ModBlocks.PINK_GARNET_BLOCK.asItem(),null,
                        null,Items.NETHER_STAR,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.CHISEL, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_sword",Arrays.asList(
                        null,ModItems.PINK_GARNET,null,
                        null,ModItems.PINK_GARNET,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_axe",Arrays.asList(
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,null,
                        ModItems.PINK_GARNET,Items.STICK,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_pickaxe",Arrays.asList(
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,ModItems.PINK_GARNET,
                        null,Items.STICK,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_shovel",Arrays.asList(
                        null,ModItems.PINK_GARNET,null,
                        null,Items.STICK,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_hoe",Arrays.asList(
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,null,
                        null,Items.STICK,null,
                        null,Items.STICK,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE, ModItems.PINK_GARNET);

                GenerateRecipe("pink_garnet_hammer",Arrays.asList(
                        ModBlocks.PINK_GARNET_BLOCK.asItem(),ModBlocks.PINK_GARNET_BLOCK.asItem(),ModBlocks.PINK_GARNET_BLOCK.asItem(),
                        null,Items.STICK,null,
                        null,Items.DIAMOND,null),
                        RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER, ModBlocks.PINK_GARNET_BLOCK.asItem());

                GenerateRecipe("pink_garnet_helmet",Arrays.asList(
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET,
                        null,null,null),
                        RecipeCategory.COMBAT, ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_chestplate",Arrays.asList(
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,ModItems.PINK_GARNET),
                        RecipeCategory.COMBAT, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_leggings",Arrays.asList(
                        ModItems.PINK_GARNET,ModItems.PINK_GARNET,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET),
                        RecipeCategory.COMBAT, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET);
                GenerateRecipe("pink_garnet_boots",Arrays.asList(
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET,
                        ModItems.PINK_GARNET,null,ModItems.PINK_GARNET,
                        null,null,null),
                        RecipeCategory.COMBAT, ModItems.PINK_GARNET_BOOTS, ModItems.PINK_GARNET);

                net.minecraft.recipe.Ingredient pink_Garnet_Ingredient = Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK.asItem());
                net.minecraft.recipe.Ingredient pink_Garnet_Ingredient_Item = Ingredient.ofItem(ModItems.PINK_GARNET);


                createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createSlabRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_SLAB,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createFenceRecipe(ModBlocks.PINK_GARNET_FENCE,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createButtonRecipe(ModBlocks.PINK_GARNET_BUTTON,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                createPressurePlateRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_PRESSURE_PLATE,pink_Garnet_Ingredient_Item)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET)).offerTo(exporter);
                createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);
                getWallRecipe(RecipeCategory.MISC,ModBlocks.PINK_GARNET_WALL,pink_Garnet_Ingredient)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK.asItem()), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK.asItem())).offerTo(exporter);

                offerSmithingTrimRecipe(ModItems.WEIRD_SMITHING_TEMPLATE, ModTrimPatterns.WEIRD,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Testingmod.MOD_ID, "weird")));

                offerSmithingTemplateCopyingRecipe(ModItems.WEIRD_SMITHING_TEMPLATE,pink_Garnet_Ingredient);
            }
        };
    }

    @Override
    public String getName() {
        return "Testingmod Recipes";
    }
}
