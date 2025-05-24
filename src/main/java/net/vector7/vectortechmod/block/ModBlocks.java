package net.vector7.vectortechmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vector7.vectortechmod.item.ModItems;
import net.vector7.vectortechmod.vectortechmod;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, vectortechmod.MOD_ID);


    public static final RegistryObject<Block> neodymium_block = registerBlock("neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> raw_neodymium_block = registerBlock("raw_neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> neodymium_ore = registerBlock("neodymium_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f,3f).requiresCorrectToolForDrops(), UniformInt.of(1,2))
    );

    public static final RegistryObject<Block> deepslate_neodymium_ore = registerBlock("deepslate_neodymium_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .strength(3f,3f).requiresCorrectToolForDrops(), UniformInt.of(1,2)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus EventBus){
        BLOCKS.register(EventBus);
    }

}
