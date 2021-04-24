package com.sammy.malum.network.packets;

import com.sammy.malum.core.init.particles.MalumParticles;
import com.sammy.malum.core.systems.particles.ParticleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.awt.*;
import java.util.function.Supplier;

public class TyrvingParticlePacket
{
    double posX;
    double posY;
    double posZ;
    public TyrvingParticlePacket(double posX, double posY, double posZ)
    {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public static TyrvingParticlePacket decode(PacketBuffer buf)
    {
        double posX = buf.readDouble();
        double posY = buf.readDouble();
        double posZ = buf.readDouble();
        return new TyrvingParticlePacket(posX,posY,posZ);
    }
    
    public void encode(PacketBuffer buf)
    {
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
    }
    
    public void whenThisPacketIsReceived(Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> {
            World world = Minecraft.getInstance().world;
                Color color1 = new Color(158, 7, 219);
                Color color2 = new Color(56, 20, 95);
                ParticleManager.create(MalumParticles.WISP_PARTICLE)
                        .setAlpha(0.1f, 0f)
                        .setLifetime(10)
                        .setSpin(0.4f)
                        .setScale(0.4f, 0)
                        .setColor(color1, color1)
                        .enableNoClip()
                        .randomOffset(0.2f, 0.2f)
                        .randomVelocity(0.01f, 0.01f)
                        .repeat(world, posX, posY, posZ, 12);

                ParticleManager.create(MalumParticles.SMOKE_PARTICLE)
                        .setAlpha(0.04f, 0f)
                        .setLifetime(40)
                        .setSpin(0.1f)
                        .setScale(0.6f, 0)
                        .setColor(color1, color2)
                        .randomOffset(0.4f)
                        .enableNoClip()
                        .randomVelocity(0.025f, 0.025f)
                        .repeat(world, posX, posY, posZ, 20);

        });
        context.get().setPacketHandled(true);
    }
}