package net.elisa.testingmod.item.custom;

import net.elisa.testingmod.block.ModBlocks;
import net.elisa.testingmod.component.ModDataComponentTypes;
import net.elisa.testingmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import javax.swing.*;
import java.util.Map;

public class ChiselItem extends Item {

    public static final Map<Block,Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS
            );

    public ChiselItem(Settings settings) {
        super(settings);

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null,context.getBlockPos(), ModSounds.CHISEL_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES,context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }
}
