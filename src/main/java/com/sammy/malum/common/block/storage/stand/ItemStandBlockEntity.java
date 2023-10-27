package com.sammy.malum.common.block.storage.stand;

import com.sammy.malum.common.block.curiosities.totem.*;
import com.sammy.malum.common.block.storage.*;
import com.sammy.malum.common.item.spirit.*;
import com.sammy.malum.registry.common.block.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.*;
import team.lodestar.lodestone.helpers.*;


public class ItemStandBlockEntity extends MalumItemHolderBlockEntity {

    public ItemStandBlockEntity(BlockEntityType<? extends ItemStandBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ItemStandBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityRegistry.ITEM_STAND.get(), pos, state);
    }

    @Override
    public Vec3 getItemOffset(float partialTicks) {
        Direction direction = getBlockState().getValue(BlockStateProperties.FACING);
        float gameTime = level.getGameTime() + partialTicks;
        float xOffset = direction.getStepX() * 0.25f;
        float yOffset = direction.getStepY() * 0.1f + (inventory.getStackInSlot(0).getItem() instanceof SpiritShardItem ? (float)Math.sin((gameTime % 360) / 20f) * 0.05f : 0);
        float zOffset = direction.getStepZ() * 0.25f;
        return new Vec3(0.5f - xOffset, 0.5f - yOffset, 0.5f - zOffset);
    }

    @Override
    public void onPlace(LivingEntity placer, ItemStack stack) {
        Direction direction = getBlockState().getValue(BlockStateProperties.FACING);
        BlockPos totemPolePos = getBlockPos().relative(direction.getOpposite());
        if (level.getBlockEntity(totemPolePos) instanceof TotemPoleBlockEntity totemPole) {
            TotemBaseBlockEntity totemBase = totemPole.totemBase;
            if (totemBase != null) {
                totemBase.addFilter(this);
                BlockHelper.updateState(level, totemBase.getBlockPos());
                BlockHelper.updateState(level, totemPole.getBlockPos());
            }
        }
    }
}