package net.vector7.vectortechmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vector7.vectortechmod.block.ModBlocks;
import net.vector7.vectortechmod.vectortechmod;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, vectortechmod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.neodymium_block);
        blockWithItem(ModBlocks.raw_neodymium_block);

        blockWithItem(ModBlocks.neodymium_ore);
        blockWithItem(ModBlocks.deepslate_neodymium_ore);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
