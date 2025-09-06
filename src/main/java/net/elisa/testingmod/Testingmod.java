package net.elisa.testingmod;
import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.component.ModDataComponentTypes;
import net.elisa.testingmod.item.ModItemGroups;
import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.sound.ModSounds;
import net.elisa.testingmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Testingmod implements ModInitializer {

    public static final String MOD_ID = "testingmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();


        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponentTypes();

        ModSounds.RegisterSounds();

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.STARLIGHT_ASHES, 600);
        });

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.CHISEL)) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("tooltip.testingmod.chisel.shift_down"));
                } else {
                    list.add(Text.translatable("tooltip.testingmod.chisel"));
                }
                if(itemStack.get(ModDataComponentTypes.COORDINATES) != null){
                    list.add(Text.literal("Last block changed at "
                            + itemStack.get(ModDataComponentTypes.COORDINATES)));
                }
            } else if (itemStack.isOf(ModBlocks.MAGIC_BLOCK.asItem())) {
                list.add(Text.translatable("tooltip.testingmod.magic_block"));
            }
        });


        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {

            if (entity instanceof SheepEntity sheepEntity){
                if (player.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.END_ROD && !world.isClient()){
                    player.sendMessage(Text.literal("YOU JUST HIT A SHEEP WITH AN END ROD! YOU SICK FRICK!"),false);
                    player.getEquippedStack(EquipmentSlot.MAINHAND).decrement(1);
                    if (sheepEntity.hasStatusEffect(StatusEffects.POISON)) {
                        int oldDuration = sheepEntity.getStatusEffect(StatusEffects.POISON).getAmplifier();
                        sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, -1, oldDuration+1));
                    }
                    else{
                        sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, -1, 1));
                    }
                }
                return ActionResult.PASS;
            }

            return ActionResult.PASS;
        });
	}
}