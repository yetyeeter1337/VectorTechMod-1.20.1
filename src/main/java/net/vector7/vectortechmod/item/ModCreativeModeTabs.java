package net.vector7.vectortechmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vector7.vectortechmod.block.ModBlocks;
import net.vector7.vectortechmod.vectortechmod;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, vectortechmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VECTORTECH_TAB = CREATIVE_MODE_TABS.register("vectortech_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.neodymium.get()))
                    .title(Component.translatable("creativetab.vectortech_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.neodymium.get());
                        pOutput.accept(ModItems.raw_neodymium.get());
                        pOutput.accept(ModBlocks.neodymium_block.get());
                        pOutput.accept(ModBlocks.raw_neodymium_block.get());
                        pOutput.accept(ModBlocks.neodymium_ore.get());
                        pOutput.accept(ModBlocks.deepslate_neodymium_ore.get());


                    })
                    .build());

    public static void register(IEventBus EventBus){
        CREATIVE_MODE_TABS.register(EventBus);
    }

}
