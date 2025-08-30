package net.elisa.testingmod.item;

import com.google.common.collect.Maps;
import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> PINK_GARNET_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Testingmod.MOD_ID, "pink_garnet"));

    public static final ArmorMaterial PINK_GARNET_ARMOR_MATERIAL = new ArmorMaterial(500, // durability
            createDefenseMap(2, 4, 6, 2, 4), //defence
            20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModTags.Items.PINK_GARNET_REPAIR, PINK_GARNET_KEY);
    //enchantability,   sound for equip,        toughness, knockback resistance

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }


}
