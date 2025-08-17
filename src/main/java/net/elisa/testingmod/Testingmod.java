package net.elisa.testingmod;
import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.item.ModItemGroups;
import net.elisa.testingmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
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
	}
}