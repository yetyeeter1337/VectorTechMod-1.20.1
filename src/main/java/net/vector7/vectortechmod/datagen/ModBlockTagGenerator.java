package net.vector7.vectortechmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vector7.vectortechmod.block.ModBlocks;
import net.vector7.vectortechmod.vectortechmod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, vectortechmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.deepslate_neodymium_ore.get(),
                ModBlocks.neodymium_ore.get(),
                ModBlocks.neodymium_block.get(),
                ModBlocks.raw_neodymium_block.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.deepslate_neodymium_ore.get(),
                ModBlocks.neodymium_ore.get(),
                ModBlocks.neodymium_block.get(),
                ModBlocks.raw_neodymium_block.get());

    }
}
