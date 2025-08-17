package net.elisa.testingmod.item;

import net.elisa.testingmod.Testingmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet");
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet");


    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Testingmod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings()
                // If your item is based on a block
                .registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems(){
        Testingmod.LOGGER.info("Registering Mod Items for " + Testingmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
