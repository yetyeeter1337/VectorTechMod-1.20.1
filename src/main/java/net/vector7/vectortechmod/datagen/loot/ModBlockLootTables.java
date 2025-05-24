package net.vector7.vectortechmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.vector7.vectortechmod.block.ModBlocks;
import net.vector7.vectortechmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.neodymium_block.get());
        this.dropSelf(ModBlocks.raw_neodymium_block.get());

        this.add(ModBlocks.neodymium_ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.neodymium_ore.get(), ModItems.raw_neodymium.get(), 1.0f, 2.0f));
        this.add(ModBlocks.deepslate_neodymium_ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.deepslate_neodymium_ore.get(), ModItems.raw_neodymium.get(), 1.0f, 2.0f));


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item, Float min, Float max) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder)this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().flatMap(RegistryObject::stream)::iterator;
    }
}
