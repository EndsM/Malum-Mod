package com.sammy.malum.visual_effects.networked.totem;

import com.sammy.malum.common.block.curiosities.totem.*;
import com.sammy.malum.visual_effects.*;
import com.sammy.malum.visual_effects.networked.*;
import net.minecraftforge.api.distmarker.*;

import java.util.function.*;

public class TotemPoleActivatedParticleEffect extends ParticleEffectType {

    public TotemPoleActivatedParticleEffect(String id) {
        super(id);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Supplier<ParticleEffectActor> get() {
        return () -> (level, random, positionData, colorData, nbtData) -> {
            if (!(level.getBlockEntity(positionData.getAsBlockPos()) instanceof TotemPoleBlockEntity totemPole)) {
                return;
            }
            TotemParticleEffects.activateTotemPoleParticles(totemPole);
        };
    }
}