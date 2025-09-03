package net.elisa.testingmod.item;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.item.custom.ChiselItem;
import net.elisa.testingmod.item.custom.HammerItem;
import net.elisa.testingmod.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.elisa.testingmod.item.custom.ModArmorItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.ProvidesTrimMaterialComponent;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item PINK_GARNET = registerAdvancedItem("pink_garnet",
            new Item(getSettings("pink_garnet",
                    new Item.Settings().trimMaterial(ModTrimMaterials.PINK_GARNET)) ) ) ;
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet");
    public static final Item CAULIFLOWER = registerFoodItem("cauliflower",ModFoodComponenets.CAULIFLOWER_FOOD_COMPONENT,
            ModFoodComponenets.CAULIFLOWER_CONSUMABLE_COMPONENT);

    public static final Item CHISEL = registerAdvancedItem("chisel",
            new ChiselItem(getSettings("chisel",
                    new Item.Settings().maxDamage(32).useCooldown(10)) ) );

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes");

    public static final Item PINK_GARNET_SWORD = registerAdvancedItem("pink_garnet_sword",
            new Item(getSettings("pink_garnet_sword",
                    new Item.Settings().sword(ModToolMaterials.PINK_GARNET,3,-2.4f)) ) );
    public static final Item PINK_GARNET_PICKAXE = registerAdvancedItem("pink_garnet_pickaxe",
            new Item(getSettings("pink_garnet_pickaxe",
                    new Item.Settings().pickaxe(ModToolMaterials.PINK_GARNET,1,-2.8f)) ) );
    public static final Item PINK_GARNET_SHOVEL = registerAdvancedItem("pink_garnet_shovel",
            new Item(getSettings("pink_garnet_shovel",
                    new Item.Settings().axe(ModToolMaterials.PINK_GARNET,1.5f,-3.0f)) ) );
    public static final Item PINK_GARNET_AXE = registerAdvancedItem("pink_garnet_axe",
            new Item(getSettings("pink_garnet_axe",
                    new Item.Settings().shovel(ModToolMaterials.PINK_GARNET,6,-3.2f)) ) );
    public static final Item PINK_GARNET_HOE = registerAdvancedItem("pink_garnet_hoe",
            new Item(getSettings("pink_garnet_hoe",
                    new Item.Settings().hoe(ModToolMaterials.PINK_GARNET,0,-3.0f)) ) );

    public static final Item PINK_GARNET_HAMMER = registerAdvancedItem("pink_garnet_hammer",
            new HammerItem(getSettings("pink_garnet_hammer",
                    new Item.Settings().pickaxe(ModToolMaterials.PINK_GARNET,7,-3.4f)) ) );

    public static final Item PINK_GARNET_HELMET = registerAdvancedItem("pink_garnet_helmet",
            new ModArmorItem(getSettings("pink_garnet_helmet",
                    new Item.Settings().armor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET)) ) );
    public static final Item PINK_GARNET_CHESTPLATE = registerAdvancedItem("pink_garnet_chestplate",
            new Item(getSettings("pink_garnet_chestplate",
                    new Item.Settings().armor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) ) );
    public static final Item PINK_GARNET_LEGGINGS = registerAdvancedItem("pink_garnet_leggings",
            new Item(getSettings("pink_garnet_leggings",
                    new Item.Settings().armor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) ) );
    public static final Item PINK_GARNET_BOOTS = registerAdvancedItem("pink_garnet_boots",
            new Item(getSettings("pink_garnet_boots",
                    new Item.Settings().armor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS)) ) );

    public static final Item PINK_GARNET_HORSE_ARMOR = registerAdvancedItem("pink_garnet_horse_armor",
            new Item(getSettings("pink_garnet_horse_armor",
                    new Item.Settings().horseArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL).maxCount(1)) ) );

    public static final Item WEIRD_SMITHING_TEMPLATE = registerItem2("weird_armor_trim_smithing_template",
            SmithingTemplateItem::of);

    public static final Item WEIRD_BOW = registerAdvancedItem("weird_bow",
            new BowItem(getSettings("weird_bow",
                    new Item.Settings().maxDamage(500)) ) );

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


    private static Item registerItem2(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Testingmod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Testingmod.MOD_ID, name)))));
    }

    public static void registerModItems(){
        Testingmod.LOGGER.info("Registering Mod Items for " + Testingmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
