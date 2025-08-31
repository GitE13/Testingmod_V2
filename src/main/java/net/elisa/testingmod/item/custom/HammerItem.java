package net.elisa.testingmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends Item {
    public HammerItem(Settings settings) {
        super(settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if(blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for (int z = -range; z <= range; z++) {
                            if (blockHit.getSide() == Direction.DOWN) {
                                positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y + range, initalBlockPos.getZ() + z));

                            }
                            else{
                                positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y - range, initalBlockPos.getZ() + z));
                            }
                        }
                    }
                }
            }

            if(blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for (int z = -range; z <= range; z++) {

                            if (initalBlockPos.getY() >= player.getPos().y) {
                                if (blockHit.getSide() == Direction.NORTH) {
                                    positions.add(new BlockPos(initalBlockPos.getX() + x, (int) Math.max(initalBlockPos.getY() + y, Math.floor(player.getPos().y)), initalBlockPos.getZ() + z + range));

                                } else {
                                    positions.add(new BlockPos(initalBlockPos.getX() + x, (int) Math.max(initalBlockPos.getY() + y, Math.floor(player.getPos().y)), initalBlockPos.getZ() + z - range));
                                }
                            }

                            else{
                                if (blockHit.getSide() == Direction.NORTH) {
                                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ() + z + range));

                                } else {
                                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ() + z - range));
                                }
                            }

                        }
                    }
                }
            }

            if(blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for (int z = -range; z <= range; z++) {

                            if (initalBlockPos.getY() >= player.getPos().y) {
                                if (blockHit.getSide() == Direction.EAST) {
                                    positions.add(new BlockPos(initalBlockPos.getX() + z - range, (int) Math.max(initalBlockPos.getY() + y, Math.floor(player.getPos().y)), initalBlockPos.getZ() + x));
                                } else {
                                    positions.add(new BlockPos(initalBlockPos.getX() + z + range, (int) Math.max(initalBlockPos.getY() + y, Math.floor(player.getPos().y)), initalBlockPos.getZ() + x));
                                }
                            }

                            else{
                                if (blockHit.getSide() == Direction.EAST) {
                                    positions.add(new BlockPos(initalBlockPos.getX() + z - range, initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                                } else {
                                    positions.add(new BlockPos(initalBlockPos.getX() + z + range, initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                                }
                            }

                        }
                    }
                }
            }


        }

        return positions;
    }
}
