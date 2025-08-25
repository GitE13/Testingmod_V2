package net.elisa.testingmod.item;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet");
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet");
    public static final Item CAULIFLOWER = registerFoodItem("cauliflower",ModFoodComponenets.CAULIFLOWER_FOOD_COMPONENT,
            ModFoodComponenets.CAULIFLOWER_CONSUMABLE_COMPONENT);

    public static final Item CHISEL = registerAdvancedItem("chisel",
            new ChiselItem(getSettings("chisel",
                    new Item.Settings().maxDamage(32).useCooldown(10)) ) );

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes");


    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Testingmod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    private static Item registerFoodItem(String name, FoodComponent foodComponent, ConsumableComponent consumableComponent) {
        Identifier id = Identifier.of(Testingmod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key).food(foodComponent,consumableComponent);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    private static Item registerAdvancedItem(String name, Item item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testingmod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, item);
    }

    private static Item.Settings getSettings(String name, Item.Settings itemSettings){
        return itemSettings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testingmod.MOD_ID, name)));
    }

    public static void registerModItems(){
        Testingmod.LOGGER.info("Registering Mod Items for " + Testingmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
