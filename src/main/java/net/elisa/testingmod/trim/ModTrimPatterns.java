package net.elisa.testingmod.trim;

import net.elisa.testingmod.Testingmod;
import net.elisa.testingmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> WEIRD = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(Testingmod.MOD_ID, "weird"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.WEIRD_SMITHING_TEMPLATE, WEIRD);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}