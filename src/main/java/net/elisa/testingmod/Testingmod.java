package net.elisa.testingmod;
import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.component.ModDataComponentTypes;
import net.elisa.testingmod.item.ModItemGroups;
import net.elisa.testingmod.item.ModItems;
import net.elisa.testingmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.FuelRegistry;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testingmod implements ModInitializer {

    public static final String MOD_ID = "testingmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();


        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponentTypes();

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
	}
}