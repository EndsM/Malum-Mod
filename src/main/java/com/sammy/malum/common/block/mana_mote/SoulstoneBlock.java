package com.sammy.malum.common.block.mana_mote;

import com.sammy.malum.common.item.spirit.SpiritShardItem;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import com.sammy.malum.registry.common.ParticleEffectTypeRegistry;
import com.sammy.malum.registry.common.SoundRegistry;
import com.sammy.malum.visual_effects.networked.data.ColorEffectData;
import com.sammy.malum.visual_effects.networked.data.PositionEffectData;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoulstoneBlock extends Block {
    public SoulstoneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player player, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = player.getItemInHand(pHand);
        if (!(stack.getItem() instanceof SpiritShardItem spiritShardItem)) {
            return super.use(pState, pLevel, pPos, player, pHand, pHit);
        }
        MalumSpiritType spiritType = spiritShardItem.type;
        final SpiritMoteBlock spiritMoteBlock = spiritType.spiritMote.get();
        if (spiritMoteBlock == null) {
            return super.use(pState, pLevel, pPos, player, pHand, pHit);
        }
        BlockState blockstate = spiritMoteBlock.defaultBlockState();
        SoundType soundtype = blockstate.getSoundType(pLevel, pPos, player);
        pLevel.setBlock(pPos, blockstate, 3);
        pLevel.levelEvent(2001, pPos, Block.getId(pState));
        pLevel.levelEvent(2001, pPos, Block.getId(blockstate));
        pLevel.playSound(player, pPos, SoundRegistry.SPIRIT_MOTE_CREATED.get(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, Mth.nextFloat(pLevel.random, 1.1f, 1.4f));
        if (!player.getAbilities().instabuild) {
            stack.shrink(2);
        }
        if (!pLevel.isClientSide) {
            ParticleEffectTypeRegistry.SPIRIT_MOTE_SPARKLES.createPositionedEffect(pLevel, new PositionEffectData(pPos), new ColorEffectData(spiritType));
        }
        return InteractionResult.SUCCESS;
    }
}
