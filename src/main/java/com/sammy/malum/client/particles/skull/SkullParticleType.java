package com.sammy.malum.client.particles.skull;

import com.mojang.serialization.Codec;
import com.sammy.malum.client.particles.spiritflame.SpiritFlameParticle;
import com.sammy.malum.core.init.particles.MalumParticles;
import com.sammy.malum.core.systems.particles.data.MalumParticleData;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.ParticleType;

public class SkullParticleType extends ParticleType<MalumParticleData> {
    public SkullParticleType() {
        super(false, MalumParticleData.DESERIALIZER);
    }
    
    @Override
    public Codec<MalumParticleData> func_230522_e_() {
        return MalumParticleData.codecFor(this);
    }
    
    public static class Factory implements IParticleFactory<MalumParticleData>
    {
        private final IAnimatedSprite sprite;
        
        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }
        
        @Override
        public Particle makeParticle(MalumParticleData data, ClientWorld world, double x, double y, double z, double mx, double my, double mz) {
            return new SkullParticle(world, data, x, y, z, mx, my, mz, sprite);
        }
    }
}