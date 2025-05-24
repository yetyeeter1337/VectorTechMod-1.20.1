package net.vector7.vectortechmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vector7.vectortechmod.vectortechmod;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, vectortechmod.MOD_ID);

    public static final RegistryObject<Item> neodymium = ITEMS.register("neodymium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> raw_neodymium = ITEMS.register("raw_neodymium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
