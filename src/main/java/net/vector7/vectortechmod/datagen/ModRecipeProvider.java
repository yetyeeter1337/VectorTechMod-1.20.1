package net.vector7.vectortechmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.vector7.vectortechmod.block.ModBlocks;
import net.vector7.vectortechmod.item.ModItems;
import net.vector7.vectortechmod.vectortechmod;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput);
    }

    private static final List<ItemLike> NEODYMIUM_SMELTABLES = List.of(
            ModItems.raw_neodymium.get(),
            ModBlocks.neodymium_ore.get(),
            ModBlocks.deepslate_neodymium_ore.get()
    );

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeOutput) {
        oreBlasting(recipeOutput, NEODYMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.neodymium.get(), 0.25f, 100, "neodymium");
        oreSmelting(recipeOutput, NEODYMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.neodymium.get(), 0.25f, 200, "neodymium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.neodymium_block.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.neodymium.get())
                .unlockedBy(getHasName(ModItems.neodymium.get()),has(ModItems.neodymium.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.neodymium.get(), 9)
                .requires(ModBlocks.neodymium_block.get())
                .unlockedBy(getHasName(ModBlocks.neodymium_block.get()),has(ModBlocks.neodymium_block.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.raw_neodymium_block.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.raw_neodymium.get())
                .unlockedBy(getHasName(ModItems.raw_neodymium.get()),has(ModItems.raw_neodymium.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.raw_neodymium.get(), 9)
                .requires(ModBlocks.raw_neodymium_block.get())
                .unlockedBy(getHasName(ModBlocks.raw_neodymium_block.get()),has(ModBlocks.raw_neodymium_block.get()));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(Consumer<FinishedRecipe> pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, AbstractCookingRecipe pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer
                    ).group(pGroup)
                    .unlockedBy(getHasName(itemlike),
                            has(itemlike)).save(pRecipeOutput, vectortechmod.MOD_ID +  ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
